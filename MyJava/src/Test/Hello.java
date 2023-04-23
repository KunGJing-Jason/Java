package Test;

import java.io.*;
import java.util.Dictionary;

public class Hello {
	public static void main(String args[]) throws IOException {
		House house = new House();
		house.setWateramount(20);
		Thread cat;
		Thread dog;
		cat = new Thread(house);
		dog = new Thread(house);
		cat.setName("猫");
		dog.setName("狗");
		cat.start();
		dog.start();
	}
}

class House implements Runnable {
	int wateramount;
	void setWateramount(int w){
		wateramount = w;
	}
	public void run(){
		while (true) {
			String str = Thread.currentThread().getName();
			if(!DrinkWater(str)){
				return;
			}
		}
	}

	synchronized boolean DrinkWater(String str){
		if(str.equals("狗")){
			this.wateramount = wateramount - 2;
			try{
				System.out.println(str + "喝水了");
				System.out.println("水还剩 ： "+ wateramount);
				if(wateramount <= 0){
					return false;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		else if(str.equals("猫")){
			this.wateramount = wateramount - 1;
			try{
				System.out.println(str + "喝水了");
				System.out.println("水还剩 ： "+ wateramount);
				if(wateramount <= 0){
					return false;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return true;
	}
}
