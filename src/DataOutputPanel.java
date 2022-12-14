import javax.swing.*;

class DataOutputPanel extends JPanel {

    private JLabel nameLbl; // name of outputted value
    private JLabel outputLbl; // value to output

    public DataOutputPanel(String title) {
        
        // set up this DataOutputPanel
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );

        // set up nameLbl
        nameLbl = new JLabel();
        nameLbl.setText(title + ":");
        nameLbl.setMinimumSize(new java.awt.Dimension(50, 25));
        nameLbl.setFont(new java.awt.Font("Dialog", 1, 24));

        // set up outputLbl
        outputLbl = new JLabel();
        outputLbl.setFont(new java.awt.Font("Dialog", 1 , 24));

        // populate this DataOutputPanel
        this.add(nameLbl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        this.add(outputLbl);
    }

    // setters:

    void setResult(String result) {
        outputLbl.setText(result);
    }

}