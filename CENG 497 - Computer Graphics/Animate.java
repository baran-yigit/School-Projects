import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animate extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -678868650418457730L;

	private final double points[][] = {
        { 0, 85 }, { 75, 75 }, { 100, 10 }, { 125, 75 },
        { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 },
        { 40, 190 }, { 50, 125 }, { 0, 85 }
    };

    Timer timer;
    
    private double scale = 1;
    private double delta = 0.01;

    public Animate() {
        timer = new Timer(10, this);
        timer.setInitialDelay(190);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        int h = getHeight();
        int w = getWidth();

        Graphics2D g2d = (Graphics2D)g;

        Color c1 = new Color(0.2f,0.5f,0.9f);
        Color c2 = new Color(0.3f,0.6f,0.4f);

 		GradientPaint gradPaint1 = new GradientPaint(0,150,c1,this.getHeight(),250,c2,false);
 		
 		g2d.setPaint(gradPaint1);

  		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
 		
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.translate(h/8, w/8);
        
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][1]);

        star.closePath();
        g2d.scale(scale, scale);
        g2d.setColor(Color.yellow);
        g2d.fill(star);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Star");
        frame.add(new Animate());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if ( scale < 0.01 ) {
            delta = -delta;
        } 
        else if (scale > 0.99) {
            delta = -delta;
        }

        scale += delta;
        repaint();
    }
}