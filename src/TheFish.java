import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;

public class TheFish {

    private static final int TIME_OUT = 3;
    private static boolean flag;
    private final JOptionPane optPane = new JOptionPane();

    ;
    boolean g;
    boolean f;
    private int count = TIME_OUT;
    private JDialog dialog = new JDialog();
    private final Timer timer = new Timer(1000, this::actionPerformed);
    TheFish() {
        g = getFlag2();
    }

    public boolean fish() {

        int time = randomTimeOfWaiting();

        try {
            Thread.sleep(time);
        } catch (Exception ex) {
        }


        // JOptionPane.showMessageDialog(TheFish.this, "Однозначно клюёт!!!Пора тянуть!");

        TheFish test = new TheFish();
        test.createGUI();


        return true;


    }

    int randomTimeOfWaiting() {

        double a;
        a = 2500 + Math.random() * 7000;
        return (int) a;
    }

    public void createGUI() {
        this.setFlag2(true);
        JFrame frame;
        frame = new JFrame("Рыбалка");

        frame.setBounds(600, 300, 600, 410);//Если не выставить  размер и положение то окно будет мелкое и незаметное
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

    public boolean getFlag2() {
        return flag;
    }

    public void setFlag2(boolean b) {
        flag = b;
    }

    public void propertyChange(PropertyChangeEvent e) {
        setFlag2(true);
        String prop = e.getPropertyName();
        if (JOptionPane.VALUE_PROPERTY.equals(prop)) {
            thatsAllFolks();
        }
    }

    public void actionPerformed(ActionEvent e) {

        count--;
        optPane.setMessage("Клюет! Тяни!");


        if (count == 0) {
            //  setFlag2(false);
            thatsAllFolks();
        }


    }


    private void thatsAllFolks() {
        if (count == 0) {
            setFlag2(false);

            dialog.setVisible(false);
            dialog.dispatchEvent(new WindowEvent(
                    dialog, WindowEvent.WINDOW_CLOSING));

        }
    }


    class buttonListenerComeBack22 implements ActionListener {
        public void actionPerformed(ActionEvent event) {


        }
    }


}
