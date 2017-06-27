package MenuMain;

import java.util.Scanner;

import Utility.EnterValue;
import VOPackage.VOTotalMng;

public class sub_Menu01 {
	String a = "1.자산입력";
	String b = "2.부채입력";
	String c = "3.자본입력";
	String d = "4.상위메뉴로";
	
	public sub_Menu01(){
	}
	public sub_Menu01(VOTotalMng voManage){
		int escape = 0;
		while(escape != 4){	
			Scanner sc = new Scanner(System.in);
			System.out.println("원하는 메뉴를 선택하세요.");
			System.out.println(toString());
			int imsi = sc.nextInt();
			escape = act(imsi, voManage);
		}
	}
	
	public String toString(){
		return a+"  "+b+"  "+c+"  "+d;
	}
	
	public int act(int imsi, VOTotalMng voManage){
		EnterValue enterValue = new EnterValue();
		if(imsi == 1){
			enterValue.enterAssetValue(voManage);
			//복식부기를 위해 강제로 한번 더 입력
			enterValue.doubleEnter(voManage);
		}
		else if(imsi == 2){
			enterValue.enterLiabilityValue(voManage);
			enterValue.doubleEnter(voManage);
		}
		else if(imsi == 3){
			enterValue.enterCapitalValue(voManage);
			enterValue.doubleEnter(voManage);
		}
		else if(imsi == 4){
		}
		else{
			System.out.println("잘못입력하셨습니다.");
		}
		return imsi;
	}
}
