package sun.krd.polling;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class PollBean {
	
	String res;
	int yes,no,cantsay;
	private int total;
	
	public PollBean(String res, int yes, int no, int cantsay) {
		super();
		this.res = res;
		this.yes = yes;
		this.no = no;
		this.cantsay = cantsay;
	}
	public PollBean() {
		super();
		this.res = "";
		this.yes = 0;
		this.no = 0;
		this.cantsay = 0;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public int getYes() {
		return yes;
	}
	public void setYes(int yes) {
		this.yes = yes;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCantsay() {
		return cantsay;
	}
	public void setCantsay(int cantsay) {
		this.cantsay = cantsay;
	}
	
/*	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}*/
	public void pollResult() {
		if(res.equals("yes")){
			yes++;
		}else if(res.equals("no")){
			no++;
		}else{
			cantsay++;
		}
		
		total=yes+no+cantsay;
	}
	
	public double getYesRate() {
		return ((double)yes/(double)total)*100;
	}
	
	public double getNoRate(){
		return ((double)no/(double)total)*100;
	}
	
	public double getCantsayRate(){
		return ((double)cantsay/(double)total)*100;
	}
}
