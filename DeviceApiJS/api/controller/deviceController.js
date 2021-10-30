'use strict'
var mongoose = require('mongoose')
var device = mongoose.model('device')

// GET ALL devices
exports.listAllDevices = function(req, res) {
    device.find({}, function(err, devices) {
        if (err) {
            res.send(err);
        }
        res.json(devices);
    })
}

//GET by ID
exports.listOneDevices = function(req, res) {
    device.findOne({"_id": req.params.deviceId}, function(err, device) {
        if (err) {
            res.send(err);
        }
        res.json(device);
    })
}

//GET by Brand (need finish)
exports.listBrand = function(req, res) {
    device.find({}, function(err, device) {
        if (err) {
            res.send(err);
        }
        res.json(device);
    })
}

// POST create device
exports.createDevice = function(req, res) {
    var newDevice = new device(req.body)
    newDevice.save(function(err, device) {
        if (err) {
            res.send(err);
        }
        res.json(device);
    })
}

// PUT update
exports.updateDevice = function(req, res) {
    device.findByIdAndUpdate({_id: req.params.deviceId}, req.body, {new: true}, 
        function(err, device){
            if (err) {
                res.send(err);
            }
            res.json(device);
        })
}

// DELETE
exports.removeDevice = function(req, res){
    device.deleteOne({_id: req.params.deviceId}, function(err, device){
        if (err) {
            res.send(err);
        }
        res.json("Mensagem: Device removed successfully");
    })
}