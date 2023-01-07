package acmanagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;



import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Filtering extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField flt_name;
	private JTextField flt_con_no;
	private JTextField flt_con_no_2;
	private JTextField flt_adres;
	private JTextField flt_num_AC;
	
	private final static String url = "jdbc:postgresql://localhost/ACmanagment";
    private final static String user = "postgres";
    private final static String password = "root";
    private JTextField flt_servicedate;
    private JTextField flt_nextservicedate;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Filtering() {
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		getContentPane().setBackground(new Color(206, 232, 244));
	    getContentPane().setForeground(new Color(212, 212, 212));
		setSize(1200, 800);
		
		
	
		contentPane = new JPanel();
		

		try {
			
			BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\dumid\\eclipse-workspace\\ACmanagment\\Image\\logo2.png"));
			Image image = bufferedImage.getScaledInstance(350, 100, Image.SCALE_DEFAULT);
			ImageIcon icon = new ImageIcon(image);
			getContentPane().setLayout(null);
			getContentPane().setLayout(null);
			
			
			JLabel jLabel = new JLabel();
			jLabel.setBounds(20, 20, 238, 100);
			jLabel.setIcon(icon);
			getContentPane().add(jLabel);
			
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 159, 173, 217);
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_2.setBackground(new Color(169, 214, 235));
			getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JButton login_back = new JButton("Login");
			login_back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					   dispose();
					   Login nw=new Login();
					    nw.setVisible(true);
				}
			});
			login_back.setBorder(new LineBorder(new Color(0, 0, 0)));
			login_back.setBounds(10, 22, 153, 33);
			panel_2.add(login_back);
			
			JButton Manu_back = new JButton("Manu");
			Manu_back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					   dispose();
					   Form nw=new Form();
					    nw.setVisible(true);
				}
			});
			Manu_back.setBorder(new LineBorder(new Color(0, 0, 0)));
			Manu_back.setBounds(10, 65, 153, 33);
			panel_2.add(Manu_back);
			
			JButton Select_back = new JButton("Select");
			Select_back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					   dispose();
					   Filtering nw=new Filtering();
					    nw.setVisible(true);
				}
			});
			Select_back.setBorder(new LineBorder(new Color(0, 0, 0)));
			Select_back.setBounds(10, 108, 153, 33);
			panel_2.add(Select_back);
			
			JButton updated = new JButton("Update");
			updated.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					    dispose();
					   Update nw=new Update();
					    nw.setVisible(true);
				}
			});
			updated.setBorder(new LineBorder(new Color(0, 0, 0)));
			updated.setBounds(10, 155, 153, 33);
			panel_2.add(updated);
			
			JPanel panel = new JPanel();
			panel.setBounds(344, 76, 551, 63);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel.setBackground(new Color(169, 214, 235));
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Next services Details");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(159, 20, 232, 24);
			panel.add(lblNewLabel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_1.setBackground(new Color(169, 214, 235));
			panel_1.setBounds(212, 160, 940, 578);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lb_select_nextservices = new JLabel("Next Service Date");
			lb_select_nextservices.setBorder(new LineBorder(new Color(0, 0, 0)));
			lb_select_nextservices.setFont(new Font("Tahoma", Font.BOLD, 15));
			lb_select_nextservices.setHorizontalAlignment(SwingConstants.CENTER);
			lb_select_nextservices.setBounds(45, 51, 180, 37);
			panel_1.add(lb_select_nextservices);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(273, 51, 638, 237);
			panel_1.add(scrollPane);
			
			table = new JTable();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			scrollPane.setViewportView(table);
			
			
		 //   model.addTableModelListener(new Tablemod);
			
			JCalendar select_date = new JCalendar();
			select_date.setBorder(new LineBorder(new Color(0, 0, 0)));
			select_date.setBounds(25, 121, 212, 191);
			panel_1.add(select_date);
			
			Calendar c = Calendar.getInstance();
			//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			
			JButton btn_selected_date = new JButton("SELECT");
			btn_selected_date.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					   Connection connection=null;
					   
					
				try {
					
					connection = DriverManager.getConnection(url, user, password);
					
					String strDateFormat = "HH:mm:ss a";

					//Date date=Date.valueOf(select_date.getDate());
					
					 
					//DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					String formatted_date_from=format1.format(select_date.getDate());
					Date date=Date.valueOf(formatted_date_from);
					date.toLocalDate();
					System.out.println(formatted_date_from);
					//Date dateselect=df.parse(select_date.getDate());
					c.setTime(date);
			        c.add(c.DATE,7);
			        String cf=format1.format(c.getTime());
			        System.out.println(cf);
			        
			     
			        
			    	try {
			            
			            
			            
			            Statement st3 = connection.createStatement();
			        
			        
			        String query_3="SELECT id,name,contactnumber1,contactnumber2,address,numofac,servicedate,nextservicedate FROM public.acdetails WHERE (nextservicedate<='"+cf+"' AND nextservicedate >='"+formatted_date_from+"') ORDER BY nextservicedate Asc;";
					
			        System.out.println(query_3);
			        ResultSet rs_3=st3.executeQuery(query_3);
			        System.out.println(rs_3);
			        ResultSetMetaData rsmd=rs_3.getMetaData();
				    
			        System.out.println("Connected to the PostgreSQL server successfully.3");
				    
				    int cols=rsmd.getColumnCount();
				    String[] colName={"id","name","contactnumber1","contactnumber2","address","numofac","servicedate","nextservicedate"};
				    
//				    for(int i=0;i<cols;i++)
//				    	colName[i]=rsmd.getColumnName(i+1);
				    model.setColumnIdentifiers(colName);	
				    connection.setAutoCommit(false);
				    
			        System.out.println("Opened database successfully xxxx");    
				    System.out.println(colName);
				    
				    String  id,name,contactnumber1,contactnumber2,address,numofac,servicedate,nextservicedate;
				   
				    
					while(rs_3.next()) {
						id=rs_3.getString(1);
						name=rs_3.getString(2);
						contactnumber1=rs_3.getString(3);
						contactnumber2=rs_3.getString(4);
						address=rs_3.getString(5);
						numofac=rs_3.getString(6);
						servicedate=rs_3.getString(7);
						nextservicedate=rs_3.getString(8);
						
						
						
			        	String[] row= {id,name,contactnumber1,contactnumber2,address,numofac,servicedate,nextservicedate};
			        	model.addRow(row);

					}
			    
					
			     st3.close();
		         connection.close();
		         System.out.println("Opened database successfully end");  
			        
			    	}catch(Exception e1) {
			    		
			    		
			    		
			    		
			    	}
					
				}catch(Exception e1 ){
					
					
					System.out.println(e1.getMessage());
					
					
				}	
					
				

				}
			});
			btn_selected_date.setBorder(new LineBorder(new Color(0, 0, 0)));
			btn_selected_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_selected_date.setBounds(57, 355, 146, 37);
			panel_1.add(btn_selected_date);
			
			
			
	
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_3.setBackground(new Color(227, 227, 227));
			panel_3.setBounds(273, 298, 638, 270);
			panel_1.add(panel_3);
			panel_3.setLayout(null);
			
			flt_name = new JTextField();
			flt_name.setBounds(162, 10, 447, 26);
			panel_3.add(flt_name);
			flt_name.setColumns(10);
			
			flt_con_no = new JTextField();
			flt_con_no.setColumns(10);
			flt_con_no.setBounds(162, 46, 447, 26);
			panel_3.add(flt_con_no);
			
			flt_con_no_2 = new JTextField();
			flt_con_no_2.setColumns(10);
			flt_con_no_2.setBounds(162, 82, 447, 26);
			panel_3.add(flt_con_no_2);
			
			flt_adres = new JTextField();
			flt_adres.setColumns(10);
			flt_adres.setBounds(162, 118, 447, 26);
			panel_3.add(flt_adres);
			
			flt_num_AC = new JTextField();
			flt_num_AC.setColumns(10);
			flt_num_AC.setBounds(162, 154, 447, 26);
			panel_3.add(flt_num_AC);
			
			flt_servicedate = new JTextField();
			flt_servicedate.setColumns(10);
			flt_servicedate.setBounds(162, 190, 447, 26);
			panel_3.add(flt_servicedate);
			
			flt_nextservicedate = new JTextField();
			flt_nextservicedate.setColumns(10);
			flt_nextservicedate.setBounds(162, 226, 447, 26);
			panel_3.add(flt_nextservicedate);
			
			JLabel lb_name = new JLabel("Name");
			lb_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_name.setHorizontalAlignment(SwingConstants.CENTER);
			lb_name.setBounds(10, 10, 142, 26);
			panel_3.add(lb_name);
			
			JLabel lb_no_1 = new JLabel("Contact Number 1");
			lb_no_1.setHorizontalAlignment(SwingConstants.CENTER);
			lb_no_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_no_1.setBounds(10, 46, 142, 26);
			panel_3.add(lb_no_1);
			
			JLabel lb_no_2 = new JLabel("Contact Number 2");
			lb_no_2.setHorizontalAlignment(SwingConstants.CENTER);
			lb_no_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_no_2.setBounds(10, 79, 142, 26);
			panel_3.add(lb_no_2);
			
			JLabel lb_address = new JLabel("Address");
			lb_address.setHorizontalAlignment(SwingConstants.CENTER);
			lb_address.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_address.setBounds(10, 115, 142, 26);
			panel_3.add(lb_address);
			
			JLabel lb_no_of_ac = new JLabel("Number of AC");
			lb_no_of_ac.setHorizontalAlignment(SwingConstants.CENTER);
			lb_no_of_ac.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_no_of_ac.setBounds(10, 154, 142, 26);
			panel_3.add(lb_no_of_ac);
			
			JLabel lb_service_date = new JLabel("Service Date");
			lb_service_date.setHorizontalAlignment(SwingConstants.CENTER);
			lb_service_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_service_date.setBounds(10, 187, 142, 26);
			panel_3.add(lb_service_date);
			
			JLabel lb_nextservicedate = new JLabel("Next Service Date");
			lb_nextservicedate.setHorizontalAlignment(SwingConstants.CENTER);
			lb_nextservicedate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_nextservicedate.setBounds(10, 226, 142, 26);
			panel_3.add(lb_nextservicedate);
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int selectedRow=table.getSelectedRow();
					
					flt_name.setText(table.getModel().getValueAt(selectedRow, 1).toString());
					flt_con_no.setText(table.getModel().getValueAt(selectedRow, 2).toString());
					flt_con_no_2.setText(table.getModel().getValueAt(selectedRow, 3).toString());
					flt_adres.setText(table.getModel().getValueAt(selectedRow, 4).toString());
					flt_num_AC.setText(table.getModel().getValueAt(selectedRow, 5).toString());
					flt_servicedate.setText(table.getModel().getValueAt(selectedRow, 6).toString());
					flt_nextservicedate.setText(table.getModel().getValueAt(selectedRow, 7).toString());
				}
			});
			
		table.setDefaultEditor(Object.class, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	}


