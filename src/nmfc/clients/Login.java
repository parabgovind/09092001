package nmfc.clients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import nmfc.entities.Administrator;
import nmfc.services.AdministratorDao;

public class Login {

	int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login l = new Login();
	}

	public Login() {
		JFrame frame = new JFrame();
		URL iconURL = getClass().getResource("/slogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        
        final BufferedImage img = new ImgUtils().scaleImage(frame.getWidth(), frame.getHeight(), getClass().getResource("/LMFBG.jpg"));
        JLabel bg = new JLabel(new ImageIcon(img));
		
		JLabel label = new JLabel();
	    label.setSize(1000,600);
		label.setLayout(new GridLayout());
		label.setBounds(frame.getWidth()/2-label.getWidth()/2, frame.getHeight()/2-label.getHeight()/2, label.getWidth(),label.getHeight());
		
		
		//left side
		JLabel l1 = new javax.swing.JLabel() {
	        protected void paintComponent(Graphics g) {
	           if (g instanceof Graphics2D) {        
	              Paint p = new GradientPaint(0.0f, 0.0f, new Color(133,254,161,100), getWidth(), getHeight(), new Color(2,59,31,100), true);
	              Graphics2D g2d = (Graphics2D)g;
	              g2d.setPaint(p);
	              g2d.fillRect(0, 0, getWidth(), getHeight());
	              g2d.drawRect(0, 0, getWidth(), getHeight());
	           } else { super.paintComponent(g); }
	           }
	        };
	     l1.setSize(700,600);
	     l1.setBounds(0, 0, l1.getWidth(),l1.getHeight());
		 l1.setLayout(new BorderLayout());
		
		JLabel sSays21 = new JLabel("Great to have you back!");
		sSays21.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		sSays21.setBackground(new Color(0,0,0,0));
		
		
		// set panels
		JPanel lablly = new JPanel(new FlowLayout());
		
		JPanel selly	= new JPanel(new FlowLayout(FlowLayout.CENTER, 180, 30));
		
		lablly.setBackground(new Color(0,0,0,0));
		selly.setBackground(new Color(0,0,0,0)); 
		lablly.add(sSays21);
				
		l1.add(lablly,BorderLayout.NORTH);
		
		l1.add(selly,BorderLayout.CENTER);
		
		JLabel pick = new JLabel(new ImageIcon(this.getClass().getResource("/LHOLO.png")));
		l1.add(pick);
		
		//right side
		JLabel l2 = new javax.swing.JLabel() {
	        protected void paintComponent(Graphics g) {
	           if (g instanceof Graphics2D) {        
	              Paint p = new GradientPaint(0.0f, 0.0f, new Color(133,254,161,100), getWidth(), getHeight(), new Color(2,59,31,100), true);
	              Graphics2D g2d = (Graphics2D)g;
	              g2d.setPaint(p);
	              g2d.fillRect(0, 0, getWidth(), getHeight());
	              g2d.drawRect(0, 0, getWidth(), getHeight());
	           } else { super.paintComponent(g); }
	           }
	        };
		l2.setSize(300,600);
		l2.setBounds(l1.getWidth(), 0, l2.getWidth(),l2.getHeight());
		l2.setLayout(new BorderLayout());
		
		JLabel sSays = new JLabel("Welcome!");
		sSays.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		sSays.setBackground(new Color(0,0,0,0));
		
		JLabel sSays1 = new JLabel("User Login");
		sSays1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		sSays1.setBackground(new Color(0,0,0,0));
		
		JLabel entr2 = new JLabel(new ImageIcon(this.getClass().getResource("/studentsearch.png")));		
		JLabel hint1 = new JLabel("Username");
		hint1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		hint1.setBackground(new Color(0,0,0,0));
		l2.add(hint1);
		
		JTextField htf1 = new JTextField(15);
		htf1.setFont(new Font(Font.DIALOG, 1, 25));
		htf1.setHorizontalAlignment(JTextField.CENTER);
		htf1.setForeground(Color.decode("#000000"));
		htf1.setBackground(new Color(239,238,238));
		htf1.setBorder(null);
		
		JLabel hint2 = new JLabel("Password");
		hint2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		hint2.setBackground(new Color(0,0,0,0));
		l2.add(hint2);
		
		JPasswordField htf2 = new JPasswordField(12);
		htf2.setFont(new Font("Verdana", 1, 25));
		htf2.setHorizontalAlignment(JTextField.CENTER);
		htf2.setForeground(Color.decode("#000000"));
		htf2.setBackground(new Color(239,238,238));
		htf2.setBorder(null);

		JLabel jcb = new JLabel("View Password");
		jcb.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		jcb.setBackground(new Color(0,0,0,0));
		count = 1;
		jcb.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(count==1) {
				    htf2.setEchoChar('\u0000');
				    count++;
				}else {
					count--;
				    htf2.setEchoChar((Character)          UIManager.get("PasswordField.echoChar"));
				    }
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		JLabel Jbt = new JLabel();
		Jbt.setText("Login");
		Jbt.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		Jbt.setBackground(new Color(0,0,0,0));
		
		
		Jbt.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String name = htf1.getText().toString();
				String password = htf2.getText().toString();
				Administrator admin = new Administrator();
				AdministratorDao admindao = new AdministratorDao();
				try {
					admin  = admindao.findAdministratorByName(name);
					String admin_name = admin.getAdministrator_name();
					String admin_password = admin.getAdministrator_password();
					if(admin_name.equals(name)) {
						if(admin_password.equals(password)) {
							AdminPanel ap = new AdminPanel();
							String s = new String("Login Successful<br>You have successfully signed into administrator panel.<br>You can continue using the services.");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-300, frame.getHeight()/2-45,600,90);
					        t.showtoast();
					        frame.setState(JFrame.ICONIFIED);
						}
						else {
							String s = new String("Login Failed<br>Please Enter Valid Credentials!");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
					        t.showtoast();
						}
					}
					else {
						String s = new String("Login Failed<br>Please Enter Valid Credentials!");
						Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
				        t.showtoast();
					}
				}catch(Exception e2) {
					String s = new String("Login Failed<br>Please Enter Valid Credentials!");
					Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
			        t.showtoast();
				}
		        
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		JLabel Jbt1 = new JLabel();
		Jbt1.setText("Exit");
		Jbt1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		Jbt1.setBackground(new Color(0,0,0,0));
		
		Jbt1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
			}
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		// set panels
		JPanel labl = new JPanel(new FlowLayout());
		
		JPanel sel	= new JPanel(new FlowLayout(FlowLayout.CENTER, 180, 20));
		
		labl.setBackground(new Color(0,0,0,0));
		sel.setBackground(new Color(0,0,0,0)); 
		labl.add(sSays);
		sel.add(sSays1);
		sel.add(entr2);
		sel.add(hint1);
		sel.add(htf1);
		sel.add(hint2);
		sel.add(htf2);
		sel.add(jcb);
		sel.add(Jbt);
		sel.add(Jbt1);
		
		l2.add(labl,BorderLayout.NORTH);
		
		l2.add(sel,BorderLayout.CENTER);
		
		
		
		label.add(l1);
		label.add(l2);
		
		bg.add(label);
		
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().add(bg, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}