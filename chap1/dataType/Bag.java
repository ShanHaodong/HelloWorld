package algorithms.chap1.dataType;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>
{
	private Node first;
	private int N;
	private class Node
	{
		Item item;
		Node next;
	}
	public boolean isEmpty() {return first==null;}
	public int size()        {return N;}
	public void add(Item item)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	public Iterator<Item> iterator()
	{	return new ListIterator();}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current =first;
		public boolean hasNext(){return current!=null;}
		public Item next()
		{
			if (!hasNext()) throw new NoSuchElementException();
			Item item=current.item;
			current=current.next;
			return item;
		}
		public void remove(){}
	}
	public static void main(String[] args)
	{
		Bag<String> s=new Bag<String>();
		while(!StdIn.isEmpty())
		{
			s.add(StdIn.readString());
		}
		for(String i:s)
		{
			StdOut.print(" "+i+" ");
		}
	}
}
	