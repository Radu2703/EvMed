import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class AbilityFileSignatureFrame extends JFrame{
    private JComboBox cb;
    private JPanel p;
    private String email;
    private String[]ids;
    private JButton save;
    private JOptionPane pab;
    private AbilityFileSignatureController vac;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
    private JLabel title,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
public AbilityFileSignatureFrame(String c){
    super("Ability File Signature Frame");
    email=c;
    p=new JPanel();
    vac=new AbilityFileSignatureController();
    vac.setEmail(c);
    save=new JButton("Write the result");
    title=new JLabel("Choose the ability file");
    l1=new JLabel("ID");
    l2=new JLabel("Employee CNP");
    l3=new JLabel("Medical History Description");
    l4=new JLabel("Recent Medical Events Description");
    l5=new JLabel("Blood Pressure");
    l6=new JLabel("Ophthalmological Consultation");
    l7=new JLabel("Pulse");
    l8=new JLabel("Oxygen Saturation");
    l9=new JLabel("Date");
    l10=new JLabel("Building");
    l11=new JLabel("Street");
    l12=new JLabel("City");
    l13=new JLabel("County");
    l14=new JLabel("Doctor");
    l15=new JLabel("Doctor Phone Number");
    l16=new JLabel("Result");
    l17=new JLabel("Doctor Email");
    if(AbilityFileManager.countNullIDS(email))
       {String s=AbilityFileManager.displayNullIDS(email);
        s=s.substring(0, s.length()-2);
        ids=s.split("//");
        cb=new JComboBox(ids);}
      else cb=new JComboBox();
    cb.setSelectedIndex(-1);
    t1=new JTextField(10);
    t1.setEnabled(false);
    t2=new JTextField(10);
    t2.setEnabled(false);
    t3=new JTextField(10);
    t3.setEnabled(false);
    t4=new JTextField(10);
    t4.setEnabled(false);
    t5=new JTextField(10);
    t5.setEnabled(false);
    t6=new JTextField(10);
    t6.setEnabled(false);
    t7=new JTextField(10);
    t7.setEnabled(false);
    t8=new JTextField(10);
    t8.setEnabled(false);
    t9=new JTextField(10);
    t9.setEnabled(false);
    t10=new JTextField(10);
    t10.setEnabled(false);
    t11=new JTextField(10);
    t11.setEnabled(false);
    t12=new JTextField(10);
    t12.setEnabled(false);
    t13=new JTextField(10);
    t13.setEnabled(false);
    t14=new JTextField(10);
    t14.setEnabled(false);
    t15=new JTextField(10);
    t15.setEnabled(false);
    t16=new JTextField(10);
    t17=new JTextField(10);
    t17.setEnabled(false);
    p.setLayout(new GridLayout(18,2,1,5));
    p.add(title); p.add(cb);
    p.add(l1); p.add(t1);
    p.add(l2); p.add(t2);
    p.add(l3); p.add(t3);
    p.add(l4); p.add(t4);
    p.add(l5); p.add(t5);
    p.add(l6); p.add(t6);
    p.add(l7); p.add(t7);
    p.add(l8); p.add(t8);
    p.add(l9); p.add(t9);
    p.add(l10); p.add(t10);
    p.add(l11); p.add(t11);
    p.add(l12); p.add(t12);
    p.add(l13); p.add(t13);
    p.add(l14); p.add(t14);
    p.add(l15); p.add(t15);
    p.add(l16); p.add(t16);
    p.add(l17); p.add(t17);
    setLayout(new GridLayout(2,1,1,5));
    add(p);add(save);
    save.addActionListener(vac);
    cb.addActionListener(vac);
    setLocation(600,0);
    addWindowListener(new WindowAdapter()
    {@Override
     public void windowClosing(WindowEvent e)
     {dispose();}
    });
}

private class AbilityFileSignatureController implements ActionListener{
    String info,email; String []infos=new String[17];
    public void setEmail(String c){email=c;}
@Override
public void actionPerformed(ActionEvent e)
{String et=e.getActionCommand();
 if(et.equals("Write the result"))
    {if(t1.getText().trim().length()<=0||t2.getText().trim().length()<=0||t3.getText().trim().length()<=0||t4.getText().trim().length()<=0||t5.getText().trim().length()<=0||t6.getText().trim().length()<=0||t7.getText().trim().length()<=0||t8.getText().trim().length()<=0||t9.getText().trim().length()<=0||t10.getText().trim().length()<=0||t11.getText().trim().length()<=0||t12.getText().trim().length()<=0||t13.getText().trim().length()<=0||t14.getText().trim().length()<=0||t15.getText().trim().length()<=0||t14.getText().trim().length()<=0||t15.getText().trim().length()<=0)
         JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill in the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
     else if(!t16.getText().trim().toLowerCase().equals("able")&&!t16.getText().trim().toLowerCase().equals("conditionally able")&&!t16.getText().trim().toLowerCase().equals("temporarily unable")&&!t16.getText().trim().toLowerCase().equals("unable"))
         JOptionPane.showMessageDialog(pab,"Error!\nYou can only write \"able\" or \"conditionally able\" or \"temporarily unable\" or \"unable\" in the approval field! ", "Reminder", JOptionPane.WARNING_MESSAGE);
     else {AbilityFileManager.signature(Long.parseLong(t1.getText().trim()), t16.getText().trim());
           JOptionPane.showMessageDialog(pab,"Ability file with the id="+t1.getText().trim()+" has been signed with the result: "+t16.getText().trim()+"!", "Reminder", JOptionPane.WARNING_MESSAGE);
           //SendEmail.send(EmployeeManager.searchEmailbyCNP(t2.getText().trim()), "Yearly health evaluation result", "Your result for the yearly health evaluation represented by the ability file with the id "+t1.getText().trim()+" is: "+t16.getText().trim()+"!");
           dispose();}}
 else if(e.getSource()==cb)
 {info=AbilityFileManager.displayID((String) cb.getSelectedItem());
  infos=info.split("//");
  t1.setText(infos[0]);
  t2.setText(infos[1]);
  t3.setText(infos[2]);
  t4.setText(infos[3]);
  t5.setText(infos[4]);
  t6.setText(infos[5]);
  t7.setText(infos[6]);
  t8.setText(infos[7]);
  t9.setText(infos[8]);
  t10.setText(infos[9]);
  t11.setText(infos[10]);
  t12.setText(infos[11]);
  t13.setText(infos[12]);
  t14.setText(infos[13]);
  t15.setText(infos[14]);
  t16.setText(infos[15]);
  t17.setText(infos[16]);
  repaint(); pack();}}
}
}