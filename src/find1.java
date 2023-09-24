import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class find1 {
    private JPanel fnd;
    private JTextField prof;
    private JButton srh;
    private JTextArea searchResultsWillBeTextArea;

    public find1() {
        srh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection crc= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","d423","d423");

                     String fnd="Select * from information where id in (select id from profression where p_name like %?%)";
                    PreparedStatement fn=crc.prepareStatement(fnd);
                    fn.setString(1,prof.getText());

                    ResultSet fd=fn.executeQuery();
                    int flag=0;

                    while(fd.next()){
                       /* String nm="Select * from information where id in (select id from profression where p_name=?)";
                        PreparedStatement pr=crc.prepareStatement(nm);
                        pr.setString(1,prof.getText());
                        ResultSet rr=pr.executeQuery();*/


                        System.out.println("Name:"+fd.getString(2));

                    }

                    if(flag==0){
                        System.out.println("No result found");
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

    }
}
