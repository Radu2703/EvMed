import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EmployeeAddition extends JFrame
{private JButton add, cancel;
 private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
 private EmployeeAdditionController c;
 private JOptionPane pab;
public EmployeeAddition()
{super("Employee Addition");
 JPanel p=new JPanel();
 p.setLayout(new GridLayout(9, 2, 10, 10));
 p.add(new Label("CNP"));
 tf1=new JTextField(10);
 p.add(tf1);
 p.add(new Label("Surname"));
 tf2=new JTextField(10);
 p.add(tf2);
 p.add(new Label("Name"));
 tf3=new JTextField(10);
 p.add(tf3);
 p.add(new Label("Email"));
 tf4=new JTextField(10);
 p.add(tf4);
 p.add(new Label("County"));
 tf5=new JTextField(10);
 p.add(tf5);
 p.add(new Label("City"));
 tf6=new JTextField(10);
 p.add(tf6);
 p.add(new Label("Role"));
 tf7=new JTextField(10);
 p.add(tf7);
 p.add(new Label("Phone Number"));
 tf8=new JTextField(10);
 p.add(tf8);
 c=new EmployeeAdditionController();
 add=new JButton("Add employee");
 add.addActionListener(c);
 p.add(add);
 cancel=new JButton("Cancel");
 cancel.addActionListener(c);
 p.add(cancel);
 add(p);
 setLocation(600,200);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {dispose();}
 });
 cancel.addActionListener(e->{
  tf1.setText(null);
  tf2.setText(null);
  tf3.setText(null);
  tf4.setText(null);
  tf5.setText(null);
  tf6.setText(null);
  tf7.setText(null);
  tf8.setText(null);
 });
}
class EmployeeAdditionController implements ActionListener
{@Override
public void actionPerformed(ActionEvent e)
{String et=e.getActionCommand();
 if(et.equals("Add employee"))
{if(tf1.getText().trim().length()<=0||tf2.getText().trim().length()<=0||tf3.getText().trim().length()<=0||tf4.getText().trim().length()<=0||tf5.getText().trim().length()<=0||tf6.getText().trim().length()<=0||tf7.getText().trim().length()<=0||tf8.getText().trim().length()<=0)
        JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().charAt(0)<'0'||tf1.getText().trim().charAt(0)>'9')
        JOptionPane.showMessageDialog(pab,"Error!\nCNP has to start with a digit!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().charAt(0)=='0'||tf1.getText().trim().charAt(0)=='9')
        JOptionPane.showMessageDialog(pab,"Error!\nCNP can not start with digit 0 or 9!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(EmployeeManager.uniqueCNP(tf1.getText().trim())==false)
        JOptionPane.showMessageDialog(pab,"Error!\nYou have already entered an employee with the same CNP!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(EmployeeManager.uniqueEmail(tf4.getText().trim())==false)
        JOptionPane.showMessageDialog(pab,"Error!\nYou have already entered an employee with the same email!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(EmployeeManager.uniquePhoneNumber(tf8.getText().trim())==false)
        JOptionPane.showMessageDialog(pab,"Error!\nYou have already entered an employee with the same phone number!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().length()!=13)
        JOptionPane.showMessageDialog(pab,"Error!\nCNP must have exactly 13 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf2.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nSurname cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf3.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nName cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf4.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nEmail cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf5.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nCounty cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf6.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nCity cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf7.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nRole cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf8.getText().trim().length()!=10)
        JOptionPane.showMessageDialog(pab,"Error!\nPhone number must have exactly 10 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf4.getText().trim().contains("@")==false)
        JOptionPane.showMessageDialog(pab,"Error!\nEmail must have the @ character! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf4.getText().trim().startsWith("@")||tf4.getText().trim().endsWith("@"))
        JOptionPane.showMessageDialog(pab,"Error!\nEmail must have a name and a domain (characters before and after @)! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else{try 
   {long pnc=Long.parseLong(tf1.getText().trim());
    long pnca=pnc/10;
    long pn=Long.parseLong(tf8.getText().trim());
    char gen=tf1.getText().trim().charAt(0);
    String gender;
    String year = tf1.getText().trim().substring(1, 3);
    String month = tf1.getText().trim().substring(3, 5);
    String day = tf1.getText().trim().substring(5, 7);
    if (gen>'4') year="20".concat(year);
     else if (gen<'3') year="19".concat(year);
       else year="18".concat(year);
    if(gen=='1'||gen=='3'||gen=='5'||gen=='7') gender="Male";
       else gender="Female";
    String cheie="279146358279";
    long suma=0;
    long ch=Long.parseLong(cheie);
    for (int i=1; i<=12; i++)
      {suma+=(pnca%10)*(ch%10); pnca/=10; ch/=10;}
    suma%=11; suma=(suma==10)?1:suma;
    int y=Integer.parseInt(year);
    int m=Integer.parseInt(month);
    int d=Integer.parseInt(day);
    if(m<1||m>12)
        JOptionPane.showMessageDialog(pab,"Error!\nMonth in CNP is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(d<1||d>31)
        JOptionPane.showMessageDialog(pab,"Error!\nDay in CNP is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if((m==2&&d>28&&y%4!=0)||(m==2&&d>29&&y%4==0)||(m==4&&d>30)||(m==6&&d>30)||(m==9&&d>30)||(m==11&&d>30))
        JOptionPane.showMessageDialog(pab,"Error!\nMonth and day combination in CNP is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if (pnc%10!=suma)
        JOptionPane.showMessageDialog(pab,"Error!\nControl digit in CNP is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else{
    String password=day.concat("-").concat(month).concat("-").concat(year);
    if(password.length()!=10)
       JOptionPane.showMessageDialog(pab,"Error!\nPassword must have exactly 10 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else{
    EmployeeManager.memorize(tf1.getText().trim(),tf2.getText().trim(),tf3.getText().trim(),tf4.getText().trim(),password,tf5.getText().trim(),tf6.getText().trim(),tf7.getText().trim(),tf8.getText().trim(), gender);
    String message="You have registered an employee with the following data (CNP, Surname, Name, Email, Password, County, City, Role, Phone Number, Gender):\n".concat(EmployeeManager.searchCNP(tf1.getText()));
    JOptionPane.showMessageDialog(pab, message,"Information",JOptionPane.INFORMATION_MESSAGE);}
   }}
 catch (NumberFormatException er)
  {JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the CNP field and the phone number field with an integer number!", "Reminder", JOptionPane.WARNING_MESSAGE);}
   }
  }
 }
 }
}