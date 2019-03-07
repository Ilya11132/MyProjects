import javax.swing.*;
import java.awt.*;

public class BaseImage extends JPanel {
    public void paintComponent(Graphics g) {

        Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/2177255977-612x612.jpg").getImage();
        g.drawImage(image, 0, 0, this);

    }

    static class BaseImage2 extends JPanel {
        public void paintComponent(Graphics g) {

            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/82802817.jpg").getImage();
            g.drawImage(image, 0, 0, this);

        }
    }

    static class BaseImage3 extends JPanel {
        public void paintComponent(Graphics g) {

            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/vodoem.jpeg").getImage();
            g.drawImage(image, 0, 0, this);

        }
    }
    static class BaseImage4 extends JPanel {
        public void paintComponent(Graphics g) {

            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/Carta2.jpg").getImage();
            g.drawImage(image, 0, 0, this);

          //  Font font = new Font("Verdana", Font.PLAIN, 22);
          //  g.setFont(font);

        }
    }

     class imageShape extends JPanel {
        public void paintComponent(Graphics g) {


            Image image = new ImageIcon("D:\\JDK\\Java\\Fishing\\GUIFishing\\src/vodoem.jpeg").getImage();
            g.drawImage(image, 0, 0, this);

           g.setColor(Color.red);
          // g.fillOval(Fishing.xx,Fishing.yy,100,100);
        }
    }







}