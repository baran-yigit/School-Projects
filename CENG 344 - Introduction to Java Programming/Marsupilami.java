

	public class Marsupilami extends Character{
		private boolean endangered;
		private String ability;
		
		public boolean isEndangered() {
			return endangered;
		}
		public void setEndangered(boolean endangered) {
			this.endangered=endangered;
		}
		public String getAbility() {
			return ability;
		}
		public void setAbility(String ability) {
			this.ability=ability;
		}
		Marsupilami(boolean endangered){
			super();
			this.endangered=endangered;
			this.ability="empty";
		}
		Marsupilami(boolean endangered, String ability){
			super();
			this.endangered=endangered;
			this.ability=ability;
		}
		Marsupilami(int age, String name,int lifeSpan,String habitat, boolean endangered, String ability){
			super(age,name,lifeSpan,habitat);
			this.endangered=endangered;
			this.ability=ability;
		}
		public void quote() {
			System.out.println("Houba!");
		}
		public void printInfo() {
			super.printInfo();
			if(endangered==false)
				System.out.print("I am an endangered kind. ");
			else
				System.out.print("I am not an endangered kind.");
			System.out.println("I can " + ability + ".");
		}
	}

