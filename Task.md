# Task -
## Create a REST service for managing users, groups
We have a (derby) database containing groups, users and authentication tokens.

Please refer to [the database creation script](./setupdb.sql) for more details.

* Groups (groups) have an integer id and a name that is a string.
* Users (users) have an integer id, an integer group_id where they belong and a name.
* Authentication tokens (auth) have a user_id and a token which is a string.
* Group 0 is the admin group. It should never be deleted.
* Any other groups can be deleted
* User with id 0 is the admin user, it should never be deleted.
* All other users can be deleted.
* The initial auth token for user admin is 496a3cddc8d8d4ec76343d89f1861d57199bd7b6 it was obtained from the shasum of a random uuid (4B4515E2-E9B6-43AF-8137-74F224FC8782).
* There are no specific requirements on how to create new auth tokens for other users, uuid may be used, for instance.

We pass parameters as
* id, group_id in the query string
* auth as header Authentication

The service needs to implement these functions.

| name        | description                                                                                                                                                                                                               |
|-------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| whoami      | pass id in the path, token as specified earlier, returns a JSON structure with user and group names                                                                                                                       |
| listGroups  | return a list of existing groups, can be called by any user                                                                                                                                                               |
| listUsers   | return a list of existing users, can be called by any user                                                                                                                                                                |
| createGroup | pass a name, create a group with that name, return the group id. Let the db engine decide the id, can be called only by admin                                                                                             |
| createUser  | pass a name, group_id, create the user, return the user id, can be called only by admin                                                                                                                                   |
| setAuth     | pass user_id, token, store in auth. If done by admin, can change the token for any user. Other users can only change their token starting with their current one. If none exists, admin needs to assign the the first one |

Use the base project as a start point. The project is maven-based and includes an embedded app server running on port 9000.
Choose HTTP Method and url components considering REST.

If you are using any IDE supporting maven such as eclipse, netbeans or intelliJ IDEA, "running" the project should start the application in the embedded server.

### Pre-requisites

* jdk-11
* IntelliJ IDEA, or Visual Studio Code, or NetBeans 