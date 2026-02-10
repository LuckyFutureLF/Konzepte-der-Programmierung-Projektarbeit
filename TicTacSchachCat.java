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
    int bildschirmBreite = screenSize.width;
    int bildschirmHöhe = screenSize.height;

    //Taskleistengröße ermitteln
    Insets taskleiste = Toolkit.getDefaultToolkit().getScreenInsets(
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
        );
    int taskleisteHöhe = taskleiste.bottom;

    //tatsächliche Bildschirmhöhe ohne Taskleiste
    int realBildschirmHöhe = bildschirmHöhe - taskleisteHöhe -40;
    double startBildSkalierung = (double) realBildschirmHöhe / 1080;
    int startBildBreite = (int) (1920 * startBildSkalierung);

    TicTacSchachCat() {
        //Hintergrundbild
        ImageIcon startBildIcon = new ImageIcon("tictacschach Startbild v3.jpg");
        Image startBild = startBildIcon.getImage().getScaledInstance(startBildBreite, realBildschirmHöhe, Image.SCALE_SMOOTH);
        JLabel hintergrundJLabel = new JLabel(startBildIcon);
        hintergrundJLabel.setLayout(new GridBagLayout());

        //startButton erstellen
        JButton startJButton = new JButton();
        startJButton.setBorder(new FilledRoundedBorder(25, Color.GRAY, Color.BLACK));
        startJButton.setBorderPainted(true);
        startJButton.setPreferredSize(new Dimension(220,60));
        startJButton.setContentAreaFilled(false);
        startJButton.setOpaque(false);
        startJButton.setFocusPainted(false);

        //Text für startButton erstellen
        JLabel startButtonText = new JLabel("START");
        startButtonText.setForeground(Color.WHITE);
        startButtonText.setFont(new Font("Times New Roman", Font.BOLD, 45));

        //Text zum startButton
        startJButton.setLayout(new GridBagLayout());
        startJButton.add(startButtonText, new GridBagConstraints());

        //Button zum Hintergrund
        hintergrundJLabel.add(startJButton, new GridBagConstraints());

        //spielPanel erstellen
        JPanel spielPanel = new JPanel();
        spielPanel.setLayout(new GridBagLayout());
        spielPanel.setBackground(Color.WHITE);

         //Fenster erstellen
        JFrame fenster = new JFrame("Tic-Tac-Schach");
        fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenster.setLocationRelativeTo(null);
        fenster.setResizable(false);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Karten 
        JPanel kartenPanel = new JPanel(new CardLayout());
        kartenPanel.add(hintergrundJLabel, "START");
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
    
public static void main(String[]args) {
    new TicTacSchachCat();
}
}