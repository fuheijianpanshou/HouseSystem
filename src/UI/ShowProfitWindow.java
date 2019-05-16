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

import ObjectClass.HouseBill;
import ObjectClass.HouseBillDao;
import ObjectClass.HouseBillDaoImp;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ShowProfitWindow extends JFrame {

	private JPanel contentPane;
	private JTextField yearText;
	private JTable allshowTable;
	private JTextField monthText;
	private JTextField dayText;
	
	String way="年度统计";
	
	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allrows=new Vector<>();
	
	HouseSystemWindows houseSystemWindows;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProfitWindow frame = new ShowProfitWindow();
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
	public ShowProfitWindow(HouseSystemWindows houseSystemWindows1) {
		houseSystemWindows=houseSystemWindows1;
		setTitle("\u5229\u6DA6\u7EDF\u8BA1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 729, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u7EDF\u8BA1\u6761\u4EF6\uFF1A");
		lblNewLabel.setBounds(10, 10, 103, 32);
		panel.add(lblNewLabel);
		
		JComboBox wayBox = new JComboBox();
		wayBox.addItem("年度统计");
		wayBox.addItem("月度统计");
		wayBox.addItem("日统计");
		wayBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED==arg0.getStateChange()) {
					way=arg0.getItem().toString();
				}
				
			}
		});
		wayBox.setBounds(116, 10, 90, 36);
		panel.add(wayBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E74\uFF1A");
		lblNewLabel_1.setBounds(219, 11, 33, 32);
		panel.add(lblNewLabel_1);
		
		yearText = new JTextField();
		yearText.setFont(new Font("宋体", Font.BOLD, 20));
		yearText.setBounds(262, 7, 75, 39);
		panel.add(yearText);
		yearText.setColumns(10);
		
		JTextArea showProfitText = new JTextArea();
		showProfitText.setFont(new Font("Monospaced", Font.BOLD, 20));
		showProfitText.setBounds(135, 78, 90, 39);
		panel.add(showProfitText);
		
		JButton startBu = new JButton("\u5F00\u59CB\u7EDF\u8BA1");
		startBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allrows.removeAllElements();
				HouseBillDao houseBillDao=new HouseBillDaoImp();
				List<HouseBill> houseBills=new ArrayList<>();
				int allprofit=0;
				if(way.equals("年度统计")) {
					String year=yearText.getText().toString();
					houseBills=houseBillDao.getBillByYear(year);
					
					for(int i=0;i<houseBills.size();i++) {
						HouseBill houseBill=new HouseBill();
						houseBill=houseBills.get(i);
						Vector<String> row=new Vector<>();
						row.addElement(houseBill.getBillNo());
						row.addElement(houseBill.getBillKind());
						row.addElement(houseBill.getCuNo());
						row.addElement(houseBill.getUserNo());
						row.addElement(houseBill.getYear());
						row.addElement(houseBill.getMonth());
						row.addElement(houseBill.getDay());
						row.addElement(String.valueOf(houseBill.getProfit()));
						allprofit=allprofit+houseBill.getProfit();
						allrows.addElement(row);
					}
					showProfitText.setText(String.valueOf(allprofit));
					
					
				}else if(way.equals("月度统计")) {
					String year=yearText.getText().toString();
					String month=monthText.getText().toString();
					houseBills=houseBillDao.getBillByMonth(year, month);
					
					for(int i=0;i<houseBills.size();i++) {
						HouseBill houseBill=new HouseBill();
						houseBill=houseBills.get(i);
						Vector<String> row=new Vector<>();
						row.addElement(houseBill.getBillNo());
						row.addElement(houseBill.getBillKind());
						row.addElement(houseBill.getCuNo());
						row.addElement(houseBill.getUserNo());
						row.addElement(houseBill.getYear());
						row.addElement(houseBill.getMonth());
						row.addElement(houseBill.getDay());
						row.addElement(String.valueOf(houseBill.getProfit()));
						allprofit=allprofit+houseBill.getProfit();
						allrows.addElement(row);
					}
					showProfitText.setText(String.valueOf(allprofit));
				}else if(way.equals("日统计")) {
					String year=yearText.getText().toString();
					String month=monthText.getText().toString();
					String day=dayText.getText().toString();
					houseBills=houseBillDao.getBillByDay(year, month, day);
					
					for(int i=0;i<houseBills.size();i++) {
						HouseBill houseBill=new HouseBill();
						houseBill=houseBills.get(i);
						Vector<String> row=new Vector<>();
						row.addElement(houseBill.getBillNo());
						row.addElement(houseBill.getBillKind());
						row.addElement(houseBill.getCuNo());
						row.addElement(houseBill.getUserNo());
						row.addElement(houseBill.getYear());
						row.addElement(houseBill.getMonth());
						row.addElement(houseBill.getDay());
						row.addElement(String.valueOf(houseBill.getProfit()));
						allprofit=allprofit+houseBill.getProfit();
						allrows.addElement(row);
					}
					showProfitText.setText(String.valueOf(allprofit));
					
				}
				allshowTable.updateUI();
			}
		});
		startBu.setBounds(586, 10, 93, 32);
		panel.add(startBu);
		
		JLabel lblNewLabel_2 = new JLabel("\u603B\u5171\u6536\u6B3E\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel_2.setBounds(10, 78, 115, 39);
		panel.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("\u6708\uFF1A");
		lblNewLabel_3.setBounds(347, 10, 33, 32);
		panel.add(lblNewLabel_3);
		
		monthText = new JTextField();
		monthText.setFont(new Font("宋体", Font.BOLD, 20));
		monthText.setBounds(391, 9, 66, 36);
		panel.add(monthText);
		monthText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u65E5\uFF1A");
		lblNewLabel_4.setBounds(467, 8, 33, 36);
		panel.add(lblNewLabel_4);
		
		dayText = new JTextField();
		dayText.setFont(new Font("宋体", Font.BOLD, 20));
		dayText.setBounds(510, 9, 66, 36);
		panel.add(dayText);
		dayText.setColumns(10);
		
		JButton returnBu = new JButton("\u8FD4\u56DE\u4E3B\u9875");
		returnBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				houseSystemWindows.setVisible(true);
				ShowProfitWindow.this.dispose();
			}
		});
		returnBu.setBounds(556, 61, 93, 32);
		panel.add(returnBu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 139, 729, 311);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 709, 291);
		panel_1.add(scrollPane);
		
		columnNames.addElement("账单号");
		columnNames.addElement("账单类型");
		columnNames.addElement("客户号");
		columnNames.addElement("员工号");
		columnNames.addElement("年");
		columnNames.addElement("月");
		columnNames.addElement("日");
		columnNames.addElement("收入（元）");
		
		allshowTable = new JTable(allrows,columnNames);
		scrollPane.setViewportView(allshowTable);
	}
}
