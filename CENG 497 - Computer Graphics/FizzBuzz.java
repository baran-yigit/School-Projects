//201711071 Baran Yigit
public class FizzBuzz {

	public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) { // prints the numbers 1..100
            	if (i % 15 == 0) { // for multiples of 3 and 5, prints "FizzBuzz" instead of the number (i%3==0 && i%5==0)
            		System.out.println("FizzBuzz"); }
            	else if (i % 5 == 0) { // for multiples of 5, prints "Buzz" instead of the number
            		System.out.println("Buzz"); } 
            	else if (i % 3 == 0) { // for multiples of 3, prints "Fizz" instead of the number
            		System.out.println("Fizz"); } 
            	else
            		System.out.println(i); }
	}
	
	public static void optimusPrime() {
        for (int i = 1; i <= 100; i++) { // prints the numbers 1..100
            	if (i % 15 == 0) {  // for multiples of 3 and 5, prints "FizzBuzz" instead of the number (i%3==0 && i%5==0)
            		System.out.println("FizzBuzz"); }
            	else if (i % 5 == 0 && i != 5) { // for multiples of 5, prints "Buzz" instead of the number
            		System.out.println("Buzz"); } 
            	else if (i % 3 == 0 && i != 3) { // for multiples of 3, prints "Fizz" instead of the number
            		System.out.println("Fizz"); }
            	else if (i== 3 || i == 5) { // for both prime and a multiply of 3 or 5 numbers, prints “OptimusPrime” instead of the number
        			System.out.println("OptimusPrime"); } 
            	else if (i % 1 == 0 && i % i == 0) { // for prime numbers, prints “Prime” instead of the number
            		int counter = 0;
                    for (int k = 1; k <= i; k++) {
                        if (i % k == 0)
                            counter = counter + 1; }                    
                    if (counter == 2)
                    	System.out.println("Prime");
                    else
                    	System.out.println(i); }
            	else
            		System.out.println(i);
        }
	}
	
	public static void main(String[] args) {
		fizzBuzz();
		System.out.println();
		
		System.out.println();
		
		optimusPrime();
		System.out.println();
	}
}
