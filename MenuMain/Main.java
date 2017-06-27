package MenuMain;

import IOExcel.InputExcel;
import IOExcel.OutputExcel;
import VOPackage.TotalVO;
import VOPackage.VOTotalMng;

public class Main {
	public static void main(String[] args) throws Exception{
		//D드라이브에 저장된 "재무상태표예제" 파일 인풋스트림 후 각 시트 저장
		InputExcel excel = new InputExcel();
		excel.setWorkbook();
		excel.setSheet00();
		excel.setSheet01();
		excel.setSheet02();
		
		//저장된 시트를 각 리스트에 올리기
		////시트00 = 자산리스트, 시트01 = 부채리스트, 시트02 = 자본리스트
		VOTotalMng voManage = new VOTotalMng();
		voManage.setAssetList(excel.getSheet00());
		voManage.setLiabilityList(excel.getSheet01());
		voManage.setCapitalList(excel.getSheet02());
		voManage.setTotalList();
		
		//메인메뉴 실행
		Menu menu = new Menu(voManage);
		
		//프로그램 종료하면서 변경된 사안 저장
		OutputExcel outExcel = new OutputExcel();
		outExcel.setSheet00(voManage);
		outExcel.setSheet01(voManage);
		outExcel.setSheet02(voManage);
		outExcel.setSheet03(voManage);
		outExcel.outputWorkbook();
	}
}
