package baseball;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallWindow extends JFrame {
	int GameCount = 0;
	int[] GameNumber = new int[4];
	String id = new String();
	
	JPanel mainPanel, leftPanel, rightPanel, keyPanel;
	JLabel nameLb, countLb;
	JTextField playerTf;
	JTextArea gameTa;
	JScrollPane scrollPane;
	JButton okBtn, exitBtn;
	JButton[] keyBtn;
	
	public BaseBallWindow(String id) {
		if(id.equals(UserList.Master))
			setTitle("관리자 계정");
		else
			setTitle("일반 계정");
		makeNumber();
		this.id = id;
		
		setLayout(new BorderLayout(0, 10));
		setSize(450, 270);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBounds(15, 15, 220, 170);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBounds(50 + 220, 15, 150, 170);
		
		keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(3, 3));
		
		nameLb = new JLabel("사용자: " + this.id);
		countLb = new JLabel("시도횟수: " + GameCount);
		
		playerTf = new JTextField(10);
		gameTa = new JTextArea();
		gameTa.setEditable(false);
		
		//scrollPane = new JScrollPane();
		
		keyBtn = new JButton[9];
		for(int i = 0; i < keyBtn.length; i++) {
			keyBtn[i] = new JButton("" + (i+1));
			keyPanel.add(keyBtn[i]);
			switch(i) {
			case 0:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 1);
				});
				break;
			case 1:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 2);
				});
				break;
			case 2:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 3);
				});
				break;
			case 3:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 4);
				});
				break;
			case 4:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 5);
				});
				break;
			case 5:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 6);
				});
				break;
			case 6:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 7);
				});
				break;
			case 7:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 8);
				});
				break;
			case 8:
				keyBtn[i].addActionListener(e -> {
					playerTf.setText(playerTf.getText() + 9);
				});
				break;
			}
		}
		
		okBtn = new JButton("OK");
		okBtn.addActionListener(e -> {
			if(playerTf.getText().length() != 4)
				JOptionPane.showMessageDialog(null, "입력 숫자 오류", "게임 정보", JOptionPane.WARNING_MESSAGE);
			else
				checkNumber();
		});
		
		exitBtn = new JButton("종료");
		exitBtn.addActionListener(e -> {
			new MainMenuWindow(id);
			dispose();
		});
		exitBtn.setBounds(0, 270, 500, 30);
		
		leftPanel.add(playerTf, BorderLayout.NORTH);
		leftPanel.add(keyPanel, BorderLayout.CENTER);
		leftPanel.add(okBtn, BorderLayout.SOUTH);
		
		rightPanel.add(nameLb, BorderLayout.NORTH);
		rightPanel.add(new JScrollPane(gameTa), BorderLayout.CENTER);
		rightPanel.add(countLb, BorderLayout.SOUTH);
		
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		
		add(mainPanel, BorderLayout.CENTER);
		add(exitBtn, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void makeNumber() {
		// 난수 4자리 생성
		for(int i = 0; i < GameNumber.length; i++) {
			boolean isVaild = false;
			int num;
			do {
				isVaild = false;
				num = (int)(Math.random() * 9) + 1;
				for(int j = 0; j < i; j++)
					if(num == GameNumber[j]) {
						isVaild = true;
						break;
					}
			} while(isVaild);
			GameNumber[i] = num;
		}
		System.out.print("생성된 답: ");
		for(int i : GameNumber)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public void checkNumber() {
		int strike = 0;
		int ball = 0;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int PlayerNumber = Integer.parseInt(playerTf.getText().split("")[j]);
				if(PlayerNumber == GameNumber[i]) {
					if(i == j)
						strike++;
					else
						ball++;
				}
			}
		}
		GameCount++;
		countLb.setText("시도횟수: " + GameCount);
		gameTa.append(playerTf.getText() + " " + strike + "S" + ball + "B\n");
		if(strike == 4) 
			gameEnd();
		else
			playerTf.setText("");
	}
	
	public void gameEnd() {
		UserList ul = new UserList();
		for(int i = 0; i < ul.list.size(); i++) {
			if(ul.list.get(i).id.equals(id)) {
				User user = ul.list.get(i);
				user.playerCount++;
				user.rank.add(GameCount);
				Collections.sort(user.rank);
				if(user.rank.size() > 10)
					user.rank.remove(10);
			}
		}
		JOptionPane.showMessageDialog(null, "시도횟수: " + GameCount + "\n축하합니다! 게임완료", "게임 완료", JOptionPane.INFORMATION_MESSAGE);
		ul.saveList();
		new MainMenuWindow(id);
		dispose();
	}
}
