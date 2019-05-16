package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.HouseNews;
import ObjectClass.HouseNewsDao;
import ObjectClass.HouseNewsDaoImp;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class WriteNewsWindow extends JFrame {

	private JPanel contentPane;
	private JTextField newsKindText;
	private JTextField newsNoText;
	private JTable showNewsTable;
	

	Vector<String> columnNames=new Vector<>();
	Vector<Vector> allRows=new Vector<>();
	
	HouseSystemWindows houseSystemWindows;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteNewsWindow frame = new WriteNewsWindow();
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
	public WriteNewsWindow(HouseSystemWindows houseSystemWindows1) {
		houseSystemWindows=houseSystemWindows1;
		setResizable(false);
		setTitle("\u65B0\u95FB\u66F4\u65B0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 730, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u65B0\u95FB\u79CD\u7C7B\uFF1A");
		lblNewLabel.setBounds(10, 10, 75, 30);
		panel.add(lblNewLabel);
		
		newsKindText = new JTextField();
		newsKindText.setBounds(95, 10, 87, 30);
		panel.add(newsKindText);
		newsKindText.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 710, 231);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u6709\u65B0\u95FB\uFF1A");
		lblNewLabel_1.setLabelFor(scrollPane);
		
		columnNames.addElement("新闻号");
		columnNames.addElement("发布时间");
		columnNames.addElement("新闻种类");
		columnNames.addElement("新闻内容");
		
		showNewsTable = new JTable(allRows,columnNames);
		scrollPane.setViewportView(showNewsTable);
		lblNewLabel_1.setBounds(10, 198, 75, 15);
		panel.add(lblNewLabel_1);
		
		JTextPane newsContentText = new JTextPane();
		newsContentText.setBounds(10, 84, 337, 104);
		panel.add(newsContentText);
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u95FB\u5185\u5BB9\uFF1A");
		lblNewLabel_2.setLabelFor(newsContentText);
		lblNewLabel_2.setBounds(10, 69, 75, 15);
		panel.add(lblNewLabel_2);
		
		JButton insertBu = new JButton("\u63D2\u5165\u65B0\u95FB");
		insertBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newsKinds=newsKindText.getText().toString();
				String newsContent=newsContentText.getText().toString();
				String str="yyyy-MM-dd-HH:mm";
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat(str);
				String updateTime=simpleDateFormat.format(new Date());
				String nowsNo=updateTime+"-"+newsKinds;
				HouseNews houseNews=new HouseNews();
				houseNews.setNewsNo(nowsNo);
				houseNews.setNewsKinds(newsKinds);
				houseNews.setNewsShowTime(updateTime);
				houseNews.setNewsContent(newsContent);
				HouseNewsDao houseNewsDao=new HouseNewsDaoImp();
				int n=houseNewsDao.add(houseNews);
				if(n==0) {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(WriteNewsWindow.this);
					failInformationDialog.setModal(true);
					failInformationDialog.setVisible(true);
					
				}
				newsKindText.setText("");
				newsContentText.setText("");
				
			}
		});
		insertBu.setBounds(192, 10, 100, 30);
		panel.add(insertBu);
		
		newsNoText = new JTextField();
		newsNoText.setBounds(411, 11, 75, 30);
		panel.add(newsNoText);
		newsNoText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u65B0\u95FB\u53F7\uFF1A");
		lblNewLabel_3.setBounds(345, 10, 68, 30);
		panel.add(lblNewLabel_3);
		
		JButton deleteBu = new JButton("\u5220\u9664\u65B0\u95FB");
		deleteBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HouseNewsDao houseNewsDao=new HouseNewsDaoImp();
				String newsNo=newsNoText.getText().toString();
				int n=houseNewsDao.deleteByNewsNo(newsNo);
				if(n==0) {
					FailInformationDialog failInformationDialog=new FailInformationDialog();
					failInformationDialog.setLocationRelativeTo(WriteNewsWindow.this);
					failInformationDialog.setModal(true);
					failInformationDialog.setVisible(true);
					newsNoText.setText("");
				}else {
					newsNoText.setText("");
				}
				
			}
		});
		deleteBu.setBounds(496, 10, 93, 30);
		panel.add(deleteBu);
		
		JButton returnBu = new JButton("\u8FD4\u56DE\u7CFB\u7EDF");
		returnBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WriteNewsWindow.this.dispose();
				houseSystemWindows.setVisible(true);
			}
		});
		returnBu.setBounds(602, 10, 118, 27);
		panel.add(returnBu);
		
		JButton showNewsBu = new JButton("\u663E\u793A\u6240\u6709\u65B0\u95FB");
		showNewsBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allRows.removeAllElements();
				HouseNewsDao houseNewsDao=new HouseNewsDaoImp();
				List<HouseNews> houseNewslist=houseNewsDao.query();
				if(houseNewslist.size()>0) {
					for(int i=0;i<houseNewslist.size();i++) {
						HouseNews houseNews=new HouseNews();
						houseNews=houseNewslist.get(i);
						Vector<String> row=new Vector<>();
						row.addElement(houseNews.getNewsNo());
						row.addElement(houseNews.getNewsShowTime());
						row.addElement(houseNews.getNewsKinds());
						row.addElement(houseNews.getNewsContent());
						allRows.addElement(row);
					}
				}
				showNewsTable.updateUI();
			}
		});
		showNewsBu.setBounds(95, 44, 118, 30);
		panel.add(showNewsBu);
	}
}
