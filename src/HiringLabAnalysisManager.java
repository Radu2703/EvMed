import java.sql.*;
import javax.swing.JOptionPane;

public class HiringLabAnalysisManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(long Medical_File_ID, String Employee_CNP, String Type, String Results, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into hiring_lab_analysis values (default,\""+Medical_File_ID+"\",\""+Employee_CNP+"\",\""+Type+"\",\""+Results+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting lab analysis: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Hiring lab analysis\n");
        sb.append("(ID, Medical File ID, Employee CNP, Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis");
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
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from hiring_lab_analysis WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying lab analysis IDs with CNP: "+e.getMessage());}
        return "CNP has no lab analyses in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from hiring_lab_analysis WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting lab analysis id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis WHERE ID=\""+ID+"\"");
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
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by ID: "+e.getMessage());}
     return "Lab analysis with the specified ID does not exist in the database";
    }
    
    public static boolean countFileIDs(String id_med_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from hiring_lab_analysis WHERE Medical_File_ID=\""+id_med_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting lab analysis id by med file id: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayFileIDs(String id_med_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from hiring_lab_analysis WHERE Medical_File_ID=\""+id_med_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying lab analysis IDs with med file IDs: "+e.getMessage());}
        return "There are no lab analysis with the specified med file in the database";
    }
    
    public static void displayst(){
        StringBuffer sb=new StringBuffer();
        sb.append("Hiring lab analysis\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis");
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
            sb.append("\n");   
        }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayType(String Type){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Type: ").append(Type).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where Type=\""+Type+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by type: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonth(String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Month: ").append(month).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where MONTH(Date)=\""+month+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayYear(String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Year: ").append(year).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonthYear(String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayTypeMonth(String Type, String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Type: ").append(Type).append(", Month: ").append(month).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where Type=\""+Type+"\" AND MONTH(Date)=\""+month+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by type and month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static void displayTypeYear(String Type, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Type: ").append(Type).append(", Year: ").append(year).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where Type=\""+Type+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by type and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayTypeMonthYear(String Type, String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Lab analysis (Type: ").append(Type).append(", Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Type, Results, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis Where Type=\""+Type+"\" AND MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying lab analysis by type and month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP_Fid_Date_Type(String CNP, Long fid, String date, String Type){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from hiring_lab_analysis where Employee_CNP=\""+CNP+"\" and Medical_File_ID="+fid+" and Date=\""+date+"\" and Type=\""+Type+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching lab analysis by employee CNP and lab analysis type: "+e.getMessage());}
        return "Lab analysis does not exist in the database";
    }
}