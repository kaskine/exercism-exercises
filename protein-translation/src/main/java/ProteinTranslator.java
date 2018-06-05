import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {

        ArrayList<String> proteins = new ArrayList<>();
        ArrayList<String> codons = new ArrayList<>();

        for (int i = 0; i < rnaSequence.length(); i += 3) {
            codons.add(rnaSequence.substring(i, i + 3));
        }

        for (String codon: codons) {

            switch (codon) {
                case "AUG":
                    proteins.add("Methionine");
                    break;
                case "UUU":
                case "UUC":
                    proteins.add("Phenylalanine");
                    break;
                case "UUA":
                case "UUG":
                    proteins.add("Leucine");
                    break;
                case "UCU":
                case "UCC":
                case "UCA":
                case "UCG":
                    proteins.add("Serine");
                    break;
                case "UAU":
                case "UAC":
                    proteins.add("Tyrosine");
                    break;
                case "UGU":
                case "UGC":
                    proteins.add("Cysteine");
                    break;
                case "UGG":
                    proteins.add("Tryptophan");
                    break;
                case "UAA":
                case "UAG":
                case "UGA":
                    return proteins;
            }
        }

        return proteins;
    }
}