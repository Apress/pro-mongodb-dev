require 'mongo'
include Mongo


client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')
client=client.use(:local)
db=client.database
collection=db.collection("mongodb")
 

collection.create

document1={
  
  "catalogId" => 1,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Engineering as a Service",
  "author" =>  "David A. Kelly"
}

 
  

document2={
 
  "catalogId" => 2,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "Quintessential and Collaborative",
  "author" =>  "Tom Haunert"
}
 
  collection.insert_many([document1,document2])
  
print "\n"
 
collection = client[:mongodb]


 
 
document = collection.find(:edition => 'November December 2013').find_one_and_update('$set' => {:edition=>'11-12-2013'})
print "Document before being updated: "
print "\n"
print document
print "\n"
