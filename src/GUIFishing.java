import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFishing extends JFrame {                                           // Начальный класс, с главным меню
    private JFrame frame;
    private JButton button2;
    private JButton button3;

    public static void main(String[] args) {
        GUIFishing start = new GUIFishing();                                                   //Создаем экземпляр нашего приложения. Форма вызова такая,
        try {                                                                                 // чтобы был нормальный дизайн у кнопок и фреймов
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                start.mainMenu();
            }
        });
    }

    void mainMenu() {                                                               // Задаем дизайн для формы главного меню, размещаем элементы
        Color color = new Color(135, 183, 200);
        BaseImage baseImage = new BaseImage();
        Font font = new Font("Cambria", Font.BOLD, 32);
        Dimension dimension = new Dimension(90, 30);
        JLabel topLabel = new JLabel("Кубанская");
        JLabel topLabel2 = new JLabel("рыбалка");
        topLabel.setFont(font);
        topLabel.setForeground(new Color(0, 111, 198));
        topLabel2.setFont(font);
        topLabel2.setForeground(new Color(0, 111, 121));
        baseImage.setLayout(null);
        topLabel.setBounds(22, 5, 350, 35);
        topLabel2.setBounds(72, 38, 350, 35);
        JLabel label = new JLabel();
        baseImage.add(topLabel);
        baseImage.add(topLabel2);
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(baseImage);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        JButton button1 = new JButton("Вход");
        button1.setPreferredSize(dimension);
        button1.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        button1.addActionListener(new listenerGoBase());
        buttonPanel.add(button1);

        button2 = new JButton("Сохранить");
        button2.setPreferredSize(dimension);
        button2.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        button2.addActionListener(new buttonListeber2());
        buttonPanel.add(button2);


        button3 = new JButton("Загрузить");
        button3.setPreferredSize(dimension);
        button3.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        button3.addActionListener(new buttonListeber3());
        buttonPanel.add(button3);

        JButton buttonExit = new JButton("Выход");
        buttonExit.setPreferredSize(dimension);
        buttonExit.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, color));
        buttonExit.addActionListener(new listenerExit());
        buttonPanel.add(buttonExit);

        JPanel east = new JPanel(new GridBagLayout());
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weighty = 1;
        east.add(buttonPanel, gbc);

        frame = new JFrame("Рыбалка");
        //  frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setBounds(600, 300, 550, 310);                              //Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.add(east, BorderLayout.EAST);
        frame.add(label);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    class listenerGoBase implements ActionListener {                                                // Идем на рыболовную базу
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(false);
            AdditionalBase additionalBase = new AdditionalBase();
            additionalBase.menuBase();
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

    class listenerExit implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }                //  Выход из игры
    }
}
