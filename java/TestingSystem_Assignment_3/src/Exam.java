import java.time.LocalDate;

public class Exam {
    int id;
    String code;
    String title;
    CategoryQuestion[] categoryQuestion;
    int duration;
    Account account;
    LocalDate createDate;
    Question[] questions;
}

