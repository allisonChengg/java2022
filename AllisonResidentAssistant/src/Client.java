
public class Client {

	public static void main(String[] args) {
		
		CollegeStudent alli = new CollegeStudent("alli cheng", "cs", "111", 1000.00);
		System.out.println(alli);
		
		CollegeStudent claire = new CollegeStudent("claire cheng", "comp bio", "111", 1000.00);
		System.out.println(claire);
		
		ResidentAssistant bish = new ResidentAssistant("fatty", "ee", "111", 1000.00);
		System.out.println(bish);
		
		bish.addStudent(alli);
		bish.addStudent(claire);
		System.out.println(bish);
		
		HeadRA head = new HeadRA("head RA", "CS", "111", 1000.00, 300.00);
		head.addStudent(alli);
		head.addStudent(claire);
		head.addStudent(bish);
		System.out.println(head);

		System.out.println("=======");
		head.moveOut(claire.getID());
		System.out.println(head);
	}

}
