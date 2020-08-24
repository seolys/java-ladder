package nextstep.ladder;

import java.util.List;

public class LadderGame {

	public static void main(String[] args) {
		LadderInputView inputView = new LadderInputView();
		LadderOutputView outputView = new LadderOutputView();

		List<User> users = inputView.inputUsers();
		int height = inputView.inputHeight();
		Ladder ladder = new Ladder(users.size(), height);

		outputView.printUserAndLadder(users, ladder);
	}
}
