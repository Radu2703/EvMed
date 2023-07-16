import java.sql.*;
import javax.swing.JOptionPane;

public class MedicalHistoryManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(long Medical_File_ID, String Employee_CNP, String Sickness, String Severity, String date, String Longevity, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into medical_history values (default,\""+Medical_File_ID+"\",\""+Employee_CNP+"\",\""+Sickness+"\",\""+Severity+"\",\""+date+"\",\""+Longevity+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting medical history: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Medical history\n");
        sb.append("(ID, Medical File ID, Employee CNP, Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from medical_history");
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
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying medical histories: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from medical_history WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying medical history IDs with CNP: "+e.getMessage());}
        return "CNP has no medical history in the database";
    }
    
    public static boolean countFileIDs(String id_med_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from medical_history WHERE Medical_File_ID=\""+id_med_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting medical history id by med file id: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayFileIDs(String id_med_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from medical_history WHERE Medical_File_ID=\""+id_med_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying medical history IDs with med file IDs: "+e.getMessage());}
        return "There are no med history with the specified med file in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from medical_history WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting medical history id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history WHERE ID=\""+ID+"\"");
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
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying medical history by ID: "+e.getMessage());}
     return "Medical history with the specified ID does not exist in the database";
    }
    
    public static void displayst(){
        StringBuffer sb=new StringBuffer();
        sb.append("Medical history\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from medical_history");
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
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying medical histories: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displaySickness(String Sickness){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Sickness: ").append(Sickness).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where Sickness=\""+Sickness+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by sickness: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonth(String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Month: ").append(month).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where MONTH(Date)=\""+month+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayYear(String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Year: ").append(year).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonthYear(String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displaySicknessMonth(String Sickness, String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Sickness: ").append(Sickness).append(", Month: ").append(month).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where Sickness=\""+Sickness+"\" AND MONTH(Date)=\""+month+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by sickness and month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static void displaySicknessYear(String Sickness, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Sickness: ").append(Sickness).append(", Year: ").append(year).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where Sickness=\""+Sickness+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by sickness and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displaySicknessMonthYear(String Sickness, String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Medical history (Sickness: ").append(Sickness).append(", Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Sickness, Severity, Date, Longevity, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_history Where Sickness=\""+Sickness+"\" AND MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying medical history by sickness and month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP_Sickness_Date_FID(String CNP, Long fid, String date, String Sickness){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from medical_history where Employee_CNP=\""+CNP+"\" and Medical_File_ID="+fid+" and Date=\""+date+"\" and Sickness=\""+Sickness+"\"");
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
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching medical history by employee CNP and sickness: "+e.getMessage());}
        return "Medical history does not exist in the database";
    }
}