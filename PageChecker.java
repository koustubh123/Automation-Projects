import java.io.IOException;
import java.util.ArrayList;

public class PageChecker {
	public static ArrayList<String> pageChecker(String url) throws IOException {
		ArrayList<String> mainPageUrls = new ArrayList<String>();
		ArrayList<String> SitemapUrl = SitemapLinks.sitemapLinks(url);
		for(int i=0;i<SitemapUrl.size();i++) {
			String a = SitemapUrl.get(i);
			if(a.contains("/amenities")||a.contains("/map-and-directions")||a.contains("/contact-us/1")||a.contains("/photos")) {
				mainPageUrls.add(a);
			}
			else if(a.contains("/floorplans")) {
				if(!mainPageUrls.contains(a.substring(0, a.indexOf("floorplans")).concat("floorplans"))){
				mainPageUrls.add(a.substring(0, a.indexOf("floorplans")).concat("floorplans"));
				}
			}
		}	
		return mainPageUrls;
	}
}
