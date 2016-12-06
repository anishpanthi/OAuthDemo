
1) User sends a GET request to server with five parameters: grant_type, username, password, client_id, client_secret; something like this 
http://localhost:8080/Oauth_WebServices/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=anish&password=anish


2) Server validates the user with help of spring security, and if the user is authenticated, OAuth generates a access token and send sends back to user in following format.

{"access_token":"289ebc22-3aef-4ccd-9c94-e91371f8d992","token_type":"bearer","refresh_token":"33062381-fcda-4906-abab-5f7a84749e69","expires_in":119}


Here we got access_token for further communication with server it mentioned a expires_in time that indicates the validation time of the token and a refresh_token that is being used to get a new token when token is expired.

3) We access protected resources by passing this access token as a parameter, the request goes something like this:

http://localhost:8080/Oauth_WebServices/check/users/?access_token=289ebc22-3aef-4ccd-9c94-e91371f8d992
Here http://localhost:8080/Oauth_WebServices is the server path, and /check/users/ Is an API URL that returns a list of users and is being protected to be accessed. 

4) If the token is not expired and is a valid token, the requested resources(JSON) will be returned.

[{"id":1,"name":"anish","email":"a@s.com","phone":"1111111111"},{"id":2,"name":"Shree","email":"s@r.com","phone":"2222222222222"},{"id":3,"name":"madan","email":"m@b.com","phone":"3333333333333"}]

5) In case the token is expired, user needs to get a new token using its refreshing token that was accepted in step(2). A new access token request after expiration looks something like this:
http://localhost:8080/Oauth_WebServices/oauth/token?grant_type=refresh_token&client_id=restapp&client_secret=restapp&refresh_token=7ac7940a-d29d-4a4c-9a47-25a2167c8c49

And you will get a new access token along with a new refresh token.