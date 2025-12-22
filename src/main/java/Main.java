import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskRepository repo = new TaskRepository();
        String input;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        do{System.out.println("1. Dodaj nowe zadanie\n" +
                "2. Wyświetl wszystkie zadania\n" + "3. Wyświetl zadanie według statusu\n" +
                "4. Oznacz zadanie jako zakończone\n" + "5. Usuń zadanie\n" + "6. Zapisz zadanie z pliku\n" +
                "7. Wyjście");
            input = scanner.next();
            scanner.nextLine();
            switch(input){
                case "1" -> {
                    System.out.print("Podaj tytuł: ");
                    String title = scanner.nextLine();
                    System.out.print("Podaj opis: ");
                    String description = scanner.nextLine();
                    System.out.print("Podaj termin(yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    LocalDate deadline = LocalDate.parse(date,formatter);
                    repo.add(new Task(title, description, deadline));
                }
                case "2" -> repo.displayAll();
                case "3" -> {
                    System.out.println("Jaki status ma być wyświetlony?(TODO/DONE)");
                    String status = scanner.nextLine().toUpperCase();
                    TaskStatus taskStatus = TaskStatus.valueOf(status);
                    boolean isFound = false;
                    for(Task t : repo.getTasks()) {
                        if (t.getStatus() == taskStatus){
                            isFound = true;
                            System.out.println(t);
                        }
                    }
                    if(!isFound) System.out.println("Nie znaleziono zadania o statusie: " + status);

                }
                case "4" -> {
                    System.out.println("Które zadanie: ");
                    String name = scanner.nextLine();
                    boolean isFound = false;
                    for(Task t : repo.getTasks()){
                        if(name.equals(t.getTitle())){
                            isFound = true;
                            t.setStatus(TaskStatus.DONE);
                            break;
                        }
                    }
                    if(!isFound) System.out.println("Nie znaleziono zadania!");
                }
                case "5" -> {
                    System.out.println("Które zadanie usunąć: ");
                    String title = scanner.nextLine();
                    for(Task t : repo.getTasks()){
                        if(t.getTitle().equals(title)){
                            repo.remove(t.getId());
                        }
                    }
                }
                case "7" -> System.out.println("Koniec Programu!");
                default -> System.out.println("Nieznana komenda");
            }



        }while(!input.equals("7"));
    }
}
