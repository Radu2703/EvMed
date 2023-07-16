import java.sql.*;
import javax.swing.JOptionPane;

public class EmployeeManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String CNP, String Surname, String Name, String Email, String Password, String County, String City, String Role, String Phone_Number, String Gender){
        Statement s=c.getStatement();
        String comanda="insert into employee values (\""+CNP+"\",\""+Surname+"\",\""+Name+"\",\""+Email+"\",\""+Password+"\",\""+County+"\",\""+City+"\",\""+Role+"\",\""+Phone_Number+"\",\""+Gender+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting employee: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Employees\n");
        sb.append("(CNP, Surname, Name, Email, Password, County, City, Role, Phone Number, Gender)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from employee");
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
            sb.append("\n");   
        }
        sb.append("Number of accounts: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying employees: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from employee where CNP=\""+CNP+"\"");
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
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching employee by CNP: "+e.getMessage());}
        return "Employee does not exist in the database";
    }
    
    public static String searchEmailbyCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Email from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching employee email by CNP: "+e.getMessage());}
        return "Employee does not have an email in the database";
    }
    
    public static String searchPasswordbyCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Password from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching employee password by CNP: "+e.getMessage());}
        return "Employee does not have a password in the database";
    }
    
    public static String searchEmailPass(String Email, String Password){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from employee where Email=\""+Email+"\" and Password=\""+Password+"\"");
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
                   sb.append("\n");
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching employee by email and password: "+e.getMessage());}
        return "Employee does not exist in the database";
    }
    
    public static boolean searchEmailPassLog(String Email, String Password){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(CNP) from employee where Email=\""+Email+"\" and Password=\""+Password+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }   
        }catch(SQLException e){System.out.println("Exception from counting employee by email and password: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
    }
    
    public static String searchEmailPassCNP(String Email, String Password){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select CNP from employee where Email=\""+Email+"\" and Password=\""+Password+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from finding employee CNP by email and password: "+e.getMessage());}
    return "Employee with the specified email and password does not have a CNP in the database";
    }
    
    public static String searchCNPName(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Surname, Name from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   sb.append(" ");
                   sb.append(rs.getString(2));
                   }
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from finding employee name by CNP: "+e.getMessage());}
    return "Employee with the specified CNP does not have a name in the database";
    }
    
    public static boolean modifyPassword(String Email, String oldPassword, String newPassword){
        Statement s=c.getStatement();
        try{
            ResultSet rs=s.executeQuery("Select * from employee where Email=\""+Email+"\" and Password=\""+oldPassword+"\"");
            if(rs.next()) {rs.updateString("Password", newPassword);
                           rs.updateRow();}
            rs.beforeFirst();
            return true;
                }catch(SQLException e){System.out.println("Exception from modifying employee (password): "+e.getMessage());}
        return false;
    }
    
    public static void delete(String CNP, String Surname, String Name, String Email, String Role, String Phone_Number){
        Statement s=c.getStatement();
        String comanda="Delete from employee where CNP=\""+CNP+"\" and Surname=\""+Surname+"\" and Name=\""+Name+"\" and Email=\""+Email+"\" and Role=\""+Role+"\" and Phone_Number=\""+Phone_Number+"\"";
        try{s.executeUpdate(comanda); JOptionPane.showMessageDialog(null, "Employee "+Surname+" "+Name+" has been deleted");
        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Exception from deleting employee: "+e.getMessage());}
    }
    
    public static boolean uniqueCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(CNP) from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting employees by CNP: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
    
    public static boolean uniqueEmail(String Email){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(Email) from employee where Email=\""+Email+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting employees by email: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
    
    public static String emailPass(String Email){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Password from employee where Email=\""+Email+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from finding employee password by email: "+e.getMessage());}
    return "Employee with the specified email does not have a password in the database";
    }
    
    public static boolean uniquePhoneNumber(String PhoneNumber){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(Phone_Number) from employee where Phone_Number=\""+PhoneNumber+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting employees by phone number: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
    
    public static boolean bossRole(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Role from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting employees by CNP: "+e.getMessage());}
        String st=sb.toString();
        if(st.toLowerCase().equals("director")||st.toLowerCase().equals("department boss")||st.toLowerCase().equals("manager")) return true;
        else return false;
    }
    
    public static String getRole(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Role from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching employee by CNP for role: "+e.getMessage());}
        return "Employee does not exist in the database";
    }
    
    public static boolean managerRole(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Role from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting employees by CNP: "+e.getMessage());}
        String st=sb.toString();
        if(st.toLowerCase().equals("manager")) return true;
        else return false;
    }
    
    public static boolean managerEmail(String Email){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Role from employee where Email=\""+Email+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from searching manager employees by email: "+e.getMessage());}
        String st=sb.toString();
        if(st.toLowerCase().equals("manager")) return true;
        else return false;
    }
    
    public static boolean managerCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Role from employee where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from searching manager employees by CNP: "+e.getMessage());}
        String st=sb.toString();
        if(st.toLowerCase().equals("manager")) return true;
        else return false;
    }
}