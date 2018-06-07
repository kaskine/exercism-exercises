class PhoneNumber {

    private String number;

    PhoneNumber(String s) {
        if (s.charAt(0) == '+') {
            s = s.substring(1, s.length());
        }
        s = s.replaceAll("[-(). ]+", "");

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException("Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.");
            }
        }

        if (s.length() == 11) {
            if (s.charAt(0) == '1') {
                s = s.substring(1, s.length());
            }
            else {
                throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
            }
        }
        if (!(s.length() == 10)) {
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        }
        if ((s.charAt(0) == '0' || s.charAt(0) == '1') || (s.charAt(3) == '0') || (s.charAt(3) == '1')) {
            throw new IllegalArgumentException("Illegal Area Or Exchange Code. Only 2-9 are valid digits");
        }
        
        number = s;
    }

    String getNumber() {
        return number;
    }
}
