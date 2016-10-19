<?php
 
try 
{
$connection = new MongoClient(); 
$collection=$connection->local->catalog;
$criteria = array("_id" => new MongoId("53f3d425098c6e2410000065"));

$new_object = array("catalogId" => 'catalog1', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => '11-12-2013',"title" => 'Engineering As a Service',"author" => 'Kelly, David A.', "updated"=>true);

$status=$collection->update($criteria,$new_object, array("upsert" => false));

var_dump($status);
print '<br/>';
$criteria = array("_id" => new MongoId("53f3d425098c6e2410000066"));

$new_object = array("catalogId" => 'catalog2', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => '11-12-2013',"title" => 'Quintessential and Collaborative',"author" => 'Haunert, Tom', "updated"=>true);

$status=$collection->update($criteria,$new_object, array("upsert" => false));
var_dump($status);
print '<br/>';

$criteria = array("_id" => new MongoId("53f3d425098c6e2410000064"));

$new_object = array("catalogId" => 'catalog3', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => '11-12-2013');

$status=$collection->update($criteria,$new_object, array("upsert" => true));
var_dump($status);

}catch ( MongoConnectionException $e ) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo '<p>w option is set and the write has failed</p>';
    exit();

}
?>

