import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateHTMLTable {
	static void createHtml(String url,
			ArrayList<String> sitemapList,
			ArrayList<String> imageSitemapList,
			ArrayList<String> sitemapListrc,
			ArrayList<String> imageSitemapListrc,
			ArrayList<String> jsList,
			ArrayList<String> jsListrc) throws IOException {

		ArrayList<String> mainPageList = new ArrayList<String>();
		HashMap<String, String> hmap = new HashMap<String, String>();
		String fileName = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss").format(new Date());
		PrintWriter pw = new PrintWriter(new FileWriter("Reports\\".concat("PP_Health_Checkup_"+fileName).concat(".html")));
		//PrintWriter pw = new PrintWriter(new FileWriter("Reports\\test.html"));
		pw.println("<TABLE BORDER = 5 ALIGN=CENTER>");
		pw.println("<TR><TH>URL <TH><a href="+url+" target=_blank>"+url+"</a>");

		pw.println("<TR BGCOLOR=#FA5882><TH COLSPAN=2> Main Page Element Results");
		pw.println("<TR BGCOLOR=#F5A9A9><TH>Element<TH>Visible on ProspectPortal</TR>");

		mainPageList = PageChecker.pageChecker(url);
		for(int j=0;j<mainPageList.size();j++) {
			hmap = MainPageCheck.mainPage(mainPageList.get(j),mainPageList);
			
			for (Map.Entry<String, String> entry : hmap.entrySet()) {
				if(!entry.getValue().contains("Please check Manually")) {
					pw.println("<TR ALIGN=CENTER BGCOLOR=#CEF6CE><TD>" + entry.getKey() + "<TD>" + entry.getValue());
				}else {
					pw.println("<TR ALIGN=CENTER BGCOLOR=#F5A9A9><TD>" + entry.getKey() + "<TD>" + entry.getValue());
				}
			}
		}

		pw.println("<TR BGCOLOR=#FA5882><TH COLSPAN=2> SITE-MAP Result");
		pw.println("<TR BGCOLOR=#F5A9A9><TH>Page-URLs<TH>Response Code</TR>");
		for (int i = 0; i < sitemapList.size(); i++) {
			if(!sitemapList.isEmpty()) {
				if(!sitemapListrc.get(i).contains("200")){
					pw.println("<TR ALIGN=CENTER BGCOLOR=#F5A9A9><TD>" + sitemapList.get(i) + "<TD>" + sitemapListrc.get(i));
				}else{
					pw.println("<TR ALIGN=CENTER BGCOLOR=#CEF6CE><TD>" + sitemapList.get(i) + "<TD>" + sitemapListrc.get(i));
				}
			}else {
				pw.println("<TR><TH COLSPAN=2> No URL Found");
			}
		}
		pw.println("<TR BGCOLOR=#FA5882><TH COLSPAN=2> Image SITE-MAP Result");
		pw.println("<TR BGCOLOR=#F5A9A9><TH>Image-URLs<TH>Response Code</TR>");
		for (int i = 0; i < imageSitemapList.size(); i++) {
			if(!imageSitemapList.isEmpty()) {
				if(!imageSitemapListrc.get(i).contains("200")){
					pw.println("<TR ALIGN=CENTER BGCOLOR=#F5A9A9><TD>" + imageSitemapList.get(i) + "<TD>" + imageSitemapListrc.get(i));
				}else{
					pw.println("<TR ALIGN=CENTER BGCOLOR=#CEF6CE><TD>" + imageSitemapList.get(i) + "<TD>" + imageSitemapListrc.get(i));
				}
			}else {
				pw.println("<TR><TH COLSPAN=2> No URL Found");
			}
		}
		pw.println("<TR BGCOLOR=#FA5882><TH COLSPAN=2> JS Report(Home Page)");
		pw.println("<TR BGCOLOR=#F5A9A9><TH>JS-URLs<TH>Response Code</TR>");
		for (int i = 0; i < jsList.size(); i++) {
			if(!jsListrc.get(i).contains("200")){
				pw.println("<TR ALIGN=CENTER BGCOLOR=#F5A9A9><TD>" + jsList.get(i) + "<TD>" + jsListrc.get(i));
			}else{
				pw.println("<TR ALIGN=CENTER BGCOLOR=#CEF6CE><TD>" + jsList.get(i) + "<TD>" + jsListrc.get(i));
			}
		}
		pw.println("</TABLE>");
		pw.close();
	}
}