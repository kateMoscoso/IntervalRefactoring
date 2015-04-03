package intervals;

public class BothOpened extends Interval{
	


	public BothOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return this.getMinimum() < value && value < this.getMaximum();
	}
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		switch (interval.getOpening()) {
		case BOTH_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded);
		case RIGHT_OPENED:
			return (minimumIncluded)
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded) && (maximumIncluded);
		default:
			assert false;
			return false;
		}
	}

}
