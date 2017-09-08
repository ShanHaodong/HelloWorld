package algorithms.chap1.dataType;

import edu.princeton.cs.algs4.*;
/*
 *@version 1.0 2017-8-7
 *@author SHAN Haodong
 *@run java dataType/EvaluatePostfix<cal.txt
 */
public class EvaluatePostfix
{
	public static void main(String[] args)
	{
		Stack<String> ops=new Stack<String>();
		Stack<String> vals=new Stack<String>();
		//change the Infix to Postfix;
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
				va=String.format("%s %s %s",vals.pop(),va,op);
				else
				va=String.format("%s %s",va,op);
				vals.push(va);
			}else{
				vals.push(s);
			}
		}
		String str=vals.pop();
		StdOut.println(str);
		str=" "+str;
		//calculate the values
		Stack<Double> val=new Stack<Double>();
		do{
			str=str.substring(str.indexOf(" ")+1);
			String s;
			if(str.indexOf(" ")!=-1) s=str.substring(0,str.indexOf(" "));
			else s=str;
			//StdOut.println(s);
			if(s.equals("+")) val.push(val.pop()+val.pop());
			else if(s.equals("-")){ Double v=val.pop(); val.push(val.pop()-v);}
			else if(s.equals("*")) val.push(val.pop()*val.pop());
			else if(s.equals("/")){ Double v=val.pop(); val.push(val.pop()/v);}
			else if(s.equals("sqrt")) val.push(Math.sqrt(val.pop()));
			else val.push(Double.parseDouble(s));
			//StdOut.println(str);
		}while(str.indexOf(" ")!=-1);
		
		StdOut.printf("The value is %f",val.pop());
	}
}