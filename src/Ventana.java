import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Ventana extends JFrame{
		
	private JPanel panelConsola;
	private JPanel panelBotonesAbajo;
	private JPanel panelBotonesArriba;
	//private JPanel panelBotonesMasAbajo;
	private JButton btnProbabilidad, btnCombinatoria, btnPermutacion,
					btnPermutacionConRepeticion, btnPermutacionCircular, btnFactorial, 
					btnDatosAgrupados,btnDatosNoAgrupados, 
					btnMediaPonderada, btnCovarianza ,btnCuartiles, 
					btnDeciles, btnPercentiles, btnRecta;
	private JTextArea areaConsola;
	//private JScrollPane sp = new JScrollPane(areaConsola);
	public Operacion operacion = new Operacion();
	//public double[] datos;
	
	public Ventana(){
		this.setLocation(400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 550);
		this.setResizable(true);
		this.setTitle("Calculadora de Probabilidad y Estadística");
		
		panelConsola = new JPanel(new GridLayout());
		panelBotonesArriba = new JPanel(new GridLayout(2,6,5,5));
		panelBotonesAbajo = new JPanel(new GridLayout(8,2,5,5));
		
		areaConsola = new JTextArea("\n                        " + "Bienvenido a la Calculadora \n"
		+ "                     " + " de Probabilidad y Estadística \n"
		+ " \n" + "                            " + "Seleccione una opción."
		+ " \n" + "                " + "UABCS - DASC - IDS - Tercer Semestre"
		+ " \n" + "                         " + "Probabilidad y Estadística"
		+ " \n" + "                      " + "Profesor: Miguel Parra García"
		+ " \n" + "                     " + "César Daniel Sepúlveda Ibarra");
		
		
		areaConsola.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		
		/*CREAR BOTONES*/
		btnProbabilidad = new JButton ("Calcular Probabilidad"); 
		accionBotonCalcularProbabilidad();
		
		btnCombinatoria = new JButton ("Combinatoria"); 
		accionBotonCombinatoria();
		
		btnPermutacion = new JButton ("Permutación");
		accionBotonPermutacion();
		
		btnPermutacionConRepeticion = new JButton ("Permutación con Rep.");
		accionBotonPermutacionConRepeticion();
		
		btnPermutacionCircular = new JButton ("Permutación Circular"); 
		accionBotonPermutacionCircular();
		
		btnFactorial = new JButton ("Factorial"); 
		accionBotonFactorial();
		
		btnDatosNoAgrupados = new JButton ("Datos No Agrupados");
		accionBotonDatosNoAgrupados();
		
		btnDatosAgrupados = new JButton ("Datos Agrupados en frecuencias");
		accionBotonDatosAgrupados();
		
		btnMediaPonderada = new JButton ("Media Ponderada");
		accionBotonMediaPonderada();
		
		btnCovarianza = new JButton ("Calcular Covarianza");
		accionBotonCovarianza();
		
		btnCuartiles = new JButton ("Cuartiles");
		accionBotonCuartiles();
		
		btnDeciles = new JButton ("Deciles");
		accionBotonDeciles();
		
		btnPercentiles = new JButton ("Percentiles");
		accionBotonPercentiles();
		
		btnRecta = new JButton ("Calculo de Recta de regresión");
		accionBotonRecta();
		
		panelConsola.add(areaConsola);
		panelBotonesArriba.add(btnProbabilidad);
		panelBotonesArriba.add(btnCombinatoria);
		panelBotonesArriba.add(btnPermutacion);
		panelBotonesArriba.add(btnPermutacionConRepeticion);
		panelBotonesArriba.add(btnPermutacionCircular);
		panelBotonesArriba.add(btnFactorial);
		
		panelBotonesAbajo.add(btnDatosNoAgrupados);
		panelBotonesAbajo.add(btnDatosAgrupados);
		panelBotonesAbajo.add(btnMediaPonderada);
		panelBotonesAbajo.add(btnCovarianza);
		panelBotonesAbajo.add(btnCuartiles);
		
		panelBotonesAbajo.add(btnDeciles);
		panelBotonesAbajo.add(btnPercentiles);
		panelBotonesAbajo.add(btnRecta);
		
		this.setLayout(new BorderLayout());
		this.add(panelConsola, BorderLayout.CENTER);
		this.add(panelBotonesAbajo, BorderLayout.SOUTH);
		this.add(panelBotonesArriba, BorderLayout.NORTH);
		
		
		
		show();
	}
	
	public void accionBotonCalcularProbabilidad(){ //1
		btnProbabilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String tam = JOptionPane.showInputDialog("Tamaño del espacio muestral:");
				int n = Integer.parseInt(tam);
				String espacio[] = new String[n];
				String texto = "Espacio muestral: \n";
				for (int i = 0; i < n; i++) {
					String evento = JOptionPane.showInputDialog("Evento " + (i+1) + ": ");
					espacio[i] = evento;
					texto = texto + "[" + espacio[i] + "] ";
				}
				texto = texto + " \n";
	
				JOptionPane.showMessageDialog(null, "Espacio muestral terminado");
				
				String evento = JOptionPane.showInputDialog("Evento favorable:");
				texto = texto + "Evento favorable: " + evento + "\n";
			    
				double resultado = operacion.probabilidad(espacio, evento);
				
				texto = texto + "Probabilidad evento favorable: " + resultado + "\n";
				texto = texto + "Probabilidad evento desfavorable: " + (1-resultado);
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	public void accionBotonCombinatoria(){ //2
		btnCombinatoria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fórmula combinación: n C p");
				String texto = "Fórmula: nCp = n! / (n-p)! * p! \n";
				
				String n_string = JOptionPane.showInputDialog("Ingrese n:");
				int n = Integer.parseInt(n_string);
				texto = texto + "n = " + n + "\n";
				
				String p_string = JOptionPane.showInputDialog("Ingrese p:");
				int p = Integer.parseInt(p_string);
				texto = texto + "p = " + p + "\n";
				
				double resultado = operacion.combinacion(n, p);
				
				texto = texto + n + "C" + p + " = " + n + "!" + " / (" + n + "-" + p + ")! * " 
						+ p + "! =" + resultado;
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonPermutacion(){ //3
		btnPermutacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fórmula permutación: n P p");
				String texto = "Fórmula: nPp = n! / (n-p)! \n";
				
				String n_string = JOptionPane.showInputDialog("Ingrese n:");
				int n = Integer.parseInt(n_string);
				texto = texto + "n = " + n + "\n";
				
				String p_string = JOptionPane.showInputDialog("Ingrese p:");
				int p = Integer.parseInt(p_string);
				texto = texto + "p = " + p + "\n";
				
				double resultado = operacion.permutacion(n, p);
				
				texto = texto + n + "P" + p + " = " + n + "!" + " / (" + n + "-" + p + ")! =" 
				+ resultado;
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonPermutacionConRepeticion(){ //4
		btnPermutacionConRepeticion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Permutación con repetición: n! / a! b!");
				String texto = "Fórmula: n! / a! b! \n";
				
				String n_string = JOptionPane.showInputDialog("Ingrese n:");
				int n = Integer.parseInt(n_string);
				texto = texto + "n = " + n + "\n";
				
				String a_string = JOptionPane.showInputDialog("Ingrese a:");
				int a = Integer.parseInt(a_string);
				texto = texto + "a = " + a + "\n";
				
				String b_string = JOptionPane.showInputDialog("Ingrese b:");
				int b = Integer.parseInt(b_string);
				texto = texto + "b = " + b + "\n";
				
				double resultado = operacion.permutacionConRepeticion(n, a, b);
				
				texto = texto + n + "! /" + a + "!" +  b + "! = " + resultado;
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}

	public void accionBotonPermutacionCircular(){ //5
		btnPermutacionCircular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//PCn = (n-1)!
				JOptionPane.showMessageDialog(null, "Permutación circular: PCn");
				String texto = "Fórmula: PCn = (n-1)! \n";
				
				String n_string = JOptionPane.showInputDialog("Ingrese n:");
				int n = Integer.parseInt(n_string);
				texto = texto + "n = " + n + "\n";
				
				double resultado = operacion.permutacionCircular(n);
				
				texto = texto + "PC" + n + " = (" + n + "-1)! = " + resultado;
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonFactorial(){ //6
		btnFactorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Factorial = n!
				JOptionPane.showMessageDialog(null, "Factorial: n!");
				String texto = "Fórmula: n! = (n) * (n-1) * (n-2) *...* 2 * 1 \n";
				
				String n_string = JOptionPane.showInputDialog("Ingrese n:");
				int n = Integer.parseInt(n_string);
				texto = texto + n + "! = ";
				
				double resultado = operacion.factorial(n);
				
				texto = texto + resultado;
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonDatosNoAgrupados(){ //7
		btnDatosNoAgrupados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n_string = JOptionPane.showInputDialog("Número de datos:");
				int n = Integer.parseInt(n_string);
				
				double x[] = new double[n];
				
				for (int i = 0; i < n; i++) {
					String dato = JOptionPane.showInputDialog("Dato " + (i+1) + ": ");
					x[i] = Double.valueOf(dato);
				}
				
				x = operacion.ordenar(x);
				
				String texto = "Datos: \n";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + " \n";
				
				double media = operacion.mediaAritmetica(x);
				texto = texto + "Media: " + media + "\n";
				
				double mediana = operacion.mediana(x);
				texto = texto + "Mediana: " + mediana + "\n";
				
				double moda[] = new double[n];
				moda = operacion.moda(x);
				
				texto = texto + "Moda(s): ";
				if (moda[1] == 0) {
					texto = texto + moda[0];
				}else {
					for (int i = 0; i<n; i++) {
						if (moda[i] != 0) {
							texto = texto + "[" +  moda[i] + "] ";
						}
					}
				}
				texto = texto + "\n";
				
				double mediaGeometrica = operacion.mediaGeometrica(x);
				texto = texto + "Media Geométrica: " + mediaGeometrica + "\n";
				
				double mediaArmonica = operacion.mediaArmonica(x);
				texto = texto + "Media Armónica: " + mediaArmonica + "\n";
				
				double mediaCuadratica = operacion.mediaCuadratica(x);
				texto = texto + "Media Cuadrática: " + mediaCuadratica + "\n";
				
				
				double varianza = operacion.varianza(x);
				texto = texto + "Varianza: " + varianza + "\n";
				
				double desviacionTipica = operacion.desviacionTipica(x);
				texto = texto + "Desviación Típica: " + desviacionTipica + "\n";
				
				double coeficienteVariacion = operacion.coeficienteVariacion(x);
				texto = texto + "Coeficiente de variación: " + coeficienteVariacion + "\n";
				
				double desviacionMedia = operacion.desviacionMedia(x);
				texto = texto + "Desviacion Media: " + desviacionMedia + "\n";
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonDatosAgrupados(){ //8
		btnDatosAgrupados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n_string = JOptionPane.showInputDialog("Número de datos:");
				int n = Integer.parseInt(n_string);
				
				double x[] = new double[n];
				double f[] = new double[n];
				
				for (int i = 0; i < n; i++) {
					String dato = JOptionPane.showInputDialog("Dato " + (i+1) + ": ");
					x[i] = Double.valueOf(dato);
					String frecuencia = JOptionPane.showInputDialog("Frecuencia del Dato " + (i+1) + ": ");
					f[i] = Double.valueOf(frecuencia);
				}
				
				String texto = "";
				
//				double mediana = operacion.medianaAgrupados(x, f);
//				texto = texto + "Mediana: " + mediana + "\n";
			
				double media = operacion.mediaAritmeticaAgrupados(x, f);
				texto = texto + "Media Aritmética: " + media + "\n";
				
				double mediaGeometrica = operacion.mediaGeometricaAgrupados(x, f);
				texto = texto + "Media Geométrica: " + mediaGeometrica + "\n";
				
				double mediaArmonica = operacion.mediaArmonicaAgrupados(x,  f);
				texto = texto + "Media Armónica: " + mediaArmonica + "\n";
				
				double varianza = operacion.varianzaAgrupados(x, f);
				texto = texto + "Varianza: " + varianza + "\n";
				
				double desviacionTipica = operacion.desviacionTipicaAgrupados(x, f);
				texto = texto + "Desviación Típica: " + desviacionTipica + "\n";
				
				double coeficienteVariacion = operacion.coeficienteVariacionAgrupados(x, f);
				texto = texto + "Coeficiente de variación: " + coeficienteVariacion + "\n";
				
				double desviacionMedia = operacion.desviacionMediaAgrupados(x, f);
				texto = texto + "Desviacion Media: " + desviacionMedia + "\n";
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
		
	public void accionBotonMediaPonderada(){ //10
		btnMediaPonderada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n_string = JOptionPane.showInputDialog("Número de datos:");
				int n = Integer.parseInt(n_string);
				
				double x[] = new double[n];
				double w[] = new double[n];
				
				for (int i = 0; i < n; i++) {
					String dato = JOptionPane.showInputDialog("Dato (X) " + (i+1) + ": ");
					x[i] = Double.valueOf(dato);
					String peso = JOptionPane.showInputDialog("Peso (W) " + (i+1) + ": ");
					w[i] = Double.valueOf(peso);
				}
				
				String texto = "Datos: \n";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + "\nPesos: \n";
				
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + w[i] + "] ";
				}
				texto = texto + " \n";
				
				double mediaPonderada = operacion.mediaPonderada(x, w);
				texto = texto + "Media Ponderada: " + mediaPonderada + "\n";
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonCovarianza(){ //11
		btnCovarianza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n_string = JOptionPane.showInputDialog("Número de datos:");
				int n = Integer.parseInt(n_string);
				
				double x[] = new double[n];
				double y[] = new double[n];
				double f[] = new double[n];
				
				for (int i = 0; i < n; i++) {
					String dato = JOptionPane.showInputDialog("X " + (i+1) + ": ");
					x[i] = Double.valueOf(dato);
					String y_string = JOptionPane.showInputDialog("Y " + (i+1) + ": ");
					y[i] = Double.valueOf(y_string);
					String frecuencia = JOptionPane.showInputDialog("Frecuencia " + (i+1) + ": ");
					f[i] = Double.valueOf(frecuencia);
				}
				
				String texto = "X: ";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + "\nY: ";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + y[i] + "] ";
				}
				texto = texto + "\nF: ";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + f[i] + "] ";
				}
				texto = texto + "\n";
				
				
				double covarianza = operacion.covarianza(x, y, f, true);
				texto = texto + "Covarianza (Población): " + covarianza + "\n";
				
				double covarianzaMuestra = operacion.covarianza(x, y, f, false);
				texto = texto + "Covarianza (Muestra): " + covarianzaMuestra + "\n";
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public double[] preguntaFrecuencia() {
		String[] opciones = new String[2];
		opciones[0] = "Sin frecuencias";
		opciones[1] = "Con frecuencias";
		
		int opcion = JOptionPane.showOptionDialog(
                null                            
              , "Seleccione opción"            
              , "Frecuencias"         
              , JOptionPane.DEFAULT_OPTION       
              , JOptionPane.INFORMATION_MESSAGE  
              , null                             
              , opciones                         
              , null                             
            );
		
		String n_string = JOptionPane.showInputDialog("Número de datos:");
		int n = Integer.parseInt(n_string);
		double x[] = new double[n];
		double datos[];
		
		if (opcion == 0) {
			for (int i = 0; i < n; i++) {
				String dato = JOptionPane.showInputDialog("Dato " + (i+1) + ": ");
				x[i] = Double.valueOf(dato);
			}
			
		}else {
			double f[] = new double[n];
			double total = 0;
			
			for (int i = 0; i < n; i++) {
				String dato = JOptionPane.showInputDialog("Dato " + (i+1) + ": ");
				x[i] = Double.valueOf(dato);
				String frecuencia = JOptionPane.showInputDialog("Frecuencia " + (i+1) + ": ");
				f[i] = Double.valueOf(frecuencia);
				total = total + f[i];
			}
			
			datos = new double[(int)total];
			int h = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < f[i]; j++) {
					datos[h] = x[i];
					h++;
				}
			}
			
			x = datos;
			n = (int)total;
		}
		return(x);
	}
	
	public void accionBotonCuartiles(){ //12
		btnCuartiles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double[] x;
				
				x = preguntaFrecuencia();
				int n = x.length;
					
				x = operacion.ordenar(x);
					
				String texto = "Datos: \n";
				for (int i = 0; i< n; i++) {
					if (i != 0 && i%20 == 0)
						texto = texto + "\n";
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + " \n";
				
				texto = texto + "Cuartil 1: " + operacion.cuartil(x,  1) + "\n";
				texto = texto + "Cuartil 2: " + operacion.cuartil(x,  2) + "\n";
				texto = texto + "Cuartil 3: " + operacion.cuartil(x,  3) + "\n";
				texto = texto + "Cuartil 4: " + operacion.cuartil(x,  4) + "\n";
								
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonDeciles(){ //14
		btnDeciles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double[] x;
				
				x = preguntaFrecuencia();
				int n = x.length;
					
				x = operacion.ordenar(x);
				x = operacion.ordenar(x);
				
				String texto = "Datos: \n";
				for (int i = 0; i< n; i++) {
					if (i != 0 && i%20 == 0)
						texto = texto + "\n";
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + " \n";
				
				for (int i = 0; i < 10; i++) {
					texto = texto + "Decil " + (i+1) + ": " + operacion.decil(x, (i+1)) + "\n";
				}
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonPercentiles(){ //13
		btnPercentiles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sólo puede calcular menos de 15 percentiles a la vez");
				double[] x;
				
				x = preguntaFrecuencia();
				int n = x.length;
				
				x = operacion.ordenar(x);
				String texto = "Datos: \n";
				for (int i = 0; i< n; i++) {
					if (i != 0 && i%20 == 0)
						texto = texto + "\n";
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + " \n";
				
				int num = 15;
				while (num>14) {
					String num_string = JOptionPane.showInputDialog("Número de percentiles a calcular:");
					num = Integer.parseInt(num_string);
					if (num>14) {
						JOptionPane.showMessageDialog(null, "Opción inválida");
					}
				}
				
				double[] percentil = new double[num];
				for (int i = 0; i < num; i++) {
					String posicion = JOptionPane.showInputDialog("Introduzca Posición:");
					percentil[i] = Double.valueOf(posicion);
				}
				
				for (int i = 0; i < num; i++) {
					texto = texto + "Percentil " + (percentil[i]) + ": " + operacion.percentil(x, percentil[i]) + "\n";
				}
				
				areaConsola.setText("");
				areaConsola.setText(texto);
			}
		});
	}
	
	public void accionBotonRecta(){ //9
		btnRecta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n_string = JOptionPane.showInputDialog("Número de datos:");
				int n = Integer.parseInt(n_string);
				
				double x[] = new double[n];
				double y[] = new double[n];
				double f[] = new double[n];
				for (int i = 0; i < n; i++) {
					String dato = JOptionPane.showInputDialog("X " + (i+1) + ": ");
					x[i] = Double.valueOf(dato);
					String y_string = JOptionPane.showInputDialog("Y " + (i+1) + ": ");
					y[i] = Double.valueOf(y_string);
					f[i] = 1;
				}
				
				String texto = "X: ";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + x[i] + "] ";
				}
				texto = texto + "\nY: ";
				for (int i = 0; i< n; i++) {
					texto = texto + "[" + y[i] + "] ";
				}
				texto = texto + "\n";
				
				double mediaX =  operacion.mediaAritmetica(x);
				texto = texto + "Media X: " + mediaX  + "\n";
				
				double mediaY =  operacion.mediaAritmetica(y);
				texto = texto + "Media X: " + mediaY  + "\n";
				
				double varianzaX = operacion.varianza(x);
				texto = texto + "Varianza X: "  + varianzaX + "\n";
				
				double varianzaY = operacion.varianza(y);
				texto = texto + "Varianza Y: "  + varianzaY + "\n";
				
				double covarianza = operacion.covarianza(x, y, f, true);
				texto = texto + "Covarianza: " + covarianza + "\n";
				
				String variable = "";
				double var = 0;
				double calculoRecta = 0;
				
				String opcion = JOptionPane.showInputDialog("Dato a encontrar (X o Y):");
				if (opcion.charAt(0) == 'x' || opcion.charAt(0) =='X') {
					variable = JOptionPane.showInputDialog("Introduzca Y:");
					var = Double.valueOf(variable);
					calculoRecta = operacion.rectaRegresionXsobreY(covarianza, varianzaY, 
																	mediaX, mediaY, var);
					texto = texto + "Y = " + variable + "  X = " + calculoRecta + "\n";
					areaConsola.setText("");
					areaConsola.setText(texto);
					
					
				}else if ( opcion.charAt(0) == 'y' || opcion.charAt(0) =='Y') {
					variable = JOptionPane.showInputDialog("Introduzca X:");
					var = Double.valueOf(variable);
					calculoRecta = operacion.rectaRegresionYsobreX(covarianza, varianzaX, 
							mediaX, mediaY, var);
					texto = texto + "X = " + variable + "  Y = " + calculoRecta + "\n";
					areaConsola.setText("");
					areaConsola.setText(texto);
				}else {
					JOptionPane.showMessageDialog(null, "Opción inválida");
				}
			}
		});
	}

}