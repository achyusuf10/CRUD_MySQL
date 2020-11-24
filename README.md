<!-- PROJECT LOGO -->

<br />
<p align="center">
  <a href="https://github.com/abdullah1006/CRUD_MySQL">
    <img src="https://user-images.githubusercontent.com/65402864/100080500-7e02d480-2e78-11eb-9997-d774cec7854a.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">CRUD MySQL</h3>

<p align="center">
    Simple CRUD App in Android use Code Igniter 4
    <br />
    <a href="https://github.com/abdullah1006/CRUD_MySQL"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/abdullah1006/CRUD_MySQL">View Demo</a>
    ·
    <a href="https://github.com/abdullah1006/CRUD_MySQL/issues">Report Bug</a>
    ·
    <a href="https://github.com/abdullah1006/CRUD_MySQL/issues">Request Feature</a>
  </p>
</p>

<!-- TABLE OF CONTENTS -->

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#more-screenshot">More Screenshot</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

![WhatsApp Image 2020-11-24 at 16 53 57](https://user-images.githubusercontent.com/65402864/100079084-d638d700-2e76-11eb-95fb-3dc83b730be3.jpeg)

The Android CRUD (Create, Read, Update, Delete) project uses a MySQL database, and uses the Code Igniter 4 as aframework. I created this Android project to fulfill my course assignments at a university.


### Built With

- [Android Studio](https://developer.android.com/studio?hl=zh-cn)
- [XAMPP](https://www.apachefriends.org/download.html)
- [Code Igniter](https://codeigniter.com/download)

<!-- GETTING STARTED -->

## Getting Started

Let's start buddy.

### Prerequisites


- Android Studio Version => 4.1
- Php Version => 7.2
  
  ```sh
  php -v
  ```
  

### Installation

1. Clone the repo
2. Copy crud_ci4 folder to your htdocs folder (optional)
3. Start your apache and MySQL from XAMPP (optional)
4. Or you can start the server with

```php
php spark serve
```

5. Create database 'db_anggota' in phpmyadmin
6. Migration table to database from RestAPI
 
```php
php spark migrate
```

7. Create Data Dummy

```php
php spark db:seed UserSeeder
```

8. Test your Rest API on your browser
http://localhost/crud_ci4/public/users or http://localhost:8080/users

9. Or test with [Postman](https://www.postman.com/downloads/). Make sure request is working properly.
- GET -> http://localhost/crud_ci4/public/users or http://localhost:8080/users
- POST -> http://localhost/crud_ci4/public/users/create or http://localhost:8080/users/create
- PUT -> http://localhost/crud_ci4/public/users/{id} or http://localhost:8080/users/{id}
- DELETE -> http://localhost/crud_ci4/public/users/{id} or http://localhost:8080/users/{id}

10. Open Android Studio

11. Change your ip in RetroServer.java and network_security_config.xml

## More Screenshot

![WhatsApp Image 2020-11-24 at 16 53 57](https://user-images.githubusercontent.com/65402864/100079084-d638d700-2e76-11eb-95fb-3dc83b730be3.jpeg)
![WhatsApp Image 2020-11-24 at 16 53 57 (2)](https://user-images.githubusercontent.com/65402864/100079095-d89b3100-2e76-11eb-9e11-afae5df8c33b.jpeg)
![WhatsApp Image 2020-11-24 at 16 53 57 (1)](https://user-images.githubusercontent.com/65402864/100079104-db962180-2e76-11eb-97d5-a37eb2077cfd.jpeg)
![WhatsApp Image 2020-11-24 at 16 53 56](https://user-images.githubusercontent.com/65402864/100079108-dcc74e80-2e76-11eb-9b4a-d45dcda1ef55.jpeg)

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE` for more information.

