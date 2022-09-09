import java.awt.*;
import javax.swing.*;

public class Window {

    private DataStore dataStore;
    private Color baseColor = new Color(253, 253, 172);
    private Color emphasizedColor = new Color(202, 202, 65);
    
    private CalculationPanel calcPnl;
    private ConfigurationPanel configPnl;

    public Window() {
        dataStore = new DataStore();

        // set up the JFrame
        JFrame mpcFrame = new JFrame();
        mpcFrame.setTitle("Material Price Calculator II");
        mpcFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mpcFrame.setSize(300, 400);
        mpcFrame.setMinimumSize( new Dimension(200, 300) );
        mpcFrame.addWindowListener( new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                dataStore.save();
            }
        });
        mpcFrame.setVisible(true);

        // set up the contentPane
        Container contentPane = mpcFrame.getContentPane();
        JPanel contentPnl = new JPanel();

        contentPane.setLayout( new BoxLayout(contentPane, BoxLayout.Y_AXIS) );
        contentPane.setMaximumSize( new Dimension(500, 850) );
        contentPane.add( new NavPanel(this) );
        contentPane.add(contentPnl);

        // populate the contentPnl (NOT contentPane)
        calcPnl = new CalculationPanel(this);
        configPnl = new ConfigurationPanel(this);

        contentPnl.setLayout( new BoxLayout(contentPnl, BoxLayout.X_AXIS) );
        contentPnl.add(calcPnl);
        contentPnl.add(configPnl);
        configPnl.setVisible(false);

        fillCalculationPanel();
    }

    // window behaviour methods:

    void switchView(String clickedPnl) {
        if (clickedPnl == "Calculate") {
            calcPnl.setVisible(true);
            configPnl.setVisible(false);
        } else if (clickedPnl == "Config") {
            calcPnl.setVisible(false);
            configPnl.setVisible(true);
        }
    }

    void fillCalculationPanel() {
        calcPnl.recalc();
    }

    // getters:

    DataStore getDataStore() {
        return dataStore;
    }

    Color getBaseColor() {
        return baseColor;
    }

    Color getEmphasizedColor() {
        return emphasizedColor;
    }

    public static void main(String[] args) {
        new Window();
    }

}