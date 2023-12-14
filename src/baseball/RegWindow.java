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
		
		idLb = new JLabel("���̵�");
		pwLb = new JLabel("��  ȣ");
		pwwLb = new JLabel("��ȣȮ��");
		
		idTf = new JTextField(20);
		pwPf = new JPasswordField(20);
		pwwPf = new JPasswordField(20);
		
		addBtn = new JButton("���");
		addBtn.addActionListener(e -> {
			String id = idTf.getText();
			String pw = new String(pwPf.getPassword());
			if(ul.isVaildID(id)) 
				JOptionPane.showMessageDialog(null, "�̹� ��ϵ� ���̵�", "ȸ�����", JOptionPane.WARNING_MESSAGE);
			else {
				if(!pw.equals(new String(pwwPf.getPassword())))
					JOptionPane.showMessageDialog(null, "��ȣ ����ġ", "ȸ�����", JOptionPane.WARNING_MESSAGE);
				else {
					ul.addUser(id, pw, null, 0);
					ul.saveList();
					JOptionPane.showMessageDialog(null, "ȸ�� ��� �Ϸ�", "ȸ�����", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		cancelBtn = new JButton("���");
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
		setTitle("ȸ�� ���");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
