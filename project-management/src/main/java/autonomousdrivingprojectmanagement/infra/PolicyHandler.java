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
    ProjectRepository projectRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='QuestionAnswered'"
    )
    public void wheneverQuestionAnswered_QuestionAnswerPolicy(
        @Payload QuestionAnswered questionAnswered
    ) {
        QuestionAnswered event = questionAnswered;
        System.out.println(
            "\n\n##### listener QuestionAnswerPolicy : " +
            questionAnswered +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
