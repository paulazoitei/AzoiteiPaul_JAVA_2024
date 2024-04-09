package org.example;
import javax.swing.*;
import java.awt.*;

/**
 * Clasa ConfigPanel este o clasă care definește panoul de configurare a aplicației.

 */
public class ConfigPanel  extends JPanel{
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerRows;
    JSpinner spinnerCols;
    JButton button;

    /**
     * Constructorul clasei ConfigPanel care primește ca parametru un obiect de tip MainFrame.
     * @param frame
     */
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Metoda care inițializează panoul de configurare.
     */
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        button = new JButton("Apply");
        JButton exportButton = new JButton("Export Image");
        exportButton.addActionListener(e -> frame.canvas.exportBoardAsImage());
        add(exportButton);

        //create spinners for rows and cols, and the button

        button.addActionListener(e -> {
            // Handle button click event
            int rows = (int) spinnerRows.getValue();
            int cols = (int) spinnerCols.getValue();
            frame.canvas.updateGridSize(rows, cols);
            frame.canvas.generateSticks();
            frame.canvas.repaint();
            // Perform necessary actions with the values of rows and cols
        });
        add(label);
        add(spinnerRows);
        add(spinnerCols);
        add(button);
    }

    /**
     * Metoda care returnează numărul de rânduri și coloane selectate de utilizator.
     * @return
     */
    public int getRows() {
        return (int) spinnerRows.getValue();
    }

    /**
     * Metoda care returnează numărul de coloane selectate de utilizator.
     * @return
     */
    public int getCols() {
        return (int) spinnerCols.getValue();
    }
}
