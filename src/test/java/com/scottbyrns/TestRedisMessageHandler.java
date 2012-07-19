package com.scottbyrns;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Date;

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
 * Created 7/18/12 11:16 AM
 */
public class TestRedisMessageHandler
{

    @Test
    public void testRedis () {
        ManagedRedisInstance.createInstance("localhost");
//        RedisMessengeController.registerHandler("channel");
        RedisMessengeController.sendMessage("channel",
                                            Message.create(new Date().toString()));


    }
}
