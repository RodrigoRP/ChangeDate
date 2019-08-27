package application;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;



public class Main {

	public static void main(String[] args) {
		char op = 0;
		long value = 0;
		
		Calendar cal = Calendar.getInstance();
		//Date date = cal.getTime();
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		
		
		//System.out.println(formatter.format(date));
		//Scanner sc = new Scanner(System.in);
		//sc.hasNextLong();
		value = 40000;
		ChangeDate(cal, op, value);
		
	
		

	}

	private static void ChangeDate(Calendar cal, char op, long value) {
		//1440 dia 43200 mes 518400
		/*
		 * int hora = cal.get(Calendar.HOUR); int minutos = cal.get(Calendar.MINUTE);
		 * int dia = cal.get(Calendar.DAY_OF_MONTH);
		 */
		final int JAN = 1;
		final int FEV = 2;
		final int MAR = 3;
		final int ABR = 4;
		final int MAI = 5;
		final int JUN = 6;
		final int JUL = 7;
		final int AGO = 8;
		final int SET = 9;
		final int OUT = 10;
		final int NOV = 11;
		final int DEZ = 12;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(JAN, 31);
		map.put(FEV, 28);
		map.put(MAR, 31);
		map.put(ABR, 30);
		map.put(MAI, 31);
		map.put(JUN, 30);
		map.put(JUL, 31);
		map.put(AGO, 31);
		map.put(SET, 30);
		map.put(OUT, 31);
		map.put(NOV, 30);
		map.put(DEZ, 31);
	
		
		
		int dia = 27;
		int mes = 8;
		int ano = 2019;
		int hora = 0;
		int minuto = 0;
		
		int newValueDias = 0;
		int newValueMinutos = 0;
		
		int valueMinutosAcrescimo = 0;
		int newValueMinutos2 = 0;
		float minutosHora = 0;
		if(value > 1440 && value < 43200) {
			newValueDias = (int) (value / 1440); //Nro de Dias
			newValueMinutos = 1440 * newValueDias;
			value = value - newValueMinutos;
		}
		
	
		if(value < 1440 && value > 60) {
			minutosHora = value/60; //Horas
			newValueMinutos2 = (int) (minutosHora * 60);
			valueMinutosAcrescimo = (int) (value - newValueMinutos2);
			
		}
	
		//System.out.println("Dias:"+newValueDias+"\nHoras:"+minutosHora+"\nMinutos:"+valueMinutosAcrescimo);
		
		minuto = minuto + valueMinutosAcrescimo;
		hora = (int) (hora + minutosHora);
		dia = dia + newValueDias;
		if(minuto > 59) {
			minuto = minuto - 60;
			hora++;
		}
		if(hora > 23) {
			hora = hora - 24;
			dia++;
		}
		
		if(dia > map.get(mes)) {
			System.out.println("aaaaaa"+map.get(mes));
			dia = dia - map.get(mes);
			mes++;
		}
		
		System.out.println(dia);
		System.out.println(mes);
		System.out.println(ano);
		System.out.println(hora);
		System.out.println(minuto);
		System.out.println("opa"+map.get(JAN));
		
	}

}
