package nextstep.ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

	LadderOutputView outputView = new LadderOutputView();

	@Test
	@DisplayName("참여할 사람을 입력한다.")
	public void inputUserTest() {
		String usersInputText = "pobi,honux,crong,jk";
		Scanner scanner = new Scanner(usersInputText + "\n");
		List<User> users = new LadderInputView(scanner).inputUsers();
		assertEquals(4, users.size());
		outputView.printUsers(users);
	}

	@Test
	@DisplayName("사다리 높이를 입력한다.")
	public void inputHeightTest() {
		String heightInputText = "5";
		Scanner scanner = new Scanner(heightInputText + "\n");
		int height = new LadderInputView(scanner).inputHeight();
		assertEquals(5, height);
	}

	@Test
	@DisplayName("사다리를 출력한다.")
	public void printLadderTest() {
		int userSize = 4;
		int ladderHeight = 5;

		for(int i = 0; i < 5; i++) {
			Ladder ladder = new Ladder(userSize, ladderHeight);
			outputView.printLadder(ladder);
			System.out.println();
		}
	}

}
