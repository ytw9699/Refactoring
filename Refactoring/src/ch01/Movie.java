package ch01;

public class Movie {//Movie는 간단한 비디오 데이터 클래스다
	
    public static final int CHILDRENS = 2; // 아동물 priceCode
    public static final int REGULAR = 0; // 일반물 priceCode
    public static final int NEW_RELEASE = 1;//최신물 priceCode

    private String _title;//비디오 제목
    private int _priceCode;//

    public Movie(String title, int priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        this._priceCode = priceCode;
    }
    
}