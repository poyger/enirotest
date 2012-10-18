
package com.eniro.test.json;


public class PhoneNumbers{
   	private String label;
   	private String phoneNumber;
   	private String type;

 	public String getLabel(){
		return this.label;
	}
	public void setLabel(String label){
		this.label = label;
	}
 	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
	@Override
	public String toString() {
		return "PhoneNumbers [label=" + label + ", phoneNumber=" + phoneNumber
				+ ", type=" + type + "]";
	}
}
