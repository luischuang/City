package com.penghai.haier.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.penghai.haier.model.*;

import com.qdu.util.ExcelUtil;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class HaierTest {
	static{
		//System.loadLibrary("HaiErTestDLL");
		System.load("C:/DLL/HaiErTestDLL.dll");
	}
	
	public native void Shceduling(int order_number,int[] number,int[] line,int[] mould,int[] mould_number,int[] production_time,int[] mould_change_time,
			int line_number,int[] production_line);
	public native int[] getProductionOrder();
	public native int getChangeMouldTimes();
	public native long[] getStart();
	public native long[] getEnd();
	
	public static int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
	ArrayList<Order> orders=new ArrayList<Order>();
	ArrayList<Order> temp=new ArrayList<Order>();
	ArrayList<Product> products=new ArrayList<Product>();
	ArrayList<String> lines=new ArrayList<String>();
	int OrderNumber;
	int LineNumber;
	int ProductNumber;
	
	public ArrayList<Product> getResults(String filePath){
		InitData(filePath);

		for(int i=0;i<OrderNumber;i++){
			for(int j=i+1;j<OrderNumber;j++){
				if(orders.get(i).getProductID().equals(orders.get(j).getProductID())
						&&orders.get(i).getDelivery().equals(orders.get(j).getDelivery())){
					orders.get(i).setNumber(orders.get(i).getNumber()+orders.get(j).getNumber());
					orders.get(j).setNumber(0);
				}
			}
		}
		for(int i=OrderNumber-1;i>=0;i--){
			if(orders.get(i).getNumber()==0){
				orders.remove(i);
			}
		}
		OrderNumber=orders.size();
//		temp=orders;
//		for(int i=0;i<9;i++){
//			for(int j=0;j<OrderNumber;j++){
//				orders.add(temp.get(j));
//			}
//		}
//		OrderNumber=OrderNumber*10;
		
		long startTime = System.currentTimeMillis(); // 获取开始时间
		for(int i=0;i<OrderNumber;i++){
			orders.get(i).setId(i+1);
		}
		int[] Number=new int[OrderNumber],Line=new int[OrderNumber],Mould=new int[OrderNumber],
				MouldNumber=new int[OrderNumber],ProductionTime=new int[OrderNumber],
				MouldChangeTime=new int[OrderNumber],ProductionLine=new int[LineNumber];
		for(int i=0;i<orders.size();i++){
			Number[i]=orders.get(i).getNumber();
			for(int j=0;j<products.size();j++){
				if(orders.get(i).getProductID().equals(products.get(j).getProductID())){
					Mould[i]=j;
					MouldNumber[i]=products.get(j).getMouldNumber();
					ProductionTime[i]=products.get(j).getProductionTime();
					MouldChangeTime[i]=products.get(j).getChangeMouldTime();
					for(int k=0;k<LineNumber;k++){
						if(products.get(j).getLine().equals(lines.get(k))){
							Line[i]=k;
							break;
						}
					}
					break;
				}
			}
		
		}
		for(int i=0;i<LineNumber;i++)
			ProductionLine[i]=i;
		
		
		HaierTest h=new HaierTest();
		h.Shceduling(OrderNumber, Number, Line, Mould, MouldNumber, ProductionTime, MouldChangeTime, LineNumber, ProductionLine);
		int[] production_order=h.getProductionOrder();
		long[] production_start=h.getStart();
		long[] production_end=h.getEnd();
		int change_mould_times=h.getChangeMouldTimes();
		for(int i=0;i<OrderNumber;i++){
			orders.get(i).setStart(production_start[i]);
			orders.get(i).setEnd(production_end[i]);
			for(int j=0;j<products.size();j++){

				if(orders.get(i).getProductID().equals(products.get(j).getProductID())){
					switch((int)(orders.get(i).getEnd()/43200)){
					case 0:{
						products.get(j).getTask().set(0, products.get(j).getTask().get(0)+orders.get(i).getNumber());
						break;
					}
					case 1:{
						products.get(j).getTask().set(1, products.get(j).getTask().get(1)+orders.get(i).getNumber());
						break;
					}
					case 2:{
						products.get(j).getTask().set(2, products.get(j).getTask().get(2)+orders.get(i).getNumber());
						break;
					}
					case 3:{
						products.get(j).getTask().set(3, products.get(j).getTask().get(3)+orders.get(i).getNumber());
						break;
					}
					case 4:{
						products.get(j).getTask().set(4, products.get(j).getTask().get(4)+orders.get(i).getNumber());
						break;
					}
					case 5:{
						products.get(j).getTask().set(5, products.get(j).getTask().get(5)+orders.get(i).getNumber());
						break;
					}
					default:{
						products.get(j).getTask().set(6, products.get(j).getTask().get(6)+orders.get(i).getNumber());
						break;
					}
					
					}
				}
			}
		}
		for(int i=0;i<products.size();i++){
			int total=products.get(i).getTask().get(0)+products.get(i).getTask().get(1)+products.get(i).getTask().get(2)
					+products.get(i).getTask().get(3)+products.get(i).getTask().get(4)
					+products.get(i).getTask().get(5)+products.get(i).getTask().get(6);
			products.get(i).setNumber(total);
		}
		
		System.out.println("换模次数："+change_mould_times);
		
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime)/1000 + "s");
//		System.out.println("产品型号          数量         开始生产时间                结束生产时间");
//		for(int i=0;i<OrderNumber;i++){
//			System.out.println(orders.get(i).getProductID()+"  "+orders.get(i).getNumber()+"  "+Second2Time(production_start[i])+"  "+Second2Time(production_end[i]));
//		}
		return products;
	}
