package dao.Impl;

import beans.user1;

import dao.user1Dao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @author lixu
 * @create 2022-03-04-22:31
 */
public class user1DaoImpl implements user1Dao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public user1 findOne(int id) {
        String sql = "select * from user1 where id=?";
        user1 u1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(user1.class),id);
        return u1;
    }

    @Override
    public List<user1> findAll() {
        String sql = "select * from user1";
        List<user1> userList = template.query(sql, new BeanPropertyRowMapper<>(user1.class));
        return userList;
    }
}
