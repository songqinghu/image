package com.kuaikanwang.image.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kuaikanwang.image.utils.redis.SimpleJedisTemplate;
import com.kuaikanwang.image.utils.redis.SimpleJedisTemplate.RedisCallback;

import redis.clients.jedis.JedisCommands;


@Repository
public class RedisDaoImpl implements RedisDao {

	@Autowired
	SimpleJedisTemplate jedisTemplate;
	
	@Override
	public String getValueByKey(final String key) {
		return jedisTemplate.execute(new SimpleJedisTemplate.RedisCallback<String>() {
			@Override
			public String doInRedis(JedisCommands commands) {
				return commands.get(key);
			}
		});
	}
	
	
	public Boolean setValueByKey(final String key){
		
		return jedisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(JedisCommands commands) {
				
				commands.incr(key);//加1 --存ip
				commands.expire(key, 86400);//监控一天
				return true;
			}
		});
		
		
	}
	
	
	
	
}
