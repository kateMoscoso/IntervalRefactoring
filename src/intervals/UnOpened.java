package intervals;

public class UnOpened extends Interval {
	private Opening opening;
	public UnOpened(double minimum, double maximum) {
		super(minimum, maximum);
		this.opening = Opening.UNOPENED;
		// TODO Auto-generated constructor stub
	}

	public boolean includes(double value) {
		return this.getMinimum() <= value && value <= this.getMaximum();
	}
	public boolean includes(Interval interval) {
		switch (interval.getOpening()) {
		case BOTH_OPENED:
			return includes((BothOpened)interval); 
		case LEFT_OPENED:
			return includes((LeftOpened)interval);
		case RIGHT_OPENED:
			return includes((RightOpened)interval);
		case UNOPENED:
			return includes((UnOpened)interval);
		default:
			assert false;
			return false;
		}
	}
	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return interval.getOpening() == Opening.LEFT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;
		}
		if (this.getMaximum() == interval.getMinimum()) {
			return interval.getOpening() == Opening.RIGHT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

	@Override
	public boolean includes(BothOpened interval) {
		return (this.includes(interval.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (this.includes(interval.getMaximum())|| this.getMaximum() == interval.getMaximum());
	}

	@Override
	public boolean includes(LeftOpened interval) {
		return (this.includes(interval.getMinimum())|| this.getMinimum() == interval.getMinimum())
				&& (this.includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}

	@Override
	public boolean includes(RightOpened rightOpenedInterval) {
		return (this.includes(rightOpenedInterval.getMinimum()) || this.getMinimum() == rightOpenedInterval.getMinimum())
				&& (this.includes(rightOpenedInterval.getMaximum()) || getMaximum() == rightOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(UnOpened interval) {
		return (this.includes( interval.getMinimum()) || this.getMinimum() ==  interval.getMinimum())
				&& this.includes( interval.getMaximum()) || this.getMaximum() ==  interval.getMaximum();
	}

	@Override
	public Opening getOpening() {
		// TODO Auto-generated method stub
		return this.opening;
	}
}

