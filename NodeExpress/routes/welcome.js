var express = require('express');
var router = express.Router();


router.get('/', function(req, res, next) {
    var myName = req.query.name;
    // res.send('Your Text:' + myName); 
  res.render('welcome', { username: myName });
});


module.exports = router;
