package service.Impl;

import beans.user1;
import dao.Impl.user1DaoImpl;
import dao.user1Dao;
import service.user1Service;

import java.util.List;

/**
 * @author lixu
 * @create 2022-03-04-22:38
 */
public class user1ServiceImpl implements user1Service {
    user1Dao ud = new user1DaoImpl();
    @Override
    public List<user1> findAlluser() {
        return ud.findAll();
    }

    @Override
    public user1 findOneUser(int id) {
        user1 u1 = ud.findOne(id);
        return u1;
    }
}
