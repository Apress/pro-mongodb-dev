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

doc3 = {"catalogId" : 'catalog3', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'};

doc4 = {"catalogId" : 'catalog4', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'};

docArray=[doc1,doc2,doc3,doc4];


collection.insertMany(docArray, function(error, result){

if (error) 
         console.log(error);
else{
console.log("Documents added: "+result);
}
});

collection.find({},{skip:1, limit:2, fields:{edition:1,title:1,author:1}}).toArray(function(error,result) {
 if (error) console.log(error);
  else 
   console.log(result);
         
      });



}

});
}});
