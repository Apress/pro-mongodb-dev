require 'mongo'
include Mongo

client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')

print "Database Connected to: "
db=client.database
print  db.name
print "\n"

print "Database Client: "
print  db.client
print "\n"

print "Database Options: "
print  db.options
print "\n"


print "Database Names: "
print  client.database_names
print "\n"


print "Database Info: " 
client.list_databases.each { |info| puts info.inspect }
print "\n"

print "Use Database mongo: "
client=client.use(:mongo)
print "\n"

print "Database Connected to: "
db=client.database
print  db.name
print "\n"


print "Database Names: "
print  client.database_names
print "\n"
  

print "Use Database mongo: "
client=client.use(:local)
print "\n"


print "Database Connected to: "
db=client.database
print  db.name
print "\n"
 
print db.drop

 
 

 