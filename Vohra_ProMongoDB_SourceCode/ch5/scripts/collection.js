MongoClient = require('mongodb').MongoClient;
Server = require('mongodb').Server;
Db = require('mongodb').Db;

  

var db = new Db('local', new Server('localhost', 27017));

db.open(function(error, db) {
 if (error) 
         console.log(error);

db.collections(function(error, collections){
if (error) 
         console.log(error);
else{
console.log("Collections in database local");
console.log(collections);
}
});

db.collection('mongodb', function(error, collection){
if (error) 
         console.log(error);
else{
console.log("Got collection from local database, collection name: "+collection.collectionName);
 


collection.isCapped(function(error, result){
console.log("Is collection capped?: " +result);
 
});

collection.count(function(error, result){
console.log("Document count in the collection: "+result);

});

 }

});
 

db.createCollection('mongo', function(error, collection){
if (error) 
         console.log(error);
else{
console.log("Collection created. Collection name: "+collection.collectionName); }
});

db.renameCollection('mongodb', 'mongocoll', function(error, collection){
if (error) 
         console.log(error);
else{
console.log("Collection renamed: "+collection.collectionName);
 
}

});


db.dropCollection('mongocoll', function(error, result){
if (error) 
         console.log(error);
else{
console.log("Collection mongocoll dropped: "+result);
 

}

});

 
});


  
