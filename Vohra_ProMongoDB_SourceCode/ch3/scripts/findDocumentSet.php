<?php
 
try 
{
$connection = new MongoClient(); 
$collection=$connection->local->catalog;
//$query = array();
$query = array('catalogId'=>'catalog1');
$fields = array('title' => true, 'author' => true); 
$cursor = $collection->find($query, $fields);


while ($cursor->hasNext())
{
    var_dump($cursor->getNext());
}

}catch (MongoConnectionException $e) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo $e;
    exit();

}

?>
