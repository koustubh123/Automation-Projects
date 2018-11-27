import java.io.IOException;
import java.util.ArrayList;

public class PPHealthMain {
	public static void ppHealthMain() throws IOException {
		String[] urlList = ReadXML.readXML();
		ArrayList<String> sitemapUrl = new ArrayList<String>();
		ArrayList<String> imageSitemapUrl = new ArrayList<String>();
		ArrayList<String> jsList = new ArrayList<String>();
		for(int i=0;i<urlList.length-1;i++){
			System.out.println("Report Started");
			try{
				sitemapUrl = SitemapLinks.sitemapLinks(urlList[i]);
				imageSitemapUrl = SitemapLinks.imageSitemapLinks(urlList[i]);
				jsList = JavaScriptLoader.jsLoader(urlList[i]);
				CreateHTMLTable.createHtml(urlList[i],sitemapUrl,imageSitemapUrl,ResponseCode.responseCode(sitemapUrl),ResponseCode.responseCode(imageSitemapUrl),jsList,ResponseCode.responseCode(jsList));
				System.out.println("Success");
			}catch(Exception e) {
				System.out.println("Report Failed Please Try Again");
				e.printStackTrace();
			}
		}
	}
}
