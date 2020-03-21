package com.tenpo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class BootApplicationTests {
	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
	}
	@Test
	public void test1() throws SQLException {
		/*try (Connection connection = dataSource.getConnection()) {
			System.out.println("connection -> " + connection);
		}*/
	}
}
