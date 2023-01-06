package day04;

public class Calculator {
    
    public static double calc(int first, int second, String operand){

        double output=0d;

        if(operand.equals("+")){
            output = first + second;
        } else if (operand.equals("-")){
            output = first - second;
        } else if (operand.equals("*")){
            output = first * second;
        } else if (operand.equals("/")){
            output = first / second;
        }

        // switch operand {
        //     case '+':{
        //         output = first + second;
        //         break;
        //     }
        //     case '-':{
        //         output = first + second;
        //         break;
        //     }
        // }

        return output;
    }

}
