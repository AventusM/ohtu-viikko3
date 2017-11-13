package ohtu;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GeneralCourseInfo {

    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("term")
    private String term;

    @SerializedName("url")
    private String url;

    @SerializedName("week")
    private Integer week;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("__v")
    private String v;

    @SerializedName("exercises")
    private ArrayList<String> exercises;

    public String getMaxPerWeek(int week) {
        return this.exercises.get(week - 1);
    }

}
