import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.AbstractCellEditor;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.CellEditor;
import javax.swing.CellRendererPane;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultDesktopManager;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.DesktopManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.AWTEvent;
import java.awt.AWTEventMulticaster;
import java.awt.AWTException;
import java.awt.AWTPermission;
import java.awt.ActiveEvent;
import java.awt.Adjustable;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.BufferCapabilities;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Composite;
import java.awt.CompositeContext;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.JobAttributes;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.List;
import java.awt.MediaTracker;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuComponent;
import java.awt.MenuContainer;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.PopupMenu;
import java.awt.PrintGraphics;
import java.awt.PrintJob;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.ScrollPane;
import java.awt.ScrollPaneAdjustable;
import java.awt.Scrollbar;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.SystemColor;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.InputEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

public class TicTacSchach {
    //Startbildschirm
    private JFrame fenster;
    private ImageIcon startbildIcon;
    private JLabel label;
    private Image startbild;
    private JButton startknopf;
    
    //Spielvariablen
    private JButton[][] spielfeld;
    private String[][] board; //speichert Position der Spielfiguren
    private boolean weißAmZug;
    private JLabel statusLabel;
    private JLabel weißScoreLabel;
    private JLabel schwarzScoreLabel;
    private String ausgewählteFigur; //Auswahl Spielfigur
    private int ausgewählteReihe = -1;
    private int ausgewählteSpalte = -1;
    private String spielModus = "CLASSIC"; // CLASSIC vs HARDCORE
    private int spielfeldgröße; // 3x3 vs 4x4
    
    //Figurenzähler
    private int weißTurm = 2;
    private int weißLäufer = 2;
    private int weißSpringer = 2;
    private int schwarzTurm = 2;
    private int schwarzLäufer = 2;
    private int schwarzSpringer = 2;
    
    //Score
    private int weißScore = 0;
    private int schwarzScore = 0;
    
    //FigurenButtons
    private JButton weißTurmButton, weißLäuferButton, weißSpringerButton;
    private JButton schwarzTurmButton, schwarzLäuferButton, schwarzSpringerButton;
    
    public TicTacSchach() {
        //Fenster erstellen
        fenster = new JFrame ("TicTacSchach");
        fenster.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        fenster.setSize (1200, 700);
        fenster.setLocationRelativeTo (null);
        
        // Startbild
        startbildIcon = new ImageIcon ("tictacSchachStartbild v3.jpg");
        startbild = startbildIcon.getImage();
        
        // Label 
        label = new JLabel();
        label.setHorizontalAlignment (JLabel.CENTER);
        label.setLayout (null);
        
        //Startknopf erstellen
        startknopf = new JButton ("Start");
        startknopf.setBounds (500, 650, 200, 50);
        startknopf.setFocusPainted (false);
        startknopf.setBackground (Color.WHITE);
        startknopf.setFont (new Font("Times New Roman", Font.BOLD, 32));
        startknopf.setForeground (Color.BLACK);
        startknopf.setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startknopf.addActionListener (e -> zeigeModusauswahl());
        
        label.add (startknopf);
        fenster.add (label);
        
        fenster.addComponentListener (new ComponentAdapter() {
            public void componentResized (ComponentEvent e) {
                skaliereBild();
            }
        });
        skaliereBild();

        fenster.setVisible (true);

    }
    
    //Bild skalieren
    private void skaliereBild() {
        int labelWidth = fenster.getContentPane().getWidth();
        int labelHeight = fenster.getContentPane().getHeight();
        
        if (labelWidth > 0 && labelHeight > 0) {
            Image skaliert = startbild.getScaledInstance (labelWidth, labelHeight, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(skaliert));
  
            int StartknopfBreite = 200;
            int StartknopfHoehe = 50;
            int StartknopfX = (labelWidth - StartknopfBreite) / 2;
            int StartknopfY = labelHeight - 100;
            
            startknopf.setBounds (StartknopfX, StartknopfY, StartknopfBreite, StartknopfHoehe);
        }
    }
    
