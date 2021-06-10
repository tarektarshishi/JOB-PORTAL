<?php
$CID = addslashes(strip_tags($_POST['CID']));
$Cname = addslashes(strip_tags($_POST['Cname']));
$Email = addslashes(strip_tags($_POST['Email']));
$Cphone = addslashes(strip_tags($_POST['Cphone']));
$Jtitle = addslashes(strip_tags($_POST['Jtitle']));
$Jdescription = addslashes(strip_tags($_POST['Jdescription']));
$Jaddress = addslashes(strip_tags($_POST['Jaddress']));
$C_ID = addslashes(strip_tags($_POST['C_ID']));
$key = addslashes(strip_tags($_POST['key']));

if ($key != "cuBubcDE")
    die("access denied");

$con=mysqli_connect("localhost","id15623369_hassan", "8]QlHXiD\{C~NWtt","id15623369_recruitmentdb");
// Check connection
if (mysqli_connect_errno())
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

if(isset($CID) and isset($Cname) and isset($Email) and isset($Cphone) and isset($Jtitle) and isset($Jdescription) and isset($Jaddress) and isset($C_ID)){
    $sql1 = "INSERT INTO Company VALUES ('$CID', '$Cname', '$Email', '$Cphone');";
    $sql2 = "INSERT INTO Job(Jtitle, Jdescription, Jaddress, C_ID, Posted_On) VALUES ('$Jtitle', '$Jdescription', '$Jaddress', '$C_ID', SYSDATE());"; 
}
 
mysqli_query($con,$sql1) or
    die ("can't add record");

echo ""; 

mysqli_query($con,$sql2) or
    die ("Can't add record");

echo "Record Added"; 
   
mysqli_close($con);
?> 			