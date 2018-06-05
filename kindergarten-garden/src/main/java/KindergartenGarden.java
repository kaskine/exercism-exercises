import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {

    private final String[] STUDENTS = {"Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"};

    private String garden;
    private String[] students;

    KindergartenGarden(String garden, String[] students) {
        this.garden = garden;
        this.students = students;
    }

    KindergartenGarden(String garden) {
        this.garden = garden;
        students = STUDENTS;

    }

    List<Plant> getPlantsOfStudent(String student) {

        ArrayList<Plant> plants = new ArrayList<>();
        ArrayList<Character> gardenRow1 = new ArrayList<>();
        ArrayList<Character> gardenRow2 = new ArrayList<>();

        boolean switchRow = false;
        for (int i = 0; i < garden.length(); i++) {
            if (garden.charAt(i) == '\n') {
                switchRow = true;
            }
            else {
                if (!switchRow) {
                    gardenRow1.add(garden.charAt(i));
                }
                else {
                    gardenRow2.add(garden.charAt(i));
                }
            }
        }

        int place = 0;
        boolean foundStudent = false;

        while (!foundStudent && place < students.length) {
            if(students[place].equalsIgnoreCase(student)) {
                foundStudent = true;
            }
            else {
                place++;
            }
        }

        int plantLocation = place * 2;


        plants.add(Plant.getPlant(gardenRow1.get(plantLocation)));
        plants.add(Plant.getPlant(gardenRow1.get(plantLocation + 1)));
        plants.add(Plant.getPlant(gardenRow2.get(plantLocation)));
        plants.add(Plant.getPlant(gardenRow2.get(plantLocation + 1)));

        return plants;
    }

}
