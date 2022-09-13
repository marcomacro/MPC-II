import javax.swing.BorderFactory;

class DeletableDIP extends DataInputPanel {

    private javax.swing.JButton deleteBtn;

    public DeletableDIP(String labeling, String defaultInput) {

        super(labeling, defaultInput);

        // set up deleteBtn
        deleteBtn = new javax.swing.JButton("X");
        deleteBtn.setMaximumSize( new java.awt.Dimension(45, 25) );
        deleteBtn.setActionCommand(labeling);

        // populate this deleteBtn
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(25, 0) ));
        this.add(deleteBtn);
    }

    void setDeleteBtnActionListener(java.awt.event.ActionListener ae) {
        deleteBtn.addActionListener(ae);
    }

    @Override
    void setCustomizedColor(java.awt.Color base, java.awt.Color emphasized) {
        super.setCustomizedColor(base, emphasized);
        deleteBtn.setBackground(base);
        deleteBtn.setBorder(BorderFactory.createLineBorder(emphasized));
    }
}