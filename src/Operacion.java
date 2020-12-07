
public class Operacion {
	
	public Operacion() {
	}
	
	public double probabilidad(String[] universo, String coleccion) {
		double cont = 0;
		for (int i = 0; i<universo.length; i++) {
			if (universo[i].equals(coleccion)) {
				cont++;
			}
		}
		return (cont / universo.length);
	}
	
	public double factorial(int n){
		double factorialN = 1;
		while ( n!=0) {
			factorialN = factorialN*n;
			n--;
		}		
		return(factorialN);
	}
	
	
	public double combinacion(int n, int p) {
		//nCp = n! / (n-p)! * p!
		if (n>=p) {
			return (Math.round(factorial(n) /(factorial(n-p) * factorial(p))));
		}else {
			return 0;
		}
	}
	
	public double permutacion(int n, int p) {
		//nCp = n! / (n-p)!
		if (n>=p) {
			return (Math.round(factorial(n) / factorial(n-p)));
		}else {
			return 0;
		}
	}
	
	public double permutacionConRepeticion(int n, int a, int b) {
		//n! / a! b!
		return(factorial(n) / (factorial(a) * factorial(b)));
	}
	
	public double permutacionCircular(int n) {
		//n! / a! b!
		return(factorial(n-1));
	}
	
	public double mediaAritmetica(double[] x) {
		double suma = 0;
		for (int i = 0; i < x.length; i++) {
			suma = suma + x[i];
		}
		
		return (suma / x.length);
	}
	
	public double mediaAritmeticaAgrupados(double[] x, double[] f) {
		double suma = 0;
		double n = 0;
		for (int i = 0; i < x.length; i++) {
			suma = suma + (x[i] * f[i]);
			n = n + f[i];
		}
		
		return(suma/n);
	}
	
	public double[] moda (double[] x) {
		int[] frecuencias = new int[x.length];
		double[] modas = new double[x.length];
		int frec = 1;
		int j = 0;
		
		int max = 0;
		
		for (int i = 0; i<x.length; i++) {
			frec = 1;
			j = i + 1;
			while(j < x.length) {
				if (x[i] == x[j]){
					frec = frec + 1;
			    }
				j = j + 1;
			}
			frecuencias[i] = frec;
			if (frecuencias[i] >= max) {
				max = frecuencias[i];
			}
		}
		j = 0;
		for (int i = 0; i<x.length; i++) {
			if (frecuencias[i] == max) {
				modas[j] = x[i];
				j++;
			}
		}
		
		return modas;
	}
	
	public double[] ordenar(double[] x) {
		double aux = 0;
		for (int i = 0; i<x.length-1; i++) {
			for (int j = 0; j<x.length-1; j++) {
				if (x[j] > x[j+1]) {
					aux = x[j];
					x[j] = x[j+1];
					x[j+1] = aux;
				}
			}
		}
		return(x);
	}
	
	public double mediana(double[] x) {
		double n = Double.valueOf(x.length);
		if((n % 2) == 1) {
			double pos = ((n/2)-0.5)+1;
			return(x[(int)pos-1]);
		}else {
			double mediana1 = x[(x.length/2) - 1];
			double mediana2 = x[(x.length/2)];
			return ( (mediana1 + mediana2)/2 );
		}
	}
	
	public static double log2(double x)
	{
	    return ( (Math.log(x) / Math.log(2)));
	}
	
	public double mediaGeometrica(double[] x) {
		double suma = 1;
		double n = Double.valueOf(x.length);
		for (int i = 0; i < n; i++) {
			suma = suma * x[i];
		}
		return (Math.pow(suma,(1/n)));
	}
	
	public double mediaGeometricaAgrupados(double[] x, double[] f) {
		double suma = 1;
		double n = 0;
		for (int i = 0; i < x.length; i++) {
			suma = suma * Math.pow(x[i], f[i]);
			n = n + f[i];
		}
		return (Math.pow(suma,(1/n)));
	}
	
