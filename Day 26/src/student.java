
public class student {
	int id;
	String firstName;
	String lastName;
	double gpa;
	int sat;
	
	@Override
	public String toString() {
		String msg = String.format("%3d %-20s %4.2f %4d",
				this.id,
				this.firstName + " " + this.lastName,
				this.gpa,
				this.sat);
		return msg;
	}
	
		
	}



