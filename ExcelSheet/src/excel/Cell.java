package excel;

public  class Cell
{

	private int xPos;
	private int yPos;
	private String data;
	
	public Cell(int xPos,int yPos,String data)
	{
		super();
		this.xPos=xPos;
		this.yPos=yPos;
		this.data=data;
		
	}

	public int getxPos()
	{
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
