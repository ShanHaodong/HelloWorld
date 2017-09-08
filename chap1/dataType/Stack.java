package algorithms.chap1.dataType;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;
import java.util.NoSuchElementException;

public class Stack<Item>implements Iterable<Item>
{
	private Node first; //栈顶
	private Node last;
	private int N;  //元素数量
	private class Node
	{
		Item item;
		Node next;
	}
	public static void main(String[] args)
	{
		Stack<String> s=new Stack<String>();
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
		Stack<String> r=new Stack<String>(s);
		/*s.remove(s,"mommy");
		StdOut.print("\n("+s.size()+" left on stack)");
		for(String i:s)
		{
			StdOut.print(" "+i+" ");
		}*/
		
		s.printReverseStack();
		r.printReverseStack();
		
	}
	public Stack(){}
	
	/*
	 *@test 1.3.42
	 *@version 1.0 2017-8-8
	 *@author SHAN Haodong
	 */
	 public Stack(Stack<Item> q)
	 {
	 	int N=q.size();
	 	Item[] temp=(Item[]) new Object[N];
	 	for(int i=0;i<N;i++) temp[i]=q.pop();
	 	for(int i=0;i<N;i++) {q.push(temp[N-i-1]);push(temp[N-i-1]);}
	 }
	public boolean isEmpty()
	{
		return first==null;
	}
	public int size()
	{
		return N;
	}
	
	public void push(Item item)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		if(last==null) last=first;
		N++;
	}
	public Item pop()
	{
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}
	//@test 1.3.32
	public void enqueue(Item item)
	{
		Node oldlast=last;
		last=new Node();
		last.item=item;
		if(oldlast==null) first=last;
		else oldlast.next=last;
		N++;
	}
	//Remove the nodes after given node
	public void removeAfter(Node node)
	{
		if(node!=null&&node.next!=null) node.next=null;
	}
	//insert second node as the next of first node
	public void insertAfter(Node node1,Node node2)
	{
		if(node1!=null&&node2!=null)
		{
			Node temp=node1.next;
			node1.next=node2;
			node2.next=temp;
		}
	}
	
	//remove all the nodes whose item is key
	public void remove(Stack<Item> s,String key)
	{
		Node i=s.first;
		while(i.next!=null)
		{
			if(i.next.item.equals(key))
			{
				if(i.next.next!=null) i.next=i.next.next;
				else i.next=null;
				N--;
			}
			i=i.next;
		}
	if(s.first.item.equals(key)) {s.first=s.first.next;N--;}
	}
	
	//find the maximum key of LinkList(assume the Item is Integer)
	/*@test1.3.27
	 *@version 1.0 2017-8-7
	 *@author SHAN Haodong
	 *@instructions need to change the Node deginition from Item item to Integer item; 
	*/
/*	public int max(Node first)
	{
		int temp=0;
		if(first==null) return temp;
		else 
		{
			while(first!=null)
			{
				if(first.item>temp) temp=first.item;
			  first=first.next;
			}
			return temp;
		}
	}*/
	
	/*
	使用递归实现max
	*/
	/*@test 1.3.28
	public int max(Node first)
	{
		int temp=0;
		if(first!=null) {temp=first.item>temp?first.item:temp;return max(first.next,temp);}
		else return temp;		
	}
	
	public int findMax(Node node,int temp)
	{
		if(node!=null) {temp=node.item>temp?node.item:temp;return findMax(node.next,temp);}
		else return temp;
	}
	*/
	
	//turn the LinkList over 
	
	//turn over the list and return the changed first node
	/*
	 *@test 1.3.30
	 */
	public Node reverse(Node first)
	{
		if(first==null) return null;
		if(first.next!=null) 
		{			
			Node rev=reverse(first.next);
			Node second=first.next;
			second.next=first;
			first.next=null;
			return rev;
		}
		else return first;
	}
	
	//print the reversed list
	public void printReverseStack()
	{
		Node rev=reverse(first);
		StdOut.print("\n("+N+" left on stack)");
		while(rev!=null)
		{
			StdOut.print(" "+rev.item+" ");
			rev=rev.next;
		}
	}
	public Node getFirst()
	{
		return first;
	}
	
	//iterator
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>
	{
		private Node current=first;
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
}
