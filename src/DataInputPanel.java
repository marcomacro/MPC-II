import javax.swing.*;

class DataInputPanel extends JPanel {
    private JLabel lbl = new JLabel();
    private JTextField txtFld = new JTextField();

    public DataInputPanel(String title, String defaultValue) {
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title);
        this.add(lbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        txtFld.setText(defaultValue);
        txtFld.setPreferredSize(new java.awt.Dimension(50, 25));
        txtFld.setMaximumSize(new java.awt.Dimension(50, 25));
        this.add(txtFld);
    }
}