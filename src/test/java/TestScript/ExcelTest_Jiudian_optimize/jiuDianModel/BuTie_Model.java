package TestScript.ExcelTest_Jiudian_optimize.jiuDianModel;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class BuTie_Model {
	
	//补贴= 蜂蜜+ 折扣+优惠券
	
	private double buTie;
	private double fengMi;
	private double zheKou;
	private double youHuiQuan;
	private double calculate_Butie;
	
	
	
	public double getBuTie() {
		return buTie;
	}
	public void setBuTie(double buTie) {
		this.buTie = buTie;
	}
	public double getFengMi() {
		return fengMi;
	}
	public void setFengMi(double fengMi) {
		this.fengMi = fengMi;
	}
	public double getZheKou() {
		return zheKou;
	}
	public void setZheKou(double zheKou) {
		this.zheKou = zheKou;
	}
	public double getYouHuiQuan() {
		return youHuiQuan;
	}
	public void setYouHuiQuan(double youHuiQuan) {
		this.youHuiQuan = youHuiQuan;
	}
	
	public double getCalculate_Butie() {
		return calculate_Butie;
	}
	public void setCalculate_Butie(double calculate_Butie) {
		this.calculate_Butie = calculate_Butie;
	}
	
	
	public boolean judgeEquals(){
		
		boolean flag =  false;
		
		double calculate_butie = fengMi + zheKou + youHuiQuan;
    	
    	Dailylog.logInfo("补贴的计算结果(处理之前)是：" + calculate_butie);
    	
    	calculate_butie = WriterExcelUtil.getValidNumbersOfDouble(calculate_butie, buTie+"");
    	Dailylog.logInfo("补贴的计算结果(处理之后)是:" + calculate_butie);
    	
    	setCalculate_Butie(calculate_butie);
    	
    	if(calculate_butie == buTie){
    		flag = true;
    	}
		
    	return flag;
		
	}
	
	
	
}
