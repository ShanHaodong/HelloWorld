package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *@version 1.0 2017-8-7
 *@author SHAN Haodong
 *@test 1.3.33
 *@use java dataType/Deque <deque.txt
 */
public class Deque<Item> implements Iterable<Item>
{
	public static void main(String[] args)
	{
		Deque<String> s=new Deque<String>();
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
	private Node first;
	private Node last;
	private int N;
	private class Node
	{
		Item item;
		Node prev;
		Node next;
	}
	
	public Deque()
	{
		first=null;
		last=first;
	}
	
	public boolean isEmpty()
	{
		return last==null;
	}
	
	public int size()
	{
		return N;
	}
	
	public void pushLeft(Item item)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		if(oldfirst!=null) oldfirst.prev=first;
		else last=first;
		N++;
	}
	public void pushRight(Item item)
	{
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.prev=oldlast;
		if(oldlast!=null) oldlast.next=last;
		else first=last;
		N++;
	}
	
	public Item popLeft()
	{
		if(isEmpty()) throw new RuntimeException("Deque underflow");
		Item item=first.item;
		first=first.next;
		first.prev=null;
		N--;
		return item;
	}
	
	public Item popRight()
	{
		if(isEmpty()) throw new RuntimeException("Deque underflow");
		Item item=last.item;
		last=last.prev;
		last.next=null;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>
	{
		private Node current=first;
		public boolean hasNext(){return current!=null;}
		public Item next()
		{
			if(!hasNext()) throw new NoSuchElementException();
			Item item=current.item;
			current=current.next;
			return item;
		}
		public void remove(){}
	}
	
}