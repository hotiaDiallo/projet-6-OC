package com.ib.library.service.abstraction;

import com.ib.library.model.User;
import java.util.List;

public interface UserService {
  String login(String email, String password);

  List<User> findAll();

  User findUserById(Integer id);
  User findUserByEmail(String email);
}
