package kafkaProjectExample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer {

    public static void main(String[] args){
       
    	ExecutorService executor = Executors.newCachedThreadPool();
    	
    	long t= System.currentTimeMillis();
    	long end = t+1000;
    	
    	while(System.currentTimeMillis() < end) {
    		
    		Date date = new Date(System.currentTimeMillis());
        	DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        	formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        	
        	System.out.println("Date =>"+formatter.format(date));
    		
    		
    		int numberofThead = 1;
        	int numberofWork = 1;
        			
        			
        	for (int i = 0; i < numberofThead; i++) {
        		 ProducerThead R1 = new ProducerThead(numberofWork);
        		 executor.execute(R1);
    		}
    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	
    	
    	
    
    	
    	
//    	System.out.println("Message :="+ new Gson().toJson(message));
    	
       /* KafkaProducer producer = new KafkaProducer(KafkaConstant.kafkaPropProducer());
        try{
            for(int i = 0; i < 100 ; i++){
            	
            	RequestMessage message = new RequestMessage();
            	message.setRequestNo(UUID.randomUUID().toString());
//            	message.setAuthMessage("000439137001751754700000043368120000440000000000100000VSPP01554151666611805112018051116564200000000000000000000000104000THB2000000000104000THB2000000000104000000000000000000000V000000005     F000 063476813100063476    28253019001001221324   PTTRM_PNL KOKCHANG       PHITSANULOK  THV  V-N101RTL000           000005110956350100000000388131357953268  76400000492100RTL122110000000000000000                                     75000010       C                                                             00000000000000000000011B4DE34FBEAF9BDCAFC977655F4A4AD73                                      0   201                                            0000000000000000000   0000000000000000000                                                                0882729967                                                                                                              รักษ์ษวรรณ                              สิงห์คงทนารถ                            RUKSAWAN                                SINGKHONGTHANAT");
            	message.setAuthMessage("000439137000000556700000000013687600450000000000100000VSPP05571238273911807032018070310520200000000000000000000000249900THB2000000000249900THB2000000000249900000000000000000000V000000001     F000 417969818417543455    EEE00015000001000019763COMPTROLLER  GENERAL'S DEBANGKOK      THV  V-N101RTL590           000007031052020100003000000000000000000  76400000456724VIR118090000000000000000                           10120     06      07     C                                                             00000000000000000000010                                                                        M 20107                                          0000000000000000000   0000000000000000000                                                                0971622415                                                                                                              ไอที-เอสเอสยู                           เทสต์                                   IT-SSU                                  TEST");
           // 	message.setChannel("test"+i);
            	message.setChannel("ISS");
            	
//            	String msg = "test message - " + i;
            	String msg = new Gson().toJson(message);
                System.out.println("Producer : "+msg);
                ProducerRecord record = new ProducerRecord(KafkaConstant.test_topic,msg );
//                kafkaProducer.send(new ProducerRecord(KafkaConstant.topic, Integer.toString(i), "test message - " + i ));
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
                
                 
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        	producer.close();
        } */
    } 
    
    public String convertDateTime (long timemili) {
    	Date date = new Date(timemili);
    	DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
    	formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    	
    	return formatter.format(date);
    }	
}