    private void zeigeModusauswahl() {
        fenster.getContentPane().removeAll();
        
        // Hauptpanel
        JPanel hauptPanel = new JPanel (new BorderLayout(20, 20));
        hauptPanel.setBackground (new Color(222, 184, 135));
        hauptPanel.setBorder (BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        // Titel
        JLabel titelLabel = new JLabel ("Wähle einen Spielmodus");
        titelLabel.setFont (new Font("Times New Roman", Font.BOLD, 50));
        titelLabel.setHorizontalAlignment (JLabel.CENTER);
        titelLabel.setForeground (Color.WHITE);
        hauptPanel.add (titelLabel, BorderLayout.NORTH);
        
        //ButtonPanel mit den 6 Buttons
        JPanel buttonPanel = new JPanel (new GridLayout(3, 2, 20, 20));
        buttonPanel.setBackground (new Color(222, 184, 135));
        buttonPanel.setBorder (BorderFactory.createEmptyBorder(30, 80, 30, 80));
        
        //3x3 CLASSIC Button
        JButton classic3x3Button = new JButton ("<html><center>3x3 CLASSIC<br><font size='3'>Geschlagene Figuren kehren zurück</font></center></html>");
        classic3x3Button.setFont (new Font("Times New Roman", Font.BOLD, 30));
        classic3x3Button.setBackground (new Color(101, 67, 33));
        classic3x3Button.setForeground (Color.WHITE);
        classic3x3Button.setBorder (BorderFactory.createLineBorder(new Color(80, 50, 20), 3));
        classic3x3Button.setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        classic3x3Button.setFocusPainted (false);
        classic3x3Button.addActionListener(e -> {
            spielModus = "CLASSIC";
            spielfeldgröße = 3;
            starteSpiel();
        });

        buttonPanel.add(classic3x3Button);
        
        //3x3 HARDCORE Button
        JButton hardcore3x3Button = new JButton("<html><center>3x3 HARDCORE<br><font size='3'>Geschlagene Figuren sind raus</font></center></html>");
        hardcore3x3Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
        hardcore3x3Button.setBackground(new Color(101, 67, 33));
        hardcore3x3Button.setForeground(Color.WHITE);
        hardcore3x3Button.setBorder(BorderFactory.createLineBorder(new Color(80, 50, 20), 3));
        hardcore3x3Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hardcore3x3Button.setFocusPainted(false);
        hardcore3x3Button.addActionListener(e -> {
            spielModus = "HARDCORE";
            spielfeldgröße = 3;
            starteSpiel();
        });

        buttonPanel.add(hardcore3x3Button);
        
        //4x4 CLASSIC Button
        JButton classic4x4Button = new JButton("<html><center>4x4 CLASSIC<br><font size='3'>Geschlagene Figuren kehren zurück</font></center></html>");
        classic4x4Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
        classic4x4Button.setBackground(new Color(101, 67, 33));
        classic4x4Button.setForeground(Color.WHITE);
        classic4x4Button.setBorder(BorderFactory.createLineBorder(new Color(80, 50, 20), 3));
        classic4x4Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        classic4x4Button.setFocusPainted(false);
        classic4x4Button.addActionListener(e -> {
            spielModus = "CLASSIC";
            spielfeldgröße = 4;
            starteSpiel();
        });

        buttonPanel.add(classic4x4Button);
        
        //4x4 HARDCORE Button
        JButton hardcore4x4Button = new JButton("<html><center>4x4 HARDCORE<br><font size='3'>Geschlagene Figuren sind raus</font></center></html>");
        hardcore4x4Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
        hardcore4x4Button.setBackground(new Color(101, 67, 33));
        hardcore4x4Button.setForeground(Color.WHITE);
        hardcore4x4Button.setBorder(BorderFactory.createLineBorder(new Color(80, 50, 20), 3));
        hardcore4x4Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    
        hardcore4x4Button.setFocusPainted(false);
        hardcore4x4Button.addActionListener(e -> {
            spielModus = "HARDCORE";
            spielfeldgröße = 4;
            starteSpiel();
        });

        buttonPanel.add(hardcore4x4Button);
        
        //RegelnButton
        JButton regelnButton = new JButton("REGELN");
        regelnButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        regelnButton.setBackground(new Color(101, 67, 33));
        regelnButton.setForeground(Color.WHITE);
        regelnButton.setBorder(BorderFactory.createLineBorder(new Color(80, 50, 20), 3));
        regelnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regelnButton.setFocusPainted(false);
        regelnButton.addActionListener(e -> zeigeRegeln());

        buttonPanel.add(regelnButton);

        //Zurück (zum Startbildschrim) Button
        JButton zurückButon = new JButton("← Zurück zum Start");
        zurückButon.setFont(new Font("Times New Roman", Font.BOLD, 30));
        zurückButon.setBackground(new Color(101, 67, 33));
        zurückButon.setForeground(Color.WHITE);
        zurückButon.setBorder(BorderFactory.createLineBorder(new Color(80, 50, 20), 3));
        zurückButon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        zurückButon.setFocusPainted(false);
        zurückButon.addActionListener(e -> {
            fenster.getContentPane().removeAll();
            fenster.add(label);
            skaliereBild();
            fenster.revalidate();
            fenster.repaint();
        });

        buttonPanel.add(zurückButon);
        
        hauptPanel.add(buttonPanel, BorderLayout.CENTER);
        
        fenster.add(hauptPanel);
        fenster.revalidate();
        fenster.repaint();
    }
    
    private void zeigeRegeln() {
        JFrame regelnfenster = new JFrame("Spielregeln");
        regelnfenster.setSize(380,510);
        regelnfenster.setLocationRelativeTo(fenster);
        regelnfenster.setResizable(false);
        regelnfenster.setLayout(new BorderLayout());

        JPanel regeln = new JPanel();
        regeln.setBackground(Color.WHITE);

        JLabel regelntextLabel = new JLabel("<html>" +
        "<b>TIC TAC SCHACH - REGELN</b><br><br>" +
        "SPIELFELD:<br>" +
        "3x3 oder 4x4-Felder<br><br>" +
        "FIGUREN:<br>" +
        "Jeder Spieler hat 6 Figuren:<br>" +
        "- 2 Türme ♖ (bewegen sich gerade)<br>" +
        "- 2 Läufer ♗ (bewegen sich diagonal)<br>" +
        "- 2 Springer ♘ (bewegen sich in L-Form)<br><br>" +
        "SPIELABLAUF:<br>" +
        "Spieler wechseln sich ab<br>" +
        "Pro Zug kann man:<br>" +
        "- Eine neue Figur auf ein freies Feld setzen ODER<br>" +
        "- Eine bereits gesetzte Figur bewegen<br><br>" +
        "BEWEGUNGEN:<br>" +
        "Figuren bewegen sich wie im Schach<br>" +
        "Gegnerische Figuren können geschlagen werden<br><br>" +
        "GEWINN:<br>" +
        "Wer zuerst 3 eigene Figuren in einer Reihe hat<br>" +
        "Dies gilt für 3x3 UND 4x4!<br><br>" +
        "SPIELMODI:<br>" +
        "CLASSIC: Geschlagene Figuren kehren zum Besitzer zurück<br>" +
        "HARDCORE: Geschlagene Figuren sind endgültig raus");
        regelntextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        regelntextLabel.setForeground(Color.BLACK);
        regelntextLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        regelntextLabel.setBorder(new EmptyBorder(new Insets(5, 5,5,5)));

        JButton schließregelnButton = new JButton("Schließen");
        schließregelnButton.setForeground(Color.BLACK);
        schließregelnButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        schließregelnButton.setBackground(Color.WHITE);;
        schließregelnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        schließregelnButton.setFocusPainted(false);
    
        schließregelnButton.addActionListener(e -> regelnfenster.dispose());

        regeln.add(regelntextLabel);
        regeln.add(schließregelnButton, BorderLayout.SOUTH);
        regelnfenster.add(regeln);
        regelnfenster.setVisible(true);
    }
    
    private void starteSpiel() {
        fenster.getContentPane().removeAll();
        
        //Spielvariablen 
        weißAmZug = true;
        ausgewählteFigur = null;
        ausgewählteReihe = -1;
        ausgewählteSpalte = -1;
        
        //Hauptpanel
        JPanel hauptPanel = new JPanel(new BorderLayout(10, 10));
        hauptPanel.setBackground(new Color(245, 245, 245));
        hauptPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //Scoreboard + Statusanzeige
        JPanel scoreboard = erstelleScoreboard();
        hauptPanel.add(scoreboard, BorderLayout.NORTH);
        
        //SpielPanel mit Spielbrett + den Figuren
        JPanel spielPanel = new JPanel(new BorderLayout(20, 0));
        spielPanel.setBackground(new Color(245, 245, 245));
        
        //linkes Panel für weiß
        JPanel weißFigurenPanel = erstelleFigurenButtons(true);
        
        //rechtes Panel für schwarz
        JPanel schwarzFigurenPanel = erstelleFigurenButtons(false);
        
        spielPanel.add(weißFigurenPanel, BorderLayout.WEST);
        spielPanel.add(schwarzFigurenPanel, BorderLayout.EAST);
        
        //Spielfeld
        JPanel spielfeldPanel = new JPanel(new GridLayout(spielfeldgröße, spielfeldgröße, 0, 0));
        spielfeldPanel.setBackground(Color.WHITE);
        int feldGröße = (spielfeldgröße == 3) ? 150 : 120; //Größe der Felder
        int gesamtGröße = feldGröße * spielfeldgröße;
        spielfeldPanel.setPreferredSize(new Dimension(gesamtGröße, gesamtGröße));
        spielfeldPanel.setMinimumSize(new Dimension(gesamtGröße, gesamtGröße));

        spielfeld = new JButton[spielfeldgröße][spielfeldgröße];
        board = new String[spielfeldgröße][spielfeldgröße];

        for (int i = 0; i < spielfeldgröße; i++) {
            for (int j = 0; j < spielfeldgröße; j++) {
                spielfeld[i][j] = new JButton("");
                spielfeld[i][j].setFont(new Font("Arial Unicode MS", Font.PLAIN, spielfeldgröße == 3 ? 60 : 40));
                spielfeld[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                
                //Schachbrettmuster
                if ((i + j) % 2 == 0) {
                    spielfeld[i][j].setBackground(new Color(222, 184, 135));
                } else {
                    spielfeld[i][j].setBackground(new Color(101, 67, 33));
                }
        
        spielfeld[i][j].setFocusPainted(false);
        final int reihe = i;
        final int spalte = j;
        spielfeld[i][j].addActionListener(e -> feldGeklickt(reihe, spalte));
        spielfeldPanel.add(spielfeld[i][j]);
    }
}
    //Spielfeld wird zentriert
    JPanel zentriertesspielfeldPanel = new JPanel(new GridBagLayout());
    zentriertesspielfeldPanel.setBackground(new Color(245, 245, 245));

    zentriertesspielfeldPanel.add(spielfeldPanel);
    spielPanel.add(zentriertesspielfeldPanel, BorderLayout.CENTER);
    hauptPanel.add(spielPanel, BorderLayout.CENTER);

    //Buttons werden je nach Anzahl der Spielfiguren aktiviert/deaktiviert
    aktualisiereFigurenButtons();
        
        //Buttons auf der Spielseite
        JPanel spielPanelButtons = new JPanel(new GridLayout(1, 2, 20, 0));
        spielPanelButtons.setBackground(new Color(245, 245, 245));
        
        //Zurückbutton
        JButton zurückButon = new JButton("← Zurück zur Modusauswahl");
        zurückButon.setFont(new Font("Times New Roman", Font.BOLD, 18));
        zurückButon.setForeground(Color.WHITE);
        zurückButon.setBackground(new Color(101, 67, 33));
        zurückButon.setPreferredSize(new Dimension(40, 30));
        zurückButon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        zurückButon.setFocusPainted(false);
        zurückButon.addActionListener(e -> zeigeModusauswahl());
        spielPanelButtons.add(zurückButon);
        
        //Neues SpielButton
        JButton resetButton = new JButton("Neues Spiel");
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(new Color(101, 67, 33));
        resetButton.setPreferredSize(new Dimension(40, 30));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(e -> resetSpiel());
        spielPanelButtons.add(resetButton);
        
        hauptPanel.add(spielPanelButtons, BorderLayout.SOUTH);
        
        fenster.add(hauptPanel);
        fenster.revalidate();
        fenster.repaint();
    }
    
    private JPanel erstelleScoreboard() {
        JPanel scoreboard = new JPanel(new GridLayout(1, 3, 20, 0));
        scoreboard.setBackground(new Color(245, 245, 245));
        scoreboard.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        
        //Score für Weiß
        weißScoreLabel = new JLabel("WEIß: 0", SwingConstants.CENTER);
        weißScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        weißScoreLabel.setOpaque(true);
        weißScoreLabel.setBackground(Color.WHITE);
        weißScoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        weißScoreLabel.setPreferredSize(new Dimension(180, 60));

        scoreboard.add(weißScoreLabel);
        
        //Statusanzeige
        statusLabel = new JLabel("<html><center>WEiß AM ZUG<br><font size='3'>" + spielfeldgröße + "x" + spielfeldgröße + " " + spielModus + 
                                 "</font></center></html>", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(new Color(255, 255, 200));
        statusLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
        statusLabel.setPreferredSize(new Dimension(300, 60));

        scoreboard.add(statusLabel);
        
        //Score für Schwarz
        schwarzScoreLabel = new JLabel("SCHWARZ: 0", SwingConstants.CENTER);
        schwarzScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        schwarzScoreLabel.setOpaque(true);
        schwarzScoreLabel.setBackground(Color.LIGHT_GRAY);
        schwarzScoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        schwarzScoreLabel.setPreferredSize(new Dimension(180, 60));
        
        scoreboard.add(schwarzScoreLabel);
        
        return scoreboard;
    }
    
    //FigurenButtonPanel für Weiß & Scgwarz
    private JPanel erstelleFigurenButtons(boolean istweiß) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(istweiß ? new Color(101, 67, 33) : new  Color(101, 67, 33), 5),
            istweiß ? " WEIß " : " SCHWARZ ",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Times New Roman", Font.BOLD, 15)));
        
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        if (istweiß) {
        //FigurenButtons für Wei?
        weißTurmButton = new JButton("♖");
        weißTurmButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
        weißTurmButton.setBackground(Color.WHITE);
        weißTurmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        weißTurmButton.setPreferredSize(new Dimension(100, 100));
        weißTurmButton.setMaximumSize(new Dimension(100, 100));
        weißTurmButton.setFocusPainted(false);
        weißTurmButton.setFocusable(false);
        weißTurmButton.addActionListener(e -> FigurAusgewählt("TURM"));

        panel.add(weißTurmButton);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
            
        weißLäuferButton = new JButton("♗");
        weißLäuferButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
        weißLäuferButton.setBackground(Color.WHITE);
        weißLäuferButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        weißLäuferButton.setPreferredSize(new Dimension(100, 100));
        weißLäuferButton.setMaximumSize(new Dimension(100, 100));
        weißLäuferButton.setFocusPainted(false);
        weißLäuferButton.setFocusable(false);
        weißLäuferButton.addActionListener(e -> FigurAusgewählt("LÄUFER"));

        panel.add(weißLäuferButton);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
            
        weißSpringerButton = new JButton("♘");
        weißSpringerButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
        weißSpringerButton.setBackground(Color.WHITE);
        weißSpringerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        weißSpringerButton.setPreferredSize(new Dimension(100, 100));
        weißSpringerButton.setMaximumSize(new Dimension(100, 100));
        weißSpringerButton.setFocusPainted(false);
        weißSpringerButton.setFocusable(false);
        weißSpringerButton.addActionListener(e -> FigurAusgewählt("SPRINGER"));

        panel.add(weißSpringerButton);
        } else {
        //FigurenButtons für Schwarz
        schwarzTurmButton = new JButton("♜");
        schwarzTurmButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
        schwarzTurmButton.setBackground(Color.WHITE);
        schwarzTurmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        schwarzTurmButton.setPreferredSize(new Dimension(100, 100));
        schwarzTurmButton.setMaximumSize(new Dimension(100, 100));
        schwarzTurmButton.setFocusPainted(false);
        schwarzTurmButton.setFocusable(false);
        schwarzTurmButton.addActionListener(e -> FigurAusgewählt("TURM"));

        panel.add(schwarzTurmButton);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
            
        schwarzLäuferButton = new JButton("♝");
        schwarzLäuferButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
        schwarzLäuferButton.setBackground(Color.WHITE);
        schwarzLäuferButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        schwarzLäuferButton.setPreferredSize(new Dimension(100, 100));
        schwarzLäuferButton.setMaximumSize(new Dimension(100, 100));
        schwarzLäuferButton.setFocusPainted(false);
        schwarzLäuferButton.setFocusable(false);
        schwarzLäuferButton.addActionListener(e -> FigurAusgewählt("LÄUFER"));

        panel.add(schwarzLäuferButton);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
            
        schwarzSpringerButton = new JButton("♞");
        schwarzSpringerButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
        schwarzSpringerButton.setBackground(Color.WHITE);
        schwarzSpringerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        schwarzSpringerButton.setPreferredSize(new Dimension(100, 100));
        schwarzSpringerButton.setMaximumSize(new Dimension(100, 100));
        schwarzSpringerButton.setFocusPainted(false);
        schwarzSpringerButton.setFocusable(false);
        schwarzSpringerButton.addActionListener(e -> FigurAusgewählt("SPRINGER"));

        panel.add(schwarzSpringerButton);
        }
        
        return panel;
    }
    
    private void FigurAusgewählt(String typ) {
        //
        ausgewählteFigur = typ;
        ausgewählteReihe = -1;
        ausgewählteSpalte = -1;
        
        //Reset Buttons für Weiß & Schwarz
        weißTurmButton.setBackground(null);
        weißLäuferButton.setBackground(null);
        weißSpringerButton.setBackground(null);
        schwarzTurmButton.setBackground(null);
        schwarzLäuferButton.setBackground(null);
        schwarzSpringerButton.setBackground(null);
        
        //Ausgewählten Button markieren
        if (weißAmZug) {
            if (typ.equals("TURM")) weißTurmButton.setBackground(new Color(222, 184, 135));
            else if (typ.equals("LÄUFER")) weißLäuferButton.setBackground(new Color(222, 184, 135));
            else if (typ.equals("SPRINGER")) weißSpringerButton.setBackground(new Color(222, 184, 135));
        } else {
            if (typ.equals("TURM")) schwarzTurmButton.setBackground(new Color(222, 184, 135));
            else if (typ.equals("LÄUFER")) schwarzLäuferButton.setBackground(new Color(222, 184, 135));
            else if (typ.equals("SPRINGER")) schwarzSpringerButton.setBackground(new Color(222, 184, 135));
        }
        
        statusLabel.setText(typ + " ausgewählt");
    }
    
    private void feldGeklickt(int reihe, int spalte) {
        //Fall 1: Eigene Figur zum Bewegen auswählen
        if (board[reihe][spalte] != null && 
            ((weißAmZug && board[reihe][spalte].startsWith("W_")) ||
             (!weißAmZug && board[reihe][spalte].startsWith("B_")))) {
            
            ausgewählteReihe = reihe;
            ausgewählteSpalte = spalte;
            ausgewählteFigur = null;
            
            //Färbung der Buttons zurücksetzen
            weißTurmButton.setBackground(null);
            weißLäuferButton.setBackground(null);
            weißSpringerButton.setBackground(null);
            schwarzTurmButton.setBackground(null);
            schwarzLäuferButton.setBackground(null);
            schwarzSpringerButton.setBackground(null);
            
            //Markiere ausgewähltes Feld
            ResetAlleFelder();
            spielfeld[reihe][spalte].setBackground(Color.CYAN);
            
            statusLabel.setText(" Figur ausgewählt");
            return;
        }
        
        //Fall 2: Neue Figur setzen
        if (ausgewählteFigur != null && board[reihe][spalte] == null) {
            if (kannFigurSetzen(ausgewählteFigur)) {
                String figur = (weißAmZug ? "W_" : "B_") + ausgewählteFigur;
                board[reihe][spalte] = figur;
                spielfeld[reihe][spalte].setText(getFigurSymbol(figur));
                reduziereFigur(ausgewählteFigur);
                
                if (prüfeGewinn()) {
                    return;
                }

                if (prüfeKeineFigurenMehr()) {
                    return;
                }
                
                if (prüfeUnentschieden()) {
                    return;
                }
                
                wechsleSpieler();
                ausgewählteFigur = null;
                weißTurmButton.setBackground(null);
                weißLäuferButton.setBackground(null);
                weißSpringerButton.setBackground(null);
                schwarzTurmButton.setBackground(null);
                schwarzLäuferButton.setBackground(null);
                schwarzSpringerButton.setBackground(null);
            }
        }
        
        // Fall 3: Ausgewählte Figur bewegen
        else if (ausgewählteReihe != -1 && ausgewählteSpalte != -1) {
            if (istZugGueltig(ausgewählteReihe, ausgewählteSpalte, reihe, spalte)) {
                // Bewege Figur
                String figur = board[ausgewählteReihe][ausgewählteSpalte];
                
                // Falls gegnerische Figur geschlagen wird
                if (board[reihe][spalte] != null) {
                    String geschlageneFigur = board[reihe][spalte];
                    erhoeheGeschlageneFigur(geschlageneFigur);
                }
                
                board[reihe][spalte] = figur;
                board[ausgewählteReihe][ausgewählteSpalte] = null;
                
                spielfeld[reihe][spalte].setText(getFigurSymbol(figur));
                spielfeld[ausgewählteReihe][ausgewählteSpalte].setText("");
                
                ResetAlleFelder();
                
                if (prüfeGewinn()) {
                    return;
                }

                if (prüfeKeineFigurenMehr()) {
                    return;
                }
                
                if (prüfeUnentschieden()) {
                    return;
                }
                
                wechsleSpieler();
                ausgewählteReihe = -1;
                ausgewählteSpalte = -1;
            } else {
                statusLabel.setText((weißAmZug ? "WEIß" : "SCHWARZ") + " - Ungültiger Zug!");
            }
        }
    }
    
    private boolean kannFigurSetzen(String typ) {
        if (weißAmZug) {
            if (typ.equals("TURM") && weißTurm > 0) return true;
            if (typ.equals("LÄUFER") && weißLäufer > 0) return true;
            if (typ.equals("SPRINGER") && weißSpringer > 0) return true;
        } else {
            if (typ.equals("TURM") && schwarzTurm > 0) return true;
            if (typ.equals("LÄUFER") && schwarzLäufer > 0) return true;
            if (typ.equals("SPRINGER") && schwarzSpringer > 0) return true;
        }
        statusLabel.setText("Keine " + typ + " mehr verfügbar!");
        return false;
    }
    
    private void reduziereFigur(String typ) {
        if (weißAmZug) {
            if (typ.equals("TURM")) weißTurm--;
            else if (typ.equals("LÄUFER")) weißLäufer--;
            else if (typ.equals("SPRINGER")) weißSpringer--;
        } else {
            if (typ.equals("TURM")) schwarzTurm--;
            else if (typ.equals("LÄUFER")) schwarzLäufer--;
            else if (typ.equals("SPRINGER")) schwarzSpringer--;
        }
        aktualisiereFigurenButtons();
    }
    
    private void erhoeheGeschlageneFigur(String figur) {
        // Im HARDCORE Modus kommen Figuren NICHT zurück
        if (spielModus.equals("HARDCORE")) {
            return;
        }
        
        // Im CLASSIC Modus kommen Figuren zurück
        String typ = figur.substring(2); // Entferne "W_" oder "B_"
        
        if (figur.startsWith("W_")) {
            if (typ.equals("TURM")) weißTurm++;
            else if (typ.equals("LÄUFER")) weißLäufer++;
            else if (typ.equals("SPRINGER")) weißSpringer++;
        } else {
            if (typ.equals("TURM")) schwarzTurm++;
            else if (typ.equals("LÄUFER")) schwarzLäufer++;
            else if (typ.equals("SPRINGER")) schwarzSpringer++;
        }
        aktualisiereFigurenButtons();
    }
    
    private void aktualisiereFigurenButtons() {
        // Weiße Buttons - Symbol mit Anzahl
        weißTurmButton.setText("<html><center>♖<br><font size='3'>" + weißTurm + "</font></center></html>");
        weißLäuferButton.setText("<html><center>♗<br><font size='3'>" + weißLäufer + "</font></center></html>");
        weißSpringerButton.setText("<html><center>♘<br><font size='3'>" + weißSpringer + "</font></center></html>");
        
        weißTurmButton.setEnabled(weißAmZug && weißTurm > 0);
        weißLäuferButton.setEnabled(weißAmZug && weißLäufer > 0);
        weißSpringerButton.setEnabled(weißAmZug && weißSpringer > 0);
        
        // Schwarze Buttons - Symbol mit Anzahl
        schwarzTurmButton.setText("<html><center>♜<br><font size='3'>" + schwarzTurm + "</font></center></html>");
        schwarzLäuferButton.setText("<html><center>♝<br><font size='3'>" + schwarzLäufer + "</font></center></html>");
        schwarzSpringerButton.setText("<html><center>♞<br><font size='3'>" + schwarzSpringer + "</font></center></html>");
        
        schwarzTurmButton.setEnabled(!weißAmZug && schwarzTurm > 0);
        schwarzLäuferButton.setEnabled(!weißAmZug && schwarzLäufer > 0);
        schwarzSpringerButton.setEnabled(!weißAmZug && schwarzSpringer > 0);
    }
    
    private String getFigurSymbol(String figur) {
        if (figur == null) return "";
        
        boolean istweiß = figur.startsWith("W_");
        String typ = figur.substring(2);
        
        if (typ.equals("TURM")) return istweiß ? "♖" : "♜";
        if (typ.equals("LÄUFER")) return istweiß ? "♗" : "♝";
        if (typ.equals("SPRINGER")) return istweiß ? "♘" : "♞";
        
        return "";
    }
    
    private boolean istZugGueltig(int vonReihe, int vonSpalte, int nachReihe, int nachSpalte) {
        // Kann nicht auf eigene Figur ziehen
        if (board[nachReihe][nachSpalte] != null) {
            boolean zielIstweiß = board[nachReihe][nachSpalte].startsWith("W_");
            if (weißAmZug == zielIstweiß) {
                return false;
            }
        }
        
        String figur = board[vonReihe][vonSpalte];
        String typ = figur.substring(2);
        
        int reihenDiff = Math.abs(nachReihe - vonReihe);
        int spaltenDiff = Math.abs(nachSpalte - vonSpalte);
        
        // Turm: Gerade (horizontal oder vertikal)
        if (typ.equals("TURM")) {
            if (vonReihe == nachReihe || vonSpalte == nachSpalte) {
                return istWegFrei(vonReihe, vonSpalte, nachReihe, nachSpalte);
            }
            return false;
        }
        
        // Läufer: Diagonal
        if (typ.equals("LÄUFER")) {
            if (reihenDiff == spaltenDiff) {
                return istWegFrei(vonReihe, vonSpalte, nachReihe, nachSpalte);
            }
            return false;
        }
        
        // Springer: L-Form
        if (typ.equals("SPRINGER")) {
            return (reihenDiff == 2 && spaltenDiff == 1) || (reihenDiff == 1 && spaltenDiff == 2);
        }
        
        return false;
    }
    
    private boolean istWegFrei(int vonReihe, int vonSpalte, int nachReihe, int nachSpalte) {
        int reihenSchritt = Integer.compare(nachReihe, vonReihe);
        int spaltenSchritt = Integer.compare(nachSpalte, vonSpalte);
        
        int aktReihe = vonReihe + reihenSchritt;
        int aktSpalte = vonSpalte + spaltenSchritt;
        
        while (aktReihe != nachReihe || aktSpalte != nachSpalte) {
            if (board[aktReihe][aktSpalte] != null) {
                return false;
            }
            aktReihe += reihenSchritt;
            aktSpalte += spaltenSchritt;
        }
        
        return true;
    }
    
    private boolean prüfeUnentschieden() {
        // Nur im HARDCORE Modus prüfen
        if (!spielModus.equals("HARDCORE")) {
            return false;
        }
        
        // Zähle ALLE Figuren (auf dem Feld + verfügbar)
        int weißAufFeld = 0;
        int schwarzAufFeld = 0;
        
        for (int i = 0; i < spielfeldgröße; i++) {
            for (int j = 0; j < spielfeldgröße; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].startsWith("W_")) {
                        weißAufFeld++;
                    } else {
                        schwarzAufFeld++;
                    }
                }
            }
        }
        
