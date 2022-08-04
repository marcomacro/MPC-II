import java.awt.Color;

import javax.swing.*;

public class NavPanel extends JPanel {
    private JPanel left = new JPanel();
    private JPanel right = new JPanel();
    
    public NavPanel() {
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 50) );

        left.setBackground(Color.BLUE);
        this.add(left);
        right.setBackground(Color.YELLOW);
        this.add(right);
    }
}
