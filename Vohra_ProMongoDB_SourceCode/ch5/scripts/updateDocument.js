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

 doc1 = {"catalogId" : 1, "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'};


doc2 = {"catalogId" : 2, "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'};

collection.insertMany([doc1,doc2], function(error, result){

if (error) 
         console.log(error);
else{
console.log("Documents added: "+result);
}
});

collection.findOneAndUpdate({journal:'Java Magazine'}
      , {$set: {journal:'Java Magazine'}}
      , {returnOriginal: false
          ,upsert: true
        }
      , function(error, result) {
 if (error) console.log(error);
  else 
   console.log(result);
         
      });
 
collection.update({journal:'Oracle Magazine'}, {$set:{edition:'11-12-2013', title:'Engineering as a Service', author:'David A. Kelly'}}, {upsert:true}, 
function(error, result) {
 if (error) console.log(error);
  else 
   console.log(result);
         
      });

 



}

});
}});
