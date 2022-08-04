import javax.swing.*;

class DataOutputPanel extends JPanel {
    private JLabel lbl = new JLabel();
    private JLabel resultLbl = new JLabel();

    public DataOutputPanel(String title, String defaultValue) {
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title);
        lbl.setMinimumSize(new java.awt.Dimension(50, 25));
        this.add(lbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        resultLbl.setText(defaultValue);
        this.add(resultLbl);
    }

    public void setResult(String result) {
        resultLbl.setText(result);
    }
}