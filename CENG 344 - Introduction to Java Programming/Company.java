import java.util.ArrayList;
import java.util.Random;


public class Company {

        private int currentTime;
        private String Compname;
        private int workyear;
        

        private ArrayList<Employee> company;

        private void initCompany() {
                company = new ArrayList<Employee>();
                for (int i = 0; i < 3; i++) {
                        company.add(new SoftwareManager("Murat",50));
                }
        }      
        
        public void run(int runTime) {
                initCompany();
                Compname="SMC";
                Random timeGen = new Random();
                int people=timeGen.nextInt(5);
                currentTime = 0;
                workyear=10;
                System.out.println("All of our workers are happy for working at " + Compname + ".");
                while (currentTime <= runTime) {
                        int scheduledTime = timeGen.nextInt(10) + 1;
                        currentTime += scheduledTime;                      
                        if(currentTime<10) {
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Current Work Hours: " + currentTime);
                        	System.out.println(Employee.generatedNames[2] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[3] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[4] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[5] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[22] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[23] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[24] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[25] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[42] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[43] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[44] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[45] + " is " + sucRate() + " at own task.");
                        }
                        else if(currentTime>=10 && currentTime<20) {
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Current Work Hours: " + currentTime);
                        	System.out.println(Employee.generatedNames[6] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[7] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[8] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[9] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[26] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[27] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[28] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[29] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[46] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[47] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[48] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[49] + " is " + sucRate() + " at own task.");
                        }
                        else if(currentTime>=20 && currentTime<30) {
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Current Work Hours: " + currentTime);
                        	System.out.println(Employee.generatedNames[10] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[11] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[12] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[13] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[30] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[31] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[32] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[33] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[50] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[51] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[52] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[53] + " is " + sucRate() + " at own task.");
                        }
                        else if(currentTime>=30 && currentTime<40) {
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Current Work Hours: " + currentTime);
                        	System.out.println(Employee.generatedNames[14] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[15] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[16] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[17] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[34] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[35] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[36] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[37] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[54] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[55] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[56] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[57] + " is " + sucRate() + " at own task.");
                        }
                        else if(currentTime>=40 && currentTime<50) {
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Current Work Hours: " + currentTime);
                        	System.out.println(Employee.generatedNames[18] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[19] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[20] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[21] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[38] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[39] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[40] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[41] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[58] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[59] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[60] + " is " + sucRate() + " at own task.");
                        	System.out.println(Employee.generatedNames[61] + " is " + sucRate() + " at own task.");
                        }
                        else {
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Work has finished succesfully. ");
                        }
                        performWork();             
                }
                        switch(people) {
                        case 0:
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Currently no one working right now.");
                        	System.out.println("--------------------------------------------");
                        	break;
                        case 1:
                        	System.out.println("--------------------------------------------");
                        	System.out.println(Employee.generatedNames[0] + " is one of the reliable workers.");
                        	System.out.println("This person succeed at all tasks. What an employee!");
                        	System.out.println("--------------------------------------------");
                        	break;
                        case 2:
                        	System.out.println("--------------------------------------------");
                        	System.out.println("Mehmet contributed this project more than Hasan's did.");
                        	System.out.println("--------------------------------------------");
                        	break;
                        case 3:
                        	System.out.println("--------------------------------------------");
                        	System.out.println(Employee.generatedNames[1] + ", Mehmet and Hasan decided to work on a project." );
                        	System.out.println("--------------------------------------------");
                        	break;
                        case 4:
                        	System.out.println("--------------------------------------------");
                        	System.out.println(Employee.generatedNames[0] + ", " + Employee.generatedNames[1] + ", " + "Hasan and Mehmet have at least " + workyear + " years experience at this company. We are owe them. ");
                        	System.out.println("--------------------------------------------");
                        }
                }         

        public int getCurrentTime() {
			return currentTime;
		}

		public void setCurrentTime(int currentTime) {
			this.currentTime = currentTime;
		}

		public String getCompname() {
			return Compname;
		}

		public void setCompname(String compname) {
			Compname = compname;
		}

		public int getWorkyear() {
			return workyear;
		}

		public void setWorkyear(int workyear) {
			this.workyear = workyear;
		}

		public ArrayList<Employee> getCompany() {
			return company;
		}

		public void setCompany(ArrayList<Employee> company) {
			this.company = company;
		}

		private void performWork() {                
                for (Employee emp : company) {
                        if (!emp.work())
                                manage(emp);
                }
        }

        private String sucRate() {
        	Random timeGen1 = new Random();
        	int successrand=timeGen1.nextInt(2);        
            if(successrand==0) {
            	return "succeed";
            }
            else {
            	return "not succeed";                        
        }
    }
        
        private void manage(Employee emp) {
        	System.out.println("All of the workers performing at their highest capacity.");
        }

        public static void main(String[] args) {
                Company com = new Company();
                com.initCompany();
                com.run(50);
                SoftwareManager sof=new SoftwareManager("Mehmet",80);
                com.manage(sof);
                sof.printInfo();
                sof.work();
        }
}
