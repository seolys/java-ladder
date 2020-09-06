package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {

	private List<Boolean> points = new ArrayList<>();

	public Line(int countOfPerson) {
		// 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
		Random random = new Random();

		boolean isLinedBefore = false;
		for (int i = 1; i < countOfPerson; i++) {
			isLinedBefore = add(random, isLinedBefore);
		}
	}

	public Boolean get(int i) {
		return points.get(i);
	}

	private boolean add(Random random, boolean isLinedBefore) {
		if (isLinedBefore) {
			points.add(false);
			return false;
		}
		boolean isLine = random.nextBoolean();
		points.add(isLine);
		return isLine;
	}

	public String toString() {
		return points.stream()
				.map(this::drawLine)
				.collect(Collectors.joining("|", "|", "|"));
	}

	public int size() {
		return points.size();
	}

	private String drawLine(boolean isLine) {
		return isLine ? "-----" : "     ";
	}

}