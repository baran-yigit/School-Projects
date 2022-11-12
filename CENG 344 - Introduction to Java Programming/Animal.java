
public abstract class Animal {

        protected final String eats;
        protected final int noOfLegs;
        protected boolean vegetarian;
    	protected String color;

        public Animal(String eats, int noOfLegs) {
                this.eats = eats;
                this.noOfLegs = noOfLegs;
        }

        public boolean isVegetarian() {
			return vegetarian;
		}

		public void setVegetarian(boolean vegetarian) {
			this.vegetarian = vegetarian;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getEats() {
                return eats;
        }

        public int getNoOfLegs() {
                return noOfLegs;
        }

        public abstract boolean swim();


        public String toString() {
                return Animal.generatedNames[1] + " eats creatures which has " + noOfLegs + " legs.";
        } 

        public boolean equals(Object other) {
                if (other instanceof Animal) {
                        return equals((Animal)other);
                }
                return false;
        }

        public boolean equals(Animal other) {
                return other != null && eats.equals(other.eats) && noOfLegs == other.noOfLegs;
        }

        static String[] generatedNames = {
                "Barry", "Garry", "Ducky", "Lucky" , "Funny" , "Friendly" , "Lovely" , "Lonely" , "Truly" , "Rarely", "Tweety" , "fly" , "Swim" , "Quack quack" , "Cloudy"     };

        public Animal() {
            eats = generatedNames[11];
            noOfLegs = 2;
    }
}
