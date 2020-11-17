package app.functions;

import java.math.BigDecimal;

public class Validation {

    private BigDecimal minLimit;
    private BigDecimal maxLimit;
    private boolean isValX;

    public Validation(float minLimit, float maxLimit, boolean isValX){
        this.minLimit = new BigDecimal(minLimit);
        this.maxLimit = new BigDecimal(maxLimit);
        this.isValX = isValX;
    }

    public boolean validate(String val){
        if (val == null) return false;

        //check if the value is X
        if (isValX){
            try {
                BigDecimal x = BigDecimal.valueOf(Float.parseFloat(val));
                if (x.compareTo(maxLimit) >= 0 || x.compareTo(minLimit) <= 0) return false;
            } catch(NumberFormatException e){
                System.out.println("X isn't a number");
                return false;
            }
        } else {
            try {

                //try to parse to float
                BigDecimal value = BigDecimal.valueOf(Float.parseFloat(val));

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
