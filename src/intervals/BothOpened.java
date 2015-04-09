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
		return interval.includes(this);
	}
	public boolean includes(BothOpened interval) {
		return (includes(interval.getMinimum()) || getMinimum() == interval.getMinimum())
				&& (includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}
	public boolean includes(LeftOpened interval) {
		return (includes(interval.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (includes(interval.getMaximum()));
	}
	public boolean includes(RightOpened interval) {
		return (includes(interval.getMinimum()))
				&& (includes(interval.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}
	public boolean includes(UnOpened interval) {
		boolean minimumIncluded = includes(interval.getMinimum());
		boolean maximumIncluded = includes(interval.getMaximum());
		return (minimumIncluded) && (maximumIncluded);
	}
	

	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return false;
		}
		if (this.getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}
}
