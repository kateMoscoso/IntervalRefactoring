package intervals;

public class RightOpened extends Interval {
	private Opening opening;
	public RightOpened(Punto minimum, Punto maximum) {
		super(minimum, maximum);
		this.opening = Opening.RIGHT_OPENED;
	}

	public boolean includes(double value) {
		return this.getMinimum().isLessThanOrEquals(value) && this.getMaximum().isGreaterThan(value);
	}
	
	public boolean includes(Interval interval) {
		return interval.includes(this);
	}
	
	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum().equals(interval.getMaximum())) {
			return interval.getOpening() == Opening.LEFT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;
		}
		if (this.getMaximum().equals(interval.getMinimum())) {
			return false;
		}
		return this.includes(interval.getMinimum().getValor())
				|| this.includes(interval.getMaximum().getValor());
	}

	@Override
	public boolean includes(BothOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) )
				&& (interval.includes(this.getMaximum().getValor()) || this.getMaximum().equals(interval.getMaximum()));
	}

	@Override
	public boolean includes(LeftOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) )
				&& (interval.includes(this.getMaximum().getValor()) || this.getMaximum().equals(interval.getMaximum()));
	}

	@Override
	public boolean includes(RightOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.getMinimum().equals(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()) || this.getMaximum().equals(interval.getMaximum()));
	}

	@Override
	public boolean includes(UnOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.getMinimum().equals(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()));
	}

	@Override
	public Opening getOpening() {
		return this.opening;
	}
}


