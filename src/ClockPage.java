import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;

public class ClockPage extends JFrame{
    private Clock c;
    public ClockPage(){
    super("Thread clock");
    c=new Clock();
    add(c);
    setSize(400,200);
    setLocationRelativeTo(null);
    addWindowListener(new WindowAdapter()
    {@Override
     public void windowClosing(WindowEvent e)
     {dispose();}
    });
}
    
private class Clock extends JPanel{
    private Color blue;
    public Clock(){
        blue=new Color(30,144,255);
    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)this.getGraphics();
        Font f=new Font("Monospaced", Font.BOLD, 20);
        g2.setFont(f);
        GregorianCalendar c=new GregorianCalendar();
        String timp=c.getTime().toString();
        g2.setColor(blue);
        g2.drawString(timp, 10,70);
        try{
            Thread.sleep(1000);
        }catch(Exception e){}
        g2.setColor(this.getBackground());
        g2.drawString(timp, 10,70);
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        setSize(400,200);
        repaint();
    }
} 
}
