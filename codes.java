import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Random;


public class HomePage extends javax.swing.JFrame {
     Timer t = new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e)
{ 
     Date d = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
     l5.setText("" + sdf.format(d));
     
}
    }
    );
    public HomePage() {
        initComponents();
    }
        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
CreateAcc Acc = new CreateAcc();
Acc.setVisible(true);
this.dispose();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
DetailsPage Log = new DetailsPage();
Log.setVisible(true);
this.dispose();

       
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
Tranfer tf= new Tranfer();
tf.setVisible(true);
this.dispose();
    }                                        

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
BankMan bm = new BankMan();
bm.setVisible(true);
this.dispose();
    }                                    

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
branches br = new branches();
br.setVisible(true);
this.dispose();
    }                                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
     t.start();
     SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
     Date d = new Date();
     dat.setText("DATE : "+ sdf2.format(d));
     SimpleDateFormat sdf3 = new SimpleDateFormat("E");
     Date d2 = new Date();
     day.setText("DAY : "+ sdf3.format(d2));
    }                                 

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
        private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     

    }                                    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Random r = new Random(); // create table users(acc_no bigint(15), F_name  varchar(20),L_name varchar(20), addres varchar(20) ,email varchar(25),mobno varchar(11),pass varchar(20),city varchar(20));
        int accNo = r.nextInt(999999999);
        String FirstName = t1.getText();
        String LastName = t2.getText();
        String UserName = t3.getText();
        String Add = t4.getText();
        String Email = t5.getText();
        String Mob = t6.getText();
        String pass = new String(p1.getPassword());
        String repass = new String(p2.getPassword());
        String city = c1.getSelectedItem().toString();

        if(Mob.length() == 10){l12.setText("");
            if(pass.equals(repass)){
                String Sql =("Insert into users values("+accNo+",'"+FirstName+("','")+LastName+("','")+UserName+("','")+Add+("','")+Email+("','")+Mob+("','")
                    +pass+("','")+city+("',")+0+(");"));
                String details = ("create table "+UserName+"(Date Date,TransType varchar(40),Amount decimal(10,2),balance decimal(10,2) default 0 );");
                System.out.println(""+Sql);
                System.out.println(""+details);
                try{
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
                    Statement stm = con.createStatement();
                    stm.executeUpdate(Sql);
                    stm.executeUpdate(details);
                    JOptionPane.showMessageDialog(rootPane, "you have successfully created an account :) and ur account no is : "+accNo);
                    DetailsPage Logs = new DetailsPage();
                    Logs.setVisible(true);
                    this.dispose();
                }
                catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
            } else{JOptionPane.showMessageDialog(rootPane, "Password dont match");}}
            else l12.setText("Invalid Number");

    }                                        

    private void t6KeyTyped(java.awt.event.KeyEvent evt) {                            
        // TODO add your handling code here:
    }                           

    private void t6KeyReleased(java.awt.event.KeyEvent evt) {                               

    }                              

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
if(jCheckBox1.isSelected() == true) 
    jButton1.setEnabled(true);
