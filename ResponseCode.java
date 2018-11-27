import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ResponseCode {
	static ArrayList<String> responseCode(ArrayList<String> urlString) throws IOException{
		ArrayList<String> responseCodes = new ArrayList<String>();
		for(int i=0;i<urlString.size();i++){
			if(!urlString.get(i).isEmpty()){
				URL url = new URL(urlString.get(i));
				int httpCode = 1;
				HttpURLConnection http = (HttpURLConnection)url.openConnection();
				if(!http.getHeaderFields().isEmpty()){
					httpCode = http.getResponseCode();
				}
				String responseString;

				switch (httpCode) { 
				case 1:
					responseString = "Failed";
					break;
				case 100: 
					responseString = "Continue"; 
					break; 
				case 200: 
					responseString = "OK"; 
					break; 
				case 201: 
					responseString = "Created"; 
					break;
				case 204: 
					responseString = "No Content"; 
					break;
				case 205: 
					responseString = "Reset Content"; 
					break;
				case 206: 
					responseString = "Partial Content"; 
					break;
				case 207: 
					responseString = "Multi-Status"; 
					break;
				case 208: 
					responseString = "Already Reported"; 
					break;
				case 301: 
					responseString = "Moved Permanently"; 
					break;
				case 302: 
					responseString = "Found (Previously 'Moved temporarily')"; 
					break;
				case 303: 
					responseString = "See Other"; 
					break;
				case 304: 
					responseString = "Not Modified"; 
					break;
				case 306: 
					responseString = "Switch Proxy"; 
					break;
				case 307: 
					responseString = "Temporary Redirect"; 
					break;
				case 308: 
					responseString = "Permanent Redirect"; 
					break;
				case 400: 
					responseString = "Bad Request"; 
					break;
				case 401: 
					responseString = "Unauthorized"; 
					break;
				case 403: 
					responseString = "Forbidden"; 
					break;
				case 404: 
					responseString = "Not Found"; 
					break;
				case 408: 
					responseString = "Request Timeout"; 
					break;
				case 410: 
					responseString = "Gone"; 
					break;
				case 500: 
					responseString = "Internal Server Error"; 
					break;
				case 502: 
					responseString = "Bad Gateway"; 
					break;
				case 503: 
					responseString = "Service Unavailable"; 
					break;
				case 505: 
					responseString = "HTTP Version Not Supported"; 
					break;
				default: 
					responseString = "Please Check Internet"; 
					break; 
				} 
				if(httpCode==1){
					responseCodes.add("("+responseString+")");
				}else{
					responseCodes.add(httpCode+" ("+responseString+")");
				}
			} 
		}
		return responseCodes;
	}
}