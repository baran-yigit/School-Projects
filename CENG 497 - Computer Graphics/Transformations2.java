//Baran Yigit 201711071
import java.awt.*;
import java.awt.event.*;

public class Transformations2 extends Frame implements ActionListener {
 /**
	 * 
	 */
	private static final long serialVersionUID = 518435818434146416L;
	
	// Initializing coordinates of the rectangle
	 int[] x = {400,600,600,400};
	 int[] y = {400,400,200,200}; 

 	public static void main(String[] args) {
 		// Setting frame size to (800x800)
 		// Setting background color
 		// Setting visibility
		Transformations2 f = new Transformations2();
		f.setSize(800, 800);
		f.setTitle("Transformations2");
		f.setVisible(true);
		f.setBackground(Color.getHSBColor(0.3f, 0.4f, 0.5f));		
 	}
 
	public class MyFinishWindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public Transformations2() {
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
	   
		Button shrx = new Button();
	    shrx.setLabel("Shear in X");
		shrx.addActionListener(this);
		
		Button shry = new Button();
		shry.setLabel("Shear in Y");
		shry.addActionListener(this);
		
		Button strx = new Button();
		strx.setLabel("Stretch in X");
		strx.addActionListener(this);
		
		Button stry = new Button();
		stry.setLabel("Stretch in Y");
		stry.addActionListener(this);
		
		Button sclu = new Button();
		sclu.setLabel("Scale Up");
		sclu.addActionListener(this);
		
		Button scld = new Button();
		scld.setLabel("Scale Down");
		scld.addActionListener(this);
		
		p.add(shrx);
		p.add(shry);
		p.add(strx);
		p.add(stry);
		p.add(sclu);
		p.add(scld);
	    
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
 
	// Draw 2 lines and paint 1 filled rectangle
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int width = this.getWidth();
		int height = this.getHeight();
	
		g2d.drawLine(width/2, 0, width/2, height);
		g2d.drawLine(0, height/2, width, height/2);
		g2d.fillPolygon(x,y,4);
	}
 
	// Action listener
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		repaint();
		
		if (command == "Shear in X") {
			for (int i=2;i<4;i++) {
				x[i]*=1.01;
		 }
			getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Shear in Y") {
			for (int i=1;i<3;i++) {
				y[i]/=1.01;
		 }
		 getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Stretch in X") {
			for (int i=1;i<3;i++) {
				x[i]+=10;
		 }
		 getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Stretch in Y") {
			for (int i=2;i<4;i++) {
				y[i]-=10;
		 }
		 getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Scale Up") {
			for (int i=1;i<3;i++) {
				x[i]+=10;
		 }
			for (int i=2;i<4;i++) {
				y[i]-=10;
		 }
		 getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Scale Down") {
			for (int i=1;i<3;i++) {
				x[i]-=10;
		 }
			for (int i=2;i<4;i++) {
				y[i]+=10;
		 }
		 getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Set Default") {
			 int[] x = {400,600,600,400};
			 int[] y = {400,400,200,200};
			for (int i=0;i<4;i++) {
				this.x[i]=x[i];
				this.y[i]=y[i];				
		 }
			getGraphics().fillPolygon(x,y,4);
		}		
	}	
}