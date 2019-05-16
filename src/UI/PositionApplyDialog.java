package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PositionApplyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PositionApplyDialog dialog = new PositionApplyDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PositionApplyDialog() {
		setBounds(100, 100, 450, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u804C\u4F4D\u5E94\u8058");
			lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(113, 20, 191, 34);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
			lblNewLabel_1.setBounds(133, 64, 66, 23);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			textField.setBounds(218, 64, 86, 23);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
			lblNewLabel_2.setBounds(133, 106, 66, 23);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(218, 107, 86, 22);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\u5E94\u8058\u804C\u4F4D\uFF1A");
			lblNewLabel_3.setBounds(133, 143, 71, 23);
			contentPanel.add(lblNewLabel_3);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(218, 144, 86, 25);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
			lblNewLabel_4.setBounds(135, 193, 64, 23);
			contentPanel.add(lblNewLabel_4);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(218, 194, 86, 21);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\u5DE5\u4F5C\u7ECF\u9A8C\uFF1A");
			lblNewLabel_5.setBounds(47, 239, 66, 15);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(47, 264, 267, 97);
			contentPanel.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u53D1\u9001");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						WarningDialog warningDialog=new WarningDialog("发送成功！");
						warningDialog.setLocationRelativeTo(PositionApplyDialog.this);
						warningDialog.setModal(true);
						warningDialog.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PositionApplyDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
