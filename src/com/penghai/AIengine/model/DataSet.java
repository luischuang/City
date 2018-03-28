package com.penghai.AIengine.model;

import java.util.ArrayList;

public class DataSet {
	private String dataSetID;
	private String dataSetName;
	private String description;
	private ArrayList<Attribute> attributes;
	private ArrayList<ArrayList<Object>> data;
	private boolean optimized;
	public DataSet(String dataSetID,String dataSetName,String description){
		this.dataSetID=dataSetID;
		this.dataSetName=dataSetName;
		this.description=description;
		this.attributes=new ArrayList<Attribute>();
		this.data=new ArrayList<ArrayList<Object>>();
		this.optimized=false;
	}
	public String getDataSetID() {
		return dataSetID;
	}
	public void setDataSetID(String dataSetID) {
		this.dataSetID = dataSetID;
	}
	public String getDataSetName() {
		return dataSetName;
	}
	public void setDataSetName(String dataSetName) {
		this.dataSetName = dataSetName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
	public ArrayList<ArrayList<Object>> getData() {
		return data;
	}
	public void setData(ArrayList<ArrayList<Object>> data) {
		this.data = data;
	}
	public boolean isOptimized() {
		return optimized;
	}
	public void setOptimized(boolean optimized) {
		this.optimized = optimized;
	}
}
