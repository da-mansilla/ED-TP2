class ejercicio6{
    public static void main(String[]args){
        (new ejercicio6()).run();                
    }
    public void run(){
        Stack<OrdenEstudio> ordenesSinAuditar = new Stack<OrdenEstudio>();
        Stack<OrdenEstudio> ordenesAuditadas  = new Stack<OrdenEstudio>();
        int option;
        do{
           System.out.println("<---------->");
           System.out.println("Gestor de Afiliados"); 
           System.out.println("1. Ingresar Orden de Estudio"); 
           System.out.println("2. Generar Orden al Azar"); 
           System.out.println("3. Auditar Ordenes"); 
           System.out.println("4. Mostrar Ordenes Auditadas"); 
           System.out.println("5. Salir"); 
           option = Helper.selectOption(1,5);
           switch(option){
                case 1:
                    OrdenEstudio orden = new OrdenEstudio();
                    orden = llenarOrden();
                    ordenesSinAuditar.push(orden); 
                    break;
                case 2:
                    OrdenEstudio ordenGenerada = new OrdenEstudio();
                    ordenGenerada = generarOrden();
                    ordenesSinAuditar.push(ordenGenerada); 
                    break;
                case 3:
                	if(!ordenesSinAuditar.empty()) {
                		ordenesAuditadas = auditarOrdenes(ordenesSinAuditar);
                	}else {
                		System.out.println("No hay ordenes para Auditar");
                	}  
                    break;
                case 4:
                    if(!ordenesAuditadas.empty()){    
                        mostrarOrdenesAuditadas(ordenesAuditadas);
                    }else{
                		System.out.println("No hay ordenes Auditadas");
                    }
           }
        }while(option != 5);
    }
    public OrdenEstudio llenarOrden(){
        System.out.println("Ingrese los datos correspondientes");
        System.out.println("Numero de Afiliado:");
        int numeroAfiliado = Helper.inputNumber();
        System.out.println("Tipo de Plan (A-B)");
        char plan;
        do{ 
            plan = Helper.inputChar();
        }while(plan != 'A' && plan != 'B');
        System.out.println("Codigo de Estudio");
        int codigoEstudio = Helper.inputNumber();
        System.out.println("Matricula del Medico:");
        int matricula = Helper.inputNumber();
        System.out.println("Fecha del Estudio (dd/mm/yyyy)");
        String fecha = Helper.inputString();
        return new OrdenEstudio(numeroAfiliado,plan,codigoEstudio,matricula,fecha);
    }
    public OrdenEstudio generarOrden(){
        int numeroAfiliado = Helper.generateRandomNumber(1000,9999);
        int aux = Helper.generateRandomNumber(1,2);
        char plan;
        if(aux == 1){
            plan = 'A';
        }else{
            plan = 'B';
        }
        int codigoEstudio = Helper.generateRandomNumber(1000000,9999999);
        int matricula = Helper.generateRandomNumber(100);
        String fecha = "19/10/2020";
        System.out.println("Orden generada Satisfactoriamente");
        return new OrdenEstudio(numeroAfiliado,plan,codigoEstudio,matricula,fecha);

    }
    
    public Stack<OrdenEstudio> auditarOrdenes(Stack<OrdenEstudio> ordenesSinAuditar){
        Stack<OrdenEstudio> ordenesAuditadas  = new Stack<OrdenEstudio>();
        int ordenRechazadasA = 0;
        int ordenAutorizadaB = 0;
        System.out.println("<--- Auditoria de Ordenes --->");
        while(!ordenesSinAuditar.empty()){
            OrdenEstudio orden = ordenesSinAuditar.pop();
            autorizarOrden(orden);
            if(orden.esAutorizable()){ 
                asignarPorcentaje(orden);
            }
            if(!orden.esAutorizable() && orden.getPlan() == 'A') {
            	++ordenRechazadasA;
            }
            if(orden.esAutorizable() && orden.getPlan() == 'B') {
            	++ordenAutorizadaB;
            }
            ordenesAuditadas.push(orden); 
        }
        System.out.println("<--- Ordenes Auditadas --->");
        System.out.println("Ordenes Plan A Rechazadas: "+ ordenRechazadasA);
        System.out.println("Ordenes Plan B Autorizadas: "+ ordenAutorizadaB);
        return ordenesAuditadas;
        
    }

    public void autorizarOrden(OrdenEstudio orden) {
    	orden.mostrarOrdenEstudio();
    	if(orden.getPlan() == 'A' && orden.esAutorizable()){
            System.out.println("Esta orden es de Tipo A con codigo Par y debe ser Autorizada"); 
         }
         if(orden.getPlan() == 'B' && orden.esAutorizable()){
            System.out.println("Esta orden es de Tipo B con codigo Impar y debe ser Autorizada"); 
         }
         if(orden.getPlan() == 'A' && !orden.esAutorizable()){
            System.out.println("Esta orden es de Tipo A con codigo Impar y NO debe ser Autorizada"); 
         }
         if(orden.getPlan() == 'B' && !orden.esAutorizable()){
            System.out.println("Esta orden es de Tipo B con codigo Par y NO debe ser Autorizada"); 
         }
         orden.autorizarOrden();
         System.out.println("Precione una tecla para continuar...");
         Helper.inputString(); 
    }
    public void asignarPorcentaje(OrdenEstudio orden){
         System.out.println("Ingrese el porcentaje de Descuento");
         int porcentaje;
         boolean esValido=false;
         while(!esValido){
            try{
                porcentaje = Helper.inputNumber();
                orden.definirPorcentajeDescuento(porcentaje);
                esValido= true;
            }catch(RuntimeException e){
                System.out.println(e.getMessage()); 
            }
        }
    }
    public void mostrarOrdenesAuditadas(Stack<OrdenEstudio> ordenesAuditadas){ 
        System.out.println("Ordenes Auditadas");
        while(!ordenesAuditadas.empty()){
            OrdenEstudio orden = ordenesAuditadas.pop();
            orden.mostrarOrdenEstudio();
        }
    }
}
