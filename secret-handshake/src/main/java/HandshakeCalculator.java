import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(number)).reverse();
        ArrayList<Signal> arrayList = new ArrayList<>();

        for(int i = 0; i < stringBuilder.length(); i++) {
            if(i < Signal.values().length && stringBuilder.charAt(i) == '1') {
                arrayList.add(Signal.values()[i]);
            }
        }

        if(stringBuilder.length() == 5 && stringBuilder.charAt(4) == '1') {
            Collections.reverse(arrayList);
        }

        return arrayList;
    }

}
