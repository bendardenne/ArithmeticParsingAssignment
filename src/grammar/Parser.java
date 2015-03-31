package grammar;

public class Parser {

    int pos = 0;
    String[] input; 
    
    // modify this
    public boolean parse(String[] input) {
        if(input.length == 0) return true;
        
        this.input = input;
        pos = 0;
        return parseExpression() && pos == input.length;
    }
    
    private boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean parseExpression(){
        
        boolean ret = parseTerm();
        boolean more = true;
        
        while(more && pos < input.length){
            if(input[pos] == Grammar.PLUS || input[pos] == Grammar.MINUS){
               pos++;
               ret &= parseTerm();
            } else {more = false;}
        }    
       
        return ret;
    }
    
    private boolean parseTerm() {

        boolean ret = parseFactor();
        boolean more = true;
        
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
}