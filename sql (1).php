<?php
require("php_conn.php");
//$sub=$_POST["button"];
  $lan= $_GET['sem'];
//$lan=json_decode($_POST['elements']);
//echo $lan;
$token=strtok ($lan,",");
$count=0;
$n=0;
while ($token !== false){
    $count=1;
    $n=1;
echo "$token<br />";
$token = strtok(",");
//mysql_query("INSERT INTO mytable VALUES('$token',1)");
$ret=mysqli_query($connect,"SELECT * FROM mytable");
if(mysqli_num_rows($ret) > 0)
{
while($row = mysql_fetch_assoc($ret)>0)
{
    $ch=$row["name1"];
    $n=$row["rno"];
    if($token==$ch){
        $n++;
        mysqli_query($connect,"UPDATE mytable SET rno='$n' WHERE name1='$ch'");
        $count++;
    }
}
echo $count;
}
if($count==1){
    mysqli_query($connect,"INSERT INTO mytable VALUES('$token',1)");
}
}

//$subject1=mysql_query("INSERT INTO mytable VALUES($token,1)");
//while ($row = mysql_fetch_array($subject1,MYSQL_ASSOC))
   // echo $row['subject'];
/*$row = mysql_fetch_array($subject1,MYSQL_ASSOC);
echo $row['name1'];  
/*if(!strcmp($lan,$row['subject']))
{
    echo $lan;
}
//$sem3= $_GET['sem'];
//echo $sem3; 
/*$sem1=mysql_query("SELECT sem FROM structure where id=1");
while ($row1 = mysql_fetch_array($sem1,MYSQL_ASSOC))
    echo $row1['sem'];
    
if(strcmp($sem,$row1['sem']))
{
    echo($sem);
}

$write=mysql_query("INSERT INTO structure VALUES(1,'C',1)");*/
?>