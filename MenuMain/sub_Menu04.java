package MenuMain;

import java.util.Scanner;

import Utility.CheckValue;
import VOPackage.VOTotalMng;

public class sub_Menu04 {
	String a = "1.자산 총계 확인";
	String b = "2.부채 총계 확인";
	String c = "3.자본 총계 확인";
	String d = "4.대차대조 확인";
	String e = "5.상위메뉴로";
	
	public sub_Menu04(){
	}
	public sub_Menu04(VOTotalMng voManage){
		int escape = 0;
		while(escape != 5){	
			Scanner sc = new Scanner(System.in);
			System.out.println("원하는 메뉴를 선택하세요.");
			System.out.println(toString());
			int imsi = sc.nextInt();
			escape = act(imsi, voManage);
		}
	}
	
	public String toString(){
		return a+"  "+b+"  "+c+"  "+d+"  "+e;
	}
	
	public int act(int imsi, VOTotalMng voManage){
		CheckValue checkValue = new CheckValue();
		if(imsi == 1){
			checkValue.assetSumValue(voManage);
		}
		else if(imsi == 2){
			checkValue.liabilitySumValue(voManage);
		}
		else if(imsi == 3){
			checkValue.capitalSumValue(voManage);
		}
		else if(imsi == 4){
			checkValue.CheckValue(voManage);
		}
		else if(imsi == 5){
		}
		else{
			System.out.println("잘못입력하셨습니다.");
		}
		return imsi;
	}
}