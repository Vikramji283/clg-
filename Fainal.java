import java.io.File;
import java.util.*;

import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class Rebuild extends duplicate {
   public static void main(String args[]) throws IOException {

      //Loading an existing document
      File file = new File("G:\\project\\cs.pdf");
      PDDocument document = Loader.loadPDF(file);
      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();
      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
     // System.out.println(text);
      //Closing the document
      document.close();
      
      String strNew = text.replace(
	      		"College : 407SRIMATH SIVAGNANA BALAYA SWAMIGAL TAMIL ARTS AND SCIENCE COLLEGE,Year: UG/PG - I, IV, VI & Arrear\r\n"
	      		+ "SubCode Int.Mark Ext.Mark Total Result SubCode Int.Mark Ext.Mark Total Result SubCode Int.Mark Ext.Mark Total Result\r\n"
	      		,"");
	      String strr=strNew.replace("NOTE: FOR ANY CORRECTIONS, THE CANDIDATES SHOULD APPLY TO THE COE, THIRUVALLUVAR\r\n"
+ "UNIVERSITY, SERKKADU, VELLORE, WITHIN 15 DAYS FROM THE DATE OF PUBLICATION OF RESULTS.","");

	      strNew=strr.replace("No of","");
	      strr=strNew.replace("*********** End of statement *********","");
	     String[]dk1=strr.split("\\n");
	     duplicate d=new duplicate();
	     String dk2=d.test2(dk1);
	      String[]dk=dk2.split("\\s");

		  	List<String> list1=new ArrayList<String>();  
		    	for(String lang:dk){  
		    	list1.add(lang);  
		    	} 
		    	
		    	list1.removeAll(Arrays.asList("", null));
		    	String st="Papers:";
		    	int u=0;
		    	int c=0;
		    	for( u=0;u<list1.size();u++) {
		    		try {
		    		 c=list1.indexOf(st);
		    		
		    		//System.out.println(c);
		    		list1.remove(c);
		    		list1.remove(c);
		    		
		    	}
		    		catch(Exception e) {
		    		}
		    	}
		    	st="Page:";
		    	for(u=0;u<list1.size();u++) {
		    		try {
		    			c=list1.indexOf(st);
			    		
			    	
			    		list1.remove(c);
			    		list1.remove(c);
		    			
		    		}
		    		catch(Exception e) {
		    			
		    		}
		    	}
		    	
		    	for(int v=0;v<list1.size();)
		    	{
		    		String s1=list1.get(v);
		    		boolean z1=s1.startsWith("407");
		    		if(z1==true) {
		    			v++;
		    			dinesh:
		    			for(int q=0;q<3;q++) {
		    			String s4=list1.get(v);
		    			boolean z2=d.test(s4);
		    			if(z2==false) {
		    				list1.remove(v);
		    				if(z2==true) {
		    					break dinesh;
		    				}
		    				
		    				
		    			}
		    		}
		    	}
		    		v++;
		    		
		    		
		    		}
		    	
		    	
		    	
      
		    		for(String kl:list1) {
		    			System.out.println(kl);
		    		  } 
		    		
		    		
      
      
     
   }
}
