import com.sennikov.dz1.service.QuestionReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class QuestionReaderTest {
    @Test
    public void getQuestionTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        QuestionReader service = context.getBean(QuestionReader.class);

        List<String> actualQuestionsList = service.getQuestions();
        List<String> expectedQuestionList = new ArrayList<>();
        expectedQuestionList.add("Для чего используется оператор NEW?");
        expectedQuestionList.add("Для чего используется ключевое слово «this»?");
        expectedQuestionList.add("Как называется оператор увеличения который увеличивает значение переменной на единицу?");
        expectedQuestionList.add("Чем является ключевое слово «public»?");
        expectedQuestionList.add("Какой метод запускает программу на Java?");

        Assertions.assertEquals(expectedQuestionList, actualQuestionsList, "Wrong list of questions");
    }
}
