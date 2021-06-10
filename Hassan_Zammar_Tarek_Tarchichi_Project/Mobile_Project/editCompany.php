<?php
$CID = addslashes(strip_tags($_POST['CID']));
$Cname = addslashes(strip_tags($_POST['Cname']));
$Email = addslashes(strip_tags($_POST['Email']));
$Cphone = addslashes(strip_tags($_POST['Cphone']));
$key = addslashes(strip_tags($_POST['key']));

if ($key != "cuBubcDE")
    die("access denied");

$con=mysqli_connect("localhost","id15623369_hassan", "8]QlHXiD\{C~NWtt","id15623369_recruitmentdb");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

if(isset($CID) and isset($Cname) and isset($Email) and isset($Cphone) ){
  $sql = "UPDATE Company SET Cname ='$Cname', Email ='$Email', Cphone ='$Cphone' WHERE CID = '$CID'";
}

else{
  echo "Please fill the blanks";
}

mysqli_query($con,$sql) or
    die ("Can't update record");

echo "Record Updated";
   
mysqli_close($con);
?> 		