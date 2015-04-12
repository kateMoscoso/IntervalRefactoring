package intervals;

public class LeftOpened extends Interval{
	private Opening opening;
	public LeftOpened(double minimum, double maximum) {
		super(minimum, maximum);
		this.opening = Opening.LEFT_OPENED;
	}

	public boolean includes(double value) {
		return this.getMinimum() < value && value <= this.getMaximum();
	}
	public boolean includes(Interval interval) {
		return interval.includes(this);
	}

	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return false;
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
		return (interval.includes(this.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum()));
	}

	@Override
	public boolean includes(LeftOpened interval) {
		return (interval.includes(this.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum())|| this.getMaximum() == interval.getMaximum());
	}

	@Override
	public boolean includes(RightOpened interval) {
		return (interval.includes(this.getMinimum())|| this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum()) );
	}

	@Override
	public boolean includes(UnOpened interval) {
		return (interval.includes(this.getMinimum()))
				&& (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}

	@Override
	public Opening getOpening() {
		// TODO Auto-generated method stub
		return this.opening;
	}
}
