package assignment3;

public class Student1 {
	
	    private int prn;
	    private String name;
	    private String dob;
	    private double marks;

	    public Student1(int prn, String name, String dob, double marks) {
	        this.prn = prn;
	        this.name = name;
	        this.dob = dob;
	        this.marks = marks;
	    }

	    public int getPrn() {
	        return prn;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public double getMarks() {
	        return marks;
	    }
	    public void display() {
	        System.out.println("PRN: " + prn);
	        System.out.println("Name: " + name);
	        System.out.println("DOB: " + dob);
	        System.out.println("Marks: " + marks);
	    }
	}


