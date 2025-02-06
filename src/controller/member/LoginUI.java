package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import controller.member.AddMemberUI;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(94, 75, 61, 16);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(153, 70, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(94, 114, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(153, 109, 130, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				Member member=new MemberServiceImpl().Login(Username, Password);
				
				if(member!=null)
				{
					Tool.save(member, "member.txt");
					LoginSuccessUI loginsuccess=new LoginSuccessUI();
					loginsuccess.setVisible(true);
					
					dispose();
				}
				else
				{
					LoginErrorUI loginerror=new LoginErrorUI();
					loginerror.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(94, 160, 117, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddMemberUI addmember=new AddMemberUI();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(223, 160, 117, 29);
		contentPane.add(btnNewButton_1);
		
	}
}