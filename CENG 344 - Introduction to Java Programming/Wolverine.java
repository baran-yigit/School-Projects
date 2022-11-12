

public class Wolverine extends Character {
	private boolean mutant;
	private String claw;
	
	public boolean isMutant() {
		return mutant;
	}
	public void setMutant(boolean mutant) {
		this.mutant=mutant;
	}
	public String getClaw() {
		return claw;
	}
	public void setClaw(String claw) {
		this.claw=claw;
	}
	Wolverine(boolean mutant,String claw) {
	super();	
	this.mutant=mutant;
	this.claw=claw;
	}
	Wolverine(int age, String name,int lifeSpan, String habitat, boolean mutant,String claw){
	super(age,name,lifeSpan,habitat);
	this.mutant=mutant;
	this.claw=claw;
	}
	public void quote() {
		System.out.println();
		System.out.println("Your best is enough. Trust me!");
	}
	public void printInfo() {
		super.printInfo();
		if(mutant==true)
			System.out.print("I have a mutant power that is healing factor.");
		System.out.print(" I have " + claw + " retractable claws in each hand.");			
	}
}
