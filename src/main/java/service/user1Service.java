package service;

import beans.user1;

import java.util.List;

/**
 * @author lixu
 * @create 2022-03-02-20:03
 */
public interface user1Service {
    public abstract List<user1> findAlluser();
    public abstract user1 findOneUser(int id);
}
