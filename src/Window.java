import javax.swing.*;

public class Window {

    private DataStore dataStore;
    private JFrame mpc_frame = new JFrame();
    private JPanel mainPnl = new JPanel();
    private NavPanel navPnl = new NavPanel(this);
    private JPanel contentPnl = new JPanel();
    private CalculationPanel calcPnl;
    private ConfigurationPanel configPnl;

    public Window(DataStore ds) {
        dataStore = ds;

        mpc_frame.setTitle("Material Price Calculator II");
        mpc_frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mpc_frame.setSize(300, 400);
        mpc_frame.setMinimumSize( new java.awt.Dimension(200, 300) );
        mpc_frame.add(mainPnl);
        mpc_frame.setVisible(true);
        mpc_frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                dataStore.save();
            }
        });

        mainPnl.setLayout( new javax.swing.BoxLayout(mainPnl, javax.swing.BoxLayout.Y_AXIS) );
        mainPnl.setMaximumSize( new java.awt.Dimension(500, 850) );
        mainPnl.add(navPnl);
        mainPnl.add(contentPnl);

        calcPnl = new CalculationPanel(this);
        configPnl = new ConfigurationPanel(this);

        contentPnl.setLayout( new javax.swing.BoxLayout(contentPnl, javax.swing.BoxLayout.X_AXIS) );
        contentPnl.add(calcPnl);
        contentPnl.add(configPnl);
        configPnl.setVisible(false);

        recalc();
    }

    public DataStore getDataStore() {
        return dataStore;
    }

    void switchView(String clickedPnl) {
        if (clickedPnl == "Calculate") {
            calcPnl.setVisible(true);
            configPnl.setVisible(false);
        } else if (clickedPnl == "Config") {
            calcPnl.setVisible(false);
            configPnl.setVisible(true);
        }
    }

    void recalc() {
        calcPnl.recalc();
    }

}