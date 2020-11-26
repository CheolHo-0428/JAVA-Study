package Project;

public class MyDate {
	private int day;
	private int month;
	private int year;
	public boolean isValid = true;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
			if(day > 29) {
				isValid = false;
			}
			else {
				this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public MyDate(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	public String isValid() {
		if(isValid == true) {
			return "유효한 날짜 입니다.";
			}
		else {
			return "유효하지 않은 날짜 입니다." ;
		}
}
}
