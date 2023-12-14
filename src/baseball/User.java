package baseball;

public class User {
	String id;
	String pw;
	int[] rank = new int[10];
	int playerCount;
	
	public User(String id, String pw, String rank, int playerCount) {
		this.id = id;
		this.pw = pw;
		if(rank != null)
			for(int i = 0; i < rank.split(",").length; i++)
				this.rank[i] = Integer.parseInt(rank.split(",")[i]);
		this.playerCount = playerCount;
	}
	
	public void print() {
		System.out.println("================");
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		System.out.println("Rank: " + rank);
	}
}
