import java.awt.Dimension;
import javax.swing.*;

public class NavPanel extends JPanel implements java.awt.event.ActionListener {

    private Window mainWindow;

    private JButton calculationBtn;
    private JButton configBtn;
    
    public NavPanel(Window w) {
        mainWindow = w;

        // set up this NavPanel
        this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );
        this.setMaximumSize( new Dimension(500, 50) );

        // set up CalculationBtn
        calculationBtn = new JButton("Calculate");

        calculationBtn.setMinimumSize( new Dimension(75, 50) );
        calculationBtn.setPreferredSize( new Dimension(110, 50) );
        calculationBtn.setMaximumSize( new Dimension(250, 50) );

        calculationBtn.setBackground(mainWindow.getBaseColor());
        calculationBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, mainWindow.getEmphasizedColor()));
        calculationBtn.setFocusPainted(false);
        
        calculationBtn.addActionListener(this);
        
        // set up ConfigBtn
        configBtn  = new JButton("Config");
        
        configBtn.setMinimumSize( new Dimension(75, 50) );
        configBtn.setPreferredSize( new Dimension(110, 50) );
        configBtn.setMaximumSize( new Dimension(250, 50) );
        
        configBtn.setBackground(mainWindow.getBaseColor());
        configBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, mainWindow.getEmphasizedColor()));
        configBtn.setBorderPainted(false);
        configBtn.setFocusPainted(false);
        
        configBtn.addActionListener(this);
        
        // populate this NavPanel
        this.add(calculationBtn);
        this.add(configBtn);
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        mainWindow.switchView(ae.getActionCommand());
        // update NavPanel appearance
        if (ae.getActionCommand().equals("Calculate")) {
            calculationBtn.setBorderPainted(true);
            configBtn.setBorderPainted(false);
        }
        else if (ae.getActionCommand().equals("Config")) {
            calculationBtn.setBorderPainted(false);
            configBtn.setBorderPainted(true);
        }
    }

}