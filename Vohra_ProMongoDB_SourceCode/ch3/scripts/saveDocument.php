<?php
 

try 
{
$connection = new MongoClient(); 

$collection=$connection->local->catalog;
$doc1 = array("catalogId" => 'catalog1', "journal" => 'Oracle Magazine', "publisher" => 'Oracle 

Publishing', "edition" => 'November December 2013',"title" => 'Engineering as a 

Service',"author" => 'David A. Kelly');
$status=$collection->insert($doc1);
var_dump($status);
print '<br/>';
$doc2 =array("catalogId" => 'catalog2', "journal" => 'Oracle Magazine', "publisher" => 'Oracle Publishing', "edition" => 'November December 2013',"title" => 'Quintessential and Collaborative',"author" => 'Tom Haunert');
$status=$collection->insert($doc2);
var_dump($status);
print '<br/>';
$doc1['edition']= '11-12-2013';
$doc1['author'] = 'Kelly, David A.';
$doc1['updated']=true;

$status=$collection->save($doc1);
var_dump($status);
print '<br/>';

$doc2['edition']='11-12-2013';
$doc2['author'] = 'Haunert, Tom';
$doc2['updated']=true;

$status=$collection->save($doc2);
var_dump($status);
print '<br/>';

}catch ( MongoConnectionException $e ) 
{
    echo '<p>Couldn\'t connect to mongodb</p>';
    exit();
}catch(MongoCursorException $e) {
 echo '<p>w option is set and the write has failed</p>';
    exit();

}

?>
