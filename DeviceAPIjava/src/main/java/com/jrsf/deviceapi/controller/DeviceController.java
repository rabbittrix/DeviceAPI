package com.jrsf.deviceapi.controller;

import com.jrsf.deviceapi.domain.Device;
import com.jrsf.deviceapi.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@Api(value = "API REST Device")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class DeviceController {

    DeviceService service;

    // List all devices
    @ApiOperation(value = "List all devices")
    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices(){
        List<Device> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Get device by identifier
    @ApiOperation(value = "Get device by identifier")
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id){
        Device obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Search device by brand
    @ApiOperation(value = "Search device by brand")
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Device>> getDeviceByBrand(@PathVariable String brand){
        List<Device> list = service.findByBrand(brand.trim().toUpperCase());
        return ResponseEntity.ok().body(list);
    }

    // Add device (create)
    @ApiOperation(value = "Add device (create)")
    @PostMapping
    public ResponseEntity<Device> saveDevice(@RequestBody Device device){
        device = service.create(device);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(device.getDeviceId()).toUri();
        return ResponseEntity.created(uri).body(device);
    }

    // Update device (full and partial)
    @ApiOperation(value = "Update device (full and partial)")
    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device){
        Device newObj = service.update(id, device);
        return ResponseEntity.ok().body(newObj);
    }

    // Delete a device
    @ApiOperation(value = "Delete a device")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
