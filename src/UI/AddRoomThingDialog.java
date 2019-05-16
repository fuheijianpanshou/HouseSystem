package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.RoomThing;
import ObjectClass.RoomThingDao;
import ObjectClass.RoomThingDaoImp;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class AddRoomThingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField roomNoText;
	private JTextField thingNoText;
	private JTextField thingPriceText;
	private JTextField thingNameText;
	private JTable roomThingTable;
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allrows=new Vector<>();
	
	String thingNu="1";
	
	String way="数量";
	
	String isHigh="+";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddRoomThingDialog dialog = new AddRoomThingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddRoomThingDialog() {
		setTitle("\u6DFB\u52A0\u7269\u54C1");
		setBounds(100, 100, 600, 373);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 574, 281);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		lblNewLabel.setBounds(16, 12, 54, 24);
		contentPanel.add(lblNewLabel);
		
		roomNoText = new JTextField();
		roomNoText.setBounds(72, 10, 66, 26);
		contentPanel.add(roomNoText);
		roomNoText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7269\u54C1\u53F7\uFF1A");
		lblNewLabel_1.setBounds(148, 11, 54, 26);
		contentPanel.add(lblNewLabel_1);
		
		thingNoText = new JTextField();
		thingNoText.setBounds(203, 12, 66, 26);
		contentPanel.add(thingNoText);
		thingNoText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7269\u54C1\u4EF7\u683C\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel_2.setBounds(185, 47, 105, 30);
		contentPanel.add(lblNewLabel_2);
		
		thingPriceText = new JTextField();
		thingPriceText.setBounds(289, 47, 66, 32);
		contentPanel.add(thingPriceText);
		thingPriceText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_3.setBounds(279, 8, 43, 32);
		contentPanel.add(lblNewLabel_3);
		
		JComboBox thingNuBox = new JComboBox();
		thingNuBox.addItem("1");
		thingNuBox.addItem("2");
		thingNuBox.addItem("3");
		thingNuBox.addItem("4");
		thingNuBox.addItem("5");
		thingNuBox.addItem("6");
		thingNuBox.addItem("7");
		thingNuBox.addItem("8");
		thingNuBox.addItem("9");
		thingNuBox.addItem("10");
		thingNuBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					thingNu=arg0.getItem().toString();
				}
				
			}
		});
		thingNuBox.setBounds(329, 9, 43, 30);
		contentPanel.add(thingNuBox);
		
		JLabel lblNewLabel_4 = new JLabel("\u7269\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_4.setBounds(16, 49, 72, 26);
		contentPanel.add(lblNewLabel_4);
		
		thingNameText = new JTextField();
		thingNameText.setBounds(94, 48, 81, 32);
		contentPanel.add(thingNameText);
		thingNameText.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 134, 548, 147);
		contentPanel.add(scrollPane);
		
		columnNames.addElement("房间号");
		columnNames.addElement("物品号");
		columnNames.addElement("物品名");
		columnNames.addElement("物品价格");
		columnNames.addElement("物品数量");
		
		roomThingTable = new JTable(allrows,columnNames);
		scrollPane.setViewportView(roomThingTable);
		
		JButton searchThingBu = new JButton("\u623F\u95F4\u7269\u54C1");
		searchThingBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomNo=roomNoText.getText().toString();
				if(roomNo.equals("")) {
					
				}else {
					allrows.removeAllElements();
					RoomThingDao roomThingDao=new RoomThingDaoImp();
					List<RoomThing> roomThings=new ArrayList<>(); 
					roomThings=roomThingDao.getRoomThingsByRoomNo(roomNo);
					if(roomThings.size()>0) {
						for(int i=0;i<roomThings.size();i++) {
							RoomThing roomThing=new RoomThing();
							roomThing=roomThings.get(i);
							Vector<String> row=new Vector<>();
							row.addElement(roomNo);
							row.addElement(roomThing.getThingNo());
							row.addElement(roomThing.getThingName());
							row.addElement(String.valueOf(roomThing.getThingPrice()));
							row.addElement(String.valueOf(roomThing.getThingAmount()));
							allrows.addElement(row);
						}
						roomThingTable.updateUI();
					}
					
				}
			}
		});
		searchThingBu.setBounds(402, 48, 93, 29);
		contentPanel.add(searchThingBu);
		
		JLabel lblNewLabel_5 = new JLabel("\u65B9\u5F0F\uFF1A");
		lblNewLabel_5.setBounds(452, 12, 43, 24);
		contentPanel.add(lblNewLabel_5);
		
		JComboBox wayBox = new JComboBox();
		wayBox.addItem("数量");
		wayBox.addItem("价格");
		wayBox.addItem("增添");
		wayBox.addItem("删除");
		wayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					way=arg0.getItem().toString();
				}
			}
		});
		
		wayBox.setBounds(504, 11, 60, 26);
		contentPanel.add(wayBox);
		
		JComboBox isHightBox = new JComboBox();
		isHightBox.addItem("+");
		isHightBox.addItem("-");
		isHightBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					isHigh=arg0.getItem().toString();
				}
			}
		});
		isHightBox.setBounds(382, 8, 43, 32);
		contentPanel.add(isHightBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 291, 564, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("\u786E\u8BA4\u66F4\u65B0");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(way.equals("数量")){
							String roomNo=roomNoText.getText().toString();
							String thingNo=thingNoText.getText().toString();
							int thingAm=Integer.valueOf(thingNu);
							RoomThingDao roomThingDao=new RoomThingDaoImp();
							int n;
							if(isHigh.equals("+")) {
								n=roomThingDao.updateThingNuByKey(roomNo, thingNo, thingAm);
							}else if(isHigh.equals("-")) {
								n=roomThingDao.updateThingdownByKey(roomNo, thingNo, thingAm);
							}else {
								n=0;
							}
							
							if(n==0) {
								
							}else {
								
							}
							
						}else if(way.equals("价格")) {
							String roomNo=roomNoText.getText().toString();
							String thingNo=thingNoText.getText().toString();
							int price=Integer.valueOf(thingPriceText.getText());
							RoomThingDao roomThingDao=new RoomThingDaoImp();
							int n=roomThingDao.updateThingPriceByKey(roomNo, thingNo, price);
							if(n==0) {
								
							}else {
								
							}
						}else if(way.equals("增添")) {
							String roomNo=roomNoText.getText().toString();
							String thingNo=thingNoText.getText().toString();
							String thingName=thingNameText.getText().toString();
							int price=Integer.valueOf(thingPriceText.getText());
							int amount=Integer.valueOf(thingNu);
							RoomThing roomThing=new RoomThing();
							roomThing.setRoomNo(roomNo);
							roomThing.setThingNo(thingNo);
							roomThing.setThingName(thingName);
							roomThing.setThingPrice(price);
							roomThing.setThingAmount(amount);
							RoomThingDao roomThingDao=new RoomThingDaoImp();
							roomThingDao.add(roomThing);
						}else if(way.equals("删除")) {
							String roomNo=roomNoText.getText().toString();
							String thingNo=thingNoText.getText().toString();
							RoomThingDao roomThingDao=new RoomThingDaoImp();
							roomThingDao.delteThingByKey(roomNo, thingNo);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88\u66F4\u65B0");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AddRoomThingDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
