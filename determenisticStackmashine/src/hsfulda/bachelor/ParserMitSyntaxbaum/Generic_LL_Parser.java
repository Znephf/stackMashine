package hsfulda.bachelor.ParserMitSyntaxbaum;

import java.util.*;

import javax.swing.tree.TreeModel;

//import  I_FlexibleGenericParserWithTree;

public class Generic_LL_Parser implements I_FlexibleGenericParserWithTree {

	//Generate data structure for Parser
	
	public ArrayList <Character> inputAlphabet = new ArrayList <Character>();
	public ArrayList <Character> stackAlphabet = new ArrayList <Character>();
	public ArrayList <String []>transferFunction = new ArrayList<String []>();
	public Deque<Character> stack = new ArrayDeque<Character>();
	Character stackLast;
	public Character startSymbol;
	
	Generic_LL_Parser(){
		
	}
	
	
	@Override
	public void addToSigma(char a) {
		// TODO Auto-generated method stub
		this.inputAlphabet.add(a);
	}
	@Override
	public void addToGamma(char x) {
		// TODO Auto-generated method stub
		this.stackAlphabet.add(x);
		if(stackAlphabet.size() == 1) {
			startSymbol = x;
			}
		System.out.println("addToGamma:" + x + "added");
	}
	@Override
	public void addToDelta(char x, char a, String alpha) {
		// TODO Auto-generated method stub
		String [] tFunction = { Character.toString(x) , Character.toString(a) , alpha };
		transferFunction.add(tFunction);
		System.out.println(transferFunction);
	}
	@Override
	public int[] parse(String wort) throws ParseException {
		

		boolean found = false;
		
		stack.push(startSymbol); // Load startSymbol in stack
		while(wort.length()>0) {
			
			if(stack.isEmpty()) {
				throw new ParseException();
			}
			Character lastChar = stack.pop();
			Character buchstabe = wort.charAt(0);
			found = false;
			for (int i = 0; i < transferFunction.size(); i++) { // Find transferFunction
				String [] help = transferFunction.get(i);
				if (help[0].charAt(0) == (lastChar) && help[1].charAt(0) ==buchstabe){
					found = true;
					while(help[2].length() > 0){ // PUSH Variables (alpha) to Stack
						Character lastone = help[2].charAt(help[2].length()-1);
						stack.push(lastone);
						help[2] = help[2].substring(0, help[2].length()-2);
					}
				}
				
			}
			
			wort = wort.substring(1,wort.length()-1);
		
		}
		if(!stack.isEmpty()) {
			throw new ParseException();
		}
		
	/*
			
			if(help[0].equals(startSymbol)) {
				stack.push(help[0]);
			}
			
		}
		*/
		return null;
	}
	@Override
	public TreeModel getSyntaxTree() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void showTree() {
		// TODO Auto-generated method stub
		
	}

	
	
}
