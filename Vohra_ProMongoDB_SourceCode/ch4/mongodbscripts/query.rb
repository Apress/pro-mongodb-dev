require 'mongo'
include Mongo

mongo_connection = MongoClient.new 
db=mongo_connection.db("local")
collection=db.create_collection("catalog")

document1={
  "catalogId" => 1,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Engineering as a Service",
  "author" =>  "David A. Kelly"
}
 
id1=collection.insert(document1)

document2={
  "catalogId" => 2,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Quintessential and Collaborative",
  "author" =>  "Tom Haunert"
}

documentArray=[document1,document2]
id2=collection.insert(document2)

##print collection.find("_id" => id2).to_a
##print "\n"
## print collection.find("catalogId" => 1).to_a

##print "\n"
## print collection.find({}, {:sort=>[['catalogId', 'desc']]}).to_a

##print "\n"
## puts collection.find("catalogId" => {"$gt" => 1, "$lte" => 2}).to_a
##print "\n"
## puts collection.find({"title" => /^E/}).to_a
##print "\n"
params = {'search' => 'Oracle Magazine'}
search_string = params['search']

puts collection.find({"journal" => Regexp.new(search_string)}).to_a
print "\n"
params = {'search' => 'November December 2013'}
search_string = params['search']

puts collection.find({"edition" => /#{search_string}/}).to_a
 