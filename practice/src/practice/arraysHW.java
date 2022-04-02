package practice;

import java.util.Scanner;

public class arraysHW {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("How many numbers will you enter?");
		int numOfInt = keyboard.nextInt();
		
		int[] arrayOfInt = new int[numOfInt];
		System.out.println("Enter " + numOfInt + " integers one per line: ");
		
		int sum = 0;
		for (int i = 0; i < numOfInt; i++) {
			arrayOfInt[i] = keyboard.nextInt();
			sum += arrayOfInt[i];
		}
		
		for (int i : arrayOfInt) {
			System.out.print(i);
			System.out.print(" " + ((i * 100.00) / sum) + "% of the sum.");
			System.out.println();
		}
	
	}
	
	/*
	public static int[] swap(int[] intArray) {
		int temp = intArray[0];
		intArray[0] = intArray[intArray.length - 1];
		intArray[intArray.length - 1] = temp;
		
		return intArray;
	}
	*/

}
