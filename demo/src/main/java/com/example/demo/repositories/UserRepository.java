package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.query.UserQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {

    private final UserQuery userQuery;
    private final JdbcTemplate jdbc;

    public UserRepository(UserQuery userQuery, JdbcTemplate jdbc) {
        this.userQuery = userQuery;
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(userQuery.getFindAllSqlUser(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(userQuery.getSaveSqlUser(), user.getFirstName(), user.getLastName());
        return user;
    }

    //    Удаление пользователя
    public void deleteById(int id) {
        jdbc.update(userQuery.getDeleteSqlUser(), id);
    }

    //    Обновление информации о пользователе
    public User getOne(int id) {
        for (User u :
                findAll()) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public User updateById(User user) {
        jdbc.update(userQuery.getUpdateSqlUser(), user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}
