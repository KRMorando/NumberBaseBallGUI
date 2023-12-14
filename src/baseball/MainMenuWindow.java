package baseball;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenuWindow extends JFrame {
	JButton startBtn, rankBtn, exitBtn;
	JLabel titleLb;
	
	public MainMenuWindow(String id) {
		setLayout(new FlowLayout());
		setSize(400, 200);
		
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
		
		exitBtn = new JButton();
		exitBtn.setText("����");
		exitBtn.setPreferredSize(new Dimension(300, 30));
		exitBtn.addActionListener(e -> {
			dispose();
		});
		
		add(titleLb);
		add(startBtn);
		add(rankBtn);
		add(exitBtn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
