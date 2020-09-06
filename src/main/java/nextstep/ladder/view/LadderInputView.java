package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.User;

public class LadderInputView {

	private static LadderInputView ladderOutputView;

	private Scanner scanner = new Scanner(System.in);

	private LadderInputView() {
	}

	public static synchronized LadderInputView getInstance() {
		if (ladderOutputView == null) {
			ladderOutputView = new LadderInputView();
		}
		return ladderOutputView;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public List<User> inputUsers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		String line = scanner.nextLine();
		return Arrays.stream(line.split(","))
				.map(String::trim)
				.map(User::new)
				.collect(Collectors.toList());
	}

	public List<String> inputPrizes(int userSize) {
		System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		String line = scanner.nextLine();
		List<String> results = Arrays.asList(line.split(","));
		if (results.size() != userSize) {
			throw new IllegalArgumentException();
		}
		return results;
	}

	public int inputLadderHeight() {
		System.out.println("\n최대 사다리 높이는 몇 개인가요?");
		return Integer.parseInt(scanner.nextLine());
	}

	public String inputUserNameToCheckResult() {
		System.out.println("\n결과를 보고 싶은 사람은?");
		return scanner.nextLine();
	}
}
