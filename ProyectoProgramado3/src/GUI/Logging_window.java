package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import Objetos.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Logging_window {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPassword;
	private DataBase db = new DataBase();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logging_window window = new Logging_window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Logging_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#521c34"));
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblUser.setBounds(92, 83, 108, 14);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPassword.setBounds(92, 139, 108, 14);
		frame.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(72, 108, 145, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(72, 166, 145, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtUser.getText().length()==0|| txtPassword.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter all text fields");
					return;
				}
				ArrayList<Object> res=db.consult("Employees", new Employee(txtUser.getText(), null, txtPassword.getText()));
				if(res.size()>0) {
					Main_window newMainWindow= new Main_window();
					newMainWindow.setVisible(true);
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong User");
					txtUser.setText("");
					txtPassword.setText("");
					return;
				}
				
			}
		});
		btnLogIn.setBackground(Color.decode("#1f2438"));
		btnLogIn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBounds(92, 197, 108, 23);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\LogoP.png"));
		lblLogo.setBounds(10, 11, 100, 50);
		frame.getContentPane().add(lblLogo);
		
		JButton btnRegister_user = new JButton();
		btnRegister_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register_employee_window newWindowRE= new Register_employee_window();
				newWindowRE.setVisible(true);
			}
		});
		btnRegister_user.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\AddrUser.png"));
		btnRegister_user.setBackground(Color.decode("#521c34"));
		btnRegister_user.setBounds(225, 219, 49, 50);
		frame.getContentPane().add(btnRegister_user);
		frame.setBounds(100, 100, 300, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
