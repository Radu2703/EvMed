import java.sql.*;
import javax.swing.JOptionPane;

public class HealthEvaluationManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String Employee_CNP, String Medical_History_Description, String Recent_Medical_Events_Description, String Blood_Pressure, String Ophthalmological_Consultation, String Pulse, String Oxygen_Saturation, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number, String Doctor_Email){
        Statement s=c.getStatement();
        String comanda="insert into yearly_health_evaluation values (default,\""+Employee_CNP+"\",\""+Medical_History_Description+"\",\""+Recent_Medical_Events_Description+"\",\""+Blood_Pressure+"\",\""+Ophthalmological_Consultation+"\",\""+Pulse+"\",\""+Oxygen_Saturation+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\",\""+Doctor_Email+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting health evaluation: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Yearly health evaluation\n");
        sb.append("(ID, Employee CNP, Medical history description, Recent medical events description, Blood pressure, Ophthalmological consultation, Pulse, Oxygen saturation, Date, Building, Street, City, County, Doctor, Doctor Phone Number, Doctor email)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from yearly_health_evaluation");
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
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying health evaluations: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from yearly_health_evaluation WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying yearly health evaluation IDs with CNP: "+e.getMessage());}
        return "CNP has no yearly health evaluation in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from yearly_health_evaluation WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting yearly health evaluation id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from yearly_health_evaluation WHERE ID=\""+ID+"\"");
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
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying health evaluation by ID: "+e.getMessage());}
     return "Health evaluation with the specified ID does not exist in the database";
    }
    
    public static String searchCNP_Date(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from yearly_health_evaluation where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
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
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching health evaluation by employee CNP and date: "+e.getMessage());}
        return "Health evaluation does not exist in the database";
    }
    
    public static boolean uniqueCNP_Date(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(ID) from yearly_health_evaluation where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }      
        }catch(SQLException e){System.out.println("Exception from counting health evaluation by employee CNP and date: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
}