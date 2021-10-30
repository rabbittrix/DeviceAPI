'use strict'

const { get } = require('express/lib/response')

module.exports = function(app){
    var deviceController = require('../controller/deviceController')

    app.route('/api')
        .get(deviceController.listAllDevices)
        .post(deviceController.createDevice)

    app.route('/api/:deviceId')
        .get(deviceController.listOneDevices)
        .put(deviceController.updateDevice)
        .delete(deviceController.removeDevice)

    app.route('(/api/brand/:devicebrand)')
        .get(deviceController.listBrand)

}