import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
public class LoginFrame extends JFrame {
    private JLabel l1,l2;
    private JLabel email,pass,mes;
    private JTextField t1,t2;
    private JButton b1,b2;
    private JRadioButton emp, admin, doct;
    private ButtonGroup g;
    private JPanel p1,p2;
    private LoginController lc;
    private JFrame re;
public LoginFrame(){
    super("Login and register window");
    lc=new LoginController();
    l1=new JLabel("Login window");
    l2=new JLabel("Register window");
    email=new JLabel("Email");
    pass=new JLabel("Password: dd-mm-yyyy (if not changed already, which is recommended)");
    mes=new JLabel("There are no administrators registered in the database!");
    t1=new JTextField();
    t2=new JTextField();
    emp=new JRadioButton("Employee");
    admin=new JRadioButton("Admin");
    doct=new JRadioButton("Doctor");
    g=new ButtonGroup();
    g.add(admin); g.add(emp); g.add(doct);
    b1=new JButton("Login");
    b2=new JButton("Register as administrator (press button again afterwards)");
    b1.addActionListener(lc);
    b2.addActionListener(lc);
    p1=new JPanel(); p2=new JPanel();
    p1.setLayout(new GridLayout(2, 2, 5, 5));
    p2.setLayout(new GridLayout(3, 1, 5, 5));
    p1.add(email); p1.add(t1);
    p1.add(pass); p1.add(t2);
    p2.add(emp); p2.add(admin); p2.add(doct);
    setLayout(new GridLayout(4, 1, 10, 10));
    if(AdministratorManager.counter()){
        add(l1); add(p1); add(p2); add(b1);
    }
    else{
        add(l2); add(mes); add(b2);
    }
    b2.addActionListener(e->{
     if(!AdministratorManager.counter())
        {if (re==null)re=new AdministratorAddition();
         re.pack();
         re.setVisible(true);}
     else{
         remove(b2); remove(mes); remove(l2);
         add(l1); add(p1); add(p2); add(b1);
         repaint();
         pack();
     }
    });
  }

private class LoginController implements ActionListener
{private JFrame em, ad, doc;
 private JOptionPane warn;
 public void actionPerformed(ActionEvent e)
 {if(e.getSource()==b1){
   if(t1.getText().trim().length()<=0||t2.getText().trim().length()<=0)
     JOptionPane.showMessageDialog(warn,"Error!\nBoth email and password must be filled!", "Reminder", JOptionPane.WARNING_MESSAGE);
   else if(t1.getText().trim().length()>50)
        JOptionPane.showMessageDialog(warn,"Error!\nEmail cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
   else if(t2.getText().trim().length()>50)
        JOptionPane.showMessageDialog(warn,"Error!\nPassword cannot have more than 50 characters! ", "Reminder", JOptionPane.WARNING_MESSAGE);
   else if(t1.getText().trim().contains("@")==false)
        JOptionPane.showMessageDialog(warn,"Error!\nEmail must have the @ character! ", "Reminder", JOptionPane.WARNING_MESSAGE);
   else if(t1.getText().trim().startsWith("@")||t1.getText().trim().endsWith("@"))
        JOptionPane.showMessageDialog(warn,"Error!\nEmail must have a name and a domain (characters before and after @)! ", "Reminder", JOptionPane.WARNING_MESSAGE);
   else if (emp.isSelected())
   {if(EmployeeManager.searchEmailPassLog(t1.getText().trim(), t2.getText().trim())==false)
       JOptionPane.showMessageDialog(warn,"Error!\nThere is no employee with this email and password combination!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else{em=new EmployeeFrame(EmployeeManager.searchEmailPassCNP(t1.getText().trim(),t2.getText().trim()));
         em.pack();
         em.setLocation(500, 200);
         em.setVisible(true);
         t1.setText(null);
         t2.setText(null);
         emp.setSelected(false);}
    }
   else if (admin.isSelected())
   {if(AdministratorManager.searchEmailPassLog(t1.getText().trim(), t2.getText().trim())==false)
       JOptionPane.showMessageDialog(warn,"Error!\nThere is no administrator with this email and password combination!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else{ad=new AdminFrame(AdministratorManager.searchEmailPassCNP(t1.getText().trim(),t2.getText().trim()));
         ad.pack();
         ad.setLocation(400, 200);
         ad.setVisible(true);
         t1.setText(null);
         t2.setText(null);
         admin.setSelected(false);}
    }
   else if (doct.isSelected())
   {if(DoctorManager.searchEmailPassLog(t1.getText().trim(), t2.getText().trim())==false)
       JOptionPane.showMessageDialog(warn,"Error!\nThere is no doctor with this email and password combination!", "Reminder", JOptionPane.WARNING_MESSAGE);
    else{doc=new DoctorFrame(DoctorManager.searchEmailPassCNP(t1.getText().trim(),t2.getText().trim()));
         doc.pack();
         doc.setLocation(500, 200);
         doc.setVisible(true);
         t1.setText(null);
         t2.setText(null);
         doct.setSelected(false);}
    }
  else JOptionPane.showMessageDialog(warn,"Error!\nChoose an account type!", "Reminder", JOptionPane.WARNING_MESSAGE);
  }
 }
}

public static void main(String[] args)
 {JFrame f=new LoginFrame();
  f.pack();
  f.setLocation(500, 200);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
