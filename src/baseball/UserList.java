package baseball;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserList {
	static ArrayList<User> list = new ArrayList<>();
	String str = new String();
	File dataFile = new File("data.txt");
	
	public void createList() {
		try {
			if(!dataFile.exists())
				dataFile.createNewFile();
			
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
			while((str = br.readLine()) != null) {
				String id = str;
				String pw = br.readLine();
				String rank = br.readLine();
				int playerCount = Integer.parseInt(br.readLine());
				addUser(id, pw, rank, playerCount);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveList() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile, false));
			String document = "";
			
			for(User u : list) {
				String str = "";
				for(int i = 0; i < u.rank.length; i++) {
					str += u.rank[i];
					if(i != u.rank.length - 1)
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
