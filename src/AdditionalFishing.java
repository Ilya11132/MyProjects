import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdditionalFishing extends JFrame {

   //    private static int count = 0;

    private JFrame frame;
    private JLabel label;
    private JButton button2;

    void goMap() {                                                                  // Создаем карту с водоемами
        BaseImage.BaseImage4 BaseImage4 = new BaseImage.BaseImage4();
        Dimension dimension = new Dimension(90, 30);
        BaseImage4.setLayout(null);
        Font font = new Font("Cambria", Font.BOLD, 25);
        JLabel topLabel = new JLabel("Выбирете место на карте");
        topLabel.setFont(font);
        topLabel.setForeground(new Color(0, 111, 198));
        topLabel.setBounds(72, 5, 350, 35);
        label = new JLabel();
        BaseImage4.add(topLabel);
        label = new JLabel();
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        BaseImage4.setLayout(null);

        JButton buttonPlace0 = new JButton("Кирпили");
        buttonPlace0.addActionListener(new listenerGoKirpili());
        buttonPlace0.setBounds(241, 164, 85, 30);
        BaseImage4.add(buttonPlace0);

        button2 = new JButton("Краснодарское вдхр.");
        button2.addActionListener(new buttonListeber2());
        button2.setBounds(254, 331, 151, 30);
        BaseImage4.add(button2);

        JButton buttonPlace1 = new JButton("Прав. прит. Кубани");
        buttonPlace1.addActionListener(new listenerGoBackBaseMenu());
        buttonPlace1.setBounds(433, 187, 151, 30);
        BaseImage4.add(buttonPlace1);

        JButton buttonPlace2 = new JButton("оз. Карасун");
        buttonPlace2.setPreferredSize(dimension);
        buttonPlace2.addActionListener(new buttonListeber4());
        buttonPlace2.setBounds(73, 82, 100, 30);
        BaseImage4.add(buttonPlace2);

        label.add(BaseImage4);
        frame = new JFrame("Выберите место на карте");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600, 300, 600, 410);                     //Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.add(label);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    class listenerGoKirpili implements ActionListener {                           //   Переходим на водоем Кирпили, размещаем кнопки
        public void actionPerformed(ActionEvent event) {
            // count++;
            JButton button11 = new JButton();
            // if (count % 2 == 0) {
            button11.setText("Закинуть");
            //} else button11.setText("Достать");

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }

            frame.setVisible(false);
            Color color = new Color(135, 183, 200);
            BaseImage.BaseImage3 BaseImage3 = new BaseImage.BaseImage3();
            BaseImage3.setLayout(null);
            label = new JLabel();
            label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));

            button11.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, color));
            button11.addActionListener(new listenerFishing());
            button11.setBounds(113, 331, 90, 35);
            BaseImage3.add(button11);

            JButton button22 = new JButton("Трофеи");
            button22.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, color));
            button22.addActionListener(new buttonListeber2());
            button22.setBounds(213, 331, 90, 35);
            BaseImage3.add(button22);

            JButton buttonExit = new JButton("Выход");
            buttonExit.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, color));
            buttonExit.addActionListener(new listenerGoBackBaseMenu());
            buttonExit.setBounds(313, 331, 90, 35);
            BaseImage3.add(buttonExit);

            label.add(BaseImage3);
            frame = new JFrame("Рыбалка");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(600, 300, 600, 410);                             //Если не выставить  размер и положение то окно будет мелкое и незаметное
            frame.add(label);
            frame.setVisible(true);
            frame.setResizable(false);
        }
    }

    class buttonListeber2 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            button2.setText("Игра");
        }
    }

    class listenerGoBackBaseMenu implements ActionListener {                                   // Возвращаемся назад, на базу
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(false);
            AdditionalBase additionalBase = new AdditionalBase();
            additionalBase.menuBase();
        }
    }

    class buttonListeber4 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        //    count = 0;
            frame.setVisible(false);
            GUIFishing start = new GUIFishing();
            start.mainMenu();
        }
    }

    class listenerFishing implements ActionListener {                                       // Начинаем рыбачить
        public void actionPerformed(ActionEvent event) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }

            frame.setVisible(false);
            new Thread() {
                Fishing fishing = new Fishing();

                public void run() {
                    fishing.fishing();
                }
            }.start();
        }

    }

}