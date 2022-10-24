import java.util.Scanner;

public class GetFunction {

    private int a_0;
    private int a_1,a_2,a_3;
    private String equation= null;

    GetFunction(){
        //
        a_0=0;
        a_1=0;
        a_2=0;
        a_3=0;
    }

    GetFunction(int a_0, int a_1, int a_2, int a_3){
        this.a_0=a_0;
        this.a_1=a_1;
        this.a_2=a_2;
        this.a_3=a_3;
        setEquation(a_0, a_1, a_2, a_3);
    }

    public void setEquation (int a_0, int a_1, int a_2, int a_3){
        if(a_0>0 && a_1>0&&a_2>0&&a_3>0)
        this.equation=a_0+"+"+a_1+"x+"+a_2+"x^2+"+a_3+"x^3";
        else if(a_0<0 && a_1<0&&a_2<0&&a_3<0)
        this.equation="-"+(a_0*-1)+"-"+(a_1*-1)+"x-"+(a_2*-1)+"x^2-"+(a_3*-1)+"x^3";
        else if (a_0==0 && a_1==0&&a_2==0&&a_3==0)
        this.equation=a_0+"+"+a_1+"x+"+a_2+"x^2+"+a_3+"x^3 = 0";
        else 
            System.out.println("Error!...");

    }

    public void setCoefficient(int a_0, int a_1, int a_2, int a_3){

        this.a_0=a_0;
        this.a_1=a_1;
        this.a_2=a_2;
        this.a_3=a_3;
        setEquation(a_0, a_1, a_2, a_3);
    }

    public String getEquation(){
        return equation;

    }

    //Constant Function is always surjective..
    private boolean constantFunction(){
        if(a_0==3&&a_1==0&&a_2==0&&a_0!=0){
                return true;
        }
        else 
            return false;

    }

    //Linear Functions are Alwasys Bijective
    private boolean linearFunction(){
        if(a_3==0&&a_2==0&&a_1!=0&&a_0!=0){
            return true;

        }
        else 
            return false;
    }

    //Quadratic Functions are always Surjective or it can be injective.
    private boolean quadraticFunction(){
        if(a_3==0&& a_1!=0&&a_2!=0&&a_0!=0)
            return true;
        else 
            return false;
    }

    public static void main(String[] args) {
        Integer[] inputs = new Integer[4];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Coefficients of the equation:");
        for(int i=0; i<4; i++){
            System.out.print("a_"+i+": ");
            inputs[i]=scan.nextInt();
        }
        GetFunction gf = new GetFunction();
        gf.setCoefficient(inputs[0],inputs[1],inputs[2],inputs[3]);
        System.out.println("Equation : " + gf.getEquation());
    }

    
}
