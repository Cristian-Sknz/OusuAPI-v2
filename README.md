<p align= "center">
<img src="https://i.imgur.com/TJCCSxO.png" alt="Osu Logo" width="700"/>	
<h1 align= "center"> A Osu API v2 Wrapper for Java</h1>
</p>

## :paperclip: My Objective
`With this improvised "API", I intend to use it in my projects. I would not release it in open source. I decided to leave the source code released because I had trouble finding a Java Wrapper that worked correctly. I hope you enjoy the basic functions of this API`

Sorry my english :3

## :dvd: Dependencies
The dependencies are inside build.gradle

## :newspaper: Add your dependencies!
[![](https://jitpack.io/v/Cristian-Sknz/OusuAPI-v2.svg)](https://jitpack.io/#Cristian-Sknz/OusuAPI-v2)
* Gradle

```groovy
repositories {
     maven { url 'https://jitpack.io' }
}

dependencies {
     implementation 'com.github.Cristian-Sknz:OusuAPI-v2:VERSION'
}
```
* Maven
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
    <groupId>com.github.Cristian-Sknz</groupId>
    <artifactId>OusuAPI-v2</artifactId>
    <version>VERSION</version>
</dependency>
```
## :man_teacher: Simple Use
I recommend that you read the official Documentation to know the limits of the API and among other things

[API Reference](https://osu.ppy.sh/docs/index.html#introduction)

### :asterisk: Create a Token
<p align="center">
:page_facing_up:
</p>

```java
/*
You MUST provide OAuth information to create a Token
*/
OsuAPI api = new OsuAPI(new OAuthApplication(0001, "CLIENT_SECRET", "REDIRECT_URI"));
APIRequest<Token> request = api.createToken("OAUTH_CODE");
Token token = request.get();
```

### :asterisk: Resume Token
<p align="center">
:page_facing_up:
</p>

```java
/*
To resume a session, you do not need to use OAuth information
*/
OsuAPI api = new OsuAPI(null/*or new OAuthApplication(0001, "CLIENT_SECRET", "REDIRECT_URI") */);
APIRequest<Token> request = api.resumeToken("Bearer_Token");
Token token = request.get();
```

#### :link: Using Token
<p align="center">
:page_facing_up:
</p>

```java
[...]
Token token = request.get();
Endpoint endpoint = token.getEndpoint();
APIRequest<User> request = endpoint.getUser(10906977, GameMode.Osu);
User user = request.get();

```

This project is not complete, I intend to update whenever I can.
Thanks for reading me :D
