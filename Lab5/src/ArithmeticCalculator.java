
public class ArithmeticCalculator {
    private int x;
    private int y;
    private char op;
    private int result;

    public ArithmeticCalculator(int x, int y, char op) {
        this.x = x;
        this.y = y;
        this.op = op;
        this.result = calc(x, y, op);
    }
    

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOp() {
        return this.op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", op='" + getOp() + "'" +
            ", result='" + result + "'" +
            "}";
    }


    private static int calc(int x, int y, char op) {
		return switch (op) {
		case '+' -> x + y;
		case '-' -> x - y;
		case '*' -> x * y;
		case '/' -> x / y;
		case '%' -> x % y;
		default -> 0;
		};
	}
}
