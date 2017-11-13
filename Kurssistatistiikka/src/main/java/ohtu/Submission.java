package ohtu;

import java.util.ArrayList;

public class Submission {

    private int week;
    private int hours;
    private ArrayList<String> exercises;

//    public void setWeek(int week) {
//        this.week = week;
//    }
//
//    public void setHours(int hours) {
//        this.hours = hours;
//    }
    public int getWeek() {
        return this.week;
    }

    public int getHours() {
        return this.hours;
    }

    public int getDoneExercisesAmount() {
        return this.exercises.size();
    }

    public String getDoneExercises() {
        String apu = "";
        for (int i = 0; i < this.exercises.size(); i++) {
            apu += this.exercises.get(i) + " ";
        }
        return apu;
    }

    @Override
    public String toString() {
        return " viikko " + this.getWeek() + ": tehtyjä tehtäviä yhteensä: " + this.getDoneExercisesAmount() + ", aikaa kului " + this.getHours() + " tuntia, tehdyt tehtävät: " + this.getDoneExercises();
    }

    public String attachMaxTasksAvailablePerWeek(String maxTextPerViikko) {
        return " viikko " + this.getWeek() + ": tehtyjä tehtäviä yhteensä: " + this.getDoneExercisesAmount() + " (maksimi " + maxTextPerViikko + "), aikaa kului " + this.getHours() + " tuntia, tehdyt tehtävät: " + this.getDoneExercises();
    }

}
