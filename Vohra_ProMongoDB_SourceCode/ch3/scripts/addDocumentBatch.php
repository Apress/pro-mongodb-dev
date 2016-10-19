<?php
 
try 
{
$connection = new MongoClient(); 

$collection=$connection->local->catalog;

$batch=array();
$doc1 = array(
    "name" => "MongoDB",
    "type" => "database",
    "count" => 1,
    "info" => (object)array("catalogId" => 'catalog1', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013',"title" => 'Engineering as a Service',"author" => 'David A. Kelly')
);

$batch[]=$doc1;

$doc2 = array(
    "name" => "MongoDB",
    "type" => "database",
    "count" => 1,
    "info" => (object)array("catalogId" => 'catalog2', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013',"title" => 'Quintessential and Collaborative',"author" => 'Tom Haunert')
);

$batch[]=$doc2;

$status=$collection->batchInsert($batch);
var_dump($status);
print '<br/>';
foreach ($batch as $doc) {
print 'Document _id: ';
  echo $doc['_id']."\n";  
print '<br/>';
}

}catch ( MongoConnectionException $e ) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo '<p>w option is set and the write has failed</p>';
    exit();

}


?>
