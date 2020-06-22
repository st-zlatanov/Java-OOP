public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }


    private void setLength(double length) {
        validateValue(length, "Length");
        this.length = length;
    }


    private void setWidth(double width) {
        validateValue(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateValue(height, "Height");
        this.height = height;
    }

    private void validateValue(double value, String dimension) {
        if (value <= 0) {
            throw new IllegalArgumentException(dimension + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea(){
        return 2 * this.length * this.width
                + 2 * this.length * this.height
                + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea(){
        return 2 * this.length * this.height +
                2 * this.width * this.height;
    }

    public double calculateVolume(){
        return this.width*this.height*this.length;
    }
}
