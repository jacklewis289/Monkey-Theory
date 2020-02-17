package sample;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.ArrayList;

public class NeedleFinder {
    private StringBuilder needleAttemptBuilder;
    private ArrayList<Record> recordList;
    private Random random;
    private String needle;
    private String haystack;
    private int counter;
    private String probability;
    private String highest;
    private String lowest;
    private String average;

    public NeedleFinder(final String needle, final String haystack) {
        this.needleAttemptBuilder = new StringBuilder();
        this.random = new Random();
        this.needle = needle;
        this.haystack = haystack;
        this.counter = 0;
        this.recordList = new ArrayList<Record>();
    }

    public void needleFinder() {
        String needleAttempt = "";
        this.counter = 0;
        while (!this.needle.equals(needleAttempt)) {
            this.needleAttemptBuilder.delete(0, this.needle.length());
            ++this.counter;
            for (int i = 0; i < this.needle.length(); ++i) {
                this.needleAttemptBuilder.append(this.haystack.charAt(this.random.nextInt(this.haystack.length())));
            }
            needleAttempt = this.needleAttemptBuilder.toString();
        }
    }

    public void needleFinderMeasure(final int measureAmount) {
        int total = 0;
        int highest = 0;
        long lowest = 999999999999999999L;
        final double probability = Math.pow(this.haystack.length(), this.needle.length());
        this.setProbability(NumberFormat.getNumberInstance(Locale.UK).format(probability));
        for (int i = 0; i < measureAmount; ++i) {
            this.needleFinder();
            this.recordList.add(new Record(this.needle, i + 1, this.counter));
            total += this.counter;
            if (this.counter > highest) {
                highest = this.counter;
            }
            else if (this.counter < lowest) {
                lowest = this.counter;
            }
        }
        this.setHighest(NumberFormat.getNumberInstance(Locale.UK).format(highest));
        this.setLowest(NumberFormat.getNumberInstance(Locale.UK).format(lowest));
        this.setAverage(NumberFormat.getNumberInstance(Locale.UK).format(total / measureAmount));
    }

    public ArrayList<Record> getRecordList() {
        return this.recordList;
    }

    public String getProbability() {
        return this.probability;
    }

    public void setProbability(final String probability) {
        this.probability = probability;
    }

    public String getHighest() {
        return this.highest;
    }

    public void setHighest(final String highest) {
        this.highest = highest;
    }

    public String getLowest() {
        return this.lowest;
    }

    public void setLowest(final String lowest) {
        this.lowest = lowest;
    }

    public String getAverage() {
        return this.average;
    }

    public void setAverage(final String average) {
        this.average = average;
    }
}