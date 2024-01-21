package com.example.demo.query;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "userquery")
@ConfigurationPropertiesScan
@Data
public class UserQuery {
    // Запись sql с получением всех пользователей из БД
    private String findAllSqlUser;
    // Запись sql с сохрением пользователя в БД
    private String saveSqlUser;
    // Запись sql с удалением пользователя из БД
    private String deleteSqlUser;
    // Запись sql с обновлением пользователя в БД
    private String updateSqlUser;
}
