import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

class FishCore {                 // Сделать фото пойманой рыбы. Реализовать в виде хэш карты, где значением будет путь к фото, а ключом - строка типа "Окунь 8 кг"
                                // Значение ключа также выводить во фрейме вместе с фото и считывать его. Реализовать сохранение пойманной рыбы, чтобы пользователь мог просмотреть свои трофеи


    private final JOptionPane optPane = new JOptionPane();
    private JDialog dialog = new JDialog();
    private JFrame frame;

    void hereTheFish() {                                                     // Заглушка, сообщает, что мы поймали рыбу

        JFrame frame;
        frame = new JFrame("Рыбалка");
        frame.setBounds(600, 300, 600, 410);            //Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.setResizable(false);
        Random random = new Random();
        boolean flag = false;
        String message;
        if (random.nextInt(9) < 7) {
            gif();
        } else {
            message = "Ушла, увы...";                                           // Выводиим фотку нашей рандомно пойманной рыбы (добавить надписи "Окунь 3 кг...")
            optPane.setMessage(message);
            optPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
            optPane.setOptionType(JOptionPane.DEFAULT_OPTION);
            dialog.add(optPane);
            dialog.pack();
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);

        }
        //   if (flag)


    }

    void gif() {                                                               // Задаем дизайн для формы главного меню, размещаем элементы

        fishimage1 fishimage = new fishimage1();
        Dimension dimension = new Dimension(90, 30);
        fishimage.setLayout(null);
        JLabel label = new JLabel();
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(fishimage);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        JButton button1 = new JButton("Вход");
        button1.setPreferredSize(dimension);
        button1.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, Color.red));

        JButton buttonExit = new JButton("Выход");
        buttonExit.setPreferredSize(dimension);
        buttonExit.setBorder(BorderFactory.createMatteBorder(
                15, 4, 15, 6, Color.red));
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
        frame.setBounds(650, 350, 700, 600);                              //Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.add(east, BorderLayout.EAST);
        frame.add(label);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    class listenerExit implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }                //  Выход из игры
    }


    public class DeckOfCards extends javax.swing.JApplet {

        public Image myImage() {

            ArrayList<Image> clubs = new ArrayList<>();
            clubs.add(new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/karas.jpg").getImage());
            clubs.add(new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/karp.jpg").getImage());
            clubs.add(new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/okun.jpg").getImage());
            clubs.add(new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/plotva.jpg").getImage());

            Random random = new Random();
            int rand = random.nextInt(3);
            return clubs.get(rand);

        }


    }

    class fishimage1 extends JPanel {
        public void paintComponent(Graphics g) {
            DeckOfCards deckOfCards = new DeckOfCards();
            Image image = deckOfCards.myImage();

            g.drawImage(image, 0, 0, this);

        }
    }


    //  ArrayList<Image> arrayName = new ArrayList<Image>();
    //  Image imageName = getImage(getCodeBase(),"direction.jpg");
    //   arrayName.add(imageName);

}
