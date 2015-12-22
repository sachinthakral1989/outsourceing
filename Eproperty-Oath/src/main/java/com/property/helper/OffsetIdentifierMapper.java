package com.property.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OffsetIdentifierMapper{

	private Map<OffSetKey,Identifier> offsetMap = new ConcurrentHashMap<>();
	private static OffsetIdentifierMapper instance = new OffsetIdentifierMapper();
	
	private OffsetIdentifierMapper(){
	}
	
	public static OffsetIdentifierMapper getInstance(){
		return instance;
	}
	
	public Identifier getIdentifierByOffset(Integer offset,String category){
		OffSetKey key = new OffSetKey();
		key.setOffset(offset);
		key.setCategory(category);
		return offsetMap.get(key);
	}

	public void setIdentifier(Integer offset,String category,Identifier value){
		OffSetKey key = new OffSetKey();
		key.setOffset(offset);
		key.setCategory(category);
		offsetMap.put(key,value);
	}

public static class Identifier{

	private String startKey;
	private String startDocId;
	
	public String getStartKey(){
		return startKey;
	}
	
	public void setStartKey(String startKey){
		this.startKey = startKey;
	}
	
	public String getStartDocId(){
		return startDocId;
	}

	public void setStartDocId(String startDocId){
		this.startDocId = startDocId;
	}
}

public static class OffSetKey{

	private Integer offset;
	private String category;
	
	public Integer getOffset(){
		return offset;
	}

	public void setOffset(Integer offset){
		this.offset = offset;
	}

	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}

	@Override
	public boolean equals(Object other){
		if(this == other){
			return true;
		}

		if(!(other instanceof OffSetKey)){
			return false;
		}
		OffSetKey key = (OffSetKey) other;
		return this.category.equals(key.category) && this.offset.equals(key.offset);
		
	}
	
	@Override
	public int hashCode(){
		int hash = 11;
		hash = hash*offset.hashCode() + 31;
		hash = hash*category.hashCode() + 31;
		return hash;
	
	}
	


}

}