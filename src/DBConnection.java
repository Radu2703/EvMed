import java.sql.*;
public class DBConnection {//m.p.Singleton
    private static DBConnection instanta;
    private Connection c;
    private Statement stmt;
    private DatabaseMetaData dbMetadata;
    private DBConnection(){
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/work_medical_history", "root", "");
            //stmt=c.createStatement();//numai daca execut doar interogari
            stmt=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dbMetadata = c.getMetaData();
        }catch(SQLException e){e.printStackTrace();}
        
    }
    public Connection getConexiune(){
        return c;
    }
    public Statement getStatement(){
        return stmt;
    }
    
    public DatabaseMetaData getDateMeta(){
        return dbMetadata;
    }
    
    public void inchide(){
        try{
        stmt.close();
        c.close();
        //dbMetadata.close();
           }catch(SQLException e){e.printStackTrace();}
    }
    public static DBConnection getInstanta(){
        if(instanta==null) instanta=new DBConnection();
        return instanta;
    }
}
