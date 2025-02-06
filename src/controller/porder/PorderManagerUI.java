package controller.porder;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mouse;
	private JTextField ram;
	private JTextField lcd;
	private JTextField deleteId;
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JTextField updateId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 220, 200);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JLabel lblNewLabel = new JLabel("Lcd：");
		lblNewLabel.setBounds(238, 79, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ram：");
		lblNewLabel_1.setBounds(238, 107, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mouse：");
		lblNewLabel_2.setBounds(238, 135, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		mouse = new JTextField();
		mouse.setBounds(295, 130, 61, 26);
		contentPane.add(mouse);
		mouse.setColumns(10);
		
		ram = new JTextField();
		ram.setColumns(10);
		ram.setBounds(295, 102, 61, 26);
		contentPane.add(ram);
		
		lcd = new JTextField();
		lcd.setColumns(10);
		lcd.setBounds(295, 74, 61, 26);
		contentPane.add(lcd);
		
		
		
		JLabel lblId = new JLabel("Id：");
		lblId.setBounds(417, 135, 61, 16);
		contentPane.add(lblId);
		
		deleteId = new JTextField();
		deleteId.setColumns(10);
		deleteId.setBounds(451, 130, 61, 26);
		contentPane.add(deleteId);
		
		JLabel lblId_1 = new JLabel("Id：");
		lblId_1.setBounds(238, 51, 61, 16);
		contentPane.add(lblId_1);
		
		updateId = new JTextField();
		updateId.setColumns(10);
		updateId.setBounds(295, 46, 61, 26);
		contentPane.add(updateId);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(porderserviceimpl.AllPorder());
				
			}
		});
		btnNewButton.setBounds(61, 218, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id=Integer.parseInt(updateId.getText());
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				
				
				porderserviceimpl.updatePorder(Lcd, Ram, Mouse, Id);
			}
		});
		btnNewButton_1.setBounds(239, 218, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id=Integer.parseInt(deleteId.getText());
				porderserviceimpl.deletePorderById(Id);
			}
		});
		btnNewButton_2.setBounds(417, 218, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("回主頁");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_3.setBounds(472, 3, 117, 29);
		contentPane.add(btnNewButton_3);
	}
}
