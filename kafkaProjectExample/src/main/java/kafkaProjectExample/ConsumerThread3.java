package kafkaProjectExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerThread3 {
	
	public static void main(String[] args) {
		
		int numberOfConsumers = 10;
		
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < numberOfConsumers; i++) {
			Consumer3 consumer = new Consumer3(i);
			executor.execute(consumer);
		}
				
			
				
	}

}
