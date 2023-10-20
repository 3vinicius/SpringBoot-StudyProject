package vinicius.mywebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vinicius.mywebapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
