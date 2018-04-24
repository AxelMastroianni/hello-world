import it.unibs.fp.mylib.InputDati;

public class provaCodice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String codiceFiscale="";
		CodiceFiscale codice=new CodiceFiscale(codiceFiscale);
		do {
		codiceFiscale=InputDati.leggiStringaNonVuota("Inserisci il tuo codice fiscale: ");
		}while(!codice.codiceCorretto());
	}

}
