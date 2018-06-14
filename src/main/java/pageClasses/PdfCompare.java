package pageClasses;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.tekSystems.automation.SeleniumAutomation.TekBase;
import org.testng.annotations.Test;

public class PdfCompare extends TekBase {

	@Test

	public void testVerifyPDFTextInBrowser() {
		System.setProperty("jsse.enableSNIExtension", "false");
		comparePdfs("file:///C:/Users/pkesari/Desktop/certificate.pdf",
				"https://www.princexml.com/samples/flyer/flyer.pdf");
	}

	public boolean comparePdfs(String URL1, String URl2) {
		try {
			String parsedText1 = getPdfContent(URL1);
			String parsedText2 = getPdfContent(URl2);
			if (parsedText1.equals(parsedText2)) {
				System.out.println("both file are same");
				return true;
			} else {
				System.out.println("files are not same");
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;

	}

	public String getPdfContent(String strURL2) {

		driver.get(strURL2);
		PDFTextStripper pdfStripper2 = null;
		PDDocument pdDoc2 = null;
		COSDocument cosDoc2 = null;
		String parsedText2 = null;

		try {
			URL url2 = new URL(strURL2);
			BufferedInputStream file2 = new BufferedInputStream(url2.openStream());
			PDFParser parser2 = new PDFParser(file2);
			parser2.parse();
			cosDoc2 = parser2.getDocument();
			pdfStripper2 = new PDFTextStripper();
			pdfStripper2.setStartPage(1);
			pdfStripper2.setEndPage(1);
			pdDoc2 = new PDDocument(cosDoc2);
			parsedText2 = pdfStripper2.getText(pdDoc2);

		} catch (MalformedURLException e2) {
			System.err.println("URL string could not be parsed " + e2.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc2 != null)
					cosDoc2.close();
				if (pdDoc2 != null)
					pdDoc2.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		System.out.println("+++++++++++++++++");
		System.out.println(parsedText2);
		System.out.println("+++++++++++++++++");
		return parsedText2;

	}
}
