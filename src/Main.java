import java.util.HashSet;
import java.util.Scanner;

public class Main {
    Answer ans;

    public Main() {
        ans = new Answer();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the 1A2B game! let's enter the answer you are guessing...");
//        System.out.println("Answer = " + ans.getAns());

        while (true) {
            System.out.println("input the answer that is 4 distinct numbers, or \"q\" to exit : ");
            try {
                String userInput = scanner.nextLine();
                if (userInput.equals("q")) {
                    System.out.println("Bye Bye.");
                    return;
                }

                String validInput = validateUserInput(userInput);
                String result = this.ans.checkAnswer(validInput);

                if(result.equals("4A")) break;

                System.out.println("This turn your guess is : " + result);
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter non-numeric character, please try again.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Congratulation, you win the game! the answer is " + ans.getAns());
    }

    private String validateUserInput (String userInput) throws NumberFormatException, Exception {
        Integer.parseInt(userInput);

        if (userInput.length() != 4) throw new Exception("you can only enter 4 numbers at all, please try again.");

        char[] chars = userInput.toCharArray();

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) throw new Exception("Cannot enter duplicated number, please try again.");
            set.add(chars[i]);
        }

        return userInput;
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }
}
