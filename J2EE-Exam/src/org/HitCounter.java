package org;

public class HitCounter
{
	private int hits=0;

	public HitCounter() 
	{
		super();
	}

	public HitCounter(int hits)   
	{
		super();
		this.hits = hits;
	}

	public int getHits() 
	{
		return hits;
	}

	public void setHits(int hits) 
	{
		this.hits = hits;
	}
	
	public int getHitCount() 
	{
		++hits;
		return hits;
	}


}
