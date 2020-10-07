class ejercicio3{
    public static void main(String[] args){
          (new ejercicio3()).run();
     }
    public void run(){
      int option;
      do{
          Stack<Integer> stack = new Stack<Integer>(20);
          System.out.println("1. Ingrese un numero");
          System.out.println("2. Generar un numero");
          System.out.println("3. Salir");
          option = Helper.selectOption(1,3);
          int number;
          if(option == 1){
              number = Helper.inputPositiveNumber();
          }else{
              number = Helper.generateRandomNumber(500);
              System.out.println("Numero Generado: " + number);
          }
          stack = findDivisors(number);
          System.out.print("Divisores: ");
          stack.show();
          if(isPerfectNumber(stack, number)){
              System.out.println("Es un numero perfecto");
          }else{
              System.out.println("No es un numero perfecto");
          }
      }while(option!=3);
    }
    public Stack<Integer> findDivisors(int number){
        Stack<Integer> stack = new Stack<Integer>(20);
        for(int i = 1; i < number; i++){
            if(number % i == 0){
                stack.push(i);
            }
        }
        return stack;
    }
    public boolean isPerfectNumber(Stack<Integer> stack, int number){
        int container = 0;
        while(!stack.empty()){
            container += stack.pop(); 
        }
        return container == number;
    }
      
}
