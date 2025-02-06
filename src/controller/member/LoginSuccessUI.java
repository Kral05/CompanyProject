package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import controller.porder.PorderMainUI;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Member member=(Member)Tool.read("member.txt");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
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
	public LoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setBounds(194, 128, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel showMember = new JLabel("");
		showMember.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		showMember.setBounds(133, 41, 183, 55);
		contentPane.add(showMember);
		
		showMember.setText(member.getName()+"  歡迎您!");
		
		JButton btnNewButton = new JButton("進入購物");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderMainUI pordermain=new PorderMainUI();
				pordermain.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(166, 171, 117, 29);
		contentPane.add(btnNewButton);
	}

}
