package nmfc.clients;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class ImgUtils {

    public BufferedImage scaleImage(int WIDTH, int HEIGHT, URL url) {
        BufferedImage bi = null;
        try {
            ImageIcon ii = new ImageIcon(url);//path to image
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bi;
    }
}

class RoundedJTextField extends JTextField {
	
	private Shape shape;
	public RoundedJTextField(int size) {
		super(size);
		setOpaque(false);
	}
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 35);
		super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 35);
	}
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 35, 35);
		}
	return shape.contains(x, y);
    }
}

class Toast extends JFrame {
	
	String s;
	JWindow w;
	Toast(String s, int x, int y,int size1,int size2)
	{
		w = new JWindow();
		w.setBackground(new Color(133,254,161,100));
		JLabel p = new JLabel();

		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.setFont(new Font("Verdana",Font.BOLD,18));
		p.setText(s);
		p.setBackground(new Color(133,254,161,90));
		p.setForeground(new Color(0,0,0));
		w.setLayout(new FlowLayout(FlowLayout.CENTER));
		w.add(p);
		w.setLocation(x, y);
		w.setSize(size1,size2);
	}

	// function to pop up the toast
	void showtoast()
	{
		try {
			w.setOpacity(1);
			w.setVisible(true);
			Thread.sleep(2000);
			for (double d = 1.0; d > 0.2; d -= 0.1) {
				Thread.sleep(100);
				w.setOpacity((float)d);
			}
			w.setVisible(false);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}