package qst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qst.model.User;

/**
 * 鏁版嵁搴撹繛鎺ュ伐鍏�
 * @author 闂�
 *
 */
public class JDBCUtil { 
	public static final String url = "jdbc:mysql://localhost:3306/city?useUnicode=true&characterEncoding=utf-8";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "123456"; 
    /**
     * 鑾峰彇杩炴帴
     * @return
     */
    public static Connection getConnecttion(){
    	Connection conn=null;
    	try {
			Class.forName(name);
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return conn;
    }
    /**
     * 鍏抽棴杩炴帴
     * @param conn
     * @param stmt
     * @param psmt
     * @param rs
     */
    public static void close(Connection conn,Statement stmt,
    		PreparedStatement psmt,ResultSet rs) {
    	try{
    		if(conn!=null){
    			conn.close();
    		}
    		if(stmt!=null){
    			stmt.close();
    		}
    		if(psmt!=null){
    			psmt.close();
    		}
    		if(rs!=null){
    			rs.close();
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
		
	}
    
    public static List<User> getUsersFromMySQLByName (String name) {  
        ArrayList<User> list = new ArrayList<User>();

        String sql = "select * from tb_user";
        try {  
            Connection conn=getConnecttion();
        	PreparedStatement psmt=conn.prepareStatement(sql);
        	ResultSet rs = psmt.executeQuery();  
            while (rs.next()) {   
                User user = new User(rs.getInt("id"),rs.getString("user_name") , rs.getString("user_password"),rs.getInt("user_type"),rs.getInt("user_statue"));  
                list.add(user);  
            }  
            rs.close();
            psmt.close();
            conn.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return list;
    }
}

