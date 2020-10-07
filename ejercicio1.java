
class ejercicio1{
    public static void main(String[]args){
      new ejercicio1().run(); 
    }
    public void run(){
        int option;
        Stack<Integer> myStack = new Stack<Integer>(3);
        do{ 
            System.out.println("Ingrese una opcion");
            System.out.println("1. Ingresar valores");
            System.out.println("2. Generar valores aleatorios");
            System.out.println("3. Eliminar Stack");
            System.out.println("4. Eliminar un elemento");
            System.out.println("5. Salir");
            option = Helper.inputNumber();
            switch(option){ 
              case 1:
                    inputStack(myStack,option);
                    show(myStack);
                    break;
              
              case 2:
                    inputStack(myStack,option);
                    show(myStack);
                    break;

              case 3:
                    popStack(myStack);
                    break;
              case 4:
                    System.out.println("Ingrese el indice del elemento que desea eliminar");
                    int index = Helper.inputNumber();
                    myStack.pop(index);
                    show(myStack);
                    break;
            }
        }while(option!= 5);
        System.out.println("<--- END --->");

    }
    public Stack<Integer> inputStack(Stack<Integer> stack,int option){
        int number;
        while(!stack.full()){
            if(option == 1){
                number = Helper.inputNumber();
            }else{
                number = Helper.generateRandomNumber(1000);
            }
            stack.push(number); 
        }
        return stack;
    }
    public void popStack(Stack<Integer> stack){
        System.out.print("Elementos borrados: [ ");
        while(!stack.empty()){ 
          System.out.print(stack.pop() + ", ");
        }
        System.out.println("]");
        
    }
    public void show(Stack<Integer> stack){
        System.out.print("Stack: [");
        for(int i = 0; i < stack.size(); i++){
            System.out.print(stack.get(i)+ ", ");
        }
        System.out.println("]");
    }

}
