package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* 
 *@author SHAN Haodong
 *@version 1.0 2017-8-8
 *@test 1.3.35 & 1.3.36
 *@use
 */
 
 public class RandomQueue<Item> implements Iterable<Item>
 {
 	public static void main(String[] args)
 	{
 		RandomQueue<Card> a=new RandomQueue<Card> (20);
 		for(int i=0;i<Card.values().length;i++)
 		{
 			//StdOut.print(Card.values()[i]);
 			a.enqueue(Card.values()[i]);
 		}
 		Card[] player1=new Card[13];
 		Card[] player2=new Card[13];
 		Card[] player3=new Card[13];
 		Card[] player4=new Card[13];
 		for(int i=0;i<13;i++)
 		{
 			player1[i]=a.dequeue();
 			player2[i]=a.dequeue();
 			player3[i]=a.dequeue();
 			player4[i]=a.dequeue();
 		}
 		StdOut.print("\nplayer1's cards:");
 		for(Card i:player1)
 		StdOut.print(" "+i);
 		StdOut.print("\nplayer2's cards:");
 		for(Card i:player2)
 		StdOut.print(" "+i);
 		StdOut.print("\nplayer3's cards:");
 		for(Card i:player3)
 		StdOut.print(" "+i);
 		StdOut.print("\nplayer4's cards:");
 		for(Card i:player4)
 		StdOut.print(" "+i);
 		
 		StdOut.println("\n "+a.size()+"elements left:");
 		for(Card i:a)
 		StdOut.print(" "+i);
 	}
 	private Item[] s;
 	private int N;
 	public RandomQueue(int cap)
 	{
 		s=(Item[]) new Object[cap];
 	}
 	public boolean isEmpty()
 	{
 		return N==0;
 	}
 	public int size()
 	{
 		return N;
 	}
 	public void enqueue(Item item)
 	{
 		if(N==s.length) resize(2*N);
 		s[N]=item;
 		N++;
 	}
 	public Item dequeue()
 	{
 		if(isEmpty()) throw new RuntimeException("Queue underflow");
 		Item item=s[0];
 		int n=StdRandom.uniform(N);
 		s[0]=s[n];
 		N--;
 		for(int i=n;i<N;i++)
 		{
 			s[i]=s[i+1];
 		}
 		s[N]=null;
 		return item;
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
 	public Item sample()
 	{
 		if(isEmpty()) throw new RuntimeException("Queue underflow");
 		Item item=s[0];
 		int n=StdRandom.uniform(N);
 		s[0]=s[n];
 		return item;
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
 		public void remove(){}
 	}
 	public enum Card
 	{
 		  H_A,
 		  H_2,
 		  H_3,
 		  H_4,
 		  H_5,
 		  H_6,
 		  H_7,
 		  H_8,
 		  H_9,
 		  H_10,
 		  H_J,
 		  H_Q,
 		  H_K,   
 		  D_A,
 		  D_2,
      D_3,
      D_4,
      D_5,
      D_6,
      D_7,
      D_8,
      D_9,
      D_10,
      D_J,
      D_Q,
      D_K,
      S_A,
      S_2,
      S_3,
      S_4,
      S_5,
      S_6,
      S_7,
      S_8,
      S_9,
      S_10,
      S_J,
      S_Q,
      S_K,
      C_A,
      C_2,
      C_3,
      C_4,
      C_5,
      C_6,
      C_7,
      C_8,
      C_9,
      C_10,
      C_J,
      C_Q,
      C_K
  }
 }