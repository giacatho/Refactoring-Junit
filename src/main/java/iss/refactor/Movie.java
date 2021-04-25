package iss.refactor;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _categoryCode;
	
	public Movie(String title, int categoryCode) {
		_title = title;
		_categoryCode = categoryCode;
	}
	
	public int getCategory() {
		return _categoryCode;
	}
	
	public void setCategory(int category) {
		_categoryCode = category;
	}
	
	public String getTitle() {
		return _title;
	}
}
