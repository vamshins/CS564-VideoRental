<html>
    <style type="text/css">
    .mytable
        {
    position:relative;
    margin-left:-150px; /* half of width */
    margin-top:-150px;  /* half of height */
    top:50%;
    left:50%;
        }
    </style>
<body>    
<?php
session_start();
 $first = $_SESSION["firstname"];
 $last = $_SESSION["lastname"];
 $custid = $_SESSION["custid"];
 ?>
 <div class="myTable" style="alignment-adjust: central">
<strong><?php echo "Hello Mr.$first $last CustiD = $custid";?></strong>
<strong>Please check your order status here</strong>
</div>
</body>