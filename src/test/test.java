package test;

import dao.DbConnection;
import dao.UserDao;
import model.*;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection conn = new DbConnection();
		UserDao userdao = new UserDao(conn);
		User usr = userdao.login("luiasdsdavid@gmail.com", "2307");
		System.out.println(usr);
		conn.disconnect();
	}

}
