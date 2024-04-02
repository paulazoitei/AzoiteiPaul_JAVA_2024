package org.example;
import javax.swing.*;
import java.awt.*;

/**
 * Clasa DrawingPanel este o clasă care definește panoul de desenare a aplicației.

 */
public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;

    /**
     * Constructorul clasei DrawingPanel care primește ca parametru un obiect de tip MainFrame.
     * @param frame
     */
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    /**
     * Metoda care inițializează panoul de desenare.
     * @param rows
     * @param cols
     */
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    /**
     * Metoda care desenează grila pe panoul de desenare.
     * @param graphics the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);

    }

    /**
     * Metoda care desenează grila pe panoul de desenare.
     * @param g
     */
    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines TODO
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
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
     * Metoda care actualizează dimensiunile grilei.
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
        repaint(); // Redesenarea panoului după actualizarea dimensiunilor grilei
    }
}
