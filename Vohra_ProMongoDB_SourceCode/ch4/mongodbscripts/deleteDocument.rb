require 'mongo'
include Mongo


client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')
client=client.use(:local)
db=client.database
collection=db.collection("mongodb")
 

#collection.create

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


document3={
 
  "catalogId" => 3,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "",
  "author" =>  ""
}

document4={
 
  "catalogId" => 4,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing",
  "edition" =>  "November December 2013",
  "title" => "",
  "author" =>  ""
}
 
  collection.insert_many([document1,document2,document3,document4])
  
print "\n"
 
collection = client[:mongodb]


 
 
#print collection.find(:edition => 'November December 2013').delete_one
 
print "\n"

#print collection.find(:journal => 'Oracle Magazine').find_one_and_delete

print "\n"
 

print collection.find(:edition => 'November December 2013').delete_many

print "\n"