//201711071 Baran Yigit
import java.util.Random;

public class Matrix {
	
	private int r;	// number of rows
	private int c;	// number of columns
	private int[][] data;	// R-by-C array
	
	// create R-by-C matrix of 0's
	public Matrix(int r,int c) {
		this.r=r;
		this.c=c;
		data=new int[r][c];
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}

	// create matrix based on 2-D array
	public Matrix(int[][] data) {
		r=data.length;
		c=data[0].length;
		this.data=new int[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				this.data[i][j]=data[i][j];
	}
	
	// create and return a random R-by-C matrix with values between 0 and 100
	public static Matrix random(int r, int c) {
		Matrix A=new Matrix(r,c);
		Random d=new Random();
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				A.data[i][j]=(d.nextInt(100));
		return A;		
	}
	
	// return C = A + B (matrix addition)
	public Matrix add(Matrix B) {
        Matrix A = this;
        if (B.r != A.r || B.c != A.c) throw new RuntimeException("Error.");
        Matrix C = new Matrix(r, c);
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
	}

	// return C = A - B (matrix subtraction)
	public Matrix subtract(Matrix B) {
		Matrix A = this;
        if (B.r != A.r || B.c != A.c) throw new RuntimeException("Error.");
        Matrix C = new Matrix(r, c);
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
	}

	// return C = A * B (matrix multiplication)
	public Matrix multiply(Matrix B) {
        Matrix A = this;
        if (A.c != B.r) throw new RuntimeException("Error.");
        Matrix C = new Matrix(A.r, B.c);
        for (int i = 0; i < C.r; i++)
            for (int j = 0; j < C.c; j++)
                for (int k = 0; k < A.c; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
	}

	// prints the data of a matrix
	public void show() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) 
                System.out.printf("%d ", data[i][j]);
            System.out.println();
        }
	}

	// prints the fizzBuzz output for a matrix’s first row
	public void fizzBuzz() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < c; j++) 
            	if (data[i][j] % 15 == 0 && data[i][j] != 0) { 
            		System.out.println("FizzBuzz"); }
            	else if (data[i][j] == 0) {
            		System.out.println(data[i][j]); }
            	else if (data[i][j] % 5 == 0) { 
            		System.out.println("Buzz"); } 
            	else if (data[i][j] % 3 == 0) { 
            		System.out.println("Fizz"); } 
            	else
            		System.out.println(data[i][j]); }
	}

	// prints the extended optimusPrime output for a matrix’s first row
	public void optimusPrime() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < c; j++) 
            	if (data[i][j] % 15 == 0 && data[i][j] != 0) { 
            		System.out.println("FizzBuzz"); }
            	else if (data[i][j] == 0) { 
            		System.out.println(data[i][j]); }
            	else if (data[i][j] % 5 == 0 && data[i][j] != 5) { 
            		System.out.println("Buzz"); } 
            	else if (data[i][j] % 3 == 0 && data[i][j] != 3) { 
            		System.out.println("Fizz"); }
            	else if (data[i][j]== 3 || data[i][j] == 5) { 
        			System.out.println("OptimusPrime"); }
            	else if (data[i][j] % 1 == 0 && data[i][j] % data[i][j] == 0) {
            		int counter = 0;
                    for (int k = 1; k <= data[i][j]; k++) {
                        if (data[i][j] % k == 0)
                            counter = counter + 1; }                    
                    if (counter == 2)
                    	System.out.println("Prime");
                    else
                    	System.out.println(data[i][j]); }
            	else
            		System.out.println(data[i][j]);
        }
	}
	
	public static void main(String[] args) {
		int [][] d= {{3,2,55},{93,52,6},{97,81,34}};
		Matrix D=new Matrix(d);
		D.show();
		System.out.println();
		
		D.fizzBuzz();
		System.out.println();
		
		D.optimusPrime();
		System.out.println();
		
		Matrix B = Matrix.random(3, 3);
        B.show();
        System.out.println();
        
        // Matrix C = Matrix.random(10, 10);
        // Matrix E = Matrix.random(10, 10);
		
        D.subtract(B).show();
        System.out.println();
       
        D.add(B).show();
        System.out.println();

        D.multiply(B).show();
        System.out.println();
                
		//C.multiply(E).fizzBuzz(); 
		//System.out.println();
		
		//C.multiply(E).optimusPrime();
		//System.out.println();
	}
}