package pageClasses;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdfparser.*;
import org.apache.pdfbox.util.PDFTextStripper;
import org.tekSystems.automation.SeleniumAutomation.TekBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Compare2PDF extends TekBase{
	
	@Test  
	  public void CompareTextInTwoPdfs() throws IOException	  {
		System.setProperty("jsse.enableSNIExtension", "false");
	    Diff_Match_Patch compare= new Diff_Match_Patch();
	    
	    String text1=ReadBaseTemplate();
	    String text2=ReadModifiedTemplate();
	   System.out.print(compare.diff_main(text1,text2)); 
	    
	  }
	  public String ReadBaseTemplate() throws IOException{  
	  driver.get("file://C:/Users/pkesari/Desktop/Partners Investments.pdf");  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
	  URL url = new URL(driver.getCurrentUrl());   
	  BufferedInputStream fileToParse=new BufferedInputStream(url.openStream());  
	   //parse()  --  This will parse the stream and populate the COSDocument object.   
	  //COSDocument object --  This is the in-memory representation of the PDF document  
	  PDFParser parser = new PDFParser(fileToParse);  
	  parser.parse();  
	  //getPDDocument() -- This will get the PD document that was parsed. When you are done with this document 
	  //you must call    close() on it to release resources  
	  //PDFTextStripper() -- This class will take a pdf document and strip out all of the text and ignore the formatting and           such.  
	  String output=new PDFTextStripper().getText(parser.getPDDocument());  
	  System.out.println(output);  
	  Assert.assertTrue(output.length()>0,"Text is extracted successfully");
	  parser.getPDDocument().close();   
	  Reporter.log("base template reading is done");  
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);  
	  return output;
	  } 
	  
	  public String ReadModifiedTemplate() throws IOException{  
	  driver.get("file://C:/Users/pkesari/Desktop/Partners Investments_1.pdf");  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
	  URL url = new URL(driver.getCurrentUrl());   
	  BufferedInputStream fileToParse=new BufferedInputStream(url.openStream());  
	   //parse()  --  This will parse the stream and populate the COSDocument object.   
	  //COSDocument object --  This is the in-memory representation of the PDF document  
	  PDFParser parser = new PDFParser(fileToParse);  
	  parser.parse();  
	  //getPDDocument() -- This will get the PD document that was parsed. When you are done with this document 
	  //you must call    close() on it to release resources  
	  //PDFTextStripper() -- This class will take a pdf document and strip out all of the text and ignore the formatting and           such.  
	  String output=new PDFTextStripper().getText(parser.getPDDocument());  
	  System.out.println(output);  
	  Assert.assertTrue(output.length()>0,"Text is extracted successfully");
	  parser.getPDDocument().close();   
	   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);  
	  return output;
	  }

}
