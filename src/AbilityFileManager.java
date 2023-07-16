import java.sql.*;
import javax.swing.JOptionPane;

public class AbilityFileManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorizeHire(String Employee_CNP, String Medical_History_Description, String Recent_Medical_Events_Description, String Blood_Pressure, String Ophthalmological_Consultation, String Pulse, String Oxygen_Saturation, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number, String Result){
        Statement s=c.getStatement();
        String comanda="insert into ability_file values (default,\""+Employee_CNP+"\",\""+Medical_History_Description+"\",\""+Recent_Medical_Events_Description+"\",\""+Blood_Pressure+"\",\""+Ophthalmological_Consultation+"\",\""+Pulse+"\",\""+Oxygen_Saturation+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\",\""+Result+"\",NULL)";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting ability file: "+e.getMessage());}
    }
    
    public static void memorizeTest(String Employee_CNP, String Medical_History_Description, String Recent_Medical_Events_Description, String Blood_Pressure, String Ophthalmological_Consultation, String Pulse, String Oxygen_Saturation, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number, String Doctor_Email){
        Statement s=c.getStatement();
        String comanda="insert into ability_file values (default,\""+Employee_CNP+"\",\""+Medical_History_Description+"\",\""+Recent_Medical_Events_Description+"\",\""+Blood_Pressure+"\",\""+Ophthalmological_Consultation+"\",\""+Pulse+"\",\""+Oxygen_Saturation+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\",NULL,\""+Doctor_Email+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting ability file: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Ability File\n");
        sb.append("(ID, Employee CNP, Medical history description, Recent medical events description, Blood pressure, Ophthalmological consultation, Pulse, Oxygen saturation, Date, Building, Street, City, County, Doctor, Doctor phone number, Result, Doctor email)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from ability_file");
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
            sb.append(" ");
            sb.append(rs.getString(15));
            sb.append(" ");
            sb.append(rs.getString(16));
            sb.append(" ");
            sb.append(rs.getString(17));
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying ability files: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from ability_file WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying ability file IDs with CNP: "+e.getMessage());}
        return "CNP has no ability files in the database";
    }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from ability_file WHERE ID=\""+ID+"\"");
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
            sb.append("//");
            sb.append(rs.getString(15));
            sb.append("//");
            sb.append(rs.getString(16));
            sb.append("//");
            sb.append(rs.getString(17));
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying ability file by ID: "+e.getMessage());}
     return "Ability file with the specified ID does not exist in the database";
    }
    
    public static boolean countNullIDS(String email){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from ability_file WHERE Result IS NULL AND Doctor_Email=\""+email+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting ability file by null result: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from ability_file WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting ability file id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayNullIDS(String email){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from ability_file WHERE Result IS NULL AND Doctor_Email=\""+email+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append("//");
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying ability file with null result: "+e.getMessage());}
     return "Ability file with null results do not exist in the database";
    }
    
    public static String searchCNP_Date(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from ability_file where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
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
                   sb.append(" ");
                   sb.append(rs.getString(15));
                   sb.append(" ");
                   sb.append(rs.getString(16));
                   sb.append(" ");
                   sb.append(rs.getString(17));
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching ability file by employee CNP and date: "+e.getMessage());}
        return "Ability file does not exist in the database";
    }
    
    public static boolean signature(long ID, String result){
        Statement s=c.getStatement();
        try{
            ResultSet rs=s.executeQuery("Select * from ability_file where ID=\""+ID+"\"");
            if(rs.next()) {rs.updateString("Result", result);
                           rs.updateRow();}
            rs.beforeFirst();
            return true;
                }catch(SQLException e){System.out.println("Exception from modifying ability file (result): "+e.getMessage());}
        return false;
    }
}