        int weißGesamt = weißAufFeld + weißTurm + weißLäufer + weißSpringer;
        int schwarzGesamt = schwarzAufFeld + schwarzTurm + schwarzLäufer + schwarzSpringer;
        
        // Wenn beide weniger als spielfeldgröße Figuren INSGESAMT haben -> Unentschieden
        // Unentschieden-Fenster erstellen
        if (weißGesamt < spielfeldgröße && schwarzGesamt < spielfeldgröße) {
        JFrame unentschiedenFenster = new JFrame("Unentschieden");
        unentschiedenFenster.setSize(350, 150);
        unentschiedenFenster.setLocationRelativeTo(fenster);
        unentschiedenFenster.setResizable(false);
        unentschiedenFenster.setLayout(new BorderLayout());

        JLabel unentschiedenLabel = new JLabel(
        "<html><center>Unentschieden!<br>Beide Spieler haben weniger als " + spielfeldgröße + " Figuren übrig.</center></html>", SwingConstants.CENTER);
        unentschiedenLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        okButton.setFocusPainted(false);
        okButton.setFocusable(false);
        okButton.addActionListener(e -> unentschiedenFenster.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(okButton);

        unentschiedenFenster.add(unentschiedenLabel, BorderLayout.CENTER);
        unentschiedenFenster.add(buttonPanel, BorderLayout.SOUTH);
        unentschiedenFenster.setVisible(true);
    
        resetSpielfeld();
        return true;
    }
        
        return false;
    }
    
