package nmfc.clients;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.ui.RectangleEdge;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import nmfc.entities.Students;
import nmfc.services.DateLabelFormatter;
import nmfc.services.StudentDaoImpl;
import nmfc.services.VisitorsDaoImpl;

public class StudentDetails {
	UtilDateModel model = new UtilDateModel();
	UtilDateModel model1 = new UtilDateModel();
	UtilDateModel model2 = new UtilDateModel();
	UtilDateModel model3 = new UtilDateModel();
	UtilDateModel model4 = new UtilDateModel();
	UtilDateModel model5 = new UtilDateModel();
	UtilDateModel model6 = new UtilDateModel();
	UtilDateModel model7 = new UtilDateModel();
	UtilDateModel model8 = new UtilDateModel();
	UtilDateModel model9 = new UtilDateModel();
	UtilDateModel model10 = new UtilDateModel();
	UtilDateModel model11 = new UtilDateModel();
	UtilDateModel model12 = new UtilDateModel();
	UtilDateModel model13 = new UtilDateModel();
	UtilDateModel model14 = new UtilDateModel();
	UtilDateModel model15 = new UtilDateModel();
	Document document;
	boolean newPage = false;
	String name;
	ByteArrayOutputStream baos;
	JButton pdf;
	boolean hope = true;
	JButton add2,add3,add4,add5,add6,add7,add8,add9;
	JButton inout;
	int max2,max3,max4,max5,max6,max7,max8;
	JFreeChart chart2,chart3,chart4,chart5,chart6,chart7,chart8;
	JButton Download;
	static long hr, min, sec = 0;
	static VisitorsDaoImpl visitor_service = new VisitorsDaoImpl(); 	
	static StudentDaoImpl student_service = new StudentDaoImpl();
	JPanel pLabel10;
	JPanel pLabel1;
	JPanel pLabel2;
	JPanel pLabel3;
	JPanel pLabel4;
	JPanel pLabel5;
	JPanel pLabel6;
	JPanel pLabel7;
	JPanel pLabel8;
	JPanel pLabel9;
	JScrollBar scroller2,scroller3,scroller4,scroller5,scroller6,scroller7,scroller8;
	SlidingCategoryDataset dataset2;
	SlidingCategoryDataset dataset3;
	SlidingCategoryDataset dataset4;
	SlidingCategoryDataset dataset5;
	SlidingCategoryDataset dataset6;
	SlidingCategoryDataset dataset7;
	SlidingCategoryDataset dataset8;

	public static void main(String args[]) throws Exception{
		StudentDetails ap = new StudentDetails();   	
	}

	public StudentDetails() {
		JFrame frame = new JFrame();
		frame.setState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(Color.white);
		URL iconURL = getClass().getResource("/slogo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Rectangle win = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		frame.setSize(win.width,win.height);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		//add components here                
		JPanel panel1 = new JPanel();

		pLabel1 = new JPanel(new GridBagLayout());
		pLabel1.setPreferredSize(new Dimension(312,390));
		pLabel1.setBackground(new Color(254,254,254));
		pLabel1.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));



