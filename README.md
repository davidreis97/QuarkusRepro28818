This repo helps reproduce the issue described in https://github.com/quarkusio/quarkus/issues/28818.

Steps:

1. Start application
2. Make the following request (using Postman or `curl` or any other HTTP client): `GET localhost:4444/sendRequest`
    * This will make the service send a `POST` request with a 5MB body and an unexpected `Content-Header` to itself on the path `\hello`
3. The client will get stuck because the server doesn't fully read the request nor close the connection.
    * To verify this, pause the execution and look at the threads - one of them threads should be stuck on `java.net.SocketOutputStream.socketWrite0()`.
    * Another consequence of this is that further requests to `GET localhost:4444/sendRequest` may hang.