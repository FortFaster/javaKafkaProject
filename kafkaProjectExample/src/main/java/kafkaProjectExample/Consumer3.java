package kafkaProjectExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;



public class Consumer3 implements Runnable {
	int count = 0;
	private int theadNo ;
	public Consumer3(int i) {
		this.theadNo = i;
	}
	@Override
	public void run() {
		int partition = 1;
    	
		System.out.println("Consumer3 No"+theadNo);
		
        KafkaConsumer consumer = new KafkaConsumer(KafkaConstant.kafkaaPropConsumers3());
        List topics = new ArrayList();
        topics.add(KafkaConstant.test_topic);
        consumer.subscribe(topics);
        
        int limitTryCommit = 3;
        
        try{
        	while (true) {
        		
				ConsumerRecords<String, String> records = consumer.poll(100);
				
				for (ConsumerRecord<String, String> record : records) {
					Map<String,Object> parameters = new HashMap<String, Object>();
					parameters.put("Message", record.value());
					
					//logNode.warn("Topic="+record.topic()+" :partition="+record.partition()+": offset="+record.offset());
					//Map<TopicPartition, OffsetAndMetadata> currentOffSet = rebalanceListner.getCurrentOffSet();
					
					//Commit offset to kafka. if fail will retry n times.
					boolean processedSuccessfully = false;
					String rError = "";
					
					for ( int i = 0; i < limitTryCommit; i++) {
						
						try {
							//logNode.warn("limitTryCommit ="+i);
							Map<TopicPartition, OffsetAndMetadata> currentOffSet = new HashMap<>();
							currentOffSet.put(new TopicPartition(record.topic(),record.partition()), new OffsetAndMetadata(record.offset()+1));
							consumer.commitSync(currentOffSet);
							currentOffSet.clear();
							processedSuccessfully = true;
							count++;
						}catch (CommitFailedException e) {
							rError = "CommitFailedException Fail ="+e.toString();
							System.err.println("Message-Kafka commit processing failure. Will try once again. :limitTryCommit="+i);
						}catch (Exception e) {
							rError = "Consumer Exception : "+e.toString();
							System.err.println("Message-Kafka commit processing failure. Will try once again. :limitTryCommit="+i);
						}
							
					}
					
					// Goto next offset when  retry commit not success
					if(!processedSuccessfully) {
						System.err.println(rError);
						continue;
					}
					
					//perform when consumer commit success
					System.out.println("TheadNo"+theadNo+" :No"+count+" :parameters==>"+parameters);
//					try {
//							//logNode.warn("Before in microflow");
//	                    	IContext systemContext = Core.createSystemContext();
//							Core.execute(systemContext, this.microflowName, true,parameters);
//						
//	                	} catch (CoreException e) {
//	                		logNode.error("Error in microflow "+this.microflowName+" for topic "+record.topic()+" and value "+record.value()+": "+e.getMessage());
//	                	
//					}
					
					
				Thread.sleep(1000);
				
				}
				
			}
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            consumer.close();
        }
		
			
	}

}