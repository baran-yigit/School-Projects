//201711071
package BaranYigit_Labwork2;

import java.awt.Color;

public class Rubik {
Color[] colors = new Color[5];
Color[] currentColors = new Color[4];
public Rubik() {
StdDraw.setCanvasSize(500, 500);

// Pick random 4 colors with the method you have written
// Change the currentColors array accordingly with these colors
// Set the colors for filling the squares and call the filledSquare method
	this.colors= new Color[] {StdDraw.BLACK, StdDraw.YELLOW, StdDraw.ORANGE, StdDraw.RED,StdDraw.MAGENTA};
	this.currentColors= new Color[] {StdDraw.BLACK, StdDraw.YELLOW, StdDraw.ORANGE, StdDraw.RED};
	StdDraw.setPenColor(colors[0]);
	StdDraw.filledSquare(0.2, 0.8, 0.3);
	StdDraw.setPenColor(colors[1]);
	StdDraw.filledSquare(0.8, 0.2, 0.3);
	StdDraw.setPenColor(colors[2]);
	StdDraw.filledSquare(0.2, 0.2, 0.3);
	StdDraw.setPenColor(colors[3]);
	StdDraw.filledSquare(0.8, 0.8, 0.3);
}
	// Main method should exactly be this
public static void main(String[] args) {
Rubik r = new Rubik();
r.play();
}
// Randomly chooses and returns a Color from your colors[] array
public Color randomColor() {
	int x=(int) (Math.random()%5);
	
	if(x==0) {
		return colors[0];
	}
	else if(x==1) {
		return colors[1];
	}
	else if(x==2) {
		return colors[2];
	}
	else if(x==3) {
		return colors[3];
	}
	else if(x==4) {
		return colors[4];
	}
	else {
		return StdDraw.WHITE;
	}
}
// Returns true if all 4 squares have the same color, otherwise false
public boolean match(Color rand1, Color rand2, Color rand3, Color rand4) {
Color r1 = rand1;
Color r2 = rand2;
Color r3 = rand3;
Color r4 = rand4;
if(r1==r2 && r2==r3 && r3==r4) {
	return true; }
	else {
		return false;
	}
}

// Implements the game mechanism, while all squares do not have the same color lets the
// user press squares to change their colors.
// When all the squares have matching colors displays a text that says “You won!”
public void play() {
	//StdDraw.enableDoubleBuffering();

do {
	if (StdDraw.isMousePressed()) {
		//changeColor(0);
		randomColor();
		StdDraw.filledSquare(0.2, 0.8, 0.3);
		//changeColor(1);
		randomColor();
		StdDraw.filledSquare(0.8, 0.2, 0.3);
		//changeColor(2);
		randomColor();
		StdDraw.filledSquare(0.2, 0.2, 0.3);
		//changeColor(3);
		randomColor();
		StdDraw.filledSquare(0.8, 0.8, 0.3);
		StdDraw.show();
}
} while (match(colors[0], colors[1], colors[2], colors[3]));

	if (match(colors[0], colors[1], colors[2], colors[3])){
		System.out.println("you won");
		}
	else {
		
	}
	
	}

// Returns a double array which contains x and y coordinates of the mouse location
public double[] mouseLocation() {
	double x = StdDraw.mouseX();
	double y = StdDraw.mouseY();

	double[] arr= new double[] {x,y};
	
	return arr;

}
// Finds and returns the square which the mouse location resides in
public int whichSquare(double[] mouseLoc) {
	double[] arr = mouseLoc;
	double x = StdDraw.mouseX();
	double y = StdDraw.mouseY();
	if(0.0 < x && x < 0.5 || 0.0 < y && y < 0.5) {
		StdDraw.filledSquare(0.2, 0.8, 0.3);
		randomColor();
		return 1;
	}
	else if(0.0 < x && x < 0.5 || 0.5 < y && y < 1.0) {
		StdDraw.filledSquare(0.8, 0.2, 0.3);
		randomColor();
		return 2;
	}
	else if(0.5 < x && x < 1.0 || 0.0 < y && y < 0.5) {
		StdDraw.filledSquare(0.2, 0.2, 0.3);
		randomColor();
		return 3;
	}
	else if(0.5 < x && x < 1.0 || 0.5 < y && y < 1.0) {
		StdDraw.filledSquare(0.8, 0.8, 0.3);
		randomColor();
		return 4;
	}
	else {
		return 0;
	}
	
}
// Takes the square which the user has clicked and changes the color of that square randomly
public void changeColor(int whichSquare) {
	double x = StdDraw.mouseX();
	double y = StdDraw.mouseY();
	double[] arr1= new double[] {x,y};
	if (StdDraw.isMousePressed()) {
	randomColor(); }
	whichSquare(arr1);
StdDraw.show();
}
}
