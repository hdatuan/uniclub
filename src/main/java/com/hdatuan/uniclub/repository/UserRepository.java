package com.hdatuan.uniclub.repository;

import com.hdatuan.uniclub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {


}
