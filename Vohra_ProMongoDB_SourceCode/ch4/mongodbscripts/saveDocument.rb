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

 

print id = collection.insert(document1)
print "\n"
document1={
  "_id" => id,
  "catalogId" => "catalog2",
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Quintessential and Collaborative",
  "author" =>  "Tom Haunert"
}


print id = collection.save(document1)
