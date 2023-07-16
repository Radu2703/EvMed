import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class EmployeeFrame extends JFrame{
    private String cnp,name;
    private JLabel title,pass,l1,l2,l3,stat;
    private JButton chg,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,bst,vr,mvb;
    private EmployeeController ac;
    private JPanel cpw,p1,p2;
public EmployeeFrame(String c){
 super("Employee window");
 cnp=c;
 ac=new EmployeeController();
 ac.setCNP(c);
 name=EmployeeManager.searchCNPName(cnp);
 title=new JLabel("WELCOME, "+name.toUpperCase());
 pass=new JLabel("Change your password");
 stat=new JLabel("See health statistics");
 bst=new JButton("Statistics window");
 chg=new JButton("Change password");
 l1=new JLabel("Verify vacation requests");
 l2=new JLabel("View your documents");
 l3=new JLabel("Medical vacation form");
 p1=new JPanel(); p2=new JPanel(); cpw=new JPanel();
 b1=new JButton("See lab analysis");
 b2=new JButton("See vaccines");
 b3=new JButton("See medical history");
 b4=new JButton("See ability file");
 b5=new JButton("See health certificate");
 b6=new JButton("See medical file");
 b7=new JButton("See medical vacation");
 b8=new JButton("See risks file");
 b9=new JButton("See health evaluation");
 b10=new JButton("See psychology test");
 vr=new JButton("Check vacations");
 mvb=new JButton("Request vacation");
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
 vr.addActionListener(ac);
 mvb.addActionListener(ac);
 cpw.setLayout(new GridLayout(1, 6, 1, 5));
 if(EmployeeManager.managerCNP(cnp))
    {cpw.add(l1);cpw.add(vr);}
  else {cpw.add(l3);cpw.add(mvb);}
 p2.setLayout(new GridLayout(2, 5, 5, 5));
 cpw.add(pass); cpw.add(chg); cpw.add(stat); cpw.add(bst);
 p2.add(b1); p2.add(b2); p2.add(b3); p2.add(b4); p2.add(b5);
 p2.add(b6); p2.add(b7); p2.add(b8); p2.add(b9); p2.add(b10);
 setLayout(new GridLayout(4, 1, 5, 5));
 add(title); add(cpw); add(l2); add(p2);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {dispose();}
 });
 }

private class EmployeeController implements ActionListener{
    private JFrame pwc, af, hc, la, hv, mf, mh, mv, rf, he, pt, stat, vac, mvg;
    private String cnp;
    public void setCNP(String c){cnp=c;}
    @Override
    public void actionPerformed(ActionEvent e){
     if(e.getSource()==vr)
       {vac=new VacationApprovalFrame(cnp);
        vac.pack();
        vac.setVisible(true);}
     if(e.getSource()==chg)
       {pwc=new EmployeePasswordChange(cnp);
        pwc.pack();
        pwc.setVisible(true);}
     if(e.getSource()==bst)
       {if (stat==null) stat=new StatisticsWindow();
        stat.pack();
        stat.setVisible(true);}
     if(e.getSource()==b1)
       {if (la==null) la=new LabAnalysisPage(cnp);
        la.pack();
        la.setVisible(true);}
     if(e.getSource()==b2)
       {if (hv==null) hv=new VaccinesPage(cnp);
        hv.pack();
        hv.setVisible(true);}
     if(e.getSource()==b3)
       {if (mh==null) mh=new MedicalHistoryPage(cnp);
        mh.pack();
        mh.setVisible(true);}
     if(e.getSource()==b4)
       {if (af==null) af=new AbilityFilePage(cnp);
        af.pack();
        af.setVisible(true);}
     if(e.getSource()==b5)
       {if (hc==null) hc=new HealthCertificatePage(cnp);
        hc.pack();
        hc.setVisible(true);}
     if(e.getSource()==b6)
       {if (mf==null) mf=new MedicalFilePage(cnp);
        mf.pack();
        mf.setVisible(true);}
     if(e.getSource()==b7)
       {if (mv==null) mv=new MedicalVacationPage(cnp);
        mv.pack();
        mv.setVisible(true);}
     if(e.getSource()==b8)
       {if (rf==null) rf=new RisksFilePage(cnp);
        rf.pack();
        rf.setVisible(true);}
     if(e.getSource()==b9)
       {if (he==null) he=new HealthEvaluationPage(cnp);
        he.pack();
        he.setVisible(true);}
     if(e.getSource()==b10)
       {if (pt==null) pt=new PsychologyTestPage(cnp);
        pt.pack();
        pt.setVisible(true);}
     if(e.getSource()==mvb)
       {if (mvg==null) mvg=new MedicalVacationAddition();
        mvg.pack();
        mvg.setVisible(true);}
    }
 }
}