    private boolean prüfeGewinn() {
        String gewinner = null;
        
        // Immer 3 in einer Reihe zum Gewinnen (auch bei 4x4)
        int gewinnLaenge = 3;
        
        // Horizontale Prüfung - prüfe alle möglichen 3er-Kombinationen
        for (int i = 0; i < spielfeldgröße; i++) {
            for (int startJ = 0; startJ <= spielfeldgröße - gewinnLaenge; startJ++) {
                if (board[i][startJ] == null) continue;
                boolean erstesIstweiß = board[i][startJ].startsWith("W_");
                boolean alleGleich = true;
                
                for (int j = startJ + 1; j < startJ + gewinnLaenge; j++) {
                    if (board[i][j] == null || board[i][j].startsWith("W_") != erstesIstweiß) {
                        alleGleich = false;
                        break;
                    }
                }
                
                if (alleGleich) {
                    gewinner = erstesIstweiß ? "WEIß" : "SCHWARZ";
                    break;
                }
            }
            if (gewinner != null) break;
        }
        
        // Vertikale Prüfung - prüfe alle möglichen 3er-Kombinationen
        if (gewinner == null) {
            for (int j = 0; j < spielfeldgröße; j++) {
                for (int startI = 0; startI <= spielfeldgröße - gewinnLaenge; startI++) {
                    if (board[startI][j] == null) continue;
                    boolean erstesIstweiß = board[startI][j].startsWith("W_");
                    boolean alleGleich = true;
                    
                    for (int i = startI + 1; i < startI + gewinnLaenge; i++) {
                        if (board[i][j] == null || board[i][j].startsWith("W_") != erstesIstweiß) {
                            alleGleich = false;
                            break;
                        }
                    }
                    
                    if (alleGleich) {
                        gewinner = erstesIstweiß ? "WEIß" : "SCHWARZ";
                        break;
                    }
                }
                if (gewinner != null) break;
            }
        }
        
        // Diagonale Prüfung (links oben nach rechts unten) - alle möglichen 3er-Kombinationen
        if (gewinner == null) {
            for (int startI = 0; startI <= spielfeldgröße - gewinnLaenge; startI++) {
                for (int startJ = 0; startJ <= spielfeldgröße - gewinnLaenge; startJ++) {
                    if (board[startI][startJ] == null) continue;
                    boolean erstesIstweiß = board[startI][startJ].startsWith("W_");
                    boolean alleGleich = true;
                    
                    for (int k = 1; k < gewinnLaenge; k++) {
                        if (board[startI + k][startJ + k] == null || 
                            board[startI + k][startJ + k].startsWith("W_") != erstesIstweiß) {
                            alleGleich = false;
                            break;
                        }
                    }
                    
                    if (alleGleich) {
                        gewinner = erstesIstweiß ? "WEIß" : "SCHWARZ";
                        break;
                    }
                }
                if (gewinner != null) break;
            }
        }
        
        // Diagonale Prüfung (rechts oben nach links unten) - alle möglichen 3er-Kombinationen
        if (gewinner == null) {
            for (int startI = 0; startI <= spielfeldgröße - gewinnLaenge; startI++) {
                for (int startJ = gewinnLaenge - 1; startJ < spielfeldgröße; startJ++) {
                    if (board[startI][startJ] == null) continue;
                    boolean erstesIstweiß = board[startI][startJ].startsWith("W_");
                    boolean alleGleich = true;
                    
                    for (int k = 1; k < gewinnLaenge; k++) {
                        if (board[startI + k][startJ - k] == null || 
                            board[startI + k][startJ - k].startsWith("W_") != erstesIstweiß) {
                            alleGleich = false;
                            break;
                        }
                    }
                    
                    if (alleGleich) {
                        gewinner = erstesIstweiß ? "WEIß" : "SCHWARZ";
                        break;
                    }
                }
                if (gewinner != null) break;
            }
        }
        
        if (gewinner != null) {
            // Score erhöhen
            if (gewinner.equals("WEIß")) {
                weißScore++;
                weißScoreLabel.setText("WEIß: " + weißScore);
            } else {
                schwarzScore++;
                schwarzScoreLabel.setText("SCHWARZ: " + schwarzScore);
            }
            
            if (gewinner != null) {
    // Score erhöhen
    if (gewinner.equals("WEIß")) {
        weißScore++;
        weißScoreLabel.setText("WEIß: " + weißScore);
    } else {
        schwarzScore++;
        schwarzScoreLabel.setText("SCHWARZ: " + schwarzScore);
    }
    
        // Gewinner-Fenster erstellen
        JFrame gewinnerFenster = new JFrame("Gewinner!");
        gewinnerFenster.setSize(350, 150);
        gewinnerFenster.setLocationRelativeTo(fenster);
        gewinnerFenster.setResizable(false);
        gewinnerFenster.setLayout(new BorderLayout());

        JLabel gewinnerLabel = new JLabel("<html><center>" + gewinner + " hat gewonnen!</center></html>", SwingConstants.CENTER);
        gewinnerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        okButton.setFocusPainted(false);
        okButton.setFocusable(false);
        okButton.addActionListener(e -> gewinnerFenster.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(okButton);

        gewinnerFenster.add(gewinnerLabel, BorderLayout.CENTER);
        gewinnerFenster.add(buttonPanel, BorderLayout.SOUTH);
        gewinnerFenster.setVisible(true);
            
        resetSpielfeld();
        return true;
        }
        }
        
        return false;
    }

    private boolean prüfeKeineFigurenMehr() {
    // Nur im HARDCORE Modus prüfen
    if (!spielModus.equals("HARDCORE")) {
        return false;
    }
    
    // Zähle Figuren auf dem Feld
    int weißAufFeld = 0;
    int schwarzAufFeld = 0;
    
    for (int i = 0; i < spielfeldgröße; i++) {
        for (int j = 0; j < spielfeldgröße; j++) {
            if (board[i][j] != null) {
                if (board[i][j].startsWith("W_")) {
                    weißAufFeld++;
                } else {
                    schwarzAufFeld++;
                }
            }
        }
    }
    
    // Gesamt-Figuren berechnen
    int weißGesamt = weißAufFeld + weißTurm + weißLäufer + weißSpringer;
    int schwarzGesamt = schwarzAufFeld + schwarzTurm + schwarzLäufer + schwarzSpringer;
    
    String gewinner = null;
    
    // Wenn ein Spieler KEINE Figuren mehr hat
    if (weißGesamt == 0 && schwarzGesamt > 0) {
        gewinner = "SCHWARZ";
    } else if (schwarzGesamt == 0 && weißGesamt > 0) {
        gewinner = "WEIß";
    }
    
    if (gewinner != null) {
        // Score erhöhen
        if (gewinner.equals("WEIß")) {
            weißScore++;
            weißScoreLabel.setText("WEIß: " + weißScore);
        } else {
            schwarzScore++;
            schwarzScoreLabel.setText("SCHWARZ: " + schwarzScore);
        }
        
        // Gewinner-Fenster erstellen
        JFrame gewinnerFenster = new JFrame("Gewinner!");
        gewinnerFenster.setSize(350, 150);
        gewinnerFenster.setLocationRelativeTo(fenster);
        gewinnerFenster.setResizable(false);
        gewinnerFenster.setLayout(new BorderLayout());

        JLabel gewinnerLabel = new JLabel(
            "<html><center>" + gewinner + " hat gewonnen!<br>" +
            "Der Gegner hat keine Figuren mehr.</center></html>", 
            SwingConstants.CENTER);
        gewinnerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        okButton.setFocusPainted(false);
        okButton.setFocusable(false);
        okButton.addActionListener(e -> gewinnerFenster.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(okButton);

        gewinnerFenster.add(gewinnerLabel, BorderLayout.CENTER);
        gewinnerFenster.add(buttonPanel, BorderLayout.SOUTH);
        gewinnerFenster.setVisible(true);
        
        resetSpielfeld();
        return true;
    }
    
    return false;
}
    
    private void wechsleSpieler() {
        weißAmZug = !weißAmZug;
        
        // Status Label aktualisieren mit farbiger Hinterlegung
        statusLabel.setText("<html><center>" + (weißAmZug ? "WEIß" : "SCHWARZ") + " AM ZUG<br><font size='3'>" + spielfeldgröße + "x" + spielfeldgröße + " " + spielModus + "</font></center></html>");
        if (weißAmZug) {
            statusLabel.setBackground(new Color(255, 255, 200)); // Helles Gelb
            weißScoreLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 4));
            schwarzScoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        } else {
            statusLabel.setBackground(new Color(200, 200, 200)); // Grau
            schwarzScoreLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 4));
            weißScoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
        
