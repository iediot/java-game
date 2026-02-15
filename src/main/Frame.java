package main;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame() {
        super("Name");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        gamePanel.startGameThread();
    }
}
