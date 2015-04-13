package intervals;

public class UnOpened extends Interval {
	private Opening opening;
	public UnOpened(Punto minimum, Punto maximum) {
		super(minimum, maximum);
		this.opening = Opening.UNOPENED;
	}

	public boolean includes(double value) {
		return this.getMinimum() <= value && value <= this.getMaximum();
	}
	public boolean includes(Interval interval) {
		return interval.includes(this);
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
		return (interval.includes(this.getMinimum()))
				&& (interval.includes(this.getMaximum()));
	}

	@Override
	public boolean includes(LeftOpened interval) {
		return (interval.includes(this.getMinimum()))
				&& (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}

	@Override
	public boolean includes(RightOpened interval) {
		return (interval.includes(this.getMinimum())|| this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum()));
	}

	@Override
	public boolean includes(UnOpened interval) {
		return (interval.includes(this.getMinimum())|| this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}

	@Override
	public Opening getOpening() {
		return this.opening;
	}
}

