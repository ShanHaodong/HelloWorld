package algorithms.chap1.dataAbstract;

import edu.princeton.cs.algs4.*;

/**
 * test the interval2D
 * @version 1.0 2017-7-17
 * @author SHAN Haodong
 */
 
 public class TestInterval2D
 {
 	public static void main(String[] args)
 	{
 		double x1=Double.parseDouble(args[0]);
 		double x2=Double.parseDouble(args[1]);
 		double y1=Double.parseDouble(args[2]);
 		double y2=Double.parseDouble(args[3]);
 		
 		int T=Integer.parseInt(args[4]);
 		
 		Interval1D xInterval=new Interval1D(x1,x2);
 		Interval1D yInterval=new Interval1D(y1,y2);
 		
 		Interval2D box=new Interval2D(xInterval,yInterval);
 		Counter c=new Counter("hits");
 		box.draw();
 		
 		for(int i=0;i<T;i++)
 		{
 			Point2D p=new Point2D(Math.random(),Math.random());
 			if(box.contains(p)) c.increment();
 			else p.draw();
 		}
 		
 		StdOut.println(c);
 		StdOut.println(box.area());
 	}
 }