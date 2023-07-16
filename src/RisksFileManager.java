import java.sql.*;
import javax.swing.JOptionPane;

public class RisksFileManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String Employee_CNP, long File_ID, String Desc, String Chance, String Recommendations, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into risks_file values (default,\""+Employee_CNP+"\",\""+File_ID+"\",\""+Desc+"\",\""+Chance+"\",\""+Recommendations+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting risks file: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
        sb.append("Risks files\n");
        sb.append("(ID, Employee CNP, Description, Chance, Recommendations, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from risks_file");
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
         }catch(SQLException e){System.out.println("Exception from displaying risks files: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from risks_file WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying risks file IDs with CNP: "+e.getMessage());}
        return "CNP has no risks file in the database";
    }
    
    public static String displayFileIDs(String id_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from risks_file WHERE File_ID=\""+id_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying risks file IDs with file IDs: "+e.getMessage());}
        return "CNP has no main risks file in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from risks_file WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting risks files id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from risks_file WHERE ID=\""+ID+"\"");
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
         }catch(SQLException e){System.out.println("Exception from displaying risks file by ID: "+e.getMessage());}
     return "Risks file with the specified ID does not exist in the database";
    }
    
    public static String searchCNP_FID_Desc(String CNP, Long fid, String Desc){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from risks_file where Employee_CNP=\""+CNP+"\" and File_ID="+fid+" and Description=\""+Desc+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching risks file by employee CNP and description: "+e.getMessage());}
        return "Risks file does not exist in the database";
    }
}
