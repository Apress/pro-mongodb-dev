require "mongo_mapper"

class Catalog
  include MongoMapper::Document
   
MongoMapper.connection = Mongo::Connection.new('localhost', 27017)
MongoMapper.database = "local"

  key :catalogId, String
  key :journal, String
  key :publisher, String
  key :edition, String
  key :title, String
  key :author, String
 
end
 
 
 
catalog = Catalog.create({
  :catalogId => 'catalog1',
  :journal => 'Oracle Magazine',
  :publisher => 'Oracle Publishing',
  :edition => 'November December 2013',
  :title => 'Engineering as a Service',
  :author => 'David A. Kelly'
})
 
catalog.save

catalog = Catalog.create({
  :catalogId => 'catalog2',
  :journal => 'Oracle Magazine',
  :publisher => 'Oracle Publishing',
  :edition => 'November December 2013',
  :title => 'Quintessential and Collaborative',
  :author => 'Tom Haunert'
})
 
catalog.save
 
##print Catalog.find(:first)
print "\n"
##print Catalog.find(:all)
 