package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private List<Line> ladder;

	public Ladder(int userSize, int ladderHeight) {
		this.ladder = IntStream.range(0, ladderHeight)
				.mapToObj(i -> new Line(userSize))
				.collect(Collectors.toList());
	}

	public List<Line> getLadder() {
		return ladder;
	}
}
