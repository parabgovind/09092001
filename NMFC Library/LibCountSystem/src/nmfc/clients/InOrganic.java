package nmfc.clients;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleEdge;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import nmfc.services.DateLabelFormatter;
import nmfc.services.StudentDaoImpl;
import nmfc.services.VisitorsDaoImpl;

public class InOrganic {
	JFrame frame;
	UtilDateModel modelstacked = new UtilDateModel();	
	UtilDateModel modelstacked1 = new UtilDateModel();	
	String nameio;
	ByteArrayOutputStream baos;
	int maxio = 20;
	JFreeChart chartio;
	JButton Download;
	JButton pdf;
	static JButton addio;
	JButton countLabel,legendhider,labelhider;
	JComboBox classy_ex,service_ex;
	static VisitorsDaoImpl visitor_service = new VisitorsDaoImpl(); 	
	static StudentDaoImpl student_service = new StudentDaoImpl();
	ChartPanel chartpanel;
	JPanel pLabel2;	
	SlidingCategoryDataset dataset2;  
	boolean showCountLabel,showlegendhider,showlabelhider;
	boolean c_selected,s_selected,c_s_selected,class_selected,stream_selected,class_stream_selected, m_selected = false;
	

	public static void main(String args[]) throws Exception{
		new InOrganic();
	}

	public InOrganic() {
		frame = new JFrame();
		frame.setState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(Color.white);
		URL iconURL = getClass().getResource("/slogo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Rectangle win = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		frame.setSize(win.width,win.height);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		//add components here                
		JPanel panel1 = new JPanel();
		pLabel2 = new JPanel(new BorderLayout());
		pLabel2.setPreferredSize(new Dimension(1000, 500));
		pLabel2.setBackground(new Color(254,254,254));
		pLabel2.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel2.add(callDatePickers(2,frame),"North");
		panel1.setBackground(Color.white);
		pLabel2.setBackground(Color.white);
		panel1.add(pLabel2);
		panel.add(panel1,gbc);

		frame.getContentPane().add(new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		frame.setVisible(true);
	}

	private Component callDatePickers(int no, JFrame frame) {
		JPanel field = new JPanel(new FlowLayout());
		field.setBackground(new Color(254,254,254));
		UtilDateModel model0 = new UtilDateModel();
		UtilDateModel model00 = new UtilDateModel();
		if(no==2) {
			model0 = modelstacked;
			model00 = modelstacked1;
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
		countLabel = new JButton("Count");
		countLabel.setBackground(Color.decode("#ffffe0"));
		countLabel.setPreferredSize(new Dimension(70,20));
		legendhider = new JButton("Legend");
		legendhider.setBackground(Color.decode("#ffffe0"));
		legendhider.setPreferredSize(new Dimension(90,20));
		labelhider = new JButton("Label");
		labelhider.setBackground(Color.decode("#ffffe0"));
		labelhider.setPreferredSize(new Dimension(90,20));
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
				if(no == 2){
					pLabel2.removeAll();
					frame.remove(pLabel2);
					createpLabel2(frame,datePicker, datePicker1,1);
				}
			}
		});
		countLabel.setFont(new Font("Verdana", Font.BOLD, 9));
		legendhider.setFont(new Font("Verdana", Font.BOLD, 9));
		labelhider.setFont(new Font("Verdana", Font.BOLD, 9));
		field.add(filter);
		field.add(countLabel);
		field.add(legendhider);
		field.add(labelhider);
		field.add(Download);
		
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
		
		addio = new JButton("Add");
		addio.setBackground(Color.decode("#ffffe0"));
		addio.setPreferredSize(new Dimension(60,20));
		addio.setFont(new Font("Verdana", Font.BOLD, 9));
		field.add(addio);
		return field;
	}

	private void createpLabel2(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1,int io) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.add(callDatePickers(2,frame),"North");
		String stream_opt = new VisitorsDaoImpl().getStreams().getFirst().toString();
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
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+stream_opt+" Students", "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+stream_opt+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+stream_opt+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Class", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}

		

		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					nameio = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					while(count < maxio) {
						BufferedImage chartImage = chartio.createBufferedImage(1000,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+nameio));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+nameio+"\\"+"B_"+nameio+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +20;
					}
					w.setVisible(false);
				}
			}

		});
		addio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					while(count < maxio) {
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chartio.createBufferedImage(1000,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						AdminPanel.document.add(img1);
						callAddSpace(3);
						count = count +20;
					}
					w.setVisible(false);
				}
				catch(Exception e1) {w.setVisible(false);}
			}
		});
		helloBro(w);
