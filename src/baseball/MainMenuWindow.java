package baseball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainMenuWindow extends JFrame {
	JButton startBtn, rankBtn, playerBtn, logoutBtn, exitBtn;
	JLabel titleLb;
	
	public MainMenuWindow(String id) {
		if(id.equals(UserList.Master))
			setTitle("������ ����");
		else
			setTitle("�Ϲ� ����");
		setLayout(new FlowLayout());
		setSize(400, 270);
		
		titleLb = new JLabel();
		titleLb.setText("���� �߱� ����");
		titleLb.setFont(new Font(null, Font.BOLD, 24));
		
		startBtn = new JButton();
		startBtn.setText("���� ����");
		startBtn.setPreferredSize(new Dimension(300, 30));
		startBtn.addActionListener(e -> {
			new BaseBallWindow(id);
			dispose();
		});
		
		rankBtn = new JButton();
		rankBtn.setText("�ְ� ���");
		rankBtn.setPreferredSize(new Dimension(300, 30));
		rankBtn.addActionListener(e -> {
			new RankWindow(id);
			dispose();
		});
		
		playerBtn = new JButton();
		playerBtn.setText("������ ���� ���");
		playerBtn.setPreferredSize(new Dimension(300, 30));
		playerBtn.addActionListener(e -> {
			if(id.equals(UserList.Master)) {
				new MasterWindow();
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "�ش� ����� �����ڸ� ��� �����մϴ�!", "���� ����", JOptionPane.WARNING_MESSAGE);
		});
		
		logoutBtn = new JButton();
		logoutBtn.setText("�α׾ƿ�");
		logoutBtn.setPreferredSize(new Dimension(300, 30));
		logoutBtn.addActionListener(e -> {
			new LoginWindow();
			dispose();
		});
		
		exitBtn = new JButton();
		exitBtn.setText("����");
		exitBtn.setPreferredSize(new Dimension(300, 30));
		exitBtn.addActionListener(e -> {
			dispose();
		});
		
		add(titleLb);
		add(startBtn);
		add(rankBtn);
		add(playerBtn);
		add(logoutBtn);
		add(exitBtn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
