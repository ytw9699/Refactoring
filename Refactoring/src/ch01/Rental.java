package ch01;

public class Rental {//Rental은 대여 정보 클래스다
	
    private Movie _movie;
    private int _daysRented;//대여기간

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }
    
    int getFrequentRenterPoints() {
    	
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1){
        	
        	return 2;//최신물을 이틀 이상 대여하면 2포인트 지급
        	
        }else {
        	
        	return 1;//그 외엔 1포인트 지급
        }
    }
    
    double getCharge() {

        double result = 0;

        switch (getMovie().getPriceCode()) {
        
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
                break;
                
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
                
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
        }

        return result;
    }
}
