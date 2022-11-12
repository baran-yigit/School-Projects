//Baran Yigit 201711071
package lab3;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class AWTDemo extends Frame implements ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3261933447164501758L;
	int x = 100;
	int y = 100;
	private List<Point2D> points;
	
	public AWTDemo() {
		points = new ArrayList<Point2D>();
		addWindowListener(new MyFinishWindow());
		addMouseListener(this);

	}
	
	public class MyFinishWindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new AWTDemo(1); // This method draws 2 ovals.
		new AWTDemo(2); // This method has a menu and moves given 2 ovals.
	}

	//Two types of constructors selected by the integer passed
	//First one is for Lab3A second one is for Lab 3B
	public AWTDemo(int a) {
		
		if(a == 1 ) {
			AWTDemo h= new AWTDemo();
			h.setTitle("Lab 3A");
			h.setSize(500, 500);
			h.setVisible(true);
			h.getGraphics().drawOval(50, 50, 100, 100);
			h.getGraphics().drawOval(100, 100, 300, 300);			
	}
	
		else if (a == 2) {
		AWTDemo k= new AWTDemo();
		k.setTitle("Lab 3B");
			MenuBar menu_bar = new MenuBar();
			Menu menu = new Menu("File");
			MenuItem exit = new MenuItem("Exit");
			menu.add(exit);
			exit.addActionListener(this);
			menu_bar.add(menu);
			k.setMenuBar(menu_bar);
			k.addWindowListener(new MyFinishWindow());
			k.setSize(500, 500);
			k.setVisible(true);
			k.getGraphics().drawOval(x-50, y-50, x, y);
			k.getGraphics().drawOval(x, y, x*3, y*3);
			// create menu
			// end program when window is closed
			// mouse event handler	
	}
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x+ "," + y);
		// TODO Auto-generated method stub
		if(points.size() >= 1)  {			
			points.remove(0);
		}
		points.add(new Point2D.Float(x, y));
		System.out.println(x + "," + y);
		repaint();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//System.out.println(points.size());
		for(Point2D point : points) {
			g2d.drawOval((int) point.getX() , (int) point.getY() , 100, 100);
			g2d.drawOval((int) point.getX() + 50, (int) point.getY() + 50, 300, 300);
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if(str.equals("Exit")) {
			System.exit(0);
		}		
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
