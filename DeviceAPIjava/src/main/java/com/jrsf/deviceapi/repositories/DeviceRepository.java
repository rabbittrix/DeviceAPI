package com.jrsf.deviceapi.repositories;

import com.jrsf.deviceapi.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query(value = "select obj from Device obj where upper(trim(obj.deviceBrand)) like %?1%")
    List<Device> findByBrand(String brand);
}
