import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.util.SortedMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationPanel extends JPanel {

    private Window mainWindow;
    private JComboBox<String> materialCmbBox;
    private DataInputPanel heightPnl;
    private DataInputPanel widthPnl;
    private DataOutputPanel resultPnl = new  DataOutputPanel("Price", "89,90 €");

    public CalculationPanel(Window w) {
        mainWindow = w;
        
        heightPnl = new DataInputPanel("Height", mainWindow.dataAccess.readValue("height-value"), mainWindow);
        widthPnl = new DataInputPanel("Width", mainWindow.dataAccess.readValue("width-value"), mainWindow);
        materialCmbBox = new JComboBox<String>();
        fillMaterialCmbBox(mainWindow.materialLst);
        materialCmbBox.setMaximumSize(new java.awt.Dimension(220, 25));
        materialCmbBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                recalc();
            }
        });

        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );

        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
        this.add(materialCmbBox);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        this.add(heightPnl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 15) ));
        this.add(widthPnl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        this.add(resultPnl);
    }

    private void fillMaterialCmbBox(SortedMap<String, Float> materialLst) {
        for (String key : materialLst.keySet()) {
            materialCmbBox.addItem(key);
        }
        materialCmbBox.setSelectedIndex(Integer.parseInt(mainWindow.dataAccess.readValue("current-material")));
    }

    void recalc() {
        Float p = mainWindow.materialLst.get(materialCmbBox.getSelectedItem());
        Float h = heightPnl.getValue();
        Float w = widthPnl.getValue();
        resultPnl.setResult(Float.toString( h * w * p ));
    }

}