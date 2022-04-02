/*
 * Allison Cheng
 * Person someone = new Person();
 * The compiler can't find the no parameter constructor and therefore can't compile
 */

public class Person {
	
	private String name;
	private int age;
	private String birthDate;

	public Person(String n, int a, String d) {
		name = n;
		age = a;
		birthDate = d;
	}

	public Person(String n, String d) {
		this(n, 0, d);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getBirthDate() {
		return birthDate;
	}

	// prints out happy birthday & increases age by 1 if the date is their birthday
	public void isBirthday(String date) {

		if(birthDate.equals(date)) {
			System.out.println("Happy Birthday!");
			age++;
		}
	}

	public String toString() {
		return "Name: " + name + " Age: " + age + " Birth Date: " + birthDate;
	}

}