		JPanel field = new JPanel(new FlowLayout());
		field.setPreferredSize(new Dimension(300,30));
		field.setBackground(new Color(254,254,254));
		field.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		UtilDateModel model01 = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model01);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setPreferredSize(new Dimension(120,20));
		UtilDateModel model02 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model02);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.setPreferredSize(new Dimension(120,20));

		field.add(datePicker);
		field.add(datePicker1);
		pLabel1.add(field,gbc);
		final JTextField tf = new JTextField(15);
		tf.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setForeground(Color.decode("#000000"));
		tf.setBackground(new Color(245,200,250));
		tf.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));

		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						model = new UtilDateModel();
						model1 = new UtilDateModel();
						model2 = new UtilDateModel();
						model3 = new UtilDateModel();
						model4 = new UtilDateModel();
						model5 = new UtilDateModel();
						model6 = new UtilDateModel();
						model7 = new UtilDateModel();
						model8 = new UtilDateModel();
						model9 = new UtilDateModel();
						model10 = new UtilDateModel();
						model11 = new UtilDateModel();
						model12 = new UtilDateModel();
						model13 = new UtilDateModel();
						model14 = new UtilDateModel();
						model15 = new UtilDateModel();

						pLabel1.removeAll();
						pLabel2.removeAll();
						pLabel3.removeAll();
						pLabel4.removeAll();
						pLabel5.removeAll();
						pLabel6.removeAll();
						pLabel7.removeAll();
						pLabel8.removeAll();
						pLabel9.removeAll();
						pLabel10.removeAll();
						frame.remove(pLabel1);
						frame.remove(pLabel2);
						frame.remove(pLabel3);
						frame.remove(pLabel4);
						frame.remove(pLabel5);
						frame.remove(pLabel6);
						frame.remove(pLabel7);
						frame.remove(pLabel8);
						frame.remove(pLabel9);
						frame.remove(pLabel10);
						GridBagConstraints gbc = new GridBagConstraints();
						gbc.weightx = 1.0;
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridwidth = GridBagConstraints.REMAINDER;
						Students students = new Students();
						students = student_service.findStudentByBarcode(tf.getText().toString());
						String count;
						try {
							if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
								for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number()).size() ; i++) {
									String str = new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number()).get(i).toString();
									addTime(str);
								}
								hr = hr + (min / 60);
								min = min % 60;
								count = new VisitorsDaoImpl().getParticularVisitorCountBYCome(students.getStudent_seat_number()).toString();
							}
							else {
								for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size() ; i++) {
									String str = new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i).toString();
									addTime(str);
								}
								hr = hr + (min / 60);
								min = min % 60;
								count = new VisitorsDaoImpl().getParticularVisitorCountBYCome(students.getStudent_seat_number(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).toString();
							}
						}catch(Exception e1) {
							for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size() ; i++) {
								String str = new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(students.getStudent_seat_number(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i).toString();
								addTime(str);
							}
							hr = hr + (min / 60);
							min = min % 60;
							count = new VisitorsDaoImpl().getParticularVisitorCountBYCome(students.getStudent_seat_number(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).toString();
						}
						JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
						JLabel details = new JLabel();
						details.setText("<html><pre>Student Name : <br>"+students.getStudent_name()+"<br>"
								+ "Student Stream : <br>"+students.getStudent_stream()+"<br>"
								+ "Student Class : <br>"+students.getStudent_class()+"<br>"
								+ "Student Division : <br>"+students.getStudent_div()+"<br>"
								+ "Student UID : <br>"+students.getStudent_seat_number()+"<br>"
								+ "Total Number Of Times visited : <br>"+count+"<br>"
								+ "Total Time Spent : <br>" + hr + " Hours " + min + " Minutes " + sec + " Seconds"+"<br></pre></html>");

						hr = min = sec =0;
						details.setHorizontalAlignment(JLabel.CENTER);
						pLabel1.add(field,gbc);
						pLabel1.add(tf,gbc);
						pLabel1.add(details,gbc);
						pLabel10.show();
						createpLabel2(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel3(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel4(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel5(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel6(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel7(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel8(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel9(students.getStudent_seat_number(),frame,datePicker,datePicker1);
						createpLabel10(students.getStudent_seat_number());
						frame.revalidate();
						frame.repaint();
						w.setVisible(false);

					}catch(Exception exception) {
						pLabel1.removeAll();
						frame.remove(pLabel1);
						JLabel details = new JLabel();
						details.setText("");
						details.setHorizontalAlignment(JLabel.CENTER);
						pLabel1.add(field,gbc);
						pLabel1.add(tf,gbc);
						pLabel1.add(details,gbc);
						Font font1 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
						String text1 = "This Section Demonstrates" + "<br>" + "<br>" +
								"The Basic Details Of Visitor" + "<br>" + "<br>" +
								"As Per The Barcode Number" + "<br>" + "<br>" +
								"You Will Enter";
						JLabel desc1 = new JLabel("<html><div style='text-align: center;'>" + text1 + "</div></html>");
						desc1.setFont(font1);
						desc1.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
						desc1.setForeground(Color.decode("#00a4bd"));
						desc1.setPreferredSize(new Dimension(300,330));
						desc1.setHorizontalAlignment(SwingConstants.CENTER);
						pLabel1.add(desc1,gbc);    
						frame.revalidate();
						frame.repaint();
						String s = new String("Please Enter Valid...<br>Barcode Number...");
						Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
				}
			}

		});

		pLabel1.add(tf,gbc);
		Font font1 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text1 = "This Section Demonstrates" + "<br>" + "<br>" +
				"The Basic Details Of Visitor" + "<br>" + "<br>" +
				"As Per The Barcode Number" + "<br>" + "<br>" +
				"You Will Enter";
		JLabel desc1 = new JLabel("<html><div style='text-align: center;'>" + text1 + "</div></html>");
		desc1.setFont(font1);
		desc1.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc1.setForeground(Color.decode("#00a4bd"));
		desc1.setPreferredSize(new Dimension(300,330));
		desc1.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel1.add(desc1,gbc);    

		pLabel2 = new JPanel(new BorderLayout());
		pLabel2.setPreferredSize(new Dimension(1000, 390));
		pLabel2.setBackground(new Color(254,254,254));
		pLabel2.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text2 = "This Section Demonstrates The Overall Visits And Count" + "<br>" + "<br>" +
				"Of Visitor On Each Date In The Form Of TimeLine"+ "<br>" + "<br>" +
				"As Per The Barcode Number You Will Enter";
		JLabel desc2 = new JLabel("<html><div style='text-align: center;'>" + text2 + "</div></html>");
		desc2.setFont(font);
		desc2.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc2.setForeground(Color.decode("#00a4bd"));
		desc2.setPreferredSize(new Dimension(990,340));
		desc2.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel2.add(desc2);


		JPanel panel2 = new JPanel();
		pLabel10 = new JPanel(new BorderLayout());
		pLabel10.setPreferredSize(new Dimension(660, 390));
		pLabel10.setBackground(new Color(254,254,254));
		pLabel10.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font10 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text10 = "This Section Demonstrates The Basic" + "<br>" + "<br>" +
				"Overview Of Visitor Visits And The Time Spent"+ "<br>" + "<br>" +
				"As Per The Barcode Number You Will Enter";
		JLabel desc10 = new JLabel("<html><div style='text-align: center;'>" + text10 + "</div></html>");
		desc10.setFont(font10);
		desc10.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc10.setForeground(Color.decode("#00a4bd"));
		desc10.setPreferredSize(new Dimension(990,340));
		desc10.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel10.add(desc10);



		pLabel3 = new JPanel(new BorderLayout());
		pLabel3.setPreferredSize(new Dimension(660, 390));
		pLabel3.setBackground(new Color(254,254,254));
		pLabel3.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font3 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text3 = "This Section Demonstrates The Overall Count For" + "<br>" + "<br>" +
				"The Most Visited Month Of All Time By The Visitor"+ "<br>" + "<br>" +
				"As Per The Barcode Number You Will Enter";
		JLabel desc3 = new JLabel("<html><div style='text-align: center;'>" + text3 + "</div></html>");
		desc3.setFont(font3);
		desc3.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc3.setForeground(Color.decode("#00a4bd"));
		desc3.setPreferredSize(new Dimension(990,340));
		desc3.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel3.add(desc3);


		JPanel panel3 = new JPanel();
		pLabel4 = new JPanel(new BorderLayout());
		pLabel4.setPreferredSize(new Dimension(650, 350));
		pLabel4.setBackground(new Color(254,254,254));
		pLabel4.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font4 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text4 = "This Section Demonstrates The Overall Count" + "<br>" + "<br>" +
				"Of Visitor On Each Month Of Each Year" + "<br>" + "<br>" +
				"As Per In Record In The Form Of Timeline" + "<br>" + "<br>" +
				"According To The Barcode Number You Will Enter";
		JLabel desc4 = new JLabel("<html><div style='text-align: center;'>" + text4 + "</div></html>");
		desc4.setFont(font4);
		desc4.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc4.setForeground(Color.decode("#00a4bd"));
		desc4.setPreferredSize(new Dimension(990,340));
		desc4.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel4.add(desc4);


		pLabel5 = new JPanel(new BorderLayout());
		pLabel5.setPreferredSize(new Dimension(650, 350));
		pLabel5.setBackground(new Color(254,254,254));
		pLabel5.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font5 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text5 = "This Section Demonstrates The Overall Count For" + "<br>" + "<br>" +
				"The Most Visited Week Day Of All Time By Visitor" + "<br>" + "<br>" +
				"As Per The Barcode Number You Will Enter";
		JLabel desc5 = new JLabel("<html><div style='text-align: center;'>" + text5 + "</div></html>");
		desc5.setFont(font5);
		desc5.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc5.setForeground(Color.decode("#00a4bd"));
		desc5.setPreferredSize(new Dimension(990,340));
		desc5.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel5.add(desc5);


		JPanel panel4 = new JPanel();
		pLabel6 = new JPanel(new BorderLayout());
		pLabel6.setPreferredSize(new Dimension(650, 350));
		pLabel6.setBackground(new Color(254,254,254));
		pLabel6.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font6 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text6 = "This Section Demonstrates The Overall Count For" + "<br>" + "<br>" +
				"The Most Visited Hour Of All Time By Visitor" + "<br>" + "<br>" +
				"As Per The Barcode Number You Will Enter";
		JLabel desc6 = new JLabel("<html><div style='text-align: center;'>" + text6 + "</div></html>");
		desc6.setFont(font6);
		desc6.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc6.setForeground(Color.decode("#00a4bd"));
		desc6.setPreferredSize(new Dimension(990,340));
		desc6.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel6.add(desc6);


		pLabel7 = new JPanel(new BorderLayout());
		pLabel7.setPreferredSize(new Dimension(650, 350));
		pLabel7.setBackground(new Color(254,254,254));
		pLabel7.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font7 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text7 = "This Section Demonstrates The Overall Visits" + "<br>" + "<br>" +
				"Of Visitor In The Form Of TimeLine" + "<br>" + "<br>" +
				"As Per The Barcode Number You Will Enter";

		JLabel desc7 = new JLabel("<html><div style='text-align: center;'>" + text7 + "</div></html>");
		desc7.setFont(font7);
		desc7.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc7.setForeground(Color.decode("#00a4bd"));
		desc7.setPreferredSize(new Dimension(990,340));
		desc7.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel7.add(desc7);

		JPanel panel5 = new JPanel();
		pLabel8 = new JPanel(new BorderLayout());
		pLabel8.setPreferredSize(new Dimension(650, 350));
		pLabel8.setBackground(new Color(254,254,254));
		pLabel8.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font8 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text8 = "This Section Demonstrates The Overall Count" + "<br>" + "<br>" +
				"Of Visitor In Each Year As Per In Record" + "<br>" + "<br>" +
				"According To The Barcode Number You Will Enter";

		JLabel desc8 = new JLabel("<html><div style='text-align: center;'>" + text8 + "</div></html>");
		desc8.setFont(font8);
		desc8.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc8.setForeground(Color.decode("#00a4bd"));
		desc8.setPreferredSize(new Dimension(990,340));
		desc8.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel8.add(desc8);


		pLabel9 = new JPanel(new BorderLayout());
		pLabel9.setPreferredSize(new Dimension(650, 350));
		pLabel9.setBackground(new Color(254,254,254));
		pLabel9.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font9 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text9 = "This Section Allows You To Download" + "<br>" + "<br>" +
				"The Data In The Form Of CSV File";
		JLabel desc9 = new JLabel("<html><div style='text-align: center;'>" + text9 + "</div></html>");
		desc9.setFont(font9);
		desc9.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc9.setForeground(Color.decode("#00a4bd"));
		desc9.setPreferredSize(new Dimension(990,340));
		desc9.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel9.add(desc9);

		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		pLabel2.setBackground(Color.white);
		pLabel10.setBackground(Color.white);
		pLabel3.setBackground(Color.white);
		pLabel4.setBackground(Color.white);
		pLabel5.setBackground(Color.white);
		pLabel6.setBackground(Color.white);
		pLabel7.setBackground(Color.white);
		pLabel8.setBackground(Color.white);
		pLabel9.setBackground(Color.white);

		panel1.add(pLabel1);
		panel1.add(pLabel2);
		panel2.add(pLabel10);
		panel2.add(pLabel3);
		panel3.add(pLabel4);
		panel3.add(pLabel5);
		panel4.add(pLabel6);
		panel4.add(pLabel7);
		panel5.add(pLabel8);
		panel5.add(pLabel9);

		panel.add(panel1,gbc);
		panel.add(panel2,gbc);
		panel.add(panel3,gbc);
		panel.add(panel4,gbc);
		panel.add(panel5,gbc);

		frame.getContentPane().add(new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		frame.setVisible(true);
	}

	private void createpLabel10(String seatNumber) {
		// TODO Auto-generated method stub
		JLabel label1 = new JLabel();
		String text ="";
		for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(seatNumber).size() ; i++) {
			String str = new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumber(seatNumber).get(i).toString();
			addTime(str);
		}
		hr = hr + (min / 60);
		min = min % 60;
		text = text + "Total Number Of Times visited : <br>"+new VisitorsDaoImpl().getParticularVisitorCountBYCome(seatNumber)+"<br>"
				+ "Total Time Spent : <br>" + hr + " Hours " + min + " Minutes " + sec + " Seconds"+"<br>";
		min = hr = sec = 0;
		text = text +"<br>";
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentGrouply(seatNumber).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getStudentGrouply(seatNumber).get(i) );
		}
		for(Object[] o:object) {
			text = text + "Year : "+o[0].toString()+" Total Visits : "+o[1]+"<br>";
			for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumberYear(seatNumber,(int) o[0]).size() ; i++) {
				String str = new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumberYear(seatNumber,(int) o[0]).get(i).toString();
				addTime(str);
			}
			hr = hr + (min / 60);
			min = min % 60;
			text = text + "Total Time Spent : <br>" + hr + " Hours " + min + " Minutes " + sec + " Seconds<br><br>";
			hr = min = sec = 0;
		}    	
		text = text +"<br><br><br><br>";
		List<Object[]> object1 = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentMonthlyGrouply(seatNumber).size(); i++){
			object1.add(i, (Object[]) new VisitorsDaoImpl().getStudentMonthlyGrouply(seatNumber).get(i) );
		}
		for(Object[] o:object1) {
			text = text + "Year : "+o[0].toString()+"<br>Month : "+o[2].toString()+" Total Visits : "+o[3]+"<br>";
			for(int i = 0 ; i < new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumberYearMonth(seatNumber,(int) o[0],o[2].toString()).size() ; i++) {
				String str = new VisitorsDaoImpl().getVisitorTimeSpentRecordBySeatNumberYearMonth(seatNumber,(int) o[0],o[2].toString()).get(i).toString();
				addTime(str);
			}
			hr = hr + (min / 60);
			min = min % 60;
			text = text + "Total Time Spent : <br>" + hr + " Hours " + min + " Minutes " + sec + " Seconds<br><br>";
			hr = min = sec = 0;
		}    	
		label1.setText("<html><div style='text-align: center;background-color:white;width:490px'>" + text + "</div></html>");
		pLabel10.setPreferredSize(new Dimension(660, 390));
		pLabel10.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		Font font10 = new Font(Font.MONOSPACED, Font.PLAIN|Font.BOLD, 18);
		label1.setFont(font10);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
		JScrollPane scroller = new JScrollPane(label1);
		scroller.setBackground(Color.white);
		pLabel10.add(scroller);
		text = text.replace("<br>", " ");
		StringSelection select = new StringSelection(text);
		label1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				clip.setContents(select, null);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label1.setToolTipText("Click To Copy The Contents");
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
	}

	private Component callDatePickers(String string, int no, JFrame frame) {
		// TODO Auto-generated method stub
		JPanel field = new JPanel(new FlowLayout());
		field.setBackground(new Color(254,254,254));
		UtilDateModel model0 = new UtilDateModel();
		UtilDateModel model00 = new UtilDateModel();

		if(no==2) {
			model0 = model;
			model00 = model1;
		}
		if(no==3) {
			model0 = model2;
			model00 = model3;
		}
		if(no==4) {
			model0 = model4;
			model00 = model5;
		}
		if(no==5) {
			model0 = model6;
			model00 = model7;
		}
		if(no==6) {
			model0 = model8;
			model00 = model9;
		}
		if(no==7) {
			model0 = model10;
			model00 = model11;
		}
		if(no==8) {
			model0 = model12;
			model00 = model13;
		}
		if(no==9) {
			model0 = model14;
			model00 = model15;
		}
		JLabel start = new JLabel("From : ");
		JDatePanelImpl datePanel = new JDatePanelImpl(model0);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		JFormattedTextField jftf = datePicker.getJFormattedTextField();
		jftf.setBackground(Color.decode("#ffffe0"));
		jftf.setForeground(Color.black);
		jftf.setBorder(BorderFactory.createLineBorder(new Color(60,150,90,150)));
		datePicker.setPreferredSize(new Dimension(110,20));
		JLabel end = new JLabel("To : ");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model00);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		JFormattedTextField jftf1 = datePicker1.getJFormattedTextField();
		jftf1.setBackground(Color.decode("#ffffe0"));
		jftf1.setForeground(Color.black);
		jftf1.setBorder(BorderFactory.createLineBorder(new Color(60,150,90,150)));
		datePicker1.setPreferredSize(new Dimension(110,20));
		JButton filter = new JButton("Go");
		filter.setBackground(Color.decode("#ffffe0"));
		filter.setPreferredSize(new Dimension(60,20));
		Download = new JButton("Copy");
		Download.setBackground(Color.decode("#ffffe0"));
		Download.setPreferredSize(new Dimension(60,20));
		Download.setFont(new Font("Verdana", Font.BOLD, 9));
		field.add(start);
		field.add(datePicker);
		field.add(end);
		field.add(datePicker1);
		filter.setFont(new Font("Verdana", Font.BOLD, 9));
		filter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(no == 2){
					pLabel2.removeAll();
					frame.remove(pLabel2);
					createpLabel2(string, frame,datePicker, datePicker1);


				}
				if(no == 3){
					pLabel3.removeAll();
					frame.remove(pLabel3);
					createpLabel3(string,frame,datePicker, datePicker1);
				}
				if(no == 4){
					pLabel4.removeAll();
					frame.remove(pLabel4);
					createpLabel4(string,frame,datePicker, datePicker1);
				}
				if(no == 5){
					pLabel5.removeAll();
					frame.remove(pLabel5);
					createpLabel5(string,frame,datePicker, datePicker1);
				}
				if(no == 6){
					pLabel6.removeAll();
					frame.remove(pLabel6);
					createpLabel6(string,frame,datePicker, datePicker1);
				}
				if(no == 7){
					pLabel7.removeAll();
					frame.remove(pLabel7);
					createpLabel7(string,frame,datePicker, datePicker1);
				}
				if(no == 8){
					pLabel8.removeAll();
					frame.remove(pLabel8);
					createpLabel8(string,frame,datePicker, datePicker1);
				}
				if(no == 9){
					pLabel9.removeAll();
					frame.remove(pLabel9);
					createpLabel9(string,frame,datePicker, datePicker1);
				}
			}

		});

		field.add(filter);
		field.add(Download);

		if(no == 2) {
			add2 = new JButton("Add");
			add2.setBackground(Color.decode("#ffffe0"));
			add2.setPreferredSize(new Dimension(60,20));
			add2.setFont(new Font("Verdana", Font.BOLD, 9));
			add2.hide();
			field.add(add2);
		}
		if(no == 3) {
			add3 = new JButton("Add");
			add3.setBackground(Color.decode("#ffffe0"));
			add3.setPreferredSize(new Dimension(60,20));
			add3.setFont(new Font("Verdana", Font.BOLD, 9));
			add3.hide();
			field.add(add3);
		}
		if(no == 4) {
			add4 = new JButton("Add");
			add4.setBackground(Color.decode("#ffffe0"));
			add4.setPreferredSize(new Dimension(60,20));
			add4.setFont(new Font("Verdana", Font.BOLD, 9));
			add4.hide();
			field.add(add4);
		}
		if(no == 5) {
			add5 = new JButton("Add");
			add5.setBackground(Color.decode("#ffffe0"));
			add5.setPreferredSize(new Dimension(60,20));
			add5.setFont(new Font("Verdana", Font.BOLD, 9));
			add5.hide();
			field.add(add5);
		}
		if(no == 6) {
			add6 = new JButton("Add");
			add6.setBackground(Color.decode("#ffffe0"));
			add6.setPreferredSize(new Dimension(60,20));
			add6.setFont(new Font("Verdana", Font.BOLD, 9));
			add6.hide();
			field.add(add6);
		}
		if(no == 7) {
			add7 = new JButton("Add");
			add7.setBackground(Color.decode("#ffffe0"));
			add7.setPreferredSize(new Dimension(60,20));
			add7.setFont(new Font("Verdana", Font.BOLD, 9));
			add7.hide();
			field.add(add7);
		}
		if(no == 8) {
			add8 = new JButton("Add");
			add8.setBackground(Color.decode("#ffffe0"));
			add8.setPreferredSize(new Dimension(60,20));
			add8.setFont(new Font("Verdana", Font.BOLD, 9));
			add8.hide();
			field.add(add8);
		}
		if(no ==9) {

			add9 = new JButton("Add");
			add9.setBackground(Color.decode("#ffffe0"));
			add9.setPreferredSize(new Dimension(60,20));
			add9.setFont(new Font("Verdana", Font.BOLD, 9));
			add9.hide();
			field.add(add9);

			inout = new JButton();
			inout.setText("In Out");
			inout.setBackground(Color.decode("#ffffe0"));
			inout.setPreferredSize(new Dimension(70,20));
			inout.setFont(new Font("Verdana", Font.BOLD, 9));
			field.add(inout);

			pdf = new JButton();
			pdf.setText("PDF");
			pdf.setBackground(Color.red);
			pdf.setPreferredSize(new Dimension(60,20));
			pdf.setFont(new Font("Verdana", Font.BOLD, 9));
			if(!hope) {
				pdf.setBackground(Color.yellow);
			}
			field.add(pdf);
		}
		if(!hope) {
			add2.show();
			add3.show();
			add4.show();
			add5.show();
			add6.show();
			add7.show();
			add8.show();
			add9.show();
		}
		return field;
	}

	private void createpLabel2(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		pLabel2.add(callDatePickers(string,2,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorRecord(string).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorRecord(string).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chart2 = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max2=new VisitorsDaoImpl().getAllDayWiseVisitorRecord(string).size();
				if(max2 > 20) {
					e = 20;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max2);
				}else {
					e=max2;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max2);
				}
				if(max2 < 20) {
					scroller2.hide();
				}
			}
			else {
				callpLabel2Else(string,datePicker,datePicker1);
			}
		}catch(Exception e1) {
			callpLabel2Else(string,datePicker,datePicker1);
		}

		chart2.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart2.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound()+60);
		rangeAxis.setRange(rangeData);
		BarRenderer renderer = (BarRenderer ) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.decode("#101D6B"));
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart2.getLegend().setFrame(BlockBorder.NONE);
		chart2.getLegend().setPosition(RectangleEdge.RIGHT);
		chart2.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart2.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart2);
		chartpanel.setPreferredSize(new Dimension(1000, 350));
		w.setVisible(false);
		pLabel2.add(chartpanel);
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller2.setValue(0);
					while(count < max2) {
						BufferedImage chartImage = chart2.createBufferedImage(1000,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"B_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller2.setValue(count);
					}
				}
			}

		});
		add2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller2.setValue(0);
					while(count < max2) {
						BufferedImage chartImage = chart2.createBufferedImage(1000,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart2.createBufferedImage(1000,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller2.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		scroller2.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset2.setFirstCategoryIndex(scroller2.getValue());
			}

		});
		pLabel2.add(scroller2,"South");         
		frame.revalidate();
		frame.repaint();
	}

	private void callpLabel2Else(String string, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
		}

		for(Object[] o:object) {
			dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
		}

		dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
		chart2 = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
				dataset2, PlotOrientation.VERTICAL, true, true, false);
		int e=0;
		max2=new VisitorsDaoImpl().getAllDayWiseVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
		if(max2 > 20) {
			e = 20;
			scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max2);
		}else {
			e=max2;
			scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max2);
		}
		if(max2 < 20) {
			scroller2.hide();
		}
	}

	private void createpLabel3(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel3.add(callDatePickers(string,3,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {

				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(string).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(string).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"All Time Visits", o[0].toString());
				}

				dataset3 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart3 = ChartFactory.createLineChart("", "Most Visited Month Of All Time", "Student FootFall Count",
						dataset3, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max3=new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(string).size();
				if(max3 > 20) {
					e = 20;
					scroller3 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max3);
				}else {
					e=max3;
					scroller3 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max3);
				}
				if(max3 < 20) {
					scroller3.hide();
				}

			}
			else {
				callpLabel3Else(string,datePicker,datePicker1);
			}
		}catch(Exception e1) {
			callpLabel3Else(string,datePicker,datePicker1);
		}

		chart3.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart3.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setLowerBound(0);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound()+60);
		rangeAxis.setRange(rangeData);
		LineAndShapeRenderer renderer = (LineAndShapeRenderer ) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.black);
		renderer.setBaseShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart3.getLegend().setFrame(BlockBorder.NONE);
		chart3.getLegend().setPosition(RectangleEdge.RIGHT);
		chart3.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart3.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart3);
		chartpanel.setPreferredSize(new Dimension(1000, 350));
		w.setVisible(false);
		pLabel3.add(chartpanel);
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller3.setValue(0);
					while(count < max3) {
						BufferedImage chartImage = chart3.createBufferedImage(1000,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"C_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller3.setValue(count);
					}
				}
			}

		});
		add3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller3.setValue(0);
					while(count < max3) {
						BufferedImage chartImage = chart3.createBufferedImage(1000,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart3.createBufferedImage(1000,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller3.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		scroller3.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset3.setFirstCategoryIndex(scroller3.getValue());
			}

		});
		pLabel3.add(scroller3,"South");
		frame.revalidate();
		frame.repaint();
	}
	private void callpLabel3Else(String string, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
		}

		for(Object[] o:object) {
			dataset1.addValue((Number) o[1],"All Time Visits", o[0].toString());
		}

		dataset3 = new SlidingCategoryDataset(dataset1, 0, 20);
		chart3 = ChartFactory.createLineChart("", "Most Visited Month Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
				dataset3, PlotOrientation.VERTICAL, true, true, false);
		int e=0;
		max3=new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
		if(max3 > 20) {
			e = 20;
			scroller3 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max3);
		}else {
			e=max3;
			scroller3 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max3);
		}
		if(max3 < 20) {
			scroller3.hide();
		} 
	}

	//    
	private void createpLabel4(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel4.add(callDatePickers(string,4,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthlyVisitorRecord(string).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthlyVisitorRecord(string).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],"FootFall",o[1].toString()+" "+o[0].toString());
				}

				dataset4 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart4 = ChartFactory.createLineChart("", "Months TimeLine", "Student FootFall Count",
						dataset4, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max4=new VisitorsDaoImpl().getAllMonthlyVisitorRecord(string).size();
				if(max4 > 20) {
					e = 20;
					scroller4 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max4);
				}else {
					e=max4;
					scroller4 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max4);
				}
				if(max4 < 20) {
					scroller4.hide();
				}
			}
			else {
				callpLable4Else(string,datePicker,datePicker1);
			}
		}catch(Exception e1) {
			callpLable4Else(string,datePicker,datePicker1);
		}

		chart4.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart4.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setLowerBound(0);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound()+60);
		rangeAxis.setRange(rangeData);
		LineAndShapeRenderer renderer = (LineAndShapeRenderer ) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.black);
		renderer.setBaseShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart4.getLegend().setFrame(BlockBorder.NONE);
		chart4.getLegend().setPosition(RectangleEdge.RIGHT);
		chart4.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart4.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart4);
		chartpanel.setPreferredSize(new Dimension(660, 350));
		w.setVisible(false);
		pLabel4.add(chartpanel);
		scroller4.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset4.setFirstCategoryIndex(scroller4.getValue());
			}

		});
		pLabel4.add(scroller4,"South");
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller4.setValue(0);
					while(count < max4) {
						BufferedImage chartImage = chart4.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"D_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller4.setValue(count);
					}
				}
			}

		});
		add4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller4.setValue(0);
					while(count < max4) {
						BufferedImage chartImage = chart4.createBufferedImage(660,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart4.createBufferedImage(660,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller4.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		frame.revalidate();
		frame.repaint();
	}
	private void callpLable4Else(String string, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthlyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthlyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
		}

		for(Object[] o:object) {
			dataset1.addValue((Number) o[2],"FootFall",o[1].toString()+" "+o[0].toString());
		}
		dataset4 = new SlidingCategoryDataset(dataset1, 0, 20);
		chart4 = ChartFactory.createLineChart("", "Months TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
				dataset4, PlotOrientation.VERTICAL, true, true, false);
		int e=0;
		max4=new VisitorsDaoImpl().getAllMonthlyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
		if(max4 > 20) {
			e = 20;
			scroller4 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max4);
		}else {
			e=max4;
			scroller4 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max4);
		}
		if(max4 < 20) {
			scroller4.hide();
		}
	}

	private void createpLabel5(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel5.add(callDatePickers(string,5,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentWeekly(string).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentWeekly(string).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset5 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart5 = ChartFactory.createBarChart("", "Most Visited Week Days Of All Time", "Student FootFall Count",
						dataset5, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max5=new VisitorsDaoImpl().getStudentWeekly(string).size();
				if(max5 > 20) {
					e = 20;
					scroller5 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max5);
				}else {
					e=max5;
					scroller5 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max5);
				}
				if(max5 < 20) {
					scroller5.hide();
				}
			}
			else {
				callpLabel5Else(string,datePicker,datePicker1); 
			}
		}catch(Exception e1) {
			callpLabel5Else(string,datePicker,datePicker1);
		}

		chart5.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart5.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound()+60);
		rangeAxis.setRange(rangeData);
		BarRenderer renderer = (BarRenderer ) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.decode("#101D6B"));
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart5.getLegend().setFrame(BlockBorder.NONE);
		chart5.getLegend().setPosition(RectangleEdge.RIGHT);
		chart5.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart5.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart5);
		chartpanel.setPreferredSize(new Dimension(660, 350));
		w.setVisible(false);
		pLabel5.add(chartpanel);
		scroller5.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset5.setFirstCategoryIndex(scroller5.getValue());
			}

		});
		pLabel5.add(scroller5,"South");
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller5.setValue(0);
					while(count < max5) {
						BufferedImage chartImage = chart5.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"E_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller5.setValue(count);
					}
				}
			}

		});
		add5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller5.setValue(0);
					while(count < max5) {
						BufferedImage chartImage = chart5.createBufferedImage(660,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart5.createBufferedImage(660,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller5.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		frame.revalidate();
		frame.repaint();
	}
	private void callpLabel5Else(String string, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentWeekly(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getStudentWeekly(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
		}

		for(Object[] o:object) {
			dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
		}

		dataset5 = new SlidingCategoryDataset(dataset1, 0, 20);
		chart5 = ChartFactory.createBarChart("", "Most Visited Week Days Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
				dataset5, PlotOrientation.VERTICAL, true, true, false);
		int e=0;
		max5=new VisitorsDaoImpl().getStudentWeekly(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
		if(max5 > 20) {
			e = 20;
			scroller5 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max5);
		}else {
			e=max5;
			scroller5 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max5);
		}
		if(max5 < 20) {
			scroller5.hide();
		}
	}

	private void createpLabel6(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel6.add(callDatePickers(string,6,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentHourly(string).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentHourly(string).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				} 

				dataset6 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart6 = ChartFactory.createLineChart("", "Most Visited Hour Of All Time", "Student FootFall Count",
						dataset6, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max6=new VisitorsDaoImpl().getStudentHourly(string).size();
				if(max6 > 20) {
					e = 20;
					scroller6 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max6);
				}else {
					e=max6;
					scroller6 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max6);
				}
				if(max6 < 20) {
					scroller6.hide();
				}
			}
			else {
				callpLabel6Else(string,datePicker,datePicker1);
			}
		}catch(Exception e1) {
			callpLabel6Else(string,datePicker,datePicker1);
		}

		chart6.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart6.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound()+60);
		rangeAxis.setRange(rangeData);
		LineAndShapeRenderer renderer = (LineAndShapeRenderer ) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.black);
		renderer.setBaseShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setLowerMargin(0);
		domainAxis.setUpperMargin(0);
		domainAxis.setCategoryMargin(0);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart6.getLegend().setFrame(BlockBorder.NONE);
		chart6.getLegend().setPosition(RectangleEdge.RIGHT);
		chart6.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart6.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart6);
		chartpanel.setPreferredSize(new Dimension(660, 350));
		w.setVisible(false);
		pLabel6.add(chartpanel);
		scroller6.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset6.setFirstCategoryIndex(scroller6.getValue());
			}

		});
		pLabel6.add(scroller6,"South");
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller6.setValue(0);
					while(count < max6) {
						BufferedImage chartImage = chart6.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"F_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller6.setValue(count);
					}
				}
			}

		});
		add6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller6.setValue(0);
					while(count < max6) {
						BufferedImage chartImage = chart6.createBufferedImage(660,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart6.createBufferedImage(660,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller6.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		frame.revalidate();
		frame.repaint();
	}
	private void callpLabel6Else(String string, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentHourly(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getStudentHourly(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
		}

		for(Object[] o:object) {
			dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
		}

		dataset6 = new SlidingCategoryDataset(dataset1, 0, 20);
		chart6 = ChartFactory.createLineChart("", "Most Visited Hour Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
				dataset6, PlotOrientation.VERTICAL, true, true, false);
		int e=0;
		max6=new VisitorsDaoImpl().getStudentHourly(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
		if(max6 > 20) {
			e = 20;
			scroller6 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max6);
		}else {
			e=max6;
			scroller6 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max6);
		}
		if(max6 < 20) {
			scroller6.hide();
		}
	}

	private void createpLabel7(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel7.add(callDatePickers(string,7,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				Boolean includeHeaders = true;
				Statement statement = null;
				PreparedStatement pstatement = null;
				ResultSet myResultSet = null;
				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e3) {
					String s11 = new String("Failed To Process...<br>Please Try Again...");
					Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
					t.showtoast();
				}
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_scanner_testing","root","root");
				} catch (SQLException e2) {
					String s11 = new String("Failed To Process...<br>Please Try Again...");
					Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
					t.showtoast();
				}
				if (connection != null) {
					try {
						statement = connection.createStatement();
					} catch (SQLException e2) {
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
				}
				pstatement = connection.prepareStatement("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visitors.visitor_seat_number = ? AND visit_status ='come' GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
				pstatement.setString(1, string);
				myResultSet = pstatement.executeQuery();
				while(myResultSet.next()) {
					dataset1.addValue(myResultSet.getLong(3),"FootFall",myResultSet.getString(1)+" "+myResultSet.getString(2));
				}

				dataset7 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart7 = ChartFactory.createLineChart("", "TimeLine", "24 Hour Time Format",
						dataset7, PlotOrientation.VERTICAL, true, false, false);
				int e=0;
				max7=new VisitorsDaoImpl().getAllTimelyVisitorRecord(string).size();
				if(max7 > 20) {
					e = 20;
					scroller7 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max7);
				}else {
					e=max7;
					scroller7 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max7);
				}
				if(max7 < 20) {
					scroller7.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				Boolean includeHeaders = true;
				Statement statement = null;
				PreparedStatement pstatement = null;
				ResultSet myResultSet = null;
				Connection connection = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e3) {
					String s11 = new String("Failed To Process...<br>Please Try Again...");
					Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
					t.showtoast();
				}
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_scanner_testing","root","root");
				} catch (SQLException e2) {
					String s11 = new String("Failed To Process...<br>Please Try Again...");
					Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
					t.showtoast();
				}
				if (connection != null) {
					try {
						statement = connection.createStatement();
					} catch (SQLException e2) {
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
				}
				pstatement = connection.prepareStatement("SELECT visit_date, visit_time, HOUR(visit_time) FROM visitors WHERE visitor_seat_number = ? AND visit_status ='come' AND visit_date BETWEEN ? AND ? GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
				pstatement.setString(1, string);
				pstatement.setString(2, datePicker.getJFormattedTextField().getText());
				pstatement.setString(3, datePicker1.getJFormattedTextField().getText());          			
				myResultSet = pstatement.executeQuery();
				while(myResultSet.next()) {
					dataset1.addValue(myResultSet.getLong(3),"FootFall",myResultSet.getString(1)+" "+myResultSet.getString(2));
				}

				dataset7 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart7 = ChartFactory.createLineChart("", "TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "24 Hour Time Format",
						dataset7, PlotOrientation.VERTICAL, true, false, false);
				int e=0;
				max7=new VisitorsDaoImpl().getAllTimelyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max7 > 20) {
					e = 20;
					scroller7 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max7);
				}else {
					e=max7;
					scroller7 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max7);
				}
				if(max7 < 20) {
					scroller7.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllTimelyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllTimelyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],"FootFall",o[0].toString()+" "+o[1].toString());
			} 

			dataset7 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart7 = ChartFactory.createLineChart("", "TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "24 Hour Time Format",
					dataset7, PlotOrientation.VERTICAL, true, false, false);
			int e=0;
			max7=new VisitorsDaoImpl().getAllTimelyVisitorRecord(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max7 > 20) {
				e = 20;
				scroller7 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max7);
			}else {
				e=max7;
				scroller7 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max7);
			}
			if(max7 < 20) {
				scroller7.hide();
			} 
		}

		chart7.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart7.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setLowerBound(0);
		rangeAxis.setUpperBound(24);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound());
		rangeAxis.setRange(rangeData);
		LineAndShapeRenderer renderer = (LineAndShapeRenderer ) plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.black);
		renderer.setBaseShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		chart7.getLegend().setFrame(BlockBorder.NONE);
		chart7.getLegend().setPosition(RectangleEdge.RIGHT);
		chart7.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart7.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart7);
		chartpanel.setPreferredSize(new Dimension(660, 350));
		w.setVisible(false);
		pLabel7.add(chartpanel);
		scroller7.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset7.setFirstCategoryIndex(scroller7.getValue());
			}

		});
		pLabel7.add(scroller7,"South");
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller7.setValue(0);
					while(count < max7) {
						BufferedImage chartImage = chart7.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"G_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller7.setValue(count);
					}
				}
			}

		});
		add7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller7.setValue(0);
					while(count < max7) {
						BufferedImage chartImage = chart7.createBufferedImage(660,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart7.createBufferedImage(660,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller7.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		frame.revalidate();
		frame.repaint();
	}
	//    
	private void createpLabel8(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel8.add(callDatePickers(string,8,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentGrouply(string).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentGrouply(string).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}
				dataset8 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart8 = ChartFactory.createLineChart("", "Years", "Student FootFall Count",
						dataset8, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max8=new VisitorsDaoImpl().getStudentGrouply(string).size();
				if(max8 > 20) {
					e = 20;
					scroller8 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max8);
				}else {
					e=max8;
					scroller8 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max8);
				}
				if(max8 < 20) {
					scroller8.hide();
				}
			}
			else {
				callpLabel8Else(string,datePicker,datePicker1);
			}
		}catch(Exception e1) {
			callpLabel8Else(string,datePicker,datePicker1);
		}

		chart8.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart8.getPlot();
		plot.setBackgroundPaint(Color.decode("#ffffe0"));
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.pink);
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.green);
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setLowerBound(0);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound()+60);
		rangeAxis.setRange(rangeData);
		LineAndShapeRenderer renderer = (LineAndShapeRenderer ) plot.getRenderer();
		renderer.setSeriesPaint(0, Color.black);
		renderer.setBaseShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.red);
		renderer.setSeriesStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
		renderer.setSeriesShape(0,  new Ellipse2D.Double(-3.0,-3.0,6.0,6.0));
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart8.getLegend().setFrame(BlockBorder.NONE);
		chart8.getLegend().setPosition(RectangleEdge.RIGHT);
		chart8.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart8.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		ChartPanel chartpanel = new ChartPanel(chart8);
		chartpanel.setPreferredSize(new Dimension(660, 350));
		w.setVisible(false);
		pLabel8.add(chartpanel);
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller8.setValue(0);
					while(count < max8) {
						BufferedImage chartImage = chart8.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"H_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller8.setValue(count);
					}
				}
			}

		});
		add8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller8.setValue(0);
					while(count < max8) {
						BufferedImage chartImage = chart8.createBufferedImage(660,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart8.createBufferedImage(660,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +20;
						scroller8.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		scroller8.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset8.setFirstCategoryIndex(scroller8.getValue());
			}

		});
		pLabel8.add(scroller8,"South");
		frame.revalidate();
		frame.repaint();
	}

	private void callpLabel8Else(String string, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		List<Object[]> object = new ArrayList<Object[]>();
		for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentGrouply(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
			object.add(i, (Object[]) new VisitorsDaoImpl().getStudentGrouply(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
		}

		for(Object[] o:object) {
			dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
		} 
		dataset8 = new SlidingCategoryDataset(dataset1, 0, 20);
		chart8 = ChartFactory.createLineChart("", "Years Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
				dataset8, PlotOrientation.VERTICAL, true, true, false);
		int e=0;
		max8=new VisitorsDaoImpl().getStudentGrouply(string,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
		if(max8 > 20) {
			e = 20;
			scroller8 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max8);
		}else {
			e=max8;
			scroller8 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max8);
		}
		if(max8 < 20) {
			scroller8.hide();
		}
	}

	private void createpLabel9(String string, JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel9.add(callDatePickers(string,9,frame),"North");

		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					try {
						Files.createDirectories(Paths.get(path+"\\"+name));						
					} catch (IOException e1) {
						String s = new String("Directory Creation Failed...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					File summaryChartFile = new File(path+"\\"+name+"\\"+"I_"+name+".csv");
					CSVWriter writer = null;
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
					try {
						writer = new CSVWriter(new FileWriter(summaryChartFile));
					} catch (IOException e1) {
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					Boolean includeHeaders = true;
					Statement statement = null;
					PreparedStatement pstatement = null;
					ResultSet myResultSet = null;
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						try {
							connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_scanner_testing","root","root");
						} catch (SQLException e2) {
							String s11 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						if (connection != null) {

							try {
								statement = connection.createStatement();
							} catch (SQLException e2) {
								String s11 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
							try {
								if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
									try {
										pstatement = connection.prepareStatement("select * from visitors where visitor_seat_number = ?");
										pstatement.setString(1, string);
										myResultSet = pstatement.executeQuery();
									} catch (SQLException e2) {
										String s11 = new String("Failed To Process...<br>Please Try Again...");
										Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
										t.showtoast();
									}
								}
								else {
									try {
										pstatement = connection.prepareStatement("select * from visitors where visitor_seat_number = ? and visit_date between ? and ?");
										pstatement.setString(1, string);
										pstatement.setString(2, datePicker.getJFormattedTextField().getText());
										pstatement.setString(3, datePicker1.getJFormattedTextField().getText());
										myResultSet = pstatement.executeQuery();
									} catch (SQLException e2) {
										String s11 = new String("Failed To Process...<br>Please Try Again...");
										Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
										t.showtoast();
									}
								}
							}catch(Exception e1) {
								try {
									pstatement = connection.prepareStatement("select * from visitors where visitor_seat_number = ? and visit_date between ? and ?");
									pstatement.setString(1, string);
									pstatement.setString(2, datePicker.getJFormattedTextField().getText());
									pstatement.setString(3, datePicker1.getJFormattedTextField().getText());
									myResultSet = pstatement.executeQuery();
								} catch (SQLException e2) {
									String s11 = new String("Failed To Process...<br>Please Try Again...");
									Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
									t.showtoast();
								}
							}


							try {
								try {
									String str[] = {"Nirmala Memorial Foundation College Of Commerce & Science"};
									writer.writeNext(str);
									String str1[] = {"NAAC Accredited and ISO Certified"};
									writer.writeNext(str1);
									String str2[] = {"D.S. Road, Asha Nagar, Thakur Complex, Kandivali(E), Mumbai - 400 101 Tel: 2854 3234"};
									writer.writeNext(str2);
									writer.writeAll(myResultSet, includeHeaders);
								} catch (SQLException e1) {
									String s11 = new String("Failed To Process...<br>Please Try Again...");
									Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
									t.showtoast();
								}
								writer.close();
								w.setVisible(false);
							} catch (IOException e1) {
								String s11 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
						}}catch (ClassNotFoundException e1) {
							String s11 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
				}
			}

		});

		pdf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(hope) {

					try {

						pdf.setBackground(Color.yellow);
						String s = new String("Click On Add Button<br>Your Selection Will Be Added To PDF");
						Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,390,70);
						t.showtoast();
						add2.show();
						add3.show();
						add4.show();
						add5.show();
						add6.show();
						add7.show();
						add8.show();
						add9.show();
						frame.revalidate();
						frame.repaint();
						com.lowagie.text.Rectangle pagesize = new com.lowagie.text.Rectangle(1200,900);
						document = new Document(pagesize);
						document.open();
						PdfPTable table = new PdfPTable(1);
						table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
						table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						table.getDefaultCell().setBackgroundColor(new Color(188,222,232));
						table.deleteBodyRows();
						table.setSkipFirstHeader(true);

						com.lowagie.text.Font font = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 24, Font.BOLD);
						font.setColor(Color.BLACK);
						String s1 = "Nirmala Memorial Foundation College Of Commerce & Science";
						Paragraph h1 = new Paragraph(s1,font);
						h1.setAlignment(Element.ALIGN_CENTER);
						PdfPCell cell = new PdfPCell(h1);
						cell.setFixedHeight(30f);
						cell.setBackgroundColor(new Color(188,222,232));
						cell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
						cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cell);

						font = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 12, Font.BOLD);
						font.setColor(Color.BLACK);
						s1 = "NAAC Accredited and ISO Certified";
						h1 = new Paragraph(s1,font);
						h1.setAlignment(Element.ALIGN_CENTER);
						cell = new PdfPCell(h1);
						cell.setFixedHeight(20f);
						cell.setBackgroundColor(new Color(188,222,232));
						cell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
						cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cell);

						s1 = "D.S. Road, Asha Nagar, Thakur Complex, Kandivali(E), Mumbai - 400 101 Tel: 2854 3234";
						h1 = new Paragraph(s1,font);
						h1.setAlignment(Element.ALIGN_CENTER);
						cell = new PdfPCell(h1);
						cell.setFixedHeight(20f);
						cell.setBackgroundColor(new Color(188,222,232));
						cell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
						cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cell);
						table.setHorizontalAlignment(Element.ALIGN_CENTER);
						//						    table.setSpacingAfter(60f);
						baos = new ByteArrayOutputStream();

						PdfWriter.getInstance(document, baos).setStrictImageSequence(true);
						document.open();
						document.add(table);

					}catch(Exception e1) {

					}
					hope = !(hope);
				}
				else {
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("/home/me/Documents"));
					int retrival = chooser.showSaveDialog(null);
					if (retrival == JFileChooser.APPROVE_OPTION) {
						document.close();
						name = chooser.getSelectedFile().getName();
						String path = chooser.getCurrentDirectory().getPath().toString();
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));		
							OutputStream ops = new FileOutputStream(path+"\\"+name+"\\"+"I_"+name+".pdf");
							baos.writeTo(ops);
							baos.close();
							ops.close();
							String s = new String("Process Completed...<br>File Is Generated...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						} catch (IOException e1) {
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						hope = !(hope);
						pdf.setBackground(Color.red);
						add2.hide();
						add3.hide();
						add4.hide();
						add5.hide();
						add6.hide();
						add7.hide();
						add8.hide();
						add9.hide();
						frame.revalidate();
						frame.repaint();
					}
					if(retrival == chooser.CANCEL_OPTION) {

						int a = JOptionPane.showConfirmDialog(frame, "Are You Sure?\nIf you select yes then all your selected data will be wiped!!!s");
						if(a == JOptionPane.YES_OPTION) {
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							try {
								baos.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							hope = !(hope);
							pdf.setBackground(Color.red);
							add2.hide();
							add3.hide();
							add4.hide();
							add5.hide();
							add6.hide();
							add7.hide();
							add8.hide();
							add9.hide();
							frame.revalidate();
							frame.repaint();
						}
					}
				}
			}
		});

		add9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
				try {
					if(newPage == true) {
						document.newPage();
					}
					PdfPTable table = new PdfPTable(1);
					table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
					table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
					table.getDefaultCell().setBackgroundColor(new Color(188,222,232));
					table.deleteBodyRows();
					table.setSkipFirstHeader(true);
					com.lowagie.text.Font font = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 15, Font.BOLD);
					font.setColor(Color.BLACK);
					String s1;
					if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
						s1 = "Table Representing The Visitor Data";
					}
					else {
						s1 = "Table Representing The Visitor Data Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText();
					}
					Paragraph h1 = new Paragraph(s1,font);
					h1.setAlignment(Element.ALIGN_CENTER);
					PdfPCell cell = new PdfPCell(h1);
					cell.setBackgroundColor(new Color(255,240,245));
					cell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
					cell.setFixedHeight(40f);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					document.add(table);
					table.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPTable table1 = new PdfPTable(10);
					float f[] = {10f,4f,38f,8f,4f,4f,8f,8f,8f,8f};
					table1.setWidths(f);
					table1.setHeaderRows(1);
					com.lowagie.text.Font fontin = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 12, com.lowagie.text.Font.BOLD);
					fontin.setColor(Color.BLACK);
					Paragraph hin = new Paragraph("UID",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					PdfPCell cellin = new PdfPCell(hin);
					cellin.setBackgroundColor(new Color(218,238,243));
					cellin.setFixedHeight(40f);
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Roll No.",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(228,223,236));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Name",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setBackgroundColor(new Color(218,238,243));
					cellin.setFixedHeight(40f);
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Stream",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(228,223,236));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Class",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(218,238,243));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Div",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(228,223,236));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Visit Date",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(218,238,243));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("In Time",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(228,223,236));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Out Time",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(218,238,243));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);

					hin = new Paragraph("Time Spent",fontin);
					hin.setAlignment(Element.ALIGN_CENTER);
					cellin = new PdfPCell(hin);
					cellin.setFixedHeight(40f);
					cellin.setBackgroundColor(new Color(228,223,236));
					cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cellin);						    

					fontin = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 12, com.lowagie.text.Font.NORMAL);

					Statement statement = null;
					PreparedStatement pstatement1 = null;
					PreparedStatement pstatement = null;
					ResultSet myResultSet = null;
					ResultSet myResultSet1 = null;
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e3) {
						w.setVisible(false);
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					try {
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_scanner_testing","root","root");
					} catch (SQLException e2) {
						w.setVisible(false);
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					if (connection != null) {
						try {
							statement = connection.createStatement();
						} catch (SQLException e2) {
							w.setVisible(false);
							String s11 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
					}


					try {
						if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
							try {
								pstatement1 = connection.prepareStatement("select * from visitors where visit_status in('come') and visitor_seat_number in(?)");
								pstatement1.setString(1, string);
								myResultSet = pstatement1.executeQuery();					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? limit 1");
									pstatement1.setString(1, myResultSet.getString(2));
									pstatement1.setString(2, myResultSet.getString(8));
									pstatement1.setString(3, "gone");
									pstatement1.setString(4, myResultSet.getString(9));
									myResultSet1 = pstatement1.executeQuery();
									while(myResultSet1.next()) {
										hin = new Paragraph(myResultSet.getString(2),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(1),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(3),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setFixedHeight(40f);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(4),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(5),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(6),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(8),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(9),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet1.getString(9),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet1.getString(11),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

									}

								}
								table1.setHorizontalAlignment(Element.ALIGN_CENTER);
								document.add(table1);

							}catch(Exception e1) {
								w.setVisible(false);
								String s11 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
						}
						else {
							try {

								myResultSet = statement.executeQuery("select * from visitors where visit_status in('come')");					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? limit 1");
									pstatement1.setString(1, myResultSet.getString(2));
									pstatement1.setString(2, myResultSet.getString(8));
									pstatement1.setString(3, "gone");
									pstatement1.setString(4, myResultSet.getString(9));
									pstatement1.setString(5, datePicker.getJFormattedTextField().getText());
									pstatement1.setString(6, datePicker1.getJFormattedTextField().getText());
									myResultSet1 = pstatement1.executeQuery();
									while(myResultSet1.next()) {
										hin = new Paragraph(myResultSet.getString(2),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(1),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(3),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setFixedHeight(40f);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(4),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(5),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(6),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(8),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet.getString(9),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet1.getString(9),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(218,238,243));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);

										hin = new Paragraph(myResultSet1.getString(11),fontin);
										hin.setAlignment(Element.ALIGN_CENTER);
										cellin = new PdfPCell(hin);
										cellin.setBackgroundColor(new Color(228,223,236));
										cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
										cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
										table1.addCell(cellin);
									}

								}
								table1.setHorizontalAlignment(Element.ALIGN_CENTER);
								document.add(table1);

							}catch(Exception e1) {
								w.setVisible(false);
								String s11 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
						}
					}catch(Exception exception) {
						try {

							myResultSet = statement.executeQuery("select * from visitors where visit_status in('come')");					
							while(myResultSet.next()) {
								pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? limit 1");
								pstatement1.setString(1, myResultSet.getString(2));
								pstatement1.setString(2, myResultSet.getString(8));
								pstatement1.setString(3, "gone");
								pstatement1.setString(4, myResultSet.getString(9));
								pstatement1.setString(5, datePicker.getJFormattedTextField().getText());
								pstatement1.setString(6, datePicker1.getJFormattedTextField().getText());
								myResultSet1 = pstatement1.executeQuery();
								while(myResultSet1.next()) {
									hin = new Paragraph(myResultSet.getString(2),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(218,238,243));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(1),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(228,223,236));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(3),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(218,238,243));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setFixedHeight(40f);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(4),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(228,223,236));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(5),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(218,238,243));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(6),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(228,223,236));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(8),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(218,238,243));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet.getString(9),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(228,223,236));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet1.getString(9),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(218,238,243));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

									hin = new Paragraph(myResultSet1.getString(11),fontin);
									hin.setAlignment(Element.ALIGN_CENTER);
									cellin = new PdfPCell(hin);
									cellin.setBackgroundColor(new Color(228,223,236));
									cellin.setVerticalAlignment(Element.ALIGN_MIDDLE);
									cellin.setHorizontalAlignment(Element.ALIGN_CENTER);
									table1.addCell(cellin);

								}

							}
							table1.setHorizontalAlignment(Element.ALIGN_CENTER);
							document.add(table1);

						}catch(Exception e1) {
							w.setVisible(false);
							String s11 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
					}

				}catch(Exception e1) {w.setVisible(false);}
				newPage = true;
				w.setVisible(false);
			}        	
		});

		inout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					try {
						Files.createDirectories(Paths.get(path+"\\"+name));						
					} catch (IOException e1) {
						String s = new String("Directory Creation Failed...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					File summaryChartFile = new File(path+"\\"+name+"\\"+"I_"+name+".csv");
					CSVWriter writer = null;
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
					try {
						writer = new CSVWriter(new FileWriter(summaryChartFile));
					} catch (IOException e1) {
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}

					Statement statement = null;
					PreparedStatement pstatement1 = null;
					PreparedStatement pstatement = null;
					ResultSet myResultSet = null;
					ResultSet myResultSet1 = null;
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e3) {
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					try {
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_scanner_testing","root","root");
					} catch (SQLException e2) {
						String s11 = new String("Failed To Process...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
						t.showtoast();
					}
					if (connection != null) {

						try {
							statement = connection.createStatement();
						} catch (SQLException e2) {
							String s11 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
					}


					String col_name[] ={"Visitor Seat Number","Visitor Roll Number","Visitor Name","Visitor Stream","Visitor Class","Visitor Division","Visitor Library Card Valid Upto","Visit Date","In Time","Out Time","Time Spent"};
					try {
						if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
							try {
								String str[] = {"Nirmala Memorial Foundation College Of Commerce & Science"};
								writer.writeNext(str);
								String str1[] = {"NAAC Accredited and ISO Certified"};
								writer.writeNext(str1);
								String str2[] = {"D.S. Road, Asha Nagar, Thakur Complex, Kandivali(E), Mumbai - 400 101 Tel: 2854 3234"};
								writer.writeNext(str2);
								writer.writeNext(col_name);
								pstatement1 = connection.prepareStatement("select * from visitors where visit_status in('come') and visitor_seat_number in(?)");
								pstatement1.setString(1, string);
								myResultSet = pstatement1.executeQuery();					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? limit 1");
									pstatement1.setString(1, myResultSet.getString(2));
									pstatement1.setString(2, myResultSet.getString(8));
									pstatement1.setString(3, "gone");
									pstatement1.setString(4, myResultSet.getString(9));
									myResultSet1 = pstatement1.executeQuery();
									while(myResultSet1.next()) {
										String[] arr = new String[]{myResultSet.getString(2),myResultSet.getString(1),myResultSet.getString(3),myResultSet.getString(4),myResultSet.getString(5),myResultSet.getString(6),myResultSet.getString(7),myResultSet.getString(8),myResultSet.getString(9),myResultSet1.getString(9),myResultSet1.getString(11)};
										writer.writeNext(arr);

									}

								}
								writer.close();
								w.setVisible(false);

							}catch(Exception e1) {
								String s11 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
						}
						else {
							try {
								String str[] = {"Nirmala Memorial Foundation College Of Commerce & Science"};
								writer.writeNext(str);
								String str1[] = {"NAAC Accredited and ISO Certified"};
								writer.writeNext(str1);
								String str2[] = {"D.S. Road, Asha Nagar, Thakur Complex, Kandivali(E), Mumbai - 400 101 Tel: 2854 3234"};
								writer.writeNext(str2);
								writer.writeNext(col_name);
								pstatement1 = connection.prepareStatement("select * from visitors where visit_status in('come') and visitor_seat_number in(?)");
								pstatement1.setString(1, string);
								myResultSet = pstatement1.executeQuery();	
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? limit 1");
									pstatement1.setString(1, string);
									pstatement1.setString(2, myResultSet.getString(8));
									pstatement1.setString(3, "gone");
									pstatement1.setString(4, myResultSet.getString(9));
									pstatement1.setString(5, datePicker.getJFormattedTextField().getText());
									pstatement1.setString(6, datePicker1.getJFormattedTextField().getText());
									myResultSet1 = pstatement1.executeQuery();
									while(myResultSet1.next()) {
										String[] arr = new String[]{myResultSet.getString(2),myResultSet.getString(1),myResultSet.getString(3),myResultSet.getString(4),myResultSet.getString(5),myResultSet.getString(6),myResultSet.getString(7),myResultSet.getString(8),myResultSet.getString(9),myResultSet1.getString(9),myResultSet1.getString(11)};
										writer.writeNext(arr);

									}

								}
								writer.close();
								w.setVisible(false);

							}catch(Exception e1) {
								String s11 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
						}
					}catch(Exception exception) {
						try {
							String str[] = {"Nirmala Memorial Foundation College Of Commerce & Science"};
							writer.writeNext(str);
							String str1[] = {"NAAC Accredited and ISO Certified"};
							writer.writeNext(str1);
							String str2[] = {"D.S. Road, Asha Nagar, Thakur Complex, Kandivali(E), Mumbai - 400 101 Tel: 2854 3234"};
							writer.writeNext(str2);
							writer.writeNext(col_name);
							myResultSet = statement.executeQuery("select * from visitors where visit_status in('come')");					
							while(myResultSet.next()) {
								pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? limit 1");
								pstatement1.setString(1, myResultSet.getString(2));
								pstatement1.setString(2, myResultSet.getString(8));
								pstatement1.setString(3, "gone");
								pstatement1.setString(4, myResultSet.getString(9));
								pstatement1.setString(5, datePicker.getJFormattedTextField().getText());
								pstatement1.setString(6, datePicker1.getJFormattedTextField().getText());
								myResultSet1 = pstatement1.executeQuery();
								while(myResultSet1.next()) {
									String[] arr = new String[]{myResultSet.getString(2),myResultSet.getString(1),myResultSet.getString(3),myResultSet.getString(4),myResultSet.getString(5),myResultSet.getString(6),myResultSet.getString(7),myResultSet.getString(8),myResultSet.getString(9),myResultSet1.getString(9),myResultSet1.getString(11)};
									writer.writeNext(arr);

								}

							}
							writer.close();
							w.setVisible(false);

						}catch(Exception e1) {
							String s11 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
					}

				}
			}
		});
		Font font9 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text9 = "This Section Allows You To Download" + "<br>" + "<br>" +
				"The Data In The Form Of CSV File";
		JLabel desc9 = new JLabel("<html><div style='text-align: center;'>" + text9 + "</div></html>");
		desc9.setFont(font9);
		desc9.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc9.setForeground(Color.decode("#00a4bd"));
		desc9.setPreferredSize(new Dimension(990,340));
		desc9.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel9.add(desc9);
		frame.revalidate();
		frame.repaint();
	}

	public void callAddSpace(float a) throws DocumentException {
		PdfPTable table = new PdfPTable(1);
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setBackgroundColor(new Color(188,222,232));
		table.deleteBodyRows();
		table.setSkipFirstHeader(true);
		com.lowagie.text.Font font = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 15, Font.BOLD);
		font.setColor(Color.BLACK);
		String s1 = "";
		Paragraph h1 = new Paragraph(s1,font);
		h1.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell = new PdfPCell(h1);
		cell.setBackgroundColor(new Color(255,255,255));
		cell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setFixedHeight(30f);
		table.addCell(cell);
		table.setSpacingBefore(a);
		table.setSpacingAfter(a);
		document.add(table);
	}
	public void addTime(String str) {
		String value="";
		String arr[] = str.split(":");
		for(int i=0;i<arr.length-2;i++) {
			hr = hr + Long.parseLong(arr[i]);
			min = min + Long.parseLong(arr[i+1]);
			sec =sec + Long.parseLong(arr[i+2]);
		}
		min = min + (sec / 60) % 60;
		hr = hr + (sec / 60) / 60;
		sec = sec % 60;

	}
}