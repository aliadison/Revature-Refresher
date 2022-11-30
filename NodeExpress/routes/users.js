var express = require('express');
var router = express.Router();
  var users = [
    { name: 'tobi' }
    , { name: 'loki' }
    , { name: 'jane' }
  ];
/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send(users);
});

module.exports = router;
