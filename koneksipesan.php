<?php
class Koneksipesan
{
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $database = "tambahmenu";
    public $con;

public function __construct()
{
    $this->con = new mysqli($this->servername,
    $this->username, $this->password, $this->database);
    if (mysqli_connect_error()) {
        trigger_error("failed to connect to MySQL:".
        mysqli_connect_error());
    }else {
        return $this->con;
    }
}
public function insertData($post)
{
    $nama = $this->con->real_escape_string($_POST['nama']);
    $deskripsi = $this->con->real_escape_string($_POST['deskripsi']);
    $harga = $this->con->real_escape_string($_POST['harga']);
    
  
    $query="INSERT INTO pesan (nama, deskripsi, harga) VALUES ('$nama', '$deskripsi','$harga')";
    $sql = $this->con->query($query);
    if ($sql==true) {
        header("Location:index.php?msg1=insert");
        
    }else{
        echo "Registration failed try again!";
    }
}
    
    public function displayData()
    {
    $query = "SELECT * FROM pesan";
    $result = $this->con->query($query);
    if ($result->num_rows > 0) {
    $data = array();
    while ($row = $result->fetch_assoc()) {
    $data[] = $row;
    }
    return $data;
    }else{
        echo "No found records";
    }
}
}
?>
