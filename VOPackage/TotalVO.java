package VOPackage;

public class TotalVO {
	//종합 필드
	String category;
	String date;
	String account;
	long cha;
	long dae;
	
	//생성자
	public TotalVO(){
	}
	public TotalVO(String category, String date, String account, long cha, long dae){
		this.category = category;
		this.date = date;
		this.account = account;
		this.cha = cha;
		this.dae = dae;
	}
	
	//setter와 getter
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public long getCha() {
		return cha;
	}
	public void setCha(long cha) {
		this.cha = cha;
	}
	public long getDae() {
		return dae;
	}
	public void setDae(long dae) {
		this.dae = dae;
	}
}
