require 'mongo'
include Mongo

mongo_connection = MongoClient.new 
db=mongo_connection.db("local")
collection=db.create_collection("catalog")

document1={
  "catalogId" => "catalog1",
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Engineering as a Service",
  "author" =>  "David A. Kelly"
}
 
document2={
  "catalogId" => "catalog2",
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Quintessential and Collaborative",
  "author" =>  "Tom Haunert"
}

documentArray=[document1,document2]
 collection.insert(documentArray)
 
 collection.find({"journal" => "Oracle Magazine"}, :fields=>{:edition=>0,:title=>0,:author=>0}).each { |document| puts document.inspect}

Ascending direction is specified with Mongo::ASCENDING or:ascending or :asc and descending direction with   Mongo::DESCENDING or :descending or :desc

 
 