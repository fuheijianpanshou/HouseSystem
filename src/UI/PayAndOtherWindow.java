package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.Customer;
import ObjectClass.CustomerDao;
import ObjectClass.CustomerDaoImp;
import ObjectClass.FoodDao;
import ObjectClass.FoodDaoImp;
import ObjectClass.HouseBill;
import ObjectClass.HouseBillDao;
import ObjectClass.HouseBillDaoImp;
import ObjectClass.NowUser;
import ObjectClass.NowUserDao;
import ObjectClass.NowUserDaoImp;
import ObjectClass.OutedRoomThing;
import ObjectClass.OutedRoomThingDao;
import ObjectClass.OutedRoomThingDaoImp;
import ObjectClass.PastCustomerDao;
import ObjectClass.PastCustomerDaoImp;
import ObjectClass.RoomDao;
import ObjectClass.RoomDaoImp;
import ObjectClass.RoomThingDao;
import ObjectClass.RoomThingDaoImp;
import ObjectClass.RoomTypeDao;
import ObjectClass.RoomTypeDaoImp;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class PayAndOtherWindow extends JFrame {

	private JPanel contentPane;
	private JTextField paySearchWayText;
	private JTextField thingSearchWayText;
	private JTextField backSearchWayText;
	private JTable payInformationTable;
	
	String backSearchWay="顾客号：";
	String thingSearchWay="顾客号：";
	String payCuSearchWay="顾客号：";
	String thingName="桌子";
	String foodWay="顾客号：";
	String foodName="青椒炒肉";
	String thingNu="1";
	String foodNu="1";
	int allPrice=0;
	
	String backRoomNo=null;//;顾客退订房间号
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allRows=new Vector<>();
	HouseSystemWindows houseSystemWindows;
	private JTextField foodWayText;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayAndOtherWindow frame = new PayAndOtherWindow();
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
	public PayAndOtherWindow(HouseSystemWindows houseSystemWindows1) {
		houseSystemWindows=houseSystemWindows1;
		setTitle("\u4ED8\u6B3E\u7ED3\u8D26");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JLabel label = new JLabel("\u7ED3\u8D26\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		label.setBounds(15, 19, 100, 24);
		
		JComboBox payCuSearchWayBox = new JComboBox();
		payCuSearchWayBox.addItem("顾客号：");
		payCuSearchWayBox.addItem("手机号：");
		payCuSearchWayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					payCuSearchWay=arg0.getItem().toString();
				}
			}
		});
		payCuSearchWayBox.setBounds(125, 18, 81, 27);
		
		JTextArea depositText = new JTextArea();
		depositText.setText("0");
		depositText.setFont(new Font("Monospaced", Font.BOLD, 20));
		depositText.setBounds(538, 16, 44, 29);
		contentPane.add(depositText);
		
		JTextArea changeText = new JTextArea();
		changeText.setText("0");
		changeText.setFont(new Font("Monospaced", Font.BOLD, 20));
		changeText.setBounds(777, 12, 44, 33);
		contentPane.add(changeText);
		
		JTextArea cuonsumptionText = new JTextArea();
		cuonsumptionText.setText("0");
		cuonsumptionText.setFont(new Font("Monospaced", Font.BOLD, 20));
		cuonsumptionText.setEditable(false);
		cuonsumptionText.setBounds(671, 12, 56, 31);
		
		JButton paySearchBu = new JButton("\u67E5\u8BE2");
		paySearchBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allRows.removeAllElements();
				Customer customer=new Customer();
				CustomerDao customerDao=new CustomerDaoImp();
				RoomDao roomDao=new RoomDaoImp();
				RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
				String cuNoOrPhone=paySearchWayText.getText().toString();
				int consumption=0;
				if(payCuSearchWay.equals("顾客号：")) {
					
					
				}else if(payCuSearchWay.equals("手机号：")) {
					String cuNo=customerDao.getCuNoByCuPhone(cuNoOrPhone);
					cuNoOrPhone=cuNo;
				}
				customer=customerDao.getCustomerByCuNo(cuNoOrPhone);
				Vector<String> row=new Vector<>();
				row.addElement(customer.getCuNo());
				row.addElement(customer.getCuName());
				row.addElement(customer.getCuRoomNo());
				row.addElement(customer.getCuPhone());
				row.addElement("房间消费");
				
				String typeNo=roomDao.getTypeNoByRoomNo(customer.getCuRoomNo());
				System.out.println(typeNo);
				int price =roomTypeDao.getRoomPriceByTypeNo(typeNo);
				System.out.println("Price:"+price);
				System.out.println(customer.getReserveTimeLong());
				allPrice=price*customer.getReserveTimeLong();
				row.addElement(String.valueOf(allPrice));
				allRows.addElement(row);
				OutedRoomThingDao outedRoomThingDao=new OutedRoomThingDaoImp();
				List<OutedRoomThing> outedRoomThings=outedRoomThingDao.getOutedRoomThingsByCuNoAndRoomNo(cuNoOrPhone, customer.getCuRoomNo());
				if(outedRoomThings.size()>0) {
					for(int i=0;i<outedRoomThings.size();i++)
					{
						OutedRoomThing outedRoomThing=outedRoomThings.get(i);
						Vector<String> row1=new Vector<>();
						row1.addElement(customer.getCuNo());
						row1.addElement(customer.getCuName());
						row1.addElement(customer.getCuRoomNo());
						row1.addElement(customer.getCuPhone());
						row1.addElement(outedRoomThing.getThingName()+"*"+String.valueOf(outedRoomThing.getThingOutAmount()));
						row1.addElement(String.valueOf(outedRoomThing.getThingOutAmount()*outedRoomThing.getThingPrice()));
						consumption=consumption+outedRoomThing.getThingOutAmount()*outedRoomThing.getThingPrice();
						allRows.addElement(row1);
					}
				}
				consumption=consumption+(int)price*customer.getReserveTimeLong();
				int  deposit=(int) ((int)price*customer.getReserveTimeLong()*1.5);
				depositText.setText(String.valueOf(deposit));
				cuonsumptionText.setText(String.valueOf(consumption));
				changeText.setText(String.valueOf(deposit-consumption));
				payInformationTable.updateUI();
				
				
				
				
			}
		});
		paySearchBu.setBounds(326, 16, 69, 31);
		
		JButton payAllBu = new JButton("\u7ED3\u8D26");
		payAllBu.setBounds(405, 15, 68, 32);
		payAllBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer customer=new Customer();
				CustomerDao customerDao=new CustomerDaoImp();
				RoomDao roomDao=new RoomDaoImp();
				RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
				HouseBill houseBill=new HouseBill();
				HouseBillDao houseBillDao=new HouseBillDaoImp();
				OutedRoomThingDao outedRoomThingDao=new OutedRoomThingDaoImp();
				PastCustomerDao pastCustomerDao=new PastCustomerDaoImp();
				String cuNoOrPhone=paySearchWayText.getText().toString();
				double consumption=0;
				if(payCuSearchWay.equals("顾客号：")) {
					
					
				}else if(payCuSearchWay.equals("手机号：")) {
					String cuNo=customerDao.getCuNoByCuPhone(cuNoOrPhone);
					cuNoOrPhone=cuNo;
				}
				
				customer=customerDao.getCustomerByCuNo(cuNoOrPhone);
				pastCustomerDao.add(customer);
				String roomNo=customerDao.getRoomNoByCuNo(cuNoOrPhone);
				int m=customerDao.updatePastRoomNoByCuNo(cuNoOrPhone, roomNo);
				int n=outedRoomThingDao.deleteByCuNo(cuNoOrPhone);
				int t=customerDao.deleteByCuNo(cuNoOrPhone);
				String str="yyyy-MM-dd-HH:mm:ss";
				Calendar cal = Calendar.getInstance(); 
				int year = cal.get(Calendar.YEAR); 
				int month = cal.get(Calendar.MONTH )+1; 
				int day=cal.get(Calendar.DAY_OF_MONTH);
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
				String date=simpleDateFormat.format(new Date());
				
				houseBill.setBillNo(date);
				houseBill.setBillKind("客房费用");
				houseBill.setCuNo(cuNoOrPhone);
				houseBill.setProfit(allPrice);
				houseBill.setYear(String.valueOf(year));
				houseBill.setMonth(String.valueOf(month));
				houseBill.setDay(String.valueOf(day));
				NowUserDao nowUserDao=new NowUserDaoImp();
				houseBill.setUserNo(nowUserDao.getUserByHouseNo("001"));
				int p=houseBillDao.add(houseBill);
				System.out.println(t);
				if(p>0) {
					WarningDialog warningDialog=new WarningDialog("结账完成！");
					warningDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}else {
					WarningDialog warningDialog=new WarningDialog("信息更新失败！");
					warningDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}
			}
		});
		
		paySearchWayText = new JTextField();
		paySearchWayText.setBounds(212, 18, 104, 28);
		paySearchWayText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6D88\u8D39\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel.setBounds(592, 16, 81, 29);
		
		
		
		JButton returnSystemBu = new JButton("\u8FD4\u56DE\u7CFB\u7EDF");
		returnSystemBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				houseSystemWindows.setVisible(true);
				PayAndOtherWindow.this.dispose();
			}
		});
		returnSystemBu.setBounds(729, 101, 92, 31);
		
		JLabel lblNewLabel_1 = new JLabel("\u7269\u54C1\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel_1.setBounds(15, 57, 100, 32);
		
		JComboBox thingSearchWayBox = new JComboBox();
		thingSearchWayBox.addItem("顾客号：");
		thingSearchWayBox.addItem("手机号：");
		thingSearchWayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					thingSearchWay=arg0.getItem().toString();
				}
			}
		});
		thingSearchWayBox.setBounds(125, 57, 81, 32);
		
		thingSearchWayText = new JTextField();
		thingSearchWayText.setBounds(212, 57, 104, 32);
		thingSearchWayText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7269\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_2.setBounds(326, 57, 69, 32);
		
		JComboBox thingNameBox = new JComboBox();
		thingNameBox.addItem("桌子");
		thingNameBox.addItem("椅子");
		thingNameBox.addItem("电视机");
		thingNameBox.addItem("矿泉水");
		thingNameBox.addItem("泡面");
		thingNameBox.addItem("床头灯");
		thingNameBox.addItem("吹风机");
		thingNameBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					thingName=arg0.getItem().toString();
				}
			}
		});
		thingNameBox.setBounds(405, 57, 100, 32);
		
		JLabel lblNewLabel_3 = new JLabel("\u7269\u54C1\u6570\u91CF\uFF1A");
		lblNewLabel_3.setBounds(515, 57, 84, 32);
		
		JComboBox thingNuBox = new JComboBox();
		thingNuBox.addItem("1");
		thingNuBox.addItem("2");
		thingNuBox.addItem("3");
		thingNuBox.addItem("4");
		thingNuBox.addItem("5");
		thingNuBox.addItem("6");
		thingNuBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					thingNu=arg0.getItem().toString();
				}
				
			}
		});
		thingNuBox.setBounds(632, 59, 87, 32);
		
		JButton writeThingBu = new JButton("\u767B\u8BB0\u4FE1\u606F");
		writeThingBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cuNoOrPhone=thingSearchWayText.getText().toString();
				CustomerDao customerDao=new CustomerDaoImp();
				RoomDao roomDao=new RoomDaoImp();
				RoomThingDao roomThingDao=new RoomThingDaoImp();
				OutedRoomThingDao outedRoomThingDao=new OutedRoomThingDaoImp();
				HouseBill houseBill=new HouseBill();
				HouseBillDao houseBillDao=new HouseBillDaoImp();
				
				if(thingSearchWay.equals("顾客号：")) {
					
					
				}else if(thingSearchWay.equals("手机号：")) {
					String cuNo=customerDao.getCuNoByCuPhone(cuNoOrPhone);
					cuNoOrPhone=cuNo;
				}
				String roomNo=customerDao.getRoomNoByCuNo(cuNoOrPhone);
				String thingNo=roomThingDao.getThingNoByKey(roomNo, thingName);
				int thingNuNow=roomThingDao.getRoomthingNuByKey(roomNo, thingNo);
				if(thingNuNow>=Integer.valueOf(thingNu)) {
					
				}else {
					thingNu=String.valueOf(thingNuNow);
				}
				int price=roomThingDao.getThingPriceByKey(roomNo, thingNo);
				int payMoney=Integer.valueOf(thingNu)*price;
				OutedRoomThing outedRoomThing=new OutedRoomThing();
				outedRoomThing.setCuNo(cuNoOrPhone);
				outedRoomThing.setPayMoney(payMoney);
				outedRoomThing.setRoomNo(roomNo);
				outedRoomThing.setThingName(thingName);
				outedRoomThing.setThingNo(thingNo);
				outedRoomThing.setThingOutAmount(Integer.valueOf(thingNu));
				outedRoomThing.setThingPrice(price);
				outedRoomThingDao.add(outedRoomThing);
				roomThingDao.updateThingdownByKey(roomNo, thingNo, Integer.valueOf(thingNu));
				
				String str="yyyy-MM-dd-HH:mm:ss";
				Calendar cal = Calendar.getInstance(); 
				int year = cal.get(Calendar.YEAR); 
				int month = cal.get(Calendar.MONTH )+1; 
				int day=cal.get(Calendar.DAY_OF_MONTH);
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
				String date=simpleDateFormat.format(new Date());
				/*String year=simpleDateFormat.format(new Date());
				SimpleDateFormat simpleDateFormat2=new SimpleDateFormat(str2);
				String month=simpleDateFormat.format(new Date());
				SimpleDateFormat simpleDateFormat3=new SimpleDateFormat(str3);
				String day=simpleDateFormat.format(new Date());
				System.out.println(day);*/
				houseBill.setBillNo(date);
				houseBill.setBillKind("物品出售");
				houseBill.setCuNo(cuNoOrPhone);
				houseBill.setProfit(payMoney);
				houseBill.setYear(String.valueOf(year));
				houseBill.setMonth(String.valueOf(month));
				houseBill.setDay(String.valueOf(day));
				NowUserDao nowUserDao=new NowUserDaoImp();
				houseBill.setUserNo(nowUserDao.getUserByHouseNo("001"));
				int n=houseBillDao.add(houseBill);
				if(n>0) {
					WarningDialog warningDialog=new WarningDialog("登记成功！");
					warningDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}else {
					WarningDialog warningDialog=new WarningDialog("登记失败！");
					warningDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}
				
			}
		});
		writeThingBu.setBounds(729, 57, 92, 32);
		
		JLabel lblNewLabel_4 = new JLabel("\u9000\u8BA2\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel_4.setBounds(15, 99, 100, 35);
		
		JComboBox backSearchWayBox = new JComboBox();
		backSearchWayBox.addItem("顾客号：");
		backSearchWayBox.addItem("手机号：");
		backSearchWayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					backSearchWay=arg0.getItem().toString();
				}
			}
		});
		backSearchWayBox.setBounds(125, 99, 81, 35);
		
		backSearchWayText = new JTextField();
		backSearchWayText.setBounds(212, 99, 104, 35);
		backSearchWayText.setColumns(10);
		
		JTextArea showBackText = new JTextArea();
		showBackText.setText("0");
		showBackText.setFont(new Font("Monospaced", Font.BOLD, 20));
		showBackText.setEditable(false);
		showBackText.setBounds(538, 99, 84, 35);
		
		JButton backSearchBu = new JButton("\u67E5\u8BE2");
		backSearchBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String CuNoOrPhone=backSearchWayText.getText().toString();
				CustomerDao customerDao=new CustomerDaoImp();
				
				
				if(backSearchWay.equals("顾客号：")) {
					String payStatus=customerDao.getPayStatusByCuNo(CuNoOrPhone);
					if(payStatus.equals("未结账已付定金")) {
						backRoomNo=customerDao.getRoomNoByCuNo(CuNoOrPhone);
						RoomDao roomDao=new RoomDaoImp();
						String typeno=roomDao.getTypeNoByRoomNo(backRoomNo);
						RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
						int typePrice=roomTypeDao.getRoomPriceByTypeNo(typeno)/2;
						showBackText.setText(String.valueOf(typePrice));
					}else {
						FailInformationDialog failInformationDialog=new FailInformationDialog();
						failInformationDialog.setLocationRelativeTo(PayAndOtherWindow.this);
						failInformationDialog.setModal(true);
						failInformationDialog.setVisible(true);
					}
					
				}else if(backSearchWay.equals("手机号：")) {
					String payStatus=customerDao.getPayStatusByCuNo(CuNoOrPhone);
					if(payStatus.equals("未结账已付定金")) {
						backRoomNo=customerDao.getRoomNoByCuNo(CuNoOrPhone);
						RoomDao roomDao=new RoomDaoImp();
						String typeno=roomDao.getTypeNoByRoomNo(backRoomNo);
						RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
						int typePrice=roomTypeDao.getRoomPriceByTypeNo(typeno)/2;
						showBackText.setText(String.valueOf(typePrice));
					}else {
						FailInformationDialog failInformationDialog=new FailInformationDialog();
						failInformationDialog.setVisible(true);
					}
					
				}
			}
		});
		backSearchBu.setBounds(326, 99, 69, 35);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BA2\u91D1\u6570\u76EE\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel_5.setBounds(405, 99, 123, 35);
		
		
		
		JButton backBu = new JButton("\u9000\u6B3E");
		backBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.valueOf(showBackText.getText())>0) {
					String searchCuNoOrCuPhone=backSearchWayText.getText().toString();
					if (backSearchWay.equals("顾客号：")) {
						CustomerDao customerDao=new CustomerDaoImp();
						customerDao.updateCuPayByCuNo(searchCuNoOrCuPhone, "已退订金");
						RoomDao roomDao=new RoomDaoImp();
						roomDao.updateRoomStatusByRoomNo(backRoomNo, "空闲");
						backSearchWayText.setText("");
						showBackText.setText("");
					}else if(backSearchWay.equals("手机号：")) {
						CustomerDao customerDao=new CustomerDaoImp();
						customerDao.updateCuPayByCuPhone(searchCuNoOrCuPhone, "已退订金");
						RoomDao roomDao=new RoomDaoImp();
						roomDao.updateRoomStatusByRoomNo(backRoomNo, "空闲");
						backSearchWayText.setText("");
						showBackText.setText("");
					}	
				}else {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					failInformationDialog.setModal(true);
					failInformationDialog.setVisible(true);
				}
				
			}
		});
		backBu.setBounds(632, 99, 87, 35);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(cuonsumptionText);
		contentPane.add(returnSystemBu);
		contentPane.add(lblNewLabel_1);
		contentPane.add(thingSearchWayBox);
		contentPane.add(thingSearchWayText);
		contentPane.add(lblNewLabel_2);
		contentPane.add(thingNameBox);
		contentPane.add(lblNewLabel_3);
		contentPane.add(thingNuBox);
		contentPane.add(writeThingBu);
		contentPane.add(lblNewLabel_4);
		contentPane.add(backSearchWayBox);
		contentPane.add(backSearchWayText);
		contentPane.add(backSearchBu);
		contentPane.add(lblNewLabel_5);
		contentPane.add(showBackText);
		contentPane.add(backBu);
		contentPane.add(label);
		contentPane.add(payCuSearchWayBox);
		contentPane.add(paySearchWayText);
		contentPane.add(paySearchBu);
		contentPane.add(payAllBu);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 207, 823, 259);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.NORTH);
		
		columnNames.addElement("顾客号");
		columnNames.addElement("姓名");
		columnNames.addElement("房间号");
		columnNames.addElement("手机号");
		columnNames.addElement("消费种类");
		columnNames.addElement("消费金额");
		
		payInformationTable = new JTable(allRows,columnNames);
		scrollPane.setViewportView(payInformationTable);
		
		JLabel lblNewLabel_6 = new JLabel("\u62BC\u91D1\uFF1A");
		lblNewLabel_6.setBounds(483, 15, 48, 31);
		contentPane.add(lblNewLabel_6);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("\u627E\u96F6\uFF1A");
		lblNewLabel_7.setBounds(729, 13, 44, 32);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u9910\u8D39\u8BA2\u8D2D\u65B9\u5F0F\uFF1A");
		lblNewLabel_8.setBounds(15, 144, 100, 29);
		contentPane.add(lblNewLabel_8);
		
		JComboBox foodWayBox = new JComboBox();
		foodWayBox.addItem("顾客号：");
		foodWayBox.addItem("手机号：");
		foodWayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange())
					foodWay=arg0.getItem().toString();
			}
		});
		foodWayBox.setBounds(125, 144, 81, 34);
		contentPane.add(foodWayBox);
		
		foodWayText = new JTextField();
		foodWayText.setBounds(212, 144, 56, 33);
		contentPane.add(foodWayText);
		foodWayText.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u83DC\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_9.setBounds(278, 144, 69, 29);
		contentPane.add(lblNewLabel_9);
		
		JComboBox foodNameBox = new JComboBox();
		foodNameBox.addItem("青椒炒肉");
		foodNameBox.addItem("西红柿炒鸡蛋");
		foodNameBox.addItem("馒头");
		foodNameBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					foodName=arg0.getItem().toString();
				}
					
			}
		});
		foodNameBox.setBounds(348, 142, 81, 33);
		contentPane.add(foodNameBox);
		
		JTextArea foodPriceText = new JTextArea();
		foodPriceText.setFont(new Font("Monospaced", Font.BOLD, 18));
		foodPriceText.setBounds(658, 144, 69, 31);
		contentPane.add(foodPriceText);
		
		JButton foodPriceBu = new JButton("\u67E5\u8BE2");
		foodPriceBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FoodDao foodDao=new FoodDaoImp();
				int price=foodDao.getPriceByName(foodName);
				foodPriceText.setText(String.valueOf(price));
			}
		});
		foodPriceBu.setBounds(436, 144, 69, 29);
		contentPane.add(foodPriceBu);
		
		JLabel lblNewLabel_10 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_10.setBounds(610, 144, 44, 34);
		contentPane.add(lblNewLabel_10);
		
		
		
		JButton foodPayBu = new JButton("\u767B\u8BB0\u6D88\u8D39");
		foodPayBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cuNoOrPhone=foodWayText.getText().toString();
				CustomerDao customerDao=new CustomerDaoImp();
				RoomDao roomDao=new RoomDaoImp();
				OutedRoomThingDao outedRoomThingDao=new OutedRoomThingDaoImp();
				HouseBill houseBill=new HouseBill();
				HouseBillDao houseBillDao=new HouseBillDaoImp();
				FoodDao foodDao=new FoodDaoImp();
				int price=foodDao.getPriceByName(foodName);
				
				if(thingSearchWay.equals("顾客号：")) {
					
					
				}else if(thingSearchWay.equals("手机号：")) {
					String cuNo=customerDao.getCuNoByCuPhone(cuNoOrPhone);
					cuNoOrPhone=cuNo;
				}
				String str="yyyy-MM-dd-HH:mm:ss";
				Calendar cal = Calendar.getInstance(); 
				int year = cal.get(Calendar.YEAR); 
				int month = cal.get(Calendar.MONTH )+1; 
				int day=cal.get(Calendar.DAY_OF_MONTH);
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
				String date=simpleDateFormat.format(new Date());
				
				String roomNo=customerDao.getRoomNoByCuNo(cuNoOrPhone);
				int payMoney=Integer.parseInt(foodNu)*price;
				OutedRoomThing outedRoomThing=new OutedRoomThing();
				outedRoomThing.setCuNo(cuNoOrPhone);
				outedRoomThing.setPayMoney(payMoney);
				outedRoomThing.setRoomNo(roomNo);
				outedRoomThing.setThingName(foodName);
				outedRoomThing.setThingNo(date);
				outedRoomThing.setThingOutAmount(Integer.valueOf(foodNu));
				outedRoomThing.setThingPrice(price);
				outedRoomThingDao.add(outedRoomThing);
				//roomThingDao.updateThingdownByKey(roomNo, thingNo, Integer.valueOf(thingNu));
				
				
				houseBill.setBillNo(date);
				houseBill.setBillKind("物品出售");
				houseBill.setCuNo(cuNoOrPhone);
				houseBill.setProfit(payMoney);
				houseBill.setYear(String.valueOf(year));
				houseBill.setMonth(String.valueOf(month));
				houseBill.setDay(String.valueOf(day));
				NowUserDao nowUserDao=new NowUserDaoImp();
				houseBill.setUserNo(nowUserDao.getUserByHouseNo("001"));
				int n=houseBillDao.add(houseBill);
				if(n>0) {
					WarningDialog warningDialog=new WarningDialog("登记成功！");
					warningDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}else {
					WarningDialog warningDialog=new WarningDialog("登记失败！");
					warningDialog.setLocationRelativeTo(PayAndOtherWindow.this);
					warningDialog.setModal(true);
					warningDialog.setVisible(true);
				}
				
			}
			
		});
		foodPayBu.setBounds(728, 147, 93, 26);
		contentPane.add(foodPayBu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					foodNu=arg0.getItem().toString();
				}
				
			}
		});
		comboBox.setBounds(560, 144, 39, 29);
		contentPane.add(comboBox);
		
		
		JLabel label_1 = new JLabel("\u6570\u91CF\uFF1A");
		label_1.setBounds(513, 144, 44, 29);
		contentPane.add(label_1);
		
		
	}
}
