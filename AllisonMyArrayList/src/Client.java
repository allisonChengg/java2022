
public class Client {

	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList(6);
		System.out.println("Is Empty: " + list.isEmpty());
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());
		
		list.add(4);
		list.add(8);
		
		System.out.println("Is Empty: " + list.isEmpty());
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());
		
		list.add(12);
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());
		
		list.add(2, 15);
		list.add(0, 1);
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());
		
		list.removeIndex(0);
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());
		
		list.removeIndex(3);
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());	
		
		list.removeElement(8);
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());	
		
		list.add(2, 16);
		list.add(3, 17);
		list.add(4, 18);
		System.out.println(list);
		list.add(5, 19);
		list.add(-2, 25);
		
		System.out.println(list);
		System.out.println("Active Num: " + list.getNumOfActive());	
	}
}
