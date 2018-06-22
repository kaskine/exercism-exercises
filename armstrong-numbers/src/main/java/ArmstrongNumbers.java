class ArmstrongNumbers {

    /**
     * Determines if a given number is an Armstrong Number
     * @param numberToCheck - The number to check
     * @return Returns true if the number given as an argument is an Armstrong Number
     */
    boolean isArmstrongNumber(int numberToCheck) {
        String str = Integer.toString(numberToCheck);
        int length = str.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += Math.pow(Integer.parseInt(Character.toString(str.charAt(i))), length);
        }

        return sum == numberToCheck;
    }

}
