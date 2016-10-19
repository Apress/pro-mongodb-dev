require 'mongo'
include Mongo

client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')
client=client.use(:local)
db=client.database
collection=db.collection("mongodb")
 

collection.create

for i in 1..10 do
catalogId="catalog"+i.to_s
  document={
  "catalogId" => catalogId,
  "journal" => "Oracle Magazine",
  "publisher" => "Oracle Publishing"
}

 collection.insert_one(document)
print "\n"
end
