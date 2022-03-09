package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lixu
 * @create 2022-03-02-20:11
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;
    static {
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxIdle")));
        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("post")));
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}
