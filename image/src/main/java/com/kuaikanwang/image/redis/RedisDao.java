package com.kuaikanwang.image.redis;


public interface RedisDao {
	public String getValueByKey(String key);
	
	public Boolean incrValueByKey(String key,Integer seconds,Integer max);
	
	public Boolean decrValueByKey(String key);
	
}
