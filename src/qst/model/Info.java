package qst.model;

import java.sql.Timestamp;

/**
 * 发布信息类
 * @author 闯
 *
 */
public class Info {
	private int infoid;
	private int infotypeid;
	private String infoTitle;
	private int infouserid;
	private long infophone;
	private String infoemail;
	private Timestamp infodate;
	private int infocheckstate;
	private int infopaystate;
	private int infostate;
	private String infocontent;
	private String infolinkman;
	private String infotypename;
	private String typeIntro;
	private int id;
	
	public Info(){
		
	}

	public int getInfotypeid() {
		return infotypeid;
	}

	public void setInfotypeid(int infotypeid) {
		this.infotypeid = infotypeid;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infotitle) {
		this.infoTitle = infotitle;
	}

	public int getInfouserid() {
		return infouserid;
	}

	public void setInfouserid(int infouserid) {
		this.infouserid = infouserid;
	}

	public long getInfophone() {
		return infophone;
	}

	public void setInfophone(long infophone) {
		this.infophone = infophone;
	}

	public String getInfoemail() {
		return infoemail;
	}

	public void setInfoemail(String infoemail) {
		this.infoemail = infoemail;
	}

	public Timestamp getInfodate() {
		return infodate;
	}

	public void setInfodate(Timestamp infodate) {
		this.infodate = infodate;
	}

	public String getInfocontent() {
		return infocontent;
	}

	public void setInfocontent(String infocontent) {
		this.infocontent = infocontent;
	}

	public String getInfolinkman() {
		return infolinkman;
	}

	public void setInfolinkman(String infolinkman) {
		this.infolinkman = infolinkman;
	}

	public int getInfoid() {
		return infoid;
	}

	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}

	public int getInfocheckstate() {
		return infocheckstate;
	}

	public void setInfocheckstate(int infocheckstate) {
		this.infocheckstate = infocheckstate;
	}

	public int getInfopaystate() {
		return infopaystate;
	}

	public void setInfopaystate(int infopaystate) {
		this.infopaystate = infopaystate;
	}

	public int getInfostate() {
		return infostate;
	}

	public void setInfostate(int infostate) {
		this.infostate = infostate;
	}

	public String getInfotypename() {
		return infotypename;
	}

	public void setInfotypename(String infotypename) {
		this.infotypename = infotypename;
	}

	public String getTypeIntro() {
		return typeIntro;
	}

	public void setTypeIntro(String typeIntro) {
		this.typeIntro = typeIntro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
