
package com.eniro.test.json;

import java.util.List;

public class Adverts{
	private Address address;
   	private CompanyInfo companyInfo;
   	private String companyReviews;
   	private String eniroId;
   	private String homepage;
   	private String infoPageLink;
   	private Location location;
   	private List<PhoneNumbers> phoneNumbers;

 	public Address getAddress(){
		return this.address;
	}
	public void setAddress(Address address){
		this.address = address;
	}
 	public CompanyInfo getCompanyInfo(){
		return this.companyInfo;
	}
	public void setCompanyInfo(CompanyInfo companyInfo){
		this.companyInfo = companyInfo;
	}
 	public String getCompanyReviews(){
		return this.companyReviews;
	}
	public void setCompanyReviews(String companyReviews){
		this.companyReviews = companyReviews;
	}
 	public String getEniroId(){
		return this.eniroId;
	}
	public void setEniroId(String eniroId){
		this.eniroId = eniroId;
	}
 	public String getHomepage(){
		return this.homepage;
	}
	public void setHomepage(String homepage){
		this.homepage = homepage;
	}
 	public String getInfoPageLink(){
		return this.infoPageLink;
	}
	public void setInfoPageLink(String infoPageLink){
		this.infoPageLink = infoPageLink;
	}
 	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
 	public List<PhoneNumbers> getPhoneNumbers(){
		return this.phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers){
		this.phoneNumbers = phoneNumbers;
	}
   	@Override
	public String toString() {
		return "Adverts [address=" + address + ", companyInfo=" + companyInfo
				+ ", companyReviews=" + companyReviews + ", eniroId=" + eniroId
				+ ", homepage=" + homepage + ", infoPageLink=" + infoPageLink
				+ ", location=" + location + ", phoneNumbers=" + phoneNumbers
				+ "]";
	}
}