//		c_selected = false;
//		s_selected = false;
//		c_s_selected = false;
//		class_selected = false;
//		stream_selected = false;
//		class_stream_selected = false;
//		m_selected = false;
//		String stream_arr[] = new String[new VisitorsDaoImpl().getStreams().size()];

		
		classy_ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acteve) {
				if(Arrays.asList(class_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					c_selected = true;

					if(c_selected == true) {
						create_c_selected(frame, datePicker, datePicker1);
					}
				}
				if(Arrays.asList(stream_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					s_selected = true;

					if(s_selected == true) {
						create_s_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Stream")) {
					s_selected = false;
					stream_selected = true;
					if(stream_selected == true) {
						create_stream_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Class")) {
					s_selected = false;
					stream_selected = false;
					class_selected = true;
					if(class_selected == true) {
						create_class_selected(frame, datePicker, datePicker1);
					}
				}

			}});
		service_ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent acteve) {
				// TODO Auto-generated method stub
				if(service_ex.getItemAt(service_ex.getSelectedIndex()).toString().equalsIgnoreCase("Month")) {
					m_selected = true;
					if(c_selected == true & m_selected == true) {
						call_c_m_selected(frame, datePicker, datePicker1);
					}
					if(s_selected == true & m_selected == true) {
						call_s_m_selected(frame, datePicker, datePicker1);
					}
					if(class_selected == true & m_selected == true) {
//						call_class_m_selected(frame, datePicker, datePicker1);
					}
					if(stream_selected == true & m_selected == true) {
//						call_stream_m_selected(frame, datePicker, datePicker1);
					}
				}
				
			}});
	}
	private void create_c_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[0],"FootFall",o[1].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students", "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Class", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}
		helloBro(w);
	}
	private void create_s_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		String classy3[] = new String[new VisitorsDaoImpl().getStreams().size()];
		String stream_opt = new VisitorsDaoImpl().getStreams().getFirst().toString();
		
		for(int  i = 0 ; i < new VisitorsDaoImpl().getStreams().size(); i++){
			classy3[i] = new VisitorsDaoImpl().getStreams().get(i).toString();
			if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase(classy3[i].toString())){
				stream_opt = new VisitorsDaoImpl().getStreams().get(i).toString();
				break;
			}
		}
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+stream_opt+" Students", "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+stream_opt+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[0],o[1].toString(),o[2].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of "+stream_opt+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Class", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}
		helloBro(w);
	}
	private void call_c_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"Aggregated Monthly FootFall Counts for "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students: Insights Across All Years", "Month", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"Aggregated Monthly FootFall Counts for "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText()+": Insights Across All Years", "Month", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"Aggregated Monthly FootFall Counts for "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText()+": Insights Across All Years", "Month", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}
		helloBro(w);
	}
	private void call_s_m_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllMonthWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"Aggregated Monthly FootFall Counts for "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students: Insights Across All Years", "Month", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"Aggregated Monthly FootFall Counts for "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText()+": Insights Across All Years", "Month", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getParticularStreamAllclass(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[2],o[1].toString(),o[0].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"Aggregated Monthly FootFall Counts for "+classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()+" Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText()+": Insights Across All Years", "Month", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}
		helloBro(w);
	}
	private void create_stream_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		String classy3[] = new String[new VisitorsDaoImpl().getStreams().size()];
		String stream_opt = (String) classy_ex.getItemAt(classy3.length+2);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getGroupBY().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getGroupBY().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of All Stream Students", "Streams", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getGroupBYDates(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getGroupBYDates(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of All Stream Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Streams", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getGroupBYDates(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getGroupBYDates(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of All Stream Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Streams", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}
		helloBro(w);
	}
	private void create_class_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		String classy3[] = new String[new VisitorsDaoImpl().getStreams().size()];
		String stream_opt = (String) classy_ex.getItemAt(classy3.length+1);
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getGroupBYClass().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getGroupBYClass().get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of All Class Students", "Class", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getGroupBYDatesClass(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getGroupBYDatesClass(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				for(Object[] o:object) {
					dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
				}

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

				chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of All Class Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Streams", "Student FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getGroupBYDatesClass(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getGroupBYDatesClass(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			for(Object[] o:object) {
				dataset1.addValue((Number) o[1],"FootFall",o[0].toString());
			}

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);

			chartio = ChartFactory.createBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of All Class Students Between Dates "+datePicker.getJFormattedTextField().getText()+" And "+datePicker1.getJFormattedTextField().getText(), "Streams", "Student FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
		}
		helloBro(w);
	}

	private JWindow callToast() {
		// TODO Auto-generated method stub
		JWindow w = new JWindow();
		w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();
		String s = new String("Process in progress...<br>Please wait...");
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.setFont(new Font("Verdana",Font.BOLD,18));
		p.setText("<html><p style =text-align:center>"+s+"</p></html>");
		p.setBackground(new Color(133,254,161,90));
		p.setForeground(new Color(0,0,0));
		w.setLayout(new FlowLayout(FlowLayout.CENTER));
		w.add(p);
		w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);
		w.setSize(400,60);
		w.setOpacity(1);
		w.setVisible(true);
		return w;
	}

	private void helloBro(JWindow w) {
		chartio.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chartio.getPlot();

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
		BarRenderer renderer = new RoundedBarRenderer();
        plot.setRenderer(renderer);
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(4);
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
		chartio.getLegend().setFrame(BlockBorder.NONE);
		chartio.getLegend().setPosition(RectangleEdge.RIGHT);
		chartio.getLegend().setBackgroundPaint(Color.white);

		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chartio.getTitle().setFont(customFont);
		chartio.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans );
		chartio.setBackgroundImage(icon);
		chartio.setBackgroundImageAlpha(0.5f);
		chartio.setBackgroundImageAlignment(Align.TOP_LEFT);
		chartpanel = new ChartPanel(chartio);
		chartpanel.setPreferredSize(new Dimension(1000, 350));
		w.setVisible(false);
		pLabel2.add(chartpanel);
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
		AdminPanel.document.add(table);
	}
	
	static class RoundedBarRenderer extends BarRenderer {
    	@Override
    	public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea,
    	                     CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis,
    	                     CategoryDataset dataset, int row, int column, int pass) {
    	    double x0 = domainAxis.getCategoryMiddle(column, getColumnCount(), dataArea, plot.getDomainAxisEdge());
    	    double y0 = rangeAxis.valueToJava2D(dataset.getValue(row, column).doubleValue(), dataArea, plot.getRangeAxisEdge());
    	    double y1 = rangeAxis.valueToJava2D(0.0, dataArea, plot.getRangeAxisEdge());

    	    Rectangle2D bar = new Rectangle2D.Double(x0 - 10, Math.min(y0, y1), 20, Math.abs(y1 - y0));
    	    RoundRectangle2D roundedBar = new RoundRectangle2D.Double(bar.getX()-5, bar.getY(), bar.getWidth()+10, bar.getHeight(), 30, 30);
//    	    RoundRectangle2D roundedBar = new RoundRectangle2D.Double(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight(), 10, 10);

    	    Paint paint = createGradientPaint(column, bar);
    	    g2.setPaint(paint);
    	    g2.fill(roundedBar);

    	    if (isDrawBarOutline() && state.getBarWidth() > 3) {
    	        g2.setStroke(getItemOutlineStroke(row, column));
    	        g2.setPaint(getItemOutlinePaint(row, column));
    	        g2.draw(roundedBar);
    	    }

    	    // Draw count text on top of the bar
    	    FontMetrics fm = g2.getFontMetrics();
    	    g2.setFont(new Font("Verdana", Font.PLAIN, 9));
    	    String countText = String.valueOf(dataset.getValue(row, column));
    	    Rectangle2D bounds = fm.getStringBounds(countText, g2);
    	    double textX = bar.getCenterX() - bounds.getWidth() / 2.0;
    	    double textY = bar.getY()- 5;
    	    g2.setColor(Color.BLACK);
    	    g2.drawString(countText, (float) textX, (float) textY);
    	}
    	private Paint createGradientPaint(int column, Rectangle2D bar) {
		    Color startColor, endColor;
		    switch (column) {
		        case 0:
		            startColor = new Color(245, 105, 145);
		            endColor = new Color(200, 20, 60);
		            break;
//		        case 1:
//		            startColor = new Color(152, 251, 152);
//		            endColor = new Color(34, 139, 34);
//		            break;
//		        case 2:
//		            startColor = new Color(135, 206, 250);
//		            endColor = new Color(0, 0, 139);
//		            break;
//		        case 3:
//		        	startColor = new Color(255,255,153);
//		            endColor = new Color(255,191,0);
//		            break;
//		        case 4:
//		        	startColor = new Color(255,190,220);
//		            endColor = new Color(224,17,95);
//		            break;
//		        case 5:
//		        	startColor = new Color(255, 204, 153);
//		            endColor = new Color(183,65, 14);
//		            break;
//		        case 6:
//		        	startColor = Color.BLUE;
//		            endColor = Color.GREEN;
//		            break;
		        default:
		        	startColor = new Color(245, 105, 145);
		            endColor = new Color(200, 20, 60);
//		        	startColor = new Color(192,192,192);
//		            endColor = new Color(64,64,64);
		    }
		    
		    double midY = bar.getY() + bar.getHeight() / 2.0;
		    
		    return new GradientPaint(
		        (float) bar.getCenterX(), (float) bar.getY(),
		        startColor,
		        (float) bar.getCenterX(), (float) midY,
		        endColor
		    );
		}
    }
}
