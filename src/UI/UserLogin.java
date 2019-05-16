package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.NowUser;
import ObjectClass.NowUserDao;
import ObjectClass.NowUserDaoImp;
import ObjectClass.UserDao;
import ObjectClass.UserDaoImp;
import Util.WindowXY;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userNoText;
	private JPasswordField userPasswordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		this.setLocation(Util.WindowXY.getPoint(this.getSize()));
		setTitle("\u7BA1\u7406\u8005\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		userNoText = new JTextField();
		userNoText.setText("\u8BF7\u8F93\u5165\u5458\u5DE5\u53F7\u7801");
		userNoText.setToolTipText("");
		userNoText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton userLoginBu = new JButton("\u767B\u5F55");
		userLoginBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userNo=Integer.valueOf(userNoText.getText());
				String userPassword=userPasswordText.getText().toString();
				UserDao userDao=new UserDaoImp();
				String password=null;
				password=userDao.queryByUserNo(userNo);
				if(password!=null&&password.equals(userPassword)) {
					HouseSystemWindows w=new HouseSystemWindows(userNo);
					NowUserDao nowUserDao=new NowUserDaoImp();
					nowUserDao.updateByhouseNO("001", userNoText.getText().toString());
				w.setVisible(true);
				UserLogin.this.setVisible(false);
				UserLogin.this.dispose();
				}else {
					LoginDialog loginDialog=new LoginDialog(UserLogin.this);
					loginDialog.setLocationRelativeTo(UserLogin.this);
					loginDialog.setModal(true);
					loginDialog.setVisible(true);
					userNoText.setText("");
					userPasswordText.setText("");
					System.out.println("职工号或密码错误！");
				}
				
			}
		});
		
		userPasswordText = new JPasswordField();
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userPasswordText, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addComponent(userNoText, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
							.addComponent(userLoginBu, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addGap(71))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNoText, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPasswordText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(userLoginBu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
