require 'mongo'
include Mongo


client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')


print "Use Database local: "
client=client.use(:local)
print "\n"


print "Database Connected to: "
db=client.database
print  db.name
print "\n"


print "Collection Names: "
print db.collection_names({})
print "\n"



print "Collections List: " 
db.list_collections.each { |info| puts info.inspect }
print "\n"




print "Collections Array: " 
db.collections.each { |info| puts info.inspect }
print "\n"
 


collection=db[:users]


print "Collection name: "
print collection.name
print "\n"


print "Collection Database: "
print collection.database
print "\n"

print "Collection options: "
print collection.options
print "\n"

print "Capped: "
print collection.capped?
print "\n"

print "Namespace: "
print collection.namespace
print "\n"

## Does not create a collection till the collection is accessed.
collection=db.collection("mongodb")
print "Collection Names: "
print db.collection_names({})
print "\n"
 
collection.create
print "Collection Names: "
print db.collection_names({})
print "\n"
 


print "Drop collection mongodb "
print "\n"
collection.drop
print "Collection Names: "
print db.collection_names
print "\n"

