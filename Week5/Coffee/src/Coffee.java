public class Coffee {
    private String origin;
    private String degreeOfRoast;
    private int grade;

    public Coffee(String origin, String degreeOfRoast, int grade) {
        this.origin = origin;
        this.degreeOfRoast = degreeOfRoast;
        this.grade = grade;
    }

    public Coffee() {
        this.origin = null;
        this.degreeOfRoast = null;
        this.grade = 0;
    }


    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDegreeOfRoast() {
        return this.degreeOfRoast;
    }

    public void setDegreeOfRoast(String degreeOfRoast) {
        this.degreeOfRoast = degreeOfRoast;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "{" +
            " origin='" + getOrigin() + "'" +
            ", degreeOfRoast='" + getDegreeOfRoast() + "'" +
            ", grade='" + getGrade() + "'" +
            "}";
    }

    public void 메서드1() {

    }

    public void 메서드2() {
        
    }
    public void 메서드3() {
        
    }
}
