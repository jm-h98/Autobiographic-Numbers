package com;

public class Request {
	private long number;
	private int[] numArray;
	
	public Request(long number) {
		this.number = number;
		numArray = null;
		if(Main.DEBUG)
			System.out.println(number + " erzeugt");
	}
	
	public boolean check() {
		if(Main.DEBUG)
			System.out.println("\nchecking " + number);
		
		if(number % 10000000 == 0)
			System.out.println("checking " + number);
		
		toArray();
		
		int sum = 0;
		for(int i = 0; i < numArray.length; i++)
			sum += numArray[i];
		if(sum != numArray.length)
			return false;
		
		return checkAuto();
	}
	
	private boolean checkAuto() {
		for(int i = 0; i < numArray.length; i++) {
			int count = 0;
			for(int j = 0; j < numArray.length; j++) {
				if(numArray[j] == i)
					count++;
			}
			
			if(Main.DEBUG)
				System.out.println(count + " times number " + i);
			
			if(count != numArray[i])
				return false;
		}
		return true;
	}
	
	private void toArray() {
		String temp = Long.toString(number);
		numArray = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
		    numArray[i] = temp.charAt(i) - '0';
		}
		if(Main.DEBUG)
			System.out.println(number + " successfully converted to Array");
	}
	
	public long getNumber() {
		return number;
	}
}
