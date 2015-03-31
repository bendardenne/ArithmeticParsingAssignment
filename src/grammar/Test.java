package grammar;

public class Test {

    public static void main(String[] args){
       
        Generator gen = new Generator((int) System.currentTimeMillis());
        Parser parser = new Parser();
        
        String[] example = gen.generate(2);
        
        for(String e: example){
            System.out.print(e);
        }
  
        String[] wrong = {"(", "4", "+" , "(", "(", "8", ")" };
        String[] simple = {"4", "+", "2", "/", "0", "+", "(", "4", "/", "8", ")"};
       
        
        System.out.println(parser.parse(simple));
        
        System.out.println(parser.parse(example));
       
        System.out.println(parser.parse(wrong));
        
        
    } 
    
}
