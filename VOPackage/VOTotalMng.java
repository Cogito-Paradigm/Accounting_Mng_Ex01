package VOPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class VOTotalMng {
	List<AssetVO> assetList;
	List<LiabilityVO> liabilityList;
	List<CapitalVO> capitalList;
	List<TotalVO> totalList;
	
	
	public List<AssetVO> getAssetList() {
		return assetList;
	}
	
	public void setAssetList(XSSFSheet sheet00) {
		List<AssetVO> assetList = new ArrayList<AssetVO>();
		int rowNum = sheet00.getLastRowNum();
		
		for(int i=1; i<=rowNum; i++){
			XSSFRow row = sheet00.getRow(i);
			
			//첫번째열의 날짜 저장
			String date = "";
			XSSFCell cell00 = row.getCell(0);

			if(cell00.getCellType()==0){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				date = sf.format(cell00.getDateCellValue());
			}else if(cell00.getCellType()==1){ 
				date = cell00.getStringCellValue();
			}else{
					System.out.println("날짜가 없어 넘어갑니다");
			}
			
			//두번째열의 계정명 저장
			String account = "";
			XSSFCell cell01 = row.getCell(1);

			if(cell01 == null){
			}else{
				account = cell01.getStringCellValue();
			}
			
			//세번째와 네번째열의 차변/대변 저장
			long cha = 0;
			long dae = 0;
			XSSFCell cell02 = row.getCell(2);
			XSSFCell cell03 = row.getCell(3);
			
			if(cell02 != null){
				cha = (long) cell02.getNumericCellValue();
			}else if(cell02 == null && cell03 != null){
				dae = (long) cell03.getNumericCellValue();
			}else{
				System.out.println("차변 대변에 값이없습니다.");
			}
			
			assetList.add(new AssetVO(date, account, cha, dae));
		}	
		this.assetList = assetList;
	}
	
	public List<LiabilityVO> getLiabilityList() {
		return liabilityList;
	}
	
	public void setLiabilityList(XSSFSheet sheet01) {
		List<LiabilityVO> liabilityList = new ArrayList<LiabilityVO>();
		int rowNum = sheet01.getLastRowNum();

		for(int i=1; i<=rowNum; i++){
			XSSFRow row = sheet01.getRow(i);
			
			//첫번째열의 날짜 저장
			String date = null;
			XSSFCell cell00 = row.getCell(0);
			
			if(cell00.getCellType()==0){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				date = sf.format(cell00.getDateCellValue());
			}else if(cell00.getCellType()==1){ 
				date = cell00.getStringCellValue();
			}else{
			}
			
			//두번째열의 계정명 저장
			String account = "";
			XSSFCell cell01 = row.getCell(1);
			
			if(cell01 == null){
			}else{
				account = cell01.getStringCellValue();
			}
			
			//세번째와 네번째열의 차변/대변 저장
			long cha = 0;
			long dae = 0;
			XSSFCell cell02 = row.getCell(2);
			XSSFCell cell03 = row.getCell(3);
			
			if(cell02 != null){
				cha = (long) cell02.getNumericCellValue();
			}else if(cell02 == null && cell03 != null){
				dae = (long) cell03.getNumericCellValue();
			}else{
				System.out.println("차변 대변에 값이없습니다.");
			}
			
			liabilityList.add(new LiabilityVO(date, account, cha, dae));
		}	
		this.liabilityList = liabilityList;
	}
	
	public List<CapitalVO> getCapitalList() {
		return capitalList;
	}
	
	public void setCapitalList(XSSFSheet sheet02) {
		List<CapitalVO> capitalList = new ArrayList<CapitalVO>();
		int rowNum = sheet02.getLastRowNum();
		
		for(int i=1; i<=rowNum; i++){
			XSSFRow row = sheet02.getRow(i);
			
			//첫번째열의 날짜 저장
			String date = "";
			XSSFCell cell00 = row.getCell(0);
			
			if(cell00.getCellType()==0){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				date = sf.format(cell00.getDateCellValue());
			}else if(cell00.getCellType()==1){
				date = cell00.getStringCellValue();
			}else{
			}
			
			//두번째열의 계정명 저장
			String account = "";
			XSSFCell cell01 = row.getCell(1);
			
			if(cell01 == null){
			}else{
				account = cell01.getStringCellValue();
			}
			
			//세번째와 네번째열의 차변/대변 저장
			long cha = 0;
			long dae = 0;
			XSSFCell cell02 = row.getCell(2);
			XSSFCell cell03 = row.getCell(3);
			
			if(cell02 != null){
				cha = (long) cell02.getNumericCellValue();
			}else if(cell02 == null && cell03 != null){
				dae = (long) cell03.getNumericCellValue();
			}else{
				System.out.println("차변 대변에 값이없습니다.");
			}
			
			capitalList.add(new CapitalVO(date, account, cha, dae));
		}	
		this.capitalList = capitalList;
	}
	
	public List<TotalVO> getTotalList() {
		return totalList;
	}
	
	public void setTotalList() {
		List<TotalVO> totalList = new ArrayList<TotalVO>();
		for(AssetVO e : assetList){
			totalList.add(new TotalVO("자산", e.getDate(), e.getAccount(), e.getCha(), e.getDae()));
		}
		for(LiabilityVO e : liabilityList){
			totalList.add(new TotalVO("부채", e.getDate(), e.getAccount(), e.getCha(), e.getDae()));
		}
		for(CapitalVO e : capitalList){
			totalList.add(new TotalVO("자본", e.getDate(), e.getAccount(), e.getCha(), e.getDae()));
		}
		
		if(!totalList.isEmpty()){
			Collections.sort(totalList, new Comparator<TotalVO>(){
				public int compare(TotalVO e1, TotalVO e2){
					String[] imsi = e1.getDate().split("-");
					String[] imsi2 = e2.getDate().split("-");
					
					int year01 = Integer.parseInt(imsi[0]);
					int month01 = Integer.parseInt(imsi[1]);
					int date01 = Integer.parseInt(imsi[2]);
					
					int year02 = Integer.parseInt(imsi2[0]);
					int month02 = Integer.parseInt(imsi2[1]);
					int date02 = Integer.parseInt(imsi2[2]);
					
					if(year01>year02){
						return 1;
					}else if(year01==year02&&month01>month02){
						return 1;
					}else if(year01==year02&&month01==month02&&date01>date02){
						return 1;
					}else if(year01<year02){
						return -1;
					}else if(year01==year02&&month01<month02){
						return -1;
					}else if(year01==year02&&month01==month02&&date01<date02){
						return -1;
					}
					return 0;	
				}
			});
		}
		this.totalList = totalList;
	}
}
