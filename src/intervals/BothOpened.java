package intervals;

public class BothOpened extends Interval{

	private Opening opening;

	public BothOpened(double minimum, double maximum) {
		super(minimum, maximum);
		this.opening = Opening.BOTH_OPENED;
	}

	@Override
	public boolean includes(double value) {
		return this.getMinimum() < value && value < this.getMaximum();
	}
	public boolean includes(Interval interval) {
		return interval.includes(this);

	}
	public boolean includes(BothOpened interval) {
		return (interval.includes(this.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}
	public boolean includes(LeftOpened interval) {
		return (interval.includes(this.getMinimum()) || this.getMinimum() == interval.getMinimum())
				&& (interval.includes(this.getMaximum()));
	}
	public boolean includes(RightOpened interval) {
		return (interval.includes(this.getMinimum()))
				&& (interval.includes(this.getMaximum()) || this.getMaximum() == interval.getMaximum());
	}
	public boolean includes(UnOpened interval) {
		return (interval.includes(this.getMinimum())) && interval.includes(this.getMaximum());
	}
	

	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum() || this.getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

	@Override
	public Opening getOpening() {
		return this.opening;
	}
}
