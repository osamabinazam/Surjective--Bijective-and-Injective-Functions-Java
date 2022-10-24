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
        
    }


    public void printEquation (int a_0, int a_1, int a_2, int a_3){
        System.out.printf("Equation : %dx^3%+dx^2%+dx%+d", a_0,a_1,a_2,a_3 );
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

    public boolean drBFunction(){
        if(a_0==3&&a_1==0&&a_2==0&&a_0!=0)
            return true;
        else if(a_3==0&& a_1!=0&&a_2!=0&&a_0!=0)
            return true;
        else if(a_3==0&&a_2==0&&a_1!=0&&a_0!=0)
            return true;
        else if (a_3!=0)
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
            new drBException("Please provide correct value to co-efficients");
        }


        GetFunction gf = new GetFunction();
        gf.setCoefficient(inputs[0],inputs[1],inputs[2],inputs[3]);
        
        //Printing Equation
        gf.getEquation();
    }

    
}
