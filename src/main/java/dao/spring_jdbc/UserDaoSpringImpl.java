package dao.spring_jdbc;

import model.user.User;


public class UserDaoSpringImpl implements UserDaoSpring {

    @Override
    public User loginUser(User user) {
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User currentUser, String updateLogin, String updatePass, String updateEmail) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
