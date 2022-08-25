import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DataInputPanel extends JPanel implements ActionListener {

    private Window mainWindow;
    private JLabel lbl = new JLabel();
    private JTextField txtFld = new JTextField();

    public DataInputPanel(String title, String defaultValue, Window w) {
        mainWindow = w;
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title);
        this.add(lbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        txtFld.setText(defaultValue);
        txtFld.setPreferredSize(new java.awt.Dimension(50, 25));
        txtFld.setMaximumSize(new java.awt.Dimension(50, 25));
        txtFld.addActionListener(this);
        this.add(txtFld);
    }

    public void actionPerformed (ActionEvent ae) {
        mainWindow.recalc();
    }

    public float getValue() {
        return Float.parseFloat(txtFld.getText());
    }

}