<?php
 
try 
{
$connection = new MongoClient(); 

 
$collection=$connection->local->catalog;
 
print 'Number of Documents: ';
var_dump($collection->count());
print '<br/>';

$cursor = $collection->find();
var_dump(iterator_to_array($cursor));
print '<br/>';

foreach ($cursor as $doc) {
     var_dump($doc["_id"]);
print '<br/>';
var_dump($doc["info"]["catalogId"]);
print '<br/>';
var_dump($doc["info"]["journal"]);
print '<br/>';
var_dump($doc["info"]["publisher"]);
print '<br/>';
var_dump($doc["info"]["edition"]);
print '<br/>';
var_dump($doc["info"]["title"]);
print '<br/>';
var_dump($doc["info"]["author"]);
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
