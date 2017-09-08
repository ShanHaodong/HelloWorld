package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;
import java.util.Iterator;

/*
 *@version 1.0 2017-8-8 
 *@author SHAN Haodong
 *@test 1.3.33
 *
 */
 
 public class ResizingArrayDeque<Item>implements Iterable<Item>
 {
 	public static void main(String[] args)
 	{
 		ResizingArrayDeque<String> s=new ResizingArrayDeque<String>(100);
		while(!StdIn.isEmpty())
		{
			String str=StdIn.readString();
			if(str.equals("L-")) StdOut.print(s.popLeft()+" ");
			else if(str.equals("R-")) StdOut.print(s.popRight()+" ");
			else if(str.substring(0,1).equals("+")) s.pushRight(str.substring(1));
			else if(str.substring(str.length()-1).equals("+")) s.pushLeft(str.substring(0,str.length()-1));
		}
		StdOut.printf("\n%d elements left:",s.size());
		for(String i:s)
		StdOut.print(" "+i+" ");
 	}
 	private Item[] array;
 	private int N;
 	public ResizingArrayDeque(int cap)
 	{
 		array=(Item[])new Object[cap];
 		N=0;
 	}
 	public boolean isEmpty()
 	{
 		return N==0;
 	}
 	public int size()
 	{
 		return N;
 	}
 	public void pushLeft(Item item)
 	{
 		if(N==array.length) resize(2*array.length);
 		if(!isEmpty())
 		{
 			for(int i=N-1;i>=0;i--)
 			{
 				array[i+1]=array[i];
 			}
 		}
 		array[0]=item;
 		N++;
 	}
 	public void pushRight(Item item)
 	{
 		if(N==array.length) resize(2*array.length);
 		array[N]=item;
 		N++;
 	}
 	public Item popLeft()
 	{
 		if(isEmpty()) throw new RuntimeException("Queue underflow");
		Item item=array[0];
		for(int i=0;i<N-1;i++)
		{
			array[i]=array[i+1];
		}
		array[N-1]=null;
 		N--;
 		if(N>0&&N==array.length/4) resize(array.length/2);
 		return item;
 	}
 	public Item popRight()
 	{
 		if(isEmpty()) throw new RuntimeException("Queue underflow");
 		Item item=array[N-1];
 		array[N-1]=null;
 		N--;
 		if(N>0&&N==array.length/4) resize(array.length/2);
 		return item;
 	}
 	//change the size of array
	public void resize(int max)
	{
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<N;i++)
		{
			temp[i]=array[i];
		}
		array=temp;
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
			Item item=array[n];
			n--;
			return item;
		}
		public void remove(){}
	}
 }