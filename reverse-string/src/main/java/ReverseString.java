class ReverseString {

    String reverse(String inputString) {

        StringBuilder sOutput = new StringBuilder();

        for (int i = inputString.length() - 1; i >= 0; i--)
            sOutput.append(inputString.charAt(i));

        return sOutput.toString();
    }
  
}