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
	/**
	 * 指定的key加1
	 * <p>Title: incrValueByKey</p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public Boolean incrValueByKey(final String key,final Integer seconds,final Integer max){
		
		return jedisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(JedisCommands commands) {
				//一级监控  控制爬虫最多 1分钟访问10次
				if(!commands.exists(key)){ //不存在该key
					commands.incr(key);
					commands.expire(key,seconds);
				}else{
					Long num = commands.incr(key);
					if(num >max){
						commands.del(key);
						return  false;
					}
					
				}
				return true;
			}
		});
		
		
	}
	
	public Boolean decrValueByKey(final String key){
		
		return jedisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(JedisCommands commands) {
				if(!commands.exists(key)){
					return true;
				}
				//存在  说明是 加法时存入 已经做了时间控制
				Long num = commands.decr(key);
				if(num<0){
					commands.del(key);
				}
				return true;
			}
		});
		
		
	}
	
	
	
	
}
