package qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qst.model.Info;
import qst.util.JDBCUtil;
/**
 * 瀵逛俊鎭殑鍚庡彴澶勭悊鍜屾暟鎹簱鐨勭浉鍏虫搷浣�
 * @author 闂�
 *
 */
public class InfoDao {
    static Connection conn;
	static PreparedStatement psmt;
	static ResultSet rs ; 
	
	/**
	 * 娣诲姞淇℃伅
	 * @param info
	 * @return
	 */
	public int addInfo(Info info) {
		// TODO Auto-generated method stub
		int i=0;
		String sql = "insert into tb_info(info_type,info_title,info_content,info_linkman,info_phone,info_email,info_user_id)"
				+ " values(?,?,?,?,?,?,?)";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setInt(1, info.getInfotypeid());
        	psmt.setString(2, info.getInfoTitle());
        	psmt.setString(3, info.getInfocontent());
        	psmt.setString(4, info.getInfolinkman());
        	psmt.setString(5, String.valueOf(info.getInfophone()));
        	psmt.setString(6, info.getInfoemail());
        	psmt.setInt(7, info.getInfouserid());
        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		
		return i;
	}
	/**
	 * 鏍规嵁淇℃伅ID鏌ユ壘鍏嶈垂淇℃伅
	 * @param infotypeid
	 * @return
	 */
	public Info selectFreeInfo(int infotypeid) {
		// TODO Auto-generated method stub
		Info info=null;
		String sql = "select * from tb_info a,tb_type b where a.info_type = b.type_sign ";
		sql=sql+" and info_payfor = 0 and a.info_type = "+infotypeid;
		sql=sql+" order by info_date desc";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs=psmt.executeQuery(sql);
        	if(rs.next()){
        	info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	//info.setInfouserid(infotypeid);
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));

        	}
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return info;
	}
	
	/**
	 * 鏍规嵁淇℃伅ID鏌ユ壘鏀惰垂淇℃伅
	 * @param infotypeid
	 * @return
	 */
	public Info selectPayInfo(int infotypeid) {
		// TODO Auto-generated method stub
		Info info=null;
		String sql = "select * from tb_info a,tb_type b where a.info_type = b.type_sign ";
		sql=sql+" and info_payfor = 1 and a.info_type = "+infotypeid;
		sql=sql+" order by info_date desc";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs=psmt.executeQuery(sql);
        	if(rs.next()){
        	info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	//info.setInfouserid(infotypeid);
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	}
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return info;
	}
	/**
	 * 鏍规嵁淇℃伅绫诲瀷鏌ユ壘淇℃伅
	 * @param sqlvalue
	 * @param subsql
	 * @param type
	 * @return
	 */
	public List<Info> searchInfo(String sqlvalue, String subsql, String type) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			if(subsql!=null&&!subsql.equals("")){
				if(subsql.equals("info_content")){
					sql = sql +" and info_content";
				}else if (subsql.equals("info_phone")) {
					sql = sql +" and info_phone";
				}else if (subsql.equals("info_email")) {
					sql = sql +" and info_email";
				}else if (subsql.equals("id")) {
					sql = sql +" and id";
				}else if (subsql.equals("info_title")) {
					sql = sql +" and info_title";
				}else if (subsql.equals("info_linkman")) {
					sql = sql +" and info_linkman";
				}

				if(type.equals("all")){
					sql=sql+" = '"+sqlvalue+"'";
				}else if(type.equals("like")){
					sql=sql+" like '%"+sqlvalue+"%'";
				}
			}
			sql=sql+" order by a.id";
			int i=1;
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	while(rs.next()){
        		System.out.println(i++);
        		Info info=new Info();
        		info.setInfoid(rs.getInt("id"));
            	info.setInfotypeid(rs.getInt("info_type"));
            	info.setInfoTitle(rs.getString("info_title"));
            	//info.setInfouserid(infotypeid);
            	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
            	info.setInfoemail(rs.getString("info_email"));
            	info.setInfodate(rs.getTimestamp("info_date"));
            	info.setInfocheckstate(rs.getInt("info_check"));
            	info.setInfopaystate(rs.getInt("info_payfor"));
            	info.setInfocontent(rs.getString("info_content"));
            	info.setInfolinkman(rs.getString("info_linkman"));
            	info.setInfotypename(rs.getString("type_name"));
            	info.setTypeIntro(rs.getString("type_intro"));
        		list.add(info);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	/**
	 * 鏍规嵁淇℃伅绫诲瀷鍒嗛〉鏌ユ壘淇℃伅
	 * @param sqlvalue
	 * @param subsql
	 * @param type
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Info> searchInfo(String sqlvalue, String subsql, String type, int start, int end) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			if(subsql!=null&&!subsql.equals("")){
				if(subsql.equals("info_content")){
					sql = sql +" and info_content";
				}else if (subsql.equals("info_phone")) {
					sql = sql +" and info_phone";
				}else if (subsql.equals("info_email")) {
					sql = sql +" and info_email";
				}else if (subsql.equals("id")) {
					sql = sql +" and id";
				}else if (subsql.equals("info_title")) {
					sql = sql +" and info_title";
				}else if (subsql.equals("info_linkman")) {
					sql = sql +" and info_linkman";
				}
				
				if(type.equals("all")){
					sql=sql+" = '"+sqlvalue+"'";
				}else if(type.equals("like")){
					sql=sql+" like '%"+sqlvalue+"%'";
				}
			}
			
			
			sql=sql+" order by a.id";
			sql=sql+" and a.id limit "+start+","+end;
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
			int i=start+1;
        	while(rs.next()){
        	Info info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	info.setInfouserid(i);
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	list.add(info);
        	i++;
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	/**
	 * 鏍规嵁淇℃伅ID鏌ユ壘淇℃伅
	 * @param infoid
	 * @return
	 */
	public Info getInfoById(String infoid) {
		// TODO Auto-generated method stub
		Info info=null;
		String sql = "select * from tb_info a,tb_type b where a.info_type = b.type_sign ";
		sql=sql+" and a.id = "+infoid;
		sql=sql+" order by id ";
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	rs=psmt.executeQuery(sql);
        	if(rs.next()){
        	info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	//info.setInfouserid(infotypeid);
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	}
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return info;
	}
	public List<Info> searchInfoByUserID(String userID) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			sql=sql+" and a.info_user_id = "+userID;
			sql=sql+" order by id ";
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
			int i=1;
        	while(rs.next()){
        	Info info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	list.add(info);
        	i++;
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	
	public List<Info> searchInfoByUserID(String userID,int start, int end) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			sql=sql+" and a.info_user_id = "+userID;
			sql=sql+" order by a.id";
			sql=sql+" and a.id limit "+start+","+end;
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
			int i=start+1;
        	while(rs.next()){
        	Info info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	list.add(info);
        	i++;
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	
	public List<Info> searchCollectionByUserID(String userID) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b,user_collection c "
					+ "where c.state=0 and a.info_type = b.type_sign and a.id = c.info_id and c.user_id ="+userID;
			sql=sql+" order by a.id ";
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
			int i=1;
        	while(rs.next()){
        	Info info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	list.add(info);
        	i++;
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	
	public List<Info> searchCollectionByUserID(String userID,int start, int end) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b,user_collection c "
					+ "where c.state=0 and a.info_type = b.type_sign and a.id = c.info_id and c.user_id ="+userID;
			sql=sql+" order by a.id";
			sql=sql+" and a.id limit "+start+","+end;
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
			int i=start+1;
        	while(rs.next()){
        	Info info=new Info();
        	info.setInfoid(rs.getInt("id"));
        	info.setInfotypeid(rs.getInt("info_type"));
        	info.setInfoTitle(rs.getString("info_title"));
        	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
        	info.setInfoemail(rs.getString("info_email"));
        	info.setInfodate(rs.getTimestamp("info_date"));
        	info.setInfocheckstate(rs.getInt("info_check"));
        	info.setInfopaystate(rs.getInt("info_payfor"));
        	info.setInfocontent(rs.getString("info_content"));
        	info.setInfolinkman(rs.getString("info_linkman"));
        	info.setInfotypename(rs.getString("type_name"));
        	info.setTypeIntro(rs.getString("type_intro"));
        	list.add(info);
        	i++;
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	/**
	 * 鏍规嵁淇℃伅浠樿垂鐘舵�併�佸鏍哥姸鎬併�両D鏌ユ壘淇℃伅
	 * @param infopaystate
	 * @param infocheckstate
	 * @param infotypeid
	 * @return
	 */
	public List<Info> infoList(String infopaystate, String infocheckstate, String infotypeid) {
		// TODO Auto-generated method stub
		System.out.println("12325345");
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			if("0".equals(infopaystate)){
				sql=sql+" and info_payfor= 0";
			}else if ("1".equals(infopaystate)) {
				sql=sql+" and info_payfor= 1";
			}
			
			if("0".equals(infocheckstate)){
				sql=sql+" and info_check= 0";
			}else if ("1".equals(infocheckstate)) {
				sql=sql+" and info_check= 1";
			}
			
			if(infotypeid!=null&&!"".equals(infotypeid)){
				sql=sql+"and a.info_type ="+infotypeid;
			}
			sql=sql+" order by a.id";
			System.out.println(sql);
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	while(rs.next()){

        		Info info=new Info();
        		info.setInfoid(rs.getInt("id"));
            	info.setInfotypeid(rs.getInt("info_type"));
            	info.setInfoTitle(rs.getString("info_title"));
            	//info.setInfouserid(infotypeid);
            	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
            	info.setInfoemail(rs.getString("info_email"));
            	info.setInfodate(rs.getTimestamp("info_date"));
            	info.setInfocheckstate(rs.getInt("info_check"));
            	info.setInfopaystate(rs.getInt("info_payfor"));
            	info.setInfocontent(rs.getString("info_content"));
            	info.setInfolinkman(rs.getString("info_linkman"));
            	info.setInfotypename(rs.getString("type_name"));
            	info.setTypeIntro(rs.getString("type_intro"));
        		list.add(info);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	
	/**
	 * 鏍规嵁淇℃伅浠樿垂鐘舵�併�佸鏍哥姸鎬併�両D鍒嗛〉鏌ユ壘淇℃伅
	 * @param infopaystate
	 * @param infocheckstate
	 * @param infotypeid
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Info> infoListByPage(String infopaystate, String infocheckstate, String infotypeid, int start,
			int end) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			if(infopaystate.equals("0")){
				sql=sql+" and info_payfor= 0";
			}else if (infopaystate.equals("1")) {
				sql=sql+" and info_payfor= 1";
			}
			
			if("0".equals(infocheckstate)){
				sql=sql+" and info_check= 0";
			}else if ("1".equals(infocheckstate)) {
				sql=sql+" and info_check= 1";
			}
			
			if(infotypeid!=null&&!"".equals(infotypeid)){
				sql=sql+" and a.info_type ="+infotypeid;
			}
			sql=sql+" order by a.id";
			sql=sql+" and a.id limit "+start+","+end;
			System.out.println(sql);
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	while(rs.next()){

        		Info info=new Info();
        		info.setInfoid(rs.getInt("id"));
            	info.setInfotypeid(rs.getInt("info_type"));
            	info.setInfoTitle(rs.getString("info_title"));
            	//info.setInfouserid(infotypeid);
            	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
            	info.setInfoemail(rs.getString("info_email"));
            	info.setInfodate(rs.getTimestamp("info_date"));
            	info.setInfocheckstate(rs.getInt("info_check"));
            	info.setInfopaystate(rs.getInt("info_payfor"));
            	info.setInfocontent(rs.getString("info_content"));
            	info.setInfolinkman(rs.getString("info_linkman"));
            	info.setInfotypename(rs.getString("type_name"));
            	info.setTypeIntro(rs.getString("type_intro"));
        		list.add(info);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	/**
	 * 灏嗕俊鎭鏍哥姸鎬佽涓哄凡瀹℃牳
	 * @param info
	 * @return
	 */
	public boolean getModifyByiId(Info info) {
		// TODO Auto-generated method stub
		int i=0;
		String sql="update tb_info set info_check = 1 where id=?";
		try {
			conn=JDBCUtil.getConnecttion();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, info.getInfoid());
			i = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	/**
	 * 灏嗕俊鎭姸鎬佽涓轰粯璐�
	 * @param info
	 * @return
	 */
	public boolean getModifyByiId2(Info info) {
		// TODO Auto-generated method stub
		int i=0;
		String sql="update tb_info set info_payfor = 1 where id=?";
		try {
			conn=JDBCUtil.getConnecttion();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, info.getInfoid());
			i=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	public List<Info> getMyInfoList(int userID) {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			sql=sql+" and info_user_id = "+userID;
			sql=sql+" order by info_date desc";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	while(rs.next()){

        		Info info=new Info();
        		info.setInfoid(rs.getInt("id"));
            	info.setInfotypeid(rs.getInt("info_type"));
            	info.setInfoTitle(rs.getString("info_title"));
            	//info.setInfouserid(infotypeid);
            	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
            	info.setInfoemail(rs.getString("info_email"));
            	info.setInfodate(rs.getTimestamp("info_date"));
            	info.setInfocheckstate(rs.getInt("info_check"));
            	info.setInfopaystate(rs.getInt("info_payfor"));
            	info.setInfocontent(rs.getString("info_content"));
            	info.setInfolinkman(rs.getString("info_linkman"));
            	info.setInfotypename(rs.getString("type_name"));
            	info.setTypeIntro(rs.getString("type_intro"));
        		list.add(info);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	/**
	 * 寰楀埌鍏嶈垂淇℃伅鍒楄〃
	 * @return
	 */
	public List<Info> getFreeInfoList() {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			sql=sql+" and info_payfor = 0 ";
			sql=sql+" order by info_date desc";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	while(rs.next()){

        		Info info=new Info();
        		info.setInfoid(rs.getInt("id"));
            	info.setInfotypeid(rs.getInt("info_type"));
            	info.setInfoTitle(rs.getString("info_title"));
            	//info.setInfouserid(infotypeid);
            	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
            	info.setInfoemail(rs.getString("info_email"));
            	info.setInfodate(rs.getTimestamp("info_date"));
            	info.setInfocheckstate(rs.getInt("info_check"));
            	info.setInfopaystate(rs.getInt("info_payfor"));
            	info.setInfocontent(rs.getString("info_content"));
            	info.setInfolinkman(rs.getString("info_linkman"));
            	info.setInfotypename(rs.getString("type_name"));
            	info.setTypeIntro(rs.getString("type_intro"));
        		list.add(info);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	/**
	 * 寰楀埌鏀惰垂淇℃伅鍒楄〃
	 * @return
	 */
	public List<Info> getPayInfoList() {
		// TODO Auto-generated method stub
		List<Info> list =new ArrayList<Info>();
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select a.*,b.type_name,b.type_intro from tb_info a,tb_type b where a.info_type = b.type_sign ";
			sql=sql+" and info_payfor = 1 ";
			sql=sql+" order by info_date desc";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	while(rs.next()){

        		Info info=new Info();
        		info.setInfoid(rs.getInt("id"));
            	info.setInfotypeid(rs.getInt("info_type"));
            	info.setInfoTitle(rs.getString("info_title"));
            	//info.setInfouserid(infotypeid);
            	info.setInfophone(Long.parseLong(rs.getString("info_phone")));
            	info.setInfoemail(rs.getString("info_email"));
            	info.setInfodate(rs.getTimestamp("info_date"));
            	info.setInfocheckstate(rs.getInt("info_check"));
            	info.setInfopaystate(rs.getInt("info_payfor"));
            	info.setInfocontent(rs.getString("info_content"));
            	info.setInfolinkman(rs.getString("info_linkman"));
            	info.setInfotypename(rs.getString("type_name"));
            	info.setTypeIntro(rs.getString("type_intro"));
        		list.add(info);
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return list;
	}
	public boolean setInfoPayfor(int infoid) {
		// TODO Auto-generated method stub
		int i=0;
		String sql="update tb_info set info_payfor = 1 where id=?";
		try {
			conn=JDBCUtil.getConnecttion();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, infoid);
			i=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	public boolean findInfoIsCollection(int userid,int infoid) {
		// TODO Auto-generated method stub
		boolean isExist=false;
		conn=JDBCUtil.getConnecttion();
		try {
			String sql="select * from user_collection where state = 0 and user_id = "+userid+" and info_id = "+infoid;
			System.out.println(sql);
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery(sql);
        	if(rs.next()){
        		isExist=true;
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		
		return isExist;
	}
	public boolean addInfoToCollection(int userid, int infoid) {
		// TODO Auto-generated method stub
		int i=0;
		String sql="insert into user_collection(user_id,info_id)"
				+ " values(?,?)";
		try {
			conn=JDBCUtil.getConnecttion();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.setInt(2, infoid);
			i=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		return i>0;
	}
	public boolean cancelCollection(int userid, int infoid) {
		String sql="update user_collection set state = 1 where user_id = ? and info_id=?";
		int i=0;
		try {  
            conn=JDBCUtil.getConnecttion();
        	psmt=conn.prepareStatement(sql);
        	psmt.setInt(1, userid);
        	psmt.setInt(2, infoid);

        	i = psmt.executeUpdate();  
        	
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  finally {
			JDBCUtil.close(conn, null, psmt, rs);
		}
		System.out.println(i);
		return i>0;
	}

}
