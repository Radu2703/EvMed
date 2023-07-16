import java.sql.*;
import javax.swing.JOptionPane;

public class MedicalFileManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String Employee_CNP, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into medical_file values (default,\""+Employee_CNP+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting medical file: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Medical files\n");
        sb.append("(ID, Employee CNP, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from medical_file");
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
            sb.append("\n");   
        }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying medical files: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from medical_file WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying medical file IDs with CNP: "+e.getMessage());}
        return "CNP has no medical files in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from medical_file WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting medical files id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from medical_file WHERE ID=\""+ID+"\"");
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
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying medical file by ID: "+e.getMessage());}
     return "Medical file with the specified ID does not exist in the database";
    }
    
    public static String searchCNP_Date(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from medical_file where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
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
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching medical file by employee CNP: "+e.getMessage());}
        return "Medical file does not exist in the database";
    }
    
    public static String searchID(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select ID from medical_file where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching medical file by employee CNP: "+e.getMessage());}
        return "Medical file does not exist in the database";
    }
}