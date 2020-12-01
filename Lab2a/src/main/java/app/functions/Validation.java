package app.functions;

import java.math.BigDecimal;

public class Validation {

    private BigDecimal minLimit;
    private BigDecimal maxLimit;
    private boolean isInterval;

    public Validation(float minLimit, float maxLimit, boolean isInterval){
        this.minLimit = new BigDecimal(minLimit);
        this.maxLimit = new BigDecimal(maxLimit);
        this.isInterval = isInterval;
    }

    public boolean validate(float val){

        //check if the value is X
        if (isInterval){
            try {
                BigDecimal x = BigDecimal.valueOf(val);
                if (x.compareTo(maxLimit) >= 0 || x.compareTo(minLimit) <= 0) return false;
            } catch(NumberFormatException e){
                System.out.println("X isn't a number");
                return false;
            }
        } else {
            try {

                //try to parse to float
                BigDecimal value = BigDecimal.valueOf(val);

                //check if val out of the interval
                if (value.compareTo(maxLimit) > 0 || value.compareTo(minLimit) < 0) return false;
            } catch (NumberFormatException e) {
                System.out.println("Value isn't a number");
                return false;
            }
        }

        return true;
    }
}
