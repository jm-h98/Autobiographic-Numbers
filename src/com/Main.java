package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
	
	static private List<Long> autobioNumbers = new LinkedList<>();
	private static Stack<Request> requests = new Stack<>();
	public static boolean DEBUG = true;
	private static long start = 0, end = 1000000000;
	
	
	public static void main(String[] args) {
		
		for(long i = start; i < end; i++) {
			if(i % 10 == 0)
				requests.push(new Request(i));
		}
		
		
		for(int i = 0; i < end - start; i++) {
			if(!requests.empty()) {
				Request temp = requests.pop();
				if(temp.check()) {
					autobioNumbers.add(temp.getNumber());
					System.out.println(temp.getNumber());
				}
			}
		}
		
		
		System.out.println("\nERGEBNIS:");
		for(int i = 0; i < autobioNumbers.size(); i++) {
			System.out.println(autobioNumbers.get(i));
		}
		
		File file = new File("autobiographicNumbers" + start + "to" + end);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("All autobiographic Numbers from " + start + " to " + end + "\n");
			for(int i = 0; i < autobioNumbers.size(); i++) {
				bw.write(autobioNumbers.get(i) + "\n");
			}
			bw.close();
		} catch (IOException e1) {
			System.out.println(e1);
		}
	}
}