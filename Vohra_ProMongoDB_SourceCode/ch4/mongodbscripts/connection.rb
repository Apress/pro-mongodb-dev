require 'mongo'
include Mongo

 
#client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')
#client =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test', :connect => :direct)
#client =Mongo::Client.new('mongodb://127.0.0.1:27017/test')
client = Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test', :max_pool_size => 20, :connection_timeout => 60)

print "Cluster: "
print  client.cluster
print "\n"
 
print "Configuration Options: "
print  client.options
print "\n"  
print "Read Preference: "
print  client.read_preference
print "\n" 
print "Write Concern : "
print client.write_concern
print "\n"  
   