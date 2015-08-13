package org;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;



import com.opensymphony.xwork2.ActionSupport;

public class UserFileUploaded extends ActionSupport
{
	String userImageFileName;
	String userImageContentType;
	File userImage;
	
	public String execute()
	{
		try
		{
			System.out.println("File Upload Execute fired");
			FileUtils.copyFile(userImage,new File("d:\\uploadFolder\\",userImageFileName));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	
		
	}

	public String getUserImageFileName()
	{
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName)
	{
		this.userImageFileName = userImageFileName;
	}

	public String getUserImageContentType()
	{
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType)
	{
		this.userImageContentType = userImageContentType;
	}

	public File getUserImage()
	{
		return userImage;
	}

	public void setUserImage(File userImage)
	{
		this.userImage = userImage;
	}

}
