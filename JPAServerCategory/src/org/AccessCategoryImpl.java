package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="AccessCategory")
@Remote(AccessCategory.class)

public class AccessCategoryImpl implements AccessCategory
{
	@PersistenceContext(unitName="CategoryJPA")
	EntityManager manager;

	@Override
	public void insertCategory(Integer catId, String catName, String catDesc,
			String catImage) throws RemoteException
	{
		Category objCategory=new Category(catId,catName,catDesc,catImage);
		manager.persist(objCategory);
		
		
	}

	@Override
	public String getCatName(Integer catId)
	{
		Category objCategory=manager.find(Category.class, catId);
		
				return objCategory.getCatName();
	}

	@Override
	public String getCatImage(Integer catId)
	{
		Category objCategory=manager.find(Category.class, catId);
		
		return objCategory.getCatImage();
		
	}

	@Override
	public String getCatDesc(Integer catId)
	{
		Category objCategory=manager.find(Category.class, catId);
		
		return objCategory.getCatDesc();
	}
	
	

}
