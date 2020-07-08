package com.ib.library.repository;

import com.ib.library.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
  Optional<User> findByEmailAndPassword(String email, String passeword);

  Optional<User> findByEmail(String email);
}