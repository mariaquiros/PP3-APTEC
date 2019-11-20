package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.DataBase;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Main_window extends JFrame {

	private JPanel contentPane;
	private DataBase db = new DataBase();


	/**
	 * Create the frame.
	 */
	public Main_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200,720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#521c34"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Logo2.png"));
		lblNewLabel.setBounds(10, 11, 200, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnResources = new JButton("");
		btnResources.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Recursos.png"));
		btnResources.setBackground(Color.decode("#1f2438"));
		btnResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resource_window newWindowResource= new resource_window();
				newWindowResource.setVisible(true);
			}
		});
		btnResources.setBounds(1124, 620, 50, 50);
		contentPane.add(btnResources);
		
		JButton btnTask = new JButton("");
		btnTask.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\task.png"));
		btnTask.setBackground(Color.decode("#1f2438"));
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				task_window newWindowTaks= new task_window();
				newWindowTaks.setVisible(true);
			}
		});
		btnTask.setBounds(1064, 620, 50, 50);
		contentPane.add(btnTask);
		
		JButton btnWBS = new JButton("WBS");
		btnWBS.setBackground(Color.decode("#1f2438"));
		btnWBS.setForeground(Color.WHITE);
		btnWBS.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnWBS.setBounds(10, 647, 130, 23);
		contentPane.add(btnWBS);
		
		JButton btnCriticalRoute = new JButton("Critical Route");
		btnCriticalRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriticalRoute.setForeground(Color.WHITE);
		btnCriticalRoute.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnCriticalRoute.setBackground(Color.decode("#1f2438"));
		btnCriticalRoute.setBounds(150, 647, 130, 23);
		contentPane.add(btnCriticalRoute);
	}
}
