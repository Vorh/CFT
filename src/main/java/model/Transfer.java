package model;

public class Transfer {
    private static StringBuilder line;

    private  StringBuilder transfer2(int num){
        line = new StringBuilder();
        while (num != 0){
            if(num % 2 == 0){
                num = num / 2;
                line.append(0);
            }else if (num == 1) {
                line.append(1);
                break;
            }else {
                num = num / 2;
                line.append(1);
            }
        }

        line.reverse().toString();
        return line;
    }

    private  StringBuilder transfer10(int num){
        line = new StringBuilder();
        String v = String.valueOf(num);
        String[] s = v.split("");
        int one;
        int first = 0;
        int r = 2;
        int length = s.length-1;

        for (int i = 0; i <s.length ; i++) {
            one = Integer.parseInt(s[i]);
            for (int j = 0; j <length-1 ; j++) {
                r = r * 2;
            }
            one = one * r;
            first = first + one;
            r = 2;
            length--;
        }

        // Костыль
        if(s[s.length-1].equals("1")){
            first--;
        }
        line.append(first);
        return line;
    }

    public  String transferMain(ListSystem input, ListSystem output, String text){
        switch (output){
            case BINARY:
                return String.valueOf(transfer2(Integer.parseInt(text)));
            case DECIMAL:
                return String.valueOf((transfer10(Integer.parseInt(text))));
        }

        return "";
    }
}
