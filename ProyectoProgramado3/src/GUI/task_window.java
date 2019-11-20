package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Objetos.*;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class task_window extends JFrame {

	private JPanel contentPane;
	private JTextField txtType;
	private JTextField txtID;
	private JTextField txtDescription;
	private JTextField txtEffort;
	private JTextField txtResponsible;
	private JLabel lblId;
	private JLabel label;
	private JLabel lblDescription;
	private JLabel lblEffort;
	private JLabel lblResponsible;
	private JLabel lblCreateTasks;
	private JTable table;
	private JButton btnModify;
	private DefaultTableModel FormatTableTasks;
	private DataBase db = new DataBase();

	/**
	 * Create the frame.
	 */
	public task_window() {
		String[] ColumnTasks = {"Type", "ID" ,"Description","Effort", "Responsible"};
        Object[][] dataTask = {{}};
        FormatTableTasks= new DefaultTableModel(dataTask, ColumnTasks);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#521c34"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1f2438"));
		panel.setBounds(10, 11, 175, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtType = new JTextField();
		txtType.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtType.setBounds(10, 101, 155, 20);
		panel.add(txtType);
		txtType.setColumns(10);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtID.setColumns(10);
		txtID.setBounds(10, 157, 155, 20);
		panel.add(txtID);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtDescription.setColumns(10);
		txtDescription.setBounds(10, 213, 155, 20);
		panel.add(txtDescription);
		
		txtEffort = new JTextField();
		txtEffort.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtEffort.setColumns(10);
		txtEffort.setBounds(10, 269, 155, 20);
		panel.add(txtEffort);
		
		txtResponsible = new JTextField();
		txtResponsible.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtResponsible.setColumns(10);
		txtResponsible.setBounds(10, 325, 155, 20);
		panel.add(txtResponsible);
		
		lblId = new JLabel("Type:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblId.setBounds(10, 76, 46, 14);
		panel.add(lblId);
		
		label = new JLabel("ID:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label.setBounds(10, 132, 46, 14);
		panel.add(label);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDescription.setBounds(10, 188, 102, 14);
		panel.add(lblDescription);
		
		lblEffort = new JLabel("Effort:");
		lblEffort.setForeground(Color.WHITE);
		lblEffort.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEffort.setBounds(10, 244, 66, 14);
		panel.add(lblEffort);
		
		lblResponsible = new JLabel("Responsible:");
		lblResponsible.setForeground(Color.WHITE);
		lblResponsible.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblResponsible.setBounds(10, 300, 102, 14);
		panel.add(lblResponsible);
		
		lblCreateTasks = new JLabel("Create tasks");
		lblCreateTasks.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateTasks.setForeground(Color.WHITE);
		lblCreateTasks.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCreateTasks.setBounds(10, 11, 144, 38);
		panel.add(lblCreateTasks);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtType.getText().length()==0||txtID.getText().length()==0||txtDescription.getText().length()==0
					||txtEffort.getText().length()==0||txtResponsible.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter all text fields");
					return;
				}
				else {
					Task newTask= new Task(txtType.getText(),txtID.getText(),txtDescription.getText(),txtEffort.getText(),txtResponsible.getText());
					db.save("Tasks",newTask);
					JOptionPane.showMessageDialog(null, "Registered Task");
					return;
				}
			
			}
		});
		btnAdd.setBackground(Color.decode("#1f2438"));
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\A\u00F1adir.png"));
		btnAdd.setBounds(10, 375, 40, 38);
		panel.add(btnAdd);
		
		btnModify = new JButton("");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()<1) {
					JOptionPane.showMessageDialog(null, "You must select the task.");
					return;
					}
				if(txtType.getText().length()==0||txtID.getText().length()==0||txtDescription.getText().length()==0
						||txtEffort.getText().length()==0||txtResponsible.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "Enter all text fields");
						return;
					}
				else {
					TableModel resourceModel=table.getModel();
					int row=table.getSelectedRow();
					System.out.println(row);
					String IDtask=(String) resourceModel.getValueAt(row, 1);
					Task newTask= new Task(txtType.getText(),txtID.getText(),txtDescription.getText(),txtEffort.getText(),txtResponsible.getText());
					db.editTask("Tasks", new Task(null, IDtask, null, null, null), newTask);
					JOptionPane.showMessageDialog(null, "Task Modified.");
					return;
				}
				
				
			}
		});
		btnModify.setBackground(Color.decode("#1f2438"));
		btnModify.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Modificar.png"));
		btnModify.setBounds(72, 375, 40, 38);
		panel.add(btnModify);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow()<1) {
					JOptionPane.showMessageDialog(null, "You must select the task.");
					return;
					}
				else {
					TableModel taskModel=table.getModel();
					int row=table.getSelectedRow();
					System.out.println(row);
					String IDtask=(String) taskModel.getValueAt(row, 1);
					db.delete("Tasks", new Task(null, IDtask, null, null, null));
					JOptionPane.showMessageDialog(null, "Task Deleted.");
					return;
				}
				
			}
		});
		btnDelete.setBackground(Color.decode("#1f2438"));
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Eliminar.png"));
		btnDelete.setBounds(125, 375, 40, 38);
		panel.add(btnDelete);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\LogoP.png"));
		lblLogo.setBounds(560, 11, 100, 50);
		contentPane.add(lblLogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 72, 452, 360);
		contentPane.add(scrollPane);
		
		table = new JTable(FormatTableTasks);
		scrollPane.setViewportView(table);
		
		JButton btnActualize = new JButton("Actualize");
		btnActualize.setForeground(Color.WHITE);
		btnActualize.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnActualize.setBackground(Color.decode("#1f2438"));
		btnActualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarTabla(FormatTableTasks);
				ArrayList<Object> res=db.consult("Tasks");
				for(int i=0; i<res.size(); i++) {
					Task newTask = (Task) res.get(i);
					String[] newRow= {newTask.getType(),newTask.getID(),newTask.getDescription(),newTask.getEffort(),newTask.getResponsible()};			
					FormatTableTasks.addRow(newRow);
					
				}
			}
		});
		btnActualize.setBounds(208, 38, 127, 23);
		contentPane.add(btnActualize);
	}
	public void LimpiarTabla(DefaultTableModel Modelo) {
		while(Modelo.getRowCount() > 1){
		    Modelo.removeRow(1);
		}
	}
}
