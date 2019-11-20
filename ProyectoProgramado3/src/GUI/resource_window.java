package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Objetos.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class resource_window extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtType;
	private JTextField txtCapacity;
	private JTextField txtQuantity;
	private JTextField txtResponsable;
	private DefaultTableModel FormatTableResource;
	private DataBase db = new DataBase();
	
	/**
	 * Create the frame.
	 */
	public resource_window() {
		String[] ColumnResource = {"ID","Name", "Type" ,"Capacity","Quantity", "Responsable"};
        Object[][] dataResource = {{}};
        FormatTableResource= new DefaultTableModel(dataResource, ColumnResource);
		setBounds(100, 100, 700, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#521c34"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 175, 424);
		panel.setBackground(Color.decode("#1f2438"));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtID.getText().length()==0|| txtName.getText().length()==0||
					txtType.getText().length()==0||txtCapacity.getText().length()==0||
					txtQuantity.getText().length()==0||txtResponsable.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter all text fields");
					return;
					}
				else {
					Resource newResource= new Resource(txtID.getText(),txtName.getText(),txtType.getText(),
							txtCapacity.getText(),txtQuantity.getText(),txtResponsable.getText());
					db.save("Resources",newResource);
					JOptionPane.showMessageDialog(null, "Registered Resource");
					return;
				}

				
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\A\u00F1adir.png"));
		btnAdd.setBackground(Color.decode("#1f2438"));
		btnAdd.setBounds(10, 375, 40, 38);
		panel.add(btnAdd);
		
		JButton btnModify = new JButton("");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()<1) {
					JOptionPane.showMessageDialog(null, "You must select the resource.");
					return;
					}
				if (txtID.getText().length()==0|| txtName.getText().length()==0||
						txtType.getText().length()==0||txtCapacity.getText().length()==0||
						txtQuantity.getText().length()==0||txtResponsable.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "Enter all text fields");
						return;
						}
				else {
					TableModel resourceModel=table.getModel();
					int row=table.getSelectedRow();
					System.out.println(row);
					String IDresource=(String) resourceModel.getValueAt(row, 0);
					Resource newResource= new Resource(txtID.getText(),txtName.getText(),txtType.getText(),
							txtCapacity.getText(),txtQuantity.getText(),txtResponsable.getText());
					db.editResource("Resources", new Resource(IDresource, null, null, null, null, null),newResource);
					JOptionPane.showMessageDialog(null, "Resource Modified.");
					return;
				}
				
			}
		});
		btnModify.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Modificar.png"));
		btnModify.setBackground(Color.decode("#1f2438"));
		btnModify.setBounds(72, 375, 40, 38);
		panel.add(btnModify);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()<1) {
					JOptionPane.showMessageDialog(null, "You must select the task.");
					return;
					}
				else {
					TableModel resourceModel=table.getModel();
					int row=table.getSelectedRow();
					System.out.println(row);
					String IDresource=(String) resourceModel.getValueAt(row, 0);
					db.delete("Resources", new Resource(IDresource, null, null, null, null, null));
					JOptionPane.showMessageDialog(null, "Resource Deleted.");
					return;
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Eliminar.png"));
		btnDelete.setBackground(Color.decode("#1f2438"));
		btnDelete.setBounds(125, 375, 40, 38);
		panel.add(btnDelete);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtID.setBounds(10, 57, 155, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(10, 113, 155, 20);
		panel.add(txtName);
		
		txtType = new JTextField();
		txtType.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtType.setColumns(10);
		txtType.setBounds(10, 169, 155, 20);
		panel.add(txtType);
		
		txtCapacity = new JTextField();
		txtCapacity.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(10, 225, 155, 20);
		panel.add(txtCapacity);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(10, 281, 155, 20);
		panel.add(txtQuantity);
		
		txtResponsable = new JTextField();
		txtResponsable.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtResponsable.setColumns(10);
		txtResponsable.setBounds(10, 337, 155, 20);
		panel.add(txtResponsable);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 32, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblName.setBounds(10, 88, 62, 14);
		panel.add(lblName);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblType.setBounds(10, 144, 62, 14);
		panel.add(lblType);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setForeground(Color.WHITE);
		lblCapacity.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCapacity.setBounds(10, 200, 80, 14);
		panel.add(lblCapacity);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblQuantity.setBounds(10, 256, 62, 14);
		panel.add(lblQuantity);
		
		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setForeground(Color.WHITE);
		lblResponsable.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblResponsable.setBounds(10, 312, 102, 14);
		panel.add(lblResponsable);
		
		JLabel lblNewLabel_1 = new JLabel("Create Resources");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 7, 155, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(520, 11, 133, 68);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Mar\u00EDa\\Downloads\\Logo2.png"));
		contentPane.add(lblLogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 92, 452, 340);
		contentPane.add(scrollPane);
		
		table = new JTable(FormatTableResource);
		scrollPane.setViewportView(table);
		
		JButton btnActualize = new JButton("Actualize");
		btnActualize.setForeground(Color.WHITE);
		btnActualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarTabla(FormatTableResource);
				ArrayList<Object> res=db.consult("Resources");
				for(int i=0; i<res.size(); i++) {
					Resource newResource = (Resource) res.get(i);
					String[] newRow= {newResource.getID(),newResource.getName(),newResource.getType(),newResource.getCapacity(),newResource.getQuantity(),newResource.getResponsable()};			
					FormatTableResource.addRow(newRow);
					
				}
			}
		});
		btnActualize.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnActualize.setBackground(Color.DARK_GRAY);
		btnActualize.setBounds(208, 38, 127, 23);
		contentPane.add(btnActualize);
		
		
	}
	public void LimpiarTabla(DefaultTableModel Modelo) {
		while(Modelo.getRowCount() > 1){
		    Modelo.removeRow(1);
		}
	}
}
