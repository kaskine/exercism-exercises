class RnaTranscription {

    String transcribe(String dnaStrand) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < dnaStrand.length(); i++) {
            switch (dnaStrand.charAt(i)) {
                case 'G':
                    stringBuilder.append('C');
                    break;
                case 'C':
                    stringBuilder.append('G');
                    break;
                case 'T':
                    stringBuilder.append('A');
                    break;
                case 'A':
                    stringBuilder.append('U');
                    break;
            }
        }

        return stringBuilder.toString();
    }

}
