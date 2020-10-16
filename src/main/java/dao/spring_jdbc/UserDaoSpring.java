package dao.spring_jdbc;

import model.user.User;

public interface UserDaoSpring {
    boolean insertUser(User user);
    boolean updateUser(User currentUser, String updateLogin, String updatePass, String updateEmail);
    boolean deleteUser(User user);
    User loginUser(User user);
}

