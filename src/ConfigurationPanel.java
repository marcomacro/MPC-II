import java.util.ArrayList;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {

    private Window mainWindow;
    private ArrayList<JPanel> materialInputPnlLst = new ArrayList<JPanel>();
    
    public ConfigurationPanel(String[] materialLst, Window w) {
        mainWindow = w;
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        
        for (String m: materialLst) {
            JPanel inputPnl = new DataInputPanel(m + ":", "15.00", w);
            materialInputPnlLst.add(inputPnl);
            this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
            this.add(inputPnl);
        }
    }

}