package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AnswerQuestionCommand {

    private String questionId;
    private String question;
    private String answer;
}
