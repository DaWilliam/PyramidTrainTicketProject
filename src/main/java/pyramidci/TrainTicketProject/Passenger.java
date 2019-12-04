package pyramidci.TrainTicketProject;

public class Passenger implements Comparable<Passenger>{
    private String name;
    private int age;
    private char gender;

    public Passenger(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

	public int compareTo(Passenger o) {
		
		System.out.println("Comparing Passengers " + (this.name.length() - o.getName().length()));
		if(this.equals(o))
			return 0;
		else
			return -1;				
	}
	
	@Override
	public int hashCode()
	{
		System.out.println("HashCoding Passengers");
		return this.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		
		boolean bName = this.name.equals(((Passenger)o).getName());
		boolean bAge = this.age == ((Passenger)o).getAge();
		boolean bGender = this.gender == ((Passenger)o).getGender();
		//System.out.println("Equaling Passengers: " + (bName && bAge && bGender));
	    return bName && bAge && bGender;
	}

	@Override
	public String toString() {
		//return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
