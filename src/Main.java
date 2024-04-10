import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Method 2
        Scanner sc=new Scanner(System.in);
        int []arr=new int[200];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<arr.length;i++){
                int cokeNumber=arr[i];
                if(cokeNumber==0)break;
                int emptyBottles = cokeNumber;
                int totalCokeHave=cokeNumber;

                while(emptyBottles>=3){
                    totalCokeHave+=emptyBottles/3;
                    emptyBottles=emptyBottles/3+emptyBottles%3;

                }
                if(emptyBottles==2){
                    totalCokeHave+=1;

                }
                System.out.println(totalCokeHave);


        }
    }


}