package acmanagement;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;


import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame{
	private JPanel contentPane;
	private JComboBox comboBox;
	
	private final String url = "jdbc:postgresql://localhost/db";
    private final String user = "postgres";
    private final String password = "root";
    
    public static String dropdownSelection="";
    private JTextField txt_username;
    private JPasswordField txt_psw;


	
	public Login() {
		
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private  void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.getContentPane().setBackground(new Color(206, 232, 244));
		frame.getContentPane().setForeground(new Color(212, 212, 212));
		frame.setSize(1200, 800);
		
		  Connection connection=null;
		  
		  List<String> ListDBname= new ArrayList<String>();
			
			try {
				
	            connection = DriverManager.getConnection(url, user, password);
	            
	          
	            
	            System.out.println("Connected to the PostgreSQL server successfully.");
	            
	            Statement st = connection.createStatement();
			    String query= "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'ORDER BY table_name;";
			    		
			    		
			    //System.out.println(firstfield_id);
			    ResultSet rs=st.executeQuery(query);
			    ResultSetMetaData rsmd=rs.getMetaData();
			    
			    int i =0;
			    
			    while(rs.next()) {
			    	System.out.println(rs.getString("TABLE_NAME"));
			    	ListDBname.add(rs.getString("TABLE_NAME"));
			    	
			    }
			    
			    

			      
		        System.out.println("Opened database successfully");
			
		        
		        System.out.println(rs);
		        st.close();
		        connection.close();
		        
			}catch(SQLException e1) {
				
				 System.out.println(e1.getMessage());
				
			}
		
		
		
		try {
			
			BufferedImage bufferedImage = ImageIO.read(getClass().getClassLoader().getResource("Images/logo2.png"));
			Image image = bufferedImage.getScaledInstance(350, 100, Image.SCALE_DEFAULT);
			ImageIcon icon = new ImageIcon(image);
			
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setLayout(null);
			
			
			JLabel jLabel = new JLabel();
			jLabel.setBounds(20, 20, 350, 100);
			jLabel.setIcon(icon);
			frame.getContentPane().add(jLabel);
			
		
			
			JLabel lblNewLabel_1 = new JLabel(" Login ");
			lblNewLabel_1.setBounds(330, 295, 489, 75);
			lblNewLabel_1.setForeground(new Color(63, 63, 63));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel name_lbl = new JLabel("E TECH AIR (PVT) LTD");
			name_lbl.setBorder(new LineBorder(null, 2));
			name_lbl.setBackground(new Color(204, 204, 204));
			name_lbl.setForeground(new Color(0, 0, 0));
			name_lbl.setFont(new Font("Tahoma", Font.BOLD, 27));
			name_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			name_lbl.setBounds(330, 143, 489, 116);
			frame.getContentPane().add(name_lbl);
			
			JLabel lb_username = new JLabel("Username :");
			lb_username.setFont(new Font("Tahoma", Font.BOLD, 20));
			lb_username.setHorizontalAlignment(SwingConstants.CENTER);
			lb_username.setBounds(350, 448, 141, 25);
			frame.getContentPane().add(lb_username);
			
			JLabel lb_password = new JLabel("Password :");
			lb_password.setFont(new Font("Tahoma", Font.BOLD, 20));
			lb_password.setHorizontalAlignment(SwingConstants.CENTER);
			lb_password.setBounds(350, 507, 141, 25);
			frame.getContentPane().add(lb_password);
			
			txt_username = new JTextField();
			txt_username.setBounds(538, 448, 281, 26);
			frame.getContentPane().add(txt_username);
			txt_username.setColumns(10);
			
			JButton btn_login = new JButton("LOGIN");
			btn_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String password =txt_psw.getText();
					String username =txt_username.getText();
					
					if (password.contains("Password")&& username.contains("Admin")) {
						
						txt_psw.setText(null);
						txt_username.setText(null);
						
						
					   frame.dispose();
					   Form nw=new Form();
					    nw.setVisible(true);
						//nw.Form();
					   
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
						txt_psw.setText(null);
						txt_username.setText(null);
						
					}
					
					
				}
			});
			btn_login.setFont(new Font("Tahoma", Font.BOLD, 10));
			btn_login.setBounds(538, 568, 132, 34);
			frame.getContentPane().add(btn_login);
			
			JButton btn_reset = new JButton("RESET");
			btn_reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					txt_username.setText(null);
					txt_psw.setText(null);
					
				}
			});
			btn_reset.setFont(new Font("Tahoma", Font.BOLD, 10));
			btn_reset.setBounds(687, 568, 132, 34);
			frame.getContentPane().add(btn_reset);
			
			txt_psw = new JPasswordField();
			txt_psw.setBounds(538, 507, 281, 26);
			frame.getContentPane().add(txt_psw);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		


		
	
		
		
		
		
	}
	 public void Login(){
		  
			
		}
}
