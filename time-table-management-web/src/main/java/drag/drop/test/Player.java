package drag.drop.test;

public class Player {

	private String name;
	private int number;
	private String photo;
	private String position;
	
	public Player(String name, int position, String maillot, String function) {
		this.name = name;
		this.number = position;
		this.photo = maillot;
		this.position = function;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int position) {
		this.number = position;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String maillot) {
		this.photo = maillot;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String function) {
		this.position = function;
	}

	
}
