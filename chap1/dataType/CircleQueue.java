package algorithms.chap1.dataType;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;
/*
 *@version 1.0 2017-8-7
 *@author SHAN Haodong
 *@test 1.3.29
 */
public class CircleQueue<Item>implements Iterable<Item>
{
	private int N;
	private Node last;
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return last==null;
	}
	
	public int size()
	{
		return N;
	}
	
	public void enqueue(Item item)
	{
		Node x=new Node();
		x.item=item;
		if(isEmpty()) x.next=x;
		else 
		{
			x.next=last.next;
			last.next=x;
		}
		last = x;
		N++;
	}
	
	public Item dequeue()
	{
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		Item item=last.next.item;
		if(last.next==last) last=null;
		else last.next=last.next.next;
		N--;
		return item;
	}
	
 	public Item dequeue(int n)
 	{
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		for(int i=0;i<n-1;i++) last=last.next;
		Item item=last.next.item;
		if(last.next==this.last) last=null;
		else last.next=last.next.next;
		N--;
		return item;
 	}
	
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>
	{
		private int n=N;
		private Node current=last.next;
		public boolean hasNext(){ return n!=0;}
		public Item next()
		{
			n--;
			Item item=current.item;
			current=current.next;
			return item;
		} 
		public void remove(){}
	}
	
	
	public static void main(String[] args)
	{
		CircleQueue<String> q=new CircleQueue<String> ();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-")) q.enqueue(item);
			else if(!q.isEmpty()) StdOut.print(" "+q.dequeue()+" ");
		}
		StdOut.print("("+q.size()+" left in the queue)");
		for(String i:q)
		{
			StdOut.print(" "+i+" ");
		}
	}
}