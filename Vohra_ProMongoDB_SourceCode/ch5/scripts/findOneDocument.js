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

 doc1 = {"catalogId" : 'catalog1', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013',"title" : 'Engineering as a Service',"author" : 'David A. Kelly'};


doc2 = {"catalogId" : 'catalog2', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013',"title" : 'Quintessential and Collaborative',"author" : 'Tom Haunert'};

collection.insertMany([doc1,doc2], function(error, result){

if (error) 
         console.log(error);
else{
console.log("Documents added: "+result);
}
});

collection.findOne({journal:'Oracle Magazine'}, {fields:{edition:1,title:1,author:1}, skip:1}, 
function(error, result) {
 if (error) console.log(error.message);
  else 
   console.log(result);
      });

}

});
}});
