package pco1_cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import practico1.pco1.datatypes.DtLoteVacuna;
import practico1.pco1.negocio.NegocioRemote;

class CommandLineExample
{
    public static void main ( String [] arguments ) throws NamingException, IOException
    {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		props.put(Context.PROVIDER_URL,"remote+http://localhost:8080"); 
		
		Context ctx  = new InitialContext(props);
		String jndiName = "ejb:pco1/pco1-ejb/Negocio!practico1.pco1.negocio.NegocioRemote";
		
		NegocioRemote negocio = (NegocioRemote)ctx.lookup(jndiName);
    	
		String nombre;
		int cantidad;
		LocalDate fechaCreado = LocalDate.now();
		boolean esNumero = true;
		
    	int opc;
    	boolean menu = true;
    	while(menu) {
    		System.out.println("#MENU");
    		System.out.println("1 - Agregar Lote");
        	System.out.println("2 - Listar Nombres");
        	System.out.println("3 - Buscar Lote");
        	System.out.println("Cualquier otro número para salir");
        	
        	Scanner leer = new Scanner(System.in);
        	Scanner teclado = new Scanner(System.in);
        	opc = leer.nextInt();
        	
        	switch(opc) {
        	   case 1 :
        		   	System.out.flush();  
        		   	System.out.println("#AGREGAR LOTE");
           			
    		   		System.out.println("Nombre:");
    		   		nombre = teclado.nextLine();
    		   		System.out.println("Cantidad:");
    		   		cantidad = leer.nextInt();
    		   		
    		   		
    		   		if(!negocio.existeLoteVacuna(nombre)) {
    		   			negocio.crearLoteVacuna(nombre, fechaCreado, cantidad);
    		   		}
    		   		else {
    		   			System.out.println("Ya existe un lote llamado "+ nombre);
    		   		}
           			
           			
        	      break; 
        	      
        	   case 2 : 
        		   System.out.println("#LISTAR LOTES");
        		   List<String> lotes = negocio.listarNombres();
        		   if(lotes != null) {
        			   for(String l: lotes){
        				   System.out.println("-"+l);
        			   }
        		   }
        		   else {
        			   System.out.println("Aún no hay lotes guardados");
        		   }
        	      break;
        	   case 3 :
        		   System.out.flush();  
        		   System.out.println("#BUSCAR LOTE");
        		   System.out.println("Nombre:");
        		   nombre = teclado.nextLine();
        		   if(!nombre.isBlank()) {
        			   if(negocio.existeLoteVacuna(nombre)){
        				   DtLoteVacuna dtlv = negocio.buscarLoteVacuna(nombre);
                		   System.out.println("Nombre :" + dtlv.getNombre());
                		   System.out.println("Cantidad :" + dtlv.getCantidad());
                		   System.out.println("Fecha: "+ dtlv.getFechaCreado());
        			   }else{
        				   System.out.println("No existe un lote llamado "+ nombre);
        			   }
        		   }
        		   else {
        			   System.out.println("Debe ingresar un nombre");
        		   }
        		   
         	      break;
        	      
        	   default : 
        		   menu = false;
        	}
        	
    	}
    }
}