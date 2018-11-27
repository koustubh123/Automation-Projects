import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SitemapLinks {
	public static ArrayList<String> sitemapLinks(String url) throws IOException {
		Document doc = Jsoup.connect(url.concat("/sitemap.xml")).get();
		Elements ele = doc.getElementsByTag("loc");
		ArrayList<String> sitemapList = new ArrayList<String>();
		for(Element e:ele){
			if(!e.text().isEmpty()){
				sitemapList.add(e.text());
			}
		}
		return sitemapList;
	}

	public static ArrayList<String> imageSitemapLinks(String url) throws IOException {
		Document doc = Jsoup.connect(url.concat("/sitemap-image.xml")).get();
		Elements ele = doc.getElementsByTag("image:loc");
		ArrayList<String> sitemapList = new ArrayList<String>();
		for(Element e:ele){
			if(!e.text().isEmpty()){
				sitemapList.add(e.text());
			}
		}
		return sitemapList;
	}
}