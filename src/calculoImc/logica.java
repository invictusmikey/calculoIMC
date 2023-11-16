package calculoImc;

import java.util.ArrayList;
import java.util.Iterator;

public class logica {
	
	double imc;
	ArrayList<personaVO> listaPersonas;
	
	
	
	
	public logica() {
		listaPersonas = new ArrayList<personaVO>();
	}
	
	public String registrarPersona(personaVO miPersona) {
		// TODO Auto-generated method stub
		String resultado = "Persona registrada con exito!!\n";
		resultado+="Documento:"+miPersona.getDocumento()+"\n";
		resultado+="Nombre:"+miPersona.getNombre()+"\n";
		resultado+="Edad:"+miPersona.getEdad()+"\n";
		resultado+="Talla:"+miPersona.getTalla()+"\n";
		resultado+="Peso:"+miPersona.getPeso()+"\n";
		
		String imcMsj = calcularIMC(miPersona.getTalla(), miPersona.getPeso());
		
		miPersona.setImcMsj(imcMsj);
		resultado+= "Imc: "+imc+"\n";
		miPersona.setImc(this.imc);
		listaPersonas.add(miPersona);
		return resultado;
	}

	public String calcularIMC(double talla , double peso) {
		
		imc = peso / (talla*talla);
		String msj = "";
		
		if (imc < 18) {
			msj = "Anorexia";
		}else if (imc >= 18 && imc < 20) {
			msj = "Delgadez";
		}else if(imc >= 20 && imc <27) {
			msj= "Normalidad";
		}else if(imc >= 27 && imc < 30 ) {
			msj="Obesidad gardo 1";
		}else if(imc >= 30 && imc < 35) {
			
			msj= " Obesidad grado 2";
		}else if(imc >=35 && imc < 40) {
			msj= " Obesidad grado 3";
		}else {
			msj="Obesidad morbida";
		}
	
		return "IMC: "+imc+"\n su imc indica que tiene :"+msj;
		
	}
	
	public String consultarListaPersonas() {
		
		String resultado = "";
		personaVO p=null;
		for (int i = 0; i < listaPersonas.size();i++) {
			
			p=listaPersonas.get(i);
			
			resultado+= "Documento: "+p.getDocumento()+"\n";
			resultado+= "Nombre: "+p.getNombre()+"\n";
			resultado+= "Edad: "+p.getEdad()+"\n";
			resultado+= "Peso: "+p.getPeso()+"\n";
			resultado+= "Talla: "+p.getTalla()+"\n";
			resultado+= ""+p.getImcMsj()+"\n";
			resultado+= "***************************";
		}
		
		return resultado;
	}
	
	public String consultarpromedio() {
		
		String resultado = "";
		double suma = 0;
		
		for (int i = 0; i < listaPersonas.size(); i++) {
			suma=suma+listaPersonas.get(i).getImc();
			
		}
		double prom = suma/listaPersonas.size();
		
		resultado= "El promedio del IMC : "+prom+"\n";
		return resultado;
		
	}
		
	}

