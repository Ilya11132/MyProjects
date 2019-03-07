import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fishing extends JPanel {
    static JFrame frame;
    JButton button11;
    int yy = 230;
    int xx = 330;
    int count2 = 0;

    public static void main(String[] args) {
        Fishing start = new Fishing(); //Создаем экземпляр нашего приложения
        start.arrangement();


    }

    public void arrangement() {

        TheFish theFish = new TheFish();


        button11 = new JButton();
        button11.setText("Достать");
        Color color = new Color(135, 183, 200);


        ImageArrangement imageShape = new ImageArrangement();
        imageShape.setLayout(null);

        button11.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color.RED.darker()));

        button11.setBounds(113, 331, 90, 35);
        button11.addActionListener(new buttonListenerComeBack2());

        imageShape.add(button11);

        JButton button22 = new JButton("Трофеи");
        button22.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color));
        button22.setBounds(213, 331, 90, 35);
        imageShape.add(button22);
        JButton button33 = new JButton("Выход");
        button33.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color));
        button33.setBounds(313, 331, 90, 35);
        imageShape.add(button33);
        imageShape.setBounds(0, 0, 600, 410);

        frame = new JFrame("Рыбалка");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600, 300, 600, 410);//Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.add(imageShape);
        frame.setVisible(true);


        frame.setResizable(false);


        theFish.fish();

        if (theFish.fish()) {
            button11.setText("Тянуть");
        } else button11.setText("Тянуть");


    }

    public void fishing() {


        button11 = new JButton();


        {
            button11.setText("Достать");
        }


        button11.addActionListener(new buttonListenerCatch());
        Color color = new Color(135, 183, 200);
        ImageShape imageShape = new ImageShape();
        imageShape.setLayout(null);

        button11.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color.RED.darker()));
        button11.setBounds(113, 331, 90, 35);
        imageShape.add(button11);

        JButton button22 = new JButton("Трофеи");
        button22.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color));
        button22.setBounds(213, 331, 90, 35);
        imageShape.add(button22);
        JButton button33 = new JButton("Выход");
        button33.addActionListener(new buttonListenerComeBack());
        button33.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color));
        button33.setBounds(313, 331, 90, 35);
        imageShape.add(button33);
        imageShape.setBounds(0, 0, 600, 410);

        frame = new JFrame("Рыбалка");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600, 300, 600, 410);//Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.add(imageShape);
        frame.setVisible(true);
        frame.setResizable(false);


        TheFish theFish = new TheFish();
        theFish.fish();


        for (int i = 0; i < 330; i++) {
            imageShape.repaint();

            //     xx++;
            //   yy++;

            try {
                Thread.sleep(0);
            } catch (Exception ex) {
            }
        }
    }

    public class ImageArrangement extends JPanel {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/vodoem.jpeg").getImage();
            g.drawImage(image, 0, 0, this);
            g.setColor(Color.red);
            g.fillOval(250, 221, 20, 20);
        }
    }

    public class ImageShape extends JPanel {
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/vodoem.jpeg").getImage();
            g.drawImage(image, 0, 0, this);
            g.setColor(Color.red);
            g.fillOval(xx, yy, 20, 20);
        }
    }

    class buttonListenerComeBack implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            //  !!!     if (flag !=true) {System.exit(0);}


            frame.setVisible(false);
            GUIFishing start = new GUIFishing();
            start.mainMenu();


        }
    }

    class buttonListenerComeBack2 implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            TheFish theFish = new TheFish();
            theFish.fish();
        }
    }

    class buttonListenerCatch implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            TheFish theFish = new TheFish();


            if (theFish.getFlag2() & count2 == 0) {
                // System.exit(0);
                FishCore fishCore = new FishCore();
                fishCore.GoGo();
                count2++;
            }


            if (count2 < 0) {
                theFish.fish();
                //           theFish.setFlag2(false);
                count2++;

            }

        }


    }


}

