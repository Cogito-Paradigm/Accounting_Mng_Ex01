package Utility;

import java.util.List;
import java.util.Scanner;

import VOPackage.AssetVO;
import VOPackage.CapitalVO;
import VOPackage.LiabilityVO;
import VOPackage.VOTotalMng;

public class EnterValue {
	public void doubleEnter(VOTotalMng voManage){
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("복식부기할 메뉴를 선택하세요.");
			System.out.println("1.자산입력  2.부채입력  3.자본입력");
			int imsi2 = sc.nextInt();
			if(imsi2 == 1){
				enterAssetValue(voManage); break;
			}else if(imsi2 ==2){
				enterLiabilityValue(voManage); break;
			}else if(imsi2 ==3){
				enterCapitalValue(voManage); break;
			}else{
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	public void enterAssetValue(VOTotalMng voManage){
		Scanner sc = new Scanner(System.in);
		System.out.println("자산의 회계활동을 입력하시오. (날짜 / 계정명 / 차변(+) or 대변(-))");
		System.out.println("ex)yyyy-mm-dd/현금/+5000");
		
		String imsi = sc.nextLine();
		String[] split = imsi.split("/");
		String date = split[0];
		String account = split[1];
		long cha = 0;
		long dae = 0;
		if(Long.parseLong(split[2])>=0){
			cha = Long.parseLong(split[2]);
		}else{
			dae = Long.parseLong(split[2])*-1;
		}
		
		voManage.getAssetList().add(new AssetVO(date, account, cha, dae));
	}
	
	public void enterLiabilityValue(VOTotalMng voManage){
		Scanner sc = new Scanner(System.in);
		System.out.println("부채의 회계활동을 입력하시오. (날짜 / 계정명 / 차변(+) or 대변(-))");
		System.out.println("ex)yyyy-mm-dd/현금/+5000");
		
		String imsi = sc.nextLine();
		String[] split = imsi.split("/");
		String date = split[0];
		String account = split[1];
		long cha = 0;
		long dae = 0;
		if(Long.parseLong(split[2])>=0){
			dae = Long.parseLong(split[2]);
		}else{
			cha = Long.parseLong(split[2])*-1;
		}
		
		voManage.getLiabilityList().add(new LiabilityVO(date, account, cha, dae));
	}
	
	public void enterCapitalValue(VOTotalMng voManage){
		Scanner sc = new Scanner(System.in);
		System.out.println("자본의 회계활동을 입력하시오. (날짜 / 계정명 / 차변(+) or 대변(-))");
		System.out.println("ex)yyyy-mm-dd/현금/+5000");
		
		String imsi = sc.nextLine();
		String[] split = imsi.split("/");
		String date = split[0];
		String account = split[1];
		long cha = 0;
		long dae = 0;
		if(Long.parseLong(split[2])>=0){
			dae = Long.parseLong(split[2]);
		}else{
			cha = Long.parseLong(split[2])*-1;
		}
		
		voManage.getCapitalList().add(new CapitalVO(date, account, cha, dae));
	}
}
