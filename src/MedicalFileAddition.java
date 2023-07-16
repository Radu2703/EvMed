import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class MedicalFileAddition extends JFrame
{private JButton add, cancel;
 private JTextField tf1, tf4, tf5, tf6, tf7, tf8, tf9, tf10;
 private MedicalFileAdditionController c;
 private JOptionPane pab;
public MedicalFileAddition()
{super("Medical File Addition");
 JPanel p=new JPanel();
 p.setLayout(new GridLayout(9, 2, 5, 1));
 p.add(new Label("Employee CNP"));
 tf1=new JTextField(10);
 p.add(tf1);
 p.add(new Label("Date (format: YYYY-MM-DD)"));
 tf4=new JTextField(10);
 p.add(tf4);
 p.add(new Label("Building"));
 tf5=new JTextField(10);
 p.add(tf5);
 p.add(new Label("Street"));
 tf6=new JTextField(10);
 p.add(tf6);
 p.add(new Label("City"));
 tf7=new JTextField(10);
 p.add(tf7);
 p.add(new Label("County"));
 tf8=new JTextField(10);
 p.add(tf8);
 p.add(new Label("Doctor"));
 tf9=new JTextField(10);
 p.add(tf9);
 p.add(new Label("Doctor Phone Number"));
 tf10=new JTextField(10);
 p.add(tf10);
 c=new MedicalFileAdditionController();
 add=new JButton("Add medical file");
 add.addActionListener(c);
 p.add(add);
 cancel=new JButton("Erase data");
 cancel.addActionListener(c);
 p.add(cancel);
 add(p);
 setLocation(500,200);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {dispose();}
 });
 cancel.addActionListener(e->{
  tf1.setText(null);
  tf4.setText(null);
  tf5.setText(null);
  tf6.setText(null);
  tf7.setText(null);
  tf8.setText(null);
  tf9.setText(null);
  tf10.setText(null);
 });
}
class MedicalFileAdditionController implements ActionListener
{private JFrame lab;
 @Override
public void actionPerformed(ActionEvent e)
{String et=e.getActionCommand();
 if(et.equals("Add medical file"))
{if(tf1.getText().trim().length()<=0||tf4.getText().trim().length()<=0||tf5.getText().trim().length()<=0||tf6.getText().trim().length()<=0||tf7.getText().trim().length()<=0||tf8.getText().trim().length()<=0||tf9.getText().trim().length()<=0||tf10.getText().trim().length()<=0)
        JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().contains("//")||tf4.getText().trim().contains("//")||tf5.getText().trim().contains("//")||tf6.getText().trim().contains("//")||tf7.getText().trim().contains("//")||tf8.getText().trim().contains("//")||tf9.getText().trim().contains("//")||tf10.getText().trim().contains("//"))
        JOptionPane.showMessageDialog(pab,"Error!\nYou cannot have \"//\" in the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(EmployeeManager.uniqueCNP(tf1.getText().trim()))
        JOptionPane.showMessageDialog(pab,"Error!\nCNP of employee not in the database!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().charAt(0)<'0'||tf1.getText().trim().charAt(0)>'9')
        JOptionPane.showMessageDialog(pab,"Error!\nCNP has to start with a digit!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().charAt(0)=='0'||tf1.getText().trim().charAt(0)=='9')
        JOptionPane.showMessageDialog(pab,"Error!\nCNP can not start with digit 0 or 9!", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf1.getText().trim().length()!=13)
        JOptionPane.showMessageDialog(pab,"Error!\nCNP must have exactly 13 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf4.getText().trim().length()!=10)
        JOptionPane.showMessageDialog(pab,"Error!\nDate must have exactly 10 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf5.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nnBuilding cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf6.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nStreet cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf7.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nCity cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf8.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nCounty cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf9.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nDoctor cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else if(tf10.getText().trim().length()!=10)
        JOptionPane.showMessageDialog(pab,"Error!\nDoctor phone number must have exactly 10 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
 else{try 
   {long pnc=Long.parseLong(tf1.getText().trim());
    long pnca=pnc/10;
    long pn=Long.parseLong(tf10.getText().trim());
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
    Integer yy = Integer.valueOf(tf4.getText().trim().substring(0, 4));
    char l1 = tf4.getText().trim().charAt(4);
    Integer mm = Integer.valueOf(tf4.getText().trim().substring(5, 7));
    char l2 = tf4.getText().trim().charAt(7);
    Integer dd = Integer.valueOf(tf4.getText().trim().substring(8, 10));
    if(mm<1||mm>12)
       JOptionPane.showMessageDialog(pab,"Error!\nMonth in date is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(dd<1||dd>31)
        JOptionPane.showMessageDialog(pab,"Error!\nDay in date is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if((mm==2&&dd>28&&yy%4!=0)||(mm==2&&dd>29&&yy%4==0)||(mm==4&&dd>30)||(mm==6&&dd>30)||(mm==9&&dd>30)||(mm==11&&dd>30))
        JOptionPane.showMessageDialog(pab,"Error!\nMonth and day combination in date is not valid! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(l1!='-'||l2!='-') 
        JOptionPane.showMessageDialog(pab,"Error!\nDate formatting is not valid (use - between parts)! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else{
    MedicalFileManager.memorize(tf1.getText().trim(),tf4.getText().trim(),tf5.getText().trim(),tf6.getText().trim(),tf7.getText().trim(),tf8.getText().trim(),tf9.getText().trim(),tf10.getText().trim());
    String message="You have registered a medical file with the following data (ID, Employee CNP, Date, Building, Street, City, County, Doctor, Doctor Phone Number):\n".concat(MedicalFileManager.searchCNP_Date(tf1.getText().trim(),tf4.getText().trim()));
    JOptionPane.showMessageDialog(pab, message,"Information",JOptionPane.INFORMATION_MESSAGE);
    if(lab==null)lab=new HiringLabAnalysisAddition(MedicalFileManager.searchID(tf1.getText().trim(),tf4.getText().trim()),tf1.getText().trim());
    lab.pack();
    lab.setLocation(500, 200);
    lab.setVisible(true);
    }}}
 catch (NumberFormatException er)
  {JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the CNP field and the doctor phone number field with an integer number!\nAnd you need to fill the date field with the appropriate format!", "Reminder", JOptionPane.WARNING_MESSAGE);}
   }
  }
 }
 }
}