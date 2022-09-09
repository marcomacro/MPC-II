import javax.swing.*;

class DataInputPanel extends JPanel {

    private JLabel inputLbl = new JLabel(); // name of what to read in
    private JTextField inputTxtFld = new JTextField(); // value to read in

    public DataInputPanel(String labeling, String defaultInput) {

        // set up this DataInputPanel
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        // set up inputLbl
        inputLbl.setText(labeling + ":");
        inputLbl.setMinimumSize(new java.awt.Dimension(40, 25));
        inputLbl.setPreferredSize(new java.awt.Dimension(60, 25));
        inputLbl.setMaximumSize(new java.awt.Dimension(80, 25));
        
        // set up inputTxtFld
        inputTxtFld.setText(defaultInput);
        inputTxtFld.setMinimumSize(new java.awt.Dimension(35, 25));
        inputTxtFld.setPreferredSize(new java.awt.Dimension(55, 25));
        inputTxtFld.setMaximumSize(new java.awt.Dimension(75, 25));
        
        // populate this DataInputPanel
        this.add(inputLbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        this.add(inputTxtFld);
    }

    // getters & setters:

    float getValue() {
        return Float.parseFloat(inputTxtFld.getText());
    }

    void setValue(String value) {
        inputTxtFld.setText(value);
    }

    void setActionListener (java.awt.event.ActionListener ae) {
        inputTxtFld.addActionListener(ae);
    }

    void setCustomizedColor(java.awt.Color base, java.awt.Color emphasized) {
        this.setBackground(base);
        inputTxtFld.setBackground(base);
        inputTxtFld.setBorder(BorderFactory.createLineBorder(emphasized));
    }

}