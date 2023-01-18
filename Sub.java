import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.StringJoiner;

public class duplicate {

		

	String[] j= {"0","1","2","3","4","5","6","7","8","9"};

	char  n;

	String y;

	public boolean test(String s) {

		int x=0;

		List<String> list6=new ArrayList<String>();  

		for(int l=0;l<j.length;l++) {

			y=j[l];

			list6.add(y);

			

		}

		char[] ch=s.toCharArray();  

		

		List<String> list5=new ArrayList<String>();  	

	for(int k=0;k<ch.length;k++) {

		n=ch[k];

		String s1=String.valueOf(n); 

		list5.add(s1);

		

	} 

	boolean gh=false; 

	dinesh:

		for(String   d:list6) {

			

			if(list5.contains(d)) {

				gh=true;

			break dinesh;

			}

		}

	return gh;

		

	}

	public String test2(String[]s1) {

		 for(int y=0;y<s1.length;y++) {

	    	  if(s1[y].startsWith("Result")) {

	    		  s1[y]="";

	    	  }

	    	  if(s1[y].startsWith("Course")) {

	    		  s1[y]="";

	    	  }

	    	  

	      }

	    	  StringJoiner joiner = new StringJoiner("");

	          for(int i = 0; i < s1.length; i++) {

	             joiner.add(s1[i]);

	          }

	          String str = joiner.toString();

		return str;

		

	}

	

	

	

	}
