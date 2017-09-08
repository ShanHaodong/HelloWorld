package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;

public class FixedCapacityStackOfStrings
{
	private String [] s;
	private int N;
	public FixedCapacityStackOfStrings(int cap)
	{
		s=new String[cap];
	}
	
	public void push(String item)
	{
		s[N++]=item;
	}
	public String pop()
	{
		return s[--N];
	}
	public boolean isEmpty()
	{
		return N==0;		
	}
	public boolean isFull()
	{
		return N==s.length;
	}
	public int size()
	{
		return N;
	}
	public static void main(String[] args)
	{
		StdOut.print("Type the cap of stack: ");
		FixedCapacityStackOfStrings a=new FixedCapacityStackOfStrings(100);
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-")) a.push(item);
			else if(!a.isEmpty()) StdOut.print(a.pop()+" ");
		}
		StdOut.println("("+a.size()+" left on stack)");
	}
}