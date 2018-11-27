import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadXML {
	static String[] readXML() throws IOException{

		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\URL.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook (fis);
		HSSFSheet sheet = workbook.getSheet("PPURL");
		String url[] = new String[sheet.getPhysicalNumberOfRows()];
		Iterator<Row> ite = sheet.rowIterator();
		int i = 0;
		while(ite.hasNext()){
			Row row = ite.next();
			Iterator<Cell> cite = row.cellIterator();
			while(cite.hasNext()){
				Cell c = cite.next();
				url[i] = c.toString();
				i++;
			}
		}
		workbook.close();
		fis.close();
		return url;
	}
}
