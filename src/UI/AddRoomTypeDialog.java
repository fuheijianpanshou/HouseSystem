package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.RoomType;
import ObjectClass.RoomTypeDao;
import ObjectClass.RoomTypeDaoImp;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomTypeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField typeNoText;
	private JTextField typeNameText;
	private JTextField roomAreaText;
	private JTextField roomPriceText;
	private JTextField roomPeopleText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddRoomTypeDialog dialog = new AddRoomTypeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddRoomTypeDialog() {
		setTitle("\u6DFB\u52A0\u623F\u95F4\u7C7B\u578B");
		setBounds(100, 100, 502, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("\u623F\u4EF7\u7C7B\u578B\u53F7\uFF1A");
		lblNewLabel.setBounds(15, 15, 95, 23);
		typeNoText = new JTextField();
		typeNoText.setBounds(138, 16, 66, 21);
		typeNoText.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("\u7C7B\u578B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setBounds(264, 16, 81, 21);
		typeNameText = new JTextField();
		typeNameText.setBounds(355, 16, 66, 22);
		typeNameText.setColumns(10);
		JLabel label = new JLabel("\u623F\u95F4\u5927\u5C0F\u33A1\uFF1A");
		label.setBounds(15, 64, 113, 26);
		roomAreaText = new JTextField();
		roomAreaText.setBounds(138, 66, 66, 23);
		roomAreaText.setColumns(10);
		JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C\u5143\uFF1A");
		label_1.setBounds(264, 67, 81, 20);
		roomPriceText = new JTextField();
		roomPriceText.setBounds(355, 66, 66, 23);
		roomPriceText.setColumns(10);
		JLabel label_2 = new JLabel("\u623F\u95F4\u4EBA\u6570\uFF1A");
		label_2.setBounds(15, 108, 95, 24);
		roomPeopleText = new JTextField();
		roomPeopleText.setBounds(138, 110, 66, 21);
		roomPeopleText.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(label);
		contentPanel.add(lblNewLabel);
		contentPanel.add(label_2);
		contentPanel.add(roomPeopleText);
		contentPanel.add(typeNoText);
		contentPanel.add(roomAreaText);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(typeNameText);
		contentPanel.add(label_1);
		contentPanel.add(roomPriceText);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton add = new JButton("\u6DFB\u52A0\u7C7B\u578B");
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String typeNo=typeNoText.getText().toString();
						String typeName=typeNameText.getText().toString();
						int typeArea=Integer.valueOf(roomAreaText.getText());
						int typePrice=Integer.valueOf(roomPriceText.getText());
						int peopleNu=Integer.valueOf(roomPeopleText.getText());
						RoomType roomType=new RoomType();
						roomType.setTypeNo(typeNo);
						roomType.setTypeName(typeName);
						roomType.setTypeArea(typeArea);
						roomType.setTypePrice(typePrice);
						roomType.setPeopleNu(peopleNu);
						RoomTypeDao roomTypeDao=new RoomTypeDaoImp();
						roomTypeDao.add(roomType);
						AddRoomTypeDialog.this.dispose();
					}
				});
				add.setActionCommand("OK");
				buttonPane.add(add);
				getRootPane().setDefaultButton(add);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88\u6DFB\u52A0");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AddRoomTypeDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
