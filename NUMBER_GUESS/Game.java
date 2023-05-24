import java.util.Scanner;

class Game{
    public static Scanner sc = new Scanner(System.in);
    public static void fnGame(int number, int attemptLimit){
        int count=0, at = attemptLimit;
        while(count!=attemptLimit){
            System.out.println("Enter the Number Between 1-100: ");
            int temp = sc.nextInt();
            count++;
            if(temp==number){
                System.out.println("Matched-> The number was: "+number);
                // count++;
                System.out.println("Attempt Taken - "+count);
                System.out.println("Attempt Remain: "+ --at);
                System.out.println("You Scored ->>>>>>>>>>>>>>>>>>>>>>>>>>>> "+at);
                return;
            }
            else if(temp>number){
                System.out.println("Entered number bigger");
                System.out.println("Attempt Remain: "+ --at);
            }
            else{
                System.out.println("Entered number Smaller");
                System.out.println("Attempt Remain: "+ --at);
            }
        }
        System.out.println("xxxxxxxxxxxxxxxxxx You Failed Try Again xxxxxxxxxxxxxxxx");
        System.out.println("The Number was -> "+number);

    }
    public static void main(String[] args) {
        int number = (int) (Math.random()*100);
        int choice;
        System.out.println("-----------------------WELCOME TO THE GAME---------------------\nRemember the less no. of attempts you take the more you scored.");
        System.out.println("Choose deficulty level\n1.Easy 2.Medium 3.Hard");
        
        choice = sc.nextInt();
        switch(choice){
            case 1:
            System.out.println("You have 20 Limits");
            fnGame(number, 20);
            break;
            case 2:
            System.out.println("You have only 6 Limits");
            fnGame(number, 6);
            break;
            case 3:
            System.out.println("You have only 3 Limits");
            fnGame(number, 3);
        }

    }
}