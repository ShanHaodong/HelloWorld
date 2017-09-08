package algorithms.chap1.dataType;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;

/**
 * Stack can change its size and have an interator
 * @version 1.0 2017-7-18
 * @author SHAN Haodong 
 */
public class ResizingArrayStack <Item> implements Iterable<Item>
{
	private Item[] a=(Item[]) new Object[1];
	private int N;
	public boolean isEmpty()
	{
		return N==0;
	}
	public int size() {return N;}
	
	public void resize(int max)
	{
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<a.length;i++)
			temp[i]=a[i];
		a=temp;
	}
	public Item pop()
	{
		Item temp=a[--N];
		a[N]=null;
		if(N>0&&N==a.length/4) resize(a.length/2);
		return temp;
	}
	public void push(Item item)
	{
		if(N==a.length) resize(a.length*2);
		a[N++]=item;
	}
	public Iterator<Item> iterator()
	{
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i=N;
		public boolean hasNext(){return i>0;}
		public  Item   next()   {return a[--i];}
		public void remove()    {}
	}
	
	public static void main(String[] args)
	{
		ResizingArrayStack<String> s=new ResizingArrayStack<String>();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-")) s.push(item);
			else if(!s.isEmpty()) StdOut.print(s.pop()+" ");
		}
		StdOut.print("\n("+s.size()+" left on stack)");
		for(String i:s)
		{
			StdOut.print(" "+i+" ");
		}
	}
}