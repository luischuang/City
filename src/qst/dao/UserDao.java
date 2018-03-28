package qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qst.model.User;
import qst.util.JDBCUtil;
/**
 * 瀵圭敤鎴风殑鍚庡彴澶勭悊鍜屾暟鎹簱鎿嶄綔
 * @author 闂�
 *
 */
public class UserDao {
    static Connection conn;
	static PreparedStatement psmt;
	static ResultSet rs ; 
	/**
	 * 鐢ㄦ埛鐧诲綍
	 * @param username
	 * @param password
	 * @return
	 */
	public static User login(String username,String password){
		User user=null;
		String sql = "select * from tb_user where user_state = 0 and user_name ='"+username+"' and user_password = '"+password+"'";
        System.out.println(sql);
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs = psmt.executeQuery();  
            if (rs.next()) {  
            	user=new User();
            	user.setUser_id(rs.getInt("id"));
            	user.setUser_name(username);
            	user.setUser_password(password);
            	user.setUser_type(rs.getInt("user_type"));
            	user.setUser_state(rs.getInt("user_state"));
            	System.out.println(user.getUser_name());
                //user = new User(rs.getInt("id"),rs.getString("user_name") , rs.getString("user_password"),rs.getInt("user_type"),rs.getInt("user_state"));   
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return user;
	}
	public static boolean modifyUser(int userId,String newPass){
		String sql="update tb_user set user_password = '"+newPass+"' where id = ?";
		int i=0;
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setInt(1, userId);

        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	/**
	 * 鏌ユ壘鐢ㄦ埛鏄惁瀛樺湪
	 * @param username
	 * @return
	 */
	public static boolean checkUser(String username){
		boolean f=false;
		String sql = "select * from tb_user where user_name='"+username+"'";
        try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs = psmt.executeQuery();  
            if (rs.next()){
            	f=true;
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return f;
	}
	
	/**
	 * 鐢ㄦ埛娉ㄥ唽
	 * @param user
	 * @return
	 */
	public static boolean register(User user){
		int i=0;
		String sql = "insert into tb_user(user_name,user_password,user_type,user_state) values(?,?,0,0)";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setString(1, user.getUser_name());
        	psmt.setString(2, user.getUser_password());
        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	/**
	 * 鍒嗛〉鏌ヨ鎵�鏈夌敤鎴�
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public static List<User> getUsers(String userid,int begin,int end) {
		// TODO Auto-generated method stub
		List<User> userList=new ArrayList<User>();
		String sql = "select * from tb_user where user_state = 0";

		if(!"".equals(userid)&&userid!=null){
			sql=sql+" and id like '%"+userid+"%'";
		}
		sql=sql+" LIMIT "+begin+","+end+" ";
        try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs = psmt.executeQuery();  
            while (rs.next()) { 
            	User user=new User();
            	user.setUser_id(rs.getInt("id"));
            	user.setUser_name(rs.getString("user_name"));
            	user.setUser_password(rs.getString("user_password"));
            	user.setUser_type(rs.getInt("user_type"));
            	user.setUser_state(rs.getInt("user_state"));
            	userList.add(user);
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return userList;
	}
	/**
	 * 鏍规嵁ID杩戜技寰楀埌鐢ㄦ埛鍒楄〃
	 * @param userid
	 * @return
	 */
	public static List<User> getAllUsers(String userid) {
		// TODO Auto-generated method stub
		List<User> userList=new ArrayList<User>();
		String sql = "select * from tb_user where user_state = 0";
		if(!"".equals(userid)&&userid!=null){
			sql=sql+" and id like '%"+userid+"%'";
		}
        try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs = psmt.executeQuery();  
            while (rs.next()) { 
            	User user=new User();
            	user.setUser_id(rs.getInt("id"));
            	user.setUser_name(rs.getString("user_name"));
            	user.setUser_password(rs.getString("user_password"));
            	user.setUser_type(rs.getInt("user_type"));
            	user.setUser_state(rs.getInt("user_state"));
            	userList.add(user);
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return userList;
	}
	/**
	 * 鍒犻櫎ID涓簎id鐨勭敤鎴�
	 * @param uid
	 * @return
	 */
	public static boolean deleteUserById(int uid) {
		// TODO Auto-generated method stub
		int i=0;
		String sql = "delete from tb_user where id=?";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setInt(1, uid);

        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	/**
	 * 鏇存柊鐢ㄦ埛鐘舵��
	 * @param uid
	 * @return
	 */
	public static boolean updateUserStateById(int uid) {
		// TODO Auto-generated method stub
		int i=0;
		String sql = "update tb_user set user_state=1 where id=?";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setInt(1, uid);

        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	/**
	 * 淇敼鐢ㄦ埛瀵嗙爜
	 * @param uid
	 * @param password
	 * @return
	 */
	public static boolean updateUserById(int uid,String password) {
		// TODO Auto-generated method stub
		int i=0;
		String sql = "update tb_user set user_password=? where id=?";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setString(1, password);
        	psmt.setInt(2, uid);

        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	/**
	 * 鏍规嵁ID鏌ユ壘姝ｅ父鐢ㄦ埛
	 * @param uid
	 * @return
	 */
	public static User getUserById(int uid) {
		// TODO Auto-generated method stub
		User user=null;
		String sql = "select * from tb_user where user_state = 0 and id = "+uid;

        try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs = psmt.executeQuery();  
            if (rs.next()) { 
            	user=new User();
            	user.setUser_id(rs.getInt("id"));
            	user.setUser_name(rs.getString("user_name"));
            	user.setUser_password(rs.getString("user_password"));
            	user.setUser_type(rs.getInt("user_type"));
            	user.setUser_state(rs.getInt("user_state"));
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return user;
	}
}
