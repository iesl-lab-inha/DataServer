package com.example.dataserver.repository;

import com.example.dataserver.model.Data;
import com.example.dataserver.model.Device;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    List<Data> findAllByOrderByTimeAsc();
    List<Data> findAllByTimeAndDevice(Instant time, Device device);
//    List<Data> getAll();
//    Data findTopByTimeSor
//    Data findTopByTimeDesc();
}
