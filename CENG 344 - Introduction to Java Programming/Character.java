//Baran Yigit 201711071



public class Character {
	private int age;
	private String name;
	private int lifeSpan;
	private String habitat;

	public Character() {
		this.age=10;
		this.name="Character";
		this.lifeSpan=150;
		this.habitat="Character's Habitat";
	}
	public Character(int age, String name,int lifeSpan, String habitat) {
		this.age=age;
		this.name=name;
		this.lifeSpan=lifeSpan;
		this.habitat=habitat;
	}
	public void quote() {
		System.out.println();
		System.out.println("I Tawt I Taw a Puddy Tat!");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getlifeSpan() {
		return lifeSpan;
	}
	public void setlifeSpan(int lifeSpan) {
		this.lifeSpan=lifeSpan;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat=habitat;
	}
	public void printInfo() {
		if(age==5)
		System.out.print("I am an animal. ");
			System.out.print("I am "+this.age + " years old. ");
		System.out.print("My name is "+this.name + ". ");
		if(age==60)
		System.out.print("I am a sponge. ");
		System.out.print("I have "+this.lifeSpan+ " years lifespan" + ". ");
		System.out.print("My habitat is "+this.habitat + ". ");
	}

	public static void main(String[] args) {
		// All of my characters has a color which is yellow and 2 legs with different ages.
		Character animal=new Character(6,"Tweety",33,"bird cage in Granny's house");
		animal.printInfo();
		animal.quote();
		System.out.println();
		
		animal = new Marsupilami(5,"Marsupilami",15,"forest",false,"jumping around trees");
		animal.printInfo();
		animal.quote();
		System.out.println();
		
		animal = new Wolverine(3,"Wolverine",13,"Northern Canada",true,"three");
		animal.printInfo();
		animal.quote();
		System.out.println();
		
		animal = new SpongeBob(60,"Spongebob",100,"pineapple","Gary","practicing karate with my friend Sandy Cheeks");
		animal.printInfo();
		animal.quote();
		System.out.println();
	}
}
