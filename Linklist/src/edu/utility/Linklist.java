package edu.utility;

public class Linklist<T>
{
	Node<T> start;
	Node<T> end;
	Node<T> current;
	int maxCount;
	
	public void add(T data)
	{
		Node<T> tmpNode=new Node<>(data);
		if(start==null)
		{
			start=end=current=tmpNode;
		}
		else
		{
			end.next=tmpNode;
		    tmpNode.previous=end;
		    end=tmpNode;
		}
		maxCount++;
	}
	
	public void delete(int index)
	{
		if(start==null || index>maxCount-1)
			return;
		else if(start==end)
			start=end=current=null;
		else if(index==0)
		{
			start=start.next;
			start.previous=null;
		}
		else if(index==maxCount-1)
		{			
			end=end.previous;
			end.next=null;			
		}
		else
		{
			Node<T> tmpNode=start;
			for(int iTmp=0;iTmp<index;iTmp++,tmpNode=tmpNode.next);
			tmpNode.next.previous=tmpNode.previous;
			tmpNode.previous.next=tmpNode.next;
		}
		maxCount--;
	}
	
	public T getFirst()
	{
		if(start==null)
			return null;
		
		current=start;
		return current.data;
	}
	
	public int getMaxCount()
	{
		return maxCount;
	}

	public void setMaxCount(int maxCount)
	{
		this.maxCount = maxCount;
	}

	public T getLast()
	{
		if(start==null)
			return null;
		
		current=end;
		return current.data;
	}
	
	public T getNext()
	{
		if(start==null || current.next==null)
			return null;
		
		current=current.next;
		return current.data;
	}
	
	public T getPrevious()
	{
		if(start==null || current.previous==null)
			return null;
		
		current=current.previous;
		return current.data;
	}
	
	
	

	
}
