<?php
$CID = addslashes(strip_tags($_POST['CID']));
$C_ID = addslashes(strip_tags($_POST['C_ID']));
$key = addslashes(strip_tags($_POST['key']));

if ($key != "cuBubcDE")
    die("access denied"); 
$con=mysqli_connect("localhost","id15623369_hassan", "8]QlHXiD\{C~NWtt","id15623369_recruitmentdb");

if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

$sql1 = "DELETE FROM Job WHERE C_ID = $C_ID;";
$sql2 = "DELETE FROM Company WHERE CID = $CID";

mysqli_query($con,$sql1);
mysqli_query($con,$sql2);

if (mysqli_affected_rows($con) > 0)
    echo "Record Removed";
else
    echo ("can't remove record");
   
mysqli_close($con);
?> 			