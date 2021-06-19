package redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Map;

public class JedisDemo02 {
    public static void main(String[] args) throws JsonProcessingException {

        Jedis jedis = new Jedis("192.168.211.128",6379);

        jedis.flushDB();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, String> map = new HashMap<>();
        map.put("hello","world");
        map.put("name","zhangsan");
//        开启事务

        Transaction multi = jedis.multi();
        String result = objectMapper.writeValueAsString(map);
        System.out.println(result);

        jedis.watch(result);
        try {
            multi.set("user1",result);
            multi.set("user2",result);

            int i = 1 /0;
//            执行事务
            multi.exec();
        } catch (Exception e) {
//            放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
