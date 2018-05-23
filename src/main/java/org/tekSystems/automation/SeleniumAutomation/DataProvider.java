package org.tekSystems.automation.SeleniumAutomation;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class DataProvider {
	
	public static void main(String args[]){
		try{
			DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("C:/Users/pkesari/Desktop/sample.xml"));
			doc.getDocumentElement().normalize();
			
//			System.out.println("xmlval"+doc.getDocumentElement().getChildNodes().item(0).getFirstChild().getChildNodes().item(0).getAttributes().getNamedItem("book").getNodeValue());
//			System.out.println("City: " +doc.getElementsByTagName("book"));
			System.out.println(doc.getFirstChild());

			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
