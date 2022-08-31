import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {

    private Window mainWindow;
    private ArrayList<DataInputPanel> materialInputPnlLst = new ArrayList<DataInputPanel>();
    
    public ConfigurationPanel(Window w) {
        mainWindow = w;
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        
        Iterator i = mainWindow.materialLst.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();

            DataInputPanel inputPnl = new DataInputPanel(m.getKey().toString(), m.getValue().toString());

            inputPnl.setActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                    try {
                        float value = Float.parseFloat(ae.getActionCommand());
                        if (value <= 0) throw new NumberFormatException();
                        mainWindow.materialLst.put(m.getKey().toString(), value);
                    } catch (NumberFormatException nfe) {
                        inputPnl.setValue(Float.toString(mainWindow.materialLst.get(m.getKey())));
                    }
                    mainWindow.recalc();
                }
            });

            materialInputPnlLst.add(inputPnl);
            this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
            this.add(inputPnl);
        }
        
    }

}