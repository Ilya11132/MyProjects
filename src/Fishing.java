import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Fishing extends JPanel {
    private static JFrame frame;
    private int count2 = 0;

    void fishing() {                                                    // Интерфейс нашего водоема с размещенными кнопками
        JButton button11 = new JButton();
        {
            button11.setText("Достать");
        }

        button11.addActionListener(new listenerCatch());
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
        JButton buttonExit = new JButton("Выход");
        buttonExit.addActionListener(new listenerGoBackMainMenu());
        buttonExit.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, color));
        buttonExit.setBounds(313, 331, 90, 35);
        imageShape.add(buttonExit);
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

 /*    public class ImageArrangement extends JPanel {                             // Графические методы для перемещения поплавка
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/vodoem.jpeg").getImage();
            g.drawImage(image, 0, 0, this);
            g.setColor(Color.red);
            g.fillOval(250, 221, 20, 20);
        }
    }

         class buttonListenerComeBack2 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            TheFish theFish = new TheFish();
            theFish.fish();
        }
    }
*/

    public class ImageShape extends JPanel {                               // Рисуем закинутый поплавок (Красный круг)
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/vodoem.jpeg").getImage();
            g.drawImage(image, 0, 0, this);
            g.setColor(Color.red);
            int yy = 230;
            int xx = 330;
            g.fillOval(xx, yy, 20, 20);
        }
    }

    class listenerGoBackMainMenu implements ActionListener {              // Назад, в главное меню
        public void actionPerformed(ActionEvent event) {
            //  !!!     if (flag !=true) {System.exit(0);}
            frame.setVisible(false);
            GUIFishing guiFishing = new GUIFishing();
            guiFishing.mainMenu();
        }
    }

    class listenerCatch implements ActionListener {                    // Ловим рыбу
        public void actionPerformed(ActionEvent event) {
            TheFish theFish = new TheFish();
            if (theFish.getFlag2() & count2 == 0) {
                // System.exit(0);
                FishCore fishCore = new FishCore();
                fishCore.hereTheFish();
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

