package algorithms.chap1.dataAbstract;

import java.util.Arrays;
public class StaticSETofInts
{
	private int[] a;
	public StaticSETofInts(int [] keys)
	{
		a=new int[keys.length];
		for(int i=0;i<a.length;i++)
		{
			a[i]=keys[i];
		}
		Arrays.sort(a);
	}
	public boolean contains(int key)
	{
		return (rank(key)!=-1);
	}
	private int rank(int b)
	{
		int low=0;
		int high=a.length-1;
		while(low<=high)
		{
			int mid=low+(high-low)/2;
  		if		 (a[mid]<b) low=mid+1;
  		else if(a[mid]>b) high=mid-1;
  		else return mid;
  	}
  	return -1;
  }
}