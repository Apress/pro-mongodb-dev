Db = require('mongodb').Db;
Server = require('mongodb').Server;
Mongos = require('mongodb').Mongos;
 
var mongos = new Mongos([
    new Server("localhost", 50000),
    new Server("localhost", 27017)
  ]);

var db = new Db('local', mongos);

//var db = new Db('local', new Server('localhost', 27017));

db.open(function(error, db) {
 if (error) 
         console.log(err);
db.listCollections().toArray(function(error, items) {
        console.log(items);
        db.close();
      });
 
});


 

/*
 mongoclient.connect("mongodb://localhost:27017/local", function(error, db) {

 
     if (error) 
         console.log(error);
     else 
         console.log('Connected with MongoDB');
 
db.listCollections().toArray(function(err, items) {
        console.log(items);
        db.close();
      });

});
*/
