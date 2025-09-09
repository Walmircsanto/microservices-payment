package br.com.walmir.order.repository;

import br.com.walmir.order.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
