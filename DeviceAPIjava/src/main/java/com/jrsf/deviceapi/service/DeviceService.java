package com.jrsf.deviceapi.service;

import com.jrsf.deviceapi.domain.Device;
import com.jrsf.deviceapi.repositories.DeviceRepository;
import com.jrsf.deviceapi.service.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeviceService {

    DeviceRepository repository;

    public Device findById(Long id){
        Optional<Device> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Device não encontradea! Id: " + id + ", Device: " + Device.class.getName()
        ));
    }

    public List<Device> findAll() {
        List<Device> list = repository.findAll();
        return list;
    }

    public List<Device> findByBrand(String brand) {
        List<Device> brandList = repository.findByBrand(brand);
        return brandList;
    }

    public Device create(Device device) {
        device.setDeviceId(null);
        return repository.save(device);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Device update(Long id, Device device) {
        Device newObj = findById(id);
        newObj.setDeviceName(device.getDeviceName());
        newObj.setDeviceBrand(device.getDeviceBrand());
        newObj.setCreationTime(device.getCreationTime());
        return repository.save(newObj);
    }
}
