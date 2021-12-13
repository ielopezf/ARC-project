
package PlanificacionDeDisco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Esta clase se encargar de tener solicitudes y recorrerlas, y enviar listas el 
 * orden de recorridos segun cada algoritmo, guardara en la primera posicion la
 * cabeza de las solicitudes y calculara su rango automaticamente
 * @author Daniel
 */
public class PlanificacionDeDisco {
    private int cabeza;
    private String direccion;
    private ArrayList<Integer> solicitudes = new ArrayList<Integer>();
    private ArrayList<Integer> solicitudesOrdenadas;
    private int rango;//limite superior de la lista
    
    public PlanificacionDeDisco(int cabeza, String direccion){
        setCabeza(cabeza);
        setDireccion(direccion);
        agregarSolicitud(cabeza);
    }
    public PlanificacionDeDisco(int cabeza,String direccion, ArrayList<Integer> solicitudes){
        setCabeza(cabeza);
        setDireccion(direccion);
        setSolicitudes(solicitudes);
    }

   /* public PlanificacionDeDisco() {
    }
*/
    //GETTERS AND SETTER    
    public int getCabeza() {
        return cabeza;
    }

    public void setCabeza(int cabeza) {
        if(cabeza >= 0)
            this.cabeza = cabeza;
        else
            throw new IllegalArgumentException("La cabeza debe ser positiva");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(direccion == "Izquierda" || direccion == "Derecha")
            this.direccion = direccion;
        else
            throw new IllegalArgumentException("La direccion debe ser Izquierda o Derecha");                               
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        if(rango >= 0)
            this.rango = rango;
        else
            throw new IllegalArgumentException("El rango debe ser mayor a 0");
    }

    public ArrayList<Integer> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Integer> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ArrayList<Integer> getSolicitudesOrdenadas() {
        return solicitudesOrdenadas;
    }

    public void setSolicitudesOrdenadas(ArrayList<Integer> solicitudesOrdenadas) {
        this.solicitudesOrdenadas = solicitudesOrdenadas;
    }
    
    /* Metodos para manipular la lista de solicitudesLa lista ordenda se 
    actualizara cuando se invoque el metodo iniciarProcesoDePlanificacion()*/
    
    //METODOS PARA LA LISTA ORIGINAL
    public int getCantidadSolicitudes(){
        return this.solicitudes.size();
    }
    
    public void agregarSolicitud(int solicitud){
        if(solicitud >= 0)            
            solicitudes.add(solicitud);
        else
            throw new IllegalArgumentException("Error: La solicitud no debe ser un número negativo");
    }
    
    public int getSolicitud(int indice){
        if(this.getCantidadSolicitudes() > indice && indice >= 0){
            return this.solicitudes.get(indice);
        }else
            throw new IllegalArgumentException("Error: La posición esta fuera del rango o es negativa");
    }
    
    public int indexSolicitud(int solicitud){
        return this.solicitudes.indexOf(solicitud);//devuelve -1 si la solicitud no esta en la lista
    }
    
    public void setSolicitud(int indice, int solicitud){
        if(this.getCantidadSolicitudes() > indice && indice >= 0 && solicitud >= 0)
            this.solicitudes.set(indice, solicitud);
        else if (solicitud < 0)
            throw new IllegalArgumentException("Error: No se permiten en solicitudes negativas");
        else 
            throw new IllegalArgumentException("Error: Posición");
        
    }
    
    public void eliminarSolicitud(int solicitud){
        if(this.solicitudes.contains(solicitud))
            this.solicitudes.remove(solicitud);
        else
            throw new IllegalArgumentException("Error:La solicitud no se encuentra en la lista de solicitudes");
    }
    
    //METODOS PARA LA LISTA ORDENADA
    private int indexSoliditudOrdenada(int solicitud){
        return this.solicitudes.indexOf(solicitud);
    }
    
    //Este metodo hara una copia ordenada de la lista de solicitudes
    private void ordenarSolicitudes(){
        solicitudesOrdenadas = (ArrayList<Integer>) this.solicitudes.clone();
        Collections.sort(this.solicitudesOrdenadas);
        this.calcularRango();
    }
        
    //Metodo caluculara el rango de acuerdo a la mayor solicitud
    private void calcularRango(){
        int mayor = 0;
        int residuo = 0;
        int centenaProx = 0;
        if(solicitudes.isEmpty())
            throw new IllegalArgumentException("La lista esta vacía, no se puede calcular el rango");
        else{
            mayor = Collections.max(this.solicitudes);
            residuo = mayor % 100;
            centenaProx = mayor - residuo + 99;
            this.setRango(centenaProx);
        }
            
    }
    
    /* Esta metodo esta preparada para iniciarce en la GUI, esta funcion 
    ordenara las solicitudes y calculara el rango.
    */
    public void iniciarProcesoDePlanificacion(){
        this.ordenarSolicitudes();
        this.calcularRango();
    }    
    //Este metodo devolvera un lista recorrida como SSTF
    public ArrayList<Integer> recorrerSSTF(){
    //public void recorrerSSTF(){
        ArrayList<Integer> sstf =  new ArrayList<Integer>();//Aqui se guardara la lista en orden SSTF
        int izquierda, actual, derecha;
        int distanciaIz, distanciaDer;
        actual = this.solicitudesOrdenadas.indexOf(this.cabeza);
        izquierda = actual - 1;
        derecha = actual + 1;
        while(izquierda != -1 || derecha != this.solicitudesOrdenadas.size()){
            sstf.add(this.solicitudesOrdenadas.get(actual));
            //System.out.println(izquierda+":"+actual+":"+derecha+"Valor"+this.solicitudesOrdenadas.get(actual));
            if(izquierda == -1){//no hay valores a la derecha
                actual = derecha;derecha++;}
            else if(derecha == this.solicitudesOrdenadas.size()){
                actual = izquierda; izquierda--;}
            else{
                distanciaIz = this.solicitudesOrdenadas.get(actual) - this.solicitudesOrdenadas.get(izquierda);
                distanciaDer = this.solicitudesOrdenadas.get(derecha) - this.solicitudesOrdenadas.get(actual);
                if(distanciaIz < distanciaDer){
                    actual = izquierda;
                    izquierda--;
                } else if(distanciaDer < distanciaIz){
                    actual = derecha;
                    derecha++;
                } else{
                    if(this.direccion.equals("Izquierda")){
                        actual = izquierda;
                        izquierda--;
                    } else{
                        actual = derecha;
                        derecha++;
                    }
                }
            }
        }
        sstf.add(this.solicitudesOrdenadas.get(actual));
        return sstf;
    }
    
    public ArrayList<Integer> recorrerSCAN(){
        ArrayList<Integer> scan = new ArrayList<>();
        int izquierda, actual, derecha;
        String direccionSCAN = this.direccion;
        actual = this.solicitudesOrdenadas.indexOf(this.cabeza);
        izquierda = actual - 1;
        derecha = actual + 1;
        
        while(izquierda != -1 || derecha != this.solicitudesOrdenadas.size()){//Mientras no se lleguen a ambos extremos
            scan.add(this.solicitudesOrdenadas.get(actual));
            if(direccionSCAN.equals("Izquierda")){
                if(izquierda == -1){//Si ya no hay valores a la izquierda
                    direccionSCAN = "Derecha";//Cambiamos de direccion
                    actual = derecha;
                    derecha++;
                    if(!scan.contains(0))
                        scan.add(0);
                }else{
                    actual=izquierda;
                    izquierda--;
                }
            }else{
                if(derecha == this.solicitudesOrdenadas.size()){//Si ya no hay valores a la derecha
                    direccionSCAN = "Izquierda";//Cambiar de direccion
                    actual=izquierda;
                    izquierda--;
                    if(!scan.contains(this.rango))
                        scan.add(this.rango);
                }else{
                    actual = derecha;
                    derecha++;
                }
            }
        }        
        scan.add(this.solicitudesOrdenadas.get(actual));
        return scan;
    }
    
    public ArrayList<Integer> recorrerC_SCAN(){
        ArrayList<Integer> c_scan = new ArrayList<>();
        int actual, siguiente;
        actual = this.solicitudesOrdenadas.indexOf(this.cabeza);
        if(this.direccion.equals("Izquierda"))
            siguiente = actual - 1;
        else
            siguiente = actual + 1;
        //while(siguiente != this.solicitudesOrdenadas.indexOf(this.cabeza)){
        do{
            c_scan.add(this.solicitudesOrdenadas.get(actual));
            if(this.direccion.equals("Izquierda")){
                if(siguiente == -1){
                    actual = this.solicitudesOrdenadas.size() - 1;
                    siguiente = actual - 1;
                    if(!solicitudesOrdenadas.contains(0) && this.solicitudesOrdenadas.indexOf(cabeza) != this.solicitudesOrdenadas.size() - 1)
                        c_scan.add(0);
                    if(!solicitudesOrdenadas.contains(this.rango) && this.solicitudesOrdenadas.indexOf(cabeza) != this.solicitudesOrdenadas.size() - 1)
                        c_scan.add(this.rango);
                }else{
                    actual=siguiente;
                    siguiente--;
                }
            }else{
                if(siguiente == this.solicitudesOrdenadas.size()){
                    actual=0;
                    siguiente= actual + 1;
                    if(!solicitudesOrdenadas.contains(this.rango) && this.solicitudesOrdenadas.indexOf(cabeza) != 0)
                        c_scan.add(this.rango);
                    if(!solicitudesOrdenadas.contains(0) && this.solicitudesOrdenadas.indexOf(cabeza) != 0)
                        c_scan.add(0);
                }else{
                    actual = siguiente;
                    siguiente++;
                }
            }
        }while(actual != this.solicitudesOrdenadas.indexOf(this.cabeza));
        return c_scan;
    } 
    
    public ArrayList<Integer> recorrerC_LOOK(){
        ArrayList<Integer> c_look = new ArrayList<>();
        int actual,siguiente;
        actual = this.solicitudesOrdenadas.indexOf(this.cabeza);
        if(this.direccion.equals("Izquierda"))
            siguiente = actual - 1;
        else
            siguiente = actual + 1;
        do{
            c_look.add(this.solicitudesOrdenadas.get(actual));
            if(this.direccion.equals("Izquierda")){
                if(siguiente == -1){
                    actual = this.solicitudesOrdenadas.size() - 1;
                    siguiente = actual - 1;
                }else{
                    actual = siguiente;
                    siguiente = actual - 1;
                }
            }else{
                if(siguiente == this.solicitudesOrdenadas.size()){
                    actual = 0;
                    siguiente = actual + 1;
                }else{
                    actual = siguiente;
                    siguiente = siguiente + 1;
                }
            }
        }while(actual != this.solicitudesOrdenadas.indexOf(this.cabeza));
        
        
        return c_look;
    }
    
    public String toString(){
        String solicitudesString = new String();
        for(int solicitud:this.solicitudes)
            solicitudesString = solicitudesString + solicitud + " ";        
        //System.out.println("Solicitudes:" + solicitudesString);
        
        return solicitudesString;
    }
    
} 
