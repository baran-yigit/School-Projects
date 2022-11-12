//Baran Yigit 201711071
package lab5;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;

public class Gradient extends Frame {
	
//Constructor
public Gradient() {
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
}

public void paint(Graphics g)
{
	 Graphics2D g2d = (Graphics2D)g;
	 Color s1 = Color.magenta;
	 Color e = Color.CYAN;
	 GradientPaint gradient = new GradientPaint(50,75,s1,200,225,e,false);
	 g2d.setPaint(gradient);
	 g2d.drawRect(50,75,300,300);
	 g2d.fillRect(50,75,300,300);
	 
	 Graphics2D g3d = (Graphics2D)g;
	 //Rectangle2D.Double rect = new Rectangle2D.Double(400, 75, this.getWidth(), this.getHeight());
	 int width = this.getWidth()/2;
	 int height = this.getHeight()/2;
	 Rectangle2D.Double rect = new Rectangle2D.Double(400,75,300,300);

	 g3d.setPaint(new GradientPaint(400,274,Color.LIGHT_GRAY,400,300,Color.DARK_GRAY,true));
	 g3d.fill(rect);
	 g3d.draw(rect);
	 System.out.println(this.getWidth()/2);
	 System.out.println(height);
}

public static void main(String[] args) {
	Gradient gr = new Gradient();
	gr.setTitle("Colour gradient");
	gr.setSize(768, 512);
	gr.setVisible(true);
}

}

