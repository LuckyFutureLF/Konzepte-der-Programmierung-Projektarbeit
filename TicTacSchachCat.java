import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacSchachCat {

    TicTacSchachCat() {
        //Fenster erstellen
        JFrame fenster = new JFrame("Tic-Tac-Schach");
        fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenster.setLocationRelativeTo(null);
        fenster.setResizable(false);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //startButtonPanel
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBackground(new Color(190,190,190));

        //Hintergrundbild
        ImageIcon startBildIcon = new ImageIcon("tictacschachStartbild v1.jpg");
        JLabel startBildJLabel = new JLabel(startBildIcon);

        //startButton erstellen
        JButton startJButton = new JButton();
        startJButton.setFont(new Font("Arial", Font.BOLD, 20));
        startJButton.setForeground(Color.WHITE);
        startJButton.setText("START");
        startJButton.setBounds(0,300,800,600);

        //startButton zum startButtonPanel
        startButtonPanel.add(startJButton);

        //Komponenten zum startPanel
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new BorderLayout());
        startPanel.add(startBildJLabel, BorderLayout.CENTER);
        startPanel.add(startButtonPanel, BorderLayout.SOUTH);

        //Komponenten zum Fenster hinzufügen
        fenster.add(startPanel);
         fenster.setVisible(true);
    }

public static void main(String[]args) {
    new TicTacSchachCat();
}
}