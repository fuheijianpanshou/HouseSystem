package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import ComplexObjectClass.EmptyRoomInformationTable;
import ComplexObjectClass.EmptyRoomInformationTableDao;
import ComplexObjectClass.EmptyRoomInformationTableDaoImp;
import ObjectClass.Customer;
import ObjectClass.CustomerDao;
import ObjectClass.CustomerDaoImp;
import ObjectClass.RoomDao;
import ObjectClass.RoomDaoImp;
import ObjectClass.RoomTypeDao;
import ObjectClass.RoomTypeDaoImp;
import UI.FailInformationDialog;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;

public class CheckInRoomWindow extends JFrame {

	private JPanel contentPane;
	private JTextField cuReservePhoneText;
	private JTextField checkCuNoText;
	private JTextField checkCuNameText;
	private JTextField checkCuPhoneText;
	private JTextField checkCuCardText;
	private JTextField checkCuRoomNu;
	private JTextField checkCuTimeLongText;
	private JTextField searchCuNoText;
	private JTable emptyRoomTable;
	private JTable checkCuTable;
	
	
	String reservepayStatus="已付押金";
	String checkPayStatus="已付押金";
	String cuSex="男";
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allRows=new Vector<>();
	
	Vector<String> customerColumnNames=new Vector<>();
	Vector<Vector> allCustomerRow=new Vector<>();
	
