public class TextFieldValidator implements Validator<String>{
    @Override
    public void validate(String input) {
        if(input == null || input.isBlank()) {
            throw new RuntimeException("Provided input should not be empty");
        }
        if(input.length() > 200){
            throw new RuntimeException("Provided input is too long (max 200 characters)");
        }
    }
}
