package com.penghai.haier.model;

import java.util.ArrayList;

public class Product {
	private String line;
	private String productID;
	private int number;
	private String mould;
	private int mouldNumber;
	private int productionTime;
	private int changeMouldTime;
	private ArrayList<Integer> task;
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getMould() {
		return mould;
	}
	public void setMould(String mould) {
		this.mould = mould;
	}
	public int getMouldNumber() {
		return mouldNumber;
	}
	public void setMouldNumber(int mouldNumber) {
		this.mouldNumber = mouldNumber;
	}
	public int getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(int productionTime) {
		this.productionTime = productionTime;
	}
	public int getChangeMouldTime() {
		return changeMouldTime;
	}
	public void setChangeMouldTime(int changeMouldTime) {
		this.changeMouldTime = changeMouldTime;
	}
	public ArrayList<Integer> getTask() {
		return task;
	}
	public void setTask(ArrayList<Integer> task) {
		this.task = task;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
