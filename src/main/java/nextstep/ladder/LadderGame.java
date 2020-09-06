package nextstep.ladder;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.view.LadderOutputView;

public class LadderGame {

	private final List<User> users;
	private final List<String> prizes;
	private final int ladderHeight;
	private Ladder ladder;

	public LadderGame(List<User> users, List<String> prizes, int ladderHeight) {
		this.users = users;
		this.prizes = prizes;
		this.ladderHeight = ladderHeight;
	}

	public void execute() {
		this.makeLadder();
		this.printLadder();
		this.setUsersPrize();
	}

	private void setUsersPrize() {
		int userSize = users.size();
		IntStream.range(0, userSize).forEach(i -> {
			int prizeIndex = ladder.getPrizeIndex(i);
			String prize = prizes.get(prizeIndex);
			users.get(i).setPrize(prize);
		});
	}

	private void makeLadder() {
		this.ladder = Ladder.make(users.size(), ladderHeight);
	}

	private void printLadder() {
		LadderOutputView outputView = LadderOutputView.getInstance();
		System.out.println("\n사다리 결과\n");
		outputView.printUsers(users);
		outputView.printLadderResult(ladder);
		outputView.printGamePrizeInfo(prizes);
	}

	public void printResult(String resultCommand) {
		LadderOutputView.getInstance().printGameResult(users, resultCommand);
	}
}
