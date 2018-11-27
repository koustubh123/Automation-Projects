import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JavaScriptLoader {

	public static ArrayList<String>  jsLoader(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		ArrayList<String> arr = new ArrayList<String>();
		Elements ele = doc.getElementsByTag("script");
		for(Element e: ele){
			if(!e.attr("src").isEmpty()){
				if(!e.attr("src").contains("http")){
					arr.add("https:".concat(e.attr("src")));
				}
				else{
					arr.add(e.attr("src"));
				}
			}
		}
		return arr;
	}
}
