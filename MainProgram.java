import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainProgram 
{
	
	static Map<String, String> dizionarioInCodice = new HashMap<String, String>();
	static String stringInput = "";
	static Scanner keyboard = new Scanner(System.in);
	static List<String> significati = new ArrayList<String>();
	static List<String> significanti = new ArrayList<String>();
	static List<String> listaTemporanea = new ArrayList<String>();

	public static void main(String[] args) {
		
		CreateDictionaries();
		//ConvertText();
	}

	
    static void print(String text) {
        System.out.println(text);
    }
    
    static void ReplaceListWithList(List<String> list1, List<String> list2)
    {
		list1.clear();
    	for (int i4 = 0; i4 < list2.size(); i4++) {
			list1.add(list2.get(i4));
		}
    }

    static void CreateDictionaries()
    {
    	
		boolean getInput = true;


		int lunghezzaSignificante = 1;
		
		do {
            print("\nAggiungi un significato nell'ordine di assegnazione (digitare @E per uscire):\n ");
            stringInput = keyboard.nextLine();
            if (stringInput.contains("@E")) getInput = false;
            else significati.add(stringInput);
        } while (getInput);
		
		getInput = true;
		
		do {
            print("Aggiungi un significante nell'ordine di assegnazione (digitare @E per uscire):\n ");
            stringInput = keyboard.nextLine();
            if (stringInput.contains("@E")) getInput = false;
            else significanti.add(stringInput);
        } while (getInput);
		
        ReplaceListWithList(listaTemporanea, significanti);
        
		while ((Math.pow(significanti.size(),lunghezzaSignificante)) < significati.size())
		{
			lunghezzaSignificante++;
		}
		
		List<String> listaTemporanea2 = new ArrayList<String>();
		
		while (listaTemporanea.get(0).length() < lunghezzaSignificante)
		{
						
			for (int i2 = 0; i2 < listaTemporanea.size(); i2++) {
				for (int i3 = 0; i3 < significanti.size(); i3++) {

					listaTemporanea2.add((listaTemporanea.get(i2) + significanti.get(i3)));
				}
			}
			
		
			listaTemporanea.clear();

			ReplaceListWithList(listaTemporanea, listaTemporanea2);
			
			listaTemporanea2.clear();
		}
		
		//FUORI WHILE

		ReplaceListWithList(significanti, listaTemporanea);
		for (int i = 0; i < significati.size(); i++)
		{
			System.out.println(significanti.get(i) + " = " + significati.get(i));
			dizionarioInCodice.put(significati.get(i), significanti.get(i));
		}
		System.out.println(dizionarioInCodice);
    }

/*    static void ConvertText()
    {
    	System.out.println("Inserisci il testo da convertire: ");
    	
    	stringInput = keyboard.nextLine();
    	
    	for (int i = 0; i < significati.size(); i++) {
    	stringInput = stringInput.replaceAll(significati.get(i).toString(), significanti.get(i).toString());
    	}
    	
    	System.out.println(stringInput);
    }
}*/
