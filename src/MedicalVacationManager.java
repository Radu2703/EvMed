import java.sql.*;
import javax.swing.JOptionPane;

public class MedicalVacationManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String Employee_CNP, String Boss_email, String Start_Date, String End_Date, String Period, String Reason, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into medical_vacation values (default,\""+Employee_CNP+"\",\""+Boss_email+"\",\""+Start_Date+"\",\""+End_Date+"\",\""+Period+"\",\""+Reason+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\",NULL)";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting medical vacation: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Medical Vacations\n");
        sb.append("(ID, Employee CNP, Boss_Email, Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from medical_vacation");
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from medical_vacation WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying medical vacation IDs with CNP: "+e.getMessage());}
        return "CNP has no medical vacation in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from medical_vacation WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting medical vacations id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation WHERE ID=\""+ID+"\"");
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
            sb.append("//");
            sb.append(rs.getString(12));
            sb.append("//");
            sb.append(rs.getString(13));
            sb.append("//");
            sb.append(rs.getString(14));
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying medical vacation by ID: "+e.getMessage());}
     return "Medical vacation with the specified ID does not exist in the database";
    }
    
    public static boolean countNullIDS(){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from medical_vacation WHERE Approval IS NULL");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from displaying medical vacation by ID: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayNullIDS(){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from medical_vacation WHERE Approval IS NULL");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(";");
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying medical vacation by ID: "+e.getMessage());}
     return "Medical vacation with null approvals do not exist in the database";
    }
    
    public static void displayst(){
        StringBuffer sb=new StringBuffer();
        sb.append("Medical Vacations\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from medical_vacation");
        while(rs.next()){
            count++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayReason(String Reason){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Reason: ").append(Reason).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where Reason=\""+Reason+"\"");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by reason: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonth(String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Month: ").append(month).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where MONTH(Start_Date)=\""+month+"\" OR MONTH(End_Date)=\""+month+"\"");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayYear(String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Year: ").append(year).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where YEAR(Start_Date)=\""+year+"\" OR YEAR(End_Date)=\""+year+"\"");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonthYear(String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where (MONTH(Start_Date)=\""+month+"\" OR MONTH(End_Date)=\""+month+"\") AND (YEAR(Start_Date)=\""+year+"\" OR YEAR(End_Date)=\""+year+"\")");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayReasonMonth(String Reason, String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Reason: ").append(Reason).append(", Month: ").append(month).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where Reason=\""+Reason+"\" AND (MONTH(Start_Date)=\""+month+"\" OR MONTH(End_Date)=\""+month+"\")");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by reason and month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static void displayReasonYear(String Reason, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Reason: ").append(Reason).append(", Year: ").append(year).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where Reason=\""+Reason+"\" AND (YEAR(Start_Date)=\""+year+"\" OR YEAR(End_Date)=\""+year+"\")");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by reason and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayReasonMonthYear(String Reason, String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical vacations (Reason: ").append(Reason).append(", Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Start Date, End Date, Period, Reason, Building, Street, City, County, Doctor, Doctor Phone Number, Approval)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_vacation Where Reason=\""+Reason+"\" AND (MONTH(Start_Date)=\""+month+"\" OR MONTH(End_Date)=\""+month+"\") AND (YEAR(Start_Date)=\""+year+"\" OR YEAR(End_Date)=\""+year+"\")");
        while(rs.next()){
            counter++;
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
            sb.append(" ");
            sb.append(rs.getString(12));
            sb.append(" ");
            sb.append(rs.getString(13));
            sb.append(" ");
            sb.append(rs.getString(14));
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical vacations by reason and month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP_Date(String CNP, String Start_Date, String End_Date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from medical_vacation where Employee_CNP=\""+CNP+"\" and Start_Date=\""+Start_Date+"\" and End_Date=\""+End_Date+"\"");
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
                   sb.append(" ");
                   sb.append(rs.getString(12));
                   sb.append(" ");
                   sb.append(rs.getString(13));
                   sb.append(" ");
                   sb.append(rs.getString(14));
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching medical vacation by employee CNP, starting date and ending date: "+e.getMessage());}
        return "Medical vacation with the specified CNP and dates does not exist in the database";
    }
    
    public static boolean approval(long ID, String approval){
        Statement s=c.getStatement();
        try{
            ResultSet rs=s.executeQuery("Select * from medical_vacation where ID=\""+ID+"\"");
            if(rs.next()) {rs.updateString("Approval", approval);
                           rs.updateRow();}
            rs.beforeFirst();
            return true;
                }catch(SQLException e){System.out.println("Exception from modifying medical vacation (approval): "+e.getMessage());}
        return false;
    }
}