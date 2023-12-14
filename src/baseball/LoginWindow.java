package baseball;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {
	UserList ul = new UserList();
	public LoginWindow() {
		JPanel idPanel, pwPanel, btnPanel;
		JLabel idLb, pwLb;
		JButton loginBtn, regBtn, cancelBtn;
		JTextField idTf;
		JPasswordField pwPf;
		
		setLayout(new BorderLayout());
		
		idPanel = new JPanel();
		pwPanel = new JPanel();
		btnPanel = new JPanel();
		
		idLb = new JLabel("로그인");
		pwLb = new JLabel("암  호");
		
		idTf = new JTextField(20);
		pwPf = new JPasswordField(20);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(e -> {
			String id = idTf.getText();
			String pw = new String(pwPf.getPassword());
			if(ul.isVaildID(id)) {
				if(ul.isVaildPW(id, pw)) {
					JOptionPane.showMessageDialog(null, "로그인 완료", "로그인", JOptionPane.INFORMATION_MESSAGE);
					new MainMenuWindow(id);
					dispose();
				} else
					JOptionPane.showMessageDialog(null, "부정확한 암호", "로그인", JOptionPane.WARNING_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "미등록 아이디", "로그인", JOptionPane.WARNING_MESSAGE);
		});
		
		regBtn = new JButton("회원가입");
		regBtn.addActionListener(e -> {
			new RegWindow();
		});
		
		cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(e -> {
			dispose();
		});
		
		idPanel.add(idLb);
		idPanel.add(idTf);
		
		pwPanel.add(pwLb);
		pwPanel.add(pwPf);
		
		btnPanel.add(loginBtn);
		btnPanel.add(regBtn);
		btnPanel.add(cancelBtn);

		add(idPanel, BorderLayout.NORTH);
		add(pwPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
