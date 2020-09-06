package nextstep.ladder;

public class User {

	private String name;
	private String prize;

	public User(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름은 5자까지 가능합니다.");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return name + " : " + prize;
	}
}
