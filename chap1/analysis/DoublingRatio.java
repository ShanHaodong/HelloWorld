package algorithms.chap1.analysis;
import edu.princeton.cs.algs4.*;

/*
 *@version 1.0 2017-8-8
 *@author SHAN Haodong
 *@use java analysis/DoublingTest 5000
 */
public class DoublingRatio
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
		int cnt=TwoSumFast.count(a);//change the sum type here.
		return timer.elapsedTime();
	}
	public static void main(String[] args)
	{
		int period=Integer.parseInt(args[0]);
		int Interval=1000;
		double prev=timeTrial(Interval);
		//double y=timeTrial(MAX);
		/*StdOut.println(y);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.1);
		StdDraw.setXscale(0,MAX);
		StdDraw.setYscale(0,y); //搞不懂这一段为啥需要除以4(疑似是4核CPU造成(事实证明八核CPU也除以4)，其在下面的for语句中会有优化，但是对TwoSumFast则不需要除以4)
		//StdDraw.setYscale(0,Math.log(y));*/
		for(int N=Interval;true;N+=N)
		{
			double time=0;
			for(int i=0;i<period;i++){
				time+=timeTrial(N);	
			}
			time=time/(1.0*period);
			StdOut.printf("%7d %5.3f %5.1f\n",N,time,time/prev);
			prev=time;
			//StdDraw.point(N,time);
			//StdDraw.point(N,Math.log(time));
		}
	}
}