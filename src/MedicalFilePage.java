import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class MedicalFilePage extends JFrame{
    private JComboBox cb;
    private JPanel p;
    private String cnp;
    private String[]ids;
    private JButton save;
    private JOptionPane pab;
    private MedicalFileController vac;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private JLabel title,l1,l2,l3,l4,l5,l6,l7,l8,l9;
public MedicalFilePage(String c){
    super("Medical File Page");
    cnp=c;
    p=new JPanel();
    vac=new MedicalFileController();
    vac.setCNP(c);
    save=new JButton("Open file");
    title=new JLabel("Choose the document");
    l1=new JLabel("ID");
    l2=new JLabel("Employee CNP");
    l3=new JLabel("Date");
    l4=new JLabel("Building");
    l5=new JLabel("Street");
    l6=new JLabel("City");
    l7=new JLabel("County");
    l8=new JLabel("Doctor");
    l9=new JLabel("Doctor Phone Number");
    if(MedicalFileManager.countIDS(cnp))
       {String s=MedicalFileManager.displayIDs(cnp);
        s=s.substring(0, s.length()-1);
        ids=s.split(" ");
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
    p.setLayout(new GridLayout(10,2,1,5));
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

private class MedicalFileController implements ActionListener{
    String info,cnp,message,title,id1,id2,id3;
    String []infos=new String[9];
    String []ids1;
    String []ids2;
    String []ids3;
    JFrame doc;
    int nb;
    public void setCNP(String c){cnp=c;}
@Override
public void actionPerformed(ActionEvent e)
{String et=e.getActionCommand();
 if(et.equals("Open file"))
    {if(t1.getText().trim().length()<=0||t2.getText().trim().length()<=0||t3.getText().trim().length()<=0||t4.getText().trim().length()<=0||t5.getText().trim().length()<=0||t6.getText().trim().length()<=0||t7.getText().trim().length()<=0||t8.getText().trim().length()<=0||t9.getText().trim().length()<=0)
         JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill in the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
     else {info=MedicalFileManager.displayID(t1.getText().trim());
           infos=info.split("//");
           message="MEDICAL FILE"+"\nID: "+infos[0]+"\nCNP: "+infos[1]+"\nDate: "+infos[2]+"\nBuilding: "+infos[3]+"\nStreet: "+infos[4]+"\nCity: "+infos[5]+"\nCity: "+infos[6]+"\nDoctor: "+infos[7]+"\nDoctor Phone Number: "+infos[8]+"\n";
           title="MedicalFile"+infos[0]+".txt";
           if(HiringLabAnalysisManager.countFileIDs(t1.getText().trim()))
           {info=HiringLabAnalysisManager.displayFileIDs(t1.getText().trim());
            nb=info.length()/2;
            info=info.substring(0, info.length()-1);
            infos=info.split(" ");
            message+="\nLAB ANALYSIS\nAssociated files (ID): ";
            for(int i=0;i<nb;i++)message+=infos[i]+"; ";
            message+="\n";}
           if(HiringVaccinesManager.countFileIDs(t1.getText().trim()))
           {info=HiringVaccinesManager.displayFileIDs(t1.getText().trim());
            nb=info.length()/2;
            info=info.substring(0, info.length()-1);
            infos=info.split(" ");
            message+="\nVACCINES\nAssociated files (ID): ";
            for(int i=0;i<nb;i++)message+=infos[i]+"; ";
            message+="\n";}
           if(MedicalHistoryManager.countFileIDs(t1.getText().trim()))
           {info=MedicalHistoryManager.displayFileIDs(t1.getText().trim());
            nb=info.length()/2;
            info=info.substring(0, info.length()-1);
            infos=info.split(" ");
            message+="\nMEDICAL HISTORY\nAssociated files (ID): ";
            for(int i=0;i<nb;i++)message+=infos[i]+"; ";
            message+="\n";}
           doc=new DocFrame(message,title);
           doc.pack();
           doc.setVisible(true);}
    }
 else if(e.getSource()==cb)
 {info=MedicalFileManager.displayID((String) cb.getSelectedItem());
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
  repaint(); pack();}}
}
}