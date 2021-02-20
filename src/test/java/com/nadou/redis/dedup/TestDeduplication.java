package com.nadou.redis.dedup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

/**
 * @ClassName TestDeduplication
 * @Description 处理重复请求
 * @Author amunamuna
 * @Date 2021/2/20 10:10 上午
 * @Version 1.0
 **/

public class TestDeduplication {

    @Autowired
    private RedisTemplate redisTemplate;

    private boolean deduplicate(String req){
        String userId= "12345678";//用户
        String method = "pay";//接口名
        //计算请求参数摘要，其中剔除里面请求时间的干扰
        String dedupMD5 = new ReqDedupHelper().dedupParamMD5(req,"requestTime");
        String KEY = "dedup:U=" + userId + "M=" + method + "P=" + dedupMD5;

        long expireTime =  1000;// 1000毫秒过期，1000ms内的重复请求会认为重复
        long expireAt = System.currentTimeMillis() + expireTime;
        String val = "expireAt@" + expireAt;

        // NOTE:直接SETNX不支持带过期时间，所以设置+过期不是原子操作，极端情况下可能设置了就不过期了，后面相同请求可能会误以为需要去重，
        // 所以这里使用底层API，保证SETNX+过期时间是原子操作
        Boolean firstSet = (Boolean) redisTemplate.execute(
                (RedisCallback<Boolean>) connection ->
                        connection.set(KEY.getBytes(), val.getBytes(), Expiration.milliseconds(expireTime),
                        RedisStringCommands.SetOption.SET_IF_ABSENT));

        final boolean isConsiderDup;
        if (firstSet != null && firstSet) {
            isConsiderDup = false;
        } else {
            isConsiderDup = true;
        }
        return isConsiderDup;
    }
}
