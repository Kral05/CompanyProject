package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField mobile;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(125, 32, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setBounds(125, 63, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setBounds(125, 94, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setBounds(125, 125, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("電話");
		lblNewLabel_4.setBounds(125, 156, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("手機");
		lblNewLabel_5.setBounds(125, 187, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(166, 23, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(166, 55, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(166, 87, 130, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(166, 119, 130, 26);
		contentPane.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(166, 151, 130, 26);
		contentPane.add(phone);
		phone.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(166, 183, 130, 26);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				
				if(new MemberServiceImpl().isUsernameBeenUse(Username))
				{
					AddMemberErrorUI addmembererror=new AddMemberErrorUI();
					addmembererror.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					String Mobile=mobile.getText();
					
					Member member=new Member(Name,Username,Password,Address,Phone,Mobile);
					
					new MemberServiceImpl().addMember(member);
					
					AddMemberSuccessUI addmembersuccess=new AddMemberSuccessUI();
					addmembersuccess.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(166, 215, 117, 29);
		contentPane.add(btnNewButton);
	}
}
