import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddMaterialPanel extends JPanel {

    private Window mainWindow;
    private JTextField nameTxtFld;
    private JTextField priceTxtFld;
    private JButton addBtn;

    public AddMaterialPanel(Window w) {

        mainWindow = w;
        
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS));

        nameTxtFld = new JTextField("Material ...");
        nameTxtFld.setMinimumSize(new java.awt.Dimension(35, 25));
        nameTxtFld.setPreferredSize(new java.awt.Dimension(55, 25));
        nameTxtFld.setMaximumSize(new java.awt.Dimension(75, 25));
        this.add(nameTxtFld);

        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        
        priceTxtFld = new JTextField("123.45");
        priceTxtFld.setMinimumSize(new java.awt.Dimension(35, 25));
        priceTxtFld.setPreferredSize(new java.awt.Dimension(55, 25));
        priceTxtFld.setMaximumSize(new java.awt.Dimension(75, 25));
        this.add(priceTxtFld);

        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));

        addBtn = new JButton("+");
        addBtn.setMaximumSize( new java.awt.Dimension(45, 25) );
        addBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
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
                }
            }
        });
        this.add(addBtn);
    }

    void setCustomizedColor(java.awt.Color base, java.awt.Color emphasized) {
        this.setBackground(base);
        nameTxtFld.setBackground(base);
        nameTxtFld.setBorder(BorderFactory.createLineBorder(emphasized));
        priceTxtFld.setBackground(base);
        priceTxtFld.setBorder(BorderFactory.createLineBorder(emphasized));
        addBtn.setBackground(base);
        addBtn.setBorder(BorderFactory.createLineBorder(emphasized, 2));
    }
    
}