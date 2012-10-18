
package com.eniro.test.json;


public class CompanyInfo{
   	private String companyName;
   	private String companyText;
   	private String orgNumber;

 	public String getCompanyName(){
		return this.companyName;
	}
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
 	public String getCompanyText(){
		return this.companyText;
	}
	public void setCompanyText(String companyText){
		this.companyText = companyText;
	}
 	public String getOrgNumber(){
		return this.orgNumber;
	}
	public void setOrgNumber(String orgNumber){
		this.orgNumber = orgNumber;
	}
	@Override
	public String toString() {
		return "CompanyInfo [companyName=" + companyName + ", companyText="
				+ companyText + ", orgNumber=" + orgNumber + "]";
	}
}
