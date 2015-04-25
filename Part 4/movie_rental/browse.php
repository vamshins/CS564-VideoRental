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

if ($_SERVER["REQUEST_METHOD"] == "POST")
 {
   $movie = $_POST['movie_name'];
   $con=mysqli_connect("localhost","root","") or die("Not Connected");
   mysqli_query($con,"use movierental");
   $sql = sprintf("Select title,movie_id FROM movie where title LIKE '%s%%'",
               mysql_real_escape_string($movie));
   $result = mysqli_query($con,$sql);
   if(mysqli_num_rows($result) > 0)
   {
   echo '<div class="myresult"><table class="TFtable" align="center"><th colspan="2">Movie Name</th>';
   while($row = mysqli_fetch_assoc($result))
   {
     $movie_id = $row['movie_id'];
     $title = $row['title'];
     $link = "about.php?movie_id=$movie_id";
     echo '<tr><td>';
     echo "<a href='$link'>$title</a>";
     echo '</td></tr>';
   }
   echo '</table></div>';
   }
   else
   {
     echo '<div class="myresult">No results. Please Search again</div>';
   }
 
 }
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
  <li><a class="mylink" href="home.php">Home</a></li>
  <li><a class="mylink" href="update.php">Update Profile</a></li>
  <li><a class="mylink" href="#browse">Browse Movies</a></li>
  <li><a class="mylink" href="buy.php">Buy Moives</a></li>
</ul>
</div>
<div class="mytable">
<form action="browse.php" method="post">
    <table>
     <tr>
      <td><input type="text" required name="movie_name" placeholder="Search Movie"/></td>
      <td><input type="submit" value="Search"/></td>
     </tr>
    </table>
</form>
</body>
</html>