import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalBase extends JFrame {

    private JFrame frame;
    private JButton button2;
    private JButton button3;

    void go2() {
        Color color = new Color(135, 183, 200);
        BaseImage.BaseImage2 baseImage2 = new BaseImage.BaseImage2();
        Font font = new Font("Cambria", Font.BOLD, 32);
        Dimension dimension = new Dimension(90, 30);
        JLabel topLabel = new JLabel("Рыболовная");
        JLabel topLabel2 = new JLabel("база");
        topLabel.setFont(font);
        topLabel.setForeground(new Color(0, 111, 198));
        topLabel2.setFont(font);
        topLabel2.setForeground(new Color(0, 111, 121));
        baseImage2.setLayout(null);
        topLabel.setBounds(22, 5, 350, 35);
        topLabel2.setBounds(152, 38, 350, 35);
        JLabel label = new JLabel();
        baseImage2.add(topLabel);
        baseImage2.add(topLabel2);
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(baseImage2);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        JButton button1 = new JButton("На рыбалку");
        button1.setPreferredSize(dimension);
        button1.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        button1.addActionListener(new buttonListeber());
        buttonPanel.add(button1);


        button2 = new JButton("В магазин");
        button2.setPreferredSize(dimension);
        button2.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        button2.addActionListener(new buttonListeber2());
        buttonPanel.add(button2);


        button3 = new JButton("Мой улов");
        button3.setPreferredSize(dimension);
        button3.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        button3.addActionListener(new buttonListeber3());
        buttonPanel.add(button3);


        JButton buttonExit = new JButton("Выход");
        buttonExit.setPreferredSize(dimension);
        buttonExit.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        buttonExit.addActionListener(new buttonListeber4());
        buttonPanel.add(buttonExit);


        JPanel east = new JPanel(new GridBagLayout());
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weighty = 1;
        east.add(buttonPanel, gbc);

        frame = new JFrame("Рыбалка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600, 300, 550, 310);//Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.add(east, BorderLayout.EAST);
        frame.add(label);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    class buttonListeber implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(false);

            AdditionalFishing additional2 = new AdditionalFishing();
            additional2.go3();
        }
    }

    class buttonListeber2 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            button2.setText("Игра");
        }
    }

    class buttonListeber3 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            button3.setText("Игра");
        }
    }

    class buttonListeber4 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(false);
            GUIFishing start = new GUIFishing();
            start.mainMenu();
        }
    }
}