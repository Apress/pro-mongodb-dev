<?php
 
try 
{
$connection = new MongoClient(); 
$db=$connection->local;
$collection=$db->catalog;
var_dump($collection);
print '<br/>'; 
print 'Collection Name: '; 
var_dump($collection->getName());
print '<br/>';
$collection=$connection->local->mongo;
print 'Collection Name: '; 
var_dump($collection->getName());

}catch ( MongoConnectionException $e ) 
{
    echo '<p>Couldn\'t connect to mongodb, is the "mongo" process running?</p>';
    exit();
}

$collection->drop();

$coll = $db->createCollection(
    "catalog",
    array(
        'capped' => true,
        'size' => 1*1024,
        'max' => 10
    )
);
print '<br/>';
var_dump($coll);
print '<br/>';
print 'Collection Name: '; 
var_dump($coll->getName());
 
?>
