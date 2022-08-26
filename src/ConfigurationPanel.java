import java.util.ArrayList;
import java.util.SortedMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {

    private Window mainWindow;
    private ArrayList<JPanel> materialInputPnlLst = new ArrayList<JPanel>();
    
    public ConfigurationPanel(SortedMap<String, Float> materialLst, Window w) {
        mainWindow = w;
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        
        Iterator i = materialLst.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();
            DataInputPanel inputPnl = new DataInputPanel(m.getKey() + ":", m.getValue().toString(), w);
            materialInputPnlLst.add(inputPnl);
            this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
            this.add(inputPnl);
        }
        
    }

}