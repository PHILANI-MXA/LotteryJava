
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Lottery {

    public static void main(String[] args) {
        Scanner userKeyboardInput = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        // adding 1 to 9 to the array
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }

        Lottery obj = new Lottery();
        int numberOfElements = 3;

        List<Integer> randomElements = obj.getRandomElements(list, numberOfElements);
        System.out.println("Randomly selected elements: " + randomElements);

        String input;
        int randomIndex = randomElements.get(0); // Assuming you want to compare with the first random element

        do {
            System.out.print("To play: guess your winning numbers or press 'q' to quit: ");
            input = userKeyboardInput.nextLine();
            if (input.equals("give me a hint")) {
                System.out.println("try: " + randomIndex);
            } else if (!input.equals("q")) {
                if (Integer.parseInt(input) == randomIndex) {
                    System.out.println("CONGRACULATIONS YOU'VE WON! ZAR10");
                    input = "q"; // if someone wins, they're forced to quit
                } else {
                    System.out.println("Sorry, good guess, but not quite right.");
                }
            }
        } while (!input.equals("q"));

        System.out.println("Thanks for playing!");
    }

    public List<Integer> getRandomElements(List<Integer> list, int totalItems) {
        Random rand = new Random();
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(list.size());
            newList.add(list.get(randomIndex));
        }

        return newList;
    }
}