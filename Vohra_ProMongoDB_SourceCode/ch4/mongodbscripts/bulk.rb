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

 
collection.bulk_write([ { :insert_one => { :catalogId => 5 }
                  },
                  { :update_one => { :find => { :catalogId => 1 },
                                     :update => {'$set' => { :catalogId => 6 } }
                                   }
                  },
                  { :replace_one => { :find => { :catalogId => 2 },
                                      :replacement => { :catalogId => 7 }
                                    }
                  }
                ],
                :ordered => true )
  