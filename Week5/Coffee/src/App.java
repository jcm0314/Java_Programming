public class App {
    public static void main(String[] args) throws Exception {
        Coffee coffee1 = new Coffee("Costa Rica", "Light", 1);
        System.out.println(coffee1);
        Coffee coffee2 = new Coffee();
        coffee2.setOrigin("Kenya");
        coffee2.setDegreeOfRoast("Medium");
        coffee2.setGrade(5);
        System.out.println(" " + coffee2.getOrigin());
        System.out.println(" " + coffee2.getDegreeOfRoast());
        System.out.println(" " + coffee2.getGrade());
        // 객체 생성
        // 출력력
    }
}