	HouseSystemWindows houseSystemWindows;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInRoomWindow frame = new CheckInRoomWindow();
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
	public CheckInRoomWindow(HouseSystemWindows houseSystemWindows1) {
		houseSystemWindows=houseSystemWindows1;
		setResizable(false);
		setTitle("\u5165\u4F4F\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 814, 181);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u5DF2\u9884\u5B9A\u624B\u673A\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 10, 94, 31);
		
		cuReservePhoneText = new JTextField();
		cuReservePhoneText.setBounds(105, 10, 94, 31);
		cuReservePhoneText.setColumns(10);
		
		JTextArea showReserveMonText = new JTextArea();
		showReserveMonText.setFont(new Font("Monospaced", Font.BOLD, 20));
		showReserveMonText.setText("0");
		showReserveMonText.setEditable(false);
		showReserveMonText.setBounds(454, 10, 60, 31);
		panel.add(showReserveMonText);
		
		JButton cuReserveSerchBu = new JButton("\u67E5\u8BE2");
		cuReserveSerchBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cuPhone=cuReservePhoneText.getText().toString();
				CustomerDao customerDao=new CustomerDaoImp();
				String status=customerDao.getPayStatusByCuPhone(cuPhone);
				System.out.println(status);
				if(status.equals("未结账已付定金")) {
					int timeLong=customerDao.getTimeLongByPhone(cuPhone);
					String cuRoomNo=customerDao.getRoomNoByCuPhone(cuPhone);
					RoomDao roomDao=new RoomDaoImp();
					String typeNo=roomDao.getTypeNoByRoomNo(cuRoomNo);
					RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
					int price=roomTypeDao.getRoomPriceByTypeNo(typeNo);
					int showPay=(int) ((int)timeLong*price*1.5-(int)price/2);
					showReserveMonText.setText(String.valueOf(showPay));
				}else {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					cuReservePhoneText.setText("");
					failInformationDialog.setVisible(true);
				}
				
		
			}
		});
		cuReserveSerchBu.setBounds(209, 10, 93, 31);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(cuReservePhoneText);
		panel.add(cuReserveSerchBu);
		
		JLabel lblNewLabel_1 = new JLabel("\u4ED8\u6B3E\u91D1\u989D\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel_1.setBounds(333, 10, 111, 31);
		panel.add(lblNewLabel_1);
		
		
		
		JButton cuReserveCheckBu = new JButton("\u786E\u8BA4\u5165\u4F4F");
		cuReserveCheckBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(showReserveMonText.getText().toString())>0) {
					String cuPhone=cuReservePhoneText.getText().toString();
					CustomerDao customerDao=new CustomerDaoImp();
					customerDao.updateCuPayByCuPhone(cuPhone, reservepayStatus);
					String roomNo=customerDao.getRoomNoByCuPhone(cuPhone);
					RoomDao roomDao=new RoomDaoImp();
					roomDao.updateRoomStatusByRoomNo(roomNo, "入住");
					cuReservePhoneText.setText("");
					showReserveMonText.setText("0");
				}else {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setVisible(true);
				}
				
			}
		});
		cuReserveCheckBu.setBounds(607, 10, 94, 31);
		panel.add(cuReserveCheckBu);
		
		JButton returnSystemBu = new JButton("\u8FD4\u56DE\u7CFB\u7EDF");
		returnSystemBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				houseSystemWindows.setVisible(true);
				CheckInRoomWindow.this.dispose();
			}
			
		});
		returnSystemBu.setBounds(711, 10, 93, 31);
		panel.add(returnSystemBu);
		
		JLabel label = new JLabel("\u987E\u5BA2\u53F7\uFF1A");
		label.setBounds(10, 51, 60, 31);
		panel.add(label);
		
		checkCuNoText = new JTextField();
		checkCuNoText.setBounds(80, 51, 66, 31);
		panel.add(checkCuNoText);
		checkCuNoText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(156, 51, 45, 31);
		panel.add(lblNewLabel_2);
		
		checkCuNameText = new JTextField();
		checkCuNameText.setBounds(208, 51, 74, 31);
		panel.add(checkCuNameText);
		checkCuNameText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_3.setBounds(292, 51, 45, 31);
		panel.add(lblNewLabel_3);
		
		JComboBox checkCuSexBox = new JComboBox();
		checkCuSexBox.addItem("男");
		checkCuSexBox.addItem("女");
		checkCuSexBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					
				}
				
			}
		});
		checkCuSexBox.setBounds(347, 51, 53, 31);
		panel.add(checkCuSexBox);
		
		JLabel lblNewLabel_4 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_4.setBounds(410, 51, 54, 31);
		panel.add(lblNewLabel_4);
		
		checkCuPhoneText = new JTextField();
		checkCuPhoneText.setBounds(471, 51, 94, 31);
		panel.add(checkCuPhoneText);
		checkCuPhoneText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblNewLabel_5.setBounds(10, 92, 70, 31);
		panel.add(lblNewLabel_5);
		
		checkCuCardText = new JTextField();
		checkCuCardText.setBounds(90, 92, 119, 31);
		panel.add(checkCuCardText);
		checkCuCardText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		lblNewLabel_6.setBounds(218, 92, 54, 31);
		panel.add(lblNewLabel_6);
		
		checkCuRoomNu = new JTextField();
		checkCuRoomNu.setBounds(281, 92, 66, 31);
		panel.add(checkCuRoomNu);
		checkCuRoomNu.setColumns(10);
		
		JComboBox cuReservePayBox = new JComboBox();
		cuReservePayBox.addItem("已付押金");
		cuReservePayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					reservepayStatus=arg0.getItem().toString();
				}
				
			}
		});
		cuReservePayBox.setBounds(524, 10, 73, 31);
		panel.add(cuReservePayBox);
		
		JLabel lblNewLabel_8 = new JLabel("\u5165\u4F4F\u65F6\u957F\uFF08\u5929\uFF09\uFF1A");
		lblNewLabel_8.setBounds(364, 92, 107, 31);
		panel.add(lblNewLabel_8);
		
		checkCuTimeLongText = new JTextField();
		checkCuTimeLongText.setBounds(481, 92, 45, 31);
		panel.add(checkCuTimeLongText);
		checkCuTimeLongText.setColumns(10);
		
		JComboBox checkCuPayBox = new JComboBox();
		checkCuPayBox.addItem("已付押金");
		checkCuPayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (ItemEvent.SELECTED==arg0.getStateChange()) {
					checkPayStatus=arg0.getItem().toString();
					
				}
				
			}
		});
		checkCuPayBox.setBounds(661, 51, 74, 31);
		panel.add(checkCuPayBox);
		
		JTextArea showCheckCuPay = new JTextArea();
		showCheckCuPay.setText("0");
		showCheckCuPay.setFont(new Font("Monospaced", Font.BOLD, 20));
		showCheckCuPay.setEditable(false);
		showCheckCuPay.setBounds(661, 92, 59, 31);
		panel.add(showCheckCuPay);
		
		JButton checkPaySeBu = new JButton("\u4ED8\u6B3E\u91D1\u989D");
		checkPaySeBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomNo=checkCuRoomNu.getText().toString();
				int timeLong=Integer.valueOf(checkCuTimeLongText.getText());
				RoomDao roomDao=new RoomDaoImp();
				String typeNo=roomDao.getTypeNoByRoomNo(roomNo);
				RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
				int price=roomTypeDao.getRoomPriceByTypeNo(typeNo);
				double allPrice=(double)price*timeLong*1.5;
				showCheckCuPay.setText(String.valueOf(allPrice));	
			}
		});
		checkPaySeBu.setBounds(549, 92, 103, 31);
		panel.add(checkPaySeBu);
		
		
		
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
		searchEmptyRoomBu.setBounds(80, 133, 93, 38);
		panel.add(searchEmptyRoomBu);
		
		JButton cuCheckBu = new JButton("\u786E\u8BA4\u5165\u4F4F");
		cuCheckBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cuNo=checkCuNoText.getText().toString();
				String cuName=checkCuNameText.getText().toString();
				String cuPhone=checkCuPhoneText.getText().toString();
				String cuCard=checkCuCardText.getText().toString();
				String roomNo=checkCuRoomNu.getText().toString();
				int timelong=Integer.valueOf(checkCuTimeLongText.getText());
				Customer customer=new Customer();
				customer.setCuNo(cuNo);
				customer.setCuName(cuName);
				customer.setCuSex(cuSex);
				customer.setCuPhone(cuPhone);
				customer.setReserveTimeLong(timelong);
				customer.setCuPay(checkPayStatus);
				customer.setCuRoomNo(roomNo);
				customer.setCuCard(cuCard);
				String str="yyyy-MM-dd HH:mm";
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
				String date=simpleDateFormat.format(new Date());
				customer.setCuCheckTime(date);
				CustomerDao customerDao=new CustomerDaoImp();
				customerDao.addCheckCustomer(customer);
				RoomDao roomDao=new RoomDaoImp();
				roomDao.updateRoomStatusByRoomNo(roomNo, "入住");
				
			}
		});
		cuCheckBu.setBounds(183, 133, 93, 38);
		panel.add(cuCheckBu);
		
		JLabel label_1 = new JLabel("\u987E\u5BA2\u53F7\uFF1A");
		label_1.setBounds(559, 133, 54, 38);
		panel.add(label_1);
		
		searchCuNoText = new JTextField();
		searchCuNoText.setBounds(623, 133, 66, 38);
		panel.add(searchCuNoText);
		searchCuNoText.setColumns(10);
		
		JButton searchCuNoBu = new JButton("\u67E5\u8BE2");
		searchCuNoBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allCustomerRow.removeAllElements();
				String searchRoomNo=searchCuNoText.getText().toString();
				//List<Customer> customers=new ArrayList<>();
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
				checkCuTable.updateUI();
			}
		});
		searchCuNoBu.setBounds(711, 133, 93, 39);
		panel.add(searchCuNoBu);
		
		JLabel lblNewLabel_7 = new JLabel("\u652F\u4ED8\u72B6\u6001\uFF1A");
		lblNewLabel_7.setBounds(575, 51, 74, 31);
		panel.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 390, 268);
		contentPane.add(scrollPane);
		
		columnNames.add("房间号");
		columnNames.add("类型名");
		columnNames.add("可住人数");
		columnNames.add("楼层");
		columnNames.add("价格");
		columnNames.add("面积");
		columnNames.add("描述");	
		emptyRoomTable = new JTable(allRows,columnNames);
		scrollPane.setViewportView(emptyRoomTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(410, 191, 414, 268);
		contentPane.add(scrollPane_1);
		
		customerColumnNames.addElement("姓名");
		customerColumnNames.addElement("性别");
		customerColumnNames.addElement("状态");
		customerColumnNames.addElement("房号");
		customerColumnNames.addElement("入住时间");
		customerColumnNames.addElement("手机号");
		customerColumnNames.addElement("身份证");
		
		checkCuTable = new JTable(allCustomerRow,customerColumnNames);
		scrollPane_1.setViewportView(checkCuTable);
	}
}
