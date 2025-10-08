package com.hdatuan.uniclub.repository;

import com.hdatuan.uniclub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    Optional<Users> findByEmail(String email);
}
