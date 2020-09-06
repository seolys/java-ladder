package nextstep.ladder.view;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.User;

public class LadderOutputView {

	public static LadderOutputView ladderOutputView = null;

	private LadderOutputView() {
	}

	public static synchronized LadderOutputView getInstance() {
		if (ladderOutputView == null) {
			ladderOutputView = new LadderOutputView();
		}
		return ladderOutputView;
	}

	public void printUsers(List<User> users) {
		String usersText = users.stream()
				.map(User::getName)
				.map(rightPad(5))
				.collect(Collectors.joining(" "));
		System.out.println(usersText);
	}

	public void printLadderResult(Ladder ladder) {
		ladder.getLadder()
				.stream()
				.map(Line::toString)
				.forEach(System.out::println);
	}

	public void printGamePrizeInfo(List<String> results) {
		String resultsText = results.stream()
				.map(rightPad(5))
				.collect(Collectors.joining(" "));
		System.out.println(resultsText);
	}

	public void printGameResult(List<User> users, String command) {
		System.out.println("\n실행결과");
		if ("all".equals(command)) {
			printAllUserGameResult(users);
			return;
		}
		printUserGameResult(users, command);
	}

	private void printAllUserGameResult(List<User> users) {
		users.stream()
				.map(User::toString)
				.forEach(System.out::println);
	}

	private void printUserGameResult(List<User> users, String userName) {
		String result = users.stream()
				.filter(user -> user.getName().equals(userName))
				.map(User::getPrize)
				.findFirst()
				.orElse("다시 입력해주세요.");
		System.out.println(result);
	}

	private Function<String, String> rightPad(int n) {
		return str -> String.format("%-" + n + "s", str);
	}

}
