package com.hasan.jpahibernate.repo;

import com.hasan.jpahibernate.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien,Integer> {

}
