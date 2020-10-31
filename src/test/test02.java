package test;

import dao.BookDAO_MariaDB;

public class test02 {

	public static void main(String[] args) {
		BookDAO_MariaDB b = new BookDAO_MariaDB();
		b.booklist().forEach(i->{System.out.println(i);}); //여기 디비 내용이 들어와야함?
		
	}

}
