package algorithms.chap1.dataType;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class Queue<Item>implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N;
	public static void main(String [] args)
	{
		Queue<String> q=new Queue<String> ();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-")) q.enqueue(item);
			else if(!q.isEmpty()) StdOut.print(" "+q.dequeue()+" ");
		}
		StdOut.print("\nq:("+q.size()+" left in the queue)");
		for(String i:q) StdOut.print(" "+i);
		Queue<String> r=new Queue<String>(q);
		StdOut.print("\nq:("+q.size()+" left in the queue)");
		for(String i:q) StdOut.print(" "+i);
		StdOut.print("\nr:("+r.size()+" left in the queue)");
		for(String i:r) StdOut.print(" "+i);
	}
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return first==null;}
	public int size()        {return N;}
	public Queue(){}
	/*
	 *@test 1.3.41
	 *@version 1.0 2017-8-8
	 */
	public Queue(Queue<Item> q)
	{
		int N=q.size();
		Item[] temp=(Item[]) new Object[N];
		for(int i=0;i<N;i++) temp[i]=q.dequeue();
		for(int i=0;i<N;i++) 
		{
			q.enqueue(temp[i]);
			enqueue(temp[i]);
		}
	}
	public void enqueue(Item item)
	{
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.next=null;
		if(isEmpty()) first=last;
		else oldlast.next=last;
		N++;
	}
	
	public Item dequeue()
	{
		Item item=first.item;
		first=first.next;
		if(isEmpty()) last=null;
		N--;
		return item;
	}
	
	//ÊµÏÖiterator
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	public class ListIterator implements Iterator<Item>
	{
		private Node current=first;
		public boolean hasNext(){return current!=null;}
		public Item next()
		{
			Item item=current.item;
			current=current.next;
			return item;
		}
		public void remove(){}
	}
}