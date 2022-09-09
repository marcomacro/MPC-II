public class ConfigurationPanel extends javax.swing.JPanel {

    private Window mainWindow;
    
    public ConfigurationPanel(Window w) {
        mainWindow = w;

        // set up this ConfigurationPanel
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        this.setBackground(mainWindow.getBaseColor());
        
        // get the list of materials
        java.util.TreeMap<String, Float> materialLst = mainWindow.getDataStore().getMaterialLst();
        java.util.Iterator<java.util.Map.Entry<String, Float>> i = materialLst.entrySet().iterator();

        // populate this ConfigurationPanel
        while (i.hasNext()) {
            java.util.Map.Entry<String, Float> mapItem = (java.util.Map.Entry<String, Float>)i.next();

            DataInputPanel inputPnl = new DataInputPanel(mapItem.getKey().toString(), String.format(java.util.Locale.US, "%,.2f", mapItem.getValue()));
            inputPnl.setCustomizedColor(mainWindow.getBaseColor(), mainWindow.getEmphasizedColor());

            inputPnl.setActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                    boolean successfullyParsed = false;
                    float value = -1;

                    // try to parse unformatted string
                    try {
                        value = Float.parseFloat(ae.getActionCommand());
                        successfullyParsed = true;
                    } catch (NumberFormatException nfe) {
                        // try to parse localized string
                        try {
                            java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
                            value = (nf.parse(ae.getActionCommand())).floatValue();
                            successfullyParsed = true;
                        } catch (java.text.ParseException pe) {
                            ;
                        }     
                    }
                    if (successfullyParsed && value > 0) {
                        // register number in materialLst
                        materialLst.put(mapItem.getKey().toString(), value);
                        // Upate (formatted / localized) number in DataInputPanel
                        inputPnl.setValue(String.format(java.util.Locale.US, "%,.2f", materialLst.get(mapItem.getKey())));
                        // write the updated materialLst back to DataStore
                        mainWindow.getDataStore().setMaterialLst(materialLst);
                    } else {
                        // set the DataInputPanel back to the previous value, due to it not beeing parsable
                        inputPnl.setValue(String.format(java.util.Locale.US, "%,.2f", materialLst.get(mapItem.getKey())));
                    }
                    mainWindow.fillCalculationPanel();
                }
            });

            this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
            this.add(inputPnl);
        }
        
    }

}