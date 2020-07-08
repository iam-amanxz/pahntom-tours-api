# Phantom Tours Spring boot API

**Spring boot API appliaction of Group-C for SOFTWARE SYSTEMS DEVELOPMENT (BCC608), Sothamption Solent University**
[API Documentation](https://solent-ssd-group-c.github.io/api_docs/)

>
### Group Members
**Husnul Aman-14883830 |**
**Jareer Zeenam-14883881 |**
**Emaadh Careem-14889641 |**
**Puvanendrarajah Vinushiya-14883813 |**
**Thilagshana Thilakarasa-14883708**

## Application Configuration

**`Application.properties`** can be used to configure the API the way you want.
```bash
# Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
# This API implements Spring Data JPA with Hibernate.
spring.datasource.url = jdbc:mysql://<host>:<port>/<database-name>?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username = <username>
spring.datasource.password = <password>

# Note: If you want to use a different relational database make sure to include the driver dependency in `pom.xml` and update the configurations.

# Configuring Tomcat port (Default is 8080)
server.port=9000

# Hibernate ddl auto (create, create-drop, validate, update)
# Specify the database creation mode.
spring.jpa.hibernate.ddl-auto = update

# Include this if you want to output the SQL on console.
spring.jpa.hibernate.show-sql=true

# JWT secret key.
# Specify a String of your choice for the secret key.
ssdgroupc.app.jwtSecret= <your-secret-key>

# JWT expiration time in ms.
ssdgroupc.app.jwtExpirationMs= 86400000

## Application Setup
#### Create a database schema
Create a database schema and name it as exactly as you named your database in **`Application.properties`**.

    mysql> CREATE  DATABASE  <database-name>;

#### Update and build the project
 1. Right click the project and click `Maven` and `Update Project`
 2. Right click the project and click `Run As` and `Maven Build`

#### Run the application

 - Right click on **`TourApiApplication.Java`** and `Run As` and `Java Application`

#### Insert user roles.
```bash
mysql> USE <database-name>;
mysql> INSERT INTO roles(name) VALUES('ROLE_USER');
mysql> INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
## Setting up an Admin account
Users must be created from the client. Connect to the API from the VueJS Nuxt application register a new user.
Default user role is set to `ROLE_USER` 
#### Altering user role.
```bash
# Get the user id of the user you registered by providing username 
mysql> SELECT id FROM 'tour-api'.users WHERE username = 'admin';
+----+
| id |
+----+
|  1 |
+----+

# Get the role id for `ROLE_ADMIN`
mysql> SELECT id FROM `tour-api`.roles WHERE name = 'ROLE_ADMIN';
+----+
| id |
+----+
|  2 |
+----+

# Alter the `role_id` to match the `ROLE_ADMIN` id to make the user an Admin
mysql> UPDATE `tour-api`.`user_roles` SET `role_id` = '2' WHERE (`user_id` = '1') and (`role_id` = '1');

# Confirm that the role_id matches `ROLE_ADMIN` id
mysql> SELECT role_id FROM `tour-api`.user_roles WHERE user_id = 2;
```
Once the first admin is set up you can add more admins by accessing the admin dashboard. 
