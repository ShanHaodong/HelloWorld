package algorithms.chap1.dataType;
import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;
import java.util.Iterator;

/*
 *@version 1.0 2017-8-8
 *@author SHAN Haodong
 *@test 1.3.34
 *@use java dataType/RandomBag<stringstack.txt
 */
public class RandomBag<Item>implements Iterable<Item>
{
	public static void main(String[] args)
	{
		RandomBag<String> a=new RandomBag<String>(5);
		while(!StdIn.isEmpty())
		{
			String str=StdIn.readString();
			a.add(str);
		}
		StdOut.printf("\n%d elements :",a.size());
		for(String i:a)
		StdOut.print(" "+i+" ");
	}
	private int N; 
	private Item[] s;
	public RandomBag(int cap)
	{
		s=(Item[]) new Object[cap];
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
	public void add(Item item)
	{
		if(N==s.length) resize(2*N);
		s[N]=item;
		N++;
	}
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
		for(int i=N;i>0;i--)
		{
			int ran=StdRandom.uniform(i);
			Item item=s[ran];
			s[ran]=s[i-1];
			s[i-1]=item;
		}
		return new ArrayIterator();
	}
	public class ArrayIterator implements Iterator<Item>
	{
		private int n=N-1;
		public boolean hasNext(){return n>=0;}
		public Item next()
		{
			Item item=s[n];
			n--;
			return item;
		}
	} 
	
}