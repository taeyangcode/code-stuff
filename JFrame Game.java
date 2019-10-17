import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFramePractice {
    JFrame window;
    
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelNumber, weaponLabelName;
    
    JButton startButton, choice1, choice2, choice3, choice4;
    
    JTextArea mainTextArea;
    
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalText = new Font("Times New Roman", Font.PLAIN, 36);
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    
    Container cont;
    
    int playerHP;
    String weapon;
    
    public static void main(String args[]) {
        new JFramePractice();
        
    }
    
    public JFramePractice() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
        window.setVisible(true);
        
        cont = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.white);
        
        titleNameLabel = new JLabel("WELCOME!");
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.white);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(normalText);
        startButton.addActionListener(tsHandler);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        cont.add(titleNamePanel);
        cont.add(startButtonPanel);
        
    }
    
    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.white);
        cont.add(mainTextPanel);
        
        mainTextArea = new JTextArea("QUESTION");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.white);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(normalText);
        mainTextArea.setLineWrap(true);
        
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.white);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        
        cont.add(choiceButtonPanel);
        
        choice1 = new JButton("A");
        choice1.setBackground(Color.white);
        choice1.setForeground(Color.black);
        choice1.setFont(normalText);
        choice2 = new JButton("B");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFont(normalText);
        choice3 = new JButton("C");
        choice3.setBackground(Color.white);
        choice3.setForeground(Color.black);
        choice3.setFont(normalText);
        choice4 = new JButton("D");
        choice4.setBackground(Color.white);
        choice4.setForeground(Color.black);
        choice4.setFont(normalText);
        
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.white);
        playerPanel.setLayout(new GridLayout(1, 4));
        cont.add(playerPanel);
        
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalText);
        hpLabel.setForeground(Color.black);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalText);
        hpLabelNumber.setForeground(Color.black);
        playerPanel.add(hpLabelNumber);
        
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalText);
        weaponLabel.setForeground(Color.black);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalText);
        weaponLabelName.setForeground(Color.black);
        playerPanel.add(weaponLabelName);
        
        playerSetup();
    }
    
    public void playerSetup() {
        playerHP = 15;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
        
        
    }
    
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
            
        }
        
    }
}
