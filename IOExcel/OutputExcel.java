package IOExcel;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import VOPackage.VOTotalMng;


public class OutputExcel {
	XSSFWorkbook workbook = new XSSFWorkbook();
	
	public void outputWorkbook() throws Exception{
		FileOutputStream file = new FileOutputStream("D://재무상태표만들어진파일.xlsx");
		this.workbook.write(file);
		file.close();
	}
	
	public void setSheet00(VOTotalMng voManage) {
		this.workbook.createSheet("자산내역");
		XSSFSheet sheet00 = this.workbook.getSheetAt(0);
		XSSFRow rowFirst = sheet00.createRow(0);
		rowFirst.createCell(0).setCellValue("날짜");
		rowFirst.createCell(1).setCellValue("계정");
		rowFirst.createCell(2).setCellValue("차변");
		rowFirst.createCell(3).setCellValue("대변");
		
		int rowNum = voManage.getAssetList().size();
		for(int i = 0; i<rowNum; i++){
			XSSFRow row = sheet00.createRow(i+1);
			row.createCell(0).setCellValue(voManage.getAssetList().get(i).getDate());
			row.createCell(1).setCellValue(voManage.getAssetList().get(i).getAccount());
			
			if(voManage.getAssetList().get(i).getCha() != 0){
				row.createCell(2).setCellValue(voManage.getAssetList().get(i).getCha());
			}else{
				row.createCell(3).setCellValue(voManage.getAssetList().get(i).getDae());
			}
		}
	}

	public void setSheet01(VOTotalMng voManage) {
		this.workbook.createSheet("부채내역");
		XSSFSheet sheet01 = this.workbook.getSheetAt(1);
		XSSFRow rowFirst = sheet01.createRow(0);
		rowFirst.createCell(0).setCellValue("날짜");
		rowFirst.createCell(1).setCellValue("계정");
		rowFirst.createCell(2).setCellValue("차변");
		rowFirst.createCell(3).setCellValue("대변");
		
		int rowNum = voManage.getLiabilityList().size();
		for(int i = 0; i<rowNum; i++){
			XSSFRow row = sheet01.createRow(i+1);
			row.createCell(0).setCellValue(voManage.getLiabilityList().get(i).getDate());
			row.createCell(1).setCellValue(voManage.getLiabilityList().get(i).getAccount());
			
			if(voManage.getLiabilityList().get(i).getCha() != 0){
				row.createCell(2).setCellValue(voManage.getLiabilityList().get(i).getCha());
			}else{
				row.createCell(3).setCellValue(voManage.getLiabilityList().get(i).getDae());
			}
		}
	}
	
	public void setSheet02(VOTotalMng voManage) {
		this.workbook.createSheet("자본내역");
		XSSFSheet sheet02 = this.workbook.getSheetAt(2);
		XSSFRow rowFirst = sheet02.createRow(0);
		rowFirst.createCell(0).setCellValue("날짜");
		rowFirst.createCell(1).setCellValue("계정");
		rowFirst.createCell(2).setCellValue("차변");
		rowFirst.createCell(3).setCellValue("대변");
		
		int rowNum = voManage.getCapitalList().size();
		for(int i = 0; i<rowNum; i++){
			XSSFRow row = sheet02.createRow(i+1);
			row.createCell(0).setCellValue(voManage.getCapitalList().get(i).getDate());
			row.createCell(1).setCellValue(voManage.getCapitalList().get(i).getAccount());
			
			if(voManage.getCapitalList().get(i).getCha() != 0){
				row.createCell(2).setCellValue(voManage.getCapitalList().get(i).getCha());
			}else{
				row.createCell(3).setCellValue(voManage.getCapitalList().get(i).getDae());
			}
		}
	}
	
	public void setSheet03(VOTotalMng voManage) {
		this.workbook.createSheet("통합관리");
		XSSFSheet sheet03 = this.workbook.getSheetAt(3);
		XSSFRow rowFirst = sheet03.createRow(0);
		rowFirst.createCell(0).setCellValue("날짜");
		rowFirst.createCell(1).setCellValue("자산계정");
		rowFirst.createCell(2).setCellValue("자산차변");
		rowFirst.createCell(3).setCellValue("자산대변");
		rowFirst.createCell(4).setCellValue("부채계정");
		rowFirst.createCell(5).setCellValue("부채차변");
		rowFirst.createCell(6).setCellValue("부채대변");
		rowFirst.createCell(7).setCellValue("자본계정");
		rowFirst.createCell(8).setCellValue("자본차변");
		rowFirst.createCell(9).setCellValue("자본대변");
		
		int rowNum = voManage.getTotalList().size();
		for(int i = 0; i<rowNum; i++){
			XSSFRow row = sheet03.createRow(i+1);
			if(voManage.getTotalList().get(i).getCategory()=="자산"){
				row.createCell(0).setCellValue(voManage.getTotalList().get(i).getDate());
				row.createCell(1).setCellValue(voManage.getTotalList().get(i).getAccount());
				
				if(voManage.getTotalList().get(i).getCha() != 0){
					row.createCell(2).setCellValue(voManage.getTotalList().get(i).getCha());
				}else{
					row.createCell(3).setCellValue(voManage.getTotalList().get(i).getDae());
				}
			}else if(voManage.getTotalList().get(i).getCategory()=="부채"){
				row.createCell(0).setCellValue(voManage.getTotalList().get(i).getDate());
				row.createCell(4).setCellValue(voManage.getTotalList().get(i).getAccount());
				
				if(voManage.getTotalList().get(i).getCha() != 0){
					row.createCell(5).setCellValue(voManage.getTotalList().get(i).getCha());
				}else{
					row.createCell(6).setCellValue(voManage.getTotalList().get(i).getDae());
				}
			}else if(voManage.getTotalList().get(i).getCategory()=="자본"){
				row.createCell(0).setCellValue(voManage.getTotalList().get(i).getDate());
				row.createCell(7).setCellValue(voManage.getTotalList().get(i).getAccount());
				
				if(voManage.getTotalList().get(i).getCha() != 0){
					row.createCell(8).setCellValue(voManage.getTotalList().get(i).getCha());
				}else{
					row.createCell(9).setCellValue(voManage.getTotalList().get(i).getDae());
				}
			}
		}
	}
}
