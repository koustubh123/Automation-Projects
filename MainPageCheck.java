import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class MainPageCheck {
	static HashMap<String,String> mainPage(String url, ArrayList<String> arr) throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\phantomjs-windows\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();

		String[] floorPlanName = {"Floorplan Page Heading","Floorplan Group Heading","Floorplan Content"};
		String[] contactUsName = {"Contact us Page Heading","Guest Card Form"};
		String[] photosToursName = {"Photos & Tours Page Heading","Photos Thumbnail Group", "Image/Video Viewer","Google 360 Tours", "Panoramic Tour Viewer"};
		String[] mapsDirectionName = {"Maps & Direction Page Heading","Map Viewer"};
		String[] amenitiesName = {"Amenities Page Heading","Amenity Viewer"};

		String[] floorPlan = {"//h1[@class='page-heading']","//h2[@class='fp-group-header']","//div[@id='floorplan-overview-content']"};
		String[] contactUs = {"//h1[@class='page-heading']","//fieldset[@id='guest-card-simple']"};
		String[] photosTours = {"//h1[@class='page-heading']","//div[@class='thumb-group js-thumb-group']",
				"//div[@id='galleria-viewer-vid']","//div[@class='google-360-wrapper']", "//div[@class='panoramax-container']"};
		String[] mapsDirection = {"//h1[@class='page-heading']","//div[@id='neighborhood-map-container']"};
		String[] amenities = {"//h1[@class='page-heading']","//div[@class='main-viewer']"};

		if(url.contains("amenities")) {
			return MainPageCheck.ppTest(amenities, amenitiesName, driver, url);
		}else if(url.contains("photos")) {
			return MainPageCheck.ppTest(photosTours, photosToursName, driver, url);
		}else if(url.contains("contact-us")) {
			return MainPageCheck.ppTest(contactUs, contactUsName, driver, url);
		}else if(url.contains("map-and-directions")) {
			return MainPageCheck.ppTest(mapsDirection, mapsDirectionName, driver, url);
		}else if(url.contains("floorplans")){
			return MainPageCheck.ppTest(floorPlan, floorPlanName, driver, url);
		}
		return null;
	}

	static HashMap<String,String> ppTest(String[] arr,String[] arr1,WebDriver driver, String url) {
		driver.get(url);
		HashMap<String,String> hmap = new HashMap<>();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		for(int i=0;i<arr.length;i++) {
			if(!driver.findElements(By.xpath(arr[i])).isEmpty()) {
				hmap.put(arr1[i], "Verified with Automation");
			}else {
				hmap.put(arr1[i], "Please check Manually");
			}
		}
		return hmap;
	}
}
