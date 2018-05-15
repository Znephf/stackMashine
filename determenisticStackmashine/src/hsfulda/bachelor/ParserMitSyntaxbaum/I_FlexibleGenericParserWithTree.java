package hsfulda.bachelor.ParserMitSyntaxbaum;

import javax.swing.tree.TreeModel;

public interface I_FlexibleGenericParserWithTree {
	
	// Operationen zur Manipulation der Stackmaschine:
	
	/*
	 * Fuegt a als Eingabesymbol hinzu.
	 */
	public void addToSigma(char a);

	/*
	 * Fuegt x als Stacksymbol hinzu.
	 * Ist x das erste zugefuegte Stacksymbol, wird es gleichzeitig als Startsymbol gesetzt.
	 */
	public void addToGamma(char x);
	
	/*
	 * Erweitert die Uebergangsfunktion um einen Eintrag fuer Stacksymbol x und Eingabesymbol a
	 */
	public void addToDelta(char x, char a, String alpha);
	
	
	// Operationen fuer das Parsen und den Zugriff auf das Ergebnis
	
	/*
	 * Parse Operation ueberprueft die syntaktische Korrektheit der Eingabe wort. 
	 * 
	 * Als Ergebnis wird ein Array int[] zurueck gegeben. 
	 * In diesem Array ist der Verlauf gespeichert, wie sich die Hoehe des Stacks waehrend der Verarbeitung von wort veraendert. 
	 * Wird das Wort erkannt, hat dieses Array also einen Eintrag mehr als das wort Zeichen hat. An 0. Stelle steht der Wert 1. 
	 * An letzter Stelle steht der Wert 0. Dazwischen kann die Stackhoehe mal anwachsen und mal wieder abnehmen.
	 */
	public int[] parse(String wort) throws ParseException;
	
	/*
	 * Erlaubt den Zugriff auf den beim Parsen erzeugten Syntaxbaum
	 */
	public TreeModel getSyntaxTree();
	
	/*
	 * Zeigt den beim Parsen erzeugten Syntaxbaum an
	 */
	public void showTree();
}