//	public static void main(String[] args) throws WriteException, IOException {
//		// TODO Auto-generated method stub
//		
//		//InitData("F:/data1.xlsx");
////		for(int i=0;i<orders.size();i++){
////			System.out.println(orders.get(i).getProductID()+" "+orders.get(i).getNumber());
////		}
////		for(int i=0;i<products.size();i++){
////			System.out.println(products.get(i).getLine()+" "+products.get(i).getProductID()+" "+products.get(i).getMould()+" "
////		+products.get(i).getMouldNumber()+" "+products.get(i).getProductionTime()+" "+products.get(i).getChangeMouldTime());
////		}
//		int[] Number=new int[OrderNumber],Line=new int[OrderNumber],Mould=new int[OrderNumber],
//				MouldNumber=new int[OrderNumber],ProductionTime=new int[OrderNumber],
//				MouldChangeTime=new int[OrderNumber],ProductionLine=new int[LineNumber];
//		for(int i=0;i<orders.size();i++){
//			Number[i]=orders.get(i).getNumber();
//			for(int j=0;j<products.size();j++){
//				if(orders.get(i).getProductID().equals(products.get(j).getProductID())){
//					Mould[i]=j;
//					MouldNumber[i]=products.get(j).getMouldNumber();
//					ProductionTime[i]=products.get(j).getProductionTime();
//					MouldChangeTime[i]=products.get(j).getChangeMouldTime();
//					for(int k=0;k<LineNumber;k++){
//						if(products.get(j).getLine().equals(lines.get(k))){
//							Line[i]=k;
//							break;
//						}
//					}
//					break;
//				}
//			}
//		
//		}
//		for(int i=0;i<LineNumber;i++)
//			ProductionLine[i]=i;
//		
//		
//		HaierTest h=new HaierTest();
//		h.Shceduling(OrderNumber, Number, Line, Mould, MouldNumber, ProductionTime, MouldChangeTime, LineNumber, ProductionLine);
//		int[] production_order=h.getProductionOrder();
//		long[] production_start=h.getStart();
//		long[] production_end=h.getEnd();
//		int change_mould_times=h.getChangeMouldTimes();
//		System.out.println("换模次数："+change_mould_times);
//		System.out.println("产品型号          数量         开始生产时间                结束生产时间");
//		for(int i=0;i<OrderNumber;i++){
//			System.out.println(orders.get(i).getProductID()+"  "+orders.get(i).getNumber()+"  "+Second2Time(production_start[i])+"  "+Second2Time(production_end[i]));
//		}
//		
//		WritableWorkbook writewb = null;
//		try{
//			OutputStream outstream=new FileOutputStream("D:/HaiErTestResult1.xls");
//			writewb=Workbook.createWorkbook(outstream);
//			WritableSheet sheet = writewb.createSheet("First Sheet",0);
//			Label product=new Label(0,0,"产品型号");
//			sheet.addCell(product);
//			Label line=new Label(1,0,"线体");
//			sheet.addCell(line);
//			Label productnumber=new Label(2,0,"数量");
//			sheet.addCell(productnumber);
//			Label start=new Label(3,0,"开始生产时间");
//			sheet.addCell(start);
//			Label end=new Label(4,0,"结束生产时间");
//			sheet.addCell(end);
//			Label change=new Label(5,0,"换模次数："+change_mould_times);
//			sheet.addCell(change);
//			for(int i=0;i<OrderNumber;i++){
//				Label product1=new Label(0,i+1,orders.get(i).getProductID());
//				sheet.addCell(product1);
//				for(int j=0;j<ProductNumber;j++){
//					if(orders.get(i).getProductID().equals(products.get(j).getProductID())){
//						Label line1=new Label(1,i+1,products.get(j).getLine());
//						sheet.addCell(line1);
//					}
//				}
//				Label productnumber1=new Label(2,i+1,""+orders.get(i).getNumber());
//				sheet.addCell(productnumber1);
//				Label start1=new Label(3,i+1,Second2Date(2017,7,22,production_start[i]));
//				sheet.addCell(start1);
//				Label end1=new Label(4,i+1,Second2Date(2017,7,22,production_end[i]));
//				sheet.addCell(end1);
//			}
//			
//			writewb.write();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			writewb.close();
//		}
//	}
//	
	public ArrayList<Order> getOrders(){
		for(int i=0;i<orders.size();i++){
			for(int j=0;j<products.size();j++){
				if(orders.get(i).getProductID().equals(products.get(j).getProductID())){
					orders.get(i).setLine(products.get(j).getLine());
					break;
				}
			}
		
		}
		return orders;
	}

	public void InitData(String filepath){
		File file = new File(filepath); 
		
		ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file,1);
		//System.out.println(result.size());
		for(int i=1;i<result.size();i++){
			Order order=new Order();
//			for(int j=0;j<result.get(i).size();j++){
//				//System.out.print(result.get(i).get(j)+" ");
//				
//			}
			order.setId(i);
			order.setProductID(result.get(i).get(0).toString());
			order.setNumber(Integer.parseInt(result.get(i).get(1).toString()));
			order.setPriority(Integer.parseInt(result.get(i).get(2).toString()));
			order.setDelivery(result.get(i).get(4).toString());
			order.setStart(0);
			order.setEnd(0);
			ArrayList<Integer> tasks=new ArrayList<Integer>();
			tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);
			order.setTask(tasks);
			orders.add(order);
			//System.out.print("\n");
		}
		OrderNumber=orders.size();


		
		ArrayList<ArrayList<Object>> result1 = ExcelUtil.readExcel(file,2);
		for(int i=1;i<result1.size();i++){
			Product product=new Product();
//			for(int j=0;j<result1.get(i).size();j++){
//				System.out.print(result1.get(i).get(j)+" ");
//				
//			}
			boolean isExit=false;
			for(int j=0;j<products.size();j++){
				if(products.get(j).getProductID().equals(result1.get(i).get(2).toString())){
					isExit=true;
					break;
				}
			}
			boolean lineisExist=false;
			for(int j=0;j<lines.size();j++){
				if(lines.get(j).equals(result1.get(i).get(0).toString())){
					lineisExist=true;
					break;
				}
			}
			if(lineisExist){
				
			}else{
				lines.add(result1.get(i).get(0).toString());
			}
			if(isExit){
				
			}else{
				product.setLine(result1.get(i).get(0).toString());
				product.setProductID(result1.get(i).get(2).toString());
				product.setMould(result1.get(i).get(4).toString());
				product.setMouldNumber(Integer.parseInt(result1.get(i).get(5).toString()));
				if(result1.get(i).get(6).toString().indexOf("100")!=-1){
					product.setProductionTime(36);
				}else{
					product.setProductionTime(20);
				}
				product.setChangeMouldTime(getStringNum(result1.get(i).get(7).toString()));
				ArrayList<Integer> tasks=new ArrayList<Integer>();
				tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);tasks.add(0);
				product.setTask(tasks);
				products.add(product);
			}
			
