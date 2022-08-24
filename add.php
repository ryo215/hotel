<?php

include 'customers.php';

$customerObj = new Customers();

if(isset($_POST['submit'])) {
    $customerObj->insertData($_POST);
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DE.HOTEL</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
</head>
<body>

<div class="card text-center" style="padding:15px;">
    <h4>DE.HOTEL</h4>
</div><br/>

<div class="container">
    <form action="add.php" method="POST">
        <div class="form-group">
            <label for="name">Id:</label>
            <input type="text" class="form-control" name="name"
            placeholder="Masukkan Id" required=""/>
        </div>
        <div class="form-group">
            <label for="email">Nama:</label>
            <input type="text" class="form-control" name="email"
            placeholder="Masukkan Nama" required=""/>
        </div>
        <div class="form-group">
            <label for="username">Nomor Telepon:</label>
            <input type="text" class="form-control" name="username"
            placeholder="Masukkan Nomor Telepon" required=""/>
         </div>
         <div class="form-group">
             
        <input type="submit" name="submit" class="btn btn-primary"
        style="float:right;" value="Submit"/>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
