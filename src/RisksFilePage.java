import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class RisksFilePage extends JFrame{
    private JComboBox cb;
    private JPanel p;
    private String cnp;
    private String[]ids;
    private JButton save;
    private JOptionPane pab;
    private RisksFileController vac;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    private JLabel title,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
public RisksFilePage(String c){
    super("Risks File Page");
    cnp=c;
    p=new JPanel();
    vac=new RisksFileController();
    vac.setCNP(c);
    save=new JButton("Open file (by choosing one of its risks)");
    title=new JLabel("Choose a risk");
    l1=new JLabel("ID");
    l2=new JLabel("Employee CNP");
    l3=new JLabel("File ID");
    l4=new JLabel("Description");
    l5=new JLabel("Chance");
    l6=new JLabel("Recommendations");
    l7=new JLabel("Date");
    l8=new JLabel("Building");
    l9=new JLabel("Street");
    l10=new JLabel("City");
    l11=new JLabel("County");
    l12=new JLabel("Doctor");
    l13=new JLabel("Doctor Phone Number");
    if(RisksFileManager.countIDS(cnp))
       {String s=RisksFileManager.displayIDs(cnp);
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
    t10=new JTextField(10);
    t10.setEnabled(false);
    t11=new JTextField(10);
    t11.setEnabled(false);
    t12=new JTextField(10);
    t12.setEnabled(false);
    t13=new JTextField(10);
    t13.setEnabled(false);
    p.setLayout(new GridLayout(14,2,1,5));
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

private class RisksFileController implements ActionListener{
    String info,cnp,message,title,ids; 
    String[] infos=new String[13]; 
    String[] IDS; 
    JFrame doc;
    int nb;
    public void setCNP(String c){cnp=c;}
@Override
public void actionPerformed(ActionEvent e)
{String et=e.getActionCommand();
 if(et.equals("Open file (by choosing one of its risks)"))
    {if(t1.getText().trim().length()<=0||t2.getText().trim().length()<=0||t3.getText().trim().length()<=0||t4.getText().trim().length()<=0||t5.getText().trim().length()<=0||t6.getText().trim().length()<=0||t7.getText().trim().length()<=0||t8.getText().trim().length()<=0||t9.getText().trim().length()<=0||t10.getText().trim().length()<=0||t11.getText().trim().length()<=0||t12.getText().trim().length()<=0||t13.getText().trim().length()<=0)
         JOptionPane.showMessageDialog(pab,"Error!\nYou need to fill in the fields! ", "Reminder", JOptionPane.WARNING_MESSAGE);
     else {ids=RisksFileManager.displayFileIDs(t3.getText().trim());
           nb=ids.length()/2;
           ids=ids.substring(0, ids.length()-1);
           IDS=ids.split(" ");
           message="RISKS FILE\n"+"CNP: "+t2.getText().trim()+'\n'+"File ID: "+t3.getText().trim()+"\n\n";
           for(int i=0; i<nb; i++){
           info=RisksFileManager.displayID(IDS[i]);
           infos=info.split("//");
           message+="RISK\nID: "+infos[0]+"\nDescription: "+infos[3]+"\nChance: "+infos[4]+"\nRecommendations: "+infos[5]+"\nDate: "+infos[6]+"\nBuilding: "+infos[7]+"\nStreet: "+infos[8]+"\nCity: "+infos[9]+"\nCounty: "+infos[10]+"\nDoctor: "+infos[11]+"\nDoctor Phone Number: "+infos[12]+"\n\n";
           }
           title="RisksFile"+infos[2]+".txt";
           doc=new DocFrame(message,title);
           doc.pack();
           doc.setVisible(true);}
    }
 else if(e.getSource()==cb)
 {info=RisksFileManager.displayID((String) cb.getSelectedItem());
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
  repaint(); pack();}}
}
}
