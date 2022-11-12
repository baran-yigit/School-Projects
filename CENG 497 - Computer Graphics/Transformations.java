//Baran Yigit 201711071
package lab6;
import java.awt.*;
import java.awt.event.*;

public class Transformations extends Frame implements ActionListener {
 /**
	 * 
	 */
	private static final long serialVersionUID = 518435818434146416L;
	
	// Initializing coordinates of the triangle
	int[] x = {500,700,600};
 	int[] y = {300,300,100};

 	public static void main(String[] args) {
 		// Setting frame size to (800x800)
 		// Setting background color
 		// Setting visibility
		Transformations f = new Transformations();
		f.setSize(800, 800);
		f.setTitle("Transformations");
		f.setVisible(true);
		f.setBackground(Color.getHSBColor(0.3f, 0.4f, 0.5f));		
 	}
 
	public class MyFinishWindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public Transformations() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
		
		MenuBar mb = new MenuBar();	
		Menu m = new Menu("File");
		m.add(new MenuItem("Set Default"));
		m.addActionListener(this);
		mb.add(m);
		setMenuBar(mb);	
		
	    Panel p=new Panel();  
	    p.setBounds(0,40,800,50);  	    	    
		add(p);	    
		p.setBackground(Color.black);
	   
		Button tup = new Button();
	    tup.setLabel("Translate Up");
		tup.addActionListener(this);
		
		Button tdown = new Button();
		tdown.setLabel("Translate Down");
		tdown.addActionListener(this);
		
		Button tright = new Button();
	    tright.setLabel("Translate Right");
		tright.addActionListener(this);
		
		Button tleft = new Button();
	    tleft.setLabel("Translate Left");
		tleft.addActionListener(this);
		
		Button refx = new Button();
		refx.setLabel("Reflect X");
		refx.addActionListener(this);
		
		Button refy = new Button();
		refy.setLabel("Reflect Y");
		refy.addActionListener(this);
		
		p.add(tup);
		p.add(tdown);
		p.add(tright);
		p.add(tleft);
		p.add(refx);
		p.add(refy);
	    
		addWindowListener(new MyFinishWindow());
		setSize(800,800);
		setLayout(new GridLayout(20,1));
		setVisible(true);		
		 // Setting title
		 // Creating menu
		 // Adding WindowListener to exit the program when window is closed
		 // Setting layout
		 // Adding control panel
		 // Adding buttons
	}
 
	// Draw 2 lines and paint 1 filled triangle
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int width = this.getWidth();
		int height = this.getHeight();
	
		g2d.drawLine(width/2, 0, width/2, height);
		g2d.drawLine(0, height/2, width, height/2);
		g2d.fillPolygon(x,y,3);
	}
 
	// Action listener
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		repaint();
		
		if (command == "Translate Up") {
			for (int i=0;i<3;i++) {
				y[i]-=10;
		 }
		 getGraphics().fillPolygon(x,y,3);
		}
		
		else if (command == "Translate Down") {
			for (int i=0;i<3;i++) {
				y[i]+=10;
		 }
		 getGraphics().fillPolygon(x,y,3);
		}
		
		else if (command == "Translate Right") {
			for (int i=0;i<3;i++) {
				x[i]+=10;
		 }
		 getGraphics().fillPolygon(x,y,3);
		}
		
		else if (command == "Translate Left") {
			for (int i=0;i<3;i++) {
				x[i]-=10;
		 }
		 getGraphics().fillPolygon(x,y,3);
		}
		
		else if (command == "Reflect X") {
			for (int i=0;i<3;i++) {
				y[i]=getHeight()-y[i];
		 }
		 getGraphics().fillPolygon(x,y,3);
		}
		
		else if (command == "Reflect Y") {
			for (int i=0;i<3;i++) {
				x[i]=getWidth()-x[i];
		 }
		 getGraphics().fillPolygon(x,y,3);
		}
		
		else if (command == "Set Default") {
			int[] x = {500,700,600};
			int[] y = {300,300,100};
			for (int i=0;i<3;i++) {
				this.x[i]=x[i];
				this.y[i]=y[i];				
		 }
			getGraphics().fillPolygon(x,y,3);
		}
		
	}	
}