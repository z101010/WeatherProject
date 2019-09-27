package Expleo.pageobjects;

public class AccuweatherPageObject {
    private int[] maxTemp = new int[5];
    private int[] minTemp = new int[5];

    public void addMaxTemp(int index, int maxTemp) {
        this.maxTemp[index] = maxTemp;
    }

    public void addMinTemp(int index, int minTemp) {
        this.minTemp[index] = minTemp;
    }

    public void printBoth() {
        for (int i=0; i<5; i++) {
            System.out.println("Max Temp: " + maxTemp[i] + " Min Temp: " + minTemp[i]);
        }
    }


}
