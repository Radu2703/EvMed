import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TableFrame extends JFrame{
    private JTable tabel;
    private JPanel p;
    private int i,nb;
    private String IDS, INFO;
    private String [] ids,info;
    private JRadioButton btn1,btn2,btn3,btn4;
    private ButtonGroup group;
 public TableFrame(){
    super("Admins Table");
    p=new JPanel();
    p.setLayout(new GridLayout(1,4,1,1));
    nb=AdministratorManager.countCNPs();
    tabel=new JTable(nb+1,7);
    tabel.setEnabled(false);
    tabel.setValueAt("SURNAME",0,0);
    tabel.setValueAt("NAME",0,1);
    tabel.setValueAt("EMAIL",0,2);
    tabel.setValueAt("COUNTY",0,3);
    tabel.setValueAt("CITY",0,4);
    tabel.setValueAt("PHONE NUMBER",0,5);
    tabel.setValueAt("GENDER",0,6);
    if(nb>0)
     {IDS=AdministratorManager.displayCNPs();
      IDS=IDS.substring(0,IDS.length()-1);
      ids=IDS.split(" ");
     }
    for(i=1;i<=nb;i++)
    {INFO=AdministratorManager.displayCNP(ids[i-1]);
     info=INFO.split("//");
     tabel.setValueAt(info[1], i, 0);
     tabel.setValueAt(info[2], i, 1);
     tabel.setValueAt(info[3], i, 2);
     tabel.setValueAt(info[5], i, 3);
     tabel.setValueAt(info[6], i, 4);
     tabel.setValueAt(info[7], i, 5);
     tabel.setValueAt(info[8], i, 6);}
    for(i=0;i<7;i++)tabel.getColumnModel().getColumn(i).setPreferredWidth(100);
    
    setLocation(500,10);
    addWindowListener(new WindowAdapter()
    {@Override
     public void windowClosing(WindowEvent e)
     {dispose();}
    });
    
    btn1 = new JRadioButton("Normal");
    btn2 = new JRadioButton("Italic");
    btn3 = new JRadioButton("Bold");
    btn4 = new JRadioButton("Bold/Italic");
        
    btn1.setPreferredSize(new Dimension(1, 1));
    btn2.setPreferredSize(new Dimension(1, 1));
    btn3.setPreferredSize(new Dimension(1, 1));
    btn4.setPreferredSize(new Dimension(1, 1));
        
    btn1.setSelected(true);
    group = new ButtonGroup();
    group.add(btn1);
    group.add(btn2);
    group.add(btn3);
    group.add(btn4);
  
    btn1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
        {startThread(1);}
      });
    btn2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
        {startThread(2);}
      });
    btn3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
        {startThread(3);}
      });
    btn4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
        {startThread(4);}
      });
  
    p.add(btn1);
    p.add(btn2);
    p.add(btn3);
    p.add(btn4);
    setLayout(new GridLayout(2,1,1,1));
    add(tabel);
    add(p);
    }
    
    private void startThread(int i)
    {
        int mode=i;
        
        SwingWorker sw1 = new SwingWorker() {
            // Method
            @Override
            protected Boolean doInBackground()
                throws Exception
            {String res;
             switch(mode){
                case 1:tabel.setFont(tabel.getFont().deriveFont(Font.PLAIN));
                       break;
                case 2:tabel.setFont(tabel.getFont().deriveFont(Font.ITALIC));
                       break;
                case 3:tabel.setFont(tabel.getFont().deriveFont(Font.BOLD));
                       break;
                case 4:tabel.setFont(tabel.getFont().deriveFont(Font.BOLD|Font.ITALIC));
                       break;
                default:break;}
                return true;
            }
        };
  
        // Executes the swingworker on worker thread
        sw1.execute();
    }
 }
