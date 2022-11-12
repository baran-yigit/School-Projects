//Baran Yigit 201711071
package lab4;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Mickey extends Frame implements ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 250;
	int y = 300;
	int dx = 300;
	int dy = 300;
	private List<Point2D> points;
	
	public class MyFinishWindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Mickey();
		
	}
	
	public Mickey() {
		points = new ArrayList<Point2D>();
		setTitle("Mickey");
		MenuBar mb = new MenuBar();	
		
		Menu m = new Menu("File");
		m.add(new MenuItem("Set Default"));
		m.addActionListener(this);
		mb.add(m);
		setMenuBar(mb);	
		
	    Panel p=new Panel();  
	    p.setBounds(0,40,800,50);  	    
	    p.setBackground(Color.BLACK); 
	    
		add(p);	    
		p.setBackground(Color.black);
	    Button small = new Button();
	    small.setLabel("Smaller");
		small.addActionListener(this);
		Button big = new Button();
		
		setLayout(null);
		addWindowListener(new MyFinishWindow());

		big.addActionListener(this);
		big.setLabel("Bigger");

		p.add(small);
		p.add(big);
	    addMouseListener(this);
	    
		setSize(800,800);
		setLayout(new GridLayout(10,3));
		setVisible(true);
		setBackground(Color.RED);
		
		getGraphics().drawOval(x, y, dx, dy);
		getGraphics().drawOval(x-50, y-100, (dx/2), (dy/2));
		getGraphics().drawOval(x+200, y-100, (dx/2), (dy/2));
		
		getGraphics().fillOval(x, y, dx, dy);
		getGraphics().fillOval(x-50, y-100, (dx/2), (dy/2));
		getGraphics().fillOval(x+200, y-100, (dx/2), (dy/2));
	}
	
	public void paint(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		//System.out.println(points.size());

		for(Point2D point : points) {
		g1.drawOval((int) point.getX() , (int) point.getY() , dx, dy);
		g1.drawOval((int) point.getX()  -50, (int) point.getY() -100, dx/2, dy/2);
		g1.drawOval((int) point.getX() + 200, (int) point.getY() -100 , dx/2, dy/2);
		g1.fillOval((int) point.getX(), (int) point.getY(), dx, dy);
		g1.fillOval((int) point.getX()-50, (int) point.getY()-100, dx/2, dy/2);
		g1.fillOval((int) point.getX()+200, (int) point.getY()-100, dx/2, dy/2);		
		g1.setColor(Color.black);		
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		repaint();
		if (command == "Smaller") {
			dx/=2;
			dy/=2;
			points.add(new Point2D.Float(x, y));
			//System.out.println(points);
			points.remove(0);
			//System.out.println(points.size());
			update(getGraphics());
			repaint();			
		}

		else if (command == "Bigger") {
			dx*=2;
			dy*=2;
			points.add(new Point2D.Float(x, y));
			points.remove(0);
			update(getGraphics());
			}
					
		else if (command == "Set Default") {
			dx=300;
			dy=300;
			x=250;
			y=300;
			points.add(new Point2D.Float(x, y));
			points.remove(0);
			update(getGraphics());
			repaint();	
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		//System.out.println(x+ "," + y);
		if(points.size() >= 1)  {			
			points.remove(0);
		}
		points.add(new Point2D.Float(x, y));
		System.out.println(x + "," + y);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
