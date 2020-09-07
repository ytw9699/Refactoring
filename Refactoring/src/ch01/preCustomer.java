package ch01;
	import java.util.Enumeration;
	import java.util.Vector;

public class preCustomer {//Customer는 고객 클래스다
	
    private String _name;
    private Vector _rentals = new Vector();

    public preCustomer(String name) {
        this._name = name;
    }
    
    public String getName() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }

    public String statement() {//내역을 생성  = 누적 대여료, 적립 포인트 출력
    						   //홍길동 고객님의 대여기록 
    						   //누적 대여료: 얼마 
    	 					   //적립포인트 : 얼마
    	
        double totalAmount = 0;//누적 대여료
        
        int frequentRenterPoints = 0;//적립 포인트
        
        Enumeration rentals = _rentals.elements();
        
        String result = _name + " 고객님의 대여 기록\n";

        while(rentals.hasMoreElements()) {
        	
            double thisAmount = 0;
            
            Rental each = (Rental) rentals.nextElement();

          
            switch (each.getMovie().getPriceCode()) {//비디오 종류별로 대여료 계산
            
                case Movie.REGULAR:
                    
                	thisAmount += 2;
                    
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                    
                case Movie.NEW_RELEASE:
                    
                	thisAmount += each.getDaysRented() * 3;
                    break;
                    
                case Movie.CHILDRENS:
                    
                	thisAmount += 1.5;
                	
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints ++;

            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        //푸터 행 추가
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트: " + String.valueOf(frequentRenterPoints);
        
        return result;
    }

}