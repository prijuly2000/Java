package org;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless(name="AccessUserInterface")
@Remote(AccessUserInterface.class)
public class AccessUserImpl implements AccessUserInterface
{
	@PersistenceContext(unitName="UsersJPA")
	EntityManager manager;

	@Override
	public void insertUser(String userName, String password, String name,
			String email) throws RemoteException
	{
		Users objUser=new Users(userName,password,name,email);
		manager.persist(objUser);

	}

	@Override
	public String getPassword(String userName) throws RemoteException
	{
		/*Users objUser=manager.find(Users.class, userName);
		return objUser.getPassword();*/
		
		Query query=manager.createQuery("select password from Users user where user.userName=:name");
		query.setParameter("name", userName);
		return (String)query.getSingleResult();
	}

	@Override
	public String getEmail(String userName) throws RemoteException
	{
		Users objUser=manager.find(Users.class, userName);
		return objUser.getEmail();
	}

	@Override
	public String[] getAllEmails() throws RemoteException
	{
		Query query=manager.createQuery("select email from Users user");
		List<String> result=query.getResultList();
		Iterator<String> iter=result.iterator();
		
		String []data=new String[result.size()];
		int iTmp=0;
		while(iter.hasNext())
		{
			System.out.println(data[iTmp]=iter.next());
			iTmp++;
			
		}
		return data;
	}

	@Override
	public UserData getUserdata(String userName) throws RemoteException
	{
		Query query=manager.createQuery("select object(user) from  Users user where user.userName=:name" );
		query.setParameter("name", userName);
		Users objUser=(Users)query.getSingleResult();
		
		UserData data=new UserData(); 
		data.setName(objUser.getName());
		data.setEmail(objUser.getEmail());
		data.setPassword(objUser.getPassword());
		data.setUserName(objUser.getUsername());
		return data;
	}

}
