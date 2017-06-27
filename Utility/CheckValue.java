package Utility;

import java.util.List;

import VOPackage.AssetVO;
import VOPackage.CapitalVO;
import VOPackage.LiabilityVO;
import VOPackage.VOTotalMng;

public class CheckValue {
	public  void assetSumValue(VOTotalMng voManage){
		long chaSum = 0;
		long daeSum = 0;
		for(AssetVO e : voManage.getAssetList()){
			chaSum = chaSum + e.getCha();
			daeSum = daeSum + e.getDae();
		}

		System.out.println("자산 차변의 합은 "+chaSum);
		System.out.println("자산 대변의 합은 "+daeSum);
		System.out.println("따라서 자산의 총합은 "+(chaSum-daeSum)+" 입니다.");
	}
	
	public void liabilitySumValue(VOTotalMng voManage){
		long chaSum = 0;
		long daeSum = 0;
		for(LiabilityVO e : voManage.getLiabilityList()){
			chaSum = chaSum + e.getCha();
			daeSum = daeSum + e.getDae();
		}

		System.out.println("부채 차변의 합은 "+chaSum);
		System.out.println("부채 대변의 합은 "+daeSum);
		System.out.println("따라서 부채의 총합은 "+(daeSum-chaSum)+" 입니다.");
	}
	
	public void capitalSumValue(VOTotalMng voManage){
		long chaSum = 0;
		long daeSum = 0;
		for(CapitalVO e : voManage.getCapitalList()){
			chaSum = chaSum + e.getCha();
			daeSum = daeSum + e.getDae();
		}

		System.out.println("자본 차변의 합은 "+chaSum);
		System.out.println("자본 대변의 합은 "+daeSum);
		System.out.println("따라서 자본의 총합은 "+(daeSum-chaSum)+" 입니다.");
	}
	
	public void CheckValue(VOTotalMng voManage){
		long assetChaSum = 0;
		long assetDaeSum = 0;
		for(AssetVO e : voManage.getAssetList()){
			assetChaSum = assetChaSum + e.getCha();
			assetDaeSum = assetDaeSum + e.getDae();
		}
		long assetSum = assetChaSum-assetDaeSum;
		
		long liabilityChaSum = 0;
		long liabilityDaeSum = 0;
		for(LiabilityVO e : voManage.getLiabilityList()){
			liabilityChaSum = liabilityChaSum + e.getCha();
			liabilityDaeSum = liabilityDaeSum + e.getDae();
		}
		long liabilitySum = liabilityDaeSum-liabilityChaSum;
		
		long capitalChaSum = 0;
		long capitalDaeSum = 0;
		for(CapitalVO e : voManage.getCapitalList()){
			capitalChaSum = capitalChaSum + e.getCha();
			capitalDaeSum = capitalDaeSum + e.getDae();
		}
		long capitalSum = capitalDaeSum-capitalChaSum;
		
		System.out.println("자산의 총합은 "+assetSum);
		System.out.println("부채의 총합은 "+liabilitySum);
		System.out.println("자본의 총합은 "+capitalSum);
		
		if(assetSum == liabilitySum+capitalSum){
			System.out.println("자산 = 부채 + 자본 ");
			System.out.println(assetSum+"="+liabilitySum+"+"+capitalSum);
			System.out.println("올바른 회계처리입니다.");
		}else{
			System.out.println("자산 = 부채 + 자본 ");
			System.out.println(assetSum+"="+liabilitySum+"+"+capitalSum);
			System.out.println("회계처리에 오류가 있습니다.");
		}
		
	}
}
