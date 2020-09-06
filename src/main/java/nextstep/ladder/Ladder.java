package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

	private List<Line> ladder;

	private Ladder(List<Line> ladder) {
		this.ladder = ladder;
	}

	public static Ladder make(int userSize, int ladderHeight) {
		List<Line> ladder = IntStream.range(0, ladderHeight)
				.mapToObj(i -> new Line(userSize))
				.collect(Collectors.toList());
		return new Ladder(ladder);
	}

	public List<Line> getLadder() {
		return ladder;
	}

	public int getPrizeIndex(int userIndex) {
		int x = userIndex;
		int y = 0;
		int userSize = ladder.get(0).size() + 1;
		int resultIndex = findResult(x, y, true, userSize);
		return resultIndex;
	}

	public int findResult(int x, int y, boolean moveAble, int userSize) {
		if (y >= ladder.size()) {
			return x;
		}
		Line line = ladder.get(y);
		if (moveAble && hasLeftLine(x, line)) { // 왼쪽으로 이동.
			return findResult(x - 1, y, false, userSize);
		}
		if (moveAble && hasRightLine(x, userSize, line)) { // 오른쪽으로 이동.
			return findResult(x + 1, y, false, userSize);
		}
		return findResult(x, y + 1, true, userSize); // 아래로 이동.
	}

	private boolean hasLeftLine(int x, Line line) {
		return x > 0 && line.get(x - 1);
	}

	private boolean hasRightLine(int x, int userSize, Line line) {
		return x < userSize - 1 && line.get(x);
	}

}
