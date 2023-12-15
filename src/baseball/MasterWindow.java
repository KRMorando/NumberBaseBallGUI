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
		setTitle("관리자 계정");
		setLayout(new FlowLayout());
		setSize(400, 250);
		
		titleLb = new JLabel();
		titleLb.setText("관리자 전용 기능");
		titleLb.setForeground(Color.red);
		titleLb.setFont(new Font(null, Font.BOLD, 24));
		
		makeUserBtn = new JButton();
		makeUserBtn.setText("임의 유저들 생성");
		makeUserBtn.setPreferredSize(new Dimension(300, 30));
		makeUserBtn.addActionListener(e -> {
			ul.createUsers();
		});
		
		playerBtn = new JButton();
		playerBtn.setText("최다 사용자 조회");
		playerBtn.setPreferredSize(new Dimension(300, 30));
		playerBtn.addActionListener(e -> {
			new PlayerWindow();
			dispose();
		});
		
		exitBtn = new JButton();
		exitBtn.setText("뒤로가기");
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
