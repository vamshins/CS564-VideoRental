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
 $movie_id = $_GET['movie_id'];
   $con=mysqli_connect("localhost","root","") or die("Not Connected");
   mysqli_query($con,"use movierental");
   $sql = "Select
           mov.title as title,
           mov.director as director,
           mov.production_company as production,
           mov.genre_name as genre,
           ex.exemplar_name as exemplar,
           med.medium_type as medium_name,
           m.price_per_day as price,
           m.availability_status as availability,
           m.offered_id as offerid
           from moviesoffered m
           INNER JOIN medium med on m.medium_id = med.medium_id
           INNER JOIN (Select movie_id,title,director,production_company,name as genre_name from movie,genre where movie.genre_id = genre.genre_id) mov on mov.movie_id = m.movie_id
           INNER JOIN exemplar ex on ex.exemplar_id = m.exemplar_id
           where m.movie_id='$movie_id'";
   $result = mysqli_query($con,$sql);
   echo '<div class="myresult">';
   while($row = mysqli_fetch_assoc($result))
   {
   echo '<table class="TFtable" align="center"><th colspan="2">Movie Information</th>';
   echo "<tr><th>Moive Name :</th><td>" .$row['title']. "</td></tr>";
   echo "<tr><th>Director Name :</th><td>" .$row['director']. "</td></tr>";
   echo "<tr><th>Production Name :</th><td>" .$row['production']. "</td></tr>";
   echo "<tr><th>Moive Name :</th><td>" .$row['genre']. "</td></tr>";
   echo "<tr><th>Exemplar Name :</th><td>" .$row['exemplar']. "</td></tr>";
   echo "<tr><th>Medium :</th><td>" .$row['medium_name']. "</td></tr>";
   echo "<tr><th>Exemplar Name :</th><td>" .$row['exemplar']. "</td></tr>";
   echo "<tr><th>Price :</th><td>" .$row['price']. "</td></tr>";
   echo "<tr><th>Offer Id :</th><td>" .$row['offerid']. "</td></tr>";
   if($row['availability'] == 'Y')
   {
     echo '<form action="buy.php" method="GET"><input type="hidden" name="offerid" value='.$row['offerid'].'/>';
     echo '<tr><td colspan ="2" align ="center"><input type="submit" value="Buy"/></form></table>';
   }
   else { echo '<tr><td colspan ="2" align ="center"><input type="submit" disabled value="Buy"/></table><br>';}
   }
   echo "</div>";
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
  <li><a class="mylink" href="browse.php">Browse Movies</a></li>
  <li><a class="mylink" href="buy.php">Buy Moives</a></li>
</ul>
</div>
</body>