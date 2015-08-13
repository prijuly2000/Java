package org;

public class JetPlane
{
	Engine objEngine;

	public Engine getObjEngine()
	{
		return objEngine;
	}

	public void setObjEngine(Engine objEngine)
	{
		this.objEngine = objEngine;
	}
	
	public void fly()
	{
		objEngine.start();
		objEngine.fullThrottle();
	}
	public void landSafely()
	{
		objEngine.stop();
	}

}
