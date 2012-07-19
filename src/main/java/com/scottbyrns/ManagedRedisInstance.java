package com.scottbyrns;

import redis.clients.jedis.Jedis;

/**
 * Copyright (C) 2012 by Scott Byrns
 * http://github.com/scottbyrns
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p/>
 * Created 7/18/12 1:08 PM
 */
public class ManagedRedisInstance
{
    private Jedis jedis;

    private static ManagedRedisInstance instance;

    private ManagedRedisInstance(String host)
    {
        jedis = new Jedis(host);
        jedis.connect();
    }

    public static ManagedRedisInstance createInstance(String host)
    {

        RedisMessageHandler redisMessageHandler = new RedisMessageHandler();
        MessageController.registerListenersOfClass(RedisMessageHandler.class, redisMessageHandler);

        if (null == instance) {
            instance = new ManagedRedisInstance(host);
        }
        return instance;
    }

    public static ManagedRedisInstance getInstance()
    {
        if (null == instance) {
            instance = createInstance("localhost");
        }
        return instance;
    }

    public Jedis getJedis()
    {
        return jedis;
    }

    public void setJedis(Jedis jedis)
    {
        this.jedis = jedis;
    }



    public Long publish(String channel, String message)
    {
        return jedis.publish(channel,
                             message);
    }
}
