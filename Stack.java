import java.lang.StringBuilder;
public class Stack<ELEMENT>{

      private int deafultLenght;
      private ELEMENT[] data;
      private int count;

      public Stack(){
          this.data = (ELEMENT []) new Object[10];
          this.count = 0;
      }

      public Stack(int dimension){
          if(dimension <= 0){
              throw new RuntimeException("La cantidad de elementos debe ser positiva");
          }
          this.data = (ELEMENT []) new Object[dimension];
          this.count = 0;
      }

      public boolean empty(){
          return this.count <= 0;  
      }
      public boolean full(){
          return this.size() >= this.data.length;
      }
      public ELEMENT get(int index){
         if(index < 0 || index >= this.size()){
            throw new RuntimeException("Indice no valido");
         }
         return this.data[index];
      }
      public ELEMENT push(ELEMENT element){
          if(this.size() >= this.data.length){
              ELEMENT [] temp = (ELEMENT[]) new Object[this.data.length* 2];
              for(int i = 0; i < this.data.length; ++i){
                  temp[i]= this.data[i];
              }
              this.data = temp;
          }
          this.data[this.count] = element;
          ++this.count;
          return element ;
      }

      public ELEMENT pop(){
          if(this.empty()){
              throw new RuntimeException("La pila esta vacia"); 
          }
          --this.count;
          return this.data[count];
      }
      public ELEMENT pop(int index){
          if(this.empty()){
              throw new RuntimeException("La pila esta vacia"); 
          }
          ELEMENT element= this.data[index];
          for (int i = index; i<this.count-1; i++){
              this.data[i]= this.data[i+1];
          }
          --this.count;
          return element; 

      }
      public ELEMENT peek(){
          if(this.empty()){
              throw new RuntimeException("La pila esta llena"); 
          }
          return this.data[this.count-1];
      }  
      public int size(){
          return this.count; 
      }
      public void show(){
          System.out.print("[");
          for(int i = 0; i < this.size()-1; i++){
              System.out.print(this.data[i]+ ", ");
          }
          System.out.println(this.data[this.count-1]+ "]");
      }
      @Override
      public String toString() {

          if (this.size() <=0) {
              return "";
          }
   
          // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
          StringBuilder sb = new StringBuilder();
          sb.append("[" + this.data[0].toString());
          for (int i = 1; i < this.size(); ++i) {
              sb.append(", " + this.data[i].toString());
          }
          sb.append("]");
          return sb.toString();
      }      

}
