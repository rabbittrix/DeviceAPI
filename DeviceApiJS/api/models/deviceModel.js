'use strict'
var mongoose = require('mongoose')
var Schema = mongoose.Schema

var deviceSchema = Schema({
    deviceName: {type: String},
    deviceBrand: {type: String},
    creationTime: {datetime: String}
})

module.exports = mongoose.model('device', deviceSchema)