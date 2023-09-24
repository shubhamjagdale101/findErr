import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class Aboutur {
    private JPanel abur;
    private JTextField Name;
    private JTextField Prof;
    private JTextField scp;
    private JButton fbprof;
    private JButton fbadd;
    private JTextField address;

    public Aboutur() {
        JFrame jf=new JFrame("Finderr");
        jf.add(abur);

        JMenuBar mb= new JMenuBar();
        JMenuItem abt=new JMenuItem("About");
        JMenuItem edt=new JMenuItem("Edit");
        JMenu fl=new JMenu("File");
        fl.add(abt);fl.add(edt);
        mb.add(fl);
        jf.getContentPane().add(BorderLayout.NORTH,mb);
        JMenuItem so=new JMenuItem("Sign out");
        JMenu act=new JMenu("Account");
        act.add(so);
        mb.add(act);

        so.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hellochk hk=new Hellochk();
                hk.Hello();
                jf.dispose();
            }
        });

        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        Image icon= Toolkit.getDefaultToolkit().getImage("D:\\project_sy\\Prototype2\\iconn.jpeg");
        jf.setIconImage(icon);

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Connection DriverManager = null;
            Connection conn= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:ORCL","d423","d423");
        }catch (Exception Sql){

        }

        abt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });

        edt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit st=new submit();
                st.subm();
                jf.dispose();
            }
        });

        fbprof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        new Aboutur();
    }
}
