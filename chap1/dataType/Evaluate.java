package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;
/**
 * Calculate the double in Dijkstra double stacks
 * @version 1.0 2017-7-18
 * @author SHAN Haodong
 * @tensions java dataType/Evaluate<cal.txt
 * @input cal.txt should be like"( 2.0 + ( 1.0 + 6.0 ) + 2.0 )",including space 
 */

public class Evaluate
{
	public static void main(String[] args)
	{
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(s.equals("("));
			else if(s.equals("+")) ops.push(s);
			else if(s.equals("-")) ops.push(s);
			else if(s.equals("*")) ops.push(s);
			else if(s.equals("/")) ops.push(s);
			else if(s.equals("sqrt")) ops.push(s);
			else if(s.equals(")")) 
			{
				String op=ops.pop();
				double v=vals.pop();
				if(op.equals("+")) v=vals.pop()+v;
				else if(op.equals("-")) v=vals.pop()-v;
				else if(op.equals("*")) v=vals.pop()*v;
				else if(op.equals("/")) v=vals.pop()/v;
				else if(op.equals("sqrt")) v=Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}