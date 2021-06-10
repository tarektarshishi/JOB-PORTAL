<?php
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

  if(isset($C_ID) and isset($Jtitle) and isset($Jdescription) and isset($Jaddress) ){
    $sql = "UPDATE Job SET Jtitle ='$Jtitle', Jdescription ='$Jdescription', Jaddress ='$Jaddress' WHERE C_ID = '$C_ID'";
  }
  
  else{
    echo "Please fill the blanks";
  }
  
  mysqli_query($con,$sql) or
      die ("Can't update record");
  
  echo "Record Updated";
   
mysqli_close($con);
?> 		