package algorithms.chap1.basis;
import edu.princeton.cs.algs4.*;

/**
 * Print a boolean array,* for true and space for false, line and row number is needed.
 * @version 1.0 2017-7-15
 * @author SHAN Haodong
 */
 
 public class BooleanArray
 {
 	public static void main(String[] args)
 	{
 		boolean[][] boarray=new boolean[10][10];
 		for(int i=0;i<10;i++)
 		{
 			for(int j=0;j<10;j++)
 			{
 				if(Euclid.gcd(i+1,j+1)==1) boarray[i][j]=true;
 				else boarray[i][j]=false;
 			}
 		}
 		PrintBooleanArray(boarray);
 	}
 	static void PrintBooleanArray(boolean[][] a)
 	{
 		//print the number of row
 		StdOut.printf("   ");
 		for(int i=0;i<a[0].length;i++)
 		StdOut.printf("%2d ",i+1);
 		StdOut.printf("\n");
 		
 		//print every line
 		for(int i=0;i<a.length;i++)
 		{
 			StdOut.printf("%2d ",i+1);
 			for(int j=0;j<a[i].length;j++)
 			{
 				if(a[i][j]) StdOut.printf(" * ");
 				else StdOut.printf("   ");
 			}
 			StdOut.printf("\n");
 		}
 	}
}

 		
 			
 		
