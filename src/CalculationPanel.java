import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationPanel extends JPanel {

    private Window mainWindow;
    private JComboBox<String> materialCmbBox;
    private JLabel choosenPriceLbl;
    private DataInputPanel heightPnl;
    private DataInputPanel widthPnl;
    private DataOutputPanel resultPnl = new DataOutputPanel("Price");

    public CalculationPanel(Window w) {
        mainWindow = w;
        
        heightPnl = new DataInputPanel("Height", String.valueOf(mainWindow.getDataStore().getHeight()));
        heightPnl.setCustomizedColor(mainWindow.getBaseColor(), mainWindow.getEmphasizedColor());
        heightPnl.setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    int value = Integer.parseInt(ae.getActionCommand());
                    if (value <= 0) throw new NumberFormatException();
                    mainWindow.getDataStore().setHeight(value);
                } catch (NumberFormatException nfe) {
                    heightPnl.setValue(Integer.toString(mainWindow.getDataStore().getHeight()));
                }
                recalc();
            }
        });
        
        widthPnl = new DataInputPanel("Width", String.valueOf(mainWindow.getDataStore().getWidth()));
        widthPnl.setCustomizedColor(mainWindow.getBaseColor(), mainWindow.getEmphasizedColor());
        widthPnl.setActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    int value = Integer.parseInt(ae.getActionCommand());
                    if (value <= 0) throw new NumberFormatException();
                    mainWindow.getDataStore().setWidth(value);
                } catch (NumberFormatException nfe) {
                    widthPnl.setValue(Integer.toString(mainWindow.getDataStore().getWidth()));
                }
                recalc();
            }
        });

        materialCmbBox = new JComboBox<String>();
        fillMaterialCmbBox();
        materialCmbBox.setMaximumSize(new java.awt.Dimension(180, 25));
        materialCmbBox.setBackground(mainWindow.getBaseColor());
        materialCmbBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainWindow.getDataStore().setCurrentMaterial(materialCmbBox.getSelectedIndex());
                recalc();
            }
        });

        choosenPriceLbl = new JLabel();
        choosenPriceLbl.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        resultPnl.setBackground(mainWindow.getBaseColor());

        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        this.setBackground(mainWindow.getBaseColor());

        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
        this.add(materialCmbBox);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 5) ));
        this.add(choosenPriceLbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        this.add(heightPnl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 15) ));
        this.add(widthPnl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 55) ));
        this.add(resultPnl);
    }

    void fillMaterialCmbBox() {
        materialCmbBox.removeAllItems();
        for (String key : mainWindow.getDataStore().getMaterialLst().keySet()) {
            materialCmbBox.addItem(key);
        }
        materialCmbBox.setSelectedIndex(mainWindow.getDataStore().getCurrentMaterial()); 
    }

    void recalc() {
        /* Why a try-statement here ??
         * After adding materials on the configPnl, the materialCmbBox is cleared out and after
         * that refilled from DataStore (method above). When removing these items, 
         * (this) recalc()-method is invoked and it fails to get the selected-Item, when or 'cuz
         * this had been removed, which leads to that the code isn't able to calc the float p.
          */
        try {
            Float p = mainWindow.getDataStore().getMaterialLst().get(materialCmbBox.getSelectedItem());
            Float h = heightPnl.getValue();
            Float w = widthPnl.getValue();
            choosenPriceLbl.setText(String.format(java.util.Locale.US ,"%,.2f", p));
            resultPnl.setResult(String.format(java.util.Locale.US ,"%,.2f", h * w * p));
        } catch (Exception e) {
            // System.out.println("Catched.");
        }
    }

}