else if(jCheckBox1.isSelected() == false)
    jButton1.setEnabled(false);
    
    }                                          

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAcc().setVisible(true);
            }
        });
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
 String User = user.getText().trim();
       String Pass = new String(pass.getPassword());
         DefaultTableModel dm = (DefaultTableModel)T2.getModel();
          dm.setRowCount(0);
       try{
          DefaultTableModel dtm = (DefaultTableModel)T1.getModel();
          dtm.setRowCount(0);
          Class.forName("java.sql.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
           Statement st = con.createStatement();
           String sql =("Select * from users where username ='"+User+"';");
           ResultSet rs = st.executeQuery(sql);
           rs.first();
           String Username = rs.getString(4);
           String Password = rs.getString(8);

           if(User.equalsIgnoreCase(Username) && Pass.equals(Password))

           {
               wel.setText(("WELCOME "+rs.getString(2)+" "+rs.getString(3)));
           t1.setText(""+rs.getInt(1));
           t2.setText(""+rs.getString(2));
           t3.setText(""+rs.getString(3));
           t4.setText(""+rs.getString(4));
           t5.setText(""+rs.getString(5));
           t6.setText(""+rs.getString(6));
           t7.setText(""+rs.getString(7));
           t8.setText(""+rs.getString(9));
           t9.setText(""+rs.getString(10));
Object arr[] = {rs.getInt(1),rs.getString(2),rs.getString(4),rs.getDouble(10)};
dtm.addRow(arr);
           
          }
           else JOptionPane.showMessageDialog(rootPane, "Invalid UserName or Password");
       }
       catch(Exception e){JOptionPane.showMessageDialog(rootPane, "Invalid UserName");}
       edit.setEnabled(true);

    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
String User = user.getText().trim();
       String Pass = new String(pass.getPassword());
       try{
         DefaultTableModel dtm = (DefaultTableModel)T2.getModel();
          dtm.setRowCount(0);
           Class.forName("java.sql.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
           Statement st = con.createStatement();
           String sql =("Select username,password from users where username = '"+User+"';");
           ResultSet rs = st.executeQuery(sql);
           rs.first();
           String Username = rs.getString(1);
           String Password = rs.getString(2);
           String sql2 = ("Select * from "+Username+";");
           ResultSet trans = st.executeQuery(sql2);
           if(User.equalsIgnoreCase(Username) && Pass.equals(Password)){
               while(trans.next()){
Object arr[] = {trans.getDate(1),trans.getString(2),trans.getDouble(3),trans.getDouble(4)};
dtm.addRow(arr);}
           }
           else JOptionPane.showMessageDialog(rootPane, "Invalid UserName or Password");
       }
       catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }                                        

    private void editActionPerformed(java.awt.event.ActionEvent evt) {                                     
t2.setEditable(true);
t3.setEditable(true);
t5.setEditable(true);
t6.setEditable(true);
t7.setEditable(true);
t8.setEditable(true);
save.setEnabled(true);
    }                                    

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {                                     
try{
String Us = t4.getText();
String Fn = t2.getText();
String Ln = t3.getText();
String Ad = t5.getText();
String Em = t6.getText();
String Mn = t7.getText();
String Cy = t8.getText();
Class.forName("java.sql.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
Statement st = con.createStatement();
String sql = ("update users set firstname = '"+Fn+"',Lastname = '"+Ln+"',address = '"
        +Ad+"',email = '"+Em+"',Mob = "+Mn+",City = '"+Cy+"' where username = '"+Us+"';");
st.executeUpdate(sql);
}
catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
edit.setEnabled(false);
save.setEnabled(false);
t2.setEditable(false);
t3.setEditable(false);
t5.setEditable(false);
t6.setEditable(false);
t7.setEditable(false);
t8.setEditable(false);
JOptionPane.showMessageDialog(rootPane, "Changes Saved");
}                                    

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
Tranfer Tf = new Tranfer();
Tf.setVisible(true);
this.dispose();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
HomePage HM = new HomePage();
HM.setVisible(true);
this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailsPage().setVisible(true);
            }
        });
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     

    }                                    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
