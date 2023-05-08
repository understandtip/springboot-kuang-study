package org.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.LocalTime.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        System.out.println(dataSource.getClass());
        String sql = "select * from tbl_book";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(System.out::println);
        //System.out.println(maps);
    }

    @Test
    public void testDate() throws ParseException {
        Date date = new Date();
        //long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss");
        //System.out.println(simpleDateFormat.format(date));
        String format = simpleDateFormat.format(date);
        System.out.println(simpleDateFormat.parse(format));
    }

    @Test
    public void testCalendar() {
        /*Calendar date = Calendar.getInstance();
        date.add(Calendar.YEAR,1);
        System.out.println(date);*/

        /*LocalDate now = LocalDate.now();
        LocalDate now1 = LocalDate.of(2023,3,18);
        System.out.println(now1.getDayOfWeek());*/

        /*LocalDate now1 = LocalDate.of(2023,3,18);
        LocalDate localDate = LocalDateTime.now().toLocalDate();
        System.out.println(localDate.withMonth(2).isBefore(now1));*/

        /*Instant instant = Instant.now();
        Date date = Date.from(instant);
        System.out.println(date);
        Instant instant_1 = date.toInstant();*/

       /* LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss");
        System.out.println(now.format(dateTimeFormatter));*/

        /*LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2003, 11, 25);
        Period between = Period.between(now, of);
        System.out.println(between.getYears() +"年"+ between.getMonths()+"月"+between.getDays()+"日");
        System.out.println(ChronoUnit.YEARS.between(now, of));*/
    }
}
