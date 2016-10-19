<?php
 
try 
{
$connection = new MongoClient(); 
$collection=$connection->local->catalog;

for ($i = 1; $i <= 5; $i++)
{
    $status=$collection->insert(array("catalogId" =>'catalog'.$i, "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013'));
var_dump($status);
print '<br/>';
}


}catch (MongoConnectionException $e) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo '<p>w option is set and the write has failed</p>';
    exit();

}

 
 
?>
