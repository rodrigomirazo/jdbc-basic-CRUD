# jdbc-basic-CRUD

## Creating a CRUD API for mysql tables

<p>In real life we usually cover Business necessities to solve entity management.<br><br>
    Example: I want to:
    <br> - view my user contact list
    <br> - create new users
    <br> - delete users
</p>

#### what is a CRUD API?
<p> CRUD stands for: CReate, Update & Delete</p>
<p>A CRUD API in java means we are able to process 
   Select, Insert, Update and Delete SQL operations, to encapsulate functionality </p>

### TOP 4 components for CRUD API

##### 1. Connector
    Connect/Disconnect to Database
##### 2. Get
    Select * from statement
##### 3. Update
    Update SET statement
##### 4. Delete
    Delete Statement

## Steps to create a connector


#### 1. Load the driver Class

    Class.forName("com.mysql.cj.jdbc.Driver");

#### 2. create  the connection object
    
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root12345");
    
#### 3. create a close connector
    
    con.close();

## Get Method

#### 1. Declare Empty list of Entities (Persons, Clients)
    List<Person> personList = new ArrayList<>();
    
#### 2. Create the statement object
    Statement stmt = con.createStatement();
    
#### 3. Prepare your select Statement
    String select = "SELECT * FROM trainee_schema.trainee_user";
    
#### 4. execute select query
    ResultSet rs = stmt.executeQuery(select);
    while(rs.next()) {
        personList.add(  new Person(...)  );
    }

## Create Method

#### 1. Create a statement
    Statement stmt = con.createStatement();

#### 2. Create a statement
    String insert = " INSERT INTO `trainee_schema`.`trainee_user` (`username`, `name`, `lastname`) ... ";

#### 3. Create a statement
    int result = stmt.executeUpdate(insert);
    
## Delete Method

#### 1. Create a statement
    Statement stmt = con.createStatement();

#### 2. Create a statement
    String delete = " DELETE FROM `trainee_schema`.`trainee_user` WHERE (`id` = '"+id+"'); ";

#### 3. Create a statement
    int result = stmt.executeUpdate(delete);
