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

 
 collection.bulkWrite([
      { insertOne: { document: {"catalogId" : 'catalog1', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013',"title" : 'Engineering as a Service',"author" : 'David A. Kelly'} } }, 

{ insertOne: { document: {"catalogId" : 'catalog2', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013',"title" : 'Quintessential and Collaborative',"author" : 'Tom Haunert'} } },

{ insertOne: { document: {"catalogId" : 'catalog3', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'} } }, 

{ insertOne: { document: {"catalogId" : 'catalog4', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'} } }
    , { updateOne: { filter: {journal:'Oracle Magazine'}, update: {$set: {journal:'OracleMagazine'}}, upsert:true } }
    , { updateMany: { filter: {edition:'November December 2013'}, update: {$set: {edition:'11-12-2013'}}, upsert:true } }
    , { deleteOne: { filter: {journal:'Oracle Magazine'} } }
    , { replaceOne: { filter: {catalogId:'catalog5'}, replacement: {"catalogId" : 'catalog5', "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013'}, upsert:true}}]
  , {ordered:true, w:1}, function(error, result){

if (error) 
      console.log(error);
else{
console.log("Documents added: "+result);
}
});


}

});
}});