        aktualisiereFigurenButtons();
    }
    
    private void ResetAlleFelder() {
        for (int i = 0; i < spielfeldgröße; i++) {
            for (int j = 0; j < spielfeldgröße; j++) {
                // Schachbrettmuster wiederherstellen
                if ((i + j) % 2 == 0) {
                    spielfeld[i][j].setBackground(new Color(222, 184, 135)); // Hellbraun
                } else {
                    spielfeld[i][j].setBackground(new Color(139, 90, 43)); // Dunkelbraun
                }
            }
        }
    }
    
    private void resetSpielfeld() {
        // Nur Spielfeld leeren (für nächste Runde)
        for (int i = 0; i < spielfeldgröße; i++) {
            for (int j = 0; j < spielfeldgröße; j++) {
                board[i][j] = null;
                spielfeld[i][j].setText("");
                
                // Schachbrettmuster wiederherstellen
                if ((i + j) % 2 == 0) {
                    spielfeld[i][j].setBackground(new Color(222, 184, 135)); // Hellbraun
                } else {
                    spielfeld[i][j].setBackground(new Color(139, 90, 43)); // Dunkelbraun
                }
            }
        }
        
        // Figuren zurücksetzen
        weißTurm = 2;
        weißLäufer = 2;
        weißSpringer = 2;
        schwarzTurm = 2;
        schwarzLäufer = 2;
        schwarzSpringer = 2;
        
        // Spielvariablen zurücksetzen
        weißAmZug = true;
        ausgewählteFigur = null;
        ausgewählteReihe = -1;
        ausgewählteSpalte = -1;
        
        weißTurmButton.setBackground(null);
        weißLäuferButton.setBackground(null);
        weißSpringerButton.setBackground(null);
        schwarzTurmButton.setBackground(null);
        schwarzLäuferButton.setBackground(null);
        schwarzSpringerButton.setBackground(null);
        
        aktualisiereFigurenButtons();
        statusLabel.setText("<html><center>WEIß AM ZUG<br><font size='3'>" + spielfeldgröße + "x" + spielfeldgröße + " " + spielModus + "</font></center></html>");
        statusLabel.setBackground(new Color(255, 255, 200));
        weißScoreLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 4));
        schwarzScoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
    
    private void resetSpiel() {
        // Kompletter Reset inklusive Score
        resetSpielfeld();
        
        // Score zurücksetzen
        weißScore = 0;
        schwarzScore = 0;
        weißScoreLabel.setText("WEIß: 0");
        schwarzScoreLabel.setText("SCHWARZ: 0");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacSchach());
    }
}