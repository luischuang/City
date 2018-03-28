package com.penghai.haier.model;

import java.util.ArrayList;

public class Order {

	private int id;
	private String productID;
	private int number;
	private String line;
	private int priority;
	private String delivery;
	private long start;
	private long end;
	private ArrayList<Integer> task;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String ProductID) {
		productID = ProductID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long production_start) {
		this.start = production_start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Integer> getTask() {
		return task;
	}
	public void setTask(ArrayList<Integer> task) {
		this.task = task;
	}
	
}
