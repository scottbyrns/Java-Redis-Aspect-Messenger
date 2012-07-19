package com.scottbyrns;

import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.InvalidJSONStringException;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

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
public class RedisMessageHandler extends JedisPubSub
{

    public RedisMessageHandler()
    {

    }

    public void onMessage(String channel, String message) {
        try {
            MessageController.sendMessage(channel,
                                          JSONObjectMapper.mapJSONStringToEntity(message, Message.class)
                                          );
        }
        catch (FatalMappingException e) {
            MessageController.sendMessage(channel, Message.create(message));
        }
        catch (InvalidJSONStringException e) {
            MessageController.sendMessage(channel, Message.create(message));
        }
    }

    public void onSubscribe(String channel, int subscribedChannels) {
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {

    }

    public void onPSubscribe(String pattern, int subscribedChannels) {

    }

    public void onPUnsubscribe(String pattern, int subscribedChannels) {

    }

    public void onPMessage(String pattern, String channel,
        String message) {
    }

}
