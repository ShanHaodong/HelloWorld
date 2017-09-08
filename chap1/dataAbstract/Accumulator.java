package algorithms.chap1.dataAbstract;

import edu.princeton.cs.algs4.*;

/**
 * Class Accumulator
 * @version 1.0 2017-7-17
 * @author SHAN Haodong 
 * @test 1.2.18
 */
public class Accumulator
{
	private double qsum;
	private double m;
	private int N;
	public Accumulator()
	{
		qsum=0;
		m=0;
		N=0;
	}
	
	public void addDataValue(double val)
	{
		N++;
		qsum+=1.0*(N-1)/N*Math.pow(val-m,2);
		m+=(val-m)/N;
	}
	
	public double mean()
	{
		return m;
	}
	
	public String toString()
	{
		return("Mean:"+m+"\n"+"Var: "+this.var()+"\nStddev: "+this.stddev());
	}
	
	public double var()
	{
		return qsum/(N-1);
	}
	
	public double stddev()
	{
		return Math.sqrt(this.var());
	}
	
	//通过java dataAbstract/Accumulator <data.txt 输入得到结算结果
	public static void main(String[]args)
	{
		Accumulator a=new Accumulator();
		while(!StdIn.isEmpty())
		{
			a.addDataValue(StdIn.readDouble());
		}
		StdOut.println(a);
		
	}
}