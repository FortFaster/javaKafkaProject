package kafkaProjectExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerThread {
	
	public static void main(String[] args) {
		
		int numberOfConsumers = 1;
		
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < numberOfConsumers; i++) {
			Consumer consumer = new Consumer(i);
			executor.execute(consumer);
		}
				
			
				
	}

}
