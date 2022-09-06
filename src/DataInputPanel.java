import javax.swing.*;
import java.awt.event.ActionListener;

class DataInputPanel extends JPanel {

    private String title;
    private JLabel lbl = new JLabel();
    private JTextField txtFld = new JTextField();

    public DataInputPanel(String title, String defaultValue) {
        this.title = title;
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title + ":");
        lbl.setMinimumSize(new java.awt.Dimension(40, 25));
        lbl.setPreferredSize(new java.awt.Dimension(60, 25));
        lbl.setMaximumSize(new java.awt.Dimension(80, 25));
        this.add(lbl);

        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        
        txtFld.setText(defaultValue);
        txtFld.setMinimumSize(new java.awt.Dimension(35, 25));
        txtFld.setPreferredSize(new java.awt.Dimension(55, 25));
        txtFld.setMaximumSize(new java.awt.Dimension(75, 25));
        this.add(txtFld);
    }

    String getKey() {
        return title;
    }

    float getValue() {
        return Float.parseFloat(txtFld.getText());
    }

    void setValue(String value) {
        txtFld.setText(value);
    }

    void setActionListener (ActionListener ae) {
        txtFld.addActionListener(ae);
    }

    void setCustomizedColor(java.awt.Color base, java.awt.Color emphasized) {
        this.setBackground(base);
        txtFld.setBackground(base);
        txtFld.setBorder(BorderFactory.createLineBorder(emphasized));
    }

}