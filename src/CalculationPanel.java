public class CalculationPanel extends javax.swing.JPanel {
    
    private Window mainWindow;
    
    private javax.swing.JComboBox<String> materialCmbBox;
    private javax.swing.JLabel choosenPriceLbl;
    private DataInputPanel heightPnl;
    private DataInputPanel widthPnl;
    private DataOutputPanel resultPnl;
    
    public CalculationPanel(Window w) {
        mainWindow = w;
        
        // set up this CalculationPanel
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        this.setBackground(mainWindow.getBaseColor());

        // set up materialCmbBox
        materialCmbBox = new javax.swing.JComboBox<String>();
        materialCmbBox.setMaximumSize( new java.awt.Dimension(180, 25) );
        materialCmbBox.setBackground(mainWindow.getBaseColor());

        materialCmbBox.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                mainWindow.getDataStore().setCurrentMaterial(materialCmbBox.getSelectedIndex());
                recalc();
            }
        });

        fillMaterialCmbBox(mainWindow.getDataStore().getMaterialLst());
        
        // set up choosenPriceLbl
        choosenPriceLbl = new javax.swing.JLabel();
        choosenPriceLbl.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        
        // set up heightPnl
        heightPnl = new DataInputPanel("Height", String.valueOf(mainWindow.getDataStore().getHeight()));
        heightPnl.setCustomizedColor(mainWindow.getBaseColor(), mainWindow.getEmphasizedColor());

        heightPnl.setActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
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
        
        // set up widthPnl
        widthPnl = new DataInputPanel("Width", String.valueOf(mainWindow.getDataStore().getWidth()));
        widthPnl.setCustomizedColor(mainWindow.getBaseColor(), mainWindow.getEmphasizedColor());

        widthPnl.setActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
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

        // set up resultPnl
        resultPnl = new DataOutputPanel("Price");
        resultPnl.setBackground(mainWindow.getBaseColor());

        // populate this calculationPanel
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

    // component behaviour functions:

    private void fillMaterialCmbBox(java.util.SortedMap<String, Float> materialLst) {
        for (String key : materialLst.keySet()) {
            materialCmbBox.addItem(key);
        }
        materialCmbBox.setSelectedIndex(mainWindow.getDataStore().getCurrentMaterial());
    }

    void recalc() {
        Float p = mainWindow.getDataStore().getMaterialLst().get(materialCmbBox.getSelectedItem());
        Float h = heightPnl.getValue();
        Float w = widthPnl.getValue();
        choosenPriceLbl.setText(String.format(java.util.Locale.US ,"%,.2f", p));
        resultPnl.setResult(String.format(java.util.Locale.US ,"%,.2f", h * w * p));
    }

}