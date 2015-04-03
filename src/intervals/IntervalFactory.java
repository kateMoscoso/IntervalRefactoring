package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		switch (opening) {
		case BOTH_OPENED:
			return new BothOpened(minimum, maximum, opening);
		case LEFT_OPENED:
			return new LeftOpened(minimum, maximum, opening);
		case RIGHT_OPENED:
			return new RightOpened(minimum, maximum, opening);
		case UNOPENED:
			return new UnOpened(minimum, maximum, opening);
		default:
			return null;
		}
	}
}
