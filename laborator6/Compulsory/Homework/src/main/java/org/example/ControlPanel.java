package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;



/**
 * Clasa ControlPanel este o clasă care definește panoul de control al aplicației.
 */
public class ControlPanel  extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exportButton = new JButton("Export as PNG");


    //create all buttons (Load, Exit, etc.)

    /**
     * Constructorul clasei ControlPanel care primește ca parametru un obiect de tip MainFrame.
     * @param frame
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }




    /**
     * Metoda care inițializează panoul de control.
     */
    private void init() {
        //change the default layout manager (just for fun)

        add(exitBtn);
        add(loadBtn);
        add(saveBtn);


        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadAction); // Implement loadAction method
        saveBtn.addActionListener(this::saveAction);



    }

    /**
     * Metoda care închide fereastra aplicației.
     * @param e
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    /**
     * Metoda care salvează starea jocului într-un fișier serializat.
     * @param e
     */
    private void saveAction(ActionEvent e) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game_state.ser"))) {
            out.writeObject(frame.canvas.sticks);
            out.writeObject(frame.canvas.stones);
            out.writeBoolean(frame.canvas.isRedTurn);
            JOptionPane.showMessageDialog(frame, "Game state saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to save the game state.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metoda care încarcă starea jocului dintr-un fișier serializat.
     * @param e
     */
    private void loadAction(ActionEvent e) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("game_state.ser"))) {
            frame.canvas.setSticks((ArrayList<DrawingPanel.Stick>) in.readObject());
            frame.canvas.setStones((ArrayList<DrawingPanel.Stone>) in.readObject());
            frame.canvas.isRedTurn = in.readBoolean();
            frame.canvas.repaint();
            JOptionPane.showMessageDialog(frame, "Game state loaded successfully!");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to load the game state.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
