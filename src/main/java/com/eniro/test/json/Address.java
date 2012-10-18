
package com.eniro.test.json;


public class Address{
   	private String postArea;
   	private String postBox;
   	private String postCode;
   	private String streetName;

 	public String getPostArea(){
		return this.postArea;
	}
	public void setPostArea(String postArea){
		this.postArea = postArea;
	}
 	public String getPostBox(){
		return this.postBox;
	}
	public void setPostBox(String postBox){
		this.postBox = postBox;
	}
 	public String getPostCode(){
		return this.postCode;
	}
	public void setPostCode(String postCode){
		this.postCode = postCode;
	}
 	public String getStreetName(){
		return this.streetName;
	}
	public void setStreetName(String streetName){
		this.streetName = streetName;
	}
	@Override
	public String toString() {
		return "Address [postArea=" + postArea + ", postBox=" + postBox
				+ ", postCode=" + postCode + ", streetName=" + streetName + "]";
	}
}