String us = user1.getText();
String US = User2.getText();
String pass = new String(pswd.getPassword());
int Accno = Integer.parseInt(AccNoR.getText());
Double amt = Double.parseDouble(Amt.getText());
try{
    Class.forName("java.sql.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
Statement st = con.createStatement();
Statement st2 = con.createStatement();
String Sql = "select * from users where username = '"+us+"';";
String Rec = "Select * from users where username = '"+US+"';";
ResultSet rs = st.executeQuery(Sql);
//ResultSet Recev = st.executeQuery(Rec);
rs.first();
//Recev.first();
String Us = rs.getString(4);
String Pass = rs.getString(8);
if(us.equalsIgnoreCase(Us) && pass.equals(Pass)){
    ResultSet Recev = st2.executeQuery(Rec);
    Recev.first();
    int AN = Recev.getInt(1);
    String US1 = Recev.getString(4);
    if(AN == Accno && US1.equalsIgnoreCase(US)){
      if(amt <= rs.getDouble(10)){
         double total = (rs.getDouble(10) - amt);
         double Total = (amt + Recev.getDouble(10));
        // int acno = Recev.getInt(1);
          String Update = "update users set balance = (balance - "+amt+") where username = '"+us+"';";
      String UpdateR = "update users set balance = (balance + "+amt+") where username = '"+US+"';";
      String update = "insert into "+us+" values(curdate(),'Transfered to "+Accno+"',"+amt+","+total+"); ";
      String updateR = "insert into "+US+" values(curdate(),'Transfered from "+Accno+"',"+amt+","+Total+"); ";
      st.executeUpdate(Update);
       st.executeUpdate(UpdateR);
        st.executeUpdate(update);
         st.executeUpdate(updateR);
         JOptionPane.showMessageDialog(rootPane, "Transaction Successful");
           }else JOptionPane.showMessageDialog(rootPane, "You dont have enough balanace in your Account");
    }else JOptionPane.showMessageDialog(rootPane, "Invalid Receiver username or Account Number");
}else JOptionPane.showMessageDialog(rootPane, "Invalid User Name or Password");

}
catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
HomePage Hp = new HomePage();
Hp.setVisible(true);
this.dispose();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
DetailsPage dp = new DetailsPage();
dp.setVisible(true);
this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tranfer().setVisible(true);
            }
        });
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   
String User = t3.getText();
   String Pass = new String(p1.getPassword());
       try{
           Class.forName("java.sql.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
           Statement st = con.createStatement();
           String sql =("Select * from bankman where username ='"+User+"';");
           ResultSet rs = st.executeQuery(sql);
           rs.first();
           String Username = rs.getString(3);
           String Password = rs.getString(4);
           if( Pass.equals(Password) && User.equalsIgnoreCase(Username))
           {JOptionPane.showMessageDialog(rootPane, ("Welcome "));
            BankIn BI = new BankIn();
   BI.setVisible(true);
   this.dispose();
           }
           else JOptionPane.showMessageDialog(rootPane, "Invalid UserName or Password");
       }
       catch(Exception e){JOptionPane.showMessageDialog(rootPane, "Invalid UserName");}
  
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       HomePage Hm = new HomePage();
       Hm.setVisible(true);
       this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankMan().setVisible(true);
            }
        });
    }
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
      String user = ""+t1.getText();
      String In = ""+t2.getText();
     if(In.equals(""))
         In = "0";
      try{
      DefaultTableModel dtm = (DefaultTableModel)info.getModel();
      dtm.setRowCount(0);
      Class.forName("java.sql.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
      Statement st = con.createStatement();
      String sql =("Select AccNo,firstname,lastname,username,balance from users where AccNo = "+In+" or where username = '"+user+"';");
      System.out.println(""+sql);
      ResultSet rs = st.executeQuery(sql);
             
     rs.first();
      Object arr[] = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
      dtm.addRow(arr);
      String Hm = rs.getString(4);
      DefaultTableModel dm = (DefaultTableModel)trans.getModel();
      dm.setRowCount(0);
      ResultSet tr = st.executeQuery("select * from "+Hm+";");
      while(tr.next()){
      Object arrr[] ={tr.getDate(1),tr.getString(2),tr.getDouble(3),tr.getDouble(4)};
      dm.addRow(arrr);
                    }
      }
       catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.getMessage());}
}                                  

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {                                   
      String acc = t1.getText().trim();

       Double balance = Double.parseDouble(amt.getText());
       try{
           Class.forName("java.sql.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking","root","1234");
           Statement st = con.createStatement();
           String sql =("Select * from users where accno ='"+acc+"';");
           ResultSet rs = st.executeQuery(sql);
           rs.first();
           String name = rs.getString(4);
           double total = (balance+rs.getDouble(10));
           String Usql = ("update users set balance = ( balance+"+balance+") where accno = '"+acc+"';");
           String Tsql = ("insert into "+name+" values(curdate(),'Deposited',"+balance+","+total+"); ");
          st.executeUpdate(Usql);
          st.executeUpdate(Tsql);
          JOptionPane.showMessageDialog(rootPane, "Transaction Completed");

           
       }
       catch(Exception e){JOptionPane.showMessageDialog(rootPane, "Invalid UserName or Password");}
}                                  

    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     

    }                                    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankIn().setVisible(true);
            }
        });
    }
