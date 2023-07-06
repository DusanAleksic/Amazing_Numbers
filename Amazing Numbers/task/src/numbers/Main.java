package numbers;

import java.util.*;

public class Main {

    static String[] removeDuplicates(String tok[],String tok2[]){
        List<String> copy = new ArrayList<>();
        for(int i=0,j=0;i<tok.length;i++){
            if(Character.isDigit( tok[i].charAt(0)) && i==0 )
                copy.add(tok[i]);
            else if(Character.isDigit( tok[i].charAt(0)) && i==1 )
                copy.add(tok[i]);
            else if(!copy.contains(tok[i]))
                copy.add(tok[i]);
        }
        tok2 = new String[copy.size()];
        for(int i=0;i<copy.size();i++){
            tok2[i] = copy.get(i);
        }
        return tok2 ;
    }
    static int happy=0,sad=0,buzz=0,duck=0,palindromic=0,gapful=0,spy=0,square=0,sunny=0,even=0,odd=0,
    jumping=0;
    static boolean isNaturalNumber(long number){
        return number>0;
    }

    static void restoreValues(){
        buzz=0; duck=0; palindromic=0; gapful=0; spy=0; square=0; sunny=0; even=0; odd=0;
        jumping=0; happy=0; sad=0;
    }
    static void chooseProperty(String choice){
        if(choice.toUpperCase().equals("BUZZ"))
            buzz=1;
        else if(choice.toUpperCase().equals("DUCK"))
            duck=1;
        else if(choice.toUpperCase().equals("PALINDROMIC"))
            palindromic=1;
        else if(choice.toUpperCase().equals("GAPFUL"))
            gapful=1;
        else if(choice.toUpperCase().equals("SPY"))
            spy=1;
        else if(choice.toUpperCase().equals("SQUARE"))
            square=1;
        else if(choice.toUpperCase().equals("SUNNY"))
            sunny=1;
        else if(choice.toUpperCase().equals("EVEN"))
            even=1;
        else if(choice.toUpperCase().equals("ODD"))
            odd=1;
        else if(choice.toUpperCase().equals("JUMPING"))
            jumping=1;
        else if(choice.toUpperCase().equals("HAPPY"))
            happy=1;
        else if(choice.toUpperCase().equals("SAD"))
            sad=1;
        else if(choice.toUpperCase().equals("-BUZZ"))
            buzz=2;
        else if(choice.toUpperCase().equals("-DUCK"))
            duck=2;
        else if(choice.toUpperCase().equals("-PALINDROMIC"))
            palindromic=2;
        else if(choice.toUpperCase().equals("-GAPFUL"))
            gapful=2;
        else if(choice.toUpperCase().equals("-SPY"))
            spy=2;
        else if(choice.toUpperCase().equals("-SQUARE"))
            square=2;
        else if(choice.toUpperCase().equals("-SUNNY"))
            sunny=2;
        else if(choice.toUpperCase().equals("-EVEN"))
            even=2;
        else if(choice.toUpperCase().equals("-ODD"))
            odd=2;
        else if(choice.toUpperCase().equals("-JUMPING"))
            jumping=2;
        else if(choice.toUpperCase().equals("-HAPPY"))
            happy=2;
        else if(choice.toUpperCase().equals("-SAD"))
            sad=2;
    }

    static boolean isHapppy(long number){
        long tempNumber = number;
        long tempNumber2 = 0,tempNumber3=number;
        long sum=0;
        List<Long> sequenceOfNumbers = new ArrayList<>();
        while(sum!=1 || sum!=tempNumber){
            for(int i=0;i<numberOfDigits(tempNumber3);i++){
                tempNumber2=number%10;
                sum+=Math.pow(tempNumber2,2);
                number/=10;
            }
            if(sequenceOfNumbers.contains(sum)){
                return false;
            }
            sequenceOfNumbers.add(sum);
            if(sum==1){
                return true;
            }
            else if(sum==tempNumber){
                return false;
            }
            else {
                tempNumber3=sum;
                number=sum;
                sum=0;
            }
        }
        return false;
    }

