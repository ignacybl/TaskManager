import java.time.LocalDate;

public class DateValidator implements Validator<LocalDate>{

    @Override
    public void validate(LocalDate input) {
        if(input == null || input.isBefore(LocalDate.now())){
            throw new RuntimeException("Date cannot be null or before now");
        }
    }
}
