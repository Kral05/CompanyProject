package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mouse;
	private JTextField ram;
	private JTextField lcd;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lcd :");
		lblNewLabel_1.setBounds(124, 103, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ram :");
		lblNewLabel_2.setBounds(124, 131, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mouse :");
		lblNewLabel_3.setBounds(124, 159, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		mouse = new JTextField();
		mouse.setBounds(185, 154, 130, 26);
		contentPane.add(mouse);
		mouse.setColumns(10);
		
		ram = new JTextField();
		ram.setBounds(185, 126, 130, 26);
		contentPane.add(ram);
		ram.setColumns(10);
		
		lcd = new JTextField();
		lcd.setBounds(185, 98, 130, 26);
		contentPane.add(lcd);
		lcd.setColumns(10);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=member.getName();
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				
				Porder p=new Porder(Name,Lcd,Ram,Mouse);
				
				porderserviceimpl.addPorder(p);
				
				
			}
		});
		btnNewButton.setBounds(166, 198, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回主頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_1.setBounds(327, 6, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel MemberatAdd = new JLabel("");
		MemberatAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		MemberatAdd.setBounds(150, 40, 149, 31);
		contentPane.add(MemberatAdd);
		
		MemberatAdd.setText(member.getName()+" 您好!");
	}
}
