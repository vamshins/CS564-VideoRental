<html>
<link rel="stylesheet" type="text/css" href="styles.css">
<body>    
<?php
session_start();
if(isset($_SESSION["firstname"]))
{
 $first = $_SESSION["firstname"];
 $last = $_SESSION["lastname"];
 $custid = $_SESSION["custid"];
 $gend = $_SESSION["gend"];
}
else
{
   header("Location: error.html");
}
if ($gend == "M")
 {
    $salut = "Mr";
 }
 else {
     $salut = "Ms";
 }
 ?>
<div class="myheading">
Hello <strong style="color: brown"> <?php echo "$salut. $first $last"?></strong>
<br>
<strong>Please Select any opetration</strong>
</div>
<div class="mynavigation">
<ul>
  <li><a class="mylink" href="#home">Home</a></li>
  <li><a class="mylink" href="update.php">Update Profile</a></li>
  <li><a class="mylink" href="browse.php">Browse Movies</a></li>
  <li><a class="mylink" href="buy.php">Buy Moives</a></li>
</ul>
</div>
</body>