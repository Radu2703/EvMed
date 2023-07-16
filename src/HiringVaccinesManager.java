import java.sql.*;
import javax.swing.JOptionPane;

public class HiringVaccinesManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(long Medical_File_ID, String Employee_CNP, String Type, String date, String Building, String Street, String City, String County, String Doctor, String Doctor_Phone_Number){
        Statement s=c.getStatement();
        String comanda="insert into hiring_vaccines values (default,\""+Medical_File_ID+"\",\""+Employee_CNP+"\",\""+Type+"\",\""+date+"\",\""+Building+"\",\""+Street+"\",\""+City+"\",\""+County+"\",\""+Doctor+"\",\""+Doctor_Phone_Number+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting vaccines: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Hiring vaccines\n");
        sb.append("(ID, Medical File ID, Employee CNP, Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines");
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
         }catch(SQLException e){System.out.println("Exception from displaying vaccines: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String displayIDs(String cnp){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from hiring_vaccines WHERE Employee_CNP=\""+cnp+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");   
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying vaccine IDs with CNP: "+e.getMessage());}
        return "CNP has no vaccines in the database";
    }
    
    public static boolean countIDS(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from hiring_vaccines WHERE Employee_CNP=\""+CNP+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting vaccines id by cnp: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayID(String ID){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines WHERE ID=\""+ID+"\"");
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
         }catch(SQLException e){System.out.println("Exception from displaying hiring vaccines by ID: "+e.getMessage());}
     return "Hiring vaccines with the specified ID does not exist in the database";
    }
    
    public static void displayst(){
        StringBuffer sb=new StringBuffer();
        sb.append("Hiring vaccines\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines");
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
            sb.append("\n");   
        }
        sb.append("Number of documents: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from hiring_vaccines where Employee_CNP=\""+CNP+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching vaccine by employee CNP: "+e.getMessage());}
        return "Vaccine does not exist in the database";
    }
    
    public static boolean countFileIDs(String id_med_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select COUNT(ID) from hiring_vaccines WHERE Medical_File_ID=\""+id_med_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            }
         }catch(SQLException e){System.out.println("Exception from counting vaccines id by med file id: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
     }
    
    public static String displayFileIDs(String id_med_file){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select ID from hiring_vaccines WHERE Medical_File_ID=\""+id_med_file+"\"");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying vaccines IDs with med file IDs: "+e.getMessage());}
        return "There are no vaccine with the specified med file in the database";
    }
    
    public static String searchCNP_Type(String CNP, String Type){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from hiring_vaccines where Employee_CNP=\""+CNP+"\" and Type=\""+Type+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching vaccine by employee CNP and vaccine type: "+e.getMessage());}
        return "Vaccine does not exist in the database";
    }
    
    public static String searchCNP_Fid_Date_Type(String CNP, Long fid, String date, String Type){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from hiring_vaccines where Employee_CNP=\""+CNP+"\" and Medical_File_ID="+fid+" and Date=\""+date+"\" and Type=\""+Type+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching vaccine by employee CNP and medical file ID and date and type: "+e.getMessage());}
        return "Vaccine does not exist in the database";
    }
    
    public static void displayType(String Type){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Type: ").append(Type).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where Type=\""+Type+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by type: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonth(String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Month: ").append(month).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where MONTH(Date)=\""+month+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayYear(String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Year: ").append(year).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayMonthYear(String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayTypeMonth(String Type, String month){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Type: ").append(Type).append(", Month: ").append(month).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where Type=\""+Type+"\" AND MONTH(Date)=\""+month+"\"");
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
            sb.append("\n");   
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by type and month: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    
    public static void displayTypeYear(String Type, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Type: ").append(Type).append(", Year: ").append(year).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where Type=\""+Type+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by type and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void displayTypeMonthYear(String Type, String month, String year){
        StringBuffer sb=new StringBuffer();
        int counter=0;
        sb.append("Vaccines (Type: ").append(Type).append(", Month: ").append(month).append(", Year: ").append(year).append(")\n");
        sb.append("(Type, Date, Building, Street, City, County, Doctor, Doctor Phone Number)\n");
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from hiring_vaccines Where Type=\""+Type+"\" AND MONTH(Date)=\""+month+"\" AND YEAR(Date)=\""+year+"\"");
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
            sb.append("\n");
            }
          sb.append("Number of elements: ").append(counter);
         }catch(SQLException e){System.out.println("Exception from displaying vaccines by type and month and year: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
}