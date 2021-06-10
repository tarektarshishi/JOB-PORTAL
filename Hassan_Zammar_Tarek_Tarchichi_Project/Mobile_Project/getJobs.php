<?php

$con=mysqli_connect("localhost","id15623369_hassan", "8]QlHXiD\{C~NWtt","id15623369_recruitmentdb");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

$sql = "select Company.CID, Company.Cname, Company.Email, Company.Cphone, Job.Jtitle, Job.Jdescription, Job.Jaddress
from Company
INNER JOIN Job on Company.CID = Job.C_ID";
if ($result = mysqli_query($con,$sql))
  {
   $emparray = array();
   while($row =mysqli_fetch_assoc($result))
       $emparray[] = $row;

  echo(json_encode($emparray));
  // Free result set
  mysqli_free_result($result);
  mysqli_close($con);
}

?> 	