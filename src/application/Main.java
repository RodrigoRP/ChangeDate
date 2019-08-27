package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static int DIA_X = 566;
	
	public static void main(String[] args) {
		char op = 0;
		long value = 0;

		Calendar cal = Calendar.getInstance();
		// Date date = cal.getTime();
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		// System.out.println(formatter.format(date));
		// Scanner sc = new Scanner(System.in);
		// sc.hasNextLong();
		
		value = 1440 * DIA_X;
		ChangeDate(cal, op, value);

	}

	private static void ChangeDate(Calendar cal, char op, long value) {

		int hora = cal.get(Calendar.HOUR);
		int minuto = cal.get(Calendar.MINUTE);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);

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

		int newValueDias = 0;
		int newValueMinutos = 0;

		int valueMinutosAcrescimo = 0;
		int newValueMinutos2 = 0;
		float minutosHora = 0;

		/* CALCULA NUMERO DE DIAS */

		if (value > 1440) {
			newValueDias = (int) (value / 1440); // Nro de Dias
			newValueMinutos = 1440 * newValueDias;
			value = value - newValueMinutos; // Nro de minutos
		}

		/* CALCULA NUMERO DE MINUTOS */

		if (value < 1440 && value > 60) {
			minutosHora = value / 60; // HORAS
			newValueMinutos2 = (int) (minutosHora * 60);
			valueMinutosAcrescimo = (int) (value - newValueMinutos2); // MINUTOS

		}

		minuto = minuto + valueMinutosAcrescimo;
		hora = (int) (hora + minutosHora);
		dia = dia + newValueDias;
		if (minuto > 59) {
			minuto = minuto - 60;
			hora++;
		}
		if (hora > 23) {
			hora = hora - 24;
			dia++;
		}
		int mesNovoAno = 0;
		while (dia > map.get(mes)) {

			dia = dia - map.get(mes);
			if (mes < 12) {
				mes++;
			} else {
				mes = mesNovoAno + 1;
				mesNovoAno++;
			}

		}
		if (mesNovoAno != 0)
			ano = ano + mesNovoAno;

		Calendar c2 = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		c2.add(Calendar.DAY_OF_MONTH, DIA_X);
	
		System.out.println(sdf.format(c2.getTime()));
		
		System.out.println(dia);
		System.out.println(mes);
		System.out.println(ano);
		System.out.println(hora);
		System.out.println(minuto);

	}

}
