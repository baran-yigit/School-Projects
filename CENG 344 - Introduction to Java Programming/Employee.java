
public abstract class Employee {

        protected final String name;
        protected final int id;

        public Employee(String empName, int empId) {
                name = empName;
                id = empId;
        }

        public String getName() {
                return name;
        }

        public int getId() {
                return id;
        }

        public abstract boolean work();


        public String toString() {
                return name + " ID: " + id;
        } 

        public boolean equals(Object other) {
                if (other instanceof Employee) {
                        return equals((Employee)other);
                }
                return false;
        }

        public boolean equals(Employee other) {
                return other != null && name.equals(other.name) && id == other.id;
        }

        private static int lastGeneratedId = 0;
        static String[] generatedNames = {
                "Leon Mcdonald",
                "Frankie Johnson",
                "Todd Rosenthal",
                "Mauricio Curran",
                "Randy Feinstein",
                "Donald Munoz",
                "Bonnie Barnhardt",
                "Gary Foley",
                "Brittney Wilson",
                "Lyndsay Loomis",
                "Madge Cartwright",
                "Stella Coan",
                "David Lafave",
                "Kimberly Matthews",
                "Dwayne Heckler",
                "Laura Payne",
                "Mary Luevano",
                "Walter Sizemore",
                "James Lawson",
                "Pat Nelson",
                "Sherry Leighton",
                "Anthony Tieman",
                "Lona Davis",
                "Ana Flores",
                "Richard Mcdonald",
                "Joseph Standley",
                "Nancy Eddy",
                "Joyce Shaw",
                "Philip Collings",
                "James Reay",
                "Barbara Acker",
                "Violet Cleary",
                "Maria Crawley",
                "Erin Hilton",
                "Evelyn Morales",
                "Leo Rose",
                "Dorothy Johnson",
                "Geoffrey Fogarty",
                "Jane Marin",
                "Daniel Tran",
                "Nancy Lee",
                "Peter Johnson",
                "Glenn Browning",
                "Mark Jaramillo",
                "Latina Gross",
                "Theresa Stutes",
                "George Thiel",
                "Robert Carney",
                "Janet Watts",
                "Michael English",
                "James Scott",
                "Elmer Honaker",
                "Brian Upton",
                "Dawne Miller",
                "Gretchen Bender",
                "John Carr",
                "Faith Gavin",
                "Traci Hill",
                "Joseph Miller",
                "Don Montoya",
                "Brandy Pritts",
                "Sandra Sheppard",
                "Charles Whitmer",
                "Ana Williams",
                "Elizabeth Murphy",
                "Michael Hollingsworth",
                "Claudine Dalton",
                "Harold Coleman",
                "Young Ayala",
                "Shelba Kirschbaum",
                "Tom Perez",
                "Amee Martin",
                "Maryanne Foote",
                "Sylvia Harrell",
                "Alexander Weibel",
                "Bruce Bailey",
                "Vincent Fidler",
                "Jack Wilbur",
                "Charles Pond",
                "Danielle Yocom",
                "John Kemp",
                "Jamie Casey",
                "Everett Frederick",
                "Emma Hazley",
                "Justin Lynch",
                "Tyler Miller",
                "Albert Reyes",
                "Wilbur Price",
                "Kimberly Halton",
                "Mary Underwood",
                "Raymond Garrett",
                "William Olive",
                "Joanne Smith",
                "Wilbert Howerton",
                "Selene Gross",
                "Jennie Andrews",
                "Jasper Barrows",
                "Robert Verdin",
                "Mark Mcallister",
                "Teri Morrissey"
        };

        public Employee() {
            name = generatedNames[lastGeneratedId];
            id = lastGeneratedId++;
    }
}
