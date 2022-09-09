import javax.swing.*;

class DataOutputPanel extends JPanel {

    private JLabel lbl = new JLabel();
    private JLabel resultLbl = new JLabel();

    public DataOutputPanel(String title) {
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        lbl.setText(title + ":");
        lbl.setMinimumSize(new java.awt.Dimension(50, 25));
        lbl.setFont(new java.awt.Font("Dialog", 1, 24));

        resultLbl.setFont(new java.awt.Font("Dialog", 1 , 24));

        this.add(lbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        this.add(resultLbl);
    }

    void setResult(String result) {
        resultLbl.setText(result);
    }

}