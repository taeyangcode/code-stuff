package com.jetbrains;

import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Swing {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JFrame windowFrame = new JFrame();

    private JPanel studentInputPanel = new JPanel();
    private JPanel randomStudentPanel = new JPanel();

    private GridBagConstraints gbc = new GridBagConstraints();

    private Font timesLarge = new Font("Times New Roman", Font.PLAIN, 26);
    private Font timesSmall = new Font("Times New Roman", Font.PLAIN, 18);

    private ArrayList<String> nameList = new ArrayList<>();

   void frameSetup() {
       ImageIcon favicon = new ImageIcon("src/com/jetbrains/favicon-32x32.png");
       windowFrame.setIconImage(favicon.getImage());

        int windowX = 1280;
        int windowY = 720;
        int screenPosX = (screenSize.width - windowX) / 2;
        int screenPosY = (screenSize.height - windowY) / 2;

        windowFrame.setSize(windowX, windowY);
        windowFrame.setLocation(screenPosX, screenPosY); //Sets JFrame in the center of user's screen
        windowFrame.setResizable(false);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setTitle("Random Student Picker");
   }

   void inputPanelSetup() {
        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel botPanel = new JPanel();

        JLabel welcomeText = new JLabel();

        JTextArea studentNamesInput = new JTextArea(10, 20);

        JScrollPane nameInputJSP = new JScrollPane(studentNamesInput);

        JButton submitButton = new JButton();

        studentInputPanel.setLayout(new GridLayout(3, 1));

        welcomeText.setFont(timesLarge);
        welcomeText.setText("<html> Please enter all student names separated by comma space. <br> (You will have the ability to adjust their presence in class later) </html>");
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);

        midPanel.setLayout(new GridBagLayout());

        studentNamesInput.setLineWrap(true);
        studentNamesInput.setFont(timesSmall);

        nameInputJSP.setPreferredSize(new Dimension(400, 200));

        botPanel.setLayout(new GridBagLayout());

        submitButton.setPreferredSize(new Dimension(400, 80));
        submitButton.setFont(timesSmall);
        submitButton.setText("Submit");
        submitButton.setFocusable(false);
        submitButton.addActionListener(
               new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       nameList = (ArrayList<String>) Stream.of(studentNamesInput.getText().split(","))
                               .map(String::trim)
                               .collect(toList());

                       studentInputPanel.setVisible(false);

                       windowFrame.add(randomStudentPanel);
                       randomStudentPanel.setVisible(true);
                       randomPanelSetup();
                   }
               }
        );

        studentInputPanel.add(topPanel);
        studentInputPanel.add(midPanel);
        studentInputPanel.add(botPanel);

        topPanel.add(welcomeText);

        midPanel.add(new JLabel());
        midPanel.add(nameInputJSP);
        midPanel.add(new JLabel());

        botPanel.add(new JLabel());
        botPanel.add(submitButton);
        botPanel.add(new JLabel());
   }

   void randomPanelSetup() {
       randomStudentPanel.setLayout(new GridLayout(4, 1));

        JPanel topPanel = new JPanel();
        JPanel checkBoxPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel botPanel = new JPanel();

        JLabel checkBoxInstructions = new JLabel();

        JButton randomPicker = new JButton();

        JLabel randomStudent = new JLabel();

        ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();

        for(int i = 0; i < nameList.size(); i++) {
            JCheckBox checkbox = new JCheckBox(nameList.get(i));
            checkboxes.add(checkbox);
        }

        checkBoxPanel.setLayout(new GridLayout(1, nameList.size()));
        checkBoxPanel.add(new JCheckBox("a"));
        checkBoxPanel.add(new JCheckBox());
        checkBoxPanel.add(new JCheckBox());
        checkBoxPanel.add(new JCheckBox());
        checkBoxPanel.add(new JCheckBox());


        checkBoxInstructions.setFont(timesLarge);
        checkBoxInstructions.setText("<html> For any absent or unwanted student, <br> click the checkbox to the side of their name. </html>");
        checkBoxInstructions.setHorizontalAlignment(SwingConstants.CENTER);

        midPanel.setLayout(new GridBagLayout());

        randomPicker.setPreferredSize(new Dimension(400, 80));
        randomPicker.setFont(timesSmall);
        randomPicker.setText("Random Student");
        randomPicker.setFocusable(false);
        randomPicker.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Random rd = new Random();
                        int index = rd.nextInt(nameList.size());
                        randomStudent.setText(nameList.get(index));
                        nameList.remove(nameList.get(index));
                    }
                }
        );

        randomStudent.setFont(timesLarge);

        randomStudentPanel.add(topPanel);
        randomStudentPanel.add(checkBoxPanel);
        randomStudentPanel.add(midPanel);
        randomStudentPanel.add(botPanel);

        topPanel.add(checkBoxInstructions);

        midPanel.add(new JLabel());
        midPanel.add(randomPicker);
        midPanel.add(new JLabel());

        botPanel.add(randomStudent);
   }

   void visibility() {
       windowFrame.add(studentInputPanel);
       studentInputPanel.setVisible(true);
       windowFrame.setVisible(true);
   }

}
