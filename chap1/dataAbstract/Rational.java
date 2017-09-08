package algorithms.chap1.dataAbstract;

import edu.princeton.cs.algs4.*;
import basis.Euclid;

/**
 * Class Rational and other applied functions
 * @version 1.0 2017-7-17
 * @author SHAN Haodong
 * @test 1.2.16
 */
public class Rational
{
	private int  p;
	private int  q;
	
	public Rational(int numerator,int denominator)
	{
		 p=numerator;
		 q=denominator;
		 assert q!=0:"denominator cannot be zero!";
	}
	
	public int getp()
	{
		return p;
	}
	
	public int getq()
	{
		return q;
	}
	
	public Rational plus(Rational other)
	{
		int p,q;
		p=this.p*other.getq()+this.q*other.getp();
		q=this.q*other.getq();
		int g=Euclid.gcd(Math.abs(p),Math.abs(q));
		p/=g;
		q/=g;
		return new Rational(p,q);
	}
	
	public Rational minus(Rational other)
	{
		int p,q;
		p=this.p*other.getq()-this.q*other.getp();
		q=this.q*other.getq();
		int g=Euclid.gcd(Math.abs(p),Math.abs(q));
		p/=g;
		q/=g;
		return new Rational(p,q);
	}
	
	public Rational times(Rational other)
	{
		int p,q;
		p=this.p*other.getp();
		q=this.q*other.getq();
		int g=Euclid.gcd(Math.abs(p),Math.abs(q));
		p/=g;
		q/=g;
		return new Rational(p,q);
	}
	
	public Rational divides(Rational other)
	{
		int p,q;
		p=this.p*other.getq();
		q=this.q*other.getp();
		int g=Euclid.gcd(Math.abs(p),Math.abs(q));
		p/=g;
		q/=g;
		return new Rational(p,q);
	}
		
	public boolean equals(Rational other)
	{
		if(this==other) return true;
		if(other==null) return false;
		if(this.getClass()!=other.getClass()) return false;
		Rational that=(Rational)other;
		if(this.p!=that.p) return false;
		if(this.q!=that.q) return false;
		return true;
	}
	
	public String toString()
	{
		return (p+"/"+q);
	}
	public static void main(String[] args)
	{
		Rational a=new Rational(2,7);
		Rational b=new Rational(2,0);
		StdOut.println(a+" + "+b+"="+a.plus(b));
		StdOut.println(a+" - "+b+"="+a.minus(b));
		StdOut.println(a+" * "+b+"="+a.times(b));
		StdOut.println(a+" / "+b+"="+a.divides(b));
	}
}
	