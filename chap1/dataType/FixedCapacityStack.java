package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item>implements Iterable<Item>
{
	private Item [] s;
	private int N;
	public FixedCapacityStack(int cap)
	{
		s=(Item[])new Object[cap];
	}
	
	public void push(Item item)
	{
		if(N==s.length) resize(2*s.length);
		s[N++]=item;
	}
	
	public Item pop()
	{
		Item item=s[--N];
		s[N]=null; //避免对象游离
		if(N>0&&N==s.length/4) resize(s.length/2);
		return item;
	}
	public boolean isEmpty()
	{
		return N==0;		
	}
	public int size()
	{
		return N;
	}
	//改变数组大小
	public void resize(int max)
	{
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<N;i++)
		{
			temp[i]=s[i];
		}
		s=temp;
	}
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}
	public class ArrayIterator implements Iterator<Item>
	{
		private int n=N-1;
		public boolean hasNext(){return n>=0;}
		public Item next()
		{
			if(!hasNext()) throw new NoSuchElementException();
			Item item=s[n];
			n--;
			return item;
		}
		public void remove(){}
	}
	public Item[] value()
	{
		Item[] temp=(Item[]) new Object[N];
		for(int i=0;i<N;i++)
		{
			temp[i]=s[i];
		}
		return temp;
	}
	public static void main(String[] args)
	{
		//StdOut.print("Type the cap of stack: ");
		FixedCapacityStack<String> a=new FixedCapacityStack<String>(100);
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-")) a.push(item);
			else if(!a.isEmpty()) StdOut.print(a.pop()+" ");
		}
		StdOut.println("("+a.size()+" left on stack)");
		for(String i:a)
		StdOut.print(" "+i+" ");
	}
}