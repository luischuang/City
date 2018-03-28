package qst.model;

/**
 * 用户类
 * @author 闯
 *
 */
public class User {
	private int user_id;
	private String user_name;
	private String user_password;
	private int user_type;
	private int user_state;
	
	public User(){
		
	}
	
	public User(int id,String name,String password,int type,int state){
		this.user_id=id;
		this.user_name=name;
		this.user_password=password;
		this.user_type=type;
		this.user_state=state;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public int getUser_state() {
		return user_state;
	}
	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}
	
	
}
