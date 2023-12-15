package baseball;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlayerWindow extends JFrame {
	JPanel playerPanel;
	JLabel titleLb, playerLb, countLb, left, right;
	JButton exitBtn;
	
	public PlayerWindow() {
		setLayout(new BorderLayout());
		setSize(300, 400);
		
		titleLb = new JLabel();
		titleLb.setText("최다 사용자 조회");
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(UserList.list.size() + 1, 2));
		
		playerLb = new JLabel("사용자명");
		playerLb.setHorizontalAlignment(JLabel.CENTER);
		
		countLb = new JLabel("사용 횟수");
		countLb.setHorizontalAlignment(JLabel.CENTER);
		
		playerPanel.add(playerLb);
		playerPanel.add(countLb);
		
		for(int i = 0; i < UserList.list.size(); i++) {
			left = new JLabel(UserList.list.get(i).id);
			right = new JLabel("" + UserList.list.get(i).playerCount);
					
			left.setHorizontalAlignment(JLabel.CENTER);
			right.setHorizontalAlignment(JLabel.CENTER);
					
			playerPanel.add(left);
			playerPanel.add(right);
		}
		
		exitBtn = new JButton();
		exitBtn.setText("나가기");
		exitBtn.addActionListener(e -> {
			new MasterWindow();
			dispose();
		});
		
		add(titleLb, BorderLayout.NORTH);
		add(new JScrollPane(playerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		add(exitBtn, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
