package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {

	private Scanner scanner;

	public LadderInputView() {
		this.scanner = new Scanner(System.in);
	}

	public LadderInputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public List<User> inputUsers() {
		System.out.println("참가자 이름을 입력하세요.");
		String line = scanner.nextLine();
		return Arrays.stream(line.split(","))
				.map(User::new)
				.collect(Collectors.toList());
	}

	public int inputHeight() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return Integer.parseInt(scanner.nextLine());
	}

}
