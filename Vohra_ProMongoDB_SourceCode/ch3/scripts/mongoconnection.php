<?php
$connection = new MongoClient(); // connects to localhost:27017
 print 'Connection: <br/>'; 
var_dump($connection);
print '<br/>'; 
 print 'Write Concern: <br/>'; 
var_dump($connection->getWriteConcern());
print '<br/>';
$connection = new MongoClient( "mongodb://localhost:27017" );  
 print 'Read Preferences: <br/>'; 
var_dump($connection->getReadPreference());
print '<br/>';
 print 'List DBs: <br/>'; 
var_dump($connection->listDBs());
print '<br/>';
$connection = new MongoClient("mongodb://192.168.1.72:27017");
 print 'List Open Connections: <br/>'; 
var_dump($connection->getConnections()); 
print '<br/>'; 
$connection->close(true);
 print 'List Open Connections: <br/>'; 
var_dump($connection->getConnections());
?>
