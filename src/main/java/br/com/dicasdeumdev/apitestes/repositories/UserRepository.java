package br.com.dicasdeumdev.apitestes.repositories;

import br.com.dicasdeumdev.apitestes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
