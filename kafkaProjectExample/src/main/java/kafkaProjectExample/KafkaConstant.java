package kafkaProjectExample;

import java.util.Properties;

public class KafkaConstant {

	//test
//	public static final String kafkaServer = "localhost:9092";
	public static final String kafkaServer = "192.168.1.140:9092";
//	public static final String kafkaServer = "192.168.8.114:9092";
//	public static final String zookeeperServer = "192.168.1.116:2181";

//	public static final String kafkaServer = "192.168.1.30:9092";
	
	//sit
//	public static final String kafkaServer = "192.168.1.159:9092,192.168.1.160:9092,192.168.1.161:9092";
//	public static final String zookeeperServer = "192.168.1.30:2181";
	
	//PRD
	//public static final String kafkaServer = "172.20.3.41:9092,172.20.3.42:9092,172.20.3.43:9092";
	
	
	public static final String c1 = "Spending-Consumers";
	public static final String c2 = "ECoupong-Consumers";
	public static final String c3 = "Campaign-Consumers";
	public static final String topic_campaign = "campaign.t1";
	public static final String topic_spending = "spending";
	public static final String topic_ecoupon = "ecoupon";
	public static final String topic_testgroup = "test-group";
	public static final String test_topic = "authoriseMessage";
	public static final String test_topic1 = "authoriseMessage1";
	
	public static Properties kafkaaPropConsumers() {
		
		Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaServer);
        properties.put("group.id", c1);
        properties.put("enable.auto.commit", "false");
        properties.put("auto.commit.interval.ms", "500");
        properties.put("session.timeout.ms", "30000");
        properties.put("request_timeout_ms", "40000");
        
//        properties.put("rebalance.max.retries", "4");
//        properties.put("rebalance.backoff.ms", "2000");
        properties.put("session.timeout.ms", "30000");
        properties.put("heartbeat.interval.ms", "1000");
        properties.put("max.poll.interval.ms", "300000");
        properties.put("max.poll.records", "1000");
        
        properties.put("auto.offset.reset", "latest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		return properties;
	}
	
	public static Properties kafkaaPropConsumers2() {
		
		Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaServer);
        properties.put("group.id", c2);
        properties.put("enable.auto.commit", "false");
        properties.put("auto.commit.interval.ms", "500");
        properties.put("session.timeout.ms", "30000");
        properties.put("request_timeout_ms", "40000");
        
//        properties.put("rebalance.max.retries", "4");
//        properties.put("rebalance.backoff.ms", "2000");
        properties.put("session.timeout.ms", "30000");
        properties.put("heartbeat.interval.ms", "1000");
        properties.put("max.poll.interval.ms", "300000");
        properties.put("max.poll.records", "9");
        
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		return properties;
	}
	
	public static Properties kafkaaPropConsumers3() {
		
		Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaServer);
        properties.put("group.id", c3);
        properties.put("enable.auto.commit", "false");
        properties.put("auto.commit.interval.ms", "500");
        properties.put("session.timeout.ms", "30000");
        properties.put("request_timeout_ms", "40000");
        
//        properties.put("rebalance.max.retries", "4");
//        properties.put("rebalance.backoff.ms", "2000");
        properties.put("session.timeout.ms", "30000");
        properties.put("heartbeat.interval.ms", "1000");
        properties.put("max.poll.interval.ms", "300000");
        properties.put("max.poll.records", "9");
        
        properties.put("auto.offset.reset", "latest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		return properties;
	}
	
	public static Properties kafkaPropProducer() {
			Properties props = new Properties();
			props.put("bootstrap.servers", kafkaServer);
		    props.put("acks", "all");
		    props.put("retries", 0);
		    props.put("batch.size", 16384);
		    props.put("linger.ms", 1);
		    props.put("buffer.memory", 33554432);
		    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	        
	        return props;
	}
	

}
