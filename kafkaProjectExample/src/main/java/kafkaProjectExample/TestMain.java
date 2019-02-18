package kafkaProjectExample;

public class TestMain {

	public static void main(String[] args) {

		String topic = "test1,test2.test3-test4";

		String[] fields = topic.split(",");

		

		for (String field : fields) {
			System.out.println("filed : =>" + field);
		}

	}

}
