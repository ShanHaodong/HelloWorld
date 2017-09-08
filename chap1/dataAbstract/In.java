package algorithms.chap1.dataAbstract;

import edu.princeton.cs.algs4.*;

/**
 * finish the static function readInts() of In class
 * @version 1.0 2017-7-17
 * @author SHAN Haodong
 * @test 1.2.15
 */
 
 public class In
 {
 	public static void main(String[] args)
 	{
 		int[] a=readInts("next");
 		for(int i=0;i<a.length;i++)
 		StdOut.println(a[i]);
 	}
 	public In(String name)
 	{
 		
 	}
 	public static int[] readInts(String name)
 	{
 		In in=new In(name);
 		String input =in.readAll();
 		String[] words=input.split("\\s+");
 		int[] ints=new int[words.length];
 		for(int i=0;i<words.length;i++)
 			ints[i]=Integer.parseInt(words[i]);
 		return ints;
 	}
 	public String readAll()
 	{
 		return ("1 25 16");
 	}
}