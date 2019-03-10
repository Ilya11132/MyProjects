import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;

class TheFish {                                                                                // Выдает инф. сообщение через 3-5 сек, что рыба клюет, через три сек пропадает

    private static final int TIME_OUT = 3;
    private static boolean flag;
    private final JOptionPane optPane = new JOptionPane();
    private int count = TIME_OUT;
    private JDialog dialog = new JDialog();
    private final Timer timer = new Timer(1000, this::actionPerformed);

    void fish() {                                                                                // Через рандомное время запускаем метод для выдачи сообщения "Клюет тяни!"
        int time = randomTimeOfWaiting();
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
        }
        // JOptionPane.showMessageDialog(TheFish.this, "Однозначно клюёт!!!Пора тянуть!");
        TheFish theFish = new TheFish();
        theFish.createGUI();
    }

    private int randomTimeOfWaiting() {                                                           // Задаем рандомное время
        double a;
        a = 2500 + Math.random() * 7000;
        return (int) a;
    }

    private void createGUI() {                                                                   // Через рандомное время на нашем фреймме появляется сообщение "Клюет тяни!" на 3 сек
        this.setFlag2(true);
        JFrame frame;
        frame = new JFrame("Рыбалка");
        frame.setBounds(600, 300, 600, 410);                                     //Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.setResizable(false);
        timer.setCoalesce(false);
        optPane.setMessage("Клюет! Тяни!");
        optPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        optPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        optPane.addPropertyChangeListener(this::propertyChange);
        dialog.add(optPane);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        timer.start();
        this.setFlag2(true);
    }

    boolean getFlag2() {                                                                            // Флаги, чтобы метод вызвался всего один раз, а не каждый раз, когда жмешь на кнопку
        return flag;
    }

    private void setFlag2(boolean b) {
        flag = b;
    }

    private void propertyChange(PropertyChangeEvent e) {                                          // Тоже метод  для нашего сообщения
        setFlag2(true);
        String prop = e.getPropertyName();
        if (JOptionPane.VALUE_PROPERTY.equals(prop)) {
            thatsAllFolks();
        }
    }

    private void actionPerformed(ActionEvent e) {                                               // Тоже метод  для нашего сообщения
        count--;
        optPane.setMessage("Клюет! Тяни!");
        if (count == 0) {
            //  setFlag2(false);
            thatsAllFolks();
        }

    }

    private void thatsAllFolks() {                                                              //  Метод  для нашего сообщения, который закроет окно через 3 сек
        if (count == 0) {
            setFlag2(false);
            dialog.setVisible(false);
            dialog.dispatchEvent(new WindowEvent(
                    dialog, WindowEvent.WINDOW_CLOSING));
        }
    }

}
