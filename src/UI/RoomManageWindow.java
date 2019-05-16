package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.Room;
import ObjectClass.RoomDao;
import ObjectClass.RoomDaoImp;
import ObjectClass.RoomThingDao;
import ObjectClass.RoomThingDaoImp;
import ObjectClass.RoomType;
import ObjectClass.RoomTypeDao;
import ObjectClass.RoomTypeDaoImp;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class RoomManageWindow extends JFrame {

	private JPanel contentPane;
	
	HouseSystemWindows houseSystemWindows;
	private JTable showRoomTable;
	private JTextField roomNoText;
	private JTextField typeNoText;
	private JTextField deletethingNoText;
	private JTextField deletethingRoomNoText;
	
	String groupWay="房间描述";
	String status="空闲";
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allrows=new Vector<>();
	private JTextField statusRoonNuText;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomManageWindow frame = new RoomManageWindow();
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
	public RoomManageWindow(HouseSystemWindows houseSystemWindows1) {
		setResizable(false);
		setTitle("\u623F\u95F4\u7BA1\u7406");
		houseSystemWindows=houseSystemWindows1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 10, 690, 164);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 179, 700, 276);
		
		JButton searchRoomBu = new JButton("\u663E\u793A\u6240\u6709\u623F\u95F4");
		searchRoomBu.setBounds(21, 10, 117, 31);
		searchRoomBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allrows.removeAllElements();
				RoomDao roomDao=new RoomDaoImp();
				RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
				List<Room> rooms=new ArrayList<>();
				rooms=roomDao.query();
				if(rooms.size()>0) {
					for(int i=0;i<rooms.size();i++) {
						Room room=new Room();
						room=rooms.get(i);
						Vector<String> row=new Vector<>();
						row.addElement(room.getRoomNo());
						String typeNo=roomDao.getTypeNoByRoomNo(room.getRoomNo());
						RoomType roomType=new RoomType();
						roomType=roomTypeDao.getRoomByTypeNo(typeNo);
						row.addElement(roomType.getTypeName());
						row.addElement(String.valueOf(room.getRoomFloor()));
						row.addElement(String.valueOf(roomType.getPeopleNu()));
						row.addElement(room.getDescription());
						row.addElement(room.getStatus());
						row.addElement(String.valueOf(roomType.getTypePrice()));
						allrows.addElement(row);
					}
					showRoomTable.updateUI();
				}else {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(RoomManageWindow.this);
					failInformationDialog.setModal(true);
					failInformationDialog.setVisible(true);
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u623F\u95F4");
		btnNewButton_1.setBounds(148, 10, 93, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRoomDialog addRoomDialog=new AddRoomDialog();
				addRoomDialog.setModal(true);
				addRoomDialog.setLocationRelativeTo(RoomManageWindow.this);
				addRoomDialog.setVisible(true);
			}
		});
		
		JButton addRoomTypeBu = new JButton("\u6DFB\u52A0\u623F\u95F4\u7C7B\u578B");
		addRoomTypeBu.setBounds(251, 10, 113, 31);
		addRoomTypeBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRoomTypeDialog addRoomTypeDialog=new AddRoomTypeDialog();
				addRoomTypeDialog.setLocationRelativeTo(RoomManageWindow.this);
				addRoomTypeDialog.setModal(true);
				addRoomTypeDialog.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u66F4\u65B0\u7269\u54C1");
		btnNewButton_3.setBounds(382, 10, 92, 31);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRoomThingDialog addRoomThingDialog=new AddRoomThingDialog();
				addRoomThingDialog.setLocationRelativeTo(RoomManageWindow.this);
				addRoomThingDialog.setModal(true);
				addRoomThingDialog.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		lblNewLabel_1.setBounds(10, 90, 56, 23);
		
		roomNoText = new JTextField();
		roomNoText.setBounds(76, 88, 66, 27);
		roomNoText.setColumns(10);
		
		JButton deleteRoomBu = new JButton("\u5220\u9664\u623F\u95F4");
		deleteRoomBu.setBounds(152, 88, 103, 27);
		deleteRoomBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomNo=roomNoText.getText().toString();
				RoomDao roomDao=new RoomDaoImp();
				String roomStatus=roomDao.getRoomStatusByRoomNo(roomNo);
				if(roomStatus.equals("入住")||roomStatus.equals("预定")) {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(RoomManageWindow.this);
					failInformationDialog.setModal(true);
					failInformationDialog.setVisible(true);
				}else {
					roomDao.delete(roomNo);
				}
			}
		});
		
		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B\u53F7\uFF1A");
		label.setBounds(10, 133, 95, 29);
		
		typeNoText = new JTextField();
		typeNoText.setBounds(115, 133, 66, 29);
		typeNoText.setColumns(10);
		
		JButton deleteTypeBu = new JButton("\u5220\u9664\u7C7B\u578B");
		deleteTypeBu.setBounds(191, 132, 93, 27);
		deleteTypeBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String typeNo=typeNoText.getText().toString();
				RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
				int n=roomTypeDao.delete(typeNo);
				if(n==0) {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(RoomManageWindow.this);
					failInformationDialog.setVisible(true);
					typeNoText.setText("");
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\u7269\u54C1\u53F7\uFF1A");
		lblNewLabel_2.setBounds(290, 91, 56, 21);
		
		deletethingNoText = new JTextField();
		deletethingNoText.setBounds(350, 90, 66, 24);
		deletethingNoText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label_1.setBounds(418, 94, 56, 15);
		
		deletethingRoomNoText = new JTextField();
		deletethingRoomNoText.setBounds(478, 91, 66, 21);
		deletethingRoomNoText.setColumns(10);
		
		JButton deletethingBu = new JButton("\u5220\u9664\u7269\u54C1");
		deletethingBu.setBounds(550, 90, 93, 23);
		deletethingBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomNo=deletethingRoomNoText.getText().toString();
				String thingNo=deletethingRoomNoText.getText().toString();
				RoomThingDao roomThingDao=new RoomThingDaoImp();
				roomThingDao.delteThingByKey(roomNo, thingNo);
				deletethingNoText.setText("");
				deletethingRoomNoText.setText("");
			}
		});
		
		JButton returnHouseSystemBu = new JButton("\u8FD4\u56DE\u4E3B\u7A97\u53E3");
		returnHouseSystemBu.setBounds(564, 14, 102, 27);
		returnHouseSystemBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				houseSystemWindows.setVisible(true);
				RoomManageWindow.this.dispose();
			}
		});
		panel.setLayout(null);
		panel.add(searchRoomBu);
		panel.add(btnNewButton_1);
		panel.add(addRoomTypeBu);
		panel.add(btnNewButton_3);
		panel.add(returnHouseSystemBu);
		panel.add(lblNewLabel_1);
		panel.add(roomNoText);
		panel.add(deleteRoomBu);
		panel.add(lblNewLabel_2);
		panel.add(deletethingNoText);
		panel.add(label_1);
		panel.add(deletethingRoomNoText);
		panel.add(deletethingBu);
		panel.add(label);
		panel.add(typeNoText);
		panel.add(deleteTypeBu);
		
		columnNames.addElement("房间号");
		columnNames.addElement("房间名称");
		columnNames.addElement("房间楼层");
		columnNames.addElement("房间容量");
		columnNames.addElement("房间描述");
		columnNames.addElement("房间状态");
		columnNames.addElement("房间价格");
		contentPane.setLayout(null);
		
		showRoomTable = new JTable(allrows,columnNames);
		scrollPane.setViewportView(showRoomTable);
		contentPane.add(scrollPane);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 53, 54, 27);
		panel.add(lblNewLabel);
		
		statusRoonNuText = new JTextField();
		statusRoonNuText.setBounds(76, 57, 66, 21);
		panel.add(statusRoonNuText);
		statusRoonNuText.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("空闲");
		comboBox.addItem("清理");
		comboBox.addItem("维修");
		comboBox.addItem("入住");
		comboBox.addItem("已删除");
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					status=arg0.getItem().toString();
				}
			}
		});
		comboBox.setBounds(158, 57, 83, 21);
		panel.add(comboBox);
		
		JButton statusUpdateBu = new JButton("\u66F4\u65B0\u72B6\u6001");
		statusUpdateBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomno=statusRoonNuText.getText().toString();
				RoomDao roomDao=new RoomDaoImp();
				int n=roomDao.updateRoomStatusByRoomNo(roomno, status);
				if(n>0) {
					WarningDialog warningDialog=new WarningDialog("更新成功");
					warningDialog.setLocationRelativeTo(RoomManageWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}else {
					WarningDialog warningDialog=new WarningDialog("无更新条件");
					warningDialog.setLocationRelativeTo(RoomManageWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}
			}
		});
		statusUpdateBu.setBounds(253, 55, 93, 23);
		panel.add(statusUpdateBu);
	}
}
