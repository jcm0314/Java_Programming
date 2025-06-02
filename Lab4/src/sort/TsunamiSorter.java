// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package sort;

import model.Tsunami;
import model.NaturalHazard;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class TsunamiSorter {
    public static void sortByEventValidity(List<Tsunami> tsunamis) {
        Collections.sort(tsunamis, new Comparator<Tsunami>() {
            @Override
            public int compare(Tsunami t1, Tsunami t2) {
                return t1.getTsunamiEventValidity().getCode() - t2.getTsunamiEventValidity().getCode();
            }
        });
    }

    public static void sortByCauseCode(List<Tsunami> tsunamis) {
        Collections.sort(tsunamis, new Comparator<Tsunami>() {
            @Override
            public int compare(Tsunami t1, Tsunami t2) {
                return t1.getTsunamiCauseCode().getCode() - t2.getTsunamiCauseCode().getCode();
            }
        });
    }

    public static void sortByCountry(List<Tsunami> tsunamis) {
        Collections.sort(tsunamis, new Comparator<Tsunami>() {
            @Override
            public int compare(Tsunami t1, Tsunami t2) {
                return t1.getCountry().compareTo(t2.getCountry());
            }
        });
    }

    public static void sortByMaximumWaterHeight(List<Tsunami> tsunamis) {
        Collections.sort(tsunamis, new Comparator<Tsunami>() {
            @Override
            public int compare(Tsunami t1, Tsunami t2) {
                return Double.compare(t1.getMaximumWaterHeight(), t2.getMaximumWaterHeight());
            }
        });
    }

    public static void sortByNumberOfRunup(List<Tsunami> tsunamis) {
        Collections.sort(tsunamis, new Comparator<Tsunami>() {
            @Override
            public int compare(Tsunami t1, Tsunami t2) {
                return t1.getNumberOfRunup() - t2.getNumberOfRunup();
            }
        });
    }

    public static void sort(List<Tsunami> tsunamis, int criteria) {
        switch (criteria) {
            case 0: // 연도
                Collections.sort(tsunamis, new Comparator<Tsunami>() {
                    @Override
                    public int compare(Tsunami t1, Tsunami t2) {
                        return t1.getYear() - t2.getYear();
                    }
                });
                break;
            case 1: // 월
                Collections.sort(tsunamis, new Comparator<Tsunami>() {
                    @Override
                    public int compare(Tsunami t1, Tsunami t2) {
                        return t1.getMonth() - t2.getMonth();
                    }
                });
                break;
            case 2: // 일
                Collections.sort(tsunamis, new Comparator<Tsunami>() {
                    @Override
                    public int compare(Tsunami t1, Tsunami t2) {
                        return t1.getDay() - t2.getDay();
                    }
                });
                break;
            case 3: // 이벤트 유효성
                sortByEventValidity(tsunamis);
                break;
            case 4: // 원인 코드
                sortByCauseCode(tsunamis);
                break;
            case 5: // 국가
                sortByCountry(tsunamis);
                break;
            case 6: // 위도
                Collections.sort(tsunamis, new Comparator<Tsunami>() {
                    @Override
                    public int compare(Tsunami t1, Tsunami t2) {
                        return Double.compare(t1.getLatitude(), t2.getLatitude());
                    }
                });
                break;
            case 7: // 경도
                Collections.sort(tsunamis, new Comparator<Tsunami>() {
                    @Override
                    public int compare(Tsunami t1, Tsunami t2) {
                        return Double.compare(t1.getLongitude(), t2.getLongitude());
                    }
                });
                break;
            case 8: // 최대 수위
                sortByMaximumWaterHeight(tsunamis);
                break;
            case 9: // 런업 횟수
                sortByNumberOfRunup(tsunamis);
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting criteria: " + criteria);
        }
    }
} 