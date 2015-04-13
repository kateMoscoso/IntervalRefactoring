package intervals;

public class LeftOpened extends Interval{
	private Opening opening;
	public LeftOpened(Punto minimum, Punto maximum) {
		super(minimum, maximum);
		this.opening = Opening.LEFT_OPENED;
	}

	public boolean includes(double value) {
		return this.getMinimum().getValor() < value && value <= this.getMaximum().getValor();
	}
	public boolean includes(Interval interval) {
		return interval.includes(this);
	}

	public boolean intersectsWith(Interval interval) {
		if (this.equalsWithMinimum(interval.getMaximum())) {
			return false;
		}
		if (this.equalsWithMaximum(interval.getMinimum())) {
			return interval.getOpening() == Opening.RIGHT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;

		}
		return this.includes(interval.getMinimum().getValor())
				|| this.includes(interval.getMaximum().getValor());
	}

	@Override
	public boolean includes(BothOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.equalsWithMinimum(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()));
	}

	@Override
	public boolean includes(LeftOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.equalsWithMinimum(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()));
	}

	@Override
	public boolean includes(RightOpened interval) {
		return (interval.includes(this.getMinimum().getValor())  || this.equalsWithMinimum(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()) );
	}

	@Override
	public boolean includes(UnOpened interval) {
		return (interval.includes(this.getMinimum().getValor()) || this.equalsWithMinimum(interval.getMinimum()))
				&& (interval.includes(this.getMaximum().getValor()) );
	}

	@Override
	public Opening getOpening() {
		return this.opening;
	}
}
