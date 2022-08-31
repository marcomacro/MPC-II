import javax.swing.*;
import java.awt.event.ActionListener;

class DataInputPanel extends JPanel {

    private String title;
    private JLabel lbl = new JLabel();
    private JTextField txtFld = new JTextField();

    public DataInputPanel(String title, String defaultValue, ActionListener ae) {
        this.title = title;
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title + ":");
        this.add(lbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        txtFld.setText(defaultValue);
        txtFld.setPreferredSize(new java.awt.Dimension(50, 25));
        txtFld.setMaximumSize(new java.awt.Dimension(50, 25));
        txtFld.addActionListener(ae);
        this.add(txtFld);
    }

    String getKey() {
        return title;
    }

    float getValue() {
        return Float.parseFloat(txtFld.getText());
    }

}