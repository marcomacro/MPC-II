import java.util.ArrayList;
import java.util.Map;
import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel {

    private Window mainWindow;
    private ArrayList<DataInputPanel> materialInputPnlLst = new ArrayList<DataInputPanel>();
    
    public ConfigurationPanel(Window w) {
        mainWindow = w;
        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );
        
        java.util.TreeMap<String, Float> materialLst = mainWindow.dataStore.getMaterialLst();
        java.util.Iterator<Map.Entry<String, Float>> i = materialLst.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, Float> m = (Map.Entry<String, Float>)i.next();

            DataInputPanel inputPnl = new DataInputPanel(m.getKey().toString(), String.format(java.util.Locale.US, "%,.2f", m.getValue()));

            inputPnl.setActionListener( new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ae) {
                    boolean successfullyParsed = false;
                    float value = -1;

                    // try to parse unformatted string
                    try {
                        value = Float.parseFloat(ae.getActionCommand());
                        successfullyParsed = true;
                    } catch (NumberFormatException nfe) {
                        // try to parse localizd string
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
                        materialLst.put(m.getKey().toString(), value); // rewrite
                        // Upate (formatted / localized) number in DataInputPanel
                        inputPnl.setValue(String.format(java.util.Locale.US, "%,.2f", materialLst.get(m.getKey())));
                    } else {
                        // set the DataInputPanel back to the previous value, due to it not beeing parsable
                        inputPnl.setValue(String.format(java.util.Locale.US, "%,.2f", materialLst.get(m.getKey())));
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