    static String isHapppyString(long number){
        long tempNumber = number;
        long tempNumber2 = 0,tempNumber3=number;
        long sum=0;
        List<Long> sequenceOfNumbers = new ArrayList<>();
        while(sum!=1 || sum!=tempNumber){
            for(int i=0;i<numberOfDigits(tempNumber3);i++){
                tempNumber2=number%10;
                sum+=Math.pow(tempNumber2,2);
                number/=10;
            }
            if(sequenceOfNumbers.contains(sum)){
                return "";
            }
            sequenceOfNumbers.add(sum);

            if(sum==1){
                return "happy";
            }
            else if(sum==tempNumber){
                return "";
            }
            else {
                tempNumber3=sum;
                number=sum;
                sum=0;
            }
        }
        return "false";
    }

    static String isSadString(long number){
        long tempNumber = number;
        long tempNumber2 = 0,tempNumber3=number;
        long sum=0;
        List<Long> sequenceOfNumbers = new ArrayList<>();
        while(sum!=1 || sum!=tempNumber){
            for(int i=0;i<numberOfDigits(tempNumber3);i++){
                tempNumber2=number%10;
                sum+=Math.pow(tempNumber2,2);
                number/=10;
            }
            if(sequenceOfNumbers.contains(sum)){
                return "sad";
            }
            sequenceOfNumbers.add(sum);

            if(sum==1){
                return "";
            }
            else if(sum==tempNumber){
                return "sad";
            }
            else {
                tempNumber3=sum;
                number=sum;
                sum=0;
            }
        }
        return "false";
    }
    static boolean isOdd(long number){
        return number%2==1;
    }

    static String isOddString(long number){
        if(number%2==1)
            return "odd";
        return "even";
    }
    static boolean isJumping(long number){
        while (number>10){
            int lastDigit = (int) (number%10);
            int nextToLast = (int) ((number%100)/10);
            if(Math.abs(lastDigit-nextToLast)!=1)
                return false;
            number/=10;
        }
        return true;
    }
    static String isJumpingString(long number){
        while (number>10){
            int lastDigit = (int) (number%10);
            int nextToLast = (int) ((number%100)/10);
            if(Math.abs(lastDigit-nextToLast)!=1)
                return "";
            number/=10;
        }
        return "jumping";
    }
    static boolean isBuzzNew(long number){
        return divisibleBySeven(number) || endsWithSeven(number);
    }
    static String isBuzzString (long number){
        if(divisibleBySeven(number) || endsWithSeven(number))
            return "buzz";
        return "";
    }
    static boolean isDuck(long number){
        while (number>9){
            if(number%10==0)
                return true;
            else
                number/=10;
        }
        return false;
    }
    static String isDuckString(long number){
        while (number>9){
            if(number%10==0)
                return "duck";
            else
                number/=10;
        }
        return "";
    }
    static boolean isPalindromic(long number){
        if(number/10==0)
            return true;
        else {
            long r,sum=0,temp;

            temp=number;
            while(number>0){
                r=number%10;
                sum=(sum*10)+r;
                number=number/10;
            }
            if(temp==sum)
                return true;
        }
        return false;

    }

    static String isPalindromicString(long number){
        if(number/10==0)
            return "palindromic";
        else {

            long r,sum=0,temp;
            temp=number;
            while(number>0){
                r=number%10;
                sum=(sum*10)+r;
                number=number/10;
            }
            if (temp!=sum)
                return "";
        }
        return "palindromic";
    }

    static boolean isGapful(long number){
        if(numberOfDigits(number)<3)
            return false;
        long firstDigit=0;
        long lastDigit=0;
        lastDigit = number%10;
        firstDigit = number/(long)(Math.pow(10,numberOfDigits(number)-1));
        long divisor = firstDigit*10+lastDigit;
        if(number % divisor == 0)
            return true;
        return false;
    }

    static String isGapfulString(long number){
        if(numberOfDigits(number)<3)
            return "";
        long firstDigit=0;
        long lastDigit=0;
        lastDigit = number%10;
        firstDigit = number/(long)(Math.pow(10,numberOfDigits(number)-1));
        long divisor = firstDigit*10+lastDigit;
        if(number % divisor == 0)
            return "gapful";
        return "";
    }

    static boolean isSpy(long number){
        if(number<10)
            return true;
        long digitsArray[] = new long[numberOfDigits(number)];
        int n=0,sum=0,product=1;
        while(number>0){
            digitsArray[n++]=number%10;
            number/=10;
        }
        for(int i=0;i<digitsArray.length;i++){
            sum+=digitsArray[i];
            product*=digitsArray[i];
        }
        return sum==product;
    }

    static String isSpyString(long number){
        if(number<10)
            return "spy";
        long digitsArray[] = new long[numberOfDigits(number)];
        int n=0,sum=0,product=1;
        while(number>0){
            digitsArray[n++]=number%10;
            number/=10;
        }
        for(int i=0;i<digitsArray.length;i++){
            sum+=digitsArray[i];
            product*=digitsArray[i];
        }
        if(sum==product)
            return "spy";
        return "";

    }

    static boolean isSquare(long number){

        double sqrt = Math.sqrt((double) number);
        return (sqrt-Math.floor(sqrt))==0;
    }
    static String isSquareString(long number){

        double sqrt = Math.sqrt((double) number);
        if ((sqrt-Math.ceil(sqrt))==0)
            return "square";
        return "";
    }
    static boolean isSunny(long number){
        return isSquare(number+1);
    }
    static String isSunnyString(long number){
        if(isSquare(number+1))
            return "sunny";
        return "";
    }

    static int numberOfDigits(long number){
        int n=0;
        while(number>0){
            number/=10;
            n++;
        }
        return n;
    }
    static boolean endsWithSeven(long number){
        return number%10==7;
    }
    static boolean divisibleBySeven(long number){
        long lastDigit = number%10;
        number/=10;
        number=number-lastDigit*2;
        return number%7==0;
    }
    static void infoScreen(){
        System.out.println("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }
    static void availableProperties(){
        System.out.println("Available properties: [EVEN,ODD,BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE,SUNNY," +
                "JUMPING,HAPPY,SAD]");
    }

    static  void showProperties(long number){
        System.out.println(number +" is "+isBuzzString(number)+" "+
                isDuckString(number)+ " "+isPalindromicString(number)+
                " "+isGapfulString(number)+" "+isSpyString(number)+" "+
                isSquareString(number)+" "+isSunnyString(number)+" "+isJumpingString(number)+
                " "+isHapppyString(number)+" "+isSadString(number)+" "+isOddString(number));
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        infoScreen();
        String properties[] = {"EVEN", "ODD", "BUZZ", "DUCK","PALINDROMIC", "GAPFUL", "SPY","SUNNY","SQUARE",
        "JUMPING","HAPPY","SAD",
        "-EVEN", "-ODD", "-BUZZ", "-DUCK","-PALINDROMIC", "-GAPFUL", "-SPY","-SUNNY","-SQUARE",
        "-JUMPING","-HAPPY","-SAD"};

        List<String> prop = new ArrayList<>();
        List<String> forbiddenCombination1 = new ArrayList<>();
        List<String> forbiddenCombination2 = new ArrayList<>();
        List<String> forbiddenCombination3 = new ArrayList<>();
        List<String> forbiddenCombination4 = new ArrayList<>();
        List<String> forbiddenCombination5 = new ArrayList<>();
        List<String> forbiddenCombination6 = new ArrayList<>();
        List<String> forbiddenCombination7 = new ArrayList<>();
        List<String> forbiddenCombination8 = new ArrayList<>();
        List<String> forbiddenCombination9 = new ArrayList<>();
        List<String> forbiddenCombination10 = new ArrayList<>();
        List<String> forbiddenCombination11 = new ArrayList<>();
        List<String> forbiddenCombination12 = new ArrayList<>();
        List<String> forbiddenCombination13 = new ArrayList<>();
        List<String> forbiddenCombination14 = new ArrayList<>();
        List<String> forbiddenCombination15 = new ArrayList<>();
        List<String> forbiddenCombination16 = new ArrayList<>();
        List<String> forbiddenCombination17 = new ArrayList<>();

        List<String> wrongProperties = new ArrayList<>();
        for(String s : properties){
            prop.add(s);
        }
        forbiddenCombination1.add("ODD");
        forbiddenCombination1.add("EVEN");
        forbiddenCombination2.add("DUCK");
        forbiddenCombination2.add("SPY");
        forbiddenCombination3.add("SUNNY");
        forbiddenCombination3.add("SQUARE");
        forbiddenCombination4.add("HAPPY");
        forbiddenCombination4.add("SAD");
        forbiddenCombination5.add("-ODD");
        forbiddenCombination5.add("-EVEN");
        forbiddenCombination6.add("-ODD");
        forbiddenCombination6.add("ODD");
        forbiddenCombination7.add("EVEN");
        forbiddenCombination7.add("-EVEN");
        forbiddenCombination8.add("-BUZZ");
        forbiddenCombination8.add("BUZZ");
        forbiddenCombination9.add("DUCK");
        forbiddenCombination9.add("-DUCK");
        forbiddenCombination10.add("PALINDROMIC");
        forbiddenCombination10.add("-PALINDROMIC");
        forbiddenCombination11.add("GAPFUL");
        forbiddenCombination11.add("-GAPFUL");
        forbiddenCombination12.add("SPY");
        forbiddenCombination12.add("-SPY");
        forbiddenCombination13.add("SQUARE");
        forbiddenCombination13.add("-SQUARE");
        forbiddenCombination14.add("SUNNY");
        forbiddenCombination14.add("-SUNNY");
        forbiddenCombination15.add("JUMPING");
        forbiddenCombination15.add("-JUMPING");
        forbiddenCombination16.add("HAPPY");
        forbiddenCombination16.add("-HAPPY");
        forbiddenCombination17.add("SAD");
        forbiddenCombination17.add("-SAD");

        while(true){
            System.out.print("\nEnter a request : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String tok[] =  input.split(" ");
            if(tok[0].equals("0")){
                System.out.println("Goodbye!");
                System.exit(0);
            }
            if(input.isEmpty()){
                infoScreen();
                continue;
            }

            String tok2[] = null;
            tok2 = removeDuplicates(tok,tok2);
           boolean inputIsNumber = true;
            // MORAS NOVI METOD ZA PROVERE VISE ULAZNIH PARAMETARA (VISE OD 4)

            for(int i1=0,f1=0,f2=0,f3=0,f4=0,f5=0,f6=0,f7=0,f8=0,f9=0,f10=0,f11=0,f12=0,
                f13=0,f14=0,f15=0,f16=0,f17=0;i1<tok2.length-2;i1++){
                if(tok2.length>=4){
                    if(forbiddenCombination1.contains(tok2[i1+2].toUpperCase()))
                        f1++;
                    if(forbiddenCombination2.contains(tok2[i1+2].toUpperCase()))
                        f2++;
                    if(forbiddenCombination3.contains(tok2[i1+2].toUpperCase()))
                        f3++;
                    if(forbiddenCombination4.contains(tok2[i1+2].toUpperCase()))
                        f4++;
                    if(forbiddenCombination5.contains(tok2[i1+2].toUpperCase()))
                        f5++;
                    if(forbiddenCombination6.contains(tok2[i1+2].toUpperCase()))
                        f6++;
                    if(forbiddenCombination7.contains(tok2[i1+2].toUpperCase()))
                        f7++;
                    if(forbiddenCombination8.contains(tok2[i1+2].toUpperCase()))
                        f8++;
                    if(forbiddenCombination9.contains(tok2[i1+2].toUpperCase()))
                        f9++;
                    if(forbiddenCombination10.contains(tok2[i1+2].toUpperCase()))
                        f10++;
                    if(forbiddenCombination11.contains(tok2[i1+2].toUpperCase()))
                        f11++;
                    if(forbiddenCombination12.contains(tok2[i1+2].toUpperCase()))
                        f12++;
                    if(forbiddenCombination13.contains(tok2[i1+2].toUpperCase()))
                        f13++;
                    if(forbiddenCombination14.contains(tok2[i1+2].toUpperCase()))
                        f14++;
                    if(forbiddenCombination15.contains(tok2[i1+2].toUpperCase()))
                        f15++;
                    if(forbiddenCombination16.contains(tok2[i1+2].toUpperCase()))
                        f16++;
                    if(forbiddenCombination17.contains(tok2[i1+2].toUpperCase()))
                        f17++;
                }
                if(f1==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
                            "There are no numbers with these properties.");
                }
               else if (f2==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                            "There are no numbers with these properties.");
                }
               else if (f3==2){
                    System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f4==2){
                    System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f5==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [-ODD, -EVEN]\n" +
                            "There are no numbers with these properties.");
                }
                else if (f6==2){
                    System.out.println("The request contains mutually exclusive properties: [-ODD, ODD]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f7==2){
                    System.out.println("The request contains mutually exclusive properties: [-EVEN, EVEN]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f8==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [BUZZ, -BUZZ]\n" +
                            "There are no numbers with these properties.");
                }
                else if (f9==2){
                    System.out.println("The request contains mutually exclusive properties: [DUCK, -DUCK]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f10==2){
                    System.out.println("The request contains mutually exclusive properties: [PALINDROMIC, -PALINDROMIC]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f11==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [GAPFUL, -GAPFUL]\n" +
                            "There are no numbers with these properties.");
                }
                else if (f12==2){
                    System.out.println("The request contains mutually exclusive properties: [SPY, -SPY]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f13==2){
                    System.out.println("The request contains mutually exclusive properties: [SQUARE, -SQUARE]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f14==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [SUNNY, -SUNNY]\n" +
                            "There are no numbers with these properties.");
                }
                else if (f15==2){
                    System.out.println("The request contains mutually exclusive properties: [JUMPING, -JUMPING]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f16==2){
                    System.out.println("The request contains mutually exclusive properties: [HAPPY, -HAPPY]\n" +
                            "There are no numbers with these properties.");
                    inputIsNumber=false;
                }
                else if (f17==2){
                    inputIsNumber=false;
                    System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                            "There are no numbers with these properties.");
                }
            }


            testForNum: for(int i=0,k=2;i<tok2.length;i++,k++){
                for(int j=0;j<tok2[i].length();j++){
                    if(!Character.isDigit(tok2[i].charAt(j)) && i==0) {
                        System.out.println("The first parameter should be a natural number or zero.");
                        inputIsNumber=false;
                        break testForNum;
                    }
                    else if (!Character.isDigit(tok2[i].charAt(j)) && i==1){
                        System.out.println("The second parameter should be a natural number.");
                        inputIsNumber=false;
                        break testForNum;
                    } else if (tok2.length==3 ){
                        if(!prop.contains(tok2[2].toUpperCase())){
                            System.out.println("The property ["+tok2[2].toUpperCase()+"] is wrong.");
                            availableProperties();
                            inputIsNumber=false;
                            break testForNum;
                        }
                    }
                    else if (tok2.length>=4){
                        if(!prop.contains(tok2[k].toUpperCase()) && !wrongProperties.contains(tok2[k].toUpperCase())){
                            wrongProperties.add(tok2[k].toUpperCase());
                        }
                        if(k==tok2.length-1)
                            k--;
                        if(i== tok2.length-1){
                            if(wrongProperties.size()==1){
                                System.out.println("The property ["+wrongProperties.get(0)+"] is wrong.");
                                availableProperties();
                                inputIsNumber=false;
                                break testForNum;
                            }
                            else if(wrongProperties.size()>=1) {
                                String wrongPropertiesString = "";
                                for(int z=0;z<wrongProperties.size();z++){
                                    if(z==wrongProperties.size()-1)
                                        wrongPropertiesString = wrongPropertiesString.concat(wrongProperties.get(z));
                                    else
                                        wrongPropertiesString = wrongPropertiesString.concat(wrongProperties.get(z)).concat(", ");
                                }
                                System.out.println("The properties ["+wrongPropertiesString+"] are wrong.");
                                availableProperties();
                                inputIsNumber=false;
                                break testForNum;
                            }
                        }

                    }
                }

            }
            if(!inputIsNumber)
                continue;
            long number = Long.parseLong(tok2[0]);

            if(number==0){
                System.out.println("Goodbye!");
                break;
            }
            if(!isNaturalNumber(number)){
                System.out.println("\nThe first parameter should be a natural number or zero.");
                continue;
            }
            if(tok2.length==1){
                System.out.println("Properties of "+number);
                System.out.println("buzz: "+isBuzzNew(number));
                System.out.println("duck: "+isDuck(number));
                System.out.println("palindromic: "+isPalindromic(number));
                System.out.println("gapful: "+isGapful(number));
                System.out.println("spy: "+isSpy(number));
                System.out.println("square: "+isSquare(number));
                System.out.println("sunny: "+isSunny(number));
                System.out.println("jumping: "+isJumping(number));
                System.out.println("happy: "+isHapppy(number));
                System.out.println("sad: "+!isHapppy(number));
                System.out.println("even: "+!isOdd(number));
                System.out.println("odd: "+isOdd(number));
            } else if (tok2.length==2){
                int numbersProcessed = Integer.parseInt(tok2[1]);
                for(int i=0;i<numbersProcessed;i++,number++){
                    System.out.println(number +" is "+isBuzzString(number)+" "+
                           isDuckString(number)+ " "+isPalindromicString(number)+
                            " "+isGapfulString(number)+" "+isSpyString(number)+" "+isSquareString(number)
                            + " "+ isSunnyString(number)+" "+isJumpingString(number)+" "+
                            isHapppyString(number)+ " "+isSadString(number)+" "+isOddString(number));
                }
            }else if(tok2.length==3){
                int numbersProcessed = Integer.parseInt(tok2[1]);
                for(int i=0;i<numbersProcessed;number++){
                    switch (tok2[2].toUpperCase()){
                        case "BUZZ"  : if(isBuzzNew(number)){
                            showProperties(number);
                            i++;
                        }

                        break;
                        case "DUCK"  : if(isDuck(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "PALINDROMIC"  : if(isPalindromic(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "GAPFUL"  :  if(isGapful(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "SPY"  :  if(isSpy(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "EVEN"  : if(!isOdd(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "ODD"  : if(isOdd(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "SUNNY"  : if(isSunny(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "SQUARE"  : if(isSquare(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "JUMPING"  : if(isJumping(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "HAPPY"  : if(isHapppy(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "SAD"  : if(!isHapppy(number)){
                            showProperties(number);
                            i++;
                        }
                        break;
                        case "-BUZZ"  : if(!isBuzzNew(number)){
                            showProperties(number);
                            i++;
                        }

                            break;
                        case "-DUCK"  : if(!isDuck(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-PALINDROMIC"  : if(!isPalindromic(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-GAPFUL"  :  if(!isGapful(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-SPY"  :  if(!isSpy(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-EVEN"  : if(isOdd(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-ODD"  : if(!isOdd(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-SUNNY"  : if(!isSunny(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-SQUARE"  : if(!isSquare(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-JUMPING"  : if(!isJumping(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-HAPPY"  : if(!isHapppy(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                        case "-SAD"  : if(isHapppy(number)){
                            showProperties(number);
                            i++;
                        }
                            break;
                    }
                }
            }  else if (tok2.length>=4){
                int numbersProcessed = Integer.parseInt(tok2[1]);
                restoreValues();
                for(int i=2;i<tok2.length;i++){
                    chooseProperty(tok2[i]);
                }
                int border = tok2.length-2;
                int numberOfChoices=0;

                for(int i=0;i<numbersProcessed;number++){

                    if(buzz==1){
                        if(isBuzzNew(number)){
                            numberOfChoices++;
                        }

                    }
                    if(duck==1){
                        if(isDuck(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }

                    }
                    if(palindromic==1){
                        if(isPalindromic(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(gapful==1){
                        if(isGapful(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(spy==1){
                        if(isSpy(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(square==1){
                        if(isSquare(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(sunny==1){
                        if(isSunny(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(jumping==1){
                        if(isJumping(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(even==1){
                        if(!isOdd(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(odd==1){
                        if(isOdd(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(happy==1){
                        if(isHapppy(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(sad==1){
                        if(!isHapppy(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }

                    if(buzz==2){
                        if(!isBuzzNew(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }

                    }
                    if(duck==2){
                        if(!isDuck(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }

                    }
                    if(palindromic==2){
                        if(!isPalindromic(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(gapful==2){
                        if(!isGapful(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(spy==2){
                        if(!isSpy(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(square==2){
                        if(!isSquare(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(sunny==2){
                        if(!isSunny(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(jumping==2){
                        if(!isJumping(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(even==2){
                        if(isOdd(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(odd==2){
                        if(!isOdd(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(happy==2){
                        if(!isHapppy(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(sad==2){
                        if(isHapppy(number)){
                            numberOfChoices++;
                            if(numberOfChoices==border){
                                showProperties(number);
                                numberOfChoices=0;
                                i++;
                                continue;
                            }
                        }
                    }
                    if(numberOfChoices!=border)
                        numberOfChoices=0;
                }
            }
        }
    }
}
