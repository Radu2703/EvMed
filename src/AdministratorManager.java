import java.sql.*;
import javax.swing.JOptionPane;

public class AdministratorManager {
    private static DBConnection c=DBConnection.getInstanta();
    private static Connection con=c.getConexiune();
    public static void memorize(String CNP, String Surname, String Name, String Email, String Password, String County, String City, String Phone_Number, String Gender){
        Statement s=c.getStatement();
        String comanda="insert into administrator values (\""+CNP+"\",\""+Surname+"\",\""+Name+"\",\""+Email+"\",\""+Password+"\",\""+County+"\",\""+City+"\",\""+Phone_Number+"\",\""+Gender+"\")";
        try{
            s.executeUpdate(comanda);
        }catch(SQLException e){System.out.println("Exception from inserting administrator: "+e.getMessage());}
    }
    
    public static void display(){
        StringBuffer sb=new StringBuffer();
        sb.append("Administrators\n");
        sb.append("(CNP, Surname, Name, Email, Password, County, City, Phone Number, Gender)\n");
        Statement s=c.getStatement();
           try{
        int count=0;
        ResultSet rs=s.executeQuery("Select * from administrator");
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
        sb.append("Number of accounts: ").append(count);
         }catch(SQLException e){System.out.println("Exception from displaying administrators: "+e.getMessage());}
    JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static String searchCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from administrator where CNP=\""+CNP+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching administrator by CNP: "+e.getMessage());}
        return "Administrator does not exist in the database";
    }
    
    public static String searchEmailbyCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Email from administrator where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching administrator email by CNP: "+e.getMessage());}
        return "Administrator does not have an email in the database";
    }
    
    public static String searchPasswordbyCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Password from administrator where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }   
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from searching administrator password by CNP: "+e.getMessage());}
        return "Administrator does not have a password in the database";
    }
    
    public static String searchEmailPass(String Email, String Password){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select * from administrator where Email=\""+Email+"\" and Password=\""+Password+"\"");
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
        }catch(SQLException e){System.out.println("Exception from searching administrator by email and password: "+e.getMessage());}
        return "Administrator does not exist in the database";
    }
    
    public static boolean searchEmailPassLog(String Email, String Password){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(CNP) from administrator where Email=\""+Email+"\" and Password=\""+Password+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }   
        }catch(SQLException e){System.out.println("Exception from counting administrator by email and password: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
    }
    
    public static String searchEmailPassCNP(String Email, String Password){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select CNP from administrator where Email=\""+Email+"\" and Password=\""+Password+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   }
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from finding administrator CNP by email and password: "+e.getMessage());}
    return "Administrator with the specified email and password does not have a CNP in the database";
    }
    
    public static String searchCNPName(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Surname, Name from administrator where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                   sb.append(" ");
                   sb.append(rs.getString(2));
                   }
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from finding administrator name by CNP: "+e.getMessage());}
    return "Administrator with the specified CNP does not have a name in the database";
    }
    
    public static boolean modifyPassword(String Email, String oldPassword, String newPassword){
        Statement s=c.getStatement();
        try{
            ResultSet rs=s.executeQuery("Select * from administrator where Email=\""+Email+"\" and Password=\""+oldPassword+"\"");
            if(rs.next()) {rs.updateString("Password", newPassword);
                           rs.updateRow();}
            rs.beforeFirst();
            return true;
            }catch(SQLException e){System.out.println("Exception from modifying administrator (password): "+e.getMessage());}
        return false;
    }
    
    public static void delete(String CNP, String Surname, String Name, String Email, String Phone_Number){
        Statement s=c.getStatement();
        String comanda="Delete from administrator where CNP=\""+CNP+"\" and Surname=\""+Surname+"\" and Name=\""+Name+"\" and Email=\""+Email+"\" and Phone_Number=\""+Phone_Number+"\"";
        try{s.executeUpdate(comanda); JOptionPane.showMessageDialog(null, "Doctor "+Surname+" "+Name+" has been deleted");
        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Exception from deleting administrator: "+e.getMessage());}
    }
    
    public static boolean counter(){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
        try{
        ResultSet rs=s.executeQuery("Select COUNT(CNP) from administrator");
        while(rs.next()){
            sb.append(rs.getString(1));   
            }
        }catch(SQLException e){System.out.println("Exception from counting administrators: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return false;
        else return true;
    }
    
    public static int countCNPs(){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
        try{
        ResultSet rs=s.executeQuery("Select COUNT(CNP) from administrator");
        while(rs.next()){
            sb.append(rs.getString(1));   
            }
        }catch(SQLException e){System.out.println("Exception from counting administrators: "+e.getMessage());}
        String st=sb.toString();
        return Integer.parseInt(st);
    }
    
    public static String displayCNPs(){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select CNP from administrator");
        while(rs.next()){
            sb.append(rs.getString(1));
            sb.append(" ");
        }
        return sb.toString();
        }catch(SQLException e){System.out.println("Exception from displaying admins CNPs: "+e.getMessage());}
        return "No admin CNPs in the database";
    }
    
    public static String displayCNP(String CNP){
        StringBuffer sb=new StringBuffer();
        Statement s=c.getStatement();
           try{
        ResultSet rs=s.executeQuery("Select * from administrator WHERE CNP=\""+CNP+"\"");
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
        }catch(SQLException e){System.out.println("Exception from displaying admin by CNP: "+e.getMessage());}
        return "No admin with the CNP in the database";
    }
    
    public static boolean uniqueCNP(String CNP){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(CNP) from administrator where CNP=\""+CNP+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting administrator by CNP: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
    
    public static boolean uniqueEmail(String Email){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(Email) from administrator where Email=\""+Email+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }   
        }catch(SQLException e){System.out.println("Exception from counting administrator by email: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
    
    public static String emailPass(String Email){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select Password from administrator where Email=\""+Email+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }
               return sb.toString();
        }catch(SQLException e){System.out.println("Exception from finding administrator password by email: "+e.getMessage());}
    return "Administrator with the specified email does not have a password in the database";
    }
    
    public static boolean uniquePhoneNumber(String PhoneNumber){
         StringBuffer sb=new StringBuffer();
         Statement s=c.getStatement();
        try{
           ResultSet rs=s.executeQuery("Select COUNT(Phone_Number) from administrator where Phone_Number=\""+PhoneNumber+"\"");
               while(rs.next()) {
                   sb.append(rs.getString(1));
                }
        }catch(SQLException e){System.out.println("Exception from counting administrator by phone number: "+e.getMessage());}
        String st=sb.toString();
        if(st.equals("0")) return true;
        else return false;
    }
}