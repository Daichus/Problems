import java.util.Scanner;
import java.util.Arrays;
public class Problems {

    public static Scanner sc=new Scanner(System.in);


    //第一題
    public static void arrCount(){

        int enterCount=10;
        int []arr=new int[10];
        int index=0;
        int sumOfEven=0,sumOfOdd=0;

         for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
         }
        for(int i=0;i<arr.length;i++){
            if(i%2==0){sumOfEven+=arr[i];}
            else{sumOfOdd+=arr[i];}
        }
        System.out.println(sumOfEven+","+sumOfOdd);

    }

    //第二題
    public static void findFrequency(){
        int []arr=new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0||arr[i]>=10){
                System.out.println("Out of range");
                return;
            }
        }
        if(arr.length>10){
            System.out.println("Out of range");
            return;
        }
        //以Arrays.sort方法將陣列中的元素依照大小排列以方便計算出現次數，以{1,2,2,1}為例，經過排列後呈現{1,1,2,2}的狀態，接著迴圈開始計算1出現的次數，如果下一個不是1，
        //便檢查1出現的次數是不是比儲存在mostFrequency中的值大，如果是，將1出現的次數儲存到mostFrequency中，並將curremtFrequency重設為1以計算下一個數字的出現次數
        Arrays.sort(arr);
        int highestFrequencyNumber=arr[0];
        int currentFrequency=1,mostFrequency=0;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]==arr[i]){
                currentFrequency++;
            }else{
                if(currentFrequency>mostFrequency){
                    mostFrequency=currentFrequency;
                    highestFrequencyNumber=arr[i];
                }
                currentFrequency=1;
            }

        }
        if(currentFrequency>mostFrequency){
            mostFrequency=currentFrequency;
            highestFrequencyNumber=arr[arr.length-1];
        }
        System.out.println(highestFrequencyNumber+","+mostFrequency);

    }
    //第三題
    public static void searchConstellation(){
        //將月與日直接合併轉為數字，1月30日就是1*100加上30
        String[] constellation=new String[]{"Aquarius","Pisces","Aries","Taurus","Gemini","Cancer","Leo","Virgo","Libra","Scorpio","Sagittarius","Capricorn"};
        int [][] daysOfMonth=new int[][]{{121,218},{219,320},{321,420},{421,521},{522,621},{622,722},{723,823},{824,923},{924,1023},{1024,1122},{1123,1221},{1222,1251}};
        int month=sc.nextInt(),day=sc.nextInt();
        int dayCombine=month*100+day;
        //因為12月22~1月20是跨年度，因此直接將1月1日~1月20日的數字強制加上1131以便於比較
        if(dayCombine<=120){
            dayCombine+=1131;
        }

        for(int i=0;i<daysOfMonth.length;i++){

            if(dayCombine>=daysOfMonth[i][0]&&dayCombine<=daysOfMonth[i][1]){
                System.out.println(constellation[i]+"\n");
                return;
            }

        }

    }
    //第四題
    public static void minAndMax(){
        int arr_size=10;
        float []arr=new float[arr_size];
        int i=0;

        do{
            arr[i]=sc.nextFloat();
            i++;

        }while(i<arr_size);


        float min=arr[0],max=arr[0];

        for(int j=1;j<arr.length;j++){
            if(min>arr[j]){
                min=arr[j];
            }
            if(max<arr[j]){
                max=arr[j];
            }
        }
        System.out.printf("max: %.2f\nmin: %.2f",max,min);
    }
    //第五題
    public static void grade(){
        Scanner sc=new Scanner(System.in);
        int score=sc.nextInt();
        String message;


        if(score>=60){
            message=score-90>=0?"pass\nexcellent":"pass";
        }else{
            message=score-50>=0?"almost pass":"fail";
        }
        System.out.println(message);

    }
    //第六題
    public static void printTree(){
        int treeHeight=sc.nextInt();
        int width=treeHeight*2-1;

        for(int row=1;row<=treeHeight;row++){
            for(int blank=0;blank<treeHeight-row;blank++){
                System.out.print(" ");
            }
            for(int star=0;star<row*2-1;star++){
                System.out.print("*");
            }
            System.out.println();
        }
        //打印樹幹部分，(width-3)/2算出應打印的空格數，重複三次
        for(int j=0;j<3;j++) {
            for (int i = 0; i < (width - 3) / 2; i++) {
                System.out.print(" ");
            }
            //直接印出三個星號
            System.out.print("***\n");
        }
    }
    //第七題
    public static void password(){
        int[] digitArr = new int[4];
        int code = sc.nextInt();

        //以透過除以10的餘數的方式逐步取得每一個位的數字,以1234為例，第一次除10的餘數是4，接著將1234除以10變為123，再計算除10的餘數得到3，
        //以此類推
        for (int i = 3; i >= 0 && code > 0; i--) {
            digitArr[i] = ((code % 10) + 7) % 10;
            code /= 10;
        }


        int temp = digitArr[0];
        digitArr[0] = digitArr[2];
        digitArr[2] = temp;

        temp = digitArr[1];
        digitArr[1] = digitArr[3];
        digitArr[3] = temp;

        System.out.println(digitArr[0]+""+digitArr[1]+""+digitArr[2]+""+digitArr[3]+"\n");

    }
    //第九題
    public static void isPalindrome(){
        char [] arr=sc.next().toCharArray();
        int j=arr.length-1;

        //i負責作為從頭開始檢測的陣列指標，j為從尾部開始檢測的指標，j設為陣列長度減1是為了防止超出陣列範圍的發生
        //arr[i]假設i=0，代表arr的頭，arr[j]代表尾部
        for(int i=0;i<=j;i++){
            if(arr[i]!=arr[j]){
                System.out.print("No\n");
                return;
            }
            j--;
        }

        System.out.print("Yes\n");

    }
    //第十題
   public static void counting(){
       int a=sc.nextInt();
       int b=sc.nextInt();

       if(a<=1000&&b<=1000){
           System.out.println(a+"+"+b+"="+(a+b));
           System.out.println(a+"*"+b+"="+(a*b));
           System.out.println(a+"-"+b+"="+(a-b));
           System.out.println(a+"/"+b+"="+(a/b)+"..."+(a%b));
       }
   }

   //第十一題
    public static void matrix(){
        int width=sc.nextInt();
        int height=sc.nextInt()+1;
        int digit=1;

        //每次打印一個數字前，計算它是幾位數。透過5減去位數計算要印出的空格數量
        for(int j=0;j<height;j++) {
            int temp=0;
            for (int i = j; i <=width+j; i++) {
                for(int blank=0;blank<5-countDigit(i);blank++){
                    System.out.print(" ");
                }System.out.print(i);

            }
            System.out.println( );

        }
    }
    //第十一題的調用方法,計算應印出的空格數
    static int countDigit(int i){
        int count=1;
        while(i/10>=1){
            count++;
            i/=10;
        }
        return count;
    }
}
