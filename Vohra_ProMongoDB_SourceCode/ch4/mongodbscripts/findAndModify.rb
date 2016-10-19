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

 print id1 = collection.insert(document1)
document2={
  "catalogId" => "catalog2",
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Quintessential and Collaborative",
  "author" =>  "Tom Haunert"
}
 
 
print id2 = collection.insert(document2)
 
print "\n"
 print collection.find_and_modify({:query=>{"journal" => "Oracle Magazine"}, :update=>{"edition" => "11-12-2013"}, :new=>true})
 