package com.database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public DatabaseApplication(DataSource dataSource){this.dataSource = dataSource;}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args){
		log.info("DataSource: " + dataSource.toString());
		final JdbcTemplate resTemplate = new JdbcTemplate(dataSource);
		String name = resTemplate.queryForObject("SELECT id FROM author LIMIT 1", String.class);
		log.info(name);
	}
	
}
