public class Client {
	
	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		myList.add(new Jewelry("Pura", "fs", "dsc", 12, 5));
		
		Object result = myList.get(0);
		//Jewelry result = myList.get(0);
		System.out.println((result).toString());
		System.out.println(((Jewelry) result).getName());
	}
}
