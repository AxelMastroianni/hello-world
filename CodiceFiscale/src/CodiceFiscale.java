import java.util.*;
public class CodiceFiscale {
	String codice="";
	public static final char[] vocali= {'a','e','i','o','u'};
	public static final int PRIME_SEI_LETTERE=6;
	public static final int MASSIME_LETTERE=16;
	public static final int MASSIMI_NUMERI_ANNO=2;
	public static final int NUMERO_MESE=1;
	public static final int PARTENZA_GIORNO=9;
	public static final int POSIZIONE_COMUNE=11;
	public static final int POSIZIONE_CODICE_COMUNE=12;
	public static final int ULTIMA_LETTERA=15;
	public CodiceFiscale(String codice) {
		this.codice=codice;
	}
	public boolean isVocale(char lettera) {
		for(int i=0;i<vocali.length;i++) {
			if(vocali[i]==lettera)
				return true;
		}
		return false;
	}
	public boolean isLettera(char carattere) {
		if((carattere>='A' && carattere<='Z'))
			return true;
		return false;
	}
	public boolean lungaSedici() {
		if(codice.length()==MASSIME_LETTERE)
			return true;
		return false;
	}
	public boolean sonoSei() {
		int i=0;
		for(i=0;i<PRIME_SEI_LETTERE;) {
			if(isLettera(codice.charAt(i)))
				i++;
		}
		if(i==PRIME_SEI_LETTERE)
			return true;
		return false;
	}
	public boolean annoCorretto() {
		int contaAnni=0;
		for(int i=PRIME_SEI_LETTERE;i<PRIME_SEI_LETTERE+MASSIMI_NUMERI_ANNO;i++) {
			if(!isLettera(codice.charAt(i)))
				contaAnni++;
		}
		if(contaAnni==MASSIMI_NUMERI_ANNO)
			return true;
		return false;
	}
	public boolean meseCorretto() {
		if(isLettera(codice.charAt(MASSIMI_NUMERI_ANNO+NUMERO_MESE+PRIME_SEI_LETTERE-1))) {
			if(codice.charAt(MASSIMI_NUMERI_ANNO+NUMERO_MESE+PRIME_SEI_LETTERE-1)>='A' && codice.charAt(PRIME_SEI_LETTERE+NUMERO_MESE+PRIME_SEI_LETTERE)<='O')
				return true;		
		}
		return false;
	}
	public boolean isMaschio() {
		int giorno=0;
		for(int i=PARTENZA_GIORNO;i<11;i++) {
			if(!isLettera(codice.charAt(i))&&(codice.charAt(i)>='0' && codice.charAt(i)<='9'))
				giorno++;
		}
		if(giorno==2) {
			if(codice.charAt(PARTENZA_GIORNO)>='0' && codice.charAt(PARTENZA_GIORNO)<='3')
				return true;
		}
		return false;
	}
	public boolean isFemmina() {
		int giorno=0;
		for(int i=PARTENZA_GIORNO;i<11;i++) {
			if(!isLettera(codice.charAt(i))&&(codice.charAt(i)>='0' && codice.charAt(i)<='9'))
				giorno++;
		}
		if(giorno==2) {
			if(codice.charAt(PARTENZA_GIORNO)>='4' && codice.charAt(PARTENZA_GIORNO)<='7')
				return true;
		}
		return false;
	}
	public boolean controllaComune() {
		if(isLettera(codice.charAt(POSIZIONE_COMUNE)))
			return true;
		return false;
	}
	public boolean controllaCodiceComune() {
		int contaNumeri=0;
		for(int i=POSIZIONE_CODICE_COMUNE;i<POSIZIONE_CODICE_COMUNE+3;i++) {
			if(!isLettera(codice.charAt(i)))
				contaNumeri++;
		}
		if(contaNumeri==3)
			return true;
		return false;
	}
	public boolean controllaUltimaLettera() {
		if(isLettera(codice.charAt(ULTIMA_LETTERA)))
			return true;
		return false;
	}
	public boolean codiceCorretto() {
		if(lungaSedici()) {
			if(sonoSei()) {
				if(annoCorretto()) {
					if(meseCorretto()) {
						if(isMaschio() || isFemmina()) {
							if(controllaComune()) {
								if(controllaCodiceComune()) {
									if(controllaUltimaLettera())
										return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	
	
	

}
