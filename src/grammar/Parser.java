package grammar;

public class Parser {

    int pos = 0;
    String[] input; 
    
    // modify this
    public boolean parse(String[] input) {
        this.input = input;
        pos = 0;
        return parseExpression() && pos == input.length;
    }
    
    private boolean isNum(String s){
        try{
            Integer.parseInt(s);
            System.out.println("number: " + s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean parseExpression(){
        
        boolean more = true;
        boolean ret = parseTerm();
        
        while(more && pos < input.length){
            if(input[pos] == Grammar.PLUS || input[pos] == Grammar.MINUS){
               pos++;
               ret &= parseTerm();
            } else {more = false;}
        }    
       
        return ret;
    }
    
    private boolean parseTerm() {

        boolean more = true;
        boolean ret = parseFactor();
        
        while(more && pos < input.length){
            if(input[pos] == Grammar.TIMES || input[pos] == Grammar.DIVIDE){
               pos++;
               ret &= parseFactor();
            } else {more = false;}
        }    
        
        return ret;
    }

    private boolean parseFactor() {
       
        if(! (pos < input.length))
            return false;
        
        boolean ret = isNum(input[pos]);
        
        if(input[pos] == Grammar.LEFTPAR)
        {
            pos++;
            ret = parseExpression();
            ret &= pos < input.length && input[pos] == Grammar.RIGHTPAR;
        }
        
        pos++;
        return ret;
    }

    private boolean parseParExpression(){
        
        if(pos >= input.length) return false;
        
        if(input[pos] == Grammar.LEFTPAR){
            pos++;
            boolean ret = parseExpression();
            ret &= input[pos] == Grammar.RIGHTPAR;
            return ret;   
        }
        
        return false;
    }
}