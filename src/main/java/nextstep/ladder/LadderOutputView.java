package nextstep.ladder;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderOutputView {

	public void printUserAndLadder(List<User> users, Ladder ladder) {
		printUsers(users);
		printLadder(ladder);
	}

	public void printUsers(List<User> users) {
		String usersText = users.stream()
				.map(User::getName)
				.map(rpad(5))
				.collect(Collectors.joining(" "));
		System.out.println(usersText);
	}

	public Function<String, String> rpad(int n) {
		return user -> String.format("%-" + n + "s", user);
	}

	public void printLadder(Ladder ladder) {
		ladder.getLadder().forEach(line -> line.print());
	}


}
