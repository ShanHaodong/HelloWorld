package algorithms.chap1.dataAbstract;

import edu.princeton.cs.algs4.*;

public class AnotherTestInterval2D
{
	public static void main(String[] args)
	{
		int N=Integer.parseInt(args[0]);
		double min=Double.parseDouble(args[1]);
		double max=Double.parseDouble(args[2]);
		Interval2D[] intervals=new Interval2D[N];
		Interval1D x;
		Interval1D y;
		double x1,x2,y1,y2;
		for(int i=0;i<N;i++)
		{
			x1=StdRandom.uniform(min,max);
			x2=StdRandom.uniform(x1,max);
			y1=StdRandom.uniform(min,max);
			y2=StdRandom.uniform(y1,max);
			x=new Interval1D(x1,x2);
			y=new Interval1D(y1,y2);
			intervals[i]=new Interval2D(x,y);
			intervals[i].draw();
		}
		
		int count_contain=0;
		int count_insert=0;
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
			if(contains(intervals[i],intervals[j])||contains(intervals[j],intervals[i])) count_contain++;
				if(intervals[i].intersects(intervals[j])) count_insert++;
			}
		}
		
		StdOut.println("Counts of contains: "+count_contain+"\nCounts of inserts:"+count_insert);
	}
	
	//判断Interval2D对象a是否包含Interval2D对象b
	public static boolean contains(Interval2D a,Interval2D b)
	{
		return false;
	}
	
}
//new Interval1D(StdRandom.uniform(min,max),StdRandom.uniform(min,max)),new Interval1D(StdRandom.uniform(min,max),StdRandom.uniform(min,max))