//Baran Yigit 201711071
public class Rectangle {

	private int x; // x coordinate of left-bottom corner 
	private int y; // y coordinate of left-bottom corner 
	private int width; 
	private int height;
	
	// returns left-bottom corner's x coordinate
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	// returns left-bottom corner's y coordinate
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// returns width of the rectangle
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	// returns height of the rectangle
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	 
	// constructs a rectangle with given parameters 
	public Rectangle(int x, int y, int width, int height) { 
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	 
	// constructs a rectangle which has left-bottom corner on the origin (0,0) with given width and height 
	public Rectangle(int width, int height) { 
		this(0,0, width, height);
	} 
	 
	// changes the width, height and coordinates of the rectangle according to passed values 
	public void reshape(int x, int y, int width, int height) { 
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	 
	// changes the width and height of the rectangle according to passed values
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	 
	// changes the coordinates of the rectangle according to passed values
	public void setLocation(int px, int py) {
		if (px < 0 || py < 0) {
            throw new IllegalArgumentException();
        }
        this.x = px;
        this.y = py;
	}
	 
	// prints the coordinates of the left-bottom corner's coordinates (x,y)
	public void printLocation() {
		System.out.println("Rectangle[x="+x+",y="+y+"]");
	}
	 
	// prints the coordinates of every corner
	public void printCoordinates() {
		System.out.println("----------------------");
		System.out.println("Left-Bottom:"+"("+x+","+y+")"+"\n"+
	"Left-Top:"+"("+x+","+height+")"+"\n"+
				"Right-Top:"+"("+width+","+height+")"+"\n"+
	"Right-Bottom:"+"("+width+","+y+")");
		System.out.println("----------------------");
		System.out.println();
	}
	 
	// translates the rectangle and changes the coordinates according to passed values
	public void translate(int dx, int dy) {
		this.x += dx;
		this.width += dy;
	}
	 
	// rotates the rectangle 90 degrees clockwise around its left-bottom corner
	public void rotateClockwise() {
		int width1 = height;
		int height1 = -width;
		int x1=y;
		int y1=-x;
		width=width1;
		height=height1;
		x=x1;
		y=y1;
		int height2=y;
		int y2=height;
		y=y2;
		height=height2;		
	}
	 
	// rotates the rectangle 90 degrees counter-clockwise around its left-bottom corner
	public void rotateCounterClockwise() {
		int width1 = -height ;
		int height1 = width;
		int x1= -y;
		int y1= x;
		width=width1;
		height=height1-y1;
		x=x-x1;
		y=x+y1;
		height+=y;
	}
	 
	// returns true if a given point is inside or on the rectangular area else returns false
	public boolean contains(int x, int y) {
		return ((x >= this.x) && (x >= this.x && x <= this.width || x <= this.x && x >= this.width)) && (y >= this.y && y <= this.height || x <= this.x && x >= this.height);
	}
	
	public static void main(String[] args) {
		
		Rectangle rec= new Rectangle(0,0,5,6);
		System.out.println("Rectangle 1");
		rec.printCoordinates();
		
		rec.rotateClockwise();
		System.out.println("Rectangle 1 rotated clockwise");
		rec.printCoordinates();
		
		rec.rotateCounterClockwise();
		System.out.println("Rectangle 1 rotated counter-clockwise");
		rec.printCoordinates();
		
		Rectangle rec2= new Rectangle(3,5,5,7);
		System.out.println("Rectangle 2");
		rec2.printCoordinates();
		
		rec2.translate(6, 6);
		System.out.println("Rectangle 2 translated 6 units to the right");
		rec2.printCoordinates();
		
		if(rec2.contains(10, 6))
				System.out.println("True, Rectangle 2 contains given coordinates.");
		else
			System.out.println("Rectangle 2 not contains given coordinates.");
	}
}