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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_num1;
	private JTextField tf_num2;
	private JTextField tf_Address;
	private JTextField tf_numofservices;
	
	
	private final static String url = "jdbc:postgresql://localhost/ACmanagment";
    private final static String user = "postgres";
    private final static String password = "root";
    
    
    public static String Sendformatted_date_from="";
    public static String Sendformatted_date_to="";
    public static String Sendformatted_time_from="";
    public static String Sendformatted_time_to="";

	/**
	 * Launch the application.
//	 */


	/**
	 * Create the frame.
	 */
	public Form() {
		
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
			
			JPanel panel = new JPanel();
			panel.setBounds(315, 85, 601, 55);
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel.setBackground(new Color(175, 217, 237));
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("A/C Management System");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(120, 10, 341, 35);
			panel.add(lblNewLabel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(193, 150, 853, 603);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_1.setBackground(new Color(175, 217, 237));
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lb_name = new JLabel("Customer Name :");
			lb_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_name.setBounds(126, 54, 167, 21);
			panel_1.add(lb_name);
			
			JLabel lb_number = new JLabel("Contact Number :");
			lb_number.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_number.setBounds(126, 119, 167, 21);
			panel_1.add(lb_number);
			
			tf_name = new JTextField();
			tf_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tf_name.setBounds(303, 50, 382, 31);
			panel_1.add(tf_name);
			tf_name.setColumns(10);
			
			tf_num1 = new JTextField();
			tf_num1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tf_num1.setColumns(10);
			tf_num1.setBounds(303, 115, 382, 31);
			panel_1.add(tf_num1);
			
			JLabel lb_Address = new JLabel("Address :");
			lb_Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_Address.setBounds(126, 226, 167, 21);
			panel_1.add(lb_Address);
			
			tf_num2 = new JTextField();
			tf_num2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tf_num2.setColumns(10);
			tf_num2.setBounds(303, 169, 382, 31);
			panel_1.add(tf_num2);
			
			JLabel lb_num_1 = new JLabel("(1)");
			lb_num_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_num_1.setHorizontalAlignment(SwingConstants.CENTER);
			lb_num_1.setBounds(256, 120, 53, 20);
			panel_1.add(lb_num_1);
			
			JLabel lb_num_2 = new JLabel("(2)");
			lb_num_2.setHorizontalAlignment(SwingConstants.CENTER);
			lb_num_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_num_2.setBounds(256, 174, 53, 20);
			panel_1.add(lb_num_2);
			
			tf_Address = new JTextField();
			tf_Address.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tf_Address.setColumns(10);
			tf_Address.setBounds(303, 222, 382, 31);
			panel_1.add(tf_Address);
			
			JLabel lb_num_of_services = new JLabel("Number of A/C's :");
			lb_num_of_services.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_num_of_services.setBounds(126, 280, 167, 21);
			panel_1.add(lb_num_of_services);
			
			tf_numofservices = new JTextField();
			tf_numofservices.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tf_numofservices.setColumns(10);
			tf_numofservices.setBounds(303, 276, 382, 31);
			panel_1.add(tf_numofservices);
			
			JLabel lb_serviceDate = new JLabel("Services Date :");
			lb_serviceDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_serviceDate.setBounds(36, 344, 167, 21);
			panel_1.add(lb_serviceDate);
			
			JCalendar service_calendar = new JCalendar();
			service_calendar.setBorder(new LineBorder(new Color(0, 0, 0)));
			service_calendar.setBounds(158, 348, 199, 152);
			panel_1.add(service_calendar);
			
			JLabel lb_nextservicedate = new JLabel("Next Services Date :");
			lb_nextservicedate.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_nextservicedate.setBounds(398, 344, 167, 21);
			panel_1.add(lb_nextservicedate);
			
			JCalendar next_service_calendar = new JCalendar();
			next_service_calendar.setBorder(new LineBorder(new Color(0, 0, 0)));
			next_service_calendar.setBounds(561, 348, 199, 152);
			panel_1.add(next_service_calendar);
			
			JButton btn_Sub = new JButton("SUBMIT");
			btn_Sub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
			LocalDate localDate = LocalDate.now();
				Date date=Date.valueOf(localDate);
//					System.out.println(localDate);
//					System.out.println(date);
//					
//					Calendar c = Calendar.getInstance();
//					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//
//			        c.add(date.getDate(), 7);
//			        System.out.println(df.format(c.getTime()));

					
					String bname,bnum1,bnum2,baddress,bnumofAC;
					
					String strDateFormat = "HH:mm:ss a";
					SimpleDateFormat format2 = new SimpleDateFormat(strDateFormat);
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");          
					
					
					
					bname= tf_name.getText();
					bnum1=tf_num1.getText();  
					bnum2=tf_num2.getText();
					baddress=tf_Address.getText();
					bnumofAC=tf_numofservices.getText();
					String formatted_date_from=format1.format(service_calendar.getDate());
					String formatted_date_to=format1.format(next_service_calendar.getDate());
					
					Sendformatted_date_from=formatted_date_from;
					Sendformatted_date_to=formatted_date_to;
					
					
					JTable table = null;
					  Connection connection=null;
					  
					  
					  try {
						  if(bnumofAC.trim().isEmpty()) {
							  
							  bnumofAC="0";
						  }
						  
						  if(!bname.isEmpty() && !bnum1.trim().isEmpty()  && !baddress.trim().isEmpty() && !formatted_date_from.trim().isEmpty() && !formatted_date_to.trim().isEmpty()) {
							 
							  try {
								  
							  
							  int num1=Integer.parseInt(bnum1);
							 
							  if(!bnum2.trim().isEmpty()) {
								
								  int num2=Integer.parseInt(bnum2);
								  
							  }else {
								  
								  bnum2="0";
								  
							  }
							  
							  connection = DriverManager.getConnection(url, user, password);
							  
							  System.out.println(bname);
					            
					            System.out.println("Connected to the PostgreSQL server successfully.");
					            
					            Statement st = connection.createStatement();
					            
								System.out.println(" from data saved in DB ");
							    String query="INSERT INTO public.acdetails(name,contactnumber1,contactnumber2,address,numofac,servicedate,nextservicedate) VALUES(";
							    String query2="'"+bname.toLowerCase()+"',"+bnum1+","+bnum2+",'"+baddress+"',"+bnumofAC+",'"+formatted_date_from+"','"+formatted_date_to+"');";
							    
							    try {
							    ResultSet rs=st.executeQuery(query+query2);
							    ResultSetMetaData rsmd=rs.getMetaData();
							    }catch(SQLException e1) {}
							  
					
							   
							    
						        System.out.println("Opened database successfully");
						       // String name,name2,name3,name4;
						        
						       
						        st.close();
						        connection.close();
						        JOptionPane.showMessageDialog(null, " Sucessfully Submitted "," Done ",JOptionPane.INFORMATION_MESSAGE);
						        
						        
						        
							  }catch(Exception e1) {
								  
								  JOptionPane.showMessageDialog(null, " Phone number format error "," Format Error",JOptionPane.ERROR_MESSAGE);
								  
							  }  
							     
						  }else {
							  
							  JOptionPane.showMessageDialog(null, " Enter required fields ","Error",JOptionPane.ERROR_MESSAGE);
							  
							  
						  }
						 
					  }catch(Exception e1){
						  
						  JOptionPane.showMessageDialog(null, " Entered invalid or Database connection Error  ","Database Error",JOptionPane.ERROR_MESSAGE);
						  
						  System.out.println(e1.getMessage());
						  
					  }
					  
				
					  
					    tf_name.setText(null);
				        tf_num1.setText(null);
				        tf_num2.setText(null);
				        tf_Address.setText(null);
				        tf_numofservices.setText(null);
				        service_calendar.setDate(date);
				        next_service_calendar.setDate(date);  
				}
				
				
			});
			btn_Sub.setBorder(new LineBorder(new Color(0, 0, 0)));
			btn_Sub.setBackground(new Color(255, 255, 255));
			btn_Sub.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_Sub.setBounds(158, 539, 143, 31);
			panel_1.add(btn_Sub);
			
			JButton btn_reset = new JButton("RESET");
			btn_reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					  LocalDate localDate1 = LocalDate.now();
						Date date1=Date.valueOf(localDate1);
					
					tf_name.setText(null);
			        tf_num1.setText(null);
			        tf_num2.setText(null);
			        tf_Address.setText(null);
			        tf_numofservices.setText(null);
			        service_calendar.setDate(date1);
			        next_service_calendar.setDate(date1); 
				}
			});
			btn_reset.setBorder(new LineBorder(new Color(0, 0, 0)));
			btn_reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_reset.setBackground(new Color(255, 255, 255));
			btn_reset.setBounds(561, 539, 143, 31);
			panel_1.add(btn_reset);
			
			JLabel lb_name_1 = new JLabel("*");
			lb_name_1.setBackground(new Color(255, 0, 0));
			lb_name_1.setForeground(new Color(251, 29, 4));
			lb_name_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lb_name_1.setBounds(695, 57, 58, 21);
			panel_1.add(lb_name_1);
			
			JLabel lb_name_1_1 = new JLabel("*");
			lb_name_1_1.setForeground(new Color(251, 29, 4));
			lb_name_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lb_name_1_1.setBackground(Color.RED);
			lb_name_1_1.setBounds(695, 119, 58, 21);
			panel_1.add(lb_name_1_1);
			
			JLabel lb_name_1_2 = new JLabel("*");
			lb_name_1_2.setForeground(new Color(251, 29, 4));
			lb_name_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lb_name_1_2.setBackground(Color.RED);
			lb_name_1_2.setBounds(695, 226, 58, 21);
			panel_1.add(lb_name_1_2);
			
			JLabel lb_name_1_3 = new JLabel("*");
			lb_name_1_3.setForeground(new Color(251, 29, 4));
			lb_name_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lb_name_1_3.setBackground(Color.RED);
			lb_name_1_3.setBounds(367, 351, 21, 21);
			panel_1.add(lb_name_1_3);
			
			JLabel lb_name_1_4 = new JLabel("*");
			lb_name_1_4.setForeground(new Color(251, 29, 4));
			lb_name_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lb_name_1_4.setBackground(Color.RED);
			lb_name_1_4.setBounds(771, 351, 21, 21);
			panel_1.add(lb_name_1_4);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_2.setBackground(new Color(169, 214, 235));
			panel_2.setBounds(10, 150, 173, 217);
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
			
			JButton Manu_back = new JButton("New Form");
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
			
			JButton Select_back = new JButton("Services");
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
			
			JButton updated2 = new JButton("Update Form");
			updated2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					   dispose();
					   Update nw=new Update();
					    nw.setVisible(true);
				}
			});
			updated2.setBorder(new LineBorder(new Color(0, 0, 0)));
			updated2.setBounds(10, 151, 153, 33);
			panel_2.add(updated2);
			
		
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
