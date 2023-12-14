package baseball;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegWindow extends JFrame {
	public RegWindow() {
		UserList ul = new UserList();
		
		JPanel idPanel, pwPanel, pwwPanel, btnPanel;
		JLabel idLb, pwLb, pwwLb;
		JTextField idTf;
		JPasswordField pwPf, pwwPf;
		JButton addBtn, cancelBtn;
		
		idPanel = new JPanel();
		pwPanel = new JPanel();
		pwwPanel = new JPanel();
		btnPanel = new JPanel();
		
		idLb = new JLabel("아이디");
		pwLb = new JLabel("암  호");
		pwwLb = new JLabel("암호확인");
		
		idTf = new JTextField(20);
		pwPf = new JPasswordField(20);
		pwwPf = new JPasswordField(20);
		
		addBtn = new JButton("등록");
		addBtn.addActionListener(e -> {
			String id = idTf.getText();
			String pw = new String(pwPf.getPassword());
			if(ul.isVaildID(id)) 
				JOptionPane.showMessageDialog(null, "이미 등록된 아이디", "회원등록", JOptionPane.WARNING_MESSAGE);
			else {
				if(!pw.equals(new String(pwwPf.getPassword())))
					JOptionPane.showMessageDialog(null, "암호 불일치", "회원등록", JOptionPane.WARNING_MESSAGE);
				else {
					ul.addUser(id, pw, null, 0);
					ul.saveList();
					JOptionPane.showMessageDialog(null, "회원 등록 완료", "회원등록", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(e -> {
			dispose();
		});
		
		idPanel.add(idLb);
		idPanel.add(idTf);
		
		pwPanel.add(pwLb);
		pwPanel.add(pwPf);
		
		pwwPanel.add(pwwLb);
		pwwPanel.add(pwwPf);
		
		btnPanel.add(addBtn);
		btnPanel.add(cancelBtn);
		
		add(idPanel);
		add(pwPanel);
		add(pwwPanel);
		add(btnPanel);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원 등록");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
