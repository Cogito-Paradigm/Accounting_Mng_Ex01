package Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import VOPackage.AssetVO;
import VOPackage.CapitalVO;
import VOPackage.LiabilityVO;
import VOPackage.TotalVO;
import VOPackage.VOTotalMng;

public class Display {
	public void assetDisp(VOTotalMng voManage){
		for(AssetVO e : voManage.getAssetList()){
			System.out.println("날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
		}
	}
	
	public void liabilityDisp(VOTotalMng voManage){
		for(LiabilityVO e : voManage.getLiabilityList()){
			System.out.println("날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
		}
	}
	
	public void capitalDisp(VOTotalMng voManage){
		for(CapitalVO e : voManage.getCapitalList()){
			System.out.println("날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
		}
	}
	
	public void totalDisp(VOTotalMng voManage){
		for(TotalVO e : voManage.getTotalList()){
			System.out.println("분류 : "+e.getCategory()+" 날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
		}
	}
	
	public void dateDisp(VOTotalMng voManage){
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하시오.");
		System.out.println("ex)2017-03-03");
		String a = sc.nextLine();
		
		String[] imsi = a.split("-");
		int year = Integer.parseInt(imsi[0]);
		int month = Integer.parseInt(imsi[1]);
		int date = Integer.parseInt(imsi[2]);
		
		
		for(TotalVO e : voManage.getTotalList()){
			String[] imsi2 = e.getDate().split("-");
			int year2 = Integer.parseInt(imsi2[0]);
			int month2 = Integer.parseInt(imsi2[1]);
			int date2 = Integer.parseInt(imsi2[2]);
			
			if(year==year2&&month==month2&&date==date2){
				System.out.println("분류 : "+e.getCategory()+"날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
			}else{
			}
		}
	}
	
	public void weekDisp(VOTotalMng voManage){
		String[] imsi = get7DayAgoDate().split("-");
		int year = Integer.parseInt(imsi[0]);
		int month = Integer.parseInt(imsi[1]);
		int date = Integer.parseInt(imsi[2]);
		
		Date nowDate = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String[] imsi2 = fm.format(nowDate).split("-");
		int year2 = Integer.parseInt(imsi2[0]);
		int month2 = Integer.parseInt(imsi2[1]); 
		int date2 = Integer.parseInt(imsi2[2]);
		
		//for(TotalVO e : )
		
	}
	
	public String get7DayAgoDate(){
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(0x1ee6280, "KST"));
		cal.add(Calendar.DATE, -7);
		java.util.Date weekago = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		return formatter.format(weekago);
	}
	
	public void monthDisp(VOTotalMng voManage){
		//프로그램을 돌리는 현재 날짜를 생성해서 저장
		Date nowDate= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] imsi = sdf.format(nowDate).split("-");
		int month = Integer.parseInt(imsi[1]);
		int date = Integer.parseInt(imsi[2]);
		
		if(month == 01){
			for(TotalVO e : voManage.getTotalList()){
				String[] imsi2 = e.getDate().split("-");
				int month2 = Integer.parseInt(imsi2[1]);
				int date2 = Integer.parseInt(imsi2[2]);
				
				if((month2==12&&date2>=date)||(month2==1&&date2<=date)){
					System.out.println("분류 : "+e.getCategory()+"날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
				}
			}
		}else{
			for(TotalVO e : voManage.getTotalList()){
				String[] imsi2 = e.getDate().split("-");
				int month2 =Integer.parseInt(imsi2[1]);
				int date2 = Integer.parseInt(imsi2[2]);
				
				if(((month)-1==month2&&date2>=date)||month==month2&&date2<=date){
					System.out.println("분류 : "+e.getCategory()+"날짜 : "+e.getDate()+" 계정 : "+e.getAccount()+" 차변 : "+e.getCha()+" 대변 : "+e.getDae());
				}
			}
		}
	}
}
