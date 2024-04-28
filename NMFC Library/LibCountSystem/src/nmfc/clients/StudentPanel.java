package nmfc.clients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import nmfc.entities.Students;
import nmfc.entities.Visitors;
import nmfc.services.StudentDaoImpl;
import nmfc.services.VisitorsDaoImpl;

public class StudentPanel {
	
	JLabel l111;
	JWindow win;
	String a = "";
	int thres = 0;
	final JTextField tf;
	static JPanel mainPanel;
    private static Point point = new Point();
    private JFrame frame09;
	JFrame frame;
	static VisitorsDaoImpl visitor_service = new VisitorsDaoImpl(); 	
	static StudentDaoImpl student_service = new StudentDaoImpl();
	
	public static void main(String[] args) throws Exception{
		StudentPanel sp = new StudentPanel();
        Robot hal = new Robot();
        Random random = new Random();
        while(true){
            hal.delay(1000 * 60);
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
            hal.mouseMove(x,y);
        }
		}
	public StudentPanel() {
		
		frame = new JFrame();
		URL iconURL = getClass().getResource("/slogo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
        
        final BufferedImage img = new ImgUtils().scaleImage(frame.getWidth(), frame.getHeight(), getClass().getResource("/scam.jpg"));        
        //add components here
        mainPanel = new JPanel() {
        	protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
            	g.drawImage(img, 0, 0, mainPanel);
            }
        };
	    JLabel entr1 = new JLabel();
	    entr1.setText("<html><p style =text-align:center>Scan and Go</p></html>");
	    entr1.setFont(new Font("Verdana", Font.BOLD, 45));
	    entr1.setBackground(new Color(85, 170, 221,100));
	    entr1.setBounds(15, 200, 330, 45);
	    entr1.setHorizontalAlignment(JLabel.CENTER);
	    frame.add(entr1);
	    
        Font font2 = new Font(Font.DIALOG, Font.BOLD, 90);
        l111 = new JLabel("",SwingConstants.CENTER);
        l111.setText(new VisitorsDaoImpl().getStreamCountByTCurrent(LocalDate.now().toString()));
        l111.setFont(font2);
        l111.setForeground(Color.decode("#ad2a1a"));
        l111.setBounds(frame.getWidth()/2/2/2-l111.getPreferredSize().width/2, frame.getHeight()/2-l111.getPreferredSize().height/2, l111.getPreferredSize().width, l111.getPreferredSize().height);
        frame.add(l111);
        
        Font font1 = new Font(Font.DIALOG, Font.BOLD, 45);
        JLabel l1 = new JLabel("Right now",SwingConstants.CENTER);
        l1.setFont(font1);
        l1.setForeground(Color.decode("#093145"));
        l1.setBounds(frame.getWidth()/2/2/2-l1.getPreferredSize().width/2, (frame.getHeight()/2-l111.getPreferredSize().height/2)-l1.getPreferredSize().height, l1.getPreferredSize().width, l1.getPreferredSize().height);
        frame.add(l1);
        
        Font font11 = new Font(Font.DIALOG, Font.BOLD, 30);
        JLabel l11 = new JLabel("visitors in library",SwingConstants.CENTER);
        l11.setFont(font11);
        l11.setForeground(Color.decode("#093145"));
        l11.setBounds(frame.getWidth()/2/2/2-l11.getPreferredSize().width/2, frame.getHeight()/2-l111.getPreferredSize().height/2+l111.getPreferredSize().height, l11.getPreferredSize().width, l11.getPreferredSize().height);
        frame.add(l11);
        JLabel mlogo = new JLabel(new ImageIcon(this.getClass().getResource("/Mlogo.png")));mlogo.setBackground(new Color(0,0,0,0));mlogo.setSize(258,120);mlogo.setOpaque(true);mlogo.setBounds(10,10,(int)mlogo.getWidth(),(int)mlogo.getHeight());frame.add(mlogo);
        
        JLabel login = new JLabel("<html><div style ='text-align:center;'>L<br>O<br>G<br>I<br>N<br></div></html>",SwingConstants.CENTER);
        login.setHorizontalAlignment(JLabel.CENTER);login.setVerticalAlignment(JLabel.CENTER);login.setFont(new Font("Verdana", Font.BOLD, 36));login.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));login.setForeground(Color.decode("#00a4bd"));login.setBounds((int)screenSize.width-login.getPreferredSize().width-30, screenSize.height/2-login.getPreferredSize().height/2 , login.getPreferredSize().width+15, login.getPreferredSize().height+15);
        
        login.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {Login l = new Login();frame.setState(JFrame.ICONIFIED);}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));login.setForeground(new Color(12,117,210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));login.setForeground(Color.decode("#00a4bd"));
			}
        });
        frame.add(login);
        
        tf = new RoundedJTextField(30);tf.setBounds(screenSize.width-210,screenSize.height-60, 200, 40);tf.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));tf.setHorizontalAlignment(JTextField.CENTER);tf.setForeground(Color.decode("#000000"));tf.setBackground(new Color(85, 170, 221,100));
        
        frame09 = new JFrame();
        frame09.setUndecorated(true);
          
        tf.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						Students students = new Students();
		    	    	students = student_service.findStudentByBarcode(tf.getText().toString());
			    	    tf.setText("");
			    	    SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {tf.requestFocus();}});			        
						Visitors visitor = new Visitors();
						visitor.setVisitor_roll_no(students.getStudent_roll_number());
						visitor.setVisitor_seat_number(students.getStudent_seat_number());
						visitor.setVisitor_name(students.getStudent_name());
						visitor.setVisitor_stream(students.getStudent_stream());
						visitor.setVisitor_class(students.getStudent_class());
						visitor.setVisitor_div(students.getStudent_div());
						visitor.setVisitor_library_card_valid_upto(students.getStudent_library_card_valid_upto());
						String date = LocalDate.now().toString();
						visitor.setVisit_date(date);
						String time = LocalTime.now().toString(); 
						visitor.setVisit_time(time);
						//if new user then come
						if(new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number()).size() == 0) {
							visitor.setVisit_status("come");visitor.setTime_spent("0:0:0");
						}
						//if previous status gone then come
						for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorStatusRecordBySeatNumber(students.getStudent_seat_number()).size() ; i++) {
							if(i == new VisitorsDaoImpl().getVisitorStatusRecordBySeatNumber(students.getStudent_seat_number()).size()-1) {
								if(new VisitorsDaoImpl().getVisitorStatusRecordBySeatNumber(students.getStudent_seat_number()).get(i).toString().equalsIgnoreCase("gone")) {
									visitor.setVisit_status("come");visitor.setTime_spent("0:0:0");
								}
							}
						}
						//if date gap then come
						for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorDateRecordBySeatNumber(students.getStudent_seat_number()).size() ; i++) {
							if(i == new VisitorsDaoImpl().getVisitorDateRecordBySeatNumber(students.getStudent_seat_number()).size()-1) {
								if(!new VisitorsDaoImpl().getVisitorDateRecordBySeatNumber(students.getStudent_seat_number()).get(i).toString().equalsIgnoreCase(date)) {
									visitor.setVisit_status("come");visitor.setTime_spent("0:0:0");
								}
							}
						}
						//if no date gap and previous status is come then gone
						for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorDateRecordBySeatNumber(students.getStudent_seat_number()).size() ; i++) {
							if(i == new VisitorsDaoImpl().getVisitorDateRecordBySeatNumber(students.getStudent_seat_number()).size()-1) {
								if(new VisitorsDaoImpl().getVisitorDateRecordBySeatNumber(students.getStudent_seat_number()).get(i).toString().equalsIgnoreCase(date)) {
									if(new VisitorsDaoImpl().getVisitorStatusRecordBySeatNumber(students.getStudent_seat_number()).get(i).toString().equalsIgnoreCase("come")) {
										visitor.setVisit_status("gone");
										
										for(int j = 0 ; j < new VisitorsDaoImpl().getVisitorTimeRecordBySeatNumber(students.getStudent_seat_number()).size() ; j++) {
											if(j == new VisitorsDaoImpl().getVisitorTimeRecordBySeatNumber(students.getStudent_seat_number()).size()-1) {
												String comeTime = new VisitorsDaoImpl().getVisitorTimeRecordBySeatNumber(students.getStudent_seat_number()).get(j).toString();
												SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
												Date t1 = sdf.parse(comeTime);
												Date t2 = sdf.parse(time);
												long diff_milli_sec = Math.abs(t2.getTime()-t1.getTime());
												long diff_hr = (diff_milli_sec/(60*60*1000))%24;
												long diff_min = (diff_milli_sec/(60*1000))%60;
												long diff_sec = (diff_milli_sec/1000)%60;
												visitor.setTime_spent(diff_hr+":"+diff_min+":"+diff_sec);
											}
										}
									}
								}
							}
						}
						visitor_service.addVisitors(visitor);
						l111.setText(new VisitorsDaoImpl().getStreamCountByTCurrent(LocalDate.now().toString()));
						}
					catch(Exception exception) {}
				}
			}});
        frame.add(tf);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}