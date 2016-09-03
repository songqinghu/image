package com.kuaikanwang.image.redis;


public interface RedisDao {
	public String getValueByKey(String key);
	
	public Boolean setValueByKey( String key);
}
