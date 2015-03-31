package grammar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static grammar.Grammar.*;

/**
 * Random generation of a valid derivation
 * DO NOT MODIFY
 */
public class Generator {
	
	private int seed;
	private final Random rand = new Random(seed);
	
	public Generator(int seed) {
		this.seed = seed;
	//	this.rand = new Random(seed); //FIXME REMOVE FOR INGINIOUS ?
	}
	
	
	
	public  String[] generate(int maxDepth) {
		List<String> res = new LinkedList<String>();
		generateE(res, maxDepth, 0);
		return res.toArray((new String[res.size()]));
	}
	
	public void generateE(List<String> output, int maxDepth, int currentDepth) {
		// E -> T | E + T | E - T
		if(currentDepth > maxDepth) { //prevent from exploding memory
			generateT(output, maxDepth, currentDepth + 1);
		}
		else {
			
			int i = rand.nextInt(3);
			switch(i) {
				case 0 : {
					generateE(output, maxDepth, currentDepth + 1);
					output.add(PLUS);
					generateT(output, maxDepth, currentDepth + 1);
					break;
				} 
				case 1 : {
					generateE(output, maxDepth, currentDepth + 1);
					output.add(MINUS);
					generateT(output, maxDepth, currentDepth + 1);
					break;
				}
				case 2 : {
					generateT(output, maxDepth, currentDepth + 1);
					break;
				}
			}
		}
		
	}
	
	public void generateT(List<String> output, int maxDepth, int currentDepth) {
		//T -> F | T * F | T / F
		if(currentDepth > maxDepth) { //prevent from exploding memory
			generateF(output, maxDepth, currentDepth + 1);
		}
		else {
			
			int i = rand.nextInt(3);
			switch(i) {
				case 0: {
					generateT(output, maxDepth, currentDepth + 1);
					output.add(TIMES);
					generateF(output, maxDepth, currentDepth + 1);
					break;
				} 
				case 1: {
					generateT(output, maxDepth, currentDepth + 1);
					output.add(DIVIDE);
					generateF(output, maxDepth, currentDepth + 1);
					break;
				}
				case 2: {
					generateF(output, maxDepth, currentDepth + 1);
					break;
				}
			}
		}
	}
	
		
	public void generateF(List<String> output, int maxDepth, int currentDepth) {
		// F -> ( E ) | id
		
		if(currentDepth > maxDepth) { //prevent from exploding memory
			generateId(output);
		}
		else {
			int i = rand.nextInt(2);
			switch(i) {
				case 0 : {
					output.add(LEFTPAR);
					generateE(output, maxDepth, currentDepth + 1);
					output.add(RIGHTPAR);
					break;
				}
				case 1 : {
					generateId(output);
					break;
				}	
			}
		}
	}
		
	public void generateId(List<String> output) {
		output.add(Integer.toString(rand.nextInt(Integer.MAX_VALUE)));
	}
	
}
