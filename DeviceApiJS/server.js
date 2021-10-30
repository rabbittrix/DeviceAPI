var express = require('express');

app = express();
port = process.env.PORT ||3000;
mongoose = require('mongoose');
device = require('./api/models/deviceModel');
bodyParser = require('body-parser');

mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false')

app.use(bodyParser.urlencoded({extends: true}));
app.use(bodyParser.json());

var routes = require('./api/routes/deviceRoutes')
routes(app);

app.listen(3000, () => {
    console.log('App listening on port 3000!');
});