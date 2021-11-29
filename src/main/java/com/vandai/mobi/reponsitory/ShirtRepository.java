package com.vandai.mobi.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Shirt;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Integer>{

}
