import java.util.Scanner;

public class getFunctionType {

    
    private int a_0,a_1,a_2,a_3;
    private boolean boolean_val1;       //Injective
    private boolean boolean_val2;       //Surjecttive
    private boolean boolean_val3;       //Bijective


    //Constructor 1 (Without Parameters)
    getFunctionType(){
        //
        a_0=0;
        a_1=0;
        a_2=0;
        a_3=0;
        boolean_val1=false;
        boolean_val2=false;
        boolean_val3=false;
    }

    //Constructor 2 (With parameters)
    getFunctionType(int a_0, int a_1, int a_2, int a_3){

        //Assigning value to private fields
        this.a_0=a_0;
        this.a_1=a_1;
        this.a_2=a_2;
        this.a_3=a_3;
        boolean_val1=false;
        boolean_val2=false;
        boolean_val3=false;
    }

    /*Method that takes coefficiet as inputs and assign them to private fields of 
    class in case when coefficient values are not passed in constructor*/
    public void setCoefficient(int a_0, int a_1, int a_2, int a_3){

        this.a_0=a_0;
        this.a_1=a_1;
        this.a_2=a_2;
        this.a_3=a_3;
    } //end of the method


    public void drBFunction(){

        Scanner scan = new Scanner(System.in);                          //Scanner Object used to get input
        int x=0;                                                        //Represent the value of x
        System.out.print("\nInput value of x : ");
        try{
            try {
                x=scan.nextInt();                                       //Inputing value of x
            } catch (Exception e) {
                // TODO: handle exception
                /*
                 * Catching Exception and  throwing my own exception so that my exception class handled 
                 */
               throw new drBException("[-]--> Error!...\n(Domain & Co-Domain Should be integers only)");
            }
        }catch(drBException e ){
            System.out.println("Caught!...");
            System.out.println(e.getMessage());             //Printing My Own Message
            throw new drBException("");
        }
        
        /*
         * Determining the function(Surjective,Innjective and Bijective) and setting boolean value accordingly.
         */

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

    } //end of drBFunction

    //Print the necessary detail...
    public void display(){

        try{
        drBFunction();
        }catch(drBException e){
            return;
        }
        System.out.println("\n***** General Equation *****");
        System.out.printf("Equation : %dx^3%+dx^2%+dx%+d", a_3,a_2,a_1,a_0 );
        System.out.println();


        System.out.println("\n***** Function Detail *****\n");

        System.out.println("Injective : "+ boolean_val1);
        System.out.println("Surjective : "+ boolean_val2);
        System.out.println("Bijective : "+ boolean_val3);

    }

     //Determine wheather given function is Linear or not using coefficient
     private boolean constantFunction(){
        if(a_0==3&&a_1==0&&a_2==0&&a_0!=0){
                return true;
        }
        else 
            return false;

    }

    //Determine wheather given function is Linear or not using coefficient
    private boolean linearFunction(){
        if(a_3==0&&a_2==0&&a_1!=0&&a_0!=0){
            return true;
        }
        else 
            return false;
    }

    //Determine wheather given function is Quadratic or not using coefficient
    private boolean quadraticFunction(){
        if(a_3==0&& a_1!=0&&a_2!=0&&a_0!=0)
            return true;
        else 
            return false;
    }

    //Method Determine wheater the given function is cubic function or not using coefficient
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

        /*
         * Inputing Coefficient and handling input exception
         */

        try{
            for(int i=0; i<4; i++){
                System.out.print("a_"+i+": ");
                try{
                inputs[i]=scan.nextInt();
                }catch(Exception e)
                {
                    throw new drBException("[-]--> Error!...\n(Coefficient Should be integers only) ");
                }
                
            }
        }catch(drBException e){
            System.out.println("Caught");
            System.out.println(e.getMessage());
            return;
        }


        getFunctionType gf = new getFunctionType();
        gf.setCoefficient(inputs[0],inputs[1],inputs[2],inputs[3]);
        gf.display();
        
    } //End of the Main Method...

    
}