<?php

// Create connection
$connect = mysql_connect("localhost", "root");

// Check connection
if (!$connect) {
    die("Connection failed: " . mysqli_connect_error());
}
mysql_select_db("mydb") or die(mysql_error());
echo "Connected successfully";
?>