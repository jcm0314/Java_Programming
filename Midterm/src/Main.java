// 2025/04/24 컴퓨터공학과 32203919 장천명

public class Main {
    
    public static void main(String[] args) {
        // (1) FigureType 열거형의 모든 값 출력
        FigureType[] types = FigureType.values();
        int i = 0;
        do {
            System.out.println(types[i]);
            i++;
        } while (i < types.length);

        // foreach를 사용한 FigureType 열거형 값 출력
        for (FigureType type : FigureType.values()) {
            System.out.println(type);
        }

        //(2) static method vs instance method

        //static method - 클래스명.정적메소드명 호출 Point.getDistance(p1, p2)
        double d1 = Point.getDistance(new Point(0,0), new Point(1,1));
        System.out.println(d1);
        //instance method - 인스턴스명.인스턴스메소드명 호출 figure1.getPerimeter()
        Figure figure1 = new Figure(new Point[]{new Point(0,0),new Point(0,1),
                                    new Point(0,1),new Point(1,1)});
        double d2 = figure1.getPerimeter();
        System.out.println(d2);

        //(3) constructor overloaing
        Point p1 = new Point(); // default constructor
        System.out.println(p1);
        Point p2 = new Point(10,20); // constuctor with all member fields
        System.out.println(p2);

        //(4) Point getDistance, getAngle, areParallel
        double distance = Point.getDistance(new Point(1,1), new Point(1,3));
        System.out.println("distance=" + distance);
        double angle = Point.getAngle(new Point(0,0), new Point(0,2), 
        new Point(2,2));
        System.out.println("angle=" + angle);
        boolean parallel = Point.areParallel(new Point(0,0), new Point(0,1), 
        new Point(1,0), new Point(1,1));
        System.out.println("parallel=" + parallel);

        // 다양한 도형 생성 및 출력
        Point[][] figurePoints = {
            {new Point(0, 0), new Point(2, 0), new Point(2, 2), new Point(0, 2)},  // 정사각형
            {new Point(-2, -1), new Point(2, -1), new Point(2, 1), new Point(-2, 1)},  // 직사각형
            {new Point(-1, 0), new Point(0, -2), new Point(1, 0), new Point(0, 2)},  // 마름모
            {new Point(0, 0), new Point(2, 0), new Point(3, 2), new Point(1, 2)},  // 평행사변형
            {new Point(0, 0), new Point(4, 0), new Point(3, 2), new Point(1, 2)}   // 사다리꼴
        };

        for (var points : figurePoints) {
            Figure figure = new Figure(points);
            System.out.println(figure);
        }

        // 직사각형 생성
        System.out.println(new Figure(figurePoints[1]));
        
    }
}
