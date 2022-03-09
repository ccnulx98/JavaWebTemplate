package dao;

import beans.user1;

import java.util.List;

/**
 * @author lixu
 * @create 2022-03-02-20:02
 */
public interface user1Dao {
    public abstract user1 findOne(int id);
    public abstract List<user1> findAll();
}
