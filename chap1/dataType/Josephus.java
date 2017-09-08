package algorithms.chap1.dataType;
import java.util.Iterator;
import edu.princeton.cs.algs4.*;
/*
 *@author SHAN Haodong
 *@version 1.0 2017-8-8
 *@test 1.3.37
 *@use java dataType/Josephus  7 2
 */
 
 public class Josephus<Item>extends CircleQueue 
 {
 	public static void main(String[] args)
 	{
 		Josephus<player> a=new Josephus<player>();
 		//StdOut.println("Type two numbers(first is no more than 7, the second is less than the first)");
 		int N=Integer.parseInt(args[0]);
 		int M=Integer.parseInt(args[1]);
 		for(int i=0;i<N;i++)
 		{
 			a.enqueue(player.values()[i]);
 		}
 		for(Object i:a)
 	  StdOut.print(" "+i);
 		System.out.print("\nDead list:");
 		for(int i=0;i<N;i++)
 		{
 			System.out.print(" "+a.dequeue(M));
 		}
 		
 	}
 	public enum player
 	{
 		Albert,Billy,Carrot,Dean,Elliot,Floria,Gim
 	}
 }