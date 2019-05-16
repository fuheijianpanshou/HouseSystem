package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComplexObjectClass.EmptyRoomInformationTable;
import ComplexObjectClass.EmptyRoomInformationTableDao;
import ComplexObjectClass.EmptyRoomInformationTableDaoImp;
import ObjectClass.Customer;
import ObjectClass.CustomerDao;
import ObjectClass.CustomerDaoImp;
import ObjectClass.RoomDao;
import ObjectClass.RoomDaoImp;
import UI.WarningDialog;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchWindow extends JFrame {

	private JPanel contentPane;
	private JTable showRoomTable;
	private JTable showCustomerTable;
	private JTextField roomDescriptionText;
	private JTextField cuWayText;
	private JTextField roomNoText;
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allRows=new Vector<>();
	
	Vector<String> cuColumnNames=new Vector<>();
	Vector<Vector> cuAllRows=new Vector<>();

	/**
	 * Launch the application.
	 */
	
	String roomWay="����״̬";
	String cuWay="Ԥ���˿�";
	String floor="1";
	HouseSystemWindows houseSystemWindows;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow frame = new SearchWindow();
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
	public SearchWindow(HouseSystemWindows houseSystemWindows1) {
		houseSystemWindows=houseSystemWindows1;
		setTitle("\u4FE1\u606F\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 766, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u6761\u4EF6\u9009\u62E9\uFF1A");
		lblNewLabel.setBounds(10, 10, 92, 33);
		panel.add(lblNewLabel);
		
		JComboBox roomwayBox = new JComboBox();
		roomwayBox.addItem("����״̬");
		roomwayBox.addItem("��������");
		roomwayBox.addItem("����¥��");
		roomwayBox.addItem("������");
		roomwayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					roomWay=arg0.getItem().toString();
				}
			}
		});
		roomwayBox.setBounds(108, 10, 98, 33);
		panel.add(roomwayBox);
		
		JButton roomSearchBu = new JButton("\u67E5\u8BE2");
		roomSearchBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EmptyRoomInformationTableDao emptyRoomInformationTableDao=new EmptyRoomInformationTableDaoImp();
				List<EmptyRoomInformationTable> emptyRoomInformationTables=null;
	
				allRows.removeAllElements();
				if(roomWay.equals("����״̬")) {
	
					
					String status=roomDescriptionText.getText().toString();
					if(status.equals("")) {
						WarningDialog warningDialog=new WarningDialog("����״̬����Ϊ�գ�");
						warningDialog.setLocationRelativeTo(SearchWindow.this);
						warningDialog.setModal(true);
						warningDialog.setVisible(true);
					}else {
						emptyRoomInformationTables=emptyRoomInformationTableDao.getTableByRoomStatus(status);
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
							rows.addElement(emptyRoomInformationTable.getRoomStatus());
							allRows.addElement(rows);
							
						}
					}
					
				}else if(roomWay.equals("��������")) {
					String description=roomDescriptionText.getText().toString();
					if(description.equals("")) {
						WarningDialog warningDialog=new WarningDialog("������������Ϊ�գ�");
						warningDialog.setLocationRelativeTo(SearchWindow.this);
						warningDialog.setModal(true);
						warningDialog.setVisible(true);
					}else {
						emptyRoomInformationTables=emptyRoomInformationTableDao.getTableByRoomDescription(description);
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
							rows.addElement(emptyRoomInformationTable.getRoomStatus());
							allRows.addElement(rows);
					}
					}
					
				
				
				
				}else if(roomWay.equals("����¥��")) {
					
					String description=roomDescriptionText.getText().toString();
					emptyRoomInformationTables=emptyRoomInformationTableDao.getTableByFloor(Integer.valueOf(floor));
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
						rows.addElement(emptyRoomInformationTable.getRoomStatus());
						allRows.addElement(rows);
				}
				
					
				}else if(roomWay.equals("������")) {
					
					
					
						String roomNo=roomNoText.getText().toString();
						if (roomNo.equals("")) {
							WarningDialog warningDialog=new WarningDialog("����Ų���Ϊ�գ�");
							warningDialog.setLocationRelativeTo(SearchWindow.this);
							warningDialog.setModal(true);
							warningDialog.setVisible(true);
							
						}else {
							Vector<String> rows=new Vector<>();
							EmptyRoomInformationTable emptyRoomInformationTable=new EmptyRoomInformationTable();
							emptyRoomInformationTable=emptyRoomInformationTableDao.getRoomByRoomNo(roomNo);
							rows.addElement(emptyRoomInformationTable.getRoomNo());
							rows.addElement(emptyRoomInformationTable.getTypeName());
							rows.addElement(String.valueOf(emptyRoomInformationTable.getPeopleNu()));
							rows.addElement(String.valueOf(emptyRoomInformationTable.getRoomFloor()));
							rows.addElement(String.valueOf(emptyRoomInformationTable.getTypePrice()));
							rows.addElement(String.valueOf(emptyRoomInformationTable.getTypeArea()));
							rows.addElement(emptyRoomInformationTable.getRoomDescription());
							rows.addElement(emptyRoomInformationTable.getRoomStatus());
							allRows.addElement(rows);
						}
						
				
				
				}
				
				showRoomTable.updateUI();
			}
		});
		roomSearchBu.setBounds(544, 10, 93, 33);
		panel.add(roomSearchBu);
		
		JButton returnBu = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		returnBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchWindow.this.dispose();
				houseSystemWindows.setVisible(true);
			}
		});
		returnBu.setBounds(647, 10, 109, 33);
		panel.add(returnBu);
		
		JLabel lblNewLabel_1 = new JLabel("\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setBounds(216, 10, 39, 33);
		panel.add(lblNewLabel_1);
		
		roomDescriptionText = new JTextField();
		roomDescriptionText.setBounds(254, 10, 66, 33);
		panel.add(roomDescriptionText);
		roomDescriptionText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u697C\u5C42\uFF1A");
		lblNewLabel_2.setBounds(330, 10, 46, 33);
		panel.add(lblNewLabel_2);
		
		JComboBox floorBox = new JComboBox();
		floorBox.addItem("1");
		floorBox.addItem("2");
		floorBox.addItem("3");
		floorBox.addItem("4");
		floorBox.addItem("5");
		floorBox.addItem("6");
		floorBox.addItem("7");
		floorBox.addItem("8");
		floorBox.addItem("9");
		floorBox.addItem("10");
		floorBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (ItemEvent.SELECTED==arg0.getStateChange()) {
					floor=arg0.getItem().toString();
				}
				
				
			}
		});
		floorBox.setBounds(374, 10, 46, 33);
		panel.add(floorBox);
		
		JLabel lblNewLabel_5 = new JLabel("\u623F\u53F7\uFF1A");
		lblNewLabel_5.setBounds(430, 10, 39, 33);
		panel.add(lblNewLabel_5);
		
		roomNoText = new JTextField();
		roomNoText.setBounds(468, 10, 66, 33);
		panel.add(roomNoText);
		roomNoText.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 766, 136);
		contentPane.add(scrollPane);
		
		columnNames.add("�����");
		columnNames.add("������");
		columnNames.add("��ס����");
		columnNames.add("¥��");
		columnNames.add("�۸�");
		columnNames.add("���");
		columnNames.add("����");
		columnNames.add("״̬");
		
		showRoomTable = new JTable(allRows,columnNames);
		scrollPane.setViewportView(showRoomTable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 230, 766, 77);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u987E\u5BA2\u6761\u4EF6\u9009\u62E9\uFF1A");
		lblNewLabel_3.setBounds(10, 26, 96, 28);
		panel_1.add(lblNewLabel_3);
		
		JComboBox cuWayBox = new JComboBox();
		cuWayBox.addItem("Ԥ���˿�");
		cuWayBox.addItem("��ס�˿�");
		cuWayBox.addItem("�˷��˿�");
		cuWayBox.addItem("�˿ͺ�");
		cuWayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					cuWay=arg0.getItem().toString();
				}
			}
		});
		cuWayBox.setBounds(116, 26, 98, 28);
		panel_1.add(cuWayBox);
		
		JLabel lblNewLabel_4 = new JLabel("\u6761\u4EF6\uFF1A");
		lblNewLabel_4.setBounds(224, 26, 46, 28);
		panel_1.add(lblNewLabel_4);
		
		cuWayText = new JTextField();
		cuWayText.setBounds(280, 27, 84, 28);
		panel_1.add(cuWayText);
		cuWayText.setColumns(10);
		
		JButton cuSearchBu = new JButton("\u67E5\u8BE2");
		cuSearchBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cuAllRows.removeAllElements();
				CustomerDao customerDao=new CustomerDaoImp();
				List<Customer> customers=new ArrayList<>();
				if(cuWay.equals("Ԥ���˿�")) {
					customers=customerDao.getCustomerByPayStatus("δ�����Ѹ�����");
					if(customers.size()>0) {
						for(int i=0;i<customers.size();i++) {
							Customer customer=new Customer();
							customer=customers.get(i);
							Vector<String> cuRow=new Vector<>();
							cuRow.addElement(customer.getCuNo());
							cuRow.addElement(customer.getCuName());
							cuRow.addElement(customer.getCuSex());
							cuRow.addElement(customer.getCuPhone());
							cuRow.addElement(customer.getCuCard());
							cuRow.addElement(customer.getCuPay());
							cuRow.addElement(customer.getCuReserveTime());
							cuRow.addElement(customer.getCuCheckTime());
							cuRow.addElement(String.valueOf(customer.getReserveTimeLong()));
							cuRow.addElement(customer.getCuRoomNo());
							cuRow.addElement(customer.getPastCuRoomNo());
							cuAllRows.addElement(cuRow);
							
						}
					}
					}else if(cuWay.equals("��ס�˿�")) {
						
						customers=customerDao.getCustomerByPayStatus("�Ѹ�Ѻ��");
						if(customers.size()>0) {
							for(int i=0;i<customers.size();i++) {
								Customer customer=new Customer();
								customer=customers.get(i);
								Vector<String> cuRow=new Vector<>();
								cuRow.addElement(customer.getCuNo());
								cuRow.addElement(customer.getCuName());
								cuRow.addElement(customer.getCuSex());
								cuRow.addElement(customer.getCuPhone());
								cuRow.addElement(customer.getCuCard());
								cuRow.addElement(customer.getCuPay());
								cuRow.addElement(customer.getCuReserveTime());
								cuRow.addElement(customer.getCuCheckTime());
								cuRow.addElement(String.valueOf(customer.getReserveTimeLong()));
								cuRow.addElement(customer.getCuRoomNo());
								cuRow.addElement(customer.getPastCuRoomNo());
								cuAllRows.addElement(cuRow);
								
							}
						}
					}else if(cuWay.equals("�˷��˿�")) {
						customers=customerDao.getCustomerByPayStatus("�ѽ���");
						if(customers.size()>0) {
							for(int i=0;i<customers.size();i++) {
								Customer customer=new Customer();
								customer=customers.get(i);
								Vector<String> cuRow=new Vector<>();
								cuRow.addElement(customer.getCuNo());
								cuRow.addElement(customer.getCuName());
								cuRow.addElement(customer.getCuSex());
								cuRow.addElement(customer.getCuPhone());
								cuRow.addElement(customer.getCuCard());
								cuRow.addElement(customer.getCuPay());
								cuRow.addElement(customer.getCuReserveTime());
								cuRow.addElement(customer.getCuCheckTime());
								cuRow.addElement(String.valueOf(customer.getReserveTimeLong()));
								cuRow.addElement(customer.getCuRoomNo());
								cuRow.addElement(customer.getPastCuRoomNo());
								cuAllRows.addElement(cuRow);
								
							}
						}
					}else if(cuWay.equals("�˿ͺ�")) {
						String cuNo=cuWayText.getText().toString();
						Customer customer=new Customer();
						customer=customerDao.getCustomerByCuNo(cuNo);
						Vector<String> cuRow=new Vector<>();
						cuRow.addElement(customer.getCuNo());
						cuRow.addElement(customer.getCuName());
						cuRow.addElement(customer.getCuSex());
						cuRow.addElement(customer.getCuPhone());
						cuRow.addElement(customer.getCuCard());
						cuRow.addElement(customer.getCuPay());
						cuRow.addElement(customer.getCuReserveTime());
						cuRow.addElement(customer.getCuCheckTime());
						cuRow.addElement(String.valueOf(customer.getReserveTimeLong()));
						cuRow.addElement(customer.getCuRoomNo());
						cuRow.addElement(customer.getPastCuRoomNo());
						cuAllRows.addElement(cuRow);
						
					}
				showCustomerTable.updateUI();
			}
		});
		cuSearchBu.setBounds(386, 26, 93, 28);
		panel_1.add(cuSearchBu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 317, 766, 157);
		contentPane.add(scrollPane_1);
		
		cuColumnNames.addElement("�˿ͺ�");
		cuColumnNames.addElement("����");
		cuColumnNames.addElement("�Ա�");
		cuColumnNames.addElement("�绰");
		cuColumnNames.addElement("���֤");
		cuColumnNames.addElement("֧��״̬");
		cuColumnNames.addElement("Ԥ����סʱ��");
		cuColumnNames.addElement("��סʱ��");
		cuColumnNames.addElement("��סʱ��");
		cuColumnNames.addElement("�����");
		cuColumnNames.addElement("��ȥ�����");
		
		
		showCustomerTable = new JTable(cuAllRows,cuColumnNames);
		scrollPane_1.setViewportView(showCustomerTable);
	}
}
