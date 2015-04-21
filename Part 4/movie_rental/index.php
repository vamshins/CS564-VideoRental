<html>
    <style type="text/css">
        .mytable
        {
    position:absolute;
    margin-left:-150px; /* half of width */
    margin-top:-150px;  /* half of height */
    top:50%;
    left:50%;
        }
    </style>
    <title>Welcome to Movie Rental Database</title>
    <body>
         <?php
         session_start();
         $status = '';
        if ($_SERVER["REQUEST_METHOD"] == "POST")
        {
            $email = $_POST['email_id'];
            $passwrd = $_POST['passwrd'];
            $con=mysql_connect("localhost","root","") or die("Not Connected");
            mysql_query("use movierental");
            
            if(isset($_POST['email_id']))
        {
            $sql="Select firstname,lastname,custid from customer where emailid='$email' and password=MD5('$passwrd')";
            $result = mysql_query($sql);
            if (mysql_numrows($result) > 0)
            {
                $row = mysql_fetch_assoc($result);
                $_SESSION["firstname"] = $row['firstname'];
                $_SESSION["lastname"] = $row['lastname'];
                $_SESSION["custid"] = $row['custid'];
                header("Location: home.php");
             // output data of each row
                //while($row = mysql_fetch_assoc($result)) {
                //    echo $row['firstname'];
                  //   }
                }
            else {
            $status = 'Login not successful ! Please check your email id or password !!' ;
                }
                }
        }
?>
        <center>
        <br><br><br><br>
        <u><h3 style="font-size:x-large;vertical-align: middle">Movie Rental Database System</h3></u>
        <strong style="color: red"><?php echo $status ?></strong>
        <div class="mytable">
        <h3>Login Here</h3>      
        <form action='index.php' method='post'>
        <table >
        <tr>
            <th>Email Id :</th>
            <td><input type="email" name="email_id" required placeholder="valid email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/></td>
        </tr>
        <tr>
            <th>Password :</th>
            <td><input type='password' name='passwrd' required placeholder="password"/></td>
        </tr>
        <tr style="text-align: center">
            <td colspan="2"><input type="submit" value="Submit"</td>
        </tr>
        <tr></tr>
        <tr style="text-align: center"><td colspan=2>New User ? <a href="register.php">Click Here</a></td></tr>
        </table>
        </form>
        </div>
    </center>    
    </body>
</html>