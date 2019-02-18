package kafkaProjectExample;

import java.util.UUID;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.google.gson.Gson;

public class ProducerThead2 implements Runnable {
	public int numberofWork;
	public ProducerThead2(int numberofWork) {
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
//                	message.setAuthMessage("000439137001751754700000043368120000440000000000100000VSPP01554151666611805112018051116564200000000000000000000000104000THB2000000000104000THB2000000000104000000000000000000000V000000005     F000 063476813100063476    28253019001001221324   PTTRM_PNL KOKCHANG       PHITSANULOK  THV  V-N101RTL000           000005110956350100000000388131357953268  76400000492100RTL122110000000000000000                                     75000010       C                                                             00000000000000000000011B4DE34FBEAF9BDCAFC977655F4A4AD73                                      0   201                                            0000000000000000000   0000000000000000000                                                                0882729967                                                                                                              รักษ์ษวรรณ                              สิงห์คงทนารถ                            RUKSAWAN                                SINGKHONGTHANAT");
                	message.setAuthMessage("000430445080000894000000000473590086880000000000100000VSSS07581298467011808222018082211121000000000000000000000000080000THB2000000000080000THB2000000000080000000000000000000000V000000001     F000 000519823416551469    40261759000001065009606BAR B Q PLAZA            PATHUMTHANI  THV  KVN101RTL000           000008221112100100003000000000000000000  76400000456724RTL123070000000000000000                           12130     05             C                                                             00000000000000000000000                                                                          000                                            0000000000000000000   0000000000000000000                                                                0924324666          champvoi99@gmail.com                                                                                สีหมอก                                  ฟ้าสดใส                                 SIMOK                                   FASODSAI");
               // 	message.setChannel("test"+i);
                	message.setChannel("ISS");
                	
//                	String msg = "test message - " + i;
                	String msg = new Gson().toJson(message);
                    //System.out.println("Producer : "+msg);
                    ProducerRecord record = new ProducerRecord(KafkaConstant.test_topic1,msg );
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
                    
                    
                    Thread.sleep(50);
					
				}
            	
                 
                
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        	producer.close();
        }
    }
		

}
