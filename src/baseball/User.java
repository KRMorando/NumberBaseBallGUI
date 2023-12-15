package baseball;

import java.util.ArrayList;

public class User {
	String id;
	String pw;
	String[] rawRank;
	ArrayList<Integer> rank = new ArrayList<>();
	int playerCount;
	
	public User(String id, String pw, String rank, int playerCount) {
		this.id = id;
		this.pw = pw;
		if(rank != "") {
			if(rank.split(",").length < 1)
				this.rank.add(Integer.parseInt(rank));
			else {
				rawRank = rank.split(",");
				for(int i = 0; i < rawRank.length; i++)
					try {
						this.rank.add(Integer.parseInt(rawRank[i]));
					} catch(NumberFormatException e) {
						//e.printStackTrace();
					}
			}
		}
				
		this.playerCount = playerCount;
	}
	
	public void print() {
		System.out.println("================");
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		System.out.println("Rank: " + rank);
	}
}