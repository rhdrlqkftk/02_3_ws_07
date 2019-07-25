package ws.ssafy;

public class Magazine extends Book {

	private int year;
	private int month;

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn);
		builder.append("\t|  ");
		builder.append(title);
		builder.append("\t|  ");
		builder.append(author);
		builder.append("\t|  ");
		builder.append(publisher);
		builder.append("\t|  ");
		builder.append(price);
		builder.append("\t\t|");
		builder.append(desc);
		builder.append("\t\t\t|\t");
		builder.append(year);
		builder.append(".");
		builder.append(month);
		return builder.toString();
	}

}
