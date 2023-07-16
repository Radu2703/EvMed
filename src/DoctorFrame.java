import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class DoctorFrame extends JFrame{
    private String cnp,name,email;
    private JLabel title,pass,l1,stat;
    private JButton chg,bst,vr;
    private DoctorController ac;
    private JPanel cpw;
public DoctorFrame(String c){
 super("Doctor window");
 cnp=c;
 ac=new DoctorController();
 ac.setCNP(c);
 name=DoctorManager.searchCNPName(cnp);
 email=DoctorManager.searchEmailbyCNP(cnp);
 title=new JLabel("WELCOME, "+name.toUpperCase());
 pass=new JLabel("Change your password");
 stat=new JLabel("See health statistics");
 bst=new JButton("Statistics window");
 chg=new JButton("Change password");
 l1=new JLabel("Verify ability files");
 cpw=new JPanel();
 vr=new JButton("Check ability files");
 chg.addActionListener(ac);
 bst.addActionListener(ac);
 vr.addActionListener(ac);
 cpw.setLayout(new GridLayout(1, 6, 1, 5));
 cpw.add(l1);cpw.add(vr); cpw.add(pass); cpw.add(chg); cpw.add(stat); cpw.add(bst);
 setLayout(new GridLayout(2, 1, 5, 5));
 add(title); add(cpw);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {dispose();}
 });
 }

private class DoctorController implements ActionListener{
    private JFrame pwc, stat, vac;
    private String cnp;
    public void setCNP(String c){cnp=c;}
    @Override
    public void actionPerformed(ActionEvent e){
     if(e.getSource()==vr)
       {vac=new AbilityFileSignatureFrame(email);
        vac.pack();
        vac.setVisible(true);}
     if(e.getSource()==chg)
       {pwc=new DoctorPasswordChange(cnp);
        pwc.pack();
        pwc.setVisible(true);}
     if(e.getSource()==bst)
       {if (stat==null) stat=new StatisticsWindow();
        stat.pack();
        stat.setVisible(true);}
    }
 }
}
