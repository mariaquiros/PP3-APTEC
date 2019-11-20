package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Register_employee_window extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	private DataBase db = new DataBase();

	/**
	 * Create the frame.
	 */
	public Register_employee_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#521c34"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterEmployee = new JLabel("Register Employee");
		lblRegisterEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterEmployee.setForeground(new Color(255, 255, 255));
		lblRegisterEmployee.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblRegisterEmployee.setBounds(10, 11, 197, 32);
		contentPane.add(lblRegisterEmployee);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblName.setBounds(30, 49, 197, 32);
		contentPane.add(lblName);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblID.setBounds(30, 109, 197, 32);
		contentPane.add(lblID);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPassword.setBounds(30, 172, 197, 32);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblConfirmPassword.setBounds(30, 240, 197, 32);
		contentPane.add(lblConfirmPassword);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtName.setBounds(40, 78, 177, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtID.setColumns(10);
		txtID.setBounds(40, 141, 177, 20);
		contentPane.add(txtID);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtPassword.setColumns(10);
		txtPassword.setBounds(40, 209, 177, 20);
		contentPane.add(txtPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(40, 280, 177, 20);
		contentPane.add(txtConfirmPassword);
		
		JButton btnCheck_in = new JButton("");
		btnCheck_in.setBackground(SystemColor.decode("#521c34"));
		btnCheck_in.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\AddrUser.png"));
		btnCheck_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtName.getText().length()==0||txtID.getText().length()==0||
				txtPassword.getText().length()==0||txtConfirmPassword.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter all text fields");
					return;
				}
				else if(txtPassword.getText().equals(txtConfirmPassword.getText())) {
					Employee newEmployee = new Employee(txtName.getText(),txtID.getText(),txtPassword.getText());
					db.save("Employees",newEmployee);
					JOptionPane.showMessageDialog(null, "User Created");
					txtName.setText("");
					txtID.setText("");
					txtPassword.setText("");
					txtConfirmPassword.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect password, enter the same password");
					txtName.setText("");
					txtID.setText("");
					txtPassword.setText("");
					txtConfirmPassword.setText("");
					return;
				}
				
			}
		});
		btnCheck_in.setBounds(284, 260, 50, 50);
		contentPane.add(btnCheck_in);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:/Users/Mar%EDa/Desktop/ProyectoProgramado3/src/LogoP.png"));
		lblNewLabel.setBounds(234, 11, 100, 50);
		contentPane.add(lblNewLabel);
	}
}
