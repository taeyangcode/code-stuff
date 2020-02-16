package com.jetbrains;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing {

    private GetTime dateInfo = new GetTime();
    private Colors colorsInfo = new Colors();

    private JFrame window = new JFrame();

    private JPanel monthPanel = new JPanel();

    private Border blackLine = BorderFactory.createLineBorder(Color.BLACK, 1);

    Swing() {
        frameFormat();
        monthPanelFormat();
        addDaysToMonth();
        visibility();
    }

    void frameFormat() {

        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

    }

    void monthPanelFormat() {

        window.add(monthPanel);
        monthPanel.setLayout(new GridLayout(5, 7));

    }

    void addDaysToMonth() {

        for(int i = 0; i < dateInfo.daysInMonth(); i++) {
            JTextArea day = new JTextArea();
            day.setBorder(blackLine);
            day.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {

                    int key = e.getKeyCode();

                    if(key == KeyEvent.VK_ENTER) {
                            switch (Integer.parseInt(day.getText())) {
                                case 1:
                                    day.setBackground(colorsInfo.oneLove());
                                    break;
                                case 2:
                                    day.setBackground(colorsInfo.twoLove());
                                    break;
                                case 3:
                                    day.setBackground(colorsInfo.threeLove());
                                    break;
                                case 4:
                                    day.setBackground(colorsInfo.fourLove());
                                    break;
                                case 5:
                                    day.setBackground(colorsInfo.fiveLove());
                                    break;
                                case 6:
                                    day.setBackground(colorsInfo.sixLove());
                                    break;
                                case 7:
                                    day.setBackground(colorsInfo.sevenLove());
                                    break;
                                case 8:
                                    day.setBackground(colorsInfo.eightLove());
                                    break;
                                case 9:
                                    day.setBackground(colorsInfo.nineLove());
                                    break;
                                case 10:
                                    day.setBackground(colorsInfo.tenLove());
                                    break;
                            }
                    }
                }
            });
        monthPanel.add(day);
        }

    }

    void visibility() {
        window.setVisible(true);
    }

}
