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
import javax.swing.JOptionPane;
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

public class Update extends JFrame {

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
    private JTextField tf_update;
    
    String id="";

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Update() {
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		getContentPane().setBackground(new Color(206, 232, 244));
	    getContentPane().setForeground(new Color(212, 212, 212));
		setSize(1200, 800);
		
		
	
		contentPane = new JPanel();
		

		try {
			
			BufferedImage bufferedImage = ImageIO.read(getClass().getClassLoader().getResource("Images/logo2.png"));
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
			
			JButton updated = new JButton("Update Form");
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
			
			JLabel lb_select_nextservices = new JLabel("Search Customer Name");
			lb_select_nextservices.setBorder(new LineBorder(new Color(0, 0, 0)));
			lb_select_nextservices.setFont(new Font("Tahoma", Font.BOLD, 15));
			lb_select_nextservices.setHorizontalAlignment(SwingConstants.CENTER);
			lb_select_nextservices.setBounds(22, 51, 225, 37);
			panel_1.add(lb_select_nextservices);
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(273, 51, 657, 198);
			panel_1.add(scrollPane);
			
			table = new JTable();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			scrollPane.setViewportView(table);
			
			
		
			
			
			
			JButton btn_selected_date = new JButton("Search");
			btn_selected_date.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					   Connection connection=null;
				if(!tf_update.getText().trim().isEmpty()) {
					
					String update_tf =tf_update.getText().trim()+" ";
					String[] searchIndex=update_tf.split(" ");
					System.out.println(searchIndex.length);
					String searchQuery="";
					
					if(searchIndex.length>1) {
						
						for(int i=1; i<(searchIndex.length);i++) {
							
							searchQuery=searchQuery+" or name LIKE '%"+searchIndex[i]+"%'";
							
						}
						
						searchQuery="SELECT * FROM public.acdetails WHERE name LIKE '%"+searchIndex[0]+"%'"+searchQuery+";";
						 
						 
					}else{
						
						searchQuery="SELECT * FROM public.acdetails WHERE name LIKE '%"+searchIndex[0]+"%';";
			      }
					System.out.println(searchQuery);
					
				try {
					
					connection = DriverManager.getConnection(url, user, password);
					
			        
			    	try {
			            
			            
			            
			        Statement st3 = connection.createStatement();
			        
			        
			        String query_3=searchQuery; 
			        System.out.println(query_3);
			        ResultSet rs_3=st3.executeQuery(query_3);
			        System.out.println(rs_3);
			        ResultSetMetaData rsmd=rs_3.getMetaData();
				    
			      
				    
				    int cols=rsmd.getColumnCount();
				    String[] colName={"id","name","contactnumber1","contactnumber2","address","numofac","servicedate","nextservicedate"};
				    
//				    for(int i=0;i<cols;i++)
//				    	colName[i]=rsmd.getColumnName(i+1);
				    model.setColumnIdentifiers(colName);	
				    connection.setAutoCommit(false);
				    
			      
				    
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
		    
			        
			    	}catch(Exception e1) {
			    		
			    		
			    		
			    		
			    	}
					
				}catch(Exception e1 ){
					
					
					System.out.println(e1.getMessage());
					
					
				}
				
			}else {
				
				JOptionPane.showMessageDialog(null, " Search field is empty ","Search Error",JOptionPane.ERROR_MESSAGE);
				
				
				
			}
					
				

				}
			});
			btn_selected_date.setBorder(new LineBorder(new Color(0, 0, 0)));
			btn_selected_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btn_selected_date.setBounds(60, 155, 146, 37);
			panel_1.add(btn_selected_date);
			
			
			
	
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_3.setBackground(new Color(227, 227, 227));
			panel_3.setBounds(273, 259, 657, 309);
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
			
			
			
			
			tf_update = new JTextField();
			tf_update.setBounds(22, 106, 225, 28);
			panel_1.add(tf_update);
			tf_update.setColumns(10);
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int selectedRow=table.getSelectedRow();
					
					id=table.getModel().getValueAt(selectedRow, 0).toString();
					
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
		

		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		        System.out.println(id);
				 Connection connection=null;
				
				if(id!="") {
					
					try {
						
						connection = DriverManager.getConnection(url, user, password);
						
				        
				    	try {
				            
				            
				            
				        Statement st3 = connection.createStatement();
				        
				        int cnumber1=Integer.parseInt(flt_con_no.getText());
				        
				        if(flt_con_no_2.getText().trim().isEmpty()) {
			        		
			        		flt_con_no_2.setText("0");
			        		
			        	}else {
			        		
			        		int cnumber2=Integer.parseInt(flt_con_no_2.getText());
			        		
			        	}
						if(flt_num_AC.getText().trim().isEmpty()) {
												        		
							flt_num_AC.setText("0");
												        		
						}else {
							
							int acnum=Integer.parseInt(flt_num_AC.getText());
							
							
						}
			        
				        
				        
				        
				        if(!flt_name.getText().trim().isEmpty()  && !flt_con_no.getText().trim().isEmpty() && !flt_adres.getText().trim().isEmpty() && !flt_servicedate.getText().trim().isEmpty() && !flt_nextservicedate.getText().trim().isEmpty()) {
				        	
				        	
				        
				        String query_3="UPDATE public.acdetails SET name='"+flt_name.getText()+"',contactnumber1="+flt_con_no.getText()+",contactnumber2="+flt_con_no_2.getText()+",address='"+flt_adres.getText()+"',numofac="+flt_num_AC.getText()+",servicedate='"+flt_servicedate.getText()+"',nextservicedate='"+flt_nextservicedate.getText()+"' WHERE id = "+id+";";
				        System.out.println(query_3);
				        
				        
				        try {
				        	
				        ResultSet rs_3=st3.executeQuery(query_3);
				        System.out.println(rs_3+"query excuted");
				        ResultSetMetaData rsmd=rs_3.getMetaData();
				        
				        }catch(Exception e1){
				        	
				        	
				        	
				        }
				        System.out.println("Connected to the PostgreSQL server successfully.3");
				
						
				     st3.close();
			         connection.close();
			         System.out.println("Opened database successfully end-------------"); 
			         model.setRowCount(0);
			         
			         JOptionPane.showMessageDialog(null, " Sucessfully Updated " +id ,"Update sucessful",JOptionPane.INFORMATION_MESSAGE);
			         
			           id="";
			           flt_name.setText("");
						flt_con_no.setText("");
						flt_con_no_2.setText("");
						flt_adres.setText("");
						flt_num_AC.setText("");
						flt_servicedate.setText("");
						flt_nextservicedate.setText("");
						tf_update.setText("");
						
				        }else {
				        	
				        	
				        	JOptionPane.showMessageDialog(null, " Fill all the required field  "," Error",JOptionPane.ERROR_MESSAGE);
				        	
				        }
				    	}catch(Exception e1) {
				    		
				    		
				    		JOptionPane.showMessageDialog(null, " Enter valid value  ","Update Error",JOptionPane.ERROR_MESSAGE);
				    		System.out.println(e1); 
				    		
				    	}
						
					}catch(Exception e1 ){
						
						
						System.out.println(e1.getMessage());
						
						JOptionPane.showMessageDialog(null, " Database connection Error  ","Database Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					
					JOptionPane.showMessageDialog(null, " Select a data row to update ","Update Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_update.setBounds(478, 262, 131, 37);
		panel_3.add(btn_update);
		
		JLabel lb_name_1_3 = new JLabel("*");
		lb_name_1_3.setForeground(new Color(251, 29, 4));
		lb_name_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb_name_1_3.setBackground(Color.RED);
		lb_name_1_3.setBounds(619, 16, 19, 20);
		panel_3.add(lb_name_1_3);
		
		JLabel lb_name_1_3_1 = new JLabel("*");
		lb_name_1_3_1.setForeground(new Color(251, 29, 4));
		lb_name_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb_name_1_3_1.setBackground(Color.RED);
		lb_name_1_3_1.setBounds(619, 52, 19, 20);
		panel_3.add(lb_name_1_3_1);
		
		JLabel lb_name_1_3_2 = new JLabel("*");
		lb_name_1_3_2.setForeground(new Color(251, 29, 4));
		lb_name_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb_name_1_3_2.setBackground(Color.RED);
		lb_name_1_3_2.setBounds(619, 121, 19, 20);
		panel_3.add(lb_name_1_3_2);
		
		JLabel lb_name_1_3_3 = new JLabel("*");
		lb_name_1_3_3.setForeground(new Color(251, 29, 4));
		lb_name_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb_name_1_3_3.setBackground(Color.RED);
		lb_name_1_3_3.setBounds(619, 196, 19, 20);
		panel_3.add(lb_name_1_3_3);
		
		JLabel lb_name_1_3_4 = new JLabel("*");
		lb_name_1_3_4.setForeground(new Color(251, 29, 4));
		lb_name_1_3_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb_name_1_3_4.setBackground(Color.RED);
		lb_name_1_3_4.setBounds(619, 232, 19, 20);
		panel_3.add(lb_name_1_3_4);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	}


