/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanificacionDeDisco;
import javax.swing.JOptionPane;
import java.util.ArrayList;



/**
 *
 * @author irmal
 */
public class EjerciciosDeDiscos {
    //numeroDePistasxSuperficie =>numeroDeCilindros
    private int numeroDePlatos, numeroDeCabezas,numeroDePistasxSuperficie, numeroDeSectoresxPista;
    private ArrayList <Integer> pedidos= new ArrayList <Integer>();
    private ArrayList <Integer> cabezas = new ArrayList <Integer>();
    private ArrayList <Integer> cilindros = new ArrayList <Integer>();
    private ArrayList <Integer> sectores = new ArrayList <Integer>();
  
    public int tiempoDeBusqueda, velocidadDeGiro;

    public int getNumeroDePlatos() {
        return numeroDePlatos;
    }

    public void setNumeroDePlatos(int numeroDePlatos) {
       this.numeroDePlatos = numeroDePlatos;
       
        //throw new ArithmeticException("Ingresar numeros positivos");
    }

    public int getNumeroDeCabezas() {
        return numeroDeCabezas;
    }

    public void setNumeroDeCabezas(int numeroDeCabezas) {
        this.numeroDeCabezas = numeroDeCabezas;
    }

    public int getNumeroDePistasxSuperficie() {
        return numeroDePistasxSuperficie;
    }

    public void setNumeroDePistasxSuperficie(int numeroDePistasxSuperficie) {
        this.numeroDePistasxSuperficie = numeroDePistasxSuperficie;
    }

    public int getNumeroDeSectoresxPista() {
        return numeroDeSectoresxPista;
    }

    public void setNumeroDeSectoresxPista(int numeroDeSectoresxPista) {
        this.numeroDeSectoresxPista = numeroDeSectoresxPista;
    }

    public int getTiempoDeBusqueda() {
        return tiempoDeBusqueda;
    }

    public void setTiempoDeBusqueda(int tiempoDeBusqueda) {
        this.tiempoDeBusqueda = tiempoDeBusqueda;
    }

    public int getVelocidadDeGiro() {
        return velocidadDeGiro;
    }

    public void setVelocidadDeGiro(int velocidadDeGiro) {
        this.velocidadDeGiro = velocidadDeGiro;
    }


    public ArrayList<Integer> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Integer> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Integer> getCabezas() {
        return cabezas;
    }

    public void setCabezas(ArrayList<Integer> cabezas) {
        this.cabezas = cabezas;
    }

    public ArrayList<Integer> getCilindros() {
        return cilindros;
    }

    public void setCilindros(ArrayList<Integer> cilindros) {
        this.cilindros = cilindros;
    }

    public ArrayList<Integer> getSectores() {
        return sectores;
    }

    public void setSectores(ArrayList<Integer> sectores) {
        this.sectores = sectores;
    }

    
   

    public EjerciciosDeDiscos(int numeroDePlatos, int numeroDePistasxSuperficie, int numeroDeSectoresxPista, int tiempoDeBusqueda, int velocidadDeGiro, int pedido1, int pedido2) {
       
        setNumeroDePlatos(numeroDePlatos);
        setNumeroDePistasxSuperficie(numeroDePistasxSuperficie);
        setNumeroDeSectoresxPista(numeroDeSectoresxPista);
        setTiempoDeBusqueda(tiempoDeBusqueda);
        setVelocidadDeGiro(velocidadDeGiro);
      
        setNumeroDeCabezas(numeroDePlatos*2);
        pedidos.add(pedido1); 
        pedidos.add(pedido2);
    }
    
    //métodos
    public int calcularSectoresxCilindro(int numeroCabezas, int numeroDeSectoresxPista ){ 
    int sectoresXCilindro=numeroCabezas*numeroDeSectoresxPista;
    return sectoresXCilindro;}
    
    //            numeroSectoresxCilindro es resultado  de calcularSectoresxCilindro
    public int calcularCilindro(int pedido, int numeroSectoresxCilindro){
        int cilindro;
        cilindro=pedido/numeroSectoresxCilindro;
      // cilindro=pedido+numeroSectoresxCilindro;
        return  cilindro;}
    
    public int calcularCabeza(int pedido, int numeroSectoresxCilindro){int cabeza;
    int residuoCilindro; 
    residuoCilindro=pedido%numeroSectoresxCilindro;
   //residuoCilindro=pedido+numeroSectoresxCilindro;
    cabeza= residuoCilindro/numeroDeSectoresxPista;
   // cabeza= residuoCilindro+numeroDeSectoresxPista;
    return cabeza;}
    
    public int calcularSector(int pedido, int numeroSectoresxCilindro){
        int sector;
    int residuoCilindro; 
    residuoCilindro=pedido%numeroSectoresxCilindro;
    sector= residuoCilindro%numeroDeSectoresxPista;
    
  //residuoCilindro=pedido+numeroSectoresxCilindro;
  // sector= residuoCilindro+numeroDeSectoresxPista;
    return sector;}
    
  /*  public int  tiempoPedidos(int pedidosCilindroACilindro,int cantidadCilindrosRecorridos){
    int tiempoRecorridoPedidos;
    tiempoRecorridoPedidos=tiempoDeBusqueda*cantidadCilindrosRecorridos;
   return tiempoRecorridoPedidos;}*/
    
    public int tiempoTotal(int cilindrosRecorridos , int tiempoRotacional, int sectoresRecorridos ){
        int tiempoTotal;
    tiempoTotal= tiempoDeBusqueda*cilindrosRecorridos + tiempoRotacional*sectoresRecorridos+tiempoRotacional;
    return tiempoTotal;} 
    
//tiempoCilindroAcilindro=  tiempoBusqueda

// si no hay datos como cantidad a sectores a leer, tamaño del sector,etc tiempoRotacional=tiempoTransferencia
    public int calcularCilindrosRecorridos(int c1, int c2){
        int cilindrosRecorridos=  Math.abs(c1-c2);
    
    return cilindrosRecorridos;}
    
    public int calcularTiempoRecorridoPedidos(int CilindrosRecorridos){ return tiempoDeBusqueda*CilindrosRecorridos;}
    
    public int calcularTiempoRotacional(){ return 1000/(velocidadDeGiro*numeroDeSectoresxPista);}
    
    public int cantSectoresRecorridos(int  tiempoRecorridoPedidos, int tiempoRotacional ){  return tiempoRecorridoPedidos*tiempoRotacional;}

    public int sectoresRecorridos(int cantSectoresRecorridos){ return (cantSectoresRecorridos%numeroDeSectoresxPista) ;}
//tiempoDeTransferencia= bytesTransferir/(rps*bytesxPista)

/*
tiempoRotacional
rps=(1vuelta/60segundos)*vuelta
(1sector/rps)*numeroSectoresxPista*/
    
    public void agregarCabeza(int cabeza){ cabezas.add(cabeza);}
    public void agregarCilindro(int cilindro){cilindros.add(cilindro);}
    public void agregarSector(int sector){sectores.add(sector);}

    
    
}
