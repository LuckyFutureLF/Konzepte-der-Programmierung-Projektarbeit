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

public class TicTacSchachCat {

    //Rounded Corners für Buttons
    class FilledRoundedBorder extends AbstractBorder {
    private final int arc;
    private final Color fill;
    private final Color line;

    FilledRoundedBorder(int arc, Color fill, Color line) {
        this.arc  = arc;
        this.fill = fill;
        this.line = line;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape rr = new java.awt.geom.RoundRectangle2D.Double(
            x, y, w - 1, h - 1, arc, arc
        );

        g2.setColor(fill);
        g2.fill(rr);

        if (line != null) {
            g2.setColor(line);
            g2.draw(rr);
        }

        g2.dispose();
    }
}

    //Bildschirmgröße ermitteln
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int bildschirmBreite =screenSize.width;
    int bildschirmHöhe = screenSize.height;

    private JFrame fenster;

    TicTacSchachCat() {
        //startPanel
            //Hintergrundbild
            ImageIcon startBildIcon = new ImageIcon("tictacschachStartbild v3.jpg");
            Image startBild = startBildIcon.getImage().getScaledInstance(bildschirmBreite, bildschirmHöhe, Image.SCALE_SMOOTH);
            JLabel hintergrundJLabel = new JLabel(new ImageIcon(startBild));
            hintergrundJLabel.setLayout(new GridBagLayout());

            //startButton erstellen
            JButton startJButton = new JButton();
            startJButton.setBorder(new FilledRoundedBorder(25, new Color(150,110,40,200), new Color(140,106,31)));
            startJButton.setBorderPainted(true);
            startJButton.setPreferredSize(new Dimension(220,60));
            startJButton.setContentAreaFilled(false);
            startJButton.setOpaque(false);
            startJButton.setFocusPainted(false);
            startJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            //Text für startButton erstellen
            JLabel startButtonText = new JLabel("START");
            startButtonText.setFont(new Font("Georgia", Font.BOLD, 45));
            startButtonText.setForeground(new Color(255,245,200));

            //Text zum startButton
            startJButton.setLayout(new GridBagLayout());
            startJButton.add(startButtonText, new GridBagConstraints());

            //Button zum Hintergrund
            hintergrundJLabel.add(startJButton, new GridBagConstraints());

        //spielPanel
            //spielPanel erstellen
            JPanel spielPanel = new JPanel();
            spielPanel.setLayout(new BorderLayout());
            spielPanel.setBackground(Color.WHITE);

            //titelLabel
            JLabel titelLabel = new JLabel("TIC-TAC-SCHACH");
            titelLabel.setFont(new Font("Georgia", Font.BOLD, 45));
            titelLabel.setForeground(new Color(150,110,40));
            titelLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //Buttons für den spielPanel
                //ButtonPanel
                JPanel spielButtonPanel = new JPanel ();
                spielButtonPanel.setBackground(Color.WHITE);

                //neuesSpielButton
                JButton neuesSpielButton = new JButton();
                neuesSpielButton.setBorder(new FilledRoundedBorder(25, new Color(150,110,40), Color.WHITE));
                neuesSpielButton.setBorderPainted(true);
                neuesSpielButton.setPreferredSize(new Dimension(200,40));
                neuesSpielButton.setContentAreaFilled(false);
                neuesSpielButton.setOpaque(false);
                neuesSpielButton.setFocusPainted(false);
                neuesSpielButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                //Text für neuesSpielButton
                JLabel neuesSpielButtonText = new JLabel("Neues Spiel");
                neuesSpielButtonText.setFont(new Font("Georgia", Font.BOLD, 20));
                neuesSpielButtonText.setForeground(Color.WHITE);

                //Text zum neuesSpielButton
                neuesSpielButton.setLayout(new GridBagLayout());
                neuesSpielButton.add(neuesSpielButtonText, new GridBagConstraints());

                //Aktion für den neuesSpielButton
                neuesSpielButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        neuesSpiel();
                    }
                });

                //resetButton
                JButton resetSpielButton = new JButton();
                resetSpielButton.setBorder(new FilledRoundedBorder(25, new Color(150,110,40), Color.WHITE));
                resetSpielButton.setPreferredSize(new Dimension(200,40));
                resetSpielButton.setContentAreaFilled(false);
                resetSpielButton.setOpaque(false);
                resetSpielButton.setFocusPainted(false);
                resetSpielButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                //Text für resetSpielButton 
                JLabel resetSpielButtonText = new JLabel("Reset Spiel");
                resetSpielButtonText.setFont(new Font("Georgia", Font.BOLD, 20));
                resetSpielButtonText.setForeground(Color.WHITE);                

                //Text zum resetButton
                resetSpielButton.setLayout(new GridBagLayout());
                resetSpielButton.add(resetSpielButtonText, new GridBagConstraints());

                //Aktion für den resetButton
                resetSpielButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e ) {
                        reset();
                    }
                });

                //Button zum neuesSpielButtonPanel
                spielButtonPanel.add(neuesSpielButton, BorderLayout.WEST);
                spielButtonPanel.add(resetSpielButton, BorderLayout.EAST);

                //Spielbereich
                    JPanel spielbereich = new JPanel();
                    spielbereich.setLayout(new BorderLayout());
                    spielbereich.setBackground(Color.WHITE);

                    //Spielbrett
                    erstelleSpielbrett();
                    erstelleFigurenPanel();
                    
                    spielbereich.add(spieler1Panel, BorderLayout.WEST);
                    spielbereich.add(spieler2Panel, BorderLayout.EAST);
                    spielbereich.add(zentriertesspielBrettPanel, BorderLayout.CENTER);

            //Komponenten zum spielPanel
            spielPanel.setLayout(new BorderLayout());
            spielPanel.add(titelLabel, BorderLayout.NORTH);
            spielPanel.add(spielButtonPanel, BorderLayout.SOUTH); 
            spielPanel.add(spielbereich, BorderLayout.CENTER);   

         //Fenster erstellen
        fenster = new JFrame("Tic-Tac-Schach");
        fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenster.setLocationRelativeTo(null);
        fenster.setResizable(false);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Karten 
        JPanel kartenPanel = new JPanel(new CardLayout());
        kartenPanel.add(hintergrundJLabel, "START");
        kartenPanel.setBackground(Color.BLACK);
        kartenPanel.add(spielPanel, "SPIEL");

        //Aktion für den startButton
        startJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout) kartenPanel.getLayout();
                c2.show(kartenPanel, "SPIEL");
            }
        });

        //Inhalt des JFrame fensters
        fenster.setContentPane(kartenPanel);
        fenster.setVisible(true);
    }

    //Spielbrett
        //Spielbrett + SpielbrettGröße hier (noch) manuell veränderbar
        private int spielbrettGröße = 3;
        private JPanel spielbrettPanel;
        private JButton[] spielfelder;
        private JPanel zentriertesspielBrettPanel;

