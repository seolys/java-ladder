package nextstep.ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Scanner;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderOutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

	private LadderInputView inputView = LadderInputView.getInstance();
	private LadderOutputView outputView = LadderOutputView.getInstance();

	@Test
	@DisplayName("참여할 사람을 입력한다.")
	public void inputUsersTest() {
		setScannerInputText("pobi,honux,crong,jk");
		List<User> users = inputView.inputUsers();
		assertEquals(4, users.size());
		outputView.printUsers(users);
	}

	@Test
	@DisplayName("결과를 입력한다.")
	public void inputResultsTest() {
		setScannerInputText("꽝,5000,꽝,3000");
		List<String> results = inputView.inputPrizes(4);
		assertEquals(4, results.size());
		outputView.printGamePrizeInfo(results);
	}

	@Test
	@DisplayName("사다리 높이를 입력한다.")
	public void inputHeightTest() {
		setScannerInputText("5");
		int height = inputView.inputLadderHeight();
		assertEquals(5, height);
	}

	@Test
	@DisplayName("사다리를 출력한다.")
	public void printLadderTest() {
		int userSize = 4;
		int ladderHeight = 5;

		for (int i = 0; i < 5; i++) {
			Ladder ladder = Ladder.make(userSize, ladderHeight);
			outputView.printLadderResult(ladder);
			System.out.println();
		}
	}

	@Test
	@DisplayName("통합테스트")
	void integrationTest() {
		LadderInputView inputView = LadderInputView.getInstance();
		// 참여할 사람 입력
		String inputUsers = "pobi,honux,crong,jk";
		setScannerInputText(inputUsers);
		List<User> users = inputView.inputUsers();
		System.out.println(inputUsers);
		int userSize = users.size();

		// 실행 결과 입력
		String inputPrizes = "꽝,5000,꽝,3000";
		setScannerInputText(inputPrizes);
		List<String> prizes = inputView.inputPrizes(userSize);
		System.out.println(inputPrizes);

		// 사다리 높이 입력
		String inputLadderHeight = "5";
		setScannerInputText(inputLadderHeight);
		int ladderHeight = inputView.inputLadderHeight();
		System.out.println(inputLadderHeight);

		// 게임 실행
		LadderGame ladderGame = new LadderGame(users, prizes, ladderHeight);
		ladderGame.execute();

		// 결과입력1
		String checkCommand1 = "pobi";
		setScannerInputText(checkCommand1);
		String resultCommand1 = inputView.inputUserNameToCheckResult();
		System.out.println(checkCommand1);
		ladderGame.printResult(resultCommand1);

		// 결과입력2
		String checkCommand2 = "all";
		setScannerInputText(checkCommand2);
		String resultCommand2 = inputView.inputUserNameToCheckResult();
		System.out.println(resultCommand2);
		ladderGame.printResult(resultCommand2);
	}

	private void setScannerInputText(String usersInputText) {
		inputView.setScanner(new Scanner(usersInputText + "\n"));
	}

}
