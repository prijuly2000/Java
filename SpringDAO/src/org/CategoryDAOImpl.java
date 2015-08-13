package org;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryDAOImpl implements CategoryDAO
{
	JdbcTemplate jdbcTemplate;
	public void setDao(DataSource ds)
	{
		jdbcTemplate=new JdbcTemplate(ds);
	}

	@Override
	public void saveCategory(Category objCategory)
	{
		jdbcTemplate.update("insert into category values(?,?,?,?)",
				new Object[]{objCategory.getCatId(),
							 objCategory.getCatName(),
							 objCategory.getCatDesc(),
							 objCategory.getCatImage()
		});
		
		System.out.println("Record inserted");

	}

}
