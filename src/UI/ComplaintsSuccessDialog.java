package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplaintsSuccessDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	ComplaintsDialog complaintsDialog;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ComplaintsSuccessDialog dialog = new ComplaintsSuccessDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ComplaintsSuccessDialog(ComplaintsDialog complaintsDialog1) {
		complaintsDialog=complaintsDialog1;
		setTitle("\u6295\u8BC9\u53CD\u9988");
		setBounds(100, 100, 373, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u6211\u4EEC\u5DF2\u6536\u5230\u60A8\u7684\u6295\u8BC9\uFF0C\u4F1A\u5C3D\u5FEB\u4E0E\u60A8\u8054\u7CFB\uFF01");
			lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 14));
			lblNewLabel.setEnabled(false);
			lblNewLabel.setBounds(40, 49, 282, 60);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						complaintsDialog.dispose();
						ComplaintsSuccessDialog.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ComplaintsSuccessDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
