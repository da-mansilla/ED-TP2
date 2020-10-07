class ejercicio5{
    public static void main(String[] args){
        (new ejercicio5()).run();
    }
    public void run(){ 
        System.out.println("Ingrese una expresión matematica en notacion posfija");
        String cadena = Helper.inputString();
        try{    
            System.out.println("El resultado de la expresion es: " + calculatePostFixNotation(cadena));
        }catch(RuntimeException e){
            System.out.println(e);
        }
    }
    public float calculatePostFixNotation(String cadena){
        Stack<Float> stack = new Stack<Float>();
        for(int i = 0; i < cadena.length(); i++){
            if(Character.isDigit(cadena.charAt(i))){
                stack.push(Float.parseFloat(String.valueOf(cadena.charAt(i)))); 
            }else{
                if(stack.size() <= 2){ 
                    float operand1= stack.pop();
                    float operand2= stack.pop();
                    char operation = cadena.charAt(i); 
                    float result = getResult(operand2,operand1,operation);
                    stack.push(result);
                }else{
                    throw new RuntimeException("La expresion está mal formada"); 
                }
            } 
        }
        return stack.pop();

    }
    public float getResult(float op1, float op2, char operation){
        switch(operation){
            case '+':
                return (op1+op2); 
            case '-':
                return (op1-op2);
            case '*':
                return (op1*op2);
            case '/':
                if(op2 == 0){
                    throw new RuntimeException("Division por 0");
                }
                return (op1/op2);
            default:
                return 0;
        }
    }
}
