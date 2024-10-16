package autonomousdrivingprojectmanagement.infra;

import autonomousdrivingprojectmanagement.config.kafka.KafkaProcessor;
import autonomousdrivingprojectmanagement.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import javax.naming.NameParser;
import javax.naming.NameParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    EducationRepository educationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PerformanceChecked'"
    )
    public void wheneverPerformanceChecked_SystemPerformancePolicy(
        @Payload PerformanceChecked performanceChecked
    ) {
        PerformanceChecked event = performanceChecked;
        System.out.println(
            "\n\n##### listener SystemPerformancePolicy : " +
            performanceChecked +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
