package a.code5;

public class SillyLuckyNumber {
    private String breed;
    private int luckyNumber;
    private int threeDigit; // 0 to 999

    public SillyLuckyNumber(String s) {
        breed = s;
        for (int i = 0; i < breed.length(); i++)
            luckyNumber += breed.charAt(i);
        threeDigit = luckyNumber % 1000;
    }

    // getters
    public int getLuckyNumber() {
        return luckyNumber;
    }

    @Override
    public String toString() {
        return "<<" + breed + " " + luckyNumber + " " + threeDigit + ">>";
    }

    public void setBreed(String b) {
      this.breed = b;
    }

}
