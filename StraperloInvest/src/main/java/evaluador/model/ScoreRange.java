package evaluador.model;

public class ScoreRange {
    private double min;
    private double max;
    private double score;

    public ScoreRange(double min, double max, double score) {
        this.min = min;
        this.max = max;
        this.score = score;
    }

    public boolean isInRange(double value) {
        return value >= min && value < max;
    }

    public double getScore() {
        return score;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Range[%.2f - %.2f) → %.2f", min, max, score);
    }
}
