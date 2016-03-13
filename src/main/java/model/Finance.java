package model;

public class Finance {
    private Double parseCourse;

    public String transfer(String text, Currency currency, boolean sale ){
        switch (currency){
            case USD:
                parseCourse = Double.parseDouble(ParseFinance.getUsd());
                break;
            case EUR:
                parseCourse = Double.parseDouble(ParseFinance.getEur());
                break;
            case CNY:
                parseCourse = Double.parseDouble(ParseFinance.getCny());
                break;
            case UAH:
                parseCourse = Double.parseDouble(ParseFinance.getUah());
        }

        Double num = Double.parseDouble(text);

        if(sale) {
            num = num / parseCourse;

        }else {
            num = num * parseCourse;
        }
        return String.valueOf(num);
    }
}