	public double mediaArmonica(double[] x) {
		double suma = 0;
		double n = Double.valueOf(x.length);
		
		for (int i = 0; i < n; i++) {
			suma = suma + (1 / x[i]);
		}
		return (n / suma);
	}
	
	public double mediaArmonicaAgrupados(double[] x, double[] f) {
		double suma = 0;
		double n = 0;
		for (int i = 0; i < x.length; i++) {
			suma = suma + (f[i] / x[i]);
			n = n + f[i];
		}
		return (n / suma);
	}
	
	public double mediaCuadratica(double[] x) {
		double suma = 0;
		double n = Double.valueOf(x.length);
		
		for (int i = 0; i < n; i++) {
			suma = suma + (x[i] * x[i]);
		}
		return (Math.sqrt(suma/n));
	}
	
	public double mediaPonderada(double[] x, double[] w) {
		double suma = 0;
		double sumaW = 0;
		double n = Double.valueOf(x.length);
		
		for (int i = 0; i < n; i++) {
			suma = suma + (x[i] * w[i]);
			sumaW = sumaW + w[i];
		}
		return (suma / sumaW);
	}
	
	public double posicion(double n, double k, double x) {
		double pos = (n * k) / x;
		if (pos < 1)
			pos = 1;
		return (pos);
	}
	
	public double cuartil(double[] x,  double k) {
		double n = Double.valueOf(x.length);
		double pos = posicion(n, k, 4);
		return (x[(int)Math.round(pos) - 1]);
	}
	
	public double cuartilAgrupados(double[] x,  double k) {
		double n = Double.valueOf(x.length);
		double pos = posicion(n, k, 4);
		return (x[(int)(pos-1)]);
	}
	
	public double decil(double[] x,  double k) {
		double n = Double.valueOf(x.length);
		double pos = posicion(n, k, 10);
		return (x[(int)Math.round(pos) - 1]);
	}
	
	public double decilAgrupados(double[] x,  double k) {
		double n = Double.valueOf(x.length);
		double pos = posicion(n, k, 10);
		return (x[(int)(pos-1)]);
	}
	
	public double percentil(double[] x,  double k) {
		double n = Double.valueOf(x.length);
		double pos = posicion(n, k, 100);
		return (x[(int)Math.round(pos) - 1]);
	}
	
	public double percentilAgrupados(double[] x,  double k) {
		double n = Double.valueOf(x.length);
		double pos = posicion(n, k, 100);
		return (x[(int)(pos-1)]);
	}
	
	public double varianza(double[]x) {
		double mediaX = 0;
		double suma = 0;
		
		for (int i = 0; i<x.length; i++) {
			mediaX = mediaX + x[i];
		}
		
		mediaX = mediaX / x.length;
		
		for (int i = 0; i<x.length; i++) {
			suma = suma + ((x[i]-mediaX) * (x[i]-mediaX));
		}
		
		return (suma / x.length);
	}
	
	public double varianzaAgrupados(double[]x, double[] f) {
		double mediaX = 0;
		double suma = 0;
		double n = 0;
		
		for (int i = 0; i<x.length; i++) {
			mediaX = mediaX + x[i];
			n = n + f[i];
		}
		
		mediaX = mediaX / x.length;
		
		for (int i = 0; i<x.length; i++) {
			suma = suma + f[i] * (((x[i]-mediaX) * (x[i]-mediaX)));
		}
		
		return (suma / n);
	}
	
	public double desviacionTipica(double[] x) {
		return (Math.sqrt(varianza(x)));
	}
	
	public double desviacionTipicaAgrupados(double[] x, double[] f) {
		return (Math.sqrt(varianzaAgrupados(x, f)));
	}
	
	public double covarianza(double[] x, double[] y, double[] f, boolean poblacion) {
		double mediaX = 0;
		double mediaY = 0;
		double n = 0;
		
		for (int i = 0; i< x.length; i++) {
			mediaX = mediaX + x[i] * f[i];
			mediaY = mediaY + y[i] * f[i];
			n = n + f[i];
		}
		
		mediaX = mediaX / n;
		mediaY = mediaY / n;
		
		double suma = 0;
		for (int i = 0; i< x.length; i++) {
			suma = suma + x[i] * y[i] * f[i];
		}

		if (poblacion) {
			return ((suma/n)-mediaX*mediaY);
		}else {
			return ((suma/(n-1))-mediaX*mediaY);
		}
	}
	
