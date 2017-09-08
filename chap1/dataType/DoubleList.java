package algorithms.chap1.dataType;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;
/*
 *@version 1.0 2017-8-7
 *@author SHAN Haodong
 *@test1.3.31
*/
public class DoubleList<Item> implements Iterable<Item>
{
	private DoubleNode head;
	private DoubleNode tail;
	private int N;
	private class DoubleNode
	{
		Item item;
		DoubleNode prev;
		DoubleNode next;
	}
	/*public DoubleList()
	{
		head=null;
		tail=head;
	}*/
	public boolean isEmpty()
	{
		return head==null;
	}
	
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}
	private class ArrayIterator implements Iterator<Item>
	{
		private DoubleNode current=head;
		public boolean hasNext(){ return current!=null;}
		public Item next()
		{
			if (!hasNext()) throw new NoSuchElementException();
			Item item=current.item;
			current=current.next;
			return item;
		} 
		public void remove(){}
	}
	
	public int size()
	{
		return N;
	}
	
	public void addHead(Item item)
	{
		if(isEmpty()) 
		{
			head=new DoubleNode();
			head.item=item;
			tail=head;
		}else{
			DoubleNode newhead=new DoubleNode();
			newhead.item=item;
			head.prev=newhead;
			newhead.next=head;
			head=newhead;
		}
		N++;
	}
	public Item deleteHead()
	{
		if(isEmpty()) throw new RuntimeException("List underflow");
		Item temp=head.item;
		head=head.next;
		head.prev=null;
		N--;
		return temp;
	}
	
	public void addTail(Item item)
	{
		if(isEmpty())
		{
			tail=new DoubleNode();
			tail.item=item;
			head=tail;
		}else{
			DoubleNode newtail=new DoubleNode();
			newtail.item=item;
			tail.next=newtail;
			newtail.prev=tail;
			tail=newtail;
		}
		N++;
	}
	public Item deleteTail()
	{
		if(isEmpty()) throw new RuntimeException("List underflow");
		Item temp=tail.item;
		tail=tail.prev;
		tail.next=null;
		N--;
		return temp;
	}
	
	public void insertBefore(int pos,Item item)
	{
		if(pos>N) throw new NoSuchElementException();
		DoubleNode node =new DoubleNode();
		node.item=item;
		if(pos==0)
		{
			node.next=head;
			head.prev=node;
			head=node;
		}else{
  		DoubleNode temp=head;
  		int i=0;
  		while(i<pos)
  		{
  			temp=temp.next;
  			i++;
  		}
			temp.prev.next=node;
			node.prev=temp.prev;
			node.next=temp;
			temp.prev=node;
		}
		N++;
	}
	public void insertAfter(int pos,Item item)
	{
		if(pos>N) throw new NoSuchElementException();
		DoubleNode node =new DoubleNode();
		node.item=item;
		if(pos==N)
		{
			tail.next=node;
			node.prev=tail;
			tail=node;
		}else{
  		DoubleNode temp=head;
  		int i=0;
  		while(i<pos)
  		{
  			temp=temp.next;
  			i++;
  		}
  		node.next=temp.next;
  		temp.next.prev=node;
  		node.prev=temp;
  		temp.next=node;
		}
		N++;
	}
	
	public Item delete(int pos)
	{
		if(pos>N) throw new NoSuchElementException();
		Item item;
		DoubleNode temp=head;
		int i=0;
		while(i<pos)
		{
			temp=temp.next;
			i++;
		}
		item=temp.item;
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		temp=null;
		N--;
		return item;
	}
	
	public static void main(String[] args)
	{
		DoubleList<String>list=new DoubleList<String>();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-")) list.addHead(item);
			else list.addTail(item);
		}
		StdOut.print("\n("+list.size()+" left on stack)");
		for(String i:list)
		{
			StdOut.print(" "+i+" ");
		}
		
		list.addTail("grandmother");
		list.addHead("grandfather");
		list.insertAfter(2,"uncle");
		StdOut.print("\n("+list.size()+" left on stack)");
		for(String i:list)
		{
			StdOut.print(" "+i+" ");
		}
		
		list.deleteTail();
		list.deleteHead();
		list.delete(2);
		StdOut.print("\n("+list.size()+" left on stack)");
		for(String i:list)
		{
			StdOut.print(" "+i+" ");
		}
	}
}