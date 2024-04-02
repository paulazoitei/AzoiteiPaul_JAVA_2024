package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clasa ControlPanel este o clasă care definește panoul de control al aplicației.
 */
public class ControlPanel  extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");


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
     * Metoda care afișează un mesaj de informare atunci când butonul Load este apăsat.
     * @param e
     */
    private void loadAction(ActionEvent e) {
        // Handle load button click event
        // You can perform necessary actions here
        JOptionPane.showMessageDialog(frame, "Load button clicked");
    }
/**
 * Metoda care afișează un mesaj de informare atunci când butonul Save este apăsat.
 */
    private void saveAction(ActionEvent e) {
        // Handle save button click event
        // You can perform necessary actions here
        JOptionPane.showMessageDialog(frame, "Save button clicked");
    }


}
