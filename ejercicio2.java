
class ejercicio2{
    public static void main(String[]args){
      new ejercicio2().run(); 
    }
    public void run(){
        System.out.println("Ingrese la exprecion matematica");
        String cadena = Helper.inputString();
        boolean isCorrectly = checkBrackets(cadena);
        if(isCorrectly){
            System.out.println("Esta correctamente Parentisada");
        }
        else{
            System.out.println("No esta correctamente Parentisada");
        }
    }
    public boolean checkBrackets(String cadena){
        Stack<Character> stack = new Stack<Character>(20);
        for(int i = 0; i < cadena.length(); i++){
            if(isOpenBracket(cadena.charAt(i))){
               stack.push(cadena.charAt(i)); 
            }
            if(isCloseBracket(cadena.charAt(i))){
               stack.pop();
            }
        }
        boolean bracketsIsCorrectlyClosed = stack.empty();
        boolean bracketsInCorrectOrder = verifyOrderOfBrackets(cadena);
        return bracketsIsCorrectlyClosed && bracketsInCorrectOrder;
        
    }
    public boolean verifyOrderOfBrackets(String cadena){
        boolean isValidate= true;
        Stack<Character> stack = new Stack<Character>(20);
        for(int i = 0; i < cadena.length(); i++){
            if(isOpenBracket(cadena.charAt(i))){
               char bracket = cadena.charAt(i);
               if(!stack.empty()){
                   switch (bracket){
                      case '(':
                          if(stack.peek() == '{'){ 
                             isValidate = false;
                          }
                          break;
                      case '[':
                          if(stack.peek() == '('){ 
                             isValidate = false;
                          }
                          break;
                      case '{':
                          if(stack.peek() == '(' || stack.peek() == '['){
                             isValidate = false;
                          }
                          break;
                   }
               }
               stack.push(bracket); 
            }
            if(isCloseBracket(cadena.charAt(i))){
               stack.pop();
            }
        }
       return isValidate; 
    }
    public boolean isOpenBracket(char c){
        if(c == '(' || c == '[' || c == '{' ){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isCloseBracket(char c){
        if(c == ')' || c == ']' || c == '}' ){
            return true;
        }
        else{
            return false;
        }
    }


}
