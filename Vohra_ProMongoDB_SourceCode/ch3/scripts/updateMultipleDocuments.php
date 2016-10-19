<?php
 
try 
{

 
 
$connection = new MongoClient(); 
$collection=$connection->local->catalog;

$collection->insert(array("catalogId" => 'catalog1', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013',"title" => 'Engineering as a Service',"author" => 'David A. Kelly'));

$collection->insert(array("catalogId" => 'catalog2', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013',"title" => 'Quintessential and Collaborative',"author" => 'Tom Haunert'));

$newdata = array('$set' => array("journal" => "Oracle Magazine"));
$status=$collection->update(array("edition" => "November December 2013"), $newdata,array("multiple" => true));

var_dump($status);

}

catch (MongoConnectionException $e) 

{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo $e;
    exit();

}

?>
