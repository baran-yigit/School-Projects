//Baran Yigit 201711071
package lab8;
import java.awt.*;
import java.awt.event.*;

public class Rotations extends Frame implements ActionListener {
 /**
	 * 
	 */
	private static final long serialVersionUID = 518435818434146416L;
	
	// Initializing coordinates of the rectangle
	int[] x = {500,700,700,500}; 
 	int[] y = {300,300,200,200};

 	public static void main(String[] args) {
 		// Setting frame size to (800x800)
 		// Setting background color
 		// Setting visibility
		Rotations f = new Rotations();
		f.setSize(800, 800);
		f.setTitle("Rotations");
		f.setVisible(true);
		f.setBackground(Color.getHSBColor(0.3f, 0.4f, 0.5f));		
 	}
 
	public class MyFinishWindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public Rotations() {
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
	   
		Button lbcw = new Button();
	    lbcw.setLabel("Left Bottom - Clockwise");
		lbcw.addActionListener(this);
		
		Button orgcw = new Button();
		orgcw.setLabel("Origin - Clockwise");
		orgcw.addActionListener(this);
		
		Button orgccw = new Button();
	    orgccw.setLabel("Origin - C.Clockwise");
		orgccw.addActionListener(this);
		
		p.add(lbcw);
		p.add(orgcw);
		p.add(orgccw);
	    
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
		
		if (command == "Left Bottom - Clockwise" ) {
			int temp;
			int height,width;
			width = ((int) Math.abs((x[2] - x[0])));  
			height= ((int) Math.abs((y[2] - y[0])));
			temp=width;
			width=height;
			height=temp;
			for (int i=0;i<x.length && i<y.length;i++) {
				//--------->In development process<------------
		        y[(i%4+1)%4] = y[(i%4)%4] - (((i-1)%2)*height);
		        x[(i%4+1)%4] = x[(i%4)%4] + (((2-i)%2)*width);
		        //--------->In development process<------------
			}
			getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Origin - Clockwise") {
			int temp;
			for (int i=0;i<x.length && i<y.length;i++) {
		        temp = - y[(i%4+1)%4]*1;  
		        y[(i%4+1)%4] = x[(i%4+1)%4]*1;
		        x[(i%4+1)%4] = getHeight() + temp;	        
			}
			getGraphics().fillPolygon(x,y,4);
		}
		
		else if (command == "Origin - C.Clockwise") {
			int temp;
			for (int i=0;i<x.length && i<y.length;i++) {
		        temp = y[(i%4+1)%4]*(1);  
		        y[(i%4+1)%4] = getHeight() - x[(i%4+1)%4]*(1);
		        x[(i%4+1)%4] = temp;		        
			}
			getGraphics().fillPolygon(x,y,4);	
		}

		else if (command == "Set Default") {
			int[] x = {500,700,700,500}; 
		 	int[] y = {300,300,200,200};
			for (int i=0;i<x.length && i<y.length;i++) {
				this.x[i]=x[i];
				this.y[i]=y[i];				
			}
			getGraphics().fillPolygon(x,y,4);
		}		
	}	
}