## Java Redis Aspect Messenger

An extension to the Java Aspect Messenger that lets you subscribe to and publish to Redis pub sub channels.

### Maven

#### Repository
```xml
<repositories>
    <repository>
        <id>scottbyrns-snapshots</id>
        <url>https://github.com/scottbyrns/Scottbyrns-Maven-Repo/raw/master/snapshots</url>
    </repository>
</repositories>
```

#### Dependency
```xml
<dependency>
    <groupId>com.scottbyrns</groupId>
    <artifactId>Jav-Redis-Aspect-Messenger</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Publishing messages to Redis
```java
    ManagedRedisInstance.createInstance("localhost");
    RedisMessengeController.sendMessage("user-did-view-profile", Message.create(new Date().toString()));
```

### Registering Handlers
Register a Redis channel to forward into the aspect messaging layer of your application.
This block your current thread.
```java
    RedisMessengeController.registerHandler("user-did-view-profile");
```
