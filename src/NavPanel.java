import javax.swing.*;
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
        calculationBtn.setBackground(mainWindow.getBaseColor());
        calculationBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, mainWindow.getEmphasizedColor()));
        // calculationBtn.setBorderPainted(false);
        calculationBtn.setFocusPainted(false);
        calculationBtn.addActionListener(this);
        this.add(calculationBtn);

        configBtn.setMinimumSize( new java.awt.Dimension(75, 50) );
        configBtn.setPreferredSize( new java.awt.Dimension(110, 50) );
        configBtn.setMaximumSize( new java.awt.Dimension(250, 50) );
        configBtn.setBackground(mainWindow.getBaseColor());
        configBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, mainWindow.getEmphasizedColor()));
        configBtn.setBorderPainted(false);
        configBtn.setFocusPainted(false);
        configBtn.addActionListener(this);
        this.add(configBtn);
    }

    public void actionPerformed(ActionEvent ae) {
        mainWindow.switchView(ae.getActionCommand());
        if (ae.getActionCommand().equals("Calculate")) {
            calculationBtn.setBorderPainted(true);
            configBtn.setBorderPainted(false);
        }
        else if (ae.getActionCommand().equals("Config")) {
            calculationBtn.setBorderPainted(false);
            configBtn.setBorderPainted(true);
        } else {
            System.out.println("ERROR: Clicked button not recognized.");
        }
    }

}