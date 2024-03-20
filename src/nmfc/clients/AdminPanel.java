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
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
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
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
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
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CenterTextMode;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.UnitType;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Header;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import nmfc.services.DateLabelFormatter;
import nmfc.services.StudentDaoImpl;
import nmfc.services.VisitorsDaoImpl;

public class AdminPanel {
	OrganicPanel op;
	UtilDateModel model = new UtilDateModel();	UtilDateModel model1 = new UtilDateModel();	UtilDateModel model2 = new UtilDateModel();	UtilDateModel model3 = new UtilDateModel();	UtilDateModel model4 = new UtilDateModel();	UtilDateModel model5 = new UtilDateModel();	UtilDateModel model6 = new UtilDateModel();	UtilDateModel model7 = new UtilDateModel();	UtilDateModel model8 = new UtilDateModel();	UtilDateModel model9 = new UtilDateModel();	UtilDateModel model10 = new UtilDateModel();	UtilDateModel model11 = new UtilDateModel();	UtilDateModel model12 = new UtilDateModel();	UtilDateModel model13 = new UtilDateModel();	UtilDateModel model14 = new UtilDateModel();	UtilDateModel model15 = new UtilDateModel();  UtilDateModel model39 = new UtilDateModel();	UtilDateModel model93 = new UtilDateModel();
	String name;
	static Document document;
	boolean newPage = true;
	JButton inout, sort;
	Long range;
	boolean c_selected,s_selected,c_s_selected,class_Selected,stream_selected,class_stream_selected,d_selected,w_selected,m_selected,y_selected = false;
	boolean bar_chart, line_chart;
	Set<String> class_set = new LinkedHashSet<String>();
	ByteArrayOutputStream baos;
	Random random;
	ChartPanel chartpanel_ex;
	int max2,max3,max4,max5,max6,max7,max8,max_ex;
	JFreeChart chart2,chart3,chart4,chart5,chart6,chart7,chart8,chart_ex;
	JButton Download;
	int v;
	JButton pdf;
	boolean hope = true;
	JButton add1,add2,add3,add4,add5,add6,add7,add8,add9,add_ex;
	JComboBox graph_ex,classy_ex,service_ex;
	static long hr, min, sec = 0;
	static VisitorsDaoImpl visitor_service = new VisitorsDaoImpl(); 	
	static StudentDaoImpl student_service = new StudentDaoImpl();
	JLabel student_details;
	JPanel pLabel1;	JPanel pLabel2;	JPanel pLabel3;	JPanel pLabel4;	JPanel pLabel5;	JPanel pLabel6;	JPanel pLabel7;	JPanel pLabel8;	JPanel pLabel9;JPanel pLabel_ex;
	JScrollBar scroller2,scroller3,scroller4,scroller5,scroller6,scroller7,scroller8,scroller_ex;
	SlidingCategoryDataset dataset2;    SlidingCategoryDataset dataset3;    SlidingCategoryDataset dataset4;    SlidingCategoryDataset dataset5;    SlidingCategoryDataset dataset6;    SlidingCategoryDataset dataset7;    SlidingCategoryDataset dataset8;   SlidingCategoryDataset dataset_ex;

	public static void main(String args[]) throws Exception{
		AdminPanel ap = new AdminPanel();  
		//    	List<Object[]> object = new ArrayList<Object[]>();
		//		for(int  i = 0 ; i < new VisitorsDaoImpl().getClassy().size(); i++){
		//			for(int  j = 0 ; j < new VisitorsDaoImpl().getStreams().size(); j++){
		//				System.out.println(new VisitorsDaoImpl().getClassy().get(i)+" "+new VisitorsDaoImpl().getStreams().get(j));
		//			}
		//		}

	}

