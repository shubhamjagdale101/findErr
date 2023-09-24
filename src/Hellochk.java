import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Objects;
import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class Hellochk  extends Signup {
    private JPanel pan;
    private JPanel paan;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField Log;
    private JTextField pass;
    private JButton submit;
    private JTextArea Status;
    private JButton Sign_up;


   /* public Hellochk() {
        JFrame subm =new JFrame("Submit Details");
        subm.setVisible(true);
        subm.setSize(600,600);
        subm.add(paan);
        subm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submitted::\n");
            }
        });
    }*/


    public Hellochk() {


    }


    public void Hello() {


        JFrame f=new JFrame("FindErr");
        f.add(pan);

        JMenuBar mb= new JMenuBar();
        JMenuItem abt=new JMenuItem("About");
        JMenu fl=new JMenu("File");
        fl.add(abt);
        mb.add(fl);
        f.getContentPane().add(BorderLayout.NORTH,mb);

        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        Image icon= Toolkit.getDefaultToolkit().getImage("D:\\project_sy\\Prototype2\\iconn.jpeg");
        f.setIconImage(icon);



        abt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new About();
            }
        });

        Sign_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Signup initiated");
                Signup su=new Signup();
                su.sgnup();
                f.dispose();
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Status.setText("");
                //String lg=Log.getText();
                System.out.println(Log.getText());
                if (Objects.equals(Log.getText(), "system")) {
                    System.out.println(" user name correct!");

                }
                String pa = pass.getText();
                /*if (Objects.equals(pa, "system")) {
                    System.out.println(" Pass name correct!");
                    f.dispose();
                    submit s = new submit();
                    s.subm();
                } else {
                    Status.append("Wrong Password or user name\n");
                }*/
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    //Connection DriverManager = null;
                    Connection conn= DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:ORCL","d423","d423");
                    String sql="select * from users where username=? and password=?";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setString(1,Log.getText());
                    ps.setString(2,pass.getText());

                    ResultSet rs=ps.executeQuery();
                    if (rs.next()) {
                        System.out.println(" Pass name correct!");
                        f.dispose();
                        new Aboutur();

                       /* submit s = new submit();
                        s.subm(Log.getText());*/

                    } else {
                        Status.append("Wrong Password or username please try again\n");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }



            }

            });


    }


    public static void nwde(){
        Hellochk m= new Hellochk();
        m.Hello();
    }


    public static void main(String[] args){

        nwde();
    }


}
