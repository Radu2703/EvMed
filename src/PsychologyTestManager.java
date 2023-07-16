import java.sql.*;
import javax.swing.JOptionPane;

public class PsychologyTestManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String Employee_CNP, String Role, String Type, String Results, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into yearly_psychological_test values (default,\""+Employee_CNP+"\",\""+Role+"\",\""+Type+"\",\""+Results+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting psychological test: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Yearly psychology test\n");
        sb.append("(ID, Employee CNP, Role, Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from yearly_psychological_test");
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
            sb.append("\n");   
            }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying psychological tests: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from yearly_psychological_test WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying psychological test IDs with CNP: "+e.getMessage());}
        return "CNP has no psychological test in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from yearly_psychological_test WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting psychological test id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from yearly_psychological_test WHERE ID=\""+ID+"\"");
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
            }
          return sb.toString();
         }catch(SQLException e){System.out.println("Exception from displaying psychological test by ID: "+e.getMessage());}
     return "Psychological test with the specified ID does not exist in the database";
    }
    
    public static String searchCNP_Date(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from yearly_psychological_test where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
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
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching psychological test by employee CNP and date: "+e.getMessage());}
        return "Psychological test does not exist in the database";
    }
    
    public static boolean uniqueCNP_Date(String CNP, String date){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(ID) from yearly_psychological_test where Employee_CNP=\""+CNP+"\" and Date=\""+date+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }      
        }catch(SQLException e){System.out.println("Exception from counting health evaluation by employee CNP and date: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
}
