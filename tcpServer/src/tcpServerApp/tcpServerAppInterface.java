package tcpServerApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class tcpServerAppInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtThisServerIs;
	private JTextField txtTheServerRunning;
	private JTable table;
	private JPasswordField passwordField;
	private JTextField txtNursyafiqah;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tcpServerAppInterface frame = new tcpServerAppInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tcpServerAppInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MCD SERVER STATUS ");
		lblNewLabel.setBounds(5, 5, 976, 85);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 60));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 90, 0, 668);
		panel.setToolTipText("");
		panel.setBorder(new CompoundBorder());
		panel.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtThisServerIs = new JTextField();
		txtThisServerIs.setBackground(UIManager.getColor("Button.background"));
		txtThisServerIs.setForeground(UIManager.getColor("CheckBox.foreground"));
		txtThisServerIs.setText("THIS SERVER IS ON RUNNING..... ");
		txtThisServerIs.setBounds(15, 90, 296, 19);
		contentPane.add(txtThisServerIs);
		txtThisServerIs.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SERVER STATUS : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(15, 137, 350, 46);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.highlight"));
		panel_1.setBounds(5, 193, 969, 136);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtTheServerRunning = new JTextField();
		txtTheServerRunning.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtTheServerRunning.setBounds(24, 10, 413, 28);
		txtTheServerRunning.setText("PLEASE ENTER THE DETAILS: ");
		panel_1.add(txtTheServerRunning);
		txtTheServerRunning.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 63, 154, 16);
		panel_1.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		comboBox_1.setBounds(680, 62, 106, 21);
		panel_1.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-PLEASE SELECT-", "1123", "6507", "1254"}));
		
		JLabel lblNewLabel_3 = new JLabel("PORT NO : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(611, 57, 154, 28);
		panel_1.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 107, 140, 19);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(17, 107, 82, 16);
		panel_1.add(lblNewLabel_4);
		
		txtNursyafiqah = new JTextField();
		txtNursyafiqah.setBounds(97, 63, 152, 19);
		panel_1.add(txtNursyafiqah);
		txtNursyafiqah.setColumns(10);
		
		JButton btnNewButton = new JButton("REQUEST ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(430, 338, 116, 32);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(310, 467, 1, 1);
		contentPane.add(table);
		
		JTextArea txtrServerIsOn = new JTextArea();
		txtrServerIsOn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrServerIsOn.setText("SERVER IS ON RUNNING \r\n\r\nCONNECTED !");
		txtrServerIsOn.setBounds(323, 396, 268, 99);
		contentPane.add(txtrServerIsOn);
	}
	}
}
