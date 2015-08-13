package sun.krd.polling;

import java.util.List;
import javax.transaction.RollbackException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDao {
		
private Session hbSession;
	
	public void open(){
		hbSession=HbUtil.factory.openSession();
	}
	
	public void close(){
		hbSession.close();
	}
	
	public Boolean validate(String uname, String password) {
		this.open();
		boolean result=false;
		String hql="from Login l where l.username=? and l.password=?";
		Query q=	hbSession.createQuery(hql);
		q.setString(0, uname);
		q.setString(1, password);
		int count = q.list().size();
		
		
			if(count!=0)
				result=true;
		return result;
	}
	public void AddUser( String username, String password) throws RollbackException {
		try {
			Login login=new Login();
			this.open();
			login.setUsername(username);
			login.setPassword(password);
			
			Transaction tx = hbSession.beginTransaction();
			hbSession.persist(login);
			tx.commit();
			//System.out.println("User Added "+login);
			this.close();
		} catch (SecurityException e) {
		
			e.printStackTrace();
		} catch (IllegalStateException e) {
		
			e.printStackTrace();
		}
	}
	public void changePassword(String username, String password){
		try {
			Login login=new Login();
			this.open();
			login.setUsername(username);
			login.setPassword(password);
			
			Transaction tx = hbSession.beginTransaction();
			hbSession.update(login);
			System.out.println("login updated");
			tx.commit();
			//System.out.println("User Added "+login);
			this.close();
			
		} catch (SecurityException e) {
		
			e.printStackTrace();
		} catch (IllegalStateException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	/*
	
	static String driver="oracle.jdbc.OracleDriver"; 
	static String dbUrl="jdbc:oracle:thin:@localhost:1521:XE";
	static String dbuser="system";
	static String dbpassword="s";
	Connection con=null;
	PreparedStatement ps=null;
	int empno;
	String ename=null;
	double sal=0;
	Scanner sc=new Scanner(System.in);
	ResultSet rs=null;
	
	
	private String sql=null;
	
	{
		
		try {
			Class c= Class.forName(driver);
			Driver d=(Driver) c.newInstance();
			DriverManager.registerDriver(d);
			//System.out.println("loaded");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void open() {
		
		try {
			con=DriverManager.getConnection(dbUrl,dbuser,dbpassword);
			//System.out.println("2");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		

	}
	
	private void closeConn(){
		try {
		if(con!=null){
			
				con.close();
				con=null;
		}
		if(ps!=null)
			ps.close();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
		
	}
	
	public Boolean validate(String uname, String password) {
		Boolean result = false;
		try {
			this.open();
			sql="select * from login where uname=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);
			//System.out.println(sql);
			//System.out.println(password);
			
			rs = ps.executeQuery();

			if(rs.next()){
				result=true;
				//System.out.println(result);
			}else{
				result=false;
				//System.out.println("hello");
			}
			
			
			this.closeConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
		
	}
	*/
}