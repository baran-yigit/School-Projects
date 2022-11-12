//Baran Yigit 201711071
//In development phase
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.GeneralPath;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Animation {

    private int x;
    private int y;
    private boolean positiveX;
    private boolean positiveY;
    private boolean isTimerRunning;
    private int speedValue;
    private int diameter;
    private DrawingArea drawingArea;
    Timer timer;
    private Queue<Color> clut = new LinkedList<Color>(Arrays.asList(
        Color.BLUE.darker(),
        Color.MAGENTA.darker(),
        Color.BLACK,
        Color.orange.darker(),
        Color.PINK,
        Color.CYAN.darker(),
        Color.DARK_GRAY,
        Color.YELLOW.darker(),
        Color.white.darker()));
    private Color backgroundColour;
    private Color foregroundColour;
    private double scale = 1;
    private double delta = 0.01;

    private ActionListener timerAction = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            x = getX();
            y = getY();

            drawingArea.setXYColourValues(x, y, backgroundColour, foregroundColour);
            if ( scale < 0.01 ) {
                delta = -delta;

            } 
            else if (scale > 0.99) {
                delta = -delta;
            }
            scale += delta;
        }
    };
    private JPanel buttonPanel;
    
    private JButton startStopButton;
    private JButton colourButton;
    
    private ComponentAdapter componentAdapter = new ComponentAdapter() {

        @Override
        public void componentResized(ComponentEvent ce) {
            timer.restart();
            startStopButton.setText("Stop");
            isTimerRunning = true;
        }
    };

    public Animation() {
        x = y = 0;
        positiveX = positiveY = true;
        speedValue = 1;
        isTimerRunning = true;
        diameter = 50;
        backgroundColour = Color.white;
        foregroundColour = clut.peek();
        timer = new Timer(10, timerAction);
        timer.setInitialDelay(190);
        timer.start();
    }

    private void createAndDisplayGUI() {
        JFrame frame = new JFrame("Ball Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        drawingArea = new DrawingArea(x, y, backgroundColour, foregroundColour, diameter);
        drawingArea.addComponentListener(componentAdapter);

        frame.add(makeButtonPanel(), BorderLayout.LINE_END);
        frame.add(drawingArea, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel makeButtonPanel() {
        buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));

        startStopButton = new JButton("Start");
        startStopButton.setOpaque(true);
        startStopButton.setForeground(Color.white);
        startStopButton.setBackground(Color.red.darker());
        startStopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!isTimerRunning) {
                	startStopButton.setBackground(Color.red.darker());
                    startStopButton.setText("Stop");                  
                    timer.start();
                    isTimerRunning = true;
                } else if (isTimerRunning) {
                    startStopButton.setBackground(Color.green.darker());
                    startStopButton.setText("Start");
                    timer.stop();
                    isTimerRunning = false;
                }
            }
        });
        startStopButton.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        buttonPanel.add(startStopButton);

        colourButton = new JButton("Change Color");
        colourButton.setOpaque(true);
        colourButton.setForeground(Color.cyan);
        colourButton.setBackground(clut.peek());
        colourButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            	if (!isTimerRunning) {
                	startStopButton.setBackground(Color.green.darker());
                    startStopButton.setText("Start");                  
                    timer.stop();
                    isTimerRunning = false;
                }
            	else if (isTimerRunning) {
            		startStopButton.setBackground(Color.red.darker());
            		startStopButton.setText("Stop");
            		timer.start();
            		isTimerRunning = true;
            	}
                //timer.restart();
                clut.add(clut.remove());
                foregroundColour = clut.peek();
                drawingArea.setXYColourValues(x, y, backgroundColour, foregroundColour);
                colourButton.setBackground(foregroundColour);
            }
        });
        colourButton.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        buttonPanel.add(colourButton);

        return buttonPanel;
    }

    private int getX() {
        if (x < 0) {
            positiveX = true;
        } else if (x >= drawingArea.getWidth() - diameter) {
            positiveX = false;
        }
        return (calculateX());
    }

    private int calculateX() {
        if (positiveX) {
            return (x += speedValue);
        } else {
            return (x -= speedValue);
        }
    }

    private int getY() {
        if (y < 0) {
            positiveY = true;
        } else if (y >= drawingArea.getHeight() - diameter) {
            positiveY = false;
        }
        return (calculateY());
    }

    private int calculateY() {
        if (positiveY) {
            return (y += speedValue);
        } else {
            return (y -= speedValue);
        }
    }

    public static void main(String... args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                new Animation().createAndDisplayGUI();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}

class DrawingArea extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
    private int y;
    private int ballDiameter;
    private Color backgroundColor;
    private Color foregroundColor;
    private double scale = 1;
    private double delta = 0.01;
    private double angle = 0;
    
	private final double points[][] = {
	        { 0, 85 }, { 75, 75 }, { 100, 10 }, { 125, 75 },
	        { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 },
	        { 40, 190 }, { 50, 125 }, { 0, 85 }
	    };
    Timer timer;

    public DrawingArea() {
        timer = new Timer(10, this);
        timer.setInitialDelay(190);
        timer.start();
    }
    
    public DrawingArea(int x, int y, Color bColor, Color fColor, int dia) {
        this.x = x;
        this.y = y;
        ballDiameter = dia;
        backgroundColor = bColor;
        foregroundColor = fColor;
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }

    public void setXYColourValues(int x, int y, Color bColor, Color fColor) {
        this.x = x;
        this.y = y;
        backgroundColor = bColor;
        foregroundColor = fColor;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(500, 400));
    }

    @Override
    public void paint(Graphics g) {
    	super.paint(g);
        int h = getHeight();
        int w = getWidth();
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(backgroundColor);
        g.fillRect(0, 0, w, h);
        g.setColor(foregroundColor);
        
        for(int t=1;t<15;t++) {
        	g2d.fillRect(x+t+150, y+t, ballDiameter/2, ballDiameter/2);
            g2d.fillOval(x+20+t, y+t, ballDiameter/2, ballDiameter/2);
            g.fillOval(x+30+t, y+15+t, ballDiameter, ballDiameter);
            g2d.fillOval(x+60+t, y-2+t, ballDiameter/2, ballDiameter/2);
            g.fillRect(x+70+t, y+70+t, ballDiameter/2, ballDiameter/2);
            g2d.fillRect(x+80+t, y+80+t, ballDiameter/4, ballDiameter/4);
            g.fillRect(x+90+t, y+90+t, ballDiameter/8, ballDiameter/8);
            g2d.fillOval(x+70+t, y+t, ballDiameter/2, ballDiameter/2);
            g.fillOval(x+80+t, y+15+t, ballDiameter, ballDiameter);
            g2d.fillOval(x+110+t, y-2+t, ballDiameter/2, ballDiameter/2);
            g.fillRect(x+120+t, y+120+t, ballDiameter/2, ballDiameter/2);
            g2d.fillRect(x+130+t, y+130+t, ballDiameter/4, ballDiameter/4);
            g.fillRect(x+140+t, y+140+t, ballDiameter/8, ballDiameter/8);
            g2d.fill3DRect(x+150+t, y+150+t, ballDiameter, ballDiameter, getFocusTraversalKeysEnabled());
            g2d.scale(0.8, 1.5);
            g2d.rotate(t < 5 ? 0.01 : 0.02);
            g2d.translate(h/128, w/128);
            g2d.setColor(Color.green.darker());
        }

        Color c1 = new Color(0.2f,0.5f,0.9f);
        Color c2 = new Color(0.3f,0.6f,0.4f);

 		GradientPaint gradPaint1 = new GradientPaint(0,150,c1,this.getHeight(),250,c2,false);
 		
 		g2d.setPaint(gradPaint1);
 		
 		//g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
 		
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.translate(h/8, w/8);
 		
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][1]);

        star.closePath();
        g2d.scale(scale, scale);
        g2d.rotate(angle);
        g2d.setColor(Color.yellow);
        g2d.fill(star);
    }
    
    public void actionPerformed(ActionEvent ae) {

        if ( scale < 0.01 ) {
            delta = -delta;
        } 
        else if (scale > 0.99) {
            delta = -delta;
        }
        angle += 0.01;
        scale += delta;
        repaint();
    }
}