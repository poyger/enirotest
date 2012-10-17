
package com.eniro.test.json;

import java.util.List;

public class Result{
   	private List<Adverts> adverts;
   	private Number itemsPerPage;
   	private String query;
   	private Number startIndex;
   	private String title;
   	private Number totalCount;
   	private Number totalHits;

 	public List<Adverts> getAdverts(){
		return this.adverts;
	}
	public void setAdverts(List<Adverts> adverts){
		this.adverts = adverts;
	}
 	public Number getItemsPerPage(){
		return this.itemsPerPage;
	}
	public void setItemsPerPage(Number itemsPerPage){
		this.itemsPerPage = itemsPerPage;
	}
 	public String getQuery(){
		return this.query;
	}
	public void setQuery(String query){
		this.query = query;
	}
 	public Number getStartIndex(){
		return this.startIndex;
	}
	public void setStartIndex(Number startIndex){
		this.startIndex = startIndex;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public Number getTotalCount(){
		return this.totalCount;
	}
	public void setTotalCount(Number totalCount){
		this.totalCount = totalCount;
	}
 	public Number getTotalHits(){
		return this.totalHits;
	}
	public void setTotalHits(Number totalHits){
		this.totalHits = totalHits;
	}
	@Override
	public String toString() {
		return "Result [adverts=" + adverts + ", itemsPerPage=" + itemsPerPage
				+ ", query=" + query + ", startIndex=" + startIndex
				+ ", title=" + title + ", totalCount=" + totalCount
				+ ", totalHits=" + totalHits + "]";
	}
}
