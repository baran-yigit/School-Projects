import java.util.Random;

public class Duck extends Animal implements InFoodChain {
	static Random rnd=new Random();
	protected String eats;
	protected int noOfLegs;
	protected int hours;
	protected String color;
	protected boolean vegetarian;
	private String[] title;
	
	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}

	@Override
	public boolean swim() {
		if(Animal.generatedNames[0] != null && Animal.generatedNames[Animal.generatedNames.length-1] != null )
			return true;
		else
			return false;		
		}
	
	Duck(String eats, int noOfLegs){
		super();
		this.eats=eats;
		this.noOfLegs=noOfLegs;
		hours=30;
		color="Yellow";
		vegetarian=true;
	}
	Duck(){
		super();
		hours=30;
		color="Yellow";		
	}
	
	Duck(boolean vegetarian,String eats, int noOfLegs,String color){
		super();
		this.eats=eats;
		this.noOfLegs=noOfLegs;
		hours=30;
		color="Yellow";
		vegetarian=true;
	}
	
	public void printInfo() {
		String[] title = new String[3];
		title[0] = "Barry";
		title[1] = "Garry";
		title[2] = "Ducky";
		Random timeGen3 = new Random();
		int successrand3=timeGen3.nextInt(35)%36+3;
		System.out.println("In average, A duck lives "+ successrand3 +" years on his/her habitat.");
		System.out.println(title[1] + " eats "+ eats +" when he is depressed.");
		if(vegetarian==false) 
			System.out.println(title[2] + " has a different swim style. ");

		else
		System.out.println(title[1] + " does not like swimming at the dark. ");
		System.out.println(title[1] + " has much more visitors than "+ title[0] + ".");
		System.out.println("Both " + title[1] + " and " + title[2] + " swim fast. However, they would not reach to " + title[2] + "'s speed.");
	}
		
	public void makeSound() {
    	System.out.println("--------------------------------------------");
		System.out.println("quack quack");
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setLoves(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getEats() {
		return eats;
	}

	public void setEats(String eats) {
		this.eats = eats;
	}

	public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}


public static void main(String[] args) {
    Duck sof=new Duck(true,"flies",2,"yellow");
    sof.run(46);
    System.out.println(sof.toString());
    sof.huntsDown();
    sof.huntedBy();
    System.out.println(sof.dietType());
    System.out.println(sof.climate());
    System.out.println(sof.habitat());
    System.out.println(sof.lifeExpectancy());
    sof.printInfo();
    sof.swim();
    sof.makeSound();
}

@Override
public String dietType() {
	Random timeGen2 = new Random();
	int successrand=timeGen2.nextInt(4);        
    if(successrand==0) {
    	return "herbivore";
    }
    else if(successrand==1) {
    	return "omnivore";
    }
    else {
    	return "carnivore";   
}
}

@Override
public void huntsDown() {
	if(dietType()=="herbivore") {
		System.out.println("This animal is a herbivore.");
	}
	else if(dietType()=="omnivore") {
		System.out.println("This animal is a omnivore.");
	}
	else {
		System.out.println("This animal is a carnivore.");   
	}
}

@Override
public void huntedBy() {
	if(dietType()=="herbivore") {
		System.out.println("This animal hunted by herbivores or omnivores.");
	}
	else if(dietType()=="omnivore") {
		System.out.println("This animal hunted by omnivores or carnivores.");
	}
	else {
		System.out.println("This animal hunted by omnivores.");   
	}
	
}

@Override
public String climate() {
	if(dietType()=="herbivore") {
		return "tropical";
	}
	else if(dietType()=="omnivore") {
		return "dry";
	}
	else {
		return "polar";   
	}
}

@Override
public String habitat() {
	if(dietType()=="herbivore") {
		return "sea";
	}
	else if(dietType()=="omnivore") {
		return "jungle";
	}
	else {
		return "hills";   
	}
}

@Override
public int lifeExpectancy() {
	Random timeGen3 = new Random();
	int successrand1=(timeGen3.nextInt(200)%100+1);
	return successrand1;
}

public void run(int runTime) {


    Random timeGen = new Random();
    int people=timeGen.nextInt(5);
    int currentTime = 0;
    System.out.println("All of the visitors are happy because of experienced to be with dozens of duck. ");
    while (currentTime <= runTime) {
            int scheduledTime = timeGen.nextInt(2) + 8;
            currentTime += scheduledTime;                      
            if(currentTime<10) {
            	System.out.println("--------------------------------------------");
            	System.out.println("Current Visited Minute(s): " + currentTime);
            	System.out.println(Animal.generatedNames[2] + " is a beautiful duck. She is charming.");
            	System.out.println(Animal.generatedNames[3] + " is her favourite duck. He looks like her father. ") ;
            	System.out.println(Animal.generatedNames[1] + " is the most beautiful duck at this area.");
            	System.out.println(Animal.generatedNames[14] + " days can reveal beautiful moments of any kind of ducks.");

            }
            else if(currentTime>=10 && currentTime<20) {
            	System.out.println("--------------------------------------------");
            	System.out.println("Current Visited Minute(s): " + currentTime);
            	System.out.println(Animal.generatedNames[6] + " is ill. That's why we must care him.");
            	System.out.println(Animal.generatedNames[7] + " should not go further from her place. ");
            	System.out.println(Animal.generatedNames[0] + " is the green one who is shining at the sunlight.");

            }
            else if(currentTime>=20 && currentTime<30) {
            	System.out.println("--------------------------------------------");
            	System.out.println("Current Visited Minute(s): " + currentTime);
            	System.out.println(Animal.generatedNames[10] + " is a yellow duck so that we called her as " + Animal.generatedNames[10] +" .");
            	System.out.println(Animal.generatedNames[11] + "ing can be seen usually by these ducks.");
            	System.out.println(Animal.generatedNames[12] + "ming at the pool with ducks is unbeliavable moment. ");


            }
            else if(currentTime>=30 && currentTime<40) {
            	System.out.println("--------------------------------------------");
            	System.out.println("Current Visited Minute(s): " + currentTime);
            	System.out.println(Animal.generatedNames[4] + " is the most talkative duck at this place. ");
            	System.out.println(Animal.generatedNames[5] + " has a lovely voice. ");
            	System.out.println(Animal.generatedNames[13] + " can be heard at any time from ducks. ");

            }
            else if(currentTime>=40 && currentTime<45) {
            	System.out.println("--------------------------------------------");
            	System.out.println("Current Visited Minute(s): " + currentTime);
            	System.out.println(Animal.generatedNames[8] + " is one of the rarest kind in this world. ");
            	System.out.println(Animal.generatedNames[9] + " can dance while he is singing a song.");
            }
            else {
            	System.out.println("--------------------------------------------");
            	System.out.println("These ducks seems like having a good time.");
            }
     
    }
            switch(people) {
            case 0:
            	System.out.println("--------------------------------------------");
            	System.out.println("Currently no one swimming right now.");
            	System.out.println("--------------------------------------------");
            	break;
            case 1:
            	System.out.println("--------------------------------------------");
            	System.out.println(Animal.generatedNames[0] + " loves watching Tweety.");
            	System.out.println(Animal.generatedNames[0] + " is "+ FindingFlyRate() + ".");
            	System.out.println("--------------------------------------------");
            	break;
            case 2:
            	System.out.println("--------------------------------------------");
            	System.out.println("Barry and Garry are best friends ever.");
            	System.out.println("--------------------------------------------");
            	break;
            case 3:
            	System.out.println("--------------------------------------------");
            	System.out.println(Animal.generatedNames[1] + " and Barry having a good time. Ducky sometimes jealous them." );
            	System.out.println("--------------------------------------------");
            	break;
            case 4:
            	System.out.println("--------------------------------------------");
            	System.out.println("Probably they won't agree anything about when become 4 ducks.");
            	System.out.println("--------------------------------------------");
            }
    }
private String FindingFlyRate() {
	Random timeGen1 = new Random();
	int successrand=timeGen1.nextInt(2);        
    if(successrand==0) {
    	return "succeed at finding fly";
    }
    else {
    	return "not succeed at finding fly";                        
}
}
}