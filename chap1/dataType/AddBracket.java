package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;

/*
 *@version 1.0 2017-8-7
 *@author SHAN Haodong
 *@details add brackets for left brackets-lacked Infix
 */
 
 public class AddBracket
 {
 	public static void main(String[] args)
 	{
		Stack<String> ops=new Stack<String>();
		Stack<String> vals=new Stack<String>();
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(s.equals("(")) ;
			else if(s.equals("+")||
							s.equals("-")||
							s.equals("*")||
							s.equals("/")||
							s.equals("sqrt")) ops.push(s);
			else if(s.equals(")"))
			{
				String op=ops.pop();
				String va=vals.pop();
				if(!op.equals("sqrt"))
				va=String.format("( %s %s %s )",vals.pop(),op,va);
				else
				va=String.format("( %s %s )",op,va);
				vals.push(va);
			}else{
				vals.push(s);
			}
		}
		StdOut.print(vals.pop());
		
 	}
 }