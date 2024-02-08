package com.cedula.ups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService{
	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	public void setKeyValue(String key, String value){
		ValueOperations<String,String> ops = redisTemplate.opsForValue();
		ops.set(key,value);
	}

	public String getValue(String key){
		ValueOperations<String,String> ops =this.redisTemplate.opsForValue();
		return ops.get(key);
	}
}