private void erstelleSpielbrett() {
    spielbrettPanel = new JPanel();
    spielbrettPanel.setLayout(new GridLayout(spielbrettGröße, spielbrettGröße, 0, 0));
    spielbrettPanel.setBackground(Color.WHITE);

    //Array für 3x3, evntl später 4x4 Feld
    spielfelder = new JButton[spielbrettGröße*spielbrettGröße];
    for (int i = 0; i < spielfelder.length; i++) {
        spielfelder[i] = new JButton("");
        spielfelder[i].setFont(new Font("Georgia", Font.PLAIN, 50));
        spielfelder[i].setPreferredSize(new Dimension(150, 130));
        spielfelder[i].setBorder(null);
        spielfelder[i].setMargin(new Insets(0,0,0,0));
        spielfelder[i].setFocusable(false);

    //Schachbrettfarbe
    if ((i / spielbrettGröße + i % spielbrettGröße) % 2 == 0) {
        spielfelder[i].setBackground(Color.BLACK);
        } else {
        spielfelder[i].setBackground(Color.WHITE);
        }
    final int index = i;
    spielfelder[i].addActionListener(e -> spielfelderGeklickt(index));
    
    spielbrettPanel.add(spielfelder[i]);
    }

    //zentrieren
    zentriertesspielBrettPanel = new JPanel();
    zentriertesspielBrettPanel.setLayout(new GridBagLayout());
    zentriertesspielBrettPanel.add(spielbrettPanel);

}   

