package org.example;
import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

/**
 * Clasa MainFrame este o clasă care definește fereastra principală a aplicației.
 */
public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    /**
     * Constructorul clasei MainFrame.
     */
    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * Metoda care inițializează fereastra principală a aplicației.
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        canvas = new DrawingPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);


        //invoke the layout manager
        pack();
    }

}
