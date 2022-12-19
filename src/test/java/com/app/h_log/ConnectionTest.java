package com.app.h_log;


import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Log4j2
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void connectionTest() throws SQLException {
        @Cleanup Connection condition = dataSource.getConnection();
        log.info(condition);
    }


}
