package MenuMain;

import java.util.Scanner;

import Utility.Display;
import VOPackage.VOTotalMng;

public class sub_Menu02 {
	String a = "1.특정 날짜 내용출력";
	String b = "2.일주일간 내용출력";
	String c = "3.한달간 내용출력";
	String d = "4.모든 내용출력";
	String e = "5.상위메뉴로";
	
	public sub_Menu02(){
	}
	public sub_Menu02(VOTotalMng voManage){
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
		Display disp = new Display();
		if(imsi == 1){
			disp.dateDisp(voManage);
		}
		else if(imsi == 2){
			disp.weekDisp(voManage);
		}
		else if(imsi == 3){
			disp.monthDisp(voManage);
		}
		else if(imsi == 4){
			disp.totalDisp(voManage);
		}
		else if(imsi == 5){
		}
		else{
			System.out.println("잘못입력하셨습니다.");
		}
		return imsi;
	}
}