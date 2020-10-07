class ejercicio4{

    public static void main(String[] args){
        (new ejercicio4()).run();
    }
    public void run(){ 
          Stack<Character> stack = new Stack<Character>(20);
          System.out.println("Selecciones una opcion");
          System.out.println("1. Ingresar letras");
          System.out.println("2. Generar aleatoriamente");
          int option = Helper.selectOption(1,2);
          char character;
          int countCharactersGenerated = 0;
          do{
              System.out.println("Ingrese una letra");
              if(option == 1){
                  character = Helper.inputChar();
              }else{
                  character = Helper.generateRandomCharacter();
                  countCharactersGenerated++;
              }
              if(stack.empty()){
                  stack.push(character);
              }else{
                  sortStack(stack,character);
              }
              System.out.print("Letras: ");
              stack.show();
              if(countCharactersGenerated >= 10){
                  character = '@';
              }

          }while((character != '@') || ( option != 2));
          int consonants = countConsonants(stack);
          System.out.println("Cantidaa de Consonantes: "+ consonants);
    }

    public Stack<Character> sortStack(Stack<Character> stack, char c){
        Stack<Character> temp = new Stack<Character>(20);
        while(!stack.empty() && c < stack.peek()){
            temp.push(stack.pop());
        }
        stack.push(c);
        while(!temp.empty()){
            stack.push(temp.pop());
        }
        return stack;
    }

    public int countConsonants(Stack<Character> stack){
        int count = 0;
        while(!stack.empty()){
            if(isConsonant(stack.pop())){
                count++;
            }
        }
        return count;
    }

    public boolean isConsonant(char c){
        if(c != 'a' &&  c != 'e' && c != 'i' && c != 'o' && c != 'u'){
            return true;
        }else{
            return false;
        }
    }
}
