import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.print.*;
public class DocFrame extends JFrame
{private JButton print,printF;
 private JTextArea area;
 private String message,title;
 private JPanel p;
 private DocFrameController c;
 private GridBagLayout gb;
 private GridBagConstraints gbc;
public DocFrame(String m, String t)
{super("Health Doc");
 message=m;
 title=t;
 c=new DocFrameController();
 gb=new GridBagLayout();
 gbc=new GridBagConstraints();
 gbc.fill=GridBagConstraints.HORIZONTAL;
 gbc.anchor=GridBagConstraints.NORTH;
 p=new JPanel();
 p.setLayout(gb);
 area=new JTextArea(message,50, 500);
 area.setEditable(false);
 addComponent(area,0,0,2,5);
 print=new JButton("Print");
 printF=new JButton("Print to file");
 addComponent(print,0,6,1,1);
 print.addActionListener(c);
 addComponent(printF,1,6,1,1);
 printF.addActionListener(c);
 add(p);
 addWindowListener(new WindowAdapter()
 {@Override
  public void windowClosing(WindowEvent e)
  {dispose();}
 });
}
void addComponent(Component c, int linie,int col, int lat, int inal)
{gbc.gridx=col;
 gbc.gridy=linie;
 gbc.gridwidth=lat;
 gbc.gridheight=inal;
 gb.setConstraints(c,gbc);
 p.add(c);}
class DocFrameController implements ActionListener
{private PrintWriter out;
 @Override
 public void actionPerformed(ActionEvent e)
 {if (e.getSource()==print)
  {PrinterJob imprimanta=PrinterJob.getPrinterJob();
   Book bk=new Book();
   bk.append(new PanelContent(),imprimanta.defaultPage());
   imprimanta.setPageable(bk);
   if(imprimanta.printDialog())
   {try{imprimanta.print(); JOptionPane.showMessageDialog(null,"File has been successfully printed!", "Notification", JOptionPane.PLAIN_MESSAGE);}
    catch (PrinterException pe)
     {area.append("Printer does not exist");
      area.repaint();}
    catch(ArrayIndexOutOfBoundsException ae)
    {System.out.println("What do you want to print?");}
   }
  }
 else if (e.getSource()==printF){
 try{
 out=new PrintWriter(new FileOutputStream(title));
 out.write(area.getText());
 out.flush();
 out.close();
 JOptionPane.showMessageDialog(null,"File has been successfully downloaded!", "Notification", JOptionPane.PLAIN_MESSAGE);
 }catch(FileNotFoundException fe){}
 catch(IOException ioe){}
 }
 }
}
class PanelContent extends JPanel implements Printable
{private BufferedReader br;
 private String sir="";
 public int print(Graphics g, PageFormat pf,int pageIndex)
 throws PrinterException
 {g.setColor(Color.black);
 try
 {StringReader continut=new StringReader(area.getText());
  br=new BufferedReader(continut);
  int i=0;
  while((sir=br.readLine())!=null)
  {if (sir.length()==0) sir=" ";
   g.drawString(sir,100,100+i);i+= 20;}
 }
 catch(IOException | IllegalArgumentException io){}
 return Printable.PAGE_EXISTS;
 }
}
}
