package grammar;

public class Test {

    public static void main(String[] args){
       
        Generator gen = new Generator((int) System.currentTimeMillis());
        Parser parser = new Parser();
        
        String[] example = gen.generate(2);
        
        for(String e: example){
            System.out.print(e);
        }
        System.out.println();
        System.out.println(parser.parse(example));
  
        String[] wrong = {"(", "4", "+" , "(", "(", "8", ")" };
        String[] simple = {"4", "+", "2", "/", "0", "+", "(", "4", "/", "8", ")"};
        String[]empty = {};
        
        System.out.println(parser.parse(wrong));
        System.out.println(parser.parse(simple));
        System.out.println(parser.parse(empty));
    } 
}