//			System.out.print("\n");
		}
		ProductNumber=products.size();
		LineNumber=lines.size();
	}
	static int getStringNum(String str){
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		//System.out.println( m.replaceAll("").trim());
		int result=Integer.parseInt(m.replaceAll("").trim());

		return result;
		
	}
	public static String Second2Date(int start_year,int start_month,int start_day,long second){
		int end_year=start_year,end_month=start_month,end_day=start_day,end_h=0,end_m=0,end_s=0;
		String time="";
		if(second>72000){
			end_day=start_day+(int)second/72000;
			
			if(months[start_month-1]<end_day){
				end_month=start_month+1;
				end_day=end_day-months[start_month-1];
			}
			
			second=second-second/72000*72000;
			if(second>3600){
				end_h=8+(int)second/3600;
				if(second%3600>60){
					end_m=(int)(second%3600)/60;
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}else{
				end_h=8;
				if(second%3600>60){
					end_m=(int)(second%3600)/60;
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}
		}else{
			end_day=start_day;
			if(second>3600){
				end_h=8+(int)second/3600;
				if(second%3600>60){
					end_m=(int)(second%3600)/60;
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}else{
				end_h=8;
				if(second%3600>60){
					end_m=(int)(second%3600)/60;
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}
		}
		
		time+=end_year+"/"+end_month+"/"+end_day+" ";
		if(end_h<10){
			time+="0"+end_h+":";
		}else{
			time+=end_h+":";
		}
		if(end_m<10){
			time+="0"+end_m;
		}else{
			time+=end_m;
		}
		return time;
		
	}
	
	public static String Second2Time(long second){
		String time="";
		if(second>57600){
			time+=(20170722+second/57600)+"日";
			second=second-second/57600*57600;
			if(second>3600){
				time+=(8+second/3600)+"时";
				if(second%3600>60){
					time+=(second%3600)/60+"分";
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}else{
				time+="8时";
				if(second%3600>60){
					time+=(second%3600)/60+"分";
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}
		}else{
			time+="20170722日";
			if(second>3600){
				time+=(8+second/3600)+"时";
				if(second%3600>60){
					time+=(second%3600)/60+"分";
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}else{
				time+="8时";
				if(second%3600>60){
					time+=(second%3600)/60+"分";
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}else{
//					if((second%3600)%60>0){
//						time+=(second%3600)%60+"秒";
//					}
				}
			}
		}
		
		
		return time;
		
	}
}
