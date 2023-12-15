package baseball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MasterWindow extends JFrame {
	UserList ul = new UserList();
	JButton makeUserBtn, playerBtn, exitBtn;
	JLabel titleLb;
	
	public MasterWindow() {
		setTitle("������ ����");
		setLayout(new FlowLayout());
		setSize(400, 250);
		
		titleLb = new JLabel();
		titleLb.setText("������ ���� ���");
		titleLb.setForeground(Color.red);
		titleLb.setFont(new Font(null, Font.BOLD, 24));
		
		makeUserBtn = new JButton();
		makeUserBtn.setText("���� ������ ����");
		makeUserBtn.setPreferredSize(new Dimension(300, 30));
		makeUserBtn.addActionListener(e -> {
			ul.createUsers();
		});
		
		playerBtn = new JButton();
		playerBtn.setText("�ִ� ����� ��ȸ");
		playerBtn.setPreferredSize(new Dimension(300, 30));
		playerBtn.addActionListener(e -> {
			new PlayerWindow();
			dispose();
		});
		
		exitBtn = new JButton();
		exitBtn.setText("�ڷΰ���");
		exitBtn.setPreferredSize(new Dimension(300, 30));
		exitBtn.addActionListener(e -> {
			new MainMenuWindow(UserList.Master);
			dispose();
		});
		
		add(titleLb);
		add(makeUserBtn);
		add(playerBtn);
		add(exitBtn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
