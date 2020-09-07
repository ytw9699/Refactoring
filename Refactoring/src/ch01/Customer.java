package ch01;
	import java.util.Enumeration;
	import java.util.Vector;

public class Customer {//Customer는 고객 클래스다
	
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        this._name = name;
    }
    
    public String getName() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }
    
    // 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작성
    private double amountFor(Rental aRental) {

    	return aRental.getCharge();
    }

    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록\\n";

        while (rentals.hasMoreElements()) {
        	
            Rental each = (Rental) rentals.nextElement();

            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints++;

            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints++;

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\\t" + each.getMovie().getTitle() + "\\t" +
                    String.valueOf(each.getCharge()) + "\\n";

            // 현재까지 누적된 총 대여료, //비디오 종류별 대여료 계산
            totalAmount += each.getCharge();
        }

        // 푸터 행 추가
        result += "누적 대여료 : " + String.valueOf(totalAmount) + "\\n";
        result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);
        return result;
    }

}