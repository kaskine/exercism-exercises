import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class VariableLengthQuantity {

    private static final byte SHIFT_MASK = 0b111;
    private static final long CONTINUE_MASK = 0x80;

    private static final byte BYTE_MAX = 0x7f;

    private static final String HEX_NOTATION = "0x";

    List<String> encode(List<Long> numbers) {

        LinkedList<String> returnList = new LinkedList<>();

        for (Long val : numbers) {
            LinkedList<String> currentList = new LinkedList<>();

            if (val <= Byte.MAX_VALUE) {
                currentList.add(HEX_NOTATION + Long.toHexString(val));
            }
            else {
                boolean isFirstByte = true;
                while (val > 0) {
                    byte result = (byte) (val & BYTE_MAX);

                    if (!isFirstByte) {
                        result |= Byte.MAX_VALUE + 1;
                    }
                    else {
                        isFirstByte = false;
                    }

                    currentList.add(HEX_NOTATION + Integer.toHexString(Byte.toUnsignedInt(result)));
                    val >>= SHIFT_MASK;

                    if (val < 1) {
                        break;
                    }
                }
            }
            Collections.reverse(currentList);
            returnList.addAll(currentList);
        }
        return returnList;
    }

    List<String> decode(List<Long> bytes) {

        LinkedList<String> list = new LinkedList<>();

        long result = 0;
        int position = 0;
        boolean shouldContinue = true;
        for (Long val : bytes) {
            if (!((val & CONTINUE_MASK) == CONTINUE_MASK)) {
                shouldContinue = false;
            }
            else {
                val ^= CONTINUE_MASK;
            }

            result <<= SHIFT_MASK;
            result += val;

            if (result < 0 || (shouldContinue && position == bytes.size() - 1)) {
                throw new IllegalArgumentException("Invalid variable-length quantity encoding");
            }
            if (!shouldContinue) {
                list.add(HEX_NOTATION + Long.toHexString(result));
                shouldContinue = true;
                result = 0;
            }
            position++;
        }

        return list;
    }
}
