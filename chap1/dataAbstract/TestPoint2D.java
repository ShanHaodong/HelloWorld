package algorithms.chap1.dataAbstract;

import edu.princeton.cs.algs4.*;

/**
 * readin N int and draw N random points, calculator the nearest distance between any two points
 * @version 1.0 2017-7-17
 * @author SHAN Haodong
 */
 
 public class TestPoint2D
 {
 	public static void main(String args[])
 	{
 		int N=Integer.parseInt(args[0]);
 		Point2D[] points=new Point2D[N];
 		for(int i=0;i<N;i++)
 		{
 			points[i]=new Point2D(Math.random(),Math.random());
 			points[i].draw();
 		}
 		double nearestdistance=10;
 		for(int i=1;i<N;i++)
 		{
 			double distance=points[i].distanceTo(points[0]);
 			if(distance<nearestdistance) nearestdistance=distance;
 		}
 		StdOut.println("The nearest distance is "+nearestdistance);
 	}
 }
