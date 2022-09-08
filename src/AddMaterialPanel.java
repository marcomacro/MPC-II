import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddMaterialPanel extends JPanel implements ActionListener {

    private JButton addBtn;
    private JTextField nameTxtFld;
    private JTextField priceTxtFld;

    public AddMaterialPanel() {
        
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
        addBtn.addActionListener(this);
        this.add(addBtn);
    }

    public void actionPerformed(ActionEvent ae) {
        nameTxtFld.setVisible(true);
        priceTxtFld.setVisible(true);
        this.revalidate();
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