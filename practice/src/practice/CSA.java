package practice;

import java.util.ArrayList;

public class CSA {
	
	public static void main(String[] args) {
		
		boolean x = false;
		boolean y = true;
		boolean z = false;;
		
		boolean q = x || ((x || y) && (x || z));
		System.out.println(q);
	
		/*
		 * Chapter 6 Q 6
		int[] list = {11, 22, 33, 44, 55};
		int index = 0;
		while (index < list.length) {
			System.out.print(list[index] + " ");
			index = (int) (Math.random() * 8);
			System.out.println(index);
		}
		*/
		Class1 c1 = new Class1();
		Class2 c2 = new Class2(200);
		System.out.println(c1.getX());
		System.out.println(c2.getX());
		System.out.println(c2.getY());
		
		ArrayList<Class1> aaa = new ArrayList<Class1>();
		aaa.add(new Class1());
		aaa.add(new Class2(200));
		System.out.println(aaa);
	}
}
class Class1 {
	private int x;
	public Class1() { x=100; }
	public int getX() { return x; }
}
class Class2 extends Class1 {
	private int y;
	public Class2(int y) { this.y = y; }
	public int getY() { return y; }
}
