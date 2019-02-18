package kafkaProjectExample;

import java.util.UUID;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.google.gson.Gson;

public class ProducerThead implements Runnable {
	public int numberofWork;
	public ProducerThead(int numberofWork) {
		// TODO Auto-generated constructor stub
		this.numberofWork = numberofWork;
	}

	@Override
	public void run() {

        KafkaProducer producer = new KafkaProducer(KafkaConstant.kafkaPropProducer());
        
        try{
            	for (int i = 0; i < numberofWork; i++) {
            		System.out.println("i="+(i+1));
            		RequestMessage message = new RequestMessage();
                	message.setRequestNo(UUID.randomUUID().toString());
                	message.setAuthMessage("000439137000691187500000000000000000000000000000100000VSPP013516      11810302018103010325100000000000000000000000050000THB2000000000050000   2000000000000000000000000000000000V000000001     F123 000837830316560945    90429993000001000022268TEST EMV & TLE           TAK          THV  V-N102RTL000           000010301032510100003000000000000000000  76400000456724RTL121110000000000000000                           10320     05             C                                                             00000000000000000000000                                                                          000                                            0000000000000000000   0000000000000000000                                                                0830167127                                                                                                              Thai Name 1_8402                        Thai Name 2_8402                        English Name1_8402                      English Name2_8402                      0000");
//                	message.setAuthMessage("000439137001862768300000044207490000440000000000100000VSPP01553260270111810182018101812503700000000000000000000000518500THB2000000000518500THB2000000000518500000000000000000000V000000005     F000 299980829105299980    80257376002201768454   BRIDGESTONE A.C.T.(CHIANGCHIANGMAI    THV  V-N101RTL000           000010180550410100000000588291210410539  76400000436514RTL123040000000000000000                                     75000010       C                                                             000000000000000000000115EB2E83585086370899C92730CB8410A                                      0   201                                            0000000000000000000   0000000000000000000                                                                0966628555          wannipa.waurain@gmail.com                                                                           วรรณิภา                                 วรอินทร์                                WANIPA                                  WORAAIN");
               // 	message.setChannel("test"+i);
                	message.setChannel("ISS");
                	
//                	String msg = "test message - " + i;
                	String msg = new Gson().toJson(message);
                    System.out.println("Producer : "+msg);
                	ProducerRecord record;
//                	if(i%2 == 0) {
//                     record = new ProducerRecord(KafkaConstant.test_topic1,msg );
//                	}else {
                	 record = new ProducerRecord(KafkaConstant.test_topic,msg );
//                	}
//                    kafkaProducer.send(new ProducerRecord(KafkaConstant.topic, Integer.toString(i), "test message - " + i ));
                    producer.send(record, new Callback() {
    	            public void onCompletion(RecordMetadata metadata, Exception e) {
    	                    if (e != null) {
    	                      e.printStackTrace();
    	                    System.out.println("e:"+e.getMessage());  
    	                    }
    	                    System.out.println("Sent:" + metadata.topic() + ", Partition: " + metadata.partition() + ", Offset: "
    	                            + metadata.offset() ); 
    	            }
                });
                    
                    
                    Thread.sleep(100);
					
				}
            	
                 
                
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        	producer.close();
        }
    }
		

}
