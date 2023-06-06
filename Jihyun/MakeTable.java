package Project;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javaStudy.CommonFrame;

public class MakeTable extends CommonFrame{
	public MakeTable() throws Exception {
		Scanner sc = new Scanner(System.in);
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "root", "0178");
        var stmt = con.createStatement();
      
        
        stmt.execute("SET GLOBAL local_infile = 1");
        stmt.execute("DROP SCHEMA IF EXISTS `make_table`");
        stmt.execute("CREATE SCHEMA `make_table` DEFAULT CHARACTER SET utf8;"); 
        stmt.execute("CREATE TABLE `make_table`.`nation` ("
                + "`n_no` INT NOT NULL AUTO_INCREMENT,"
                + "c_no INT,"
                + "code VARCHAR(3),"
                + "n_name VARCHAR(20),"
                + "x INT,"
                + "y INT,"
                + "PRIMARY KEY (`n_no`));");
        System.out.println("nation 생성 완료");

        stmt.execute("CREATE TABLE `make_table`.`division` ("
                + "`d_no` INT NOT NULL AUTO_INCREMENT,"
                + "d_name VARCHAR(50),"
                + "PRIMARY KEY (`d_no`));");
        System.out.println("division 생성 완료");
        
        stmt.execute("CREATE TABLE `make_table`.`user` ("
                + "`u_no` INT NOT NULL AUTO_INCREMENT,"
                + "id VARCHAR(20),"
                + "pw VARCHAR(20),"
                + "name1 VARCHAR(20),"
                + "name2 VARCHAR(20),"
                + "birth DATE,"
                + "mileage INT,"
                + "PRIMARY KEY (`u_no`));");
        System.out.println("user 생성 완료");

        stmt.execute("CREATE TABLE `make_table`.`schedule` ("
                + "`s_no` INT NOT NULL AUTO_INCREMENT,"
                + "date DATE,"
                + "depart INT,"
                + "arrival INT,"
                + "departTime TIME,"
                + "timeTaken TIME,"
                + "price INT,"
                + "PRIMARY KEY (`s_no`));");
        System.out.println("schedule 생성 완료");

        stmt.execute("CREATE TABLE `make_table`.`continent` ("
                + "`c_no` INT NOT NULL AUTO_INCREMENT,"
                + "c_name VARCHAR(50),"
                + "x INT,"
                + "y INT,"
                + "PRIMARY KEY (`c_no`));");        
        System.out.println("continent 생성 완료");
        
        int c_no = sc.nextInt();
        String code = sc.next();
        String n_name = sc.next();
        int x = sc.nextInt();
        int y = sc.nextInt();
        updateSQL("INSERT INTO `make_table`.`nation`"
        		+ " (c_no, code, n_name, x, y) VALUES (?, ?, ?, ?, ?)"
        		+ "", c_no, code, n_name, x, y);
        System.out.println("nation 테이블 입력 완료");
        
        String d_name = sc.next();
        updateSQL("INSERT INTO `make_table`.`division`"
        		+ " (d_name) VALUES (?)"
        		+ "", d_name);
        System.out.println("division 테이블 입력 완료");
        
        String id = sc.next();
        String pw = sc.next();
        String name1 = sc.next();
        String name2 = sc.next();
        String birth = sc.next();  // date형, YYYY-MM-DD 형태로 입력
        int mileage = sc.nextInt();
        updateSQL("INSERT INTO `make_table`.`user`"
        		+ " (id, pw, name1, name2, birth, mileage) VALUES (?, ?, ?, ?, ?, ?)"
        		+ "", id, pw, name1, name2, birth, mileage);
        System.out.println("user 테이블 입력 완료");
        
        String date = sc.next();  // date형, YYYY-MM-DD 형태로 입력
        int depart = sc.nextInt();
        int arrival = sc.nextInt();
        String departTime = sc.next();  // time형, 00:00:00 형태로 입력
        String timeTaken = sc.next();  // time형, 00:00:00 형태로 입력
        int price = sc.nextInt();        
        updateSQL("INSERT INTO `make_table`.`schedule`"
        		+ " (date, depart, arrival, departTime, timeTaken, price) VALUES (?, ?, ?, ?, ?, ?)"
        		+ "", date, depart, arrival, departTime, timeTaken, price);
        System.out.println("schedule 테이블 입력 완료");
        
        String c_name = sc.next();
        int c_x = sc.nextInt();
        int c_y = sc.nextInt();
        updateSQL("INSERT INTO `make_table`.`continent`"
        		+ " (c_name, x, y) VALUES (?, ?, ?)"
        		+ "", c_name, c_x, c_y);
        System.out.println("continent 테이블 입력 완료");
        
        var n_rs = getResulSet("SELECT * FROM `make_table`.`nation`");
        try {
			while(n_rs.next()) {
				System.out.print(n_rs.getInt(1) + " ");
				System.out.print(n_rs.getString(2) + " ");
				System.out.print(n_rs.getString(3) + " ");
				System.out.print(n_rs.getString(4) + " ");
				System.out.print(n_rs.getString(5) + " ");
				System.out.println(n_rs.getString(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
        
        var d_rs = getResulSet("SELECT * FROM `make_table`.`division`");
        try {
			while(d_rs.next()) {
				System.out.print(d_rs.getInt(1) + " ");
				System.out.println(d_rs.getString(2));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
        
        var u_rs = getResulSet("SELECT * FROM `make_table`.`user`");
        try {
			while(u_rs.next()) {
				System.out.print(u_rs.getInt(1) + " ");
				System.out.print(u_rs.getString(2) + " ");
				System.out.print(u_rs.getString(3) + " ");
				System.out.print(u_rs.getString(4) + " ");
				System.out.print(u_rs.getString(5) + " ");
				System.out.print(u_rs.getString(6) + " ");
				System.out.println(u_rs.getInt(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
        
        var s_rs = getResulSet("SELECT * FROM `make_table`.`schedule`");
        try {
			while(s_rs.next()) {
				System.out.print(s_rs.getInt(1) + " ");
				System.out.print(s_rs.getString(2) + " ");
				System.out.print(s_rs.getString(3) + " ");
				System.out.print(s_rs.getString(4) + " ");
				System.out.print(s_rs.getString(5) + " ");
				System.out.print(s_rs.getString(6) + " ");
				System.out.println(s_rs.getString(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
        
        var c_rs = getResulSet("SELECT * FROM `make_table`.`continent`");
        try {
			while(c_rs.next()) {
				System.out.print(c_rs.getInt(1) + " ");
				System.out.print(c_rs.getString(2) + " ");
				System.out.print(c_rs.getString(3) + " ");
				System.out.println(c_rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			new MakeTable();
			System.out.println("셋팅성공");
		} catch (Exception e) {
			System.out.println("셋팅실패");
			e.printStackTrace();
		}
	}

}