	public AdminPanel() {
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

		pLabel1 = new JPanel();
		pLabel1.setPreferredSize(new Dimension(312,390));
		pLabel1.setBackground(new Color(254,254,254));
		pLabel1.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));


		JPanel field = new JPanel(new FlowLayout());
		field.setPreferredSize(new Dimension(300,30));
		field.setBackground(new Color(254,254,254));
		field.setBorder(null);
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		JFormattedTextField jftf = datePicker.getJFormattedTextField();
		jftf.setBackground(Color.decode("#ffffe0"));
		jftf.setForeground(Color.black);
		jftf.setBorder(BorderFactory.createLineBorder(new Color(60,150,90,150)));
		datePicker.setPreferredSize(new Dimension(110,20));
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		JFormattedTextField jftf1 = datePicker1.getJFormattedTextField();
		jftf1.setBackground(Color.decode("#ffffe0"));
		jftf1.setForeground(Color.black);
		jftf1.setBorder(BorderFactory.createLineBorder(new Color(60,150,90,150)));
		datePicker1.setPreferredSize(new Dimension(110,20));
		JButton filter = new JButton("Go");
		filter.setPreferredSize(new Dimension(60,20));
		field.add(datePicker);
		field.add(datePicker1);
		filter.setFont(new Font("Verdana", Font.BOLD, 12));
		field.add(filter);
		pLabel1.add(field,"North");

		Font font2 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text = "This Section Demonstrates" + "<br>" + "<br>" +
				"The Overall Count" + "<br>" + "<br>" +
				"And The" + "<br>" + "<br>" +
				"Total Time Spent" + "<br>" + "<br>" +
				"By Visitors";
		JLabel desc = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		desc.setFont(font2);
		desc.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc.setForeground(Color.decode("#00a4bd"));
		desc.setPreferredSize(new Dimension(300,340));
		desc.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel1.add(desc);
		add1 = new JButton("Add");
		add1.setBackground(Color.decode("#ffffe0"));
		add1.setPreferredSize(new Dimension(120,20));
		add1.setFont(new Font("Verdana", Font.BOLD, 12));
		add1.hide();
		filter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					pLabel1.removeAll();
					frame.remove(pLabel1);
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.weightx = 1.0;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.gridwidth = GridBagConstraints.REMAINDER;
					String count;
					DefaultPieDataset dataset;
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
					try {
						if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
							name = "Overall Count and Time Spent";
							dataset=null;
							dataset = new DefaultPieDataset();	   
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

							myResultSet = statement.executeQuery("select visitor_stream, COUNT(visitor_stream) from visitors WHERE visit_status ='come' GROUP BY visitor_stream");
							while(myResultSet.next()) {
								dataset.setValue(myResultSet.getString(1),myResultSet.getLong(2));
							}
							myResultSet = statement.executeQuery("select time_spent from visitors WHERE time_spent is not null");
							while(myResultSet.next()) {
								addTime(myResultSet.getString(1));
							}

							count = new VisitorsDaoImpl().getAllVisitorsCountBYCome()+"";
						}
						else {
							name = "Count and Time Spent between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText();
							dataset = null;
							dataset = new DefaultPieDataset();	    
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
							pstatement = connection.prepareStatement("select visitor_stream, COUNT(visitor_stream) from visitors WHERE visit_status ='come' and visit_date between ? and ? GROUP BY visitor_stream");
							pstatement.setString(1, datePicker.getJFormattedTextField().getText());
							pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
							myResultSet = pstatement.executeQuery();
							while(myResultSet.next()) {
								dataset.setValue(myResultSet.getString(1),myResultSet.getLong(2));
							}
							pstatement = connection.prepareStatement("select time_spent from visitors WHERE time_spent is not null and visit_date between ? and ?");
							pstatement.setString(1, datePicker.getJFormattedTextField().getText());
							pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
							myResultSet = pstatement.executeQuery();
							while(myResultSet.next()) {
								addTime(myResultSet.getString(1));
							}
							count = new VisitorsDaoImpl().getAllVisitorsCountBYComeDate(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText())+"";
							pLabel1.removeAll();
							frame.remove(pLabel1);


							frame.revalidate();
							frame.repaint();
						}
					}catch(Exception e1) {
						name = "Count and Time Spent between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText();
						dataset=null;
						dataset = new DefaultPieDataset();
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
						pstatement = connection.prepareStatement("select visitor_stream, COUNT(visitor_stream) from visitors WHERE visit_status ='come' and visit_date between ? and ? GROUP BY visitor_stream");
						pstatement.setString(1, datePicker.getJFormattedTextField().getText());
						pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
						myResultSet = pstatement.executeQuery();
						while(myResultSet.next()) {
							dataset.setValue(myResultSet.getString(1),myResultSet.getLong(2));
						}
						pstatement = connection.prepareStatement("select time_spent from visitors WHERE time_spent is not null and visit_date between ? and ?");
						pstatement.setString(1, datePicker.getJFormattedTextField().getText());
						pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
						myResultSet = pstatement.executeQuery();
						while(myResultSet.next()) {
							addTime(myResultSet.getString(1));
						}
						count = new VisitorsDaoImpl().getAllVisitorsCountBYComeDate(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText())+"";
						pLabel1.removeAll();
						frame.remove(pLabel1);
						pLabel1.add(field,gbc);
						frame.revalidate();
						frame.repaint();
					}

					hr = hr + (min / 60);
					min = min % 60;

					JPanel label1 = new JPanel();
					JFreeChart chart = ChartFactory.createRingChart(name+"\nTotal Time Spent : "+ hr + " h " + min + " min " + sec + " s", dataset, true, true, false);
					hr = min = sec = 0;

					RingPlot pie = (RingPlot) chart.getPlot();
					pie.setBackgroundPaint(new Color(0,0,0,0));
					pie.setOutlineVisible(false);
					pie.setShadowPaint(null);
					pie.setNoDataMessage("No Data To Show");
					pie.setSimpleLabels(true);
					pie.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));
					Font font = new Font(Font.DIALOG, Font.BOLD, 30);
					pie.setCenterTextColor(new Color(0,0,0));
					pie.setCenterTextMode(CenterTextMode.FIXED);
					pie.setCenterText(count);
					pie.setCenterTextFont(font);
					pie.setSimpleLabelOffset(new RectangleInsets(
							UnitType.RELATIVE, 0.09, 0.09, 0.09, 0.09));//boundary label
					pie.setLabelBackgroundPaint(null);
					pie.setLabelOutlinePaint(null);
					pie.setLabelShadowPaint(null);
					pie.setSectionDepth(0.36);//circle boundary
					pie.setSectionOutlinesVisible(false);
					pie.setSeparatorsVisible(false);
					pie.setIgnoreZeroValues(true);

					Font customFont = new Font("Verdana", Font.PLAIN, 9);
					chart.getLegend().setFrame(BlockBorder.NONE);
					chart.getLegend().setItemFont(customFont);
					chart.getTitle().setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
					BufferedImage icon = null;
					try {
						icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
					} catch (IOException e1) {}
					Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
					pie.setBackgroundPaint( trans );
					pie.setBackgroundImage(icon);
					pie.setBackgroundImageAlpha(0.5f);
					pie.setBackgroundImageAlignment(Align.CENTER);
					label1.add(new ChartPanel(chart){
						@Override
						public Dimension getPreferredSize() {
							return new Dimension(300, 312);
						}
					});
					label1.setBackground(new Color(254,254,254));
					w.setVisible(false);


					Download = new JButton("Download");
					Download.setBackground(Color.decode("#ffffe0"));
					Download.setPreferredSize(new Dimension(120,20));
					Download.setFont(new Font("Verdana", Font.BOLD, 12));
					pLabel1.add(field,gbc);
					pLabel1.add(label1,gbc);
					pLabel1.add(Download,gbc);
					pLabel1.add(add1,gbc);
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
								BufferedImage chartImage = chart.createBufferedImage(300,312);
								try {
									JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
									Files.createDirectories(Paths.get(path+"\\"+name));						
								} catch (IOException e1) {
									w.setVisible(false);
									String s = new String("Directory Creation Failed...<br>Please Try Again...");
									Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
									t.showtoast();
								}
								File summaryChartFile = new File(path+"\\"+name+"\\"+"A_"+name+".png");
								try (OutputStream out = new FileOutputStream(summaryChartFile)) {
									ImageIO.write(chartImage, "png", out);
								} catch (IOException e1) {
									w.setVisible(false);
									String s = new String("Failed Writing Image...<br>Please Try Again...");
									Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
									t.showtoast();
								}
								w.setVisible(false);
							}
						}
					});
					add1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							try{
								JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
								callAddSpace(5);
								com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart.createBufferedImage(300,312),null);
								img1.setAlignment(Element.ALIGN_CENTER);
								document.add(img1);
								w.setVisible(false);
							}
							catch(Exception e1) {w.setVisible(false);}
						}
					});
					frame.revalidate();
					frame.repaint();


				}catch(Exception exception) {
					pLabel1.removeAll();
					frame.remove(pLabel1);
					pLabel1.add(field,gbc);
					frame.revalidate();
					frame.repaint();

				}
				if(!hope) {
					add1.show();
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
				} 
			}

		});




		pLabel2 = new JPanel(new BorderLayout());
		pLabel2.setPreferredSize(new Dimension(1000, 390));
		pLabel2.setBackground(new Color(254,254,254));
		pLabel2.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel2.add(callDatePickers(2,frame),"North");
		Font font = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text2 = "This Section Demonstrates The Overall Visits And Count" + "<br>" + "<br>" +
				"Of All The Visitors On Each Date In The Form Of TimeLine";
		JLabel desc2 = new JLabel("<html><div style='text-align: center;'>" + text2 + "</div></html>");
		desc2.setFont(font);
		desc2.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc2.setForeground(Color.decode("#00a4bd"));
		desc2.setPreferredSize(new Dimension(990,340));
		desc2.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel2.add(desc2);






		JPanel panel2 = new JPanel();
		student_details = new JLabel(new ImageIcon(this.getClass().getResource("/studentsearch.png")));
		student_details.setPreferredSize(new Dimension(312, 390));
		student_details.setBackground(new Color(254,254,254));
		student_details.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		student_details.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				StudentDetails sd = new StudentDetails();
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				student_details.setBorder(BorderFactory.createLineBorder(new Color(12,117,210)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				student_details.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
			}

		});



		pLabel3 = new JPanel(new BorderLayout());
		pLabel3 = new JPanel(new BorderLayout());
		pLabel3.setPreferredSize(new Dimension(1000, 390));
		pLabel3.setBackground(new Color(254,254,254));
		pLabel3.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel3.add(callDatePickers(3,frame),"North");
		Font font3 = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text3 = "This Section Demonstrates The Overall Count For" + "<br>" + "<br>" +
				"The Most Visited Month Of All Time By Visitors";
		JLabel desc3 = new JLabel("<html><div style='text-align: center;'>" + text3 + "</div></html>");
		desc3.setFont(font3);
		desc3.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc3.setForeground(Color.decode("#00a4bd"));
		desc3.setPreferredSize(new Dimension(990,340));
		desc3.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel3.add(desc3);

		JPanel panel3 = new JPanel();
		pLabel4 = new JPanel(new BorderLayout());
		pLabel4 = new JPanel(new BorderLayout());
		pLabel4.setPreferredSize(new Dimension(650, 350));
		pLabel4.setBackground(new Color(254,254,254));
		pLabel4.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel4.add(callDatePickers(4,frame),"North");
		Font font4 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text4 = "This Section Demonstrates The Overall Count Of Visitors" + "<br>" + "<br>" +
				"On Each Month Of Each Year As Per In Record " + "<br>" + "<br>" +
				"In The Form Of Timeline";
		JLabel desc4 = new JLabel("<html><div style='text-align: center;'>" + text4 + "</div></html>");
		desc4.setFont(font4);
		desc4.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc4.setForeground(Color.decode("#00a4bd"));
		desc4.setPreferredSize(new Dimension(990,340));
		desc4.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel4.add(desc4);

		pLabel5 = new JPanel(new BorderLayout());
		pLabel5 = new JPanel(new BorderLayout());
		pLabel5.setPreferredSize(new Dimension(650, 350));
		pLabel5.setBackground(new Color(254,254,254));
		pLabel5.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel5.add(callDatePickers(5,frame),"North");
		Font font5 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text5 = "This Section Demonstrates The Overall Count For" + "<br>" + "<br>" +
				"The Most Visited Week Day Of All Time By Visitors" + "<br>" + "<br>" +
				"Total Time Spent" + "<br>" + "<br>" +
				"By Visitors";
		JLabel desc5 = new JLabel("<html><div style='text-align: center;'>" + text5 + "</div></html>");
		desc5.setFont(font5);
		desc5.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc5.setForeground(Color.decode("#00a4bd"));
		desc5.setPreferredSize(new Dimension(990,340));
		desc5.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel5.add(desc5);

		JPanel panel4 = new JPanel();
		pLabel6 = new JPanel(new BorderLayout());
		pLabel6 = new JPanel(new BorderLayout());
		pLabel6.setPreferredSize(new Dimension(650, 350));
		pLabel6.setBackground(new Color(254,254,254));
		pLabel6.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel6.add(callDatePickers(6,frame),"North");
		Font font6 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text6 = "This Section Demonstrates The Overall Count For" + "<br>" + "<br>" +
				"The Most Visited Hour Of All Time By Visitors";
		JLabel desc6 = new JLabel("<html><div style='text-align: center;'>" + text6 + "</div></html>");
		desc6.setFont(font6);
		desc6.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc6.setForeground(Color.decode("#00a4bd"));
		desc6.setPreferredSize(new Dimension(990,340));
		desc6.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel6.add(desc6);

		pLabel7 = new JPanel(new BorderLayout());
		pLabel7 = new JPanel(new BorderLayout());
		pLabel7.setPreferredSize(new Dimension(650, 350));
		pLabel7.setBackground(new Color(254,254,254));
		pLabel7.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel7.add(callDatePickers(7,frame),"North");
		Font font7 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text7 = "This Section Demonstrates The Overall Visits Of Visitors" + "<br>" + "<br>" +
				"In The Form Of TimeLine";
		JLabel desc7 = new JLabel("<html><div style='text-align: center;'>" + text7 + "</div></html>");
		desc7.setFont(font7);
		desc7.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc7.setForeground(Color.decode("#00a4bd"));
		desc7.setPreferredSize(new Dimension(990,340));
		desc7.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel7.add(desc7);

		JPanel panel5 = new JPanel();
		pLabel8 = new JPanel(new BorderLayout());
		pLabel8 = new JPanel(new BorderLayout());
		pLabel8.setPreferredSize(new Dimension(550, 350));
		pLabel8.setBackground(new Color(254,254,254));
		pLabel8.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel8.add(callDatePickers(8,frame),"North");
		Font font8 = new Font("Verdana", Font.PLAIN|Font.BOLD, 18);
		String text8 = "This Section Demonstrates The Overall Count" + "<br>" + "<br>" +
				"Of Visitors In Each Year As Per In Record";
		JLabel desc8 = new JLabel("<html><div style='text-align: center;'>" + text8 + "</div></html>");
		desc8.setFont(font8);
		desc8.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc8.setForeground(Color.decode("#00a4bd"));
		desc8.setPreferredSize(new Dimension(990,340));
		desc8.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel8.add(desc8);

		pLabel9 = new JPanel(new BorderLayout());
		pLabel9 = new JPanel(new BorderLayout());
		pLabel9.setPreferredSize(new Dimension(750, 350));
		pLabel9.setBackground(new Color(254,254,254));
		pLabel9.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel9.add(callDatePickers(9,frame),"North");
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

		JPanel panel_ex = new JPanel();
		pLabel_ex = new JPanel(new BorderLayout());
		pLabel_ex.setPreferredSize(new Dimension(1300, 600));
		pLabel_ex.setBackground(new Color(254,254,254));
		pLabel_ex.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel_ex.add(callDatePickers(39,frame),"North");
		Font font_ex = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text_ex = "This Section Demonstrates The Overall Visits And Count" + "<br>" + "<br>" +
				"Of All The Visitors As Per Selection Of Options Made";
		JLabel desc_ex = new JLabel("<html><div style='text-align: center;'>" + text_ex + "</div></html>");
		desc_ex.setFont(font_ex);
		desc_ex.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc_ex.setForeground(Color.decode("#00a4bd"));
		desc_ex.setPreferredSize(new Dimension(1250,550));
		desc_ex.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel_ex.add(desc_ex);

		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);

		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		panel_ex.setBackground(Color.white);
		pLabel2.setBackground(Color.white);

		student_details.setBackground(Color.white);
		pLabel3.setBackground(Color.white);
		pLabel4.setBackground(Color.white);
		pLabel5.setBackground(Color.white);
		pLabel6.setBackground(Color.white);
		pLabel7.setBackground(Color.white);
		pLabel8.setBackground(Color.white);
		pLabel9.setBackground(Color.white);
		pLabel_ex.setBackground(Color.white);

		panel1.add(pLabel1);
		panel1.add(pLabel2);

		panel2.add(student_details);
		panel2.add(pLabel3);
		panel3.add(pLabel4);
		panel3.add(pLabel5);
		panel4.add(pLabel6);
		panel4.add(pLabel7);
		panel5.add(pLabel8);
		panel5.add(pLabel9);
		panel_ex.add(pLabel_ex);

		panel.add(panel1,gbc);
		panel.add(panel2,gbc);

		panel.add(panel3,gbc);
		panel.add(panel4,gbc);
		panel.add(panel5,gbc);
		panel.add(panel_ex,gbc);

		frame.getContentPane().add(new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		frame.setVisible(true);
	}

	private Component callDatePickers(int no, JFrame frame) {
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
		if(no==39) {
			model0 = model39;
			model00 = model93;
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
					createpLabel2(frame,datePicker, datePicker1);


				}
				if(no == 3){
					pLabel3.removeAll();
					frame.remove(pLabel3);
					createpLabel3(frame,datePicker, datePicker1);
				}
				if(no == 4){
					pLabel4.removeAll();
					frame.remove(pLabel4);
					createpLabel4(frame,datePicker, datePicker1);
				}
				if(no == 5){
					pLabel5.removeAll();
					frame.remove(pLabel5);
					createpLabel5(frame,datePicker, datePicker1);
				}
				if(no == 6){
					pLabel6.removeAll();
					frame.remove(pLabel6);
					createpLabel6(frame,datePicker, datePicker1);
				}
				if(no == 7){
					pLabel7.removeAll();
					frame.remove(pLabel7);
					createpLabel7(frame,datePicker, datePicker1);
				}
				if(no == 8){
					pLabel8.removeAll();
					frame.remove(pLabel8);
					createpLabel8(frame,datePicker, datePicker1);
				}
				if(no == 39){
					pLabel_ex.removeAll();
					frame.remove(pLabel_ex);
					createpLabel39(frame,datePicker, datePicker1);
				}

				if(no == 9){
					pLabel9.removeAll();
					frame.remove(pLabel9);
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Permission For Access Accepted...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
					createpLabel9(frame,datePicker, datePicker1);
					w.setVisible(false);
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
		if(no == 39) {
			add_ex = new JButton("Add");
			add_ex.setBackground(Color.decode("#ffffe0"));
			add_ex.setPreferredSize(new Dimension(60,20));
			add_ex.setFont(new Font("Verdana", Font.BOLD, 9));
			add_ex.hide();
			field.add(add_ex);

			String graph[]={"Vertical Bar Chart","Line Chart"};  

			graph_ex =new JComboBox(graph);    
			graph_ex.setPreferredSize(new Dimension(130,20));
			field.add(graph_ex);

			int row=0;
			String classy3[] = new String[new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size()];
			for(int  i = 0 ; i < new VisitorsDaoImpl().getClassy().size(); i++){
				for(int  j = 0 ; j < new VisitorsDaoImpl().getStreams().size(); j++){
					classy3[row] = new VisitorsDaoImpl().getClassy().get(i).toString()+" "+new VisitorsDaoImpl().getStreams().get(j).toString();
					row++;
				}
			}
			Object[] classy4 = classy3;
			Object[] classy = new VisitorsDaoImpl().getClassy().toArray();
			Object[] classy2 = new VisitorsDaoImpl().getStreams().toArray();

			String Classy[] = new String[3+new VisitorsDaoImpl().getClassy().size()+new VisitorsDaoImpl().getStreams().size()+(new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size())];
			for(int i=0;i<Classy.length-3 ;i++) {
				if(i<=new VisitorsDaoImpl().getClassy().size()-1) {
					Classy[i] = classy[i].toString();
				}
				if(i>new VisitorsDaoImpl().getClassy().size()-1 & i<=(new VisitorsDaoImpl().getClassy().size()+new VisitorsDaoImpl().getStreams().size())-1) {
					Classy[i] = classy2[i-classy.length].toString();
				}
				if(i>=(new VisitorsDaoImpl().getClassy().size()+new VisitorsDaoImpl().getStreams().size())) {
					Classy[i] = classy4[i-(classy.length+classy2.length)].toString();
				}
			}
			Classy[new VisitorsDaoImpl().getClassy().size()+new VisitorsDaoImpl().getStreams().size()+(new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size())+3-3]="All Class";
			Classy[new VisitorsDaoImpl().getClassy().size()+new VisitorsDaoImpl().getStreams().size()+(new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size())+3-2]="All Stream";
			Classy[new VisitorsDaoImpl().getClassy().size()+new VisitorsDaoImpl().getStreams().size()+(new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size())+3-1]="All Class & Stream";

			classy_ex = new JComboBox(Classy); 
			classy_ex.setPreferredSize(new Dimension(150,20));
			field.add(classy_ex);


			Object[] stream = new VisitorsDaoImpl().getStreams().toArray();
			String Stream[] = new String[4];
			Stream[0] = "Day";
			Stream[1] = "Week";
			Stream[2] = "Month";
			Stream[3] = "Year";


			service_ex =new JComboBox(Stream);    
			service_ex.setPreferredSize(new Dimension(90,20));
			field.add(service_ex);

		}
		if(no ==9) {
			inout = new JButton();
			inout.setText("In Out");
			inout.setBackground(Color.decode("#ffffe0"));
			inout.setPreferredSize(new Dimension(70,20));
			inout.setFont(new Font("Verdana", Font.BOLD, 9));
			field.add(inout);

			sort = new JButton();
			sort.setText("Class");
			sort.setBackground(Color.decode("#ffffe0"));
			sort.setPreferredSize(new Dimension(60,20));
			sort.setFont(new Font("Verdana", Font.BOLD, 9));
			field.add(sort);

			add9 = new JButton("Add");
			add9.setBackground(Color.decode("#ffffe0"));
			add9.setPreferredSize(new Dimension(60,20));
			add9.setFont(new Font("Verdana", Font.BOLD, 9));
			add9.hide();
			field.add(add9);

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
			add1.show();
			add2.show();
			add3.show();
			add4.show();
			add5.show();
			add6.show();
			add7.show();
			add8.show();
			add9.show();
			add_ex.show();
		}
		return field;
	}

	private void createpLabel2(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		pLabel2.add(callDatePickers(2,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorRecord().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chart2 = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max2=new VisitorsDaoImpl().getAllDayWiseVisitorRecord().size();
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
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart2 = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max2=new VisitorsDaoImpl().getAllDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart2 = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			max2=new VisitorsDaoImpl().getAllDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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

		chart2.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart2.getPlot();
		//      plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(220,230,240));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(220,230,240));
		plot.setRangeGridlineStroke(new BasicStroke(0.2f));
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
		chart2.getTitle().setFont(customFont);
		chart2.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chart2.setBackgroundImage(icon);
		chart2.setBackgroundImageAlpha(0.5f);
		chart2.setBackgroundImageAlignment(Align.TOP_LEFT);
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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller2.setValue(0);
					while(count < max2) {
						BufferedImage chartImage = chart2.createBufferedImage(1000,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"B_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller2.setValue(count);
					}
					w.setVisible(false);
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

	private void createpLabel3(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel3.add(callDatePickers(3,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {

				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"All Time Visits", o[0].toString());
				}

				dataset3 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart3 = ChartFactory.createLineChart("", "Most Visited Month Of All Time", "Student FootFall Count",
						dataset3, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max3=new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord().size();
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
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"All Time Visits", o[0].toString());
				}

				dataset3 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart3 = ChartFactory.createLineChart("", "Most Visited Month Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
						dataset3, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max3=new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"All Time Visits", o[0].toString());
			}

			dataset3 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart3 = ChartFactory.createLineChart("", "Most Visited Month Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
					dataset3, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			max3=new VisitorsDaoImpl().getCombinedMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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

		chart3.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart3.getPlot();
		//	      plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(200,150,220));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(200,150,220));
		plot.setRangeGridlineStroke(new BasicStroke(0.2f));
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
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chart3.setBackgroundImage(icon);
		chart3.setBackgroundImageAlpha(0.5f);
		chart3.setBackgroundImageAlignment(Align.TOP_LEFT);
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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller3.setValue(0);
					while(count < max3) {
						BufferedImage chartImage = chart3.createBufferedImage(1000,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"C_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller3.setValue(count);
					}
					w.setVisible(false);
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
	//    
	private void createpLabel4(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel4.add(callDatePickers(4,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthlyVisitorRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthlyVisitorRecord().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],"FootFall",o[1].toString()+" "+o[0].toString());
				}

				dataset4 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart4 = ChartFactory.createLineChart("", "Months TimeLine", "Student FootFall Count",
						dataset4, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max4=new VisitorsDaoImpl().getAllMonthlyVisitorRecord().size();
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
				// TODO Auto-generated method stub
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],"FootFall",o[1].toString()+" "+o[0].toString());
				}
				dataset4 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart4 = ChartFactory.createLineChart("", "Months TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
						dataset4, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max4=new VisitorsDaoImpl().getAllMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
		}catch(Exception e1) {
			// TODO Auto-generated method stub
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],"FootFall",o[1].toString()+" "+o[0].toString());
			}

			dataset4 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart4 = ChartFactory.createLineChart("", "Months TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(),"Student FootFall Count",
					dataset4, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			max4=new VisitorsDaoImpl().getAllMonthlyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller4.setValue(0);
					while(count < max4) {
						BufferedImage chartImage = chart4.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"D_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller4.setValue(count);
					}
					w.setVisible(false);
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
	private void createpLabel5(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel5.add(callDatePickers(5,frame),"North");
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentWeekly().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentWeekly().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}		

				dataset5 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart5 = ChartFactory.createBarChart("", "Most Visited Week Days Of All Time", "Student FootFall Count",
						dataset5, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max5=new VisitorsDaoImpl().getStudentWeekly().size();
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
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentWeekly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentWeekly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}		

				dataset5 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart5 = ChartFactory.createBarChart("", "Most Visited Week Days Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
						dataset5, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max5=new VisitorsDaoImpl().getStudentWeekly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentWeekly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getStudentWeekly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
			}		

			dataset5 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart5 = ChartFactory.createBarChart("", "Most Visited Week Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
					dataset5, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			max5=new VisitorsDaoImpl().getStudentWeekly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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

		chart5.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart5.getPlot();
		//	      plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(220,230,240));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(220,230,240));
		plot.setRangeGridlineStroke(new BasicStroke(0.2f));
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
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chart5.setBackgroundImage(icon);
		chart5.setBackgroundImageAlpha(0.5f);
		chart5.setBackgroundImageAlignment(Align.TOP_RIGHT);

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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller5.setValue(0);
					while(count < max5) {
						BufferedImage chartImage = chart5.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"E_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller5.setValue(count);
					}
					w.setVisible(false);
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
	private void createpLabel6(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel6.add(callDatePickers(6,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentHourly().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentHourly().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				} 

				dataset6 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart6 = ChartFactory.createLineChart("", "Most Visited Hour Of All Time", "Student FootFall Count",
						dataset6, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max6=new VisitorsDaoImpl().getStudentHourly().size();
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
				// TODO Auto-generated method stub
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentHourly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentHourly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				} 

				dataset6 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart6 = ChartFactory.createLineChart("", "Most Visited Hour Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
						dataset6, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max6=new VisitorsDaoImpl().getStudentHourly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
		}catch(Exception e1) {
			// TODO Auto-generated method stub
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentHourly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getStudentHourly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
			} 

			dataset6 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart6 = ChartFactory.createLineChart("", "Most Visited Hour Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
					dataset6, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			max6=new VisitorsDaoImpl().getStudentHourly(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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

		chart6.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart6.getPlot();
		//	      plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(200,150,200));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(200,150,200));
		plot.setRangeGridlineStroke(new BasicStroke(0.2f));
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
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chart6.setBackgroundImage(icon);
		chart6.setBackgroundImageAlpha(0.5f);
		chart6.setBackgroundImageAlignment(Align.TOP_LEFT);
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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller6.setValue(0);
					while(count < max6) {
						BufferedImage chartImage = chart6.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"F_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller6.setValue(count);
					}
					w.setVisible(false);
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
	private void createpLabel7(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel7.add(callDatePickers(7,frame),"North");
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

				myResultSet = statement.executeQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
				while(myResultSet.next()) {
					dataset1.addValue(myResultSet.getLong(3),"FootFall",myResultSet.getString(1)+" "+myResultSet.getString(2));
				}

				dataset7 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart7 = ChartFactory.createLineChart("", "TimeLine", "24 Hour Time Format",
						dataset7, PlotOrientation.VERTICAL, true, false, false);
				int e=0;
				max7=new VisitorsDaoImpl().getAllTimelyVisitorRecord().size();
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
				pstatement = connection.prepareStatement("SELECT visit_date, visit_time, HOUR(visit_time) FROM visitors WHERE visit_status ='come' AND visit_date BETWEEN ? AND ? GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
				pstatement.setString(1, datePicker.getJFormattedTextField().getText());
				pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
				myResultSet = pstatement.executeQuery();
				while(myResultSet.next()) {
					dataset1.addValue(myResultSet.getLong(3),"FootFall",myResultSet.getString(1)+" "+myResultSet.getString(2));
				}
				//                List<Object[]> object = new ArrayList<Object[]>();
				//        		for(int  i = 0 ; i < new VisitorsDaoImpl().getAllTimelyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				//        			object.add(i, (Object[]) new VisitorsDaoImpl().getAllTimelyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				//        		}
				//
				//        		for(Object[] o:object) {
				//        			dataset1.addValue((Number) o[2],"FootFall",o[0].toString()+" "+o[1].toString());
				//        		} 

				dataset7 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart7 = ChartFactory.createLineChart("", "TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "24 Hour Time Format",
						dataset7, PlotOrientation.VERTICAL, true, false, false);
				int e=0;
				max7=new VisitorsDaoImpl().getAllTimelyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllTimelyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllTimelyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],"FootFall",o[0].toString()+" "+o[1].toString());
			} 

			dataset7 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart7 = ChartFactory.createLineChart("", "TimeLine Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "24 Hour Time Format",
					dataset7, PlotOrientation.VERTICAL, true, false, false);
			int e=0;
			max7=new VisitorsDaoImpl().getAllTimelyVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller7.setValue(0);
					while(count < max7) {
						BufferedImage chartImage = chart7.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"G_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller7.setValue(count);
					}
					w.setVisible(false);
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
	private void createpLabel8(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel8.add(callDatePickers(8,frame),"North");
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentGrouply().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentGrouply().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				} 
				dataset8 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart8 = ChartFactory.createLineChart("", "Years", "Student FootFall Count",
						dataset8, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max8=new VisitorsDaoImpl().getStudentGrouply().size();
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
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentGrouply(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getStudentGrouply(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				} 
				dataset8 = new SlidingCategoryDataset(dataset1, 0, 20);
				chart8 = ChartFactory.createLineChart("", "Years Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
						dataset8, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				max8=new VisitorsDaoImpl().getStudentGrouply(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getStudentGrouply(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getStudentGrouply(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
			} 
			dataset8 = new SlidingCategoryDataset(dataset1, 0, 20);
			chart8 = ChartFactory.createLineChart("", "Years Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Student FootFall Count",
					dataset8, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			max8=new VisitorsDaoImpl().getStudentGrouply(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
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
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller8.setValue(0);
					while(count < max8) {
						BufferedImage chartImage = chart8.createBufferedImage(660,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"H_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed Writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
						scroller8.setValue(count);
					}
					w.setVisible(false);
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


	private void createpLabel39(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		c_selected = false;
		s_selected = false;
		c_s_selected = false;
		class_Selected = false;
		stream_selected = false;
		class_stream_selected = false;
		d_selected = false;
		w_selected = false;
		m_selected = false;
		y_selected = false;
		bar_chart = false;
		line_chart =false;

		String class_arr[] = new String[new VisitorsDaoImpl().getClassy().size()];
		String stream_arr[] = new String[new VisitorsDaoImpl().getStreams().size()];
		String class_stream_arr[] = new String[new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size()];

		for(int i = 0 ; i < class_arr.length ; i++) {
			class_arr[i] = new VisitorsDaoImpl().getClassy().get(i).toString();
		}
		for(int i = 0 ; i < stream_arr.length ; i++) {
			stream_arr[i] = new VisitorsDaoImpl().getStreams().get(i).toString();
		}
		int row = 0;
		for(int i = 0 ; i < class_arr.length ; i++) {
			for(int j = 0 ; j < stream_arr.length ; j++) {
				class_stream_arr[row] = new VisitorsDaoImpl().getClassy().get(i).toString()+" "+new VisitorsDaoImpl().getStreams().get(j).toString();
				row++;
			}
		}

		//nothing selected
		if(c_selected == false &
				s_selected == false &
				c_s_selected == false &
				class_Selected == false &
				stream_selected == false &
				class_stream_selected == false &
				d_selected == false &
				w_selected == false &
				m_selected == false &
				y_selected == false &
				bar_chart == false &
				line_chart == false) {

			c_selected = true;
			s_selected = false;
			c_s_selected = false;
			class_Selected = false;
			stream_selected = false;
			class_stream_selected = false;
			d_selected = true;
			w_selected = false;
			m_selected = false;
			y_selected = false;
			bar_chart = true;
			line_chart = false;

			call_c_d_d_selected(frame, datePicker, datePicker1);
		}
		graph_ex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(graph_ex.getSelectedIndex() == 0) {
					bar_chart = true;
					line_chart= false;
				}
				if(graph_ex.getSelectedIndex() == 1) {
					bar_chart = false;
					line_chart= true;
				}
				if(c_selected == true & d_selected == true) {
					call_c_d_selected(frame, datePicker, datePicker1);
				}
				if(c_selected == true & w_selected == true) {
					call_c_w_selected(frame, datePicker, datePicker1);
				}
				if(c_selected == true & m_selected == true) {
					call_c_m_selected(frame, datePicker, datePicker1);
				}
				if(c_selected == true & y_selected == true) {
					call_c_y_selected(frame, datePicker, datePicker1);
				}
				if(s_selected == true & d_selected == true) {
					call_s_d_selected(frame, datePicker, datePicker1);
				}
				if(s_selected == true & w_selected == true) {
					call_s_w_selected(frame, datePicker, datePicker1);
				}
				if(s_selected == true & m_selected == true) {
					call_s_m_selected(frame, datePicker, datePicker1);
				}
				if(s_selected == true & y_selected == true) {
					call_s_y_selected(frame, datePicker, datePicker1);
				}
				if(c_s_selected == true & d_selected == true) {
					call_c_s_d_selected(frame, datePicker, datePicker1);
				}
				if(c_s_selected == true & w_selected == true) {
					call_c_s_w_selected(frame, datePicker, datePicker1);
				}
				if(c_s_selected == true & m_selected == true) {
					call_c_s_m_selected(frame, datePicker, datePicker1);
				}
				if(c_s_selected == true & y_selected == true) {
					call_c_s_y_selected(frame, datePicker, datePicker1);
				}
				if(class_Selected == true & d_selected == true) {
					call_class_d_selected(frame, datePicker, datePicker1);
				}
				if(class_Selected == true & w_selected == true) {
					call_class_w_selected(frame, datePicker, datePicker1);
				}
				if(class_Selected == true & m_selected == true) {
					call_class_m_selected(frame, datePicker, datePicker1);
				}
				if(class_Selected == true & y_selected == true) {
					call_class_y_selected(frame, datePicker, datePicker1);
				}
				if(stream_selected == true & d_selected == true) {
					call_stream_d_selected(frame, datePicker, datePicker1);
				}
				if(stream_selected == true & w_selected == true) {
					call_stream_w_selected(frame, datePicker, datePicker1);
				}
				if(stream_selected == true & m_selected == true) {
					call_stream_m_selected(frame, datePicker, datePicker1);
				}
				if(stream_selected == true & y_selected == true) {
					call_stream_y_selected(frame, datePicker, datePicker1);
				}
				if(class_stream_selected == true & d_selected == true) {
					call_class_stream_d_selected(frame, datePicker, datePicker1);
				}
				if(class_stream_selected == true & w_selected == true) {
					call_class_stream_w_selected(frame, datePicker, datePicker1);
				}
				if(class_stream_selected == true & m_selected == true) {
					call_class_stream_m_selected(frame, datePicker, datePicker1);
				}
				if(class_stream_selected == true & y_selected == true) {
					call_class_stream_y_selected(frame, datePicker, datePicker1);
				}

			}

		});
		classy_ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acteve) {
				// TODO Auto-generated method stuff
				if(Arrays.asList(class_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					c_selected = true;
					s_selected = false;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = false;

					if(c_selected == true & d_selected == true) {
						call_c_d_selected(frame, datePicker, datePicker1);
					}
					if(c_selected == true & w_selected == true) {
						call_c_w_selected(frame, datePicker, datePicker1);
					}
					if(c_selected == true & m_selected == true) {
						call_c_m_selected(frame, datePicker, datePicker1);
					}
					if(c_selected == true & y_selected == true) {
						call_c_y_selected(frame, datePicker, datePicker1);
					}
				}
				if(Arrays.asList(stream_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					c_selected = false;
					s_selected = true;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = false;

					if(s_selected == true & d_selected == true) {
						call_s_d_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & w_selected == true) {
						call_s_w_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & m_selected == true) {
						call_s_m_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & y_selected == true) {
						call_s_y_selected(frame, datePicker, datePicker1);
					}
				}
				if(Arrays.asList(class_stream_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					c_selected = false;
					s_selected = false;
					c_s_selected = true;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = false;

					if(c_s_selected == true & d_selected == true) {
						call_c_s_d_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & w_selected == true) {
						call_c_s_w_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & m_selected == true) {
						call_c_s_m_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & y_selected == true) {
						call_c_s_y_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Class")) {
					c_selected = false;
					s_selected = false;
					c_s_selected = false;
					class_Selected = true;
					stream_selected = false;
					class_stream_selected = false;

					if(class_Selected == true & d_selected == true) {
						call_class_d_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & w_selected == true) {
						call_class_w_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & m_selected == true) {
						call_class_m_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & y_selected == true) {
						call_class_y_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Stream")) {
					c_selected = false;
					s_selected = false;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = true;
					class_stream_selected = false;

					if(stream_selected == true & d_selected == true) {
						call_stream_d_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & w_selected == true) {
						call_stream_w_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & m_selected == true) {
						call_stream_m_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & y_selected == true) {
						call_stream_y_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Class & Stream")) {
					c_selected = false;
					s_selected = false;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = true;

					if(class_stream_selected == true & d_selected == true) {
						call_class_stream_d_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & w_selected == true) {
						call_class_stream_w_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & m_selected == true) {
						call_class_stream_m_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & y_selected == true) {
						call_class_stream_y_selected(frame, datePicker, datePicker1);
					}
				}

			}});

		service_ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acteve) {
				// TODO Auto-generated method stub
				if(service_ex.getItemAt(service_ex.getSelectedIndex()).toString().equalsIgnoreCase("Day")) {
					d_selected = true;
					w_selected = false;
					m_selected = false;
					y_selected = false;

					if(c_selected == true & d_selected == true) {
						call_c_d_selected(frame, datePicker, datePicker1);
					}
					if(d_selected == true & s_selected == true) {
						call_s_d_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & d_selected == true) {
						call_class_d_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & d_selected == true) {
						call_stream_d_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & d_selected == true) {
						call_class_stream_d_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & d_selected == true) {
						call_c_s_d_selected(frame, datePicker, datePicker1);
					}
				} 
				if(service_ex.getItemAt(service_ex.getSelectedIndex()).toString().equalsIgnoreCase("Week")) {
					d_selected = false;
					w_selected = true;
					m_selected = false;
					y_selected = false;

					if(c_selected == true & w_selected == true) {
						call_c_w_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & w_selected == true) {
						call_s_w_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & w_selected == true) {
						call_c_s_w_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & w_selected == true) {
						call_class_w_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & w_selected == true) {
						call_stream_w_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & w_selected == true) {
						call_class_stream_w_selected(frame, datePicker, datePicker1);
					}
				}
				if(service_ex.getItemAt(service_ex.getSelectedIndex()).toString().equalsIgnoreCase("Month")) {
					d_selected = false;
					w_selected = false;
					m_selected = true;
					y_selected = false;

					if(c_selected == true & m_selected == true) {
						call_c_m_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & m_selected == true) {
						call_s_m_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & m_selected == true) {
						call_c_s_m_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & m_selected == true) {
						call_class_m_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & m_selected == true) {
						call_stream_m_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & m_selected == true) {
						call_class_stream_m_selected(frame, datePicker, datePicker1);
					}
				}
				if(service_ex.getItemAt(service_ex.getSelectedIndex()).toString().equalsIgnoreCase("Year")) {
					d_selected = false;
					w_selected = false;
					m_selected = false;
					y_selected = true;

					if(c_selected == true & y_selected == true) {
						call_c_y_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & y_selected == true) {
						call_s_y_selected(frame, datePicker, datePicker1);
					}
					if(c_s_selected == true & y_selected == true) {
						call_c_s_y_selected(frame, datePicker, datePicker1);
					}
					if(class_Selected == true & y_selected == true) {
						call_class_y_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & y_selected == true) {
						call_stream_y_selected(frame, datePicker, datePicker1);
					}
					if(class_stream_selected == true & y_selected == true) {
						call_class_stream_y_selected(frame, datePicker, datePicker1);
					}
				}
			}});
		callCopyAdd(frame);
	}

	private void call_c_d_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.add(callDatePickers(39,frame),"North");
		chartpanel_ex =null;
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountDaywise(classy_ex.getItemAt(0).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountDaywise(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountDaywise(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}   
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(0).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountDaywise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountDaywise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountDaywise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}   
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_s_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountDaywise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountDaywise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountDaywise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}   
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_w_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountWeekwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountWeekwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountWeekwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_s_w_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountWeekwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountWeekwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountWeekwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountMonthwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountMonthwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountMonthwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}   
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_s_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountMonthwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountMonthwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountMonthwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_y_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountYearwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountYearwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassCountYearwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}   
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_s_y_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountYearwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountYearwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitStreamCountYearwise(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 6;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountDaywise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorClassRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorClassRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount().intValue();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountDaywise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()); 
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).intValue();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsClassCountDaywise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()); 
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).intValue();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_w_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 6;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountWeekwise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorClassRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorClassRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else{
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountWeekwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsClassCountWeekwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 6;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountMonthwise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorClassRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorClassRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountMonthwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsClassCountMonthwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_y_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 6;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountYearwise();
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorClassRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorClassRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsClassCountYearwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsClassCountYearwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_stream_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 5;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountDaywise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount().intValue();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountDaywise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).intValue();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsStreamCountDaywise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); 
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).intValue();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_stream_w_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 5;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountWeekwise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountWeekwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsStreamCountWeekwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); 
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),"Week "+o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_stream_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 5;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountMonthwise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Month", "Month", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Month", "Month", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountMonthwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsStreamCountMonthwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); 
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_stream_y_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 5;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountYearwise();
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsStreamCountYearwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsStreamCountYearwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); 
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_stream_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 4;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range=new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountDaywise();
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorClassStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorClassStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount().intValue();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range=new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountDaywise2(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).intValue();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range=new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountDaywise2(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}
			catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCount(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).intValue();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_stream_w_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 4;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountWeekwise();
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorClassStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorClassStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountWeekwise2(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountWeekwise2(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}
			catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),"Week "+o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountWeek(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_stream_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 4;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountMonthwise();
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorClassStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorClassStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[4],o[2].toString()+" "+o[3].toString(),o[0].toString()+" "+o[1].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountMonthwise2(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[4],o[2].toString()+" "+o[3].toString(),o[0].toString()+" "+o[1].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountMonthwise2(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}
			catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[4],o[2].toString()+" "+o[3].toString(),o[0].toString()+" "+o[1].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountMonth(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_class_stream_y_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 4;
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountYearwise();
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorClassStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorClassStreamRecord().get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear().size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountYearwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				}
				catch(Exception e) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountYearwise(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
			}
			catch(Exception e) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllVisitorsVisitDateCountYear(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_s_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		int row = 0;
		String classy3[] = new String[new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size()];
		String class_opt = "";
		String stream_opt = "";
		for(int  i = 0 ; i < new VisitorsDaoImpl().getClassy().size(); i++){
			for(int  j = 0 ; j < new VisitorsDaoImpl().getStreams().size(); j++) {
				classy3[row] = new VisitorsDaoImpl().getClassy().get(i).toString()+" "+new VisitorsDaoImpl().getStreams().get(j).toString();
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase(classy3[row].toString())){
					class_opt = new VisitorsDaoImpl().getClassy().get(i).toString();
					stream_opt = new VisitorsDaoImpl().getStreams().get(j).toString();
					break;
				}
				row++;
			}
		}
		try {			
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountDaywise(class_opt,stream_opt);

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates", "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountDaywise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

				}catch(Exception m) {
					w.hide();
				}

				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountDaywise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

			}catch(Exception m) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Dates between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Dates", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_s_w_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		int row = 0;
		String classy3[] = new String[new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size()];
		String class_opt = "";
		String stream_opt = "";
		for(int  i = 0 ; i < new VisitorsDaoImpl().getClassy().size(); i++){
			for(int  j = 0 ; j < new VisitorsDaoImpl().getStreams().size(); j++) {
				classy3[row] = new VisitorsDaoImpl().getClassy().get(i).toString()+" "+new VisitorsDaoImpl().getStreams().get(j).toString();
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase(classy3[row].toString())){
					class_opt = new VisitorsDaoImpl().getClassy().get(i).toString();
					stream_opt = new VisitorsDaoImpl().getStreams().get(j).toString();
					break;
				}
				row++;
			}
		}
		try {			
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountWeekwise(class_opt,stream_opt);

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks", "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountWeekwise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),"Week "+o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountWeekwise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

			}catch(Exception m) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),"Week "+o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Weeks between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Weeks", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllWeekWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_s_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		int row = 0;
		String classy3[] = new String[new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size()];
		String class_opt = "";
		String stream_opt = "";
		for(int  i = 0 ; i < new VisitorsDaoImpl().getClassy().size(); i++){
			for(int  j = 0 ; j < new VisitorsDaoImpl().getStreams().size(); j++) {
				classy3[row] = new VisitorsDaoImpl().getClassy().get(i).toString()+" "+new VisitorsDaoImpl().getStreams().get(j).toString();
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase(classy3[row].toString())){
					class_opt = new VisitorsDaoImpl().getClassy().get(i).toString();
					stream_opt = new VisitorsDaoImpl().getStreams().get(j).toString();
					break;
				}
				row++;
			}
		}
		try {			
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountMonthwise(class_opt,stream_opt);

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months", "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountMonthwise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountMonthwise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

			}catch(Exception m) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Months between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Months", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void call_c_s_y_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String s = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+s+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);
		pLabel_ex.remove(chartpanel_ex);
		scroller_ex.hide();
		v = 31;
		int row = 0;
		String classy3[] = new String[new VisitorsDaoImpl().getClassy().size()*new VisitorsDaoImpl().getStreams().size()];
		String class_opt = "";
		String stream_opt = "";
		for(int  i = 0 ; i < new VisitorsDaoImpl().getClassy().size(); i++){
			for(int  j = 0 ; j < new VisitorsDaoImpl().getStreams().size(); j++) {
				classy3[row] = new VisitorsDaoImpl().getClassy().get(i).toString()+" "+new VisitorsDaoImpl().getStreams().get(j).toString();
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase(classy3[row].toString())){
					class_opt = new VisitorsDaoImpl().getClassy().get(i).toString();
					stream_opt = new VisitorsDaoImpl().getStreams().get(j).toString();
					break;
				}
				row++;
			}
		}
		try {			
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountYearwise(class_opt,stream_opt);

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years", "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
			else {
				try {
					range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountYearwise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

				}catch(Exception m) {
					w.hide();
				}
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				for(Object[] o:object) {
					dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
				}
				dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

				if(bar_chart == true) {
					chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				else {
					chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
							dataset_ex, PlotOrientation.VERTICAL, true, true, false);
				}
				int e=0;
				max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
				if(max_ex > v) {
					e = v;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}else {
					e=max_ex;
					scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
				}
				if(max_ex < v) {
					scroller_ex.hide();
				}
			}
		}catch(Exception e1) {
			try {
				range = new VisitorsDaoImpl().getAllVisitorsVisitClassStreamCountYearwise(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());

			}catch(Exception m) {
				w.hide();
			}
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			for(Object[] o:object) {
				dataset1.addValue((Number) o[3],o[1].toString()+" "+o[2].toString(),o[0].toString());
			}
			dataset_ex = new SlidingCategoryDataset(dataset1, 0, v);

			if(bar_chart == true) {
				chart_ex = ChartFactory.createBarChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				chart_ex = ChartFactory.createLineChart("FootFall Count Of Visitors As Per Years between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText(), "Years", "Student FootFall Count",
						dataset_ex, PlotOrientation.VERTICAL, true, true, false);
			}
			int e=0;
			max_ex = new VisitorsDaoImpl().getAllYearWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size();
			if(max_ex > v) {
				e = v;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}else {
				e=max_ex;
				scroller_ex = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,max_ex);
			}
			if(max_ex < v) {
				scroller_ex.hide();
			}
		}
		if(bar_chart == true) {
			callChart(w);
		}
		else {
			callLineChart(w);
		}

		scroller_ex.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				dataset_ex.setFirstCategoryIndex(scroller_ex.getValue());
			}

		});
		pLabel_ex.add(scroller_ex,"South");         
		frame.revalidate();
		frame.repaint();
	}
	private void callCopyAdd(JFrame frame) {
		// TODO Auto-generated method stub
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 				
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					name = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller_ex.setValue(0);
					while(count < max_ex) {
						BufferedImage chartImage = chart_ex.createBufferedImage(800,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+name));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+name+"\\"+"B_"+name+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +v;
						scroller_ex.setValue(count);
					}
					w.setVisible(false);
				}
			}

		});
		add_ex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	

				try{
					callAddSpace(5);
					int count=0;
					scroller_ex.setValue(0);
					while(count < max_ex) {
						BufferedImage chartImage = chart_ex.createBufferedImage(1000,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chart_ex.createBufferedImage(1000,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						document.add(img1);
						callAddSpace(3);
						count = count +v;
						scroller_ex.setValue(count);
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
	}


	private void callChart(JWindow w) {
		// TODO Auto-generated method stub
		chart_ex.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart_ex.getPlot();
		//        plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(220,230,240));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(220,230,240));
		plot.setRangeGridlineStroke(new BasicStroke(0.2f));
		plot.setOutlineVisible(false);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(0,range+(range*0.5));
		rangeAxis.setRange(rangeData);
		BarRenderer renderer = (BarRenderer ) plot.getRenderer();
		renderer.setMaximumBarWidth(.03);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);

		String[] colorNames = {"red", "green", "blue", "yellow", "orange", "purple", "maroon", "silver", "turquoise", "magenta", "indigo", "salmon", "tan", "khaki", "beige", "peach", "sky blue", "lime green", "forest green", "chocolate", "crimson", "fuchsia", "ivory", "mustard", "plum", "rose", "rust", "sapphire", "scarlet", "sienna", "slate gray", "taupe", "thistle", "tomato red", "violet", "wheat", "zaffre"};
		int[][] rgbValues = {{255, 0, 0}, {0, 255, 0}, {0, 0, 255}, {255, 255, 0}, {255, 165, 0}, {128, 0, 128}, {128, 0, 0}, {192, 192, 192}, {64, 224, 208}, {255, 0, 255}, {75, 0, 130}, {250, 128, 114}, {210, 180, 140}, {245, 245, 220}, {135, 206, 235}, {50, 205, 50}, {34, 139, 34}, {210, 105, 30}, {220, 20, 60}, {255, 0, 255}, {255, 255, 240}, {255, 173, 0}, {221, 160, 221}, {139, 0, 139}, {188, 143, 143}, {0, 191, 255}, {255, 36, 0}, {160, 82, 45}, {112, 128, 144}, {138, 43, 226}, {205, 92, 92}, {160, 82, 45}, {112, 128, 144}, {128, 0, 0}, {216, 191, 216}, {255, 99, 71}, {238, 130, 238}, {255, 222, 173}, {0, 255, 127}, {245, 222, 179}};

		Color[] colors = new Color[colorNames.length];
		for (int i = 0; i < colorNames.length; i++) {
			colors[i] = new Color(rgbValues[i][0], rgbValues[i][1], rgbValues[i][2]);
		}

		for (int i = 0; i < colors.length; i++) {
			renderer.setSeriesPaint(i,colors[i]);
		}
		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		chart_ex.getLegend().setFrame(BlockBorder.NONE);
		chart_ex.getLegend().setPosition(RectangleEdge.RIGHT);
		chart_ex.getLegend().setBackgroundPaint(Color.white);
		chart_ex.getTitle().setFont(customFont);
		chart_ex.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);
		//   		  chart_ex.setBackgroundPaint(new GradientPaint(0, 0, new Color(254,230,247), 0,275, new Color(240,230,254)));
		//   		  chart_ex.setBackgroundPaint(new GradientPaint(0, 0, new Color(255,255,255), 0,275, new Color(255,255,255)));
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chart_ex.setBackgroundImage(icon);
		chart_ex.setBackgroundImageAlpha(0.5f);
		chart_ex.setBackgroundImageAlignment(Align.TOP_LEFT);
		chartpanel_ex = new ChartPanel(chart_ex);
		chartpanel_ex.setPreferredSize(new Dimension(1000, 350));
		w.setVisible(false);
		pLabel_ex.add(chartpanel_ex);

	}
	private void callLineChart(JWindow w) {
		// TODO Auto-generated method stub
		chart_ex.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chart_ex.getPlot();
		//        plot.setBackgroundPaint(Color.decode("#ffffe0"));

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(220,230,240));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(220,230,240));
		plot.setRangeGridlineStroke(new BasicStroke(1.0f));
		plot.setOutlineVisible(false);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setAutoRange(false);
		rangeAxis.setLowerBound(0);
		rangeAxis.setUpperBound(range);
		Range rangeData = rangeAxis.getRange();
		rangeData = new Range(0,range+(range*0.5));
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
		chart_ex.getLegend().setFrame(BlockBorder.NONE);
		chart_ex.getLegend().setPosition(RectangleEdge.RIGHT);
		//	     chart_ex.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chart_ex.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);

		//	     chart_ex.setBackgroundPaint(new GradientPaint(0, 0, new Color(254,230,247), 0,275, new Color(240,230,254)));
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}

		//		plot.setDomainGridlinesVisible(false);
		//		plot.setRangeGridlinesVisible(false);
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chart_ex.setBackgroundImage(icon);
		chart_ex.setBackgroundImageAlpha(0.5f);
		chart_ex.setBackgroundImageAlignment(Align.TOP_LEFT);
		chartpanel_ex = new ChartPanel(chart_ex);
		chartpanel_ex.setPreferredSize(new Dimension(1000, 350));
		w.setVisible(false);
		pLabel_ex.add(chartpanel_ex);
	}

	private void createpLabel9(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		pLabel9.add(callDatePickers(9,frame),"North");
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
						String s3 = new String("Directory Creation Failed...<br>Please Try Again...");
						Toast t = new Toast("<html><p style =text-align:center>"+s3+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
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
							String s1 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						if (connection != null) {

							try {
								statement = connection.createStatement();
							} catch (SQLException e2) {
								String s1 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
							try {
								if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
									try {
										myResultSet = statement.executeQuery("select * from visitors");
									} catch (SQLException e2) {
										String s1 = new String("Failed To Process...<br>Please Try Again...");
										Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
										t.showtoast();
									}
								}
								else {
									try {
										pstatement = connection.prepareStatement("select * from visitors where visit_date between ? and ?");
										pstatement.setString(1, datePicker.getJFormattedTextField().getText());
										pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
										myResultSet = pstatement.executeQuery();
									} catch (SQLException e2) {
										String s1 = new String("Failed To Process...<br>Please Try Again...");
										Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
										t.showtoast();
									}
								}
							}catch(Exception e1) {
								try {
									pstatement = connection.prepareStatement("select * from visitors where visit_date between ? and ?");
									pstatement.setString(1, datePicker.getJFormattedTextField().getText());
									pstatement.setString(2, datePicker1.getJFormattedTextField().getText());
									myResultSet = pstatement.executeQuery();
								} catch (SQLException e2) {
									String s1 = new String("Failed To Process...<br>Please Try Again...");
									Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
									t.showtoast();
								}
							}


							try {
								try {
									writer.writeAll(myResultSet, includeHeaders);
								} catch (SQLException e1) {
									String s11 = new String("Failed To Process...<br>Please Try Again...");
									Toast t = new Toast("<html><p style =text-align:center>"+s11+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
									t.showtoast();
								}
								writer.close();
								w.setVisible(false);
							} catch (IOException e1) {
								String s1 = new String("Failed To Process...<br>Please Try Again...");
								Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
								t.showtoast();
							}
						}}catch (ClassNotFoundException e1) {
							String s1 = new String("Failed To Process...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s1+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
				}
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


					String col_name[] ={"Seat No.","Roll No.","Name","Stream","Class","Div","Library Card Valid Upto","Visit Date","In Time","Out Time","Time Spent"};
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
								myResultSet = statement.executeQuery("select * from visitors where visit_status in('come')");					
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
		sort.addActionListener(new ActionListener() {

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


					String col_name[] ={"Seat No.","Roll No.","Name","Stream","Class","Div","Library Card Valid Upto","Visit Date","In Time","Out Time","Time Spent"};
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
								myResultSet = statement.executeQuery("select * from visitors where visit_status in('come') order by visit_date, visitor_stream, visit_time");					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? order by visit_date, visitor_stream, visit_time limit 1");
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
								myResultSet = statement.executeQuery("select * from visitors where visit_status in('come') order by visit_date, visitor_stream, visit_time");					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? order by visit_date, visitor_stream, visit_time limit 1");
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
					}catch(Exception exception) {
						try {
							String str[] = {"Nirmala Memorial Foundation College Of Commerce & Science"};
							writer.writeNext(str);
							String str1[] = {"NAAC Accredited and ISO Certified"};
							writer.writeNext(str1);
							String str2[] = {"D.S. Road, Asha Nagar, Thakur Complex, Kandivali(E), Mumbai - 400 101 Tel: 2854 3234"};
							writer.writeNext(str2);
							writer.writeNext(col_name);
							myResultSet = statement.executeQuery("select * from visitors where visit_status in('come') order by visit_date, visitor_stream, visit_time");					
							while(myResultSet.next()) {
								pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? order by visit_date, visitor_stream, visit_time limit 1");
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
						add1.show();
						add2.show();
						add3.show();
						add4.show();
						add5.show();
						add6.show();
						add7.show();
						add8.show();
						add9.show();
						add_ex.show();
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
						op = new OrganicPanel();

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
							op.frame.dispose();
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
						add1.hide();
						add2.hide();
						add3.hide();
						add4.hide();
						add5.hide();
						add6.hide();
						add7.hide();
						add8.hide();
						add9.hide();
						add_ex.hide();
						frame.revalidate();
						frame.repaint();
					}
					if(retrival == chooser.CANCEL_OPTION) {

						int a = JOptionPane.showConfirmDialog(frame, "Are You Sure?\nIf you select yes then all your selected data will be wiped!!!s");
						if(a == JOptionPane.YES_OPTION) {
							op.frame.dispose();
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							try {
								baos.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							hope = !(hope);
							pdf.setBackground(Color.red);
							add1.hide();
							add2.hide();
							add3.hide();
							add4.hide();
							add5.hide();
							add6.hide();
							add7.hide();
							add8.hide();
							add9.hide();
							add_ex.hide();
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
					if(newPage == false) {
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
						s1 = "Table Representing The Visitors Data";
					}
					else {
						s1 = "Table Representing The Visitors Data Between "+datePicker.getJFormattedTextField().getText()+" and "+datePicker1.getJFormattedTextField().getText();
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
								myResultSet = statement.executeQuery("select * from visitors where visit_status in('come') order by visit_date, visitor_stream, visit_time");					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? order by visit_date, visitor_stream, visit_time limit 1");
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

								myResultSet = statement.executeQuery("select * from visitors where visit_status in('come') order by visit_date, visitor_stream, visit_time");					
								while(myResultSet.next()) {
									pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? order by visit_date, visitor_stream, visit_time limit 1");
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

							myResultSet = statement.executeQuery("select * from visitors where visit_status in('come') order by visit_date, visitor_stream, visit_time");					
							while(myResultSet.next()) {
								pstatement1 = connection.prepareStatement("select * from visitors where visitor_seat_number in(?) and visit_date in(?) and visit_status in(?) and visit_time >= ? and visit_date between ? and ? order by visit_date, visitor_stream, visit_time limit 1");
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