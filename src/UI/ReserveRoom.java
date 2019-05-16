package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ComplexObjectClass.EmptyRoomInformationTable;
import ComplexObjectClass.EmptyRoomInformationTableDao;
import ComplexObjectClass.EmptyRoomInformationTableDaoImp;
import ObjectClass.Customer;
import ObjectClass.CustomerDao;
import ObjectClass.CustomerDaoImp;
import ObjectClass.PastCustomer;
import ObjectClass.PastCustomerDao;
import ObjectClass.PastCustomerDaoImp;
import ObjectClass.Room;
import ObjectClass.RoomDao;
import ObjectClass.RoomDaoImp;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ReserveRoom extends JFrame {

	private JPanel contentPane;
	private JTable emptyRoomTable;
	private JTable reserveCustomerTable;
	private JTextField customerNoText;
	private JTextField customerNameText;
	private JTextField customerPhoneText;
	private JTextField customerCardText;
	private JTextField roomNoText;
	
	HouseSystemWindows houseSystemWindows;
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allRows=new Vector<>();
	
	Vector<String> customerColumnNames=new Vector<>();
	Vector<Vector> allCustomerRow=new Vector<>();
	
	String customerSex="男";
	String customerPayStatus="未结账未付定金";
	String allcusearch="目前顾客号：";
	private JTextField reserveTimeText;
	private JTextField reserveTimeLongText;
	private JTextField searchCustomerNoText;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReserveRoom frame = new ReserveRoom();
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
	public ReserveRoom(HouseSystemWindows houseSystemWindows1) {
		
		houseSystemWindows=houseSystemWindows1;
		
		setTitle("\u9884\u5B9A\u623F\u95F4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 824, 143);
		
		JLabel label = new JLabel("\u987E\u5BA2\u53F7\uFF1A");
		label.setBounds(24, 20, 58, 15);
		
		customerNoText = new JTextField();
		customerNoText.setBounds(91, 16, 66, 21);
		customerNoText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(167, 19, 49, 15);
		
		customerNameText = new JTextField();
		customerNameText.setBounds(226, 16, 66, 21);
		customerNameText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(302, 19, 44, 15);
		
		JLabel label_3 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		label_3.setBounds(418, 19, 76, 15);
		
		customerPhoneText = new JTextField();
		customerPhoneText.setBounds(498, 16, 104, 21);
		customerPhoneText.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		label_4.setBounds(5, 65, 83, 15);
		
		customerCardText = new JTextField();
		customerCardText.setBounds(91, 61, 66, 21);
		customerCardText.setColumns(10);
		
		JLabel label_5 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label_5.setBounds(166, 64, 57, 15);
		
		roomNoText = new JTextField();
		roomNoText.setBounds(229, 63, 66, 21);
		roomNoText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u652F\u4ED8\u72B6\u6001\uFF1A");
		lblNewLabel.setBounds(301, 66, 72, 15);
		
		JComboBox customerPayBox = new JComboBox();
		
		customerPayBox.addItem("未结账未付定金");
		customerPayBox.addItem("未结账已付定金");
		customerPayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					customerPayStatus=arg0.getItem().toString();
					System.out.println(customerPayStatus);
				}
				
			}
		});
		customerPayBox.setBounds(370, 63, 124, 21);
		
		JButton resetBu = new JButton("\u91CD\u7F6E");
		resetBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		resetBu.setBounds(511, 61, 91, 23);
		
		JButton searchEmptyRoomBu = new JButton("\u7A7A\u623F\u95F4");
		searchEmptyRoomBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EmptyRoomInformationTableDao emptyRoomInformationTableDao=new EmptyRoomInformationTableDaoImp();
				List<EmptyRoomInformationTable> emptyRoomInformationTables=emptyRoomInformationTableDao.getTableByRoomStatus("空闲");
				System.out.println(emptyRoomInformationTables.size());
				allRows.removeAllElements();
				for(int i=0;i<emptyRoomInformationTables.size();i++) {
					Vector<String> rows=new Vector<>();
					EmptyRoomInformationTable emptyRoomInformationTable=new EmptyRoomInformationTable();
					emptyRoomInformationTable=emptyRoomInformationTables.get(i);
					rows.addElement(emptyRoomInformationTable.getRoomNo());
					rows.addElement(emptyRoomInformationTable.getTypeName());
					rows.addElement(String.valueOf(emptyRoomInformationTable.getPeopleNu()));
					rows.addElement(String.valueOf(emptyRoomInformationTable.getRoomFloor()));
					rows.addElement(String.valueOf(emptyRoomInformationTable.getTypePrice()));
					rows.addElement(String.valueOf(emptyRoomInformationTable.getTypeArea()));
					rows.addElement(emptyRoomInformationTable.getRoomDescription());
					allRows.addElement(rows);
					
				}
				emptyRoomTable.updateUI();
			}
		});
		searchEmptyRoomBu.setBounds(24, 104, 107, 33);
		
		reserveTimeText = new JTextField();
		reserveTimeText.setBounds(675, 61, 116, 22);
		panel.add(reserveTimeText);
		reserveTimeText.setColumns(10);
		
		reserveTimeLongText = new JTextField();
		reserveTimeLongText.setBounds(675, 110, 116, 21);
		panel.add(reserveTimeLongText);
		reserveTimeLongText.setColumns(10);
		
		
		JButton reserveRoomBu = new JButton("\u9884\u5B9A");
		reserveRoomBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer customer=new Customer();
				String customerNo=customerNoText.getText().toString();
				String customerName=customerNameText.getText().toString();
				String customerPhone=customerPhoneText.getText().toString();
				String customerCard=customerCardText.getText().toString();
				String customerRoomNo=roomNoText.getText().toString();
				String customerReserveTime=reserveTimeText.getText().toString();
				int reserveTimeLong=Integer.valueOf(reserveTimeLongText.getText());
				customer.setCuNo(customerNo);
				customer.setCuName(customerName);
				customer.setCuCard(customerCard);
				customer.setCuPay(customerPayStatus);
				customer.setCuSex(customerSex);
				customer.setCuPhone(customerPhone);
				customer.setCuRoomNo(customerRoomNo);
				customer.setCuReserveTime(customerReserveTime);
				customer.setReserveTimeLong(reserveTimeLong);
				CustomerDao customerDao=new CustomerDaoImp();
				customerDao.add(customer);
				RoomDao roomDao=new RoomDaoImp();
				roomDao.updateRoomStatusByRoomNo(customerRoomNo, "预定");
			}
		});
		reserveRoomBu.setBounds(141, 103, 108, 34);
		
		JLabel lblNewLabel_1 = new JLabel("\u6761\u4EF6\uFF1A");
		lblNewLabel_1.setBounds(259, 108, 57, 25);
		
		JButton searchCustomerBu = new JButton("\u67E5\u8BE2");
		searchCustomerBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allCustomerRow.removeAllElements();
				String searchRoomNo=searchCustomerNoText.getText().toString();
				if(allcusearch.equals("目前顾客号：")) {
					Customer searchCustomer=new Customer();
					CustomerDao customerDao=new CustomerDaoImp();
					searchCustomer=customerDao.getCustomerByCuNo(searchRoomNo);
					System.out.println(searchCustomer.getCuName());
					Vector<String> customerRow=new Vector<>();
					customerRow.add(String.valueOf(searchCustomer.getCuName()));
					customerRow.add(searchCustomer.getCuSex());
					customerRow.add(searchCustomer.getCuPay());
					customerRow.add(searchCustomer.getCuRoomNo());
					customerRow.add(searchCustomer.getCuReserveTime());
					customerRow.add(searchCustomer.getCuPhone());
					customerRow.add(searchCustomer.getCuCard());
					allCustomerRow.addElement(customerRow);
				}else {
					
					PastCustomerDao pastCustomerDao=new PastCustomerDaoImp();
					List<PastCustomer> pastCustomers=new ArrayList<>();
					pastCustomers=pastCustomerDao.getPastCustomerByPhone(searchRoomNo);
					for(int i=0;i<pastCustomers.size();i++) {
						PastCustomer pastCustomer=new PastCustomer();
						pastCustomer=pastCustomers.get(i);
						Vector<String> customerRow=new Vector<>();
						customerRow.addElement(pastCustomer.getCuName());
						customerRow.addElement(pastCustomer.getCuSex());
						customerRow.addElement("");
						customerRow.addElement(pastCustomer.getCuRoomNo());
						customerRow.addElement("");
						customerRow.addElement(pastCustomer.getCuPhone());
						customerRow.addElement(pastCustomer.getCuCard());
						allCustomerRow.addElement(customerRow);
					}
					
				}
			
				//List<Customer> customers=new ArrayList<>();
				
				reserveCustomerTable.updateUI();
				
			}
			
			
			
		});
		searchCustomerBu.setBounds(533, 109, 69, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 158, 360, 303);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(371, 158, 458, 303);
		panel.setLayout(null);
		panel.add(searchCustomerBu);
		panel.add(label_4);
		panel.add(label);
		panel.add(customerNoText);
		panel.add(label_1);
		panel.add(customerNameText);
		panel.add(label_2);
		panel.add(label_3);
		panel.add(customerPhoneText);
		panel.add(customerCardText);
		panel.add(label_5);
		panel.add(roomNoText);
		panel.add(lblNewLabel);
		panel.add(searchEmptyRoomBu);
		panel.add(reserveRoomBu);
		panel.add(customerPayBox);
		panel.add(resetBu);
		panel.add(lblNewLabel_1);
		customerColumnNames.addElement("姓名");
		customerColumnNames.addElement("性别");
		customerColumnNames.addElement("状态");
		customerColumnNames.addElement("房号");
		customerColumnNames.addElement("入住时间");
		customerColumnNames.addElement("手机号");
		customerColumnNames.addElement("身份证");
		reserveCustomerTable = new JTable(allCustomerRow,customerColumnNames);
		scrollPane_1.setViewportView(reserveCustomerTable);
		contentPane.setLayout(null);
		
		columnNames.add("房间号");
		columnNames.add("类型名");
		columnNames.add("可住人数");
		columnNames.add("楼层");
		columnNames.add("价格");
		columnNames.add("面积");
		columnNames.add("描述");
		emptyRoomTable = new JTable(allRows,columnNames);
		//String[] headers={"房间号","类型名","可住人数","房间楼层","房间价格","房间面积","房间描述"};
		scrollPane.setViewportView(emptyRoomTable);
		contentPane.add(scrollPane);
		contentPane.add(scrollPane_1);
		contentPane.add(panel);
		
		JComboBox customerSexBox = new JComboBox();
		customerSexBox.addItem("男");
		customerSexBox.addItem("女");
		customerSexBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					customerSex=arg0.getItem().toString();
				}
			}
		});
		customerSexBox.setBounds(356, 16, 57, 21);
		panel.add(customerSexBox);
		
		JButton returnHouseSystemBu = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		returnHouseSystemBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				houseSystemWindows.setVisible(true);
				ReserveRoom.this.dispose();
			}
		});
		returnHouseSystemBu.setBounds(709, 16, 105, 23);
		panel.add(returnHouseSystemBu);
		
		JLabel label_6 = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		label_6.setBounds(612, 62, 66, 21);
		panel.add(label_6);
		
		JLabel lblNewLabel_2 = new JLabel("\u9884\u5B9A\u5929\u6570\uFF1A");
		lblNewLabel_2.setBounds(612, 110, 66, 21);
		panel.add(lblNewLabel_2);
		
		JComboBox allcusearchBox = new JComboBox();
		allcusearchBox.addItem("目前顾客号：");
		allcusearchBox.addItem("历史手机号：");
		allcusearchBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					allcusearch=arg0.getItem().toString();
				}
				
				
			}
		});
		allcusearchBox.setBounds(321, 110, 105, 21);
		panel.add(allcusearchBox);
		
		searchCustomerNoText = new JTextField();
		searchCustomerNoText.setBounds(436, 110, 87, 21);
		panel.add(searchCustomerNoText);
		searchCustomerNoText.setColumns(10);
		
		
		
	}
	
}
