import javax.swing.*;

public class Window {
    
    private static JFrame mpc_frame = new JFrame();
    private static JPanel mainPnl = new JPanel();
    private static JPanel topPnl = new NavPanel();

    private static String materialLst [] = {"Papier", "Folie", "Plakat", "u.v.a."};

    private static JComboBox materialCmbBox = new JComboBox(materialLst);
    private static JPanel heightPnl = new DataInputPanel("Height:", "70");
    private static JPanel widthPnl = new DataInputPanel("Width:", "70");
    private static JPanel resultPnl = new  DataOutputPanel("Price:", "89,90 €");

    public Window() {
        mpc_frame.setTitle("Material Price Calculator II");
        mpc_frame.setSize(300, 400);
        mpc_frame.setMinimumSize( new java.awt.Dimension(200, 300) );
        mpc_frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mpc_frame.add(mainPnl);

        mainPnl.setMaximumSize( new java.awt.Dimension(500, 800) );
        
        materialCmbBox.setMaximumSize(new java.awt.Dimension(220, 25));

        mainPnl.setLayout( new javax.swing.BoxLayout(mainPnl, javax.swing.BoxLayout.Y_AXIS) );
        mainPnl.add(topPnl);
        mainPnl.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
        mainPnl.add(materialCmbBox);
        mainPnl.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        mainPnl.add(heightPnl);
        mainPnl.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 15) ));
        mainPnl.add(widthPnl);
        mainPnl.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        mainPnl.add(resultPnl);

        mpc_frame.setVisible(true);
    }
}
