import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


    public class PartnerQuiz {
        static Db dataBase = new Db();
        static int[] randomNumbers2 = new int[5];
        static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            generateRandomNumbers();
            System.out.print("Player 1 enter your name -> ");
            String player1name = scanner.next();
            System.out.println("Hello " + player1name + ", welcome to the Partners Quiz! Please answer the questions provided and make sure your partner doesn’t see your answers");
            ArrayList<String> answers1 = askQustions(dataBase.readData(1,randomNumbers2));
            System.out.println("Thank you! Pass the test to the Partner and wait for the results! Do not advise!");
            int size = 3;
            for (int m = 0; m < size; m++) {
                for (int n = 0; n <= 4 * size; n++) {
                    double pos1 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - size, 2));
                    double pos2 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - 3 * size, 2));

                    if (pos1 < size + 0.5 || pos2 < size + 0.5) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
                System.out.print(System.lineSeparator());
            }

            for (int m = 1; m <= 2 * size; m++)
            {
                for (int n = 0; n < m; n++) {
                    System.out.print(' ');
                }
                for (int n = 0; n < 4 * size + 1 - 2 * m; n++) {
                    System.out.print("*");
                }
                System.out.print(System.lineSeparator());
            }
            System.out.print("Player 2 enter your name -> ");
            String player2name = scanner.next();
            System.out.println("Hey " + player2name + ", let’s see how well do you know " + player1name + ". Answer the questions and find out!");
            ArrayList<String> answers2 = askQustions(dataBase.readData(2,randomNumbers2));
            scanner.close();
            System.out.println("Let’s see the result!");
            byte score = calculateAnswers(answers1, answers2);
            System.out.println("Points: " + score + "/5");
            switch (score) {
                case 0:
                    System.out.println("Very, very bad, just go and talk with your partner");
                    break;
                case 1:
                    System.out.println("Do you even speak with your partner?");
                    break;
                case 2:
                    System.out.println("Get some wine and break the ice");
                    break;
                case 3:
                    System.out.println("Not bad, but you can do better");
                    break;
                case 4:
                    System.out.println("Great job! Good listener!");
                    break;
                case 5:
                    System.out.println("Oh, love birds!");
                    break;
            }
        }
        private static ArrayList<String> askQustions(ArrayList<String> questions) {
            ArrayList<String> answers = new ArrayList<String>(5);
            for(String question : questions) {
                System.out.print(question.concat(" -> "));
                answers.add(scanner.next().toLowerCase());
            }
            return answers;
        }
        private static byte calculateAnswers(ArrayList<String> answers1,ArrayList<String> answers2) {
            byte correct = 5;
            for(byte i=0;i<5;++i) {
                String word1 = answers1.get(i);
                String word2 = answers2.get(i);
                int min = Math.min(word1.length(), word2.length());
                int diff = Math.max(word1.length(), word2.length())-min;
                if(diff>1) {
                    --correct;
                    continue;
                }
                char[] wordc1 = word1.toLowerCase().toCharArray();
                char[] wordc2 = word2.toLowerCase().toCharArray();
                boolean hasworderror = diff==1;
                for(short j = 0;j<min;++j) {
                    if(hasworderror) {
                        if(wordc1[j]!=wordc2[j]) {
                            --correct;
                            break;
                        }
                    } else hasworderror = wordc1[j]!=wordc2[j];
                }
            }
            return correct;
        }

        private static void generateRandomNumbers(){
            Random rand = new Random();
            HashSet <Integer> randomNumbers = new HashSet<>();
            randomNumbers.add(rand.nextInt(19)+1);
            while(randomNumbers.size() < 5){
                randomNumbers.add(rand.nextInt(19)+1);
            }
            int j =0;
            for (int i: randomNumbers){
                randomNumbers2[j++] = i;
            }
        }
    }
