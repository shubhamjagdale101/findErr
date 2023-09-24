import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accreat {
    private JButton next;
    private JPanel crt;

    public Accreat() {

        JFrame f=new JFrame("Hello it");
        f.add(crt);

        f.setSize(400,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocation(300,300);
        Image icon= Toolkit.getDefaultToolkit().getImage("D:\\project_sy\\Prototype2\\iconn.jpeg");
        f.setIconImage(icon);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit s =new submit();
                s.subm();
                f.dispose();

            }
        });
    }

    public static void main(String[] args){
        new Accreat();
    }
}
