import javax.swing.JPanel;
import javax.swing.JComboBox;

public class CalculationPanel extends JPanel {

    private Window mainWindow;
    private JComboBox materialCmbBox;
    private DataInputPanel heightPnl;
    private DataInputPanel widthPnl;
    private DataOutputPanel resultPnl = new  DataOutputPanel("Price:", "89,90 €");

    public CalculationPanel(String[] materialLst, Window w) {
        mainWindow = w;
        
        heightPnl = new DataInputPanel("Height:", "70", mainWindow);
        widthPnl = new DataInputPanel("Width:", "70", mainWindow);
        materialCmbBox = new JComboBox<>(materialLst);
        materialCmbBox.setMaximumSize(new java.awt.Dimension(220, 25));

        this.setLayout( new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 800) );

        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 25) ));
        this.add(materialCmbBox);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        this.add(heightPnl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 15) ));
        this.add(widthPnl);
        this.add(javax.swing.Box.createRigidArea( new java.awt.Dimension(0, 35) ));
        this.add(resultPnl);
    }

    public void recalc() {
        Float h = heightPnl.getValue();
        Float w = widthPnl.getValue();
        resultPnl.setResult(Float.toString(h*w));
    }

}