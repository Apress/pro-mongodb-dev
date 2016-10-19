<?php
 
try 
{
$connection = new MongoClient(); 

$collection=$connection->local->catalog;
$doc = array(
    "name" => "MongoDB",
    "type" => "database",
    "count" => 1,
    "info" => (object)array("catalogId" => 'catalog1', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013',"title" => 'Engineering as a Service',"author" => 'David A. Kelly')
);
$status=$collection->insert($doc);
var_dump($status);
print '<br/>';
 
$status=$collection->insert($doc);
}catch ( MongoConnectionException $e ) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo '<p>w option is set and the write has failed</p>';
    exit();

}
?>
