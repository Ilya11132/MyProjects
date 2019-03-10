import javax.swing.*;
import java.util.TimerTask;

public class SimpleAnimation extends JPanel {           // Класс для воспроизведения аниммацции. В данный момент не используется
    static JFrame frame;

    public static void main(String[] args) {
        SimpleAnimation start = new SimpleAnimation();
        start.end();
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
        }
        start.end();
    }

    public static void end() {
        frame.setVisible(false);
        new Thread() {
            SimpleAnimation start = new SimpleAnimation();
            public void run() {
                start.begin();
            }
        }.start();
    }

    public void begin() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600, 300, 600, 410);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(SimpleAnimation.this, "Должно само закрыться через " +
                "3 сек. после запуска!");
        new java.util.Timer().schedule(
                new TimerTask() {
                    public void run() {
                        end();
                    }
                },
                4000);
    }

}