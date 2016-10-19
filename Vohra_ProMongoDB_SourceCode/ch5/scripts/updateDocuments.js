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
doc1 = {"catalogId" : 'catalog1',"title" : 'Engineering as a Service',"author" : 'David A. Kelly'};


doc2 = {"catalogId" : 'catalog2', "title" : 'Quintessential and Collaborative',"author" : 'Tom Haunert'};

collection.insertMany([doc1,doc2], function(error, result){

if (error) 
         console.log(error);
else{
console.log("Documents added: "+result);
}
});

 
 
collection.updateMany({}, {$set:{edition:'November December 2013', journal:'Oracle Magazine', publisher:'Oracle Publishing'}}, {upsert:true}, 
function(error, result) {
 if (error) console.log(error);
  else 
   console.log(result);
         
      });

 



}

});
}});
