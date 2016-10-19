<?php
 
try 
{


 
$connection = new MongoClient(); 

$collection=$connection->local->catalog;

$status=$collection->remove(array());
var_dump($status);
 

}catch (MongoConnectionException $e) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
} 

?>
