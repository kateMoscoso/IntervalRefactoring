package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		switch (opening) {
		case BOTH_OPENED:
			return new BothOpened(new Punto(minimum), new Punto(maximum));
		case LEFT_OPENED:
			return new LeftOpened(new Punto(minimum), new Punto(maximum));
		case RIGHT_OPENED:
			return new RightOpened(new Punto(minimum), new Punto(maximum));
		case UNOPENED:
			return new UnOpened(new Punto(minimum), new Punto(maximum));
		default:
			return null;
		}
	}
}
