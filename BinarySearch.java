package algorithms.chap1.basis;

import java.util.*;
import edu.princeton.cs.algs4.*;

/**
 * 二分查找法的实现
 * @version 1.0 2017-7-15
 * @author SHAN Haodong
 */
 
	public class BinarySearch
	{
  	static int count=0;
		public static void main(String[] args)
		{
			//定义一个有序(升序)数组
			int[] a=new int[100];
			for(int i=0;i<100;i++)
			{
				a[i]=i+1;
			}
			a[99]=99;
			int b=StdIn.readInt();
			int cnt;
			cnt=Search(a,b);
			StdOut.printf("%d is the %dth of a",b,cnt);
			/*double bd=Double.POSITIVE_INFINITY;
			StdOut.println("\n"+bd);*/
			//StdOut.println("\n"+(2.0e-6*100000000.1));
		}
  	/*public static int Search(int[] a,int b)
  	{
  		return Search(a,b,0,a.length-1);
  	}
  	
  	public static int Search(int[] a,int b,int low,int high)
  	{
  		if(low>high) return -1;
  		int mid=low+(high-low)/2;
  		count++;
  		if(a[mid]<b) return Search(a,b,mid,high);
  		if(a[mid]>b) return Search(a,b,low,mid);
  		else
  		{
  			StdOut.println("Search time: "+count);
  			return mid;
  	  }
  	}*/
  	
  	public static int Search(int[] a,int b)
  	{
  		int low=0;
  		int high=a.length-1;
  		while(low<=high)
  		{
  			count++;
  			int mid=low+(high-low)/2;
    		if		 (a[mid]<b) low=mid+1;
    		else if(a[mid]>b) high=mid-1;
    		else
    		{
    			StdOut.println("Search time: "+count);
    			return mid;
    	  }
    	}
    	return -1;
    }
	}
	
