<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<?php
if(isset($_SESSION["firstname"])) {
session_start();
 $first = $_SESSION["firstname"];
 $last = $_SESSION["lastname"];
 $custid = $_SESSION["custid"];
 $gend = $_SESSION["gend"];
}
 ?>
 
<div class="mycontent">
<ul>
  <li><a href="#home">Home</a></li>
  <li><a href="#news">Update Profile</a></li>
  <li><a href="#contact">My Rated Movies</a></li>
  <li><a href="#about">Buy Moives</a></li>
</ul>
</div>

<strong class="myheading">Hello Jeevan</strong>

<div class="mytable">
    <table class="TFtable">
	<tr><td>Text</td><td>Text</td><td>Text</td></tr>
	<tr><td>Text</td><td>Text</td><td>Text</td></tr>
	<tr><td>Text</td><td>Text</td><td>Text</td></tr>
	<tr><td>Text</td><td>Text</td><td>Text</td></tr>
</table>

</div>
</body>
</html>
