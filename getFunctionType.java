import java.util.Scanner;

public class getFunctionType {

    private int a_0;
    private int a_1,a_2,a_3;
    private int result;
    
    private boolean boolean_val1;       //Injective
    private boolean boolean_val2;       //Surjecttive
    private boolean boolean_val3;       //Bijective

    getFunctionType(){
        //
        a_0=0;
        a_1=0;
        a_2=0;
        a_3=0;
        boolean_val1=false;
        boolean_val2=false;
        boolean_val3=false;
        result=0;
    }

    getFunctionType(int a_0, int a_1, int a_2, int a_3){
        this.a_0=a_0;
        this.a_1=a_1;
        this.a_2=a_2;
        this.a_3=a_3;
        boolean_val1=false;
        boolean_val2=false;
        boolean_val3=false;
        result=0;
    }


    public void printEquation (int a_0, int a_1, int a_2, int a_3){
        System.out.printf("Equation : %dx^3%+dx^2%+dx%+d", a_3,a_2,a_1,a_0 );
    }

    public void setCoefficient(int a_0, int a_1, int a_2, int a_3){

        this.a_0=a_0;
        this.a_1=a_1;
        this.a_2=a_2;
        this.a_3=a_3;
    }

    public void  getEquation(){
        printEquation(a_0, a_1, a_2, a_3);

    }

    public int drBFunction(){

        Scanner scan = new Scanner(System.in);
        int x=0; 
        System.out.print("\nInput value of x : ");
        try{
        x = scan.nextInt();
        }catch(drBException e ){
            e = new drBException("[-] Error!\n (Domain & Co-Domain Should be integers only)");
            e.printStackTrace();
        }
        

        if(constantFunction()){
            boolean_val1=false;
            boolean_val2=false;
            boolean_val3=false;
        }
        else if (linearFunction()){
            boolean_val1=true;
            boolean_val2=false;
            boolean_val3=false;
        }
        else if (quadraticFunction()){
            boolean_val1=false;
            boolean_val2=false;
            boolean_val3=false;
        }
        else if (cubicFunction()){
            boolean_val1=true;
            boolean_val2=false;
            boolean_val3=false;

        }
        return getResult (x , a_0,a_1,a_2,a_3);

    }
    public void display(){
        int res = drBFunction();
        System.out.println("\n***** General Equation *****");
        System.out.printf("Equation : %dx^3%+dx^2%+dx%+d", a_3,a_2,a_1,a_0 );
        System.out.println();


        System.out.println("\n***** Function Detail *****\n");

        System.out.println("Injective : "+ boolean_val1);
        System.out.println("Surjective : "+ boolean_val2);
        System.out.println("Bijective : "+ boolean_val3);

        System.out.println("\nResult : " + res);
    }
    private int getResult (int x , int a_0, int a_1, int a_2, int a_3){
        return a_0 + (a_1*x)+(a_2*(x*x))+(a_3*(x*x*x));


    }
    
     //Constant Function is always surjective..
     private boolean constantFunction(){
        if(a_0==3&&a_1==0&&a_2==0&&a_0!=0){
                return true;
        }
        else 
            return false;

    }

    //Linear Functions are Alwasys  Injective on Intergers
    private boolean linearFunction(){
        if(a_3==0&&a_2==0&&a_1!=0&&a_0!=0){
            return true;
        }
        else 
            return false;
    }

    //Quadratic Functions are always Surjective.
    private boolean quadraticFunction(){
        if(a_3==0&& a_1!=0&&a_2!=0&&a_0!=0)
            return true;
        else 
            return false;
    }

    
    private boolean cubicFunction (){
        if (a_3!=0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Integer[] inputs = new Integer[4];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Coefficients of the equation:");

        try{
            for(int i=0; i<4; i++){
                System.out.print("a_"+i+": ");
                inputs[i]=scan.nextInt();
            }
        }catch(drBException e){
            e = new drBException("[-] Error!\n (Coefficents Should be integers only)");
            e.printStackTrace();
        }


        getFunctionType gf = new getFunctionType();
        gf.setCoefficient(inputs[0],inputs[1],inputs[2],inputs[3]);
        gf.display();
        
    }

    
}