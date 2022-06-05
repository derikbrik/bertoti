package com.jlemos.trazfast;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class TrazFastApplication{

   
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TrazFastApplication.class, args);
    }

  

}
