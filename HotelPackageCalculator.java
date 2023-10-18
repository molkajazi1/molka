package com.javainuse;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.aggregate.AggregateOperations;
import com.hazelcast.jet.config.JetConfig;
import com.hazelcast.jet.pipeline.Pipeline;
import com.hazelcast.jet.pipeline.Sinks;
import com.hazelcast.jet.pipeline.SourceBuilder;
import com.hazelcast.jet.pipeline.StreamSource;
import com.hazelcast.jet.pipeline.WindowDefinition;
public class HotelPackageCalculator {
	public static void main(String[] args) {
		JetInstance jetInstance = Jet.newJetInstance();

        JetInstance jet = Jet.newJetInstance();
        Pipeline pipeline = createPipeline();
        jet.newJob(pipeline).join();
        jet.shutdown();
        }
    public static boolean fillBufferExecuted = false;

    private static Pipeline createPipeline() {
        Pipeline pipeline = Pipeline.create();

        // Create a custom source to generate the input data (you can replace this with your own data source)
        System.out.println("etape 1");

        StreamSource<Object> source = SourceBuilder
                .stream("input-source", ctx -> new InputDataGenerator())
                .fillBufferFn((generator, buffer) -> {
                	if(!fillBufferExecuted) {
                		System.out.println("etape genereate");
                        buffer.add(generator.generate());
                        fillBufferExecuted = true;
                	}
                    

                })
                .build();
        System.out.println("etape 2");

        // Define the pipeline stages
        pipeline.readFrom(source)
        .withIngestionTimestamps() // Indicate no event time processing
        .groupingKey(data -> ((InputData) data).getRoomType() +
                ((InputData) data).getBoardType() +
                ((InputData) data).getRoomCapacity() +
                ((InputData) data).getPersonType())
        .window(WindowDefinition.tumbling(5000))
        .aggregate(AggregateOperations.averagingDouble(data -> ((InputData) data).calculatePackagePrice()))
        .map((windowResult) -> {
            String roomType = windowResult.getKey().substring(0, 1);
            String boardType = windowResult.getKey().substring(1, 2);
            String roomCapacity = windowResult.getKey().substring(2, 3);
            double averagePackagePrice = windowResult.getValue();
            return String.format("Room Type: %s, Board Type: %s, Room Capacity: %s, Average Package Price: %.2f",
                    roomType, boardType, roomCapacity, averagePackagePrice);
        })
        .writeTo(Sinks.logger());



        return pipeline;
    }
}