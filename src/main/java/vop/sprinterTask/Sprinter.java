package vop.sprinterTask;

public class Sprinter implements Comparable<Sprinter> {

    private int raceNo;
    private int overAllPosition;
    private int genderPosition;
    private String country;
    private String officialTime;
    private String halfTime;

    public Sprinter(int raceNo, int overAllPosition, int genderPosition, String country, String officialTime, String halfTime) {
        this.raceNo = raceNo;
        this.overAllPosition = overAllPosition;
        this.genderPosition = genderPosition;
        this.country = country;
        this.officialTime = officialTime;
        this.halfTime = halfTime;
    }

    public int getRaceNo() {
        return raceNo;
    }

    public int getOverAllPosition() {
        return overAllPosition;
    }

    public int getGenderPosition() {
        return genderPosition;
    }

    public String getCountry() {
        return country;
    }

    public String getOfficialTime() {
        return officialTime;
    }

    public String getHalfTime() {
        return halfTime;
    }

    @Override
    public String toString() {
        return "raceNo= " + raceNo +
                ",    overAllPosition= " + overAllPosition +
                ",    genderPosition= " + genderPosition +
                ",    officialTime =" + officialTime +
                ",    halfTime= " + halfTime;
    }

    @Override
    public int compareTo(Sprinter o) {
        return Integer.compare(raceNo, o.getRaceNo());
    }
}
