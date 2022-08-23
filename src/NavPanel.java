import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavPanel extends JPanel implements ActionListener {

    private Window mainWindow;
    private JButton calculationBtn = new JButton("Calculate");
    private JButton configBtn = new JButton("Config");
    
    public NavPanel(Window w) {
        mainWindow = w;

        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );
        this.setMaximumSize( new java.awt.Dimension(500, 50) );

        calculationBtn.setMinimumSize( new java.awt.Dimension(75, 50) );
        calculationBtn.setPreferredSize( new java.awt.Dimension(110, 50) );
        calculationBtn.setMaximumSize( new java.awt.Dimension(250, 50) );
        calculationBtn.setBackground(new Color(238, 238, 238));
        calculationBtn.setBorderPainted(false);
        calculationBtn.setFocusPainted(false);
        calculationBtn.addActionListener(this);
        this.add(calculationBtn);

        configBtn.setMinimumSize( new java.awt.Dimension(75, 50) );
        configBtn.setPreferredSize( new java.awt.Dimension(110, 50) );
        configBtn.setMaximumSize( new java.awt.Dimension(250, 50) );
        configBtn.setBackground(new Color(238, 238, 238));
        configBtn.setBorderPainted(false);
        configBtn.setFocusPainted(false);
        configBtn.addActionListener(this);
        this.add(configBtn);
    }

    public void actionPerformed(ActionEvent ae) {
        mainWindow.switchView(ae.getActionCommand());
    }

}
