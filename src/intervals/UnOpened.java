package intervals;

public class UnOpened extends Interval {
	public UnOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		// TODO Auto-generated constructor stub
	}

	public boolean includes(double value) {
		return this.getMinimum() <= value && value <= this.getMaximum();
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
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case RIGHT_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
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
	public boolean includes(BothOpened bothOpenedInterval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean includes(LeftOpened leftOpenedInterval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean includes(RightOpened rightOpenedInterval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean includes(UnOpened unOpenedInterval) {
		// TODO Auto-generated method stub
		return false;
	}
}

