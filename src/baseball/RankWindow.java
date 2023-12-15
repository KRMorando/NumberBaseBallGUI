package baseball;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RankWindow extends JFrame {
	UserList ul = new UserList();
	String id;
	
	JPanel rankPanel;
	JLabel titleLb, rankLb, countLb, left, right;
	JButton exitBtn;
	
	public RankWindow(String id) {
		if(id.equals(UserList.Master))
			setTitle("관리자 계정");
		else
			setTitle("일반 계정");
		this.id = id;
		
		setLayout(new BorderLayout());
		setSize(300, 400);
		
		titleLb = new JLabel();
		titleLb.setText(id + "님의 최고 기록");
		titleLb.setHorizontalAlignment(JLabel.CENTER);
		
		rankPanel = new JPanel();
		rankPanel.setLayout(new GridLayout(11, 2));
		
		rankLb = new JLabel("순위");
		rankLb.setHorizontalAlignment(JLabel.CENTER);
		
		countLb = new JLabel("시도 횟수");
		countLb.setHorizontalAlignment(JLabel.CENTER);
		
		rankPanel.add(rankLb);
		rankPanel.add(countLb);
		
		for(int i = 0; i < ul.list.size(); i++) {
			if(ul.list.get(i).id.equals(id)) {
				User user = ul.list.get(i);
				for(int j = 0; j < 10; j++) {
					left = new JLabel("" + (j + 1));
					if(j < user.rank.size())
						right = new JLabel("" + user.rank.get(j));
					else
						right = new JLabel("");
					
					left.setHorizontalAlignment(JLabel.CENTER);
					right.setHorizontalAlignment(JLabel.CENTER);
					
					rankPanel.add(left);
					rankPanel.add(right);
				}
			}
		}
		
		exitBtn = new JButton();
		exitBtn.setText("나가기");
		exitBtn.addActionListener(e -> {
			new MainMenuWindow(id);
			dispose();
		});
		
		add(titleLb, BorderLayout.NORTH);
		add(new JScrollPane(rankPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		add(exitBtn, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
