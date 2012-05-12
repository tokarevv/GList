package List;

public class Person implements Comparable<Person>{

	private String fName;
	private String lName;
	private int age;
	
	public Person(String fName, String lName, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	@Override
	public int compareTo(Person other) {
		int res = 0;
		
		if (!(lName.equals(other.getlName()))){
			res = lName.compareTo(other.getlName());
		}
		else if (!(fName.equals(other.getfName()))){
			res = fName.compareTo(other.getfName());
		
		}
		else {
			res = age - other.getAge();
		}
		return res;
	}

	public String toSttring() {
		return fName+' '+lName+"; "+age;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
