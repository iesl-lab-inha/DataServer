package com.example.dataserver.repository;

import com.example.dataserver.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
//    List<Data> getAll();
}
