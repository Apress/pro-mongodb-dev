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

print ids = collection.insert([document1,document2])

print "\n"



print collection.update({"journal" => "Oracle Magazine"}, {"$set" => {"edition" => "11-12-2013"}}, :multi=>true)
 
