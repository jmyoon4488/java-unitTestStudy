import java.util.*;

public class Computer {
    // 기본 숫자
    private ArrayList<Integer> baseNumbers;
    // 서로 다른 수로 이루어진 3자리 숫자
    private ArrayList<Integer> checkNumbers = new ArrayList<>();

    public void generateNumberSet() {
        initNumbers();
        while (checkNumbers.size() < BaseballGame.CHECK_NUMBER_SIZE) {
            int number = getNumberFromBase(getRandomIndex());
            if (checkNumbers.contains(number)) continue;
            checkNumbers.add(number);
        }
    }

    public void initNumbers() {
        baseNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        checkNumbers = new ArrayList<>();
    }

    public int getRandomIndex() {
        return (int) (Math.random() * (baseNumbers.size() - 1));
    }

    public int getNumberFromBase(int index) {
        if (index >= baseNumbers.size()) return BaseballGame.INPUT_ERROR;
        int ret = baseNumbers.get(index);
        baseNumbers.remove(index);
        return ret;
    }

    public ArrayList<Integer> getCheckNumbers() {
        return checkNumbers;
    }

    public ArrayList<Integer> getBaseNumbers() {
        return baseNumbers;
    }

    public void setBaseNumbers(ArrayList<Integer> baseNumbers) {
        this.baseNumbers = baseNumbers;
    }

    public void setCheckNumbers(ArrayList<Integer> checkNumbers) {
        this.checkNumbers = checkNumbers;
    }
}
