package algorithms.chap1.analysis;
import edu.princeton.cs.algs.*;
/*
 *@version 1.0 2017-8-9
 *@author SHAN Haodong
 *@test 1.4.43
 */
public class DoublingRadioNew
{
	public static double timeTrial(int N)
	{
		int MAX=1000000;
		int[] a=new int[N];
		for(int i=0;i<N;i++)
		{
			a[i]=StdRandom.uniform(-MAX,MAX);
		}
		Stopwatch timer=new Stopwatch();
		int cnt=ThreeSum.count(a);//change the sum type here.
		return timer.elapsedTime();
	}
	public static double timeTrial_(int N)
	{
		int MAX=1000000;
		int[] a=new int[N];
		for(int i=0;i<N;i++)
		{
			a[i]=StdRandom.uniform(-MAX,MAX);
		}
		Stopwatch timer=new Stopwatch();
		int cnt=ThreeSumNew.count(a);//change the sum type here.
		return timer.elapsedTime();
	}
	public static void main(String[] args)
	{
		int MAX=Integer.parseInt(args[0]);
		int Interval=MAX/100;
		double y=timeTrial(MAX);
		StdOut.println(y);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.01);
		StdDraw.setXscale(0,MAX);
		StdDraw.setYscale(0,y); //搞不懂这一段为啥需要除以4(疑似是4核CPU造成(事实证明八核CPU也除以4)，其在下面的for语句中会有优化，但是对TwoSumFast则不需要除以4)
		//StdDraw.setYscale(0,Math.log(y));
		for(int N=Interval;N<=MAX;N+=Interval)
		{
			double time=timeTrial(N);
			double time_=timeTrial_(N);
			StdOut.printf("%7d %5.3f\n",N,time);
			StdDraw.point(N,time);
			/*StdOut.printf("%7d %5.3f\n",N,time/time_);
			StdDraw.point(N,time/time_);*/
			//StdDraw.point(N,Math.log(time));
		}
	}
}