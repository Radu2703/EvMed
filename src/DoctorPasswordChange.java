import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class DoctorPasswordChange extends JFrame{
    private String cnp;
    private JPanel p1;
    private JLabel email,opw,npw;
    private JTextField tf1,tf2,tf3;
    private JButton b;
    private JOptionPane pab;
    private DoctorPasswordChangeController cont;
public DoctorPasswordChange(String c){
    super("Doctor Password Change");
    cnp=c;
    cont=new DoctorPasswordChangeController();
    cont.setCNP(c);
    email=new JLabel("Enter your email");
    opw=new JLabel("Enter your current password");
    npw=new JLabel("Enter your new password");
    tf1=new JTextField(10);
    tf2=new JTextField(10);
    tf3=new JTextField(10);
    b=new JButton("Change password");
    b.addActionListener(cont);
    p1=new JPanel();
    p1.setLayout(new GridLayout(3,2,5,5));
    p1.add(email); p1.add(tf1); p1.add(opw); p1.add(tf2); p1.add(npw); p1.add(tf3);
    setLayout(new GridLayout(2,1,5,5));
    add(p1); add(b);
    setLocation(500,200);
    addWindowListener(new WindowAdapter()
    {@Override
    public void windowClosing(WindowEvent e)
    {tf1.setText(null);
     tf2.setText(null);
     tf3.setText(null);
     dispose();}
    });
}
class DoctorPasswordChangeController implements ActionListener
{private String cnp;
 public void setCNP(String c){cnp=c;}
 @Override
public void actionPerformed(ActionEvent e){
  String et=e.getActionCommand();
  if(et.equals("Change password")){
    if(tf1.getText().trim().length()<=0||tf2.getText().trim().length()<=0||tf3.getText().trim().length()<=0)
      JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(DoctorManager.uniqueCNP(cnp))
        JOptionPane.showMessageDialog(pab,"Error!\nCNP is not in the database!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(DoctorManager.uniqueEmail(tf1.getText().trim()))
        JOptionPane.showMessageDialog(pab,"Error!\nEmail is not in the database!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(!DoctorManager.emailPass(tf1.getText().trim()).equals(tf2.getText().trim()))
        JOptionPane.showMessageDialog(pab,"Error!\nCurrent password is not used by the specified email!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else if(tf3.getText().trim().length()>50)
        JOptionPane.showMessageDialog(pab,"Error!\nNew password cannot be longer than 50 characters!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else
    {DoctorManager.modifyPassword(tf1.getText().trim(),tf2.getText().trim(),tf3.getText().trim());
     String message="The doctor with email ".concat(DoctorManager.searchEmailbyCNP(cnp).concat(" now has password ").concat(DoctorManager.searchPasswordbyCNP(cnp)));
     JOptionPane.showMessageDialog(pab, message,"Information",JOptionPane.INFORMATION_MESSAGE);
     //SendEmail.send(tf1.getText().trim(), "Password change", "Your password for the medical history application has been successfully changed!");
     dispose();}
  }
 }
}
}
