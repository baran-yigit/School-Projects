
public class SoftwareManager extends Employee {
	protected String name;
	protected int id;
	protected int hours;
	protected String language;
	protected boolean loves;
	private String[] title;
	
	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}

	@Override
	public boolean work() {
		if(Employee.generatedNames[0] != null && Employee.generatedNames[Employee.generatedNames.length-1] != null )
			return true;
		else
			return false;		
		}
	
	SoftwareManager(String empName, int empId){
		super();
		name=empName;
		id=empId;
		hours=80;
		language="German";
		loves=true;
	}
	SoftwareManager(){
		super();
		hours=80;
		language="German";

		
	}
	
	SoftwareManager(String empName, int empId,String language){
		super();
		name=empName;
		id=empId;
		hours=80;
		language="German";
		loves=true;
	}
	
	public void printInfo() {
		String[] title = new String[3];
		title[0] = "Data Scientist";
		title[1] = "Mehmet";
		title[2] = "Hasan";
		System.out.println("In average, A software manager works "+ hours +" hours to our company.");
		System.out.println(title[1] + " speaks "+ language +" very well.");
		if(loves==true) 
			System.out.println(title[1] + " loves his business. ");

		else
		System.out.println(title[1] + " does not like his business. ");
		System.out.println(title[1] + " has enough requirements to work as a "+ title[0] + ".");
		System.out.println("Both " + title[1] + " and " + title[2] + " performing above average. However, this task is more suitable for " + title[2] + ".");
	}
		

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isLoves() {
		return loves;
	}

	public void setLoves(boolean loves) {
		this.loves = loves;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
}
