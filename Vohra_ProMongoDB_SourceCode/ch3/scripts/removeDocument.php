<?php
 
try 
{


$id = '55bba8d9098c6e1c19000049';
$connection = new MongoClient(); 

$collection=$connection->local->catalog;

$status=$collection->remove(array('_id' => new MongoId($id)));
var_dump($status);
 

}catch (MongoConnectionException $e) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
} 

?>
