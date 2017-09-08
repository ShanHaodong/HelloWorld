package algorithms.chap1.basis;

import edu.princeton.cs.algs4.*;

/** 
 * 实现基本的矩阵计算
 * @version 1.0 2017-7-16
 * @author SHAN Haodong
 */
 
 public class Matrix
 {
 	public static void main(String[] args)
 	{
 		double[]x={1.2,1.5,1.8};
 		double[]y={1.5,1.6,1.2};
 		double[][]a={{1.0,1.0,0.1},{2.0,2.0,2.0},{3.0,3.0,3.0}};
 		double[][]b={{1.0,1.0,0.1},{2.0,2.0,2.0},{3.0,3.0,3.0}};
 		matrixOut(dot(x,y));
 		matrixOut(mult(a,b));
 		matrixOut(mult(a,x));
 		matrixOut(mult(x,a));
 	}
 	static void matrixOut(double x)
 	{
 		
 	}
 	static void matrixOut(double[]x)
 	{
 		
 	}
 	static void matrixOut(double[][]a)
 	{
 		
 	}
 	//两个向量的点乘
 	static double dot(double[] x,double[] y)
 	{
 		double result=0;
 		int line=x.length;
 		if(line!=y.length) return Double.POSITIVE_INFINITY;
 		for(int i=0;i<line;i++)
 		{
 			result+=x[i]*y[i];
 		}
 		return result;
 	}
 	//矩阵与矩阵的乘积
 	static double[][] mult(double [][] a,double [][] b)
 	{
 		int line=a.length;
 		int row=b.length;
 		double[][] result=new double[line][row];
 		if(line!=b[0].length) return result;
 		else
 		for(int i=0;i<line;i++)
 		{
 			for(int j=0;j<row;j++)
 			{
 				result[i][j]=a[i][j]*b[j][j];
 			}
 		}
 		return result;
 	}
 	
 	static double[][] transpose(double [][]a)
 	{
 		int line=a.length;
 		int row=a[0].length;
 		double[][] result=new double[row][line];
 		for(int i=0;i<line;i++)
 		{
 			for(int j=0;j<row;j++)
 			{
 				result[j][i]=a[i][j];
 			}
 		}
 		return result;
 	}
 	
 	static double[] mult(double[][] a,double[] x)
 	{
 		int line=a.length;
 		double[] result=new double[line];
 		for(int i=0;i<line;i++)
 		{
 			result[i]=dot(a[i],x);
 		}
 		return result;
 	}
 	
 	static double[] mult(double[]x,double[][] a)
 	{
 		int line=x.length;
 		int row=a[0].length;
 		double[] result=new double[row];
 		for(int i=0;i<row;i++)
 		{
 			for(int j=0;j<line;j++)
 			{
 				result[i]+=x[j]*a[j][i];
 			}
 		}
 		return result;
 	}
}