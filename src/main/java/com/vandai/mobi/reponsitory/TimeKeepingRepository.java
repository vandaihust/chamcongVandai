package com.vandai.mobi.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.TimeKeeping;
@Repository
public interface TimeKeepingRepository extends JpaRepository<TimeKeeping, Integer>{

}
