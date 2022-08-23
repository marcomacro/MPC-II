import java.util.ArrayList;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {

    // private JPanel[] materialInputPnlLst = new DataInputPanel[15];
    private ArrayList<JPanel> materialInputPnlLst = new ArrayList<JPanel>();
    
    public ConfigurationPanel(String[] materialLst) {
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        
        for (String m: materialLst) {
            JPanel inputPnl = new DataInputPanel(m + ":", "15.00");
            materialInputPnlLst.add(inputPnl);
            this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
            this.add(inputPnl);
        }
    }

}