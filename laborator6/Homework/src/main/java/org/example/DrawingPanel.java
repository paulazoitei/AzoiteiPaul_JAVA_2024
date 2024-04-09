package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clasa DrawingPanel este o clasă care definește panoul de desenare a aplicației.

 */
public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    ArrayList<Stick> sticks;
    private Random random;
    int rows, cols;
    static int canvasWidth = 400;
    static int canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    private Stone lastPlacedStone = null;
    ArrayList<Stone> stones;
    boolean isRedTurn = true;
    private boolean[][] adjacencyMatrix;
    private Stone lastRedStone = null;
    private Stone lastBlueStone = null;
    /**
     * Clasa Stick este o clasă care definește stick-urile jocului.
     */
    public class Stick implements Serializable {
        int x, y;
        int length;
        boolean horizontal;
        Color color;

        public Stick(int x, int y, int length, boolean horizontal, Color color) {
            this.x = x;
            this.y = y;
            this.length = length;
            this.horizontal = horizontal;
            this.color = color;
        }
    }
    /**
     * Clasa Stone este o clasă care definește stone-urile jocului.
     */
    public class Stone implements Serializable{
        int x, y;
        Color color;

        public Stone(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    public ArrayList<Stick> getSticks() {
        return sticks;
    }

    public void setSticks(ArrayList<Stick> sticks) {
        this.sticks = sticks;
    }

    /**
     * Metoda care returnează lista de pietre.
     * @return
     */
    public ArrayList<Stone> getStones() {
        return stones;
    }

    /**
     * Metoda care setează lista de pietre.
     * @param stones
     */
    public void setStones(ArrayList<Stone> stones) {
        this.stones = stones;
    }

    /**
     * Constructorul clasei DrawingPanel care primește ca parametru un obiect de tip MainFrame.
     *
     * @param frame
     */
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }
    /**
     * Metoda care inițializează panoul de desenare.
     *
     * @param rows
     * @param cols
     */
    final void init(int rows, int cols) {
        sticks = new ArrayList<>();
        stones = new ArrayList<>();
        random = new Random();
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        adjacencyMatrix = new boolean[rows * cols][rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            for (int j = 0; j < rows * cols; j++) {
                adjacencyMatrix[i][j] = false;
            }
        }
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        generateSticks();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                placeStone(e.getX(), e.getY());
            }
        });
    }
    /**
     * Metoda care desenează grila pe panoul de desenare.
     *
     * @param graphics the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);

        paintGrid(g);

        drawSticks(g);
        for (Stone stone : stones) {
            g.setColor(stone.color);
            g.fillOval(stone.x - stoneSize / 2, stone.y - stoneSize / 2, stoneSize, stoneSize);
        }

    }
    /**
     * Metoda care generează bețele aleatoriu pe tablă.
     */
    public void generateSticks() {
        sticks.clear();
        int numberOfSticks = (rows + 1) * (cols + 1);

        for (int i = 0; i < numberOfSticks; i++) {

            boolean horizontal = random.nextBoolean();

            int x = random.nextInt(cols - 1);
            int y = random.nextInt(rows - 1);

            if (horizontal && x == cols - 2) {
                sticks.add(new Stick(x, y, 1, true, Color.BLACK));
            } else if (!horizontal && y == rows - 2) {
                sticks.add(new Stick(x, y, 1, false, Color.BLACK));
            } else {
                sticks.add(new Stick(x, y, 1, horizontal, Color.BLACK));
            }
        }
        for (Stick stick : sticks) {
            if (stick.horizontal) {
                int startNode = stick.y * cols + stick.x;
                int endNode = startNode + 1;
                adjacencyMatrix[startNode][endNode] = true;
                adjacencyMatrix[endNode][startNode] = true;
            } else {
                int startNode = stick.y * cols + stick.x;
                int endNode = startNode + cols;
                adjacencyMatrix[startNode][endNode] = true;
                adjacencyMatrix[endNode][startNode] = true;
            }
        }
    }
    /**
     * Metoda care desenează grila pe panoul de desenare.
     *
     * @param g
     */
    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);

        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }

    }
    /**
     * Metoda care actualizează dimensiunea tablei de joc.
     * @param rows
     * @param cols
     */
    public void updateGridSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;


        stones.clear();
        lastPlacedStone = null;
        lastRedStone = null;
        lastBlueStone = null;
        isRedTurn = true;

        generateSticks();

        repaint();
    }
    /**
     * Metoda care desenează bețele pe panoul de desenare.
     * @param g
     */
    private void drawSticks(Graphics2D g) {
        for (Stick stick : sticks) {

            int x1 = padX + stick.x * cellWidth;
            int y1 = padY + stick.y * cellHeight;
            int x2 = stick.horizontal ? x1 + cellWidth : x1;
            int y2 = stick.horizontal ? y1 : y1 + cellHeight;
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(5));
            g.drawLine(x1, y1, x2, y2);
        }
    }
    /**
     * Metoda care plasează o piatră pe tablă la poziția dată.
     * @param x
     * @param y
     */
    private void placeStone(int x, int y) {
        int gridX = (x - padX + cellWidth / 2) / cellWidth;
        int gridY = (y - padY + cellHeight / 2) / cellHeight;

        if (!isValidMove(gridX, gridY)) {
            JOptionPane.showMessageDialog(this, "Invalid move. Try again.", "Invalid Move", JOptionPane.ERROR_MESSAGE);
            return;
        }

        placeNewStone(gridX, gridY);

    }

    /**
     * Metoda care verifică dacă o mutare este validă.
     * @param gridX
     * @param gridY
     * @return
     */
    private boolean isValidMove(int gridX, int gridY) {
    if (!isStickAtPosition(gridX, gridY)) return false;
    if (lastPlacedStone == null) return true;

    Stone lastOpponentStone = isRedTurn ? lastBlueStone : lastRedStone;
    int currentNodeIndex = gridY * cols + gridX;
    int lastStoneNodeIndex = (lastOpponentStone.y - padY) / cellHeight * cols + (lastOpponentStone.x - padX) / cellWidth;
    return adjacencyMatrix[currentNodeIndex][lastStoneNodeIndex] || adjacencyMatrix[lastStoneNodeIndex][currentNodeIndex];
}
    /**
     * Metoda care verifică dacă există un beț la poziția dată.
     * @param gridX
     * @param gridY
     * @return
     */
    private boolean isStickAtPosition(int gridX, int gridY) {
        int currentNodeIndex = gridY * cols + gridX;
        if (gridX < cols - 1) {
            int rightNodeIndex = currentNodeIndex + 1;
            if (adjacencyMatrix[currentNodeIndex][rightNodeIndex]) {
                return true;
            }
        }
        if (gridX > 0) {
            int leftNodeIndex = currentNodeIndex - 1;
            if (adjacencyMatrix[currentNodeIndex][leftNodeIndex]) {
                return true;
            }
        }

        if (gridY > 0) {
            int topNodeIndex = currentNodeIndex - cols;
            if (adjacencyMatrix[currentNodeIndex][topNodeIndex]) {
                return true;
            }
        }

        if (gridY < rows - 1) {
            int bottomNodeIndex = currentNodeIndex + cols;
            if (adjacencyMatrix[currentNodeIndex][bottomNodeIndex]) {
                return true;
            }
        }

        return false;
    }
    /**
     * Metoda care plasează o piatră nouă pe tablă la poziția dată.
     * @param gridX
     * @param gridY
     */
    private void placeNewStone(int gridX, int gridY) {
        int stoneX = padX + gridX * cellWidth;
        int stoneY = padY + gridY * cellHeight;

        Color color = isRedTurn ? Color.RED : Color.BLUE;
        Stone newStone = new Stone(stoneX, stoneY, color);
        stones.add(newStone);

        lastPlacedStone = newStone;
        if (isRedTurn) {
            lastRedStone = newStone;
        } else {
            lastBlueStone = newStone;
        }
        checkWinner();

        isRedTurn = !isRedTurn;

checkWinner();

        repaint();
    }
    /**
     * Metoda care verifică dacă poziția curentă este adiacentă ultimei pietre a adversarului.
     * @param currentNodeIndex
     * @param lastOpponentStone
     * @return
     */
    private boolean isAdjacentToLastOpponentStone(int currentNodeIndex, Stone lastOpponentStone) {
    int lastStoneGridX = (lastOpponentStone.x - padX) / cellWidth;
    int lastStoneGridY = (lastOpponentStone.y - padY) / cellHeight;
    int lastStoneNodeIndex = lastStoneGridY * cols + lastStoneGridX;


    return adjacencyMatrix[currentNodeIndex][lastStoneNodeIndex] || adjacencyMatrix[lastStoneNodeIndex][currentNodeIndex];
}

    /**
     * Metoda care verifică dacă jucătorul curent are mutări valide.
     * @param isRedTurn
     * @return
     */

