package com.example.dataserver.repository;

import com.example.dataserver.model.DataType;
import com.example.dataserver.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {

    DataType findTopByName(String name);
}
