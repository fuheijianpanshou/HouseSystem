package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.User;
import ObjectClass.UserDao;
import ObjectClass.UserDaoImp;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HouseSystemWindows extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseSystemWindows frame = new HouseSystemWindows();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public HouseSystemWindows(int userNo) {
		User user;
		UserDao userDao=new UserDaoImp();
		user=userDao.queryUserByUserNo(userNo);
		setTitle("\u9152\u5E97\u5BA2\u623F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5BA2\u623F\u7BA1\u7406");
		layeredPane.setLayer(lblNewLabel, 0);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
		lblNewLabel.setIcon(new ImageIcon("E:\\project\\HouseSystem\\image\\hi.jpg"));
		lblNewLabel.setBounds(10, 10, 747, 464);
		layeredPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u9884\u5B9A\u623F\u95F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReserveRoom reserveRoom=new ReserveRoom(HouseSystemWindows.this);
				reserveRoom.setVisible(true);
				HouseSystemWindows.this.setVisible(false);
				HouseSystemWindows.this.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(btnNewButton, 1);
		btnNewButton.setBounds(230, 166, 148, 98);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5165\u4F4F\u623F\u95F4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CheckInRoomWindow checkInRoomWindow=new CheckInRoomWindow(HouseSystemWindows.this);
				checkInRoomWindow.setVisible(true);
				HouseSystemWindows.this.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(btnNewButton_1, 1);
		btnNewButton_1.setBounds(388, 166, 148, 98);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7ED3\u7B97\u4ED8\u6B3E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PayAndOtherWindow payAndOtherWindow=new PayAndOtherWindow(HouseSystemWindows.this);
				HouseSystemWindows.this.setVisible(false);
				payAndOtherWindow.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(btnNewButton_2, 1);
		btnNewButton_2.setBounds(150, 274, 148, 98);
		layeredPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchWindow searchWindow=new SearchWindow(HouseSystemWindows.this);
				HouseSystemWindows.this.setVisible(false);
				searchWindow.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(btnNewButton_3, 1);
		btnNewButton_3.setBounds(471, 274, 148, 98);
		layeredPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5BA2\u623F\u7BA1\u7406");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomManageWindow roomManageWindow=new RoomManageWindow(HouseSystemWindows.this);
				roomManageWindow.setVisible(true);
				HouseSystemWindows.this.setVisible(false);
				
			}
		});
		btnNewButton_4.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(btnNewButton_4, 1);
		btnNewButton_4.setBounds(230, 382, 148, 72);
		layeredPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u66F4\u65B0\u65B0\u95FB");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WriteNewsWindow writeNewsWindow=new WriteNewsWindow(HouseSystemWindows.this);
				writeNewsWindow.setVisible(true);
				HouseSystemWindows.this.setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(btnNewButton_5, 1);
		btnNewButton_5.setBounds(388, 382, 148, 72);
		layeredPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("\u804C\u5DE5\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		layeredPane.setLayer(lblNewLabel_1, 1);
		lblNewLabel_1.setBounds(21, 20, 68, 15);
		layeredPane.add(lblNewLabel_1);
		
		JLabel userNoLabel = new JLabel(String.valueOf(user.getUserNo()));
		userNoLabel.setFont(new Font("宋体", Font.BOLD, 16));
		layeredPane.setLayer(userNoLabel, 1);
		userNoLabel.setBounds(85, 20, 54, 15);
		layeredPane.add(userNoLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u804C\u5DE5\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		layeredPane.setLayer(lblNewLabel_2, 1);
		lblNewLabel_2.setBounds(17, 53, 99, 27);
		layeredPane.add(lblNewLabel_2);
		
		JLabel userNameLabel = new JLabel(user.getUserName());
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 16));
		layeredPane.setLayer(userNameLabel, 1);
		userNameLabel.setBounds(103, 55, 54, 24);
		layeredPane.add(userNameLabel);
		
		JButton btnNewButton_6 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HouseSystemWindows.this.dispose();
			}
		});
		layeredPane.setLayer(btnNewButton_6, 1);
		btnNewButton_6.setBounds(651, 11, 93, 31);
		layeredPane.add(btnNewButton_6);
		
		JButton showBillBu = new JButton("\u8D26\u5355\u67E5\u770B");
		showBillBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowProfitWindow showProfitWindow=new ShowProfitWindow(HouseSystemWindows.this);
				showProfitWindow.setVisible(true);
				
			}
		});
		showBillBu.setFont(new Font("楷体", Font.BOLD, 25));
		layeredPane.setLayer(showBillBu, 1);
		showBillBu.setBounds(308, 274, 153, 98);
		layeredPane.add(showBillBu);
	}
}
