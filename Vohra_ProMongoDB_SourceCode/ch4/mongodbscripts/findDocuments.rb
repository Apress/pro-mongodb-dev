require 'mongo'
include Mongo


client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')
client=client.use(:local)
db=client.database
collection=db.collection("mongodb")
 

collection.create

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
 
  collection.insert_many([document1,document2])
  
   collection.find().each do |document|
      print document
   end

collection.find(:journal => 'Oracle Magazine').limit(5).each do |document|
      print document
   end
 

print "Number of documents with edition  November December 2013: "
print "\n"
print collection.find(:edition => 'November December 2013').count
print "\n"
print "Number of distinct documents by catalogId: "
print "\n"
print collection.find.distinct(:catalogId)
  
 
 