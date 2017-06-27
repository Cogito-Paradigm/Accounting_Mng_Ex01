package IOExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputExcel {
	XSSFWorkbook workbook;
	XSSFSheet sheet00;
	XSSFSheet sheet01;
	XSSFSheet sheet02;
	XSSFSheet sheet03;
	
	
	public XSSFWorkbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook() throws Exception {
		FileInputStream file = new FileInputStream("D://재무상태표예제.xlsx");
		this.workbook = new XSSFWorkbook(file);
	}
	public XSSFSheet getSheet00() {
		return sheet00;
	}
	public void setSheet00() {
		this.sheet00 = workbook.getSheetAt(0);
	}
	public XSSFSheet getSheet01() {
		return sheet01;
	}
	public void setSheet01() {
		this.sheet01 = workbook.getSheetAt(1);
	}
	public XSSFSheet getSheet02() {
		return sheet02;
	}
	public void setSheet02() {
		this.sheet02 = workbook.getSheetAt(2);
	}
	public XSSFSheet getSheet03() {
		return sheet03;
	}
	public void setSheet03() {
		this.sheet03 = workbook.getSheetAt(3);
	}
}
