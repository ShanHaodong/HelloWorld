package algorithms.chap1.analysis;
import edu.princeton.cs.algs4.*;
/*
 *@version 1.0 2017-8-8
 *@author SHAN Haodong
 *@class 1.4
 */
public class Stopwatch
{
	private final long start;
	public Stopwatch()
	{
		start=System.currentTimeMillis();
	}
	public double elapsedTime()
	{
		long now=System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}