package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.HouseNews;
import ObjectClass.HouseNewsDao;
import ObjectClass.HouseNewsDaoImp;
import ObjectClass.Message;
import ObjectClass.MessageDao;
import ObjectClass.MessageDaoImp;
import anotherui.CuReserveRoom;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class MessageAndShowNewsWindow extends JFrame {

	private JPanel contentPane;
	private JTable showHouseNewsTable;
	private JTable showCustomerMesTable;
	Vector<String> newsColumnNames=new Vector<>();
	Vector<Vector> newsAllRows=new Vector<>();
	
	Vector<String> messageColumnNames=new Vector<>();
	Vector<Vector> messageAllRows=new Vector<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageAndShowNewsWindow frame = new MessageAndShowNewsWindow();
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
	public MessageAndShowNewsWindow() {
		setTitle("\u7559\u8A00\u6295\u8BC9\u65B0\u95FB\u53D1\u5E03");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9152\u5E97\u516C\u544A");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 24));
		lblNewLabel.setBounds(316, 10, 113, 42);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 769, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 749, 212);
		panel.add(scrollPane);
		
		newsColumnNames.addElement("新闻种类");
		newsColumnNames.addElement("发布时间");
		newsColumnNames.addElement("新闻内容");
		
		showHouseNewsTable = new JTable(newsAllRows,newsColumnNames);
		scrollPane.setViewportView(showHouseNewsTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 238, 580, 92);
		panel.add(scrollPane_1);
		
		messageColumnNames.addElement("留言时间");
		messageColumnNames.addElement("留言内容");
		
		showCustomerMesTable = new JTable(messageAllRows,messageColumnNames);
		scrollPane_1.setViewportView(showCustomerMesTable);
		
		JTextPane cuMessageText = new JTextPane();
		cuMessageText.setBounds(10, 340, 463, 62);
		panel.add(cuMessageText);
		
		JButton submitMessageBu = new JButton("\u63D0\u4EA4\u7559\u8A00");
		submitMessageBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String content=cuMessageText.getText();
				MessageDao messageDao=new MessageDaoImp();
				Message message=new Message();
				String str="yyyy-MM-dd-HH:mm";
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
				String updateTime=simpleDateFormat.format(new Date());
				message.setTime(updateTime);
				message.setContent(content);
				int n=messageDao.add(message);
				if(n==0) {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(MessageAndShowNewsWindow.this);
					failInformationDialog.setModal(true);
					failInformationDialog.setVisible(true);
					
				}else {
					cuMessageText.setText("");
				}
			}
		});
		submitMessageBu.setBounds(483, 340, 107, 62);
		panel.add(submitMessageBu);
		
		JButton cuComplaintsBu = new JButton("\u95EE\u9898\u6295\u8BC9");
		cuComplaintsBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComplaintsDialog complaintsDialog=new ComplaintsDialog();
				complaintsDialog.setLocationRelativeTo(MessageAndShowNewsWindow.this);
				complaintsDialog.setModal(true);
				complaintsDialog.setVisible(true);
			}
		});
		cuComplaintsBu.setFont(new Font("楷体", Font.BOLD, 25));
		cuComplaintsBu.setBounds(600, 238, 159, 57);
		panel.add(cuComplaintsBu);
		
		JButton cuReservrRoomBu = new JButton("\u623F\u95F4\u9884\u5B9A");
		cuReservrRoomBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ReserveRoom reserveRoom=new ReserveRoom()
				CuReserveRoom cuReserveRoom=new CuReserveRoom(MessageAndShowNewsWindow.this);
				cuReserveRoom.setVisible(true);
				MessageAndShowNewsWindow.this.setVisible(false);
				
			}
		});
		cuReservrRoomBu.setFont(new Font("楷体", Font.BOLD, 25));
		cuReservrRoomBu.setBounds(600, 305, 159, 62);
		panel.add(cuReservrRoomBu);
		
		JButton joinPositionBu = new JButton("\u804C\u4F4D\u5E94\u8058");
		joinPositionBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PositionApplyDialog positionApplyDialog=new PositionApplyDialog();
				positionApplyDialog.setLocationRelativeTo(MessageAndShowNewsWindow.this);
				positionApplyDialog.setModal(true);
				positionApplyDialog.setVisible(true);
			}
		});
		joinPositionBu.setFont(new Font("楷体", Font.BOLD, 25));
		joinPositionBu.setBounds(600, 377, 159, 62);
		panel.add(joinPositionBu);
		
		JLabel lblNewLabel_1 = new JLabel("\u5730\u5740\uFF1A\u5C71\u4E1C\u6D4E\u5357\u5E02\u4E2D\u533A11836\u53F7 \u9884\u5B9A\u7535\u8BDD\uFF1A8888-6684 ");
		lblNewLabel_1.setBounds(10, 412, 463, 27);
		panel.add(lblNewLabel_1);
		
		JButton refresh = new JButton("\u5237\u65B0");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showall();
			}
		});
		refresh.setBounds(10, 10, 93, 23);
		contentPane.add(refresh);
		showall();
		
		
	}
	
		public void showall() {
		messageAllRows.removeAllElements();
		newsAllRows.removeAllElements();
		List<Message> messages=new ArrayList<>();
		List<HouseNews> hList=new ArrayList<>();
		MessageDao messageDao=new MessageDaoImp();
		HouseNewsDao houseNewsDao=new HouseNewsDaoImp();
		messages=messageDao.query();
		hList=houseNewsDao.query();
		for(int i=0;i<messages.size();i++) {
			Vector<String> messageRow=new Vector<>();
			Message message=new Message();
			message=messages.get(i);
			messageRow.addElement(message.getTime());
			messageRow.addElement(message.getContent());
			messageAllRows.addElement(messageRow);
 		}
		for(int j=0;j<hList.size();j++) {
			Vector<String> newRow=new Vector<>();
			HouseNews houseNews=new HouseNews();
			houseNews=hList.get(j);
			newRow.addElement(houseNews.getNewsKinds());
			newRow.addElement(houseNews.getNewsShowTime());
			newRow.addElement(houseNews.getNewsContent());
			newsAllRows.addElement(newRow);
		}
		showCustomerMesTable.updateUI();
		showHouseNewsTable.updateUI();
		
		
	}
}
