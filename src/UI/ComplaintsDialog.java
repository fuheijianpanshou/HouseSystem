package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplaintsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ComplaintsDialog dialog = new ComplaintsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComplaintsDialog() {
		setTitle("\u6295\u8BC9");
		setBounds(100, 100, 450, 449);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u6295\u8BC9");
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.BOLD, 25));
		lblNewLabel.setBounds(148, 10, 142, 47);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		lblNewLabel_1.setBounds(130, 67, 63, 26);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(203, 67, 100, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u987E\u5BA2\u53F7\uFF1A");
		lblNewLabel_2.setBounds(130, 116, 63, 29);
		contentPanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 119, 100, 26);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblNewLabel_3.setBounds(130, 175, 75, 26);
		contentPanel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(203, 175, 100, 26);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6295\u8BC9\u5185\u5BB9\uFF1A");
		lblNewLabel_4.setBounds(57, 222, 82, 30);
		contentPanel.add(lblNewLabel_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(57, 251, 246, 88);
		contentPanel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u53D1\u9001");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ComplaintsSuccessDialog complaintsSuccessDialog=new ComplaintsSuccessDialog(ComplaintsDialog.this);
						complaintsSuccessDialog.setLocationRelativeTo(ComplaintsDialog.this);
						complaintsSuccessDialog.setModal(true);
						complaintsSuccessDialog.setVisible(true);
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
						ComplaintsDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
