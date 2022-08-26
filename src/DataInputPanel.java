import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DataInputPanel extends JPanel implements ActionListener {

    private Window mainWindow;
    private String title;
    private JLabel lbl = new JLabel();
    private JTextField txtFld = new JTextField();

    public DataInputPanel(String title, String defaultValue, Window w) {
        mainWindow = w;
        this.title = title;
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title + ":");
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

    String getKey() {
        return title;
    }

    float getValue() {
        return Float.parseFloat(txtFld.getText());
    }

}