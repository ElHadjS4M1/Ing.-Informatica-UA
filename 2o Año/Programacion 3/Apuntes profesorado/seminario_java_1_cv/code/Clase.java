import java.util.*;
import java.util.ArrayList;
import prog3.ejemplos.Ejemplo;

public class Clase {
	// 4
	private int campo1; 
	private float campo2; 
	
	public Clase(int v) {
		campo1 = v; 
	}
	
	public int getCampo1() { 
		return campo1;
	} 
	
	// 5
	public final int KN=10;
	private static int contador=1;
	public static final int KNN=10;
	public static void incrementaContador () {
  		contador++;
	}	
	
	// 14
	public boolean equals(Object obj) {
	  if (obj == null) return false;
	  
	  if (this == obj) return true;
	  
	  if ( !(obj instanceof Clase) ) 
	    return false;
	    
	  Clase r = (Clase) obj;
	  
	    if ( (this.campo1 == r.campo1)
	    && (this.campo2 == r.campo2) )
	    	return true;
	    else
	    	return false;
	}
	
	public String toString() {
	  return "campo1="+campo1+"; campo2="+campo2;
	}
	

	public static void  F(int a, String x, int v[]) {
	   a = 10;
	   x = x + "Hola"; // x.concatenate("hola")
	   v[2] = 7000;
	}

	// 6
	public static final void main(String[] args) throws Exception {
	
	  switch(Integer.valueOf(args[0])) {
	    
	    case 8:
	        // imprimir por consola  (salida estandar y  salida de error)
		System.out.println("-- 8 -- Tipos escalares");
		
		// System.out.print("Cadena"); // no imprime retorno de carro 
		// System.out.println(10+3); // imprime retorno de carro al final
		// System.err.println("Ha ocurrido un error..."); // imprime por salida de error

		float a = 10.3f;
		double b = 10.3;
		char c = 'a';
		boolean d = true; // o false
		
		System.out.println("float a = "+ a);
		System.out.println("double b = "+ b);
		System.out.println("char c = "+ c);
		System.out.println("boolean d = "+ d);
	    case 9:
	    	System.in.read();
		System.out.println("-- 9 -- Wrappers y objectos ");
		Integer a2;
		a2 = new Integer(10);
		int x = a2.intValue(); // x será 10		
		System.out.println("Tipos escalares:");
		System.out.println("a = " + a2); 
		System.out.println("x = "  + x);
		
	    case 10:
		System.in.read();
		System.out.println("-- 10 -- Objetos");
		Integer a3 = new Integer(10); 
		a3 = new Integer(12);
		Integer b3 = a3;
		System.out.println("a = " + a3); 
		System.out.println("b = " + b3); 		

		Object obj = new Clase(2); // Ok
		obj = new Integer(10); // Ok 
		System.out.println("obj = " + obj); 
		
	   case 11:
		System.in.read();
		System.out.println("-- 11 -- instanceof y casting");
		obj = new Clase(2); // Ok
		if (obj instanceof Integer)
			System.out.println("obj es Integer"); 
		else
			System.out.println("obj es Clase"); 
				
		int x2 = 10;
		float f = (float) x2;				
			System.out.println("x = " + x2); 
			System.out.println("f = " + f); 
		
		Object cualquiera = new Clase(3);
		Clase obj2 = (Clase) cualquiera;
			System.out.println("cualquiera = " + cualquiera); 
			System.out.println("obj =  " +  obj2); 

	    case 12:
		System.in.read();
		System.out.println("-- 12 -- Comparación de objetos");
		Integer a4 = new Integer(12); 
		Integer b4 = a4;
			System.out.println("a==b : " + (a4 == b4)); 
		b4 = new Integer(12);
			System.out.println("a==b : " + (a4 == b4)); 
			System.out.println("a4.equals(b4)  : " + a4.equals(b4)); 

	   case 14:
		System.in.read();
		System.out.println("-- 14 -- Boxing/Unboxing");
		Integer b15 = 3;
		Integer b15_2 = new Integer(3);
			System.out.println("b = " + b15); 
			System.out.println("b = " + b15_2); 
		
		int x15 = new Integer(100);
		int x15_2 = (new Integer(100)).intValue();
			System.out.println("x = " + x15); 
			System.out.println("x = " + x15_2); 
		
	    case 16:
		System.in.read();
		System.out.println("-- 16 -- Excepciones");
		Integer a17=null, b17=null;
		if (a17.equals(b17)) {
			// este if lanza la excepción NullPointerException 
		}
			
		// ArrayIndexOutOfBoundsException
/*		int [] v = new int[10];
		v[20] = 3;
*/		
	    case  17:
		System.in.read();
		System.out.println("-- 17 -- Cadenas");
		String s1 = new String("Hola");		
		String s2 = "Hola";
			System.out.println("s == \"Hola\" : " + (s1 == "Hola")); 
			System.out.println("s.equals(\"Hola\") : " + s1.equals("Hola")); 
		Float f2 = new Float(20); 
		String s3 = f2.toString();
			System.out.println("f = " + f2); 
			System.out.println("s = " + s3); 

	   case 18:
		System.in.read();
		System.out.println("-- 18 -- Concatenacion");
		int i19=100;
			System.out.println("El valor de i es = " + i19);

		String s19 = new String("El valor de i es = ");
		String s29 = new Integer(i19).toString();
		String s39 = s19.concat(s29); // que crea un objeto nuevo
			System.out.println("s3 = " + s39);

		StringBuilder sb = new StringBuilder(); 
		sb.append("El valor de i es = "); 
		sb.append(i19);
			System.out.println("sb.toString() : \"" + sb.toString() + "\""); // objeto String

	    case 19:			
		System.in.read();
		System.out.println("-- 19 -- Arrays");
		Integer [] v; // v es un puntero a null
		v = new Integer[100];
		// v.length es la longitud reservada para el array
		for (int i=0; i<v.length; i++) {
			v[i] = new Integer(0);
			// ó v[i] = 0 (equivalente por el boxing)
		}
			System.out.println("v = " + v);
			System.out.println("v[0] = " + v[0]);
		
	    case 20:
		int [] origen = new int []{1,2,3,4,5};
		int [] destino = new int[origen.length]; 
		System.arraycopy(origen, 0, destino, 0, origen.length);	  
		for (int i=0; i<destino.length; i++) {
			System.out.println("destino["+i+"] = "+ destino[i]);
		}
		System.in.read();
		System.out.println("-- 20 -- Metodos, funciones");
		
		int z = 0;
		String str = "Adios";
		System.out.println("Antes de llamar a F:");
		System.out.println("z = " + z);
		System.out.println("sss = " + str);
		System.out.println("destino[2] = " + destino[2]);
		
		F(z,str,destino);
		
		System.out.println("Despues de llamar a F : ");
		System.out.println("z = " + z);
		System.out.println("sss = " + str);
		System.out.println("destino[2] = " + destino[2]);

	   case 22:
	   	System.in.read();
                System.out.println("-- 22 -- Control de flujo");
                String vstr[] = new String[] {"Azul", "Verde", "Rojo"}; 

                for (int i=0; i < vstr.length; i++) {
                  System.out.println(vstr[i]);
	  	}

                System.out.println();

	  	for (String color: vstr) {
		  System.out.println(color); // imprime un color por línea
		}
		
	    case 25:
		System.in.read();
		System.out.println("-- 25 -- API Java - Vectores");

		List v24 = new ArrayList();
		v24.add(87); // esto internamente hace v.add(new Integer(87)) 
		v24.add(22); // hace más grande el vector
		Integer a24 = (Integer)v24.get(0); // necesito hacer cast
			System.out.println(v24);
			System.out.println(a24);
			System.out.println(v24.get(1));

		
	    case 26:
		System.in.read();
		System.out.println("-- 26 -- API Java - Clases genericas");

		List<Integer> v25 = new ArrayList<Integer>();
		v25.add(87); // esto internamente hace v.add(new Integer(87)) 
		Integer a25 = v25.get(0); // no necesitamos hacer cast 
		System.out.println("v.size() : " + v25.size()); // size() devuelve el tamaño		
		
		List<String> colors = Arrays.asList("Azul", "Verde", "Rojo"); 
		System.out.println("Inicializacion -- v.get(1) : " + colors.get(1));
		

	  }
	}
	
} // ¡sin punto y coma!