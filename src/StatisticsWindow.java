import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class StatisticsWindow extends JFrame{
    private JPanel p;
    private JLabel title;
    private JCheckBox c1,c2,c3;
    private JTextField t1,t2,t3;
    private JComboBox cb;
    private JButton stat;
    private StatisticsController c;
    private JOptionPane pbb;
public StatisticsWindow(){
    super("Statistics window");
    String options[]={"Health certificate","Lab analysis","Vaccines","Medical history","Medical vacation"}; 
    cb=new JComboBox(options);
    cb.setSelectedIndex(-1);
    p=new JPanel();
    setLocation(500, 200);
    title=new JLabel("Choose the statistics conditions");
    c1=new JCheckBox("Sickness/Type/Reason");
    c2=new JCheckBox("Month");
    c3=new JCheckBox("Year");
    c=new StatisticsController();
    t1=new JTextField(); t2=new JTextField(); t3=new JTextField();
    stat=new JButton("See statistic");
    stat.addActionListener(c);
    setLayout(new GridLayout(4,1,5,5));
    p.setLayout(new GridLayout(3,2,5,5));
    stat.addActionListener(c);
    p.add(c1); p.add(t1);
    p.add(c2); p.add(t2);
    p.add(c3); p.add(t3);
    add(title); add(cb); add(p); add(stat);
    addWindowListener(new WindowAdapter()
    {@Override
      public void windowClosing(WindowEvent e)
      {dispose();}
    });
}
private class StatisticsController implements ActionListener{
    //private JOptionPane warn;
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==stat){
    try{int m=0,y=0;
        if(c2.isSelected()==true&&t2.getText().trim().length()>0)
            m=Integer.parseInt(t2.getText().trim());
        if(c3.isSelected()==true&&t3.getText().trim().length()>0)
            y=Integer.parseInt(t3.getText().trim());
        if(cb.getSelectedIndex()==-1)
           JOptionPane.showMessageDialog(null,"Error!\nYou need to select a document type! ", "Reminder", JOptionPane.WARNING_MESSAGE);
        else if(c1.isSelected()==true&&t1.getText().trim().length()<=0)
           JOptionPane.showMessageDialog(null,"Error!\nYou did not enter anything in type, which is selected! ", "Reminder", JOptionPane.WARNING_MESSAGE);
        else if(c2.isSelected()==true&&t2.getText().trim().length()<=0)
           JOptionPane.showMessageDialog(null,"Error!\nYou did not enter anything in month, which is selected! ", "Reminder", JOptionPane.WARNING_MESSAGE);
        else if(c3.isSelected()==true&&t3.getText().trim().length()<=0)
           JOptionPane.showMessageDialog(null,"Error!\nYou did not enter anything in year, which is selected! ", "Reminder", JOptionPane.WARNING_MESSAGE);
        else if(c2.isSelected()==true&&t2.getText().trim().length()>0&&(m<1||m>12))
            JOptionPane.showMessageDialog(null,"Error!\nIf you fill the month field, you have to do so with a number between 1 and 12!", "Reminder", JOptionPane.WARNING_MESSAGE);
        else if(c3.isSelected()==true&&t3.getText().trim().length()>0&&(y<1900||y>2100))
            JOptionPane.showMessageDialog(null,"Error!\nIf you fill the year field, you have to do so with a number between 1900 and 2100!", "Reminder", JOptionPane.WARNING_MESSAGE);
        else {
        if(cb.getSelectedItem().equals("Health certificate"))
          {if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              HealthCertificateManager.displayst();
           if(c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              HealthCertificateManager.displaySickness(t1.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              HealthCertificateManager.displayMonth(t2.getText().trim());
           if(!c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              HealthCertificateManager.displayYear(t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              HealthCertificateManager.displaySicknessMonth(t1.getText().trim(),t2.getText().trim());
           if(c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              HealthCertificateManager.displaySicknessYear(t1.getText().trim(), t3.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              HealthCertificateManager.displayMonthYear(t2.getText().trim(),t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              HealthCertificateManager.displaySicknessMonthYear(t1.getText().trim(),t2.getText().trim(),t3.getText().trim());
          }
        if(cb.getSelectedItem().equals("Lab analysis"))
          {if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              HiringLabAnalysisManager.displayst();
           if(c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              HiringLabAnalysisManager.displayType(t1.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              HiringLabAnalysisManager.displayMonth(t2.getText().trim());
           if(!c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              HiringLabAnalysisManager.displayYear(t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              HiringLabAnalysisManager.displayTypeMonth(t1.getText().trim(),t2.getText().trim());
           if(c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              HiringLabAnalysisManager.displayTypeYear(t1.getText().trim(), t3.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              HiringLabAnalysisManager.displayMonthYear(t2.getText().trim(),t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              HiringLabAnalysisManager.displayTypeMonthYear(t1.getText().trim(),t2.getText().trim(),t3.getText().trim());
          }
        if(cb.getSelectedItem().equals("Vaccines"))
          {if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              HiringVaccinesManager.displayst();
           if(c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              HiringVaccinesManager.displayType(t1.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              HiringVaccinesManager.displayMonth(t2.getText().trim());
           if(!c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              HiringVaccinesManager.displayYear(t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              HiringVaccinesManager.displayTypeMonth(t1.getText().trim(),t2.getText().trim());
           if(c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              HiringVaccinesManager.displayTypeYear(t1.getText().trim(), t3.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              HiringVaccinesManager.displayMonthYear(t2.getText().trim(),t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              HiringVaccinesManager.displayTypeMonthYear(t1.getText().trim(),t2.getText().trim(),t3.getText().trim());
          }
        if(cb.getSelectedItem().equals("Medical history"))
          {if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              MedicalHistoryManager.displayst();
           if(c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              MedicalHistoryManager.displaySickness(t1.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              MedicalHistoryManager.displayMonth(t2.getText().trim());
           if(!c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              MedicalHistoryManager.displayYear(t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              MedicalHistoryManager.displaySicknessMonth(t1.getText().trim(),t2.getText().trim());
           if(c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              MedicalHistoryManager.displaySicknessYear(t1.getText().trim(), t3.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              MedicalHistoryManager.displayMonthYear(t2.getText().trim(),t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              MedicalHistoryManager.displaySicknessMonthYear(t1.getText().trim(),t2.getText().trim(),t3.getText().trim());
          }
        if(cb.getSelectedItem().equals("Medical vacation"))
          {if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              MedicalVacationManager.displayst();
           if(c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())
              MedicalVacationManager.displayReason(t1.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              MedicalVacationManager.displayMonth(t2.getText().trim());
           if(!c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              MedicalVacationManager.displayYear(t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&!c3.isSelected())
              MedicalVacationManager.displayReasonMonth(t1.getText().trim(),t2.getText().trim());
           if(c1.isSelected()&&!c2.isSelected()&&c3.isSelected())
              MedicalVacationManager.displayReasonYear(t1.getText().trim(), t3.getText().trim());
           if(!c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              MedicalVacationManager.displayMonthYear(t2.getText().trim(),t3.getText().trim());
           if(c1.isSelected()&&c2.isSelected()&&c3.isSelected())
              MedicalVacationManager.displayReasonMonthYear(t1.getText().trim(),t2.getText().trim(),t3.getText().trim());
          }
        }
        }catch(NumberFormatException er)
         {JOptionPane.showMessageDialog(null,"Error!\nIf you fill the month or year field, you need to enter a number!", "Reminder", JOptionPane.WARNING_MESSAGE);}
    }
 }
}
}
