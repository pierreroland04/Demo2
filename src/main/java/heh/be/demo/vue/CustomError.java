package heh.be.demo.vue;

public class CustomError {
    private final Number code;
    private final String name;

    public CustomError() {
        this.code = null;
        this.name = null;
    }

    public CustomError(String name, Number code) {
        this.name = name;
        this.code = code;
    }

    public Number getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
}
