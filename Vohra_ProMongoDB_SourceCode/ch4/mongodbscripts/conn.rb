require 'mongo'
include Mongo
mongo_connection =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test')
mongo_connection =Mongo::Client.new([ '127.0.0.1:27017' ], :database => 'test', :connect => :direct)
mongo_connection =Mongo::Client.new('mongodb://127.0.0.1:27017/test')