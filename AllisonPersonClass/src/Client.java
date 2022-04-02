
public class Client {

	public static void main(String[] args) {
		
		Person allison = new Person("Allison", 17, "09/04/04");
		System.out.println(allison);
		
		allison.isBirthday("08/03/03");
		System.out.println(allison);
		allison.isBirthday("09/04/04");
		System.out.println(allison);

		Person claire = new Person("Claire", "04/30/01");
		
		System.out.println(claire.getName());
		System.out.println(claire.getAge());
		System.out.println(claire.getBirthDate());

		System.out.println(claire);


		// Person someone = new Person();

	}

}
