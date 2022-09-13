import java.awt.Dimension;
import javax.swing.*;

class DataAddPanel extends JPanel {

    private JTextField nameTxtFld; // name of what to add
    private JTextField priceTxtFld; // price of added
    private JButton addBtn; //confirm

    public DataAddPanel(Window w) {

        Window mainWindow = w;
        
        // set up this DataAddPanel
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS));

        // set up nameTxtFld
        nameTxtFld = new JTextField("Material ...");
        nameTxtFld.setMinimumSize( new Dimension(35, 25) );
        nameTxtFld.setPreferredSize( new Dimension(55, 25) );
        nameTxtFld.setMaximumSize( new Dimension(75, 25) );
        
        // set up priceTxtFld
        priceTxtFld = new JTextField("123.45");
        priceTxtFld.setMinimumSize(new Dimension(35, 25));
        priceTxtFld.setPreferredSize(new Dimension(55, 25));
        priceTxtFld.setMaximumSize(new Dimension(75, 25));
        
        // set up addBtn
        addBtn = new JButton("+");
        addBtn.setMaximumSize( new Dimension(45, 25) );
        addBtn.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String materialName = nameTxtFld.getText();
                boolean successfullyParsed = false;
                float value = -1;
                
                // try to parse unformatted string
                try {
                    value = Float.parseFloat(priceTxtFld.getText());
                    successfullyParsed = true;
                } catch (NumberFormatException nfe) {
                    // try to parse localized string
                    try {
                        java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
                        value = (nf.parse(priceTxtFld.getText())).floatValue();
                        successfullyParsed = true;
                    } catch (java.text.ParseException pe) {
                        ;
                    }     
                }
                
                if (successfullyParsed) {
                    mainWindow.getDataStore().getMaterialLst().put(materialName, value);
                    mainWindow.rebuildConfigPnl();
                }
            }
        });
        
        // populate this DataAddPanel
        this.add(nameTxtFld);
        this.add(javax.swing.Box.createRigidArea( new Dimension(25, 0) ));
        this.add(priceTxtFld);
        this.add(javax.swing.Box.createRigidArea( new Dimension(25, 0) ));
        this.add(addBtn);
    }

    // component behaviour methods:

    void setCustomizedColor(java.awt.Color base, java.awt.Color emphasized) {
        this.setBackground(base);
        nameTxtFld.setBackground(base);
        nameTxtFld.setBorder(BorderFactory.createLineBorder(emphasized));
        priceTxtFld.setBackground(base);
        priceTxtFld.setBorder(BorderFactory.createLineBorder(emphasized));
        addBtn.setBackground(base);
        addBtn.setBorder(BorderFactory.createLineBorder(emphasized));
    }
    
}