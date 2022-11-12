// 201711071

public class BaranYigit_lab1 {
    
		static void a() {
			int[] arr = new int[] {2, 2, 3, 3, 4, 4};
			int result = 0;
			for (int i = 1; i < arr.length; ++i) {
				if (arr[i] == arr[i-1] && (i == arr.length-1 || arr[i] != arr[i+1])) {
                ++result;
            }
        }
        System.out.print("This array has " + result + " batch(es).");
        System.out.println();
    } 
	
		static void b() {

	        int[] anArray = new int[] {25, 5, 12, 29, 97, 98, 99, 100, 32};
	        int count = 1;
	        
	        for (int j = 0; j < anArray.length - 1; j++) {
	            if (anArray[j] + 1 == anArray[j+1]) {
	                count++;
	            }
	        }
	            
	        if (count >= 3) {
	                System.out.println("True.");
	            } else {
	                System.out.println("False.");
	            }
	    }
	        
		static void c() {
	        int count = 0;
	        int[] arr = new int[] { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1};
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == 0)
	               count++;
	            }

	        for (int i = 0; i < count; i++)
	             arr[i] = 0;

	        for (int i = count; i < arr.length; i++)
	             arr[i] = 1;

	            System.out.print("Array after segregation is: ");
	        for (int i = 0; i < arr.length; i++)
	            System.out.print(arr[i] + " ");  
	            System.out.println();
	        }
			

	        	public static void d() {
	        	    int arr[][] = { {3, 6}, {11, 32}, {48, 97} };
	        	    int n = 3;
	        		int oddInd = 1;
	        	    int evenInd = 0;
	        	    while (true) {
	        	        while (evenInd < n && arr[evenInd][oddInd] % 2 == 0)
	        	            evenInd += 2;
	        	             
	        	        while (oddInd < n && arr[evenInd][oddInd] % 2 == 1)
	        	            oddInd += 2;
    
	        	        if (evenInd < n && oddInd < n) {
	        	                int temp = arr[evenInd][oddInd];
	        	                arr[evenInd][oddInd] = arr[oddInd][evenInd];
	        	                arr[oddInd][evenInd] = temp;
	        	            }
	        	           else
	        	            break;
	        	    }
	        	    for (int i = 0; i < n; i++)
	        	    	for (int j = 0; j < n-1; j++)
	        	        System.out.print(arr[i][j] + " ");
	        	}
	    
	        public static void main(String[] args) {
	        a();
	    	b(); 
	    	c();
	    	d();
	    	}}