private boolean hasValidMove(boolean isRedTurn) {
    Stone lastOpponentStone = isRedTurn ? lastBlueStone : lastRedStone;
    if (lastOpponentStone == null) return true;

    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            int currentNodeIndex = row * cols + col;

            if (!isStickAtPosition(col, row)) continue;
            if (isAdjacentToLastOpponentStone(currentNodeIndex, lastOpponentStone)) {
                return true;
            }
        }
    }
    return false;
}
    /**
     * Metoda care verifică dacă jocul s-a terminat și declară un câștigător.
     */

    private void checkWinner()
{

    boolean opponentHasValidMove = hasValidMove(!isRedTurn);

    if (!opponentHasValidMove) {

        String winnerColor = isRedTurn ? "Red" : "Blue";
        JOptionPane.showMessageDialog(this, winnerColor + " player wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);

    }
}

    public void exportBoardAsImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        this.printAll(g2d);
        g2d.dispose();

        try {

            String userHome = System.getProperty("user.home");
            File directory = new File(userHome + File.separator + "GameBoardExports");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File outputFile = new File(directory + File.separator + "game_board.png");

            ImageIO.write(image, "PNG", outputFile);
            JOptionPane.showMessageDialog(this, "Exported game board to " + outputFile.getAbsolutePath(), "Export Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during image export: " + ex.getMessage(), "Export Failed", JOptionPane.ERROR_MESSAGE);
        }
    }


}


