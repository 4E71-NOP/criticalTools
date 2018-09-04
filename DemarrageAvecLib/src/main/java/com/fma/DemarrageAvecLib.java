package com.fma;

import com.criticalTools.section.convert.NumberRepesentation;
import com.criticalTools.section.system.MemoryService;

public class DemarrageAvecLib {

	public static void main(String[] args) {

		NumberRepesentation nr = NumberRepesentation.getInstance();
		int intDec = 15823;

		String strBin = nr.BaseConvertion(intDec, 2);
		String strTri = nr.BaseConvertion(intDec, 3);
		String strQua = nr.BaseConvertion(intDec, 4);
		String strQui = nr.BaseConvertion(intDec, 5);
		String strSen = nr.BaseConvertion(intDec, 6);
		String strSep = nr.BaseConvertion(intDec, 7);
		String strOct = nr.BaseConvertion(intDec, 8);
		String strNon = nr.BaseConvertion(intDec, 9);
		String strunD = nr.BaseConvertion(intDec, 11);
		String strDoz = nr.BaseConvertion(intDec, 12);
		String strHex = nr.BaseConvertion(intDec, 16);

		System.out.println("Dec -> Bin(" + intDec + "): " + strBin);
		System.out.println("Dec -> Tri(" + intDec + "): " + strTri);
		System.out.println("Dec -> Qua(" + intDec + "): " + strQua);
		System.out.println("Dec -> Qui(" + intDec + "): " + strQui);
		System.out.println("Dec -> Sen(" + intDec + "): " + strSen);
		System.out.println("Dec -> Sep(" + intDec + "): " + strSep);
		System.out.println("Dec -> Oct(" + intDec + "): " + strOct);
		System.out.println("Dec -> Non(" + intDec + "): " + strNon);
		System.out.println("Dec -> unD(" + intDec + "): " + strunD);
		System.out.println("Dec -> Doz(" + intDec + "): " + strDoz);
		System.out.println("Dec -> Hex(" + intDec + "): " + strHex);

		System.out.println("Bin -> Dec (" + strBin + "): " + nr.BaseConvertion(strBin, 2, 16));
		System.out.println("Tri -> Dec (" + strTri + "): " + nr.BaseConvertion(strTri, 3, 16));
		System.out.println("Qua -> Dec (" + strQua + "): " + nr.BaseConvertion(strQua, 4, 16));
		System.out.println("Qui -> Dec (" + strQui + "): " + nr.BaseConvertion(strQui, 5, 16));
		System.out.println("Sen -> Dec (" + strSen + "): " + nr.BaseConvertion(strSen, 6, 16));
		System.out.println("Sep -> Dec (" + strSep + "): " + nr.BaseConvertion(strSep, 7, 16));
		System.out.println("Oct -> Dec (" + strOct + "): " + nr.BaseConvertion(strOct, 8, 16));
		System.out.println("Non -> Dec (" + strNon + "): " + nr.BaseConvertion(strNon, 9, 16));
		System.out.println("unD -> Dec (" + strunD + "): " + nr.BaseConvertion(strunD, 11, 16));
		System.out.println("Doz -> Dec (" + strDoz + "): " + nr.BaseConvertion(strDoz, 12, 16));
		System.out.println("Hex -> Dec (" + strHex + "): " + nr.BaseConvertion(strHex, 16, 16));

		MemoryService.getInstance().executeSystemGc();
		
	}

}
