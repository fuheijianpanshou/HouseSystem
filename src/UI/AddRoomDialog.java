package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ObjectClass.Room;
import ObjectClass.RoomDao;
import ObjectClass.RoomDaoImp;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField roomNoText;
	private JTextField roomTypeText;
	private JTextField roomFloorText;
	private JTextField roomDescriptionText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddRoomDialog dialog = new AddRoomDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddRoomDialog() {
		setTitle("\u6DFB\u52A0\u623F\u95F4");
		setBounds(100, 100, 450, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel label = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		roomNoText = new JTextField();
		roomNoText.setColumns(10);
		JLabel label_1 = new JLabel("\u623F\u95F4\u7C7B\u578B\u53F7\uFF1A");
		roomTypeText = new JTextField();
		roomTypeText.setColumns(10);
		JLabel lblNewLabel = new JLabel("\u697C\u5C42\uFF1A");
		roomFloorText = new JTextField();
		roomFloorText.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u63CF\u8FF0\uFF1A");
		roomDescriptionText = new JTextField();
		roomDescriptionText.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(roomNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(roomFloorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(58)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(roomTypeText, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(roomDescriptionText, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(roomNoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(roomTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(roomFloorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(roomDescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addRoomBu = new JButton("\u6DFB\u52A0\u623F\u95F4");
				addRoomBu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String roomNo=roomNoText.getText().toString();
						String typeNo=roomTypeText.getText().toString();
						int roomFloor=Integer.valueOf(roomFloorText.getText());
						String roomDescription=roomDescriptionText.getText().toString();
						if(roomNo!=null&&typeNo!=null&&roomFloor>0&&roomDescription!=null) {
							Room room=new Room();
							room.setRoomNo(roomNo);
							room.setTypeNo(typeNo);
							room.setRoomFloor(roomFloor);
							room.setDescription(roomDescription);
							RoomDao roomDao=new RoomDaoImp();
							roomDao.add(room);
							AddRoomDialog.this.dispose();
						}else {
							System.out.println("所有都不能为空！");
						}
					}
				});
				addRoomBu.setActionCommand("OK");
				buttonPane.add(addRoomBu);
				getRootPane().setDefaultButton(addRoomBu);
			}
			{
				JButton cancelBu = new JButton("\u53D6\u6D88\u6DFB\u52A0");
				cancelBu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AddRoomDialog.this.dispose();
					}
				});
				cancelBu.setActionCommand("Cancel");
				buttonPane.add(cancelBu);
			}
		}
	}

}
