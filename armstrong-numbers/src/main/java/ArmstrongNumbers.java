class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

        String str = Integer.toString(numberToCheck);
        int length = str.length();
        int sum = 0;

        for(int i = 0; i < length; i++)
            sum += Math.pow(Integer.parseInt(Character.toString(str.charAt(i))), length);

        return sum == numberToCheck;
	}

}
