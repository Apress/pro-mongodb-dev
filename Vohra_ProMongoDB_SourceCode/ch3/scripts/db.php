<?php
 
try 
{
$connection = new MongoClient(); 

$db = $connection->test;
print 'Datbase: '; 
var_dump($db);
print '<br/>'; 
$db=$connection->selectDB("local");
$collections=$db->getCollectionNames(true);
print 'Collections: '; 
var_dump($collections);
print '<br/>'; 
}catch ( MongoConnectionException $e ) 
{
    echo '<p>Couldn\'t connect to mongodb, is the "mongo" process running?</p>';
    exit();
}
?>
