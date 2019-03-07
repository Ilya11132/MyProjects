import javax.swing.*;

public class FishCore {


    private static final int TIME_OUT = 3;
    public static int count = 0;
    private static boolean flag;
    private final JOptionPane optPane = new JOptionPane();
    private JDialog dialog = new JDialog();

    public void GoGo() {


        JFrame frame;
        frame = new JFrame("Рыбалка");

        frame.setBounds(600, 300, 600, 410);//Если не выставить  размер и положение то окно будет мелкое и незаметное
        frame.setResizable(false);

        optPane.setMessage("Поймааааал!!!!");
        optPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        optPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        dialog.add(optPane);
        dialog.pack();


        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);


    }


}
