class OrdenEstudio{
    private int numeroAfiliado;
    private char plan;
    private int codigoEstudio;
    private int matriculaDelMedico;
    private String fecha;
    private String estado;
    private int porcentajeDescuento;

    public OrdenEstudio(int numeroAfiliado, char plan, int codigoEstudio, int matriculaDelMedico, String fecha, String estado, int porcentajeDescuento){
        this.numeroAfiliado = numeroAfiliado;
        this.plan = plan;
        this.codigoEstudio = codigoEstudio;
        this.matriculaDelMedico = matriculaDelMedico;
        this.fecha = fecha;
        this.estado = estado;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public OrdenEstudio(int numeroAfiliado, char plan, int codigoEstudio, int matriculaDelMedico, String fecha){
        this.numeroAfiliado = numeroAfiliado;
        this.plan = plan;
        this.codigoEstudio = codigoEstudio;
        this.matriculaDelMedico = matriculaDelMedico;
        this.fecha = fecha;
        this.estado = "No Auditada";
        this.porcentajeDescuento = 0;
    }
    public OrdenEstudio(){
            
    }

    public void mostrarOrdenEstudio(){
        System.out.println("Numero de Afiliado.....:" + this.numeroAfiliado);
        System.out.println("Plan...................:" + this.plan);
        System.out.println("Codigo de Estudio......:" + this.codigoEstudio);
        System.out.println("Matricula del Medico...:" + this.matriculaDelMedico);
        System.out.println("Fecha..................:"+ this.fecha);
        if(this.estado != "No Auditada"){ 
            System.out.println("Estado.................:"+ this.estado);
            System.out.println("Porcentaje de descuento:"+ this.porcentajeDescuento);
        }
        System.out.println("");
        
    }
    public void autorizarOrden(){
        if(this.esAutorizable()){
            this.estado = "Autorizado";    
        }else{
            this.estado = "No Autorizado";
        }
    }
    public boolean esAutorizable(){ 
        if(this.plan == 'A'){
           if(this.codigoEstudio % 2 == 0){
                return true;
           }else{
                return false;
           }
        }else{
            if(this.codigoEstudio % 2 != 0){
                return true;
            }else{
                return false;
            }
        }
    }
    public void definirPorcentajeDescuento(int porcentaje){
        if(this.esAutorizable()){ 
            if(this.plan == 'A'){
                if(porcentaje <= 50){
                    this.setPorcentajeDescuento(porcentaje);
                }else{    
                  throw new RuntimeException("Las Ordenes de Plan A solo tienen descuento hasta %50"); 
                }
            }else{
                if(porcentaje <= 50){
                    this.setPorcentajeDescuento(porcentaje);
                }else{
                  throw new RuntimeException("Las Ordenes de Plan B solo tienen descuento hasta %40"); 
                }
            }
        }
    }


    // Getters and Setters
    public int getNumeroAfiliado(){
        return this.numeroAfiliado;
    }
    public char getPlan(){
        return this.plan;
    }
    public int getCodigoEstudio(){
        return this.codigoEstudio;
    }
    public int getMatriculaDelMedico(){
        return this.matriculaDelMedico;
    }
    public String getFecha(){
        return this.fecha;
    }
    public String getEstado(){
        return this.estado;
    }
    public int getPorcentajeDescuento(){
        return this.porcentajeDescuento;
    }

    public void setNumeroAfiliado(int numeroAfiliado){
        this.numeroAfiliado = numeroAfiliado;
    }
    public void setPlan(char plan){
        if(plan == 'A' && plan == 'B'){ 
            this.plan = plan;
        }else{
            throw new RuntimeException("Solo existen ordenes de estudio del Tipo A o del Tipo B");
        }
    }
    public void setCodigoEstudio(int codigoEstudio){
        this.codigoEstudio = codigoEstudio;
    }
    public void setmMatriculaDelMedico(int matriculaDelMedico){
        this.matriculaDelMedico = matriculaDelMedico;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setPorcentajeDescuento(int porcentajeDescuento){
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
