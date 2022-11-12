

public class SpongeBob extends Character {
	private String pet;
	private String hobby;
	
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet=pet;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby=hobby;
	}
	SpongeBob(String pet,String hobby){
		this.pet=pet;
		this.hobby=hobby;
	}
	SpongeBob(int age,String name,int lifeSpan, String habitat,String pet,String hobby){
	super(age,name,lifeSpan,habitat);
	this.pet=pet;
	this.hobby=hobby;
	}
	public void quote() {
		System.out.println("Ravioli, ravioli, give me the formuoli!");
	}
	public void printInfo() {
		super.printInfo();
		System.out.print("I love " + hobby + ". She is a squirrel. ");
		System.out.println("I have a cute pet snail named " + pet +".");
	}
}
