# nuwe-hackathon-back

## Technology Stack

- Java
- Spring
- Gradle

## Documentation

UserController=>
```
GET: http://localhost:3000/user/{id}   //get a user by id
DELETE: http://localhost:3000/user/{id}   //delete a user by id
PUT: http://localhost:3000/user/{id} body{JSON User}   //edit name, username, password and/or email of a user by id
POST:http://localhost:3000/user/ body{JSON User}     //create a new user
```
GithubUserController=>
```
GET: http://localhost:3000/user/github/{username}   //enter a github username and get GithubUser info
```

