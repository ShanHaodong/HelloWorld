package algorithms.chap1.dataType;
import java.util.Iterator;
import edu.princeton.cs.algs4.*;

/*
 *@version 1.0 2017-8-8
 *@author SHAN Haodong
 *@test 1.3.44
 *@use 
 */
public class Buffer
{
	public static void main(String[] args)
	{
		Buffer a=new Buffer();
		a.insert('A');
		a.insert('B');
		a.insert('C');
		//a.left(1);
		a.insert('G');
		a.left(2);
		StdOut.print(a.size()+" "+a.delete()+" "+a.size());
		
	}
	private int N;
	private Node first;
	private Node current;
	private class Node
	{
		char item;
		Node prev;
		Node next;
	}
	public Buffer(){}
	public void insert(char c)
	{
		if(size()==0) 
		{
			first=new Node();
			first.item=c;
			current=first;
		}else{
			Node newNode=new Node();
			newNode.item=c;
			newNode.next=current.next;
			newNode.prev=current;
			current.next=newNode;
			current=newNode;
		}
		N++;
	}
	public char delete()
	{
		if(N==0) throw new RuntimeException("Buffer is empty");
		char c=current.item;
		if(current.next!=null)
		{
			current.prev.next=current.next;
			current.next.prev=current.next;
			current=current.next;
		}else{
			current=null;
		}
		N--;
		return c;
	}
	public void left(int k)
	{
		if(current.prev!=null)current=current.prev;
	}
	public void right(int k)
	{
		if(current.next!=null)current=current.next;
	}
	public int size()
	{
		return N;
	}
}