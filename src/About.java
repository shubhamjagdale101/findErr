import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About {
    private JPanel abt;
    private JLabel Abt;
    private JButton OKButton;


    public About() {
        JFrame at=new JFrame("About");
        at.add(abt);

        at.setSize(400,200);
        at.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        at.setVisible(true);
        at.setLocation(300,300);
        Image icon= Toolkit.getDefaultToolkit().getImage("D:\\project_sy\\Prototype2\\iconn.jpeg");
        at.setIconImage(icon);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                at.dispose();
            }
        });
    }

    public static void main(String[] args){
        new About();
    }

}
