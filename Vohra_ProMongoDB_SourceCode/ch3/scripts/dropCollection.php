<?php
 
try 
{
$connection = new MongoClient(); 
$collection=$connection->local->catalog;
  
$collection->drop();
echo '<p>Collection Dropped</p>';

}catch (MongoConnectionException $e) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
} 
 

?>
