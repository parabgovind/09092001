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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
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

public class OrganicPanel {
	JFrame frame;
	UtilDateModel modelstacked = new UtilDateModel();	
	UtilDateModel modelstacked1 = new UtilDateModel();	
	String namestacked;
	boolean c_selected,s_selected,c_s_selected,class_Selected,stream_selected,class_stream_selected = false;
	ByteArrayOutputStream baos;
	int maxstacked;
	JFreeChart chartstacked;
	JButton Download;
	JButton pdf;
	static JButton addstacked;
	JButton countLabel,legendhider,labelhider;
	JComboBox classy_ex;
	static VisitorsDaoImpl visitor_service = new VisitorsDaoImpl(); 	
	static StudentDaoImpl student_service = new StudentDaoImpl();
	ChartPanel chartpanel;
	JPanel pLabel2;	
	JScrollBar scroller2;
	SlidingCategoryDataset dataset2;  
	static Set<String> hs;
	KeyToGroupMap map;
	GroupedStackedBarRenderer gsbr;
	boolean showCountLabel,showlegendhider,showlabelhider;
	SubCategoryAxis sca;
	CategoryItemLabelGenerator generator;

	public static void main(String args[]) throws Exception{
		OrganicPanel ap = new OrganicPanel();  
	}

	public OrganicPanel() {
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
		pLabel2.setPreferredSize(new Dimension(1320, 690));
		pLabel2.setBackground(new Color(254,254,254));
		pLabel2.setBorder(BorderFactory.createLineBorder(new Color(60,150,90)));
		pLabel2.add(callDatePickers(2,frame),"North");
		Font font = new Font("Verdana", Font.PLAIN|Font.BOLD, 21);
		String text2 = "This Section Demonstrates The Overall Visits And Count" + "<br>" + "<br>" +
				"Of All The Visitors As Per Selection Of Options Made";
		JLabel desc2 = new JLabel("<html><div style='text-align: center;'>" + text2 + "</div></html>");
		desc2.setFont(font);
		desc2.setBorder(BorderFactory.createLineBorder(new Color(123,231,12)));
		desc2.setForeground(Color.decode("#00a4bd"));
		desc2.setPreferredSize(new Dimension(990,340));
		desc2.setHorizontalAlignment(SwingConstants.CENTER);
		pLabel2.add(desc2);
		panel1.setBackground(Color.white);
		pLabel2.setBackground(Color.white);
		panel1.add(pLabel2);
		panel.add(panel1,gbc);

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
				// TODO Auto-generated method stub

				if(no == 2){
					pLabel2.removeAll();
					frame.remove(pLabel2);
					createpLabel2(frame,datePicker, datePicker1);
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
		
		addstacked = new JButton("Add");
		addstacked.setBackground(Color.decode("#ffffe0"));
		addstacked.setPreferredSize(new Dimension(60,20));
		addstacked.setFont(new Font("Verdana", Font.BOLD, 9));
		field.add(addstacked);

		return field;
	}

	private void createpLabel2(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub 
		pLabel2.add(callDatePickers(2,frame),"North");		
		JWindow w = callToast();
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Year / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorRecord().get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[2].toString());
						flag++;
					}
					hs.add(o[2].toString());
					dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[2].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Year / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[2].toString());
						flag++;
					}
					hs.add(o[2].toString());
					dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[2].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("Year / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[2].toString());
					flag++;
				}
				hs.add(o[2].toString());
				dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[2].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}		
		countLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				callMeBro();
			}
			
		});
		labelhider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showlabelhider = !showlabelhider;
				if(showlabelhider == true) {
					// TODO Auto-generated method stub
					sca.setVisible(true);
				}
				else {
					sca.setVisible(false);
				}
			}
			
		});
		legendhider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showlegendhider = !showlegendhider;
				if(showlegendhider == true) {
					// TODO Auto-generated method stub
					chartstacked.getLegend().setFrame(BlockBorder.NONE);
					chartstacked.getLegend().setPosition(RectangleEdge.RIGHT);
					chartstacked.getLegend().setBackgroundPaint(Color.white);

					Font customFont = new Font("Verdana", Font.PLAIN, 9);
					chartstacked.getTitle().setFont(customFont);
					chartstacked.getLegend().setItemFont(customFont);
				}
				else {
					chartstacked.getLegend().visible=!(chartstacked.getLegend().visible);
				}
			}
			
		});
		
		Download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					namestacked = chooser.getSelectedFile().getName();
					String path = chooser.getCurrentDirectory().getPath().toString();
					int count=0;
					scroller2.setValue(0);
					while(count < maxstacked) {
						BufferedImage chartImage = chartstacked.createBufferedImage(1000,350);
						try {
							Files.createDirectories(Paths.get(path+"\\"+namestacked));						
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Directory Creation Failed...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						File summaryChartFile = new File(path+"\\"+namestacked+"\\"+"B_"+namestacked+count+".png");
						try (OutputStream out = new FileOutputStream(summaryChartFile)) {
							ImageIO.write(chartImage, "png", out);
						} catch (IOException e1) {
							w.setVisible(false);
							String s = new String("Failed writing Image...<br>Please Try Again...");
							Toast t = new Toast("<html><p style =text-align:center>"+s+"</p></html>", frame.getWidth()/2-165, frame.getHeight()/2-35,330,70);
							t.showtoast();
						}
						count = count +31;
						scroller2.setValue(count);
					}
					w.setVisible(false);
				}
			}

		});
		addstacked.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					JWindow w = new JWindow();w.setBackground(new Color(133,254,161,100));JLabel p = new JLabel();String m = new String("Process in progress...<br>Please wait...");p.setLayout(new FlowLayout(FlowLayout.CENTER));p.setFont(new Font("Verdana",Font.BOLD,18));p.setText("<html><p style =text-align:center>"+m+"</p></html>");p.setBackground(new Color(133,254,161,90));p.setForeground(new Color(0,0,0));w.setLayout(new FlowLayout(FlowLayout.CENTER));w.add(p);w.setLocation(frame.getWidth()/2-200, frame.getHeight()/2-30);w.setSize(400,60);w.setOpacity(1);w.setVisible(true);	
					callAddSpace(5);
					int count=0;
					scroller2.setValue(0);
					while(count < maxstacked) {
						BufferedImage chartImage = chartstacked.createBufferedImage(1000,350);
						com.lowagie.text.Image img1 = com.lowagie.text.Image.getInstance(chartstacked.createBufferedImage(1000,350),null);
						img1.setAlignment(Element.ALIGN_CENTER);
						AdminPanel.document.add(img1);
						callAddSpace(3);
						count = count +31;
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
		helloBro(w);
		c_selected = false;
		s_selected = false;
		c_s_selected = false;
		class_Selected = false;
		stream_selected = false;
		class_stream_selected = false;
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
				class_stream_selected == false) {

			c_selected = true;
			s_selected = false;
			c_s_selected = false;
			class_Selected = false;
			stream_selected = false;
			class_stream_selected = false;

		}
		
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

					if(c_selected == true) {
						call_c_d_selected(frame, datePicker, datePicker1);
					}
				}
				if(Arrays.asList(stream_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					c_selected = false;
					s_selected = true;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = false;

					if(s_selected == true) {
						call_s_d_selected(frame, datePicker, datePicker1);
					}
				}
				if(Arrays.asList(class_stream_arr).contains(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString())) {
					c_selected = false;
					s_selected = false;
					c_s_selected = true;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = false;

					if(c_s_selected == true) {
						call_c_s_d_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Class")) {
					c_selected = false;
					s_selected = false;
					c_s_selected = false;
					class_Selected = true;
					stream_selected = false;
					class_stream_selected = false;

					if(class_Selected == true) {
						call_class_d_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Stream")) {
					c_selected = false;
					s_selected = false;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = true;
					class_stream_selected = false;

					if(stream_selected == true) {
						call_stream_d_selected(frame, datePicker, datePicker1);
					}
				}
				if(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString().equalsIgnoreCase("All Class & Stream")) {
					c_selected = false;
					s_selected = false;
					c_s_selected = false;
					class_Selected = false;
					stream_selected = false;
					class_stream_selected = true;

					if(class_stream_selected == true) {
						call_class_stream_d_selected(frame, datePicker, datePicker1);
					}
				}

			}});
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

	protected void call_c_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		scroller2.hide();
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Class / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Class / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("Class / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[4].toString());
					flag++;
				}
				hs.add(o[4].toString());
				dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[4].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}

		helloBro(w);
	}
	protected void call_s_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		scroller2.hide();
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString()).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}

				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});

				dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("Stream / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleStreamRecord(classy_ex.getItemAt(classy_ex.getSelectedIndex()).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}

			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[4].toString());
					flag++;
				}
				hs.add(o[4].toString());
				dataset1.addValue((Number) o[1],o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[2].toString()+" "+o[3].toString(), o[4].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});

			dataset2 = new SlidingCategoryDataset(dataset1, 0, 20);
			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}

		helloBro(w);
	}
	
	protected void call_class_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		scroller2.hide();
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Class / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassRecord().get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Class / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("All Class / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[4].toString());
					flag++;
				}
				hs.add(o[4].toString());
				dataset1.addValue((Number) o[1],o[4].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[4].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});


			dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}

		helloBro(w);
	}
	
	protected void call_stream_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		scroller2.hide();
		try {
			if(datePicker.getJFormattedTextField().getText().length() ==0 && datePicker1.getJFormattedTextField().getText().length() ==0) {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorStreamRecord().get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString());
						flag++;
					}
					hs.add(o[4].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("All Stream / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[4].toString());
					flag++;
				}
				hs.add(o[4].toString());
				dataset1.addValue((Number) o[1],o[4].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[4].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});


			dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}

		helloBro(w);
	}
	
	protected void call_c_s_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		scroller2.hide();
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
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("Class-Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString()+" "+o[5].toString());
						flag++;
					}
					hs.add(o[4].toString()+" "+o[5].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString()+" "+o[5].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Class-Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString()+" "+o[5].toString());
						flag++;
					}
					hs.add(o[4].toString()+" "+o[5].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString()+" "+o[5].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("All Stream / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorSingleClassStreamRecord(class_opt,stream_opt,datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[4].toString()+" "+o[5].toString());
					flag++;
				}
				hs.add(o[4].toString()+" "+o[5].toString());
				dataset1.addValue((Number) o[1],o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString()+" "+o[5].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});


			dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}

		helloBro(w);
	}
	
	protected void call_class_stream_d_selected(JFrame frame, JDatePickerImpl datePicker, JDatePickerImpl datePicker1) {
		// TODO Auto-generated method stub
		
		JWindow w = callToast();
		pLabel2.remove(chartpanel);
		scroller2.hide();
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
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Class-Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassStreamRecord().size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassStreamRecord().get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString()+" "+o[5].toString());
						flag++;
					}
					hs.add(o[4].toString()+" "+o[5].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString()+" "+o[5].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
			else {
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				sca = new SubCategoryAxis("All Class-Stream / Day");
				gsbr = new GroupedStackedBarRenderer();

				int flag =0;
				List<Object[]> object = new ArrayList<Object[]>();
				for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
					object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
				}
				hs = new LinkedHashSet<String>();

				for(Object[] o:object) {
					flag++;
					if(flag == 1) {
						map = new KeyToGroupMap(o[4].toString()+" "+o[5].toString());
						flag++;
					}
					hs.add(o[4].toString()+" "+o[5].toString());
					dataset1.addValue((Number) o[1],o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
					map.mapKeyToGroup(o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString()+" "+o[5].toString());
				}
				Iterator<String> m = hs.iterator(); 
				while (m.hasNext()) {
					sca.addSubCategory(m.next()+""); 
				}

				gsbr.setSeriesToGroupMap(map); 
				gsbr.setItemMargin(0.0);
				gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
					public String generateToolTip(CategoryDataset dataset,int row, int column) {
						String s =super.generateToolTip(dataset1, row, column);
						int b = s.indexOf('(',1)+1;
						int e = s.indexOf(')');
						return s.substring(b,e);
					}
				});


				dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

				chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
						dataset2, PlotOrientation.VERTICAL, true, true, false);
				int e=0;
				maxstacked = 31;
				if(maxstacked > 31) {
					e = 31;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}else {
					e=maxstacked;
					scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
				}
				if(maxstacked < 31) {
					scroller2.hide();
				}
			}
		}catch(Exception e1) {
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			sca = new SubCategoryAxis("All Stream / Day");
			gsbr = new GroupedStackedBarRenderer();

			int flag =0;
			List<Object[]> object = new ArrayList<Object[]>();
			for(int  i = 0 ; i < new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).size(); i++){
				object.add(i, (Object[]) new VisitorsDaoImpl().getAllOrganicDayWiseVisitorClassStreamRecord(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText()).get(i) );
			}
			hs = new LinkedHashSet<String>();

			for(Object[] o:object) {
				flag++;
				if(flag == 1) {
					map = new KeyToGroupMap(o[4].toString()+" "+o[5].toString());
					flag++;
				}
				hs.add(o[4].toString()+" "+o[5].toString());
				dataset1.addValue((Number) o[1],o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(),o[0].toString());
				map.mapKeyToGroup(o[4].toString()+" "+o[5].toString()+" "+o[2].toString()+" "+o[3].toString(), o[4].toString()+" "+o[5].toString());
			}
			Iterator<String> m = hs.iterator(); 
			while (m.hasNext()) {
				sca.addSubCategory(m.next()+""); 
			}

			gsbr.setSeriesToGroupMap(map); 
			gsbr.setItemMargin(0.0);
			gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator() {
				public String generateToolTip(CategoryDataset dataset,int row, int column) {
					String s =super.generateToolTip(dataset1, row, column);
					int b = s.indexOf('(',1)+1;
					int e = s.indexOf(')');
					return s.substring(b,e);
				}
			});


			dataset2 = new SlidingCategoryDataset(dataset1, 0, 31);

			chartstacked = ChartFactory.createStackedBarChart("Nirmala Memorial Foundation College Of Commerce & Science"+"\n"+"NAAC Accredited and ISO Certified"+"\n"+" "+"\n"+"FootFall Count Of Visitors As Per Dates", "", "FootFall Count",
					dataset2, PlotOrientation.VERTICAL, true, true, false);
			int e=0;
			maxstacked = 31;
			if(maxstacked > 31) {
				e = 31;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}else {
				e=maxstacked;
				scroller2 = new JScrollBar(JScrollBar.HORIZONTAL,0,e,0,maxstacked);
			}
			if(maxstacked < 31) {
				scroller2.hide();
			}
		}

		helloBro(w);
	}
	
	

	private void helloBro(JWindow w) {
		// TODO Auto-generated method stub
		Font customFont = new Font("Verdana", Font.PLAIN, 9);
		chartstacked.setBackgroundPaint(Color.white);
		final CategoryPlot plot = (CategoryPlot) chartstacked.getPlot();
//		AffineTransform trans1 = AffineTransform.getTranslateInstance(28, 45);
//		trans1.concatenate(AffineTransform.getRotateInstance(-Math.PI/2));
		plot.setDomainAxis(sca);
		plot.setRenderer(gsbr);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(new Color(220,230,240));
		plot.setDomainGridlineStroke(new BasicStroke(0.2f));
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(new Color(220,230,240));
		plot.setRangeGridlineStroke(new BasicStroke(0.2f));
		plot.setOutlineVisible(false);

//		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//		rangeAxis.setAutoRangeIncludesZero(false);
//		Range rangeData = rangeAxis.getRange();
//		rangeData = new Range(rangeData.getLowerBound(),rangeData.getUpperBound());
//		rangeAxis.setRange(rangeData);

		gsbr.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

		gsbr.setMaximumBarWidth(.02);
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelPaint(new Color(0,0,0));
		domainAxis.setCategoryLabelPositionOffset(50);
		domainAxis.setCategoryMargin(0.0);
//		sca.setCategoryMargin(0.2);
//		gsbr.setItemMargin(0.1);
//		sca.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		AffineTransform trans = AffineTransform.getTranslateInstance(0, 45);
		trans.concatenate(AffineTransform.getRotateInstance(-Math.PI / 4));
		Font customFont1 = new Font("Verdana", Font.PLAIN, 9);
		sca.setSubLabelFont(customFont1);
		sca.setSubLabelFont((Font) sca.getSubLabelFont().deriveFont(trans));
		chartstacked.getLegend().setFrame(BlockBorder.NONE);
		chartstacked.getLegend().setPosition(RectangleEdge.RIGHT);
		chartstacked.getLegend().setBackgroundPaint(Color.white);
		
		chartstacked.getTitle().setFont(customFont);
		chartstacked.getLegend().setItemFont(customFont);
		plot.getDomainAxis().setTickLabelFont(customFont);
		plot.getRangeAxis().setTickLabelFont(customFont);
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(this.getClass().getResourceAsStream("/small.png"));
		} catch (IOException e1) {}
		Color trans1 = new Color(0xFF, 0xFF, 0xFF, 0);
		plot.setBackgroundPaint( trans1 );
		chartstacked.setBackgroundImage(icon);
		chartstacked.setBackgroundImageAlpha(0.5f);
		chartstacked.setBackgroundImageAlignment(Align.TOP_LEFT);
		chartpanel = new ChartPanel(chartstacked);
		chartpanel.setPreferredSize(new Dimension(1000, 350));
		w.setVisible(false);
		pLabel2.add(chartpanel);
		pLabel2.add(scroller2,"South");         
		frame.revalidate();
		frame.repaint();
	}

	protected void callMeBro() {
		// TODO Auto-generated method stub
		showCountLabel = !showCountLabel;
		if(showCountLabel == true) {
			// TODO Auto-generated method stub
			StackedBarRenderer renderer = (StackedBarRenderer) chartstacked.getCategoryPlot().getRenderer();

			// set label appearance and position
			StandardCategoryItemLabelGenerator lblGenerator = new StandardCategoryItemLabelGenerator();
			renderer.setBaseItemLabelGenerator(lblGenerator);
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBaseItemLabelPaint(Color.black);

			// Fallback for a positive value if the value does not fit inside the bar
			renderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE1, TextAnchor.CENTER_LEFT)); // Adjusted position

			// Fallback for a negative value if the value does not fit inside the bar
			renderer.setNegativeItemLabelPositionFallback(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE1, TextAnchor.CENTER_LEFT)); // Adjusted position

			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER)); // Adjusted position

			renderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER)); // Adjusted position

			// Custom LabelGenerator, which displays the sum of the values at the top of each bar
			boolean labelAdded = false;
			CategoryItemLabelGenerator generator = new CategoryItemLabelGenerator() {
				@Override
				//            
				public String generateLabel(CategoryDataset dataset, int row, int column) {
					if (row == dataset.getRowCount() - 1) { // Check if this is the last row in the dataset
						int sum = 0;
						// Sum values for all series in this category
						for (int i = 0; i < dataset.getRowCount(); i++) {
							Number value = dataset.getValue(i, column);
							if (value != null) {
								sum += value.intValue();
							}
						}
						return String.valueOf(sum); // Display the total for the last bar in each category
					} else {
						int sum = 0;
						// Sum values for all series in this category
						for (int i = 0; i < dataset2.getRowCount(); i++) {
							Number value = dataset2.getValue(i, column);
							if (value != null) {
								sum += value.intValue();
							}
						}
						return String.valueOf(sum); // Empty label for other rows
						//                	return "";
					}
				}

				@Override
				public String generateColumnLabel(CategoryDataset arg0, int arg1) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String generateRowLabel(CategoryDataset arg0, int arg1) {
					// TODO Auto-generated method stub
					return null;
				}
			};
		}
		else {
			StackedBarRenderer renderer = (StackedBarRenderer) chartstacked.getCategoryPlot().getRenderer();

			StandardCategoryItemLabelGenerator lblGenerator = new StandardCategoryItemLabelGenerator();
			renderer.setBaseItemLabelGenerator(lblGenerator);
			renderer.setBaseItemLabelsVisible(false);
		}
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
}