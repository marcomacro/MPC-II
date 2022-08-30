import javax.swing.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Window {

    DataAccess dataAccess;
    SortedMap<String, Float> materialLst;
    private JFrame mpc_frame = new JFrame();
    private JPanel mainPnl = new JPanel();
    private JPanel navPnl = new NavPanel(this);
    private JPanel contentPnl = new JPanel();
    private CalculationPanel calcPnl;
    private ConfigurationPanel configPnl;

    public Window(DataAccess da) {
        dataAccess = da;

        mpc_frame.setTitle("Material Price Calculator II");
        mpc_frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mpc_frame.setSize(300, 400);
        mpc_frame.setMinimumSize( new java.awt.Dimension(200, 300) );
        mpc_frame.add(mainPnl);
        mpc_frame.setVisible(true);

        mainPnl.setLayout( new javax.swing.BoxLayout(mainPnl, javax.swing.BoxLayout.Y_AXIS) );
        mainPnl.setMaximumSize( new java.awt.Dimension(500, 850) );
        mainPnl.add(navPnl);
        mainPnl.add(contentPnl);

        // materialLst = new TreeMap<String, Float>();
        materialLst = da.readMaterials();
        // fillMaterialLst();
        calcPnl = new CalculationPanel(this);
        configPnl = new ConfigurationPanel(this);

        contentPnl.setLayout( new javax.swing.BoxLayout(contentPnl, javax.swing.BoxLayout.X_AXIS) );
        contentPnl.add(calcPnl);
        contentPnl.add(configPnl);
        configPnl.setVisible(false);

        recalc();
    }

    private void fillMaterialLst() {
        materialLst.put("Papier", 5.00f);
        materialLst.put("Folie", 10.00f);
        materialLst.put("Plakat", 15.50f);
        materialLst.put("u.v.m.", -2.00f);
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
        if (configPnl.isVisible()) configPnl.recalc();
        calcPnl.recalc();
    }

}