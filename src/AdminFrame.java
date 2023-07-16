import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class AdminFrame extends JFrame{
    private String cnp,name;
    private JLabel title,l1,l2;
    private JButton chg,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,bst,clo,tab;
    private AdminController ac;
    private JPanel cpw,p1,p2;
public AdminFrame(String c){
 super("Administrator window");
 cnp=c;
 ac=new AdminController();
 ac.setCNP(c);
 name=AdministratorManager.searchCNPName(cnp);
 title=new JLabel("WELCOME, "+name.toUpperCase());
 bst=new JButton("Statistics window");
 chg=new JButton("Change password");
 clo=new JButton("Clock");
 tab=new JButton("Administrator table");
 l1=new JLabel("Enter new account");
 l2=new JLabel("Enter new document");
 p1=new JPanel(); p2=new JPanel(); cpw=new JPanel();
 b1=new JButton("Add administrator");
 b2=new JButton("Add employee");
 b3=new JButton("Add doctor");
 b4=new JButton("Add ability file");
 b5=new JButton("Add health certificate");
 b6=new JButton("Add medical file");
 b7=new JButton("Add medical vacation");
 b8=new JButton("Add risks file");
 b9=new JButton("Add health evaluation");
 b10=new JButton("Add psychology test");
 b1.addActionListener(ac);
 b2.addActionListener(ac);
 b3.addActionListener(ac);
 b4.addActionListener(ac);
 b5.addActionListener(ac);
 b6.addActionListener(ac);
 b7.addActionListener(ac);
 b8.addActionListener(ac);
 b9.addActionListener(ac);
 b10.addActionListener(ac);
 chg.addActionListener(ac);
 bst.addActionListener(ac);
 clo.addActionListener(ac);
 tab.addActionListener(ac);
 p1.setLayout(new GridLayout(1, 3, 5, 5));
 cpw.setLayout(new GridLayout(1, 4, 5, 5));
 p2.setLayout(new GridLayout(2, 4, 5, 5));
 cpw.add(chg); cpw.add(bst); cpw.add(clo); cpw.add(tab);
 p1.add(b1); p1.add(b2); p1.add(b3);
 p2.add(b4); p2.add(b5); p2.add(b6); p2.add(b7); 
 p2.add(b8); p2.add(b9); p2.add(b10);
 setLayout(new GridLayout(6, 1, 5, 5));
 add(title); add(cpw); add(l1); add(p1); add(l2); add(p2);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {dispose();}
 });
 }

private class AdminController implements ActionListener{
    private JFrame pwc, em, ad, doc, af, hc, la, hv, mf, mh, mv, rf, he, pt, stat, cloc, tabe;
    private String cnp;
    public void setCNP(String c){cnp=c;}
    @Override
    public void actionPerformed(ActionEvent e){
     if(e.getSource()==chg)
       {if (pwc==null) pwc=new AdminPasswordChange(cnp);
        pwc.pack();
        pwc.setVisible(true);}
     if(e.getSource()==bst)
       {if (stat==null) stat=new StatisticsWindow();
        stat.pack();
        stat.setVisible(true);}
     if(e.getSource()==b1)
       {if (ad==null) ad=new AdministratorAddition();
        ad.pack();
        ad.setVisible(true);}
     if(e.getSource()==b2)
       {if (em==null) em=new EmployeeAddition();
        em.pack();
        em.setVisible(true);}
     if(e.getSource()==b3)
       {if (doc==null) doc=new DoctorAddition();
        doc.pack();
        doc.setVisible(true);}
     if(e.getSource()==b4)
       {if (af==null) af=new AbilityFileAddition();
        af.pack();
        af.setVisible(true);}
     if(e.getSource()==b5)
       {if (hc==null) hc=new HealthCertificateAddition();
        hc.pack();
        hc.setVisible(true);}
     if(e.getSource()==b6)
       {if (mf==null) mf=new MedicalFileAddition();
        mf.pack();
        mf.setVisible(true);}
     if(e.getSource()==b7)
       {if (mv==null) mv=new MedicalVacationAddition();
        mv.pack();
        mv.setVisible(true);}
     if(e.getSource()==b8)
       {if (rf==null) rf=new RisksFileAddition();
        rf.pack();
        rf.setVisible(true);}
     if(e.getSource()==b9)
       {if (he==null) he=new HealthEvaluationAddition();
        he.pack();
        he.setVisible(true);}
     if(e.getSource()==b10)
       {if (pt==null) pt=new PsychologyTestAddition();
        pt.pack();
        pt.setVisible(true);}
     if(e.getSource()==clo)
       {if (cloc==null) cloc=new ClockPage();
        cloc.setVisible(true);}
     if(e.getSource()==tab)
       {if (tabe==null) tabe=new TableFrame();
        tabe.pack();
        tabe.setVisible(true);}
    }
 }
}