	public double rectaRegresionYsobreX(double covarianza, double varianza, double mediaX,
										double mediaY, double x) {
		return (((covarianza) / varianza) * (x - mediaX) + mediaY);
	}
	
	public double rectaRegresionXsobreY(double covarianza, double varianza, double mediaX,
			double mediaY, double y) {
		return (((covarianza) / varianza) * (y - mediaY) + mediaX);
	}
	
	public double coeficienteVariacion(double[] x) {
		return (desviacionTipica(x) / mediaAritmetica(x));
	}
	
	public double coeficienteVariacionAgrupados(double[] x, double[] f) {
		return (desviacionTipicaAgrupados(x, f) / mediaAritmeticaAgrupados(x, f));
	}
	
	public double desviacionMedia(double[] x) {
		double mediaX = 0;
		double suma = 0;
		double n = x.length;
		
		for (int i = 0; i<x.length; i++) {
			mediaX = mediaX + x[i];
		}
		
		mediaX = mediaX / x.length;
		
		for (int i = 0; i<x.length; i++) {
			suma = suma + Math.abs(x[i] - mediaX);
		}
		
		return (suma / n);
	}
	
	public double desviacionMediaAgrupados(double[] x, double[] f) {
		double mediaX = 0;
		double suma = 0;
		double n = 0;
		
		for (int i = 0; i<x.length; i++) {
			mediaX = mediaX + x[i];
			n = n + f[i];
		}
		
		mediaX = mediaX / x.length;
		
		for (int i = 0; i<x.length; i++) {
			suma = suma + f[i] * (Math.abs(x[i] - mediaX));
		}
		
		return (suma / n);
	}
	

//	public double medianaAgrupados(double[] x, double[] f) {
//		x = ordenar(x);
//		double n = Double.valueOf(x.length);
//		double min = x[0];
//		double max = x[x.length-1];
//		double rango = max - min;
//		
//		System.out.println("Rango: " + rango);
//		
//		double total = 0;
//		
//		for (int i = 0; i<x.length; i++)
//		{
//			total = total + f[i];
//		}
//		System.out.println("Total: " + total);
//		
//		double intervalo = 1 + log2(total);
//		//regla de Sturges
//		if ((int)intervalo % 2 == 1) {
//			intervalo = Math.floor(intervalo);
//		}else {
//			intervalo = Math.ceil(intervalo);
//		}
//		
//		System.out.println("Intervalo: " + intervalo);
//		
//		double amplitud = rango / intervalo;
//		
//		//la amplitud se redondea al entero superior más cercano
//		amplitud = Math.ceil(amplitud);
//		
//		System.out.println("Amplitud: " + amplitud);
//		
//		double posMediana = 0;
//		
//		if((total % 2) == 1) {
//			posMediana = ((total/2)-0.5);
//		}else {
//			posMediana = ((total/2) -1);
//		}
//		
//		System.out.println("Posición mediana: " + posMediana);
//		
//		double fA = 0;
//		int indice = 0;
//		
//		for (int i = 0; i<x.length; i++) {
//			fA = fA + f[i];
//			if (fA <= posMediana) {
//				indice = i;
//			}
//		}
//		
//		
//		double mediana = x[indice];
//		double fi = f[indice];
//		double fi_1 = 0;
//		
//		
//		
//		if (indice != 0) {
//			fi_1 = f[indice-1];
//		}
//		
//		
//		double limiteInferior = mediana - (amplitud/2);
//		
////		System.out.println("Mediana: " + mediana);
////		System.out.println("LimiteInferior: " + limiteInferior);
//
//		return (limiteInferior + ( ( ((rango/2) + fi_1) / fi)) * amplitud);
//	}
	
}
