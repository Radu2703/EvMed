import java.sql.*;
import javax.swing.JOptionPane;

public class HealthCertificateManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String Employee_CNP, String Sickness, String Recommendations, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into health_certificate values (default,\""+Employee_CNP+"\",\""+Sickness+"\",\""+Recommendations+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting health certificate: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Health certificates\n");
        sb.append("(ID, Employee CNP, Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from health_certificate");
        while(rs.next()){
            count++;
            sb.append(rs.getString(1));
            sb.append(" ");
            sb.append(rs.getString(2));
            sb.append(" ");
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from health_certificate WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying health certificate IDs with CNP: "+e.getMessage());}
        return "CNP has no health certificate in the database";
    }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate WHERE ID=\""+ID+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append("//");
            sb.append(rs.getString(2));
            sb.append("//");
            sb.append(rs.getString(3));
            sb.append("//");
            sb.append(rs.getString(4));
            sb.append("//");
            sb.append(rs.getString(5));
            sb.append("//");
            sb.append(rs.getString(6));
            sb.append("//");
            sb.append(rs.getString(7));
            sb.append("//");
            sb.append(rs.getString(8));
            sb.append("//");
            sb.append(rs.getString(9));
            sb.append("//");
            sb.append(rs.getString(10));
            sb.append("//");
            sb.append(rs.getString(11));
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying health certificate by ID: "+e.getMessage());}
     return "Health certificate with the specified ID does not exist in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from health_certificate WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting health certificate id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static void displayst(){
        StringBuffer sb=new StringBuffer();
        sb.append("Health certificates\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from health_certificate");
        while(rs.next()){
            count++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
 
    public static void displaySickness(String Sickness){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Sickness: ").append(Sickness).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where Sickness=\""+Sickness+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by sickness: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonth(String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Month: ").append(month).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where MONTH(Date)=\""+month+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayYear(String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Year: ").append(year).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where YEAR(Date)=\""+year+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonthYear(String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displaySicknessMonth(String Sickness, String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Sickness: ").append(Sickness).append(", Month: ").append(month).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where Sickness=\""+Sickness+"\" AND MONTH(Date)=\""+month+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by sickness and month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static void displaySicknessYear(String Sickness, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Sickness: ").append(Sickness).append(", Year: ").append(year).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where Sickness=\""+Sickness+"\" AND YEAR(Date)=\""+year+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by sickness and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displaySicknessMonthYear(String Sickness, String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Health certificates (Sickness: ").append(Sickness).append(", Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Sickness, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from health_certificate Where Sickness=\""+Sickness+"\" AND MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
        while(rs.next()){
            counter++;
            sb.append(rs.getString(3));
            sb.append(" ");
            sb.append(rs.getString(4));
            sb.append(" ");
            sb.append(rs.getString(5));
            sb.append(" ");
            sb.append(rs.getString(6));
            sb.append(" ");
            sb.append(rs.getString(7));
            sb.append(" ");
            sb.append(rs.getString(8));
            sb.append(" ");
            sb.append(rs.getString(9));
            sb.append(" ");
            sb.append(rs.getString(10));
            sb.append(" ");
            sb.append(rs.getString(11));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying health certificates by sickness and month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP_Date_Sickness(String CNP, String date, String Sickness){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from health_certificate where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\" and Sickness=\""+Sickness+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   sb.append(" ");
                   sb.append(rs.getString(2));
                   sb.append(" ");
                   sb.append(rs.getString(3));
                   sb.append(" ");
                   sb.append(rs.getString(4));
                   sb.append(" ");
                   sb.append(rs.getString(5));
                   sb.append(" ");
                   sb.append(rs.getString(6));
                   sb.append(" ");
                   sb.append(rs.getString(7));
                   sb.append(" ");
                   sb.append(rs.getString(8));
                   sb.append(" ");
                   sb.append(rs.getString(9));
                   sb.append(" ");
                   sb.append(rs.getString(10));
                   sb.append(" ");
                   sb.append(rs.getString(11));
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching health certificate by employee CNP and date: "+e.getMessage());}
        return "Health certificate does not exist in the database";
    }
}
