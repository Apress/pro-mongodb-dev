Server = require('mongodb').Server;
Db = require('mongodb').Db;
Collection = require('mongodb').Collection;

var db = new Db('local', new Server('localhost', 27017));

db.open(function(error, db) {
 if (error) 
         console.log(error);
else{
db.createCollection('catalog', function(error, collection){

if (error) 
         console.log(error);
else{

 doc1 = {"catalogId" : 1, "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 11122013,"title" : 'Engineering as a Service',"author" : 'David A. Kelly'};

doc2 = {"catalogId" : 2, "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 11122013,"title" : 'Quintessential and Collaborative',"author" : 'Tom Haunert'};


collection.insertMany([doc1,doc2], function(error, result){

if (error) 
         console.log(error);
else{
console.log("Documents added: "+result);
}
});

collection.findAndRemove({journal:'Oracle Magazine'}, [['catalogId', 'ascending']], {w:1}, function(error, result) {
               if (error) console.log(error);
else
console.log(result);
            })



}

});
}});