private void spielfelderGeklickt(int index) {
    //Action
}

    //Spieler + Figuren
    private JPanel spieler1Panel;
    private JPanel spieler2Panel;
    private JButton[] spieler1Figuren;
    private JButton[] spieler2Figuren;

    private int akutellerSpieler = 1;
    private JButton ausgewählteFigur = null;

private void erstelleFigurenPanel() {
    //Spieler 1 links
    spieler1Panel = new JPanel();
    spieler1Panel.setLayout(new GridLayout(6, 1, 5, 10));
    spieler1Panel.setBorder(BorderFactory.createEmptyBorder(90, 200, 50, 50));

    String[] Figuren1 = {"♗", "♗", "♘", "♘", "♖", "♖"};
    spieler1Figuren = new JButton[Figuren1.length];

    for (int i = 0; i < Figuren1.length; i++) {
        spieler1Figuren[i] = new JButton(Figuren1[i]);
        spieler1Figuren[i].setForeground(Color.WHITE);
        spieler1Figuren[i].setFont(new Font("Dejavu Sans", Font.BOLD, 45));
        spieler1Figuren[i].setBackground(Color.BLACK);
        spieler1Figuren[i].setBorderPainted(false);
        
        spieler1Figuren[i].setFocusable(false);
        spieler1Figuren[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
        final int index = i;
        spieler1Figuren[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FigurGeklickt(1, index);
            }
        });
        spieler1Panel.add(spieler1Figuren[i]);
    }

    //Spieler 2 rechts
    spieler2Panel = new JPanel();
    spieler2Panel.setLayout(new GridLayout(6, 1, 5, 10));
    spieler2Panel.setBorder(BorderFactory.createEmptyBorder(90, 50, 50, 200));

    String[] Figuren2 = {"♗", "♗", "♘", "♘", "♖", "♖"};
    spieler2Figuren = new JButton[Figuren2.length];


    for (int i = 0; i < Figuren2.length; i++) {
        spieler2Figuren[i] = new JButton(Figuren2[i]);
        spieler2Figuren[i].setForeground(Color.BLACK);
        spieler2Figuren[i].setFont(new Font("Dejavu Sans", Font.BOLD, 45));
        spieler2Figuren[i].setBackground(Color.WHITE);
        spieler2Figuren[i].setBorderPainted(false);
        spieler2Figuren[i].setFocusable(false);
        spieler2Figuren[i].setCursor(new Cursor(Cursor.HAND_CURSOR));

        final int index = i;
        spieler2Figuren[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FigurGeklickt(2, index);
            }
        });
        spieler2Panel.add(spieler2Figuren[i]);
    }
}

private void FigurGeklickt(int spieler, int figurindex) {
    //Verweigert falschen Spieler
    if (spieler != akutellerSpieler) {
        System.out.println("Spieler " + akutellerSpieler + " ist am Zug!");
        return;
    }

    //entfernt Auswahl optisch entfernen
    if (ausgewählteFigur != null) {
        ausgewählteFigur.setBorderPainted(false);
    }

    //neue Figur Auswahl
    if (spieler == 1) {
        ausgewählteFigur = spieler1Figuren[figurindex];
    } else {
        ausgewählteFigur = spieler2Figuren[figurindex];
    }

    //neue FIgur Auswahl optisch
    ausgewählteFigur.setBorderPainted(true);
    ausgewählteFigur.setBorder(BorderFactory.createLineBorder(new Color(150,110,40),2 ));
}


private void neuesSpiel() {
    ///Aktion für den neuesSpielButton
}    

private void reset() {
    //Aktion für den ResetSpielButton
}
    
public static void main(String[]args) {
    new TicTacSchachCat();
}
}