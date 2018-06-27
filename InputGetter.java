import java.util.Scanner;


public class InputGetter {

    private Scanner userInput;


    public InputGetter() {
        userInput = new Scanner(System.in);
    }


    public String getStringFromUser(String text) {
        System.out.println(text);
        return userInput.nextLine();
    }


    public int getIntFromUser(int start, int end) {
        System.out.printf("Enter a number from %d to %d. ", start, end);
        boolean isInt = false;
        int option = 0;
        while(!isInt) {
            try{
                option = Integer.parseInt(userInput.nextLine());

                if(option  >= start && option <= end) {
                    isInt = true;
                }else {
                    System.out.println("This is not a number from given round. Try again!");
                }
            }catch(NumberFormatException e) {
                 System.out.println("This is not a number. Try again!");
            }
        }
        return option;
    }

}
