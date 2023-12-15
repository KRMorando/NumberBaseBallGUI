package baseball;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class UserList {
	static ArrayList<User> list = new ArrayList<>();
	static String Master = "Master";
	static String str = new String();
	File dataFile = new File("data.txt");
	
	public void createList() {
		list.clear();
		try {
			if(!dataFile.exists()) {
				dataFile.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile, false));
				// 마스터 계정 생성
				bw.write("Master\n123\n\n0");
				bw.flush();
				bw.close();
			}
			
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
			while((str = br.readLine()) != null) {
				String id = str;
				String pw = br.readLine();
				String rank = br.readLine();
				int playerCount = Integer.parseInt(br.readLine());
				list.add(new User(id, pw, rank, playerCount));
			}
			
			Collections.sort(list, new Comparator<User>() {
	            @Override
	            public int compare(User user1, User user2) {
	                // Compare in descending order based on count
	                return Integer.compare(user2.playerCount, user1.playerCount);
	            }
	        });
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createUsers() {
		String[] playerName = {"Sam", "Smith", "Smurf", "Mars", "Tony", "Bryan", "Will", "Ian", "Hindy"};
		String document = "Master\n123\n\n0\n";
		for(int i = 0; i < playerName.length; i++) {
			int random = (int) (Math.random() * 20) + 1;
			document += playerName[i] + "\n" + "123\n";
			for(int j = 0; j < random; j++) {
				document += ((int) (Math.random() * 20) + 1);
				if(j != (random - 1))
					document += ",";
			}
			document += "\n" + random + "\n";
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile, false));
			bw.write(document);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		createList();
		JOptionPane.showMessageDialog(null, "임의의 유저들이 파일에 생성 되었습니다.", "관리자", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void saveList() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile, false));
			String document = "";
			
			for(User u : list) {
				String str = "";
				for(int i = 0; i < u.rank.size(); i++) {
					str += u.rank.get(i);
					if(i != u.rank.size() - 1)
						str += ",";
				}
				document += u.id + "\n" + u.pw + "\n" + str + "\n" + u.playerCount + "\n";
			}
			
			bw.write(document);
			bw.flush();
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		for(User u : list)
			u.print();
		System.out.println("================");
	}
	
	public void addUser(String id, String pw, String rank, int playerCount) {
		list.add(new User(id, pw, rank, playerCount));
	}
	
	public boolean isVaildID(String id) {
		for(User u : list) 
			if(u.id.equals(id))
				return true;
		return false;
	}
	
	public boolean isVaildPW(String id, String pw) {
		for(User u : list) 
			if(isVaildID(id))
				if(u.pw.equals(pw))
					return true;
		return false;
	}
}
