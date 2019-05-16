package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.User;
import ObjectClass.UserDao;
import ObjectClass.UserDaoImp;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterWindows extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JTextField userPhoneText;
	private JTextField userAdressText;
	private JPasswordField userPasswordText;
	private JTextField userSexText;
	private JTextField userPositionText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindows frame = new RegisterWindows();
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
	public RegisterWindows() {
		setTitle("\u804C\u5DE5\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u804C\u5DE5\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(242, 25, 75, 26);
		panel.add(lblNewLabel);
		
		userNameText = new JTextField();
		userNameText.setBounds(317, 25, 109, 26);
		panel.add(userNameText);
		userNameText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(242, 76, 75, 26);
		panel.add(label_1);
		
		userPhoneText = new JTextField();
		userPhoneText.setBounds(317, 76, 109, 26);
		panel.add(userPhoneText);
		userPhoneText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(242, 132, 75, 26);
		panel.add(lblNewLabel_1);
		
		userAdressText = new JTextField();
		userAdressText.setBounds(317, 132, 109, 24);
		panel.add(userAdressText);
		userAdressText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u804C\u5DE5\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(242, 181, 75, 24);
		panel.add(lblNewLabel_2);
		
		userPasswordText = new JPasswordField();
		userPasswordText.setBounds(317, 181, 109, 28);
		panel.add(userPasswordText);
		
		JLabel lblNewLabel_3 = new JLabel("\u804C\u5DE5\u6027\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(242, 235, 75, 24);
		panel.add(lblNewLabel_3);
		
		userSexText = new JTextField();
		userSexText.setBounds(317, 235, 109, 24);
		panel.add(userSexText);
		userSexText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u804C\u5DE5\u804C\u4F4D\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(242, 285, 75, 26);
		panel.add(lblNewLabel_4);
		
		userPositionText = new JTextField();
		userPositionText.setBounds(317, 285, 109, 26);
		panel.add(userPositionText);
		userPositionText.setColumns(10);
		
		JButton userInReSetBu = new JButton("\u91CD\u7F6E");
		userInReSetBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userNameText.setText("");
				userPhoneText.setText("");
				userAdressText.setText("");
				userPositionText.setText("");
				userPasswordText.setText("");
				userSexText.setText("");
			}
		});
		userInReSetBu.setBounds(241, 365, 93, 23);
		panel.add(userInReSetBu);
		
		JButton userRegisterBu = new JButton("\u6CE8\u518C");
		userRegisterBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userName=userNameText.getText().toString();
				String userPhone=userPhoneText.getText().toString();
				String userAdress=userAdressText.getText().toString();
				String userPassword=userPasswordText.getText().toString();
				String userSex=userSexText.getText().toString();
				String userPosition=userPositionText.getText().toString();
				UserDao userDao=new UserDaoImp();
				User user=new User();
				user.setUserName(userName);
				user.setUserAdress(userAdress);
				user.setUserPassword(userPassword);
				user.setUserPhone(userPhone);
				user.setUserPosition(userPosition);
				user.setUserSex(userSex);
				userDao.add(user);
			}
		});
		userRegisterBu.setBounds(333, 365, 93, 23);
		panel.add(userRegisterBu);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u804C\u5DE5\u6CE8\u518C");
		label.setFont(new Font("楷体", Font.BOLD, 25));
		panel_1.add(label);
	}
}
