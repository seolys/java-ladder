package nextstep.ladder;

import java.util.List;
import nextstep.ladder.view.LadderInputView;

public class Application {

	public static void main(String[] args) {
		LadderInputView inputView = LadderInputView.getInstance();
		// 참여할 사람 입력.
		List<User> users = inputView.inputUsers(); // pobi,honux,crong,jk
		// 당첨 항목(실행 결과) 입력.
		List<String> prizes = inputView.inputPrizes(users.size()); // 꽝,5000,꽝,3000
		// 사다리 높이 입력.
		int ladderHeight = inputView.inputLadderHeight(); // 5

		// 게임 실행
		LadderGame ladderGame = new LadderGame(users, prizes, ladderHeight);
		ladderGame.execute();

		// 결과 확인
		String resultCommand = null;
		do {
			resultCommand = inputView.inputUserNameToCheckResult();
			ladderGame.printResult(resultCommand);
		} while (isContinue(resultCommand));
	}

	private static boolean isContinue(String resultCommand) {
		return !"all".equals(resultCommand);
	}
}
