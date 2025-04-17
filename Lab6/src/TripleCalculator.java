public class TripleCalculator {
    private TripleValue value;
    private TripleOperator op;

    public TripleCalculator(TripleValue value, TripleOperator op) {
        this.value = value;
        this.op = op;
    }

    public TripleValue getValue() {
        return this.value;
    }

    public void setValue(TripleValue value) {
        this.value = value;
    }

    public TripleOperator getOp() {
        return this.op;
    }

    public void setOp(TripleOperator op) {
        this.op = op;
    }

    public int calculate() {
        return calc(value.getX(), value.getY(), value.getZ(), op);
    }

    public static int calc(int x, int y, int z, TripleOperator op) {
		switch (op) {
		case MIN:		return Math.min(Math.min(x, y), z);
		case MAX:		return Math.max(Math.max(x, y), z);
		case MEDIAN:	return Math.max(Math.min(x,y), Math.min(Math.max(x,y),z));
		case SUM:		return x + y + z;
		case PRODUCT:	return x * y * z;
		default: throw new AssertionError("Unknown operation " + op);
		}
	}

    @Override
    public String toString() {
        return "{" +
            " value='" + getValue() + "'" +
            ", op='" + getOp() + "'" +
            ", result='" + calculate() + "'" +
            " }";
    }

}
