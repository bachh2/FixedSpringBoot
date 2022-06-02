package vn.techmaster.newapp.model;

public enum City {
    HANOI("Ha Noi"),
    HOCHIMINH("Ho Chi Minh"),
    HAIPHONG("Hai Phong"),
    DANANG("Da Nang");

    public final String label;

    private City(String label) {
        this.label = label;
    }

}
