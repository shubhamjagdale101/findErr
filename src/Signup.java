import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;

public class Signup extends submit{
    private JTextField Usr;
    private JTextField Pass;
    private JButton creatAccountButton;
    private JTextArea Errors;

    private JPanel sup;

    public Signup() {


    }

    public void sgnup(){
        JFrame fr=new JFrame("New User");
        fr.add(sup);

        fr.setSize(400,400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        Image icon= Toolkit.getDefaultToolkit().getImage("D:\\project_sy\\Prototype2\\iconn.jpeg");
        fr.setIconImage(icon);

        creatAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usr=Usr.getText();
                String pas=Pass.getText();
                Errors.setText("");

                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","d423","d423");
                    String sl="select * from users where username=? ";
                    PreparedStatement sa=con.prepareStatement(sl);
                    sa.setString(1,Usr.getText());
                    //sa.setString(2,Pass.getText());

                    ResultSet r=sa.executeQuery();



                    if(r.next()){
                        System.out.println("User exits with id : " + r.getString(1));
                        Errors.append("Username Exists please select unique username\n");
                    }
                    else{
                        String in="insert into users values(uni_id.nextval,?,?)";
                        PreparedStatement itn=con.prepareStatement(in);
                        itn.setString(1,Usr.getText());
                        itn.setString(2,Pass.getText());
                        ResultSet s=itn.executeQuery();
                        new Accreat();
                        fr.dispose();
                        //System.out.println("User create with id: "+s.getString(1)+"Name: "+s.getString(2)+"Pass: "+s.getString(3));
                    }
                }catch (SQLException ex) {
                    throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args){
        Signup ss=new Signup();
        ss.sgnup();
    }
}
