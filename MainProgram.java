import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	static List<Persona> personsDatabase = new ArrayList<Persona>();

	public static void main(String[] args) {
		while (true)
			Commands();

	}

	static void print(String text) {
		System.out.println(text);
	}

	static void Commands() {
		Scanner keyboard = new Scanner(System.in); // System.in è l'input stream di default
		int intInput = 0;
		String stringInput = "";
		do {
			print("[1] Aggiungi persona [2] Cerca persona [3] Elimina utente: ");
			intInput = keyboard.nextInt();
		} while (intInput < 0 && intInput > 3);

		if (intInput == 1) { // AGGIUNGI PERSONA
			Persona person = Persona.CreatePerson();
			boolean personExists = false;

			for (int i = 0; i < personsDatabase.size(); i++) {
				// Controlla se la persona esiste già
				if (personsDatabase.get(i).ComparePersons(person))
					personExists = true;
			}

			// Aggiunge la persona al database, se non è già presente
			if (!personExists)
				personsDatabase.add(person);
			else
				print("Questa persona è già nel database");

		} else if (intInput == 2) { // CERCA PERSONA
			do {
				print("[1] Ricerca rapida [2] Ricerca normale: ");
				intInput = keyboard.nextInt();
			} while (intInput < 0 && intInput > 2);

			if (intInput == 2) {
				Persona person = Persona.CreatePerson();
				boolean personExists = false;

				for (int i = 0; i < personsDatabase.size(); i++) {
					if (personsDatabase.get(i).ComparePersons(person))
						personExists = true;
				}

				// Conferma la presenza della persona nel database
				if (personExists)
					print(person.nome + " " + person.cognome + " è presente nel database");
				else
					print(person.nome + " " + person.cognome + " non è presente nel database");

			} else if (intInput == 1) {
				String nome = "";
				String cognome = "";

				stringInput = keyboard.nextLine();

				// Prende in input nome e cognome della persona da cercare e poi li compara a
				// quelli nella lista
				print("Nome: ");
				stringInput = keyboard.nextLine();
				nome = stringInput.toLowerCase();

				print("Cognome: ");
				stringInput = keyboard.nextLine();
				cognome = stringInput.toLowerCase();

				for (int i = 0; i < personsDatabase.size(); i++) {
					if (personsDatabase.get(i).nome.contains(nome) && personsDatabase.get(i).cognome.contains(cognome))
						personsDatabase.get(i).PrintData();
					else if (i == personsDatabase.size())
						print(nome + " " + cognome + " non è nel database");
				}
			}

		} else if (intInput == 3) { // ELIMINA PERSONA

			Persona person = Persona.CreatePerson();

			for (int i = 0; i < personsDatabase.size(); i++) {
				if (personsDatabase.get(i).ComparePersons(person)) {
					personsDatabase.remove(i);
					print("Utente rimosso dal database.");
				} else
					print(person.nome + " " + person.cognome + " non è nel database");
			}
		}
	}
}
