// TODO: Figure out how to get barchart 
// Specs: https://coursera.cs.princeton.edu/introcs/assignments/barchart/specification.php
/*
public class BarChart {

    // Creates a bar chart with the given title, x-axis label, and data source.
    public BarChart(String title, String xAxisLabel, String dataSource)

    // Sets the caption of this bar chart.
    public void setCaption(String caption)

    // Adds a bar (name, value, category) to this bar chart.
    public void add(String name, int value, String category)

    // Remove all of the bars from this bar chart.
    public void reset() 

    // Draws this bar chart to standard draw.
    public void draw() 
}
*/

public class BarChartRacer {
    // The program takes two command-line arguments: the name of a bar-chart-racer file and 
    // an integer k that specifies how many bars to display in each bar chart
    public static void main(String[] args) {
        // create the bar chart
        String title = "The 5 most populous cities";
        String xAxis = "Population (thousands)";
        String source = "Source: United Nations";
        BarChart chart = new BarChart(title, xAxis, source);
        chart.setCaption("2018");

        // add the bars to the bar chart
        chart.add("Tokyo",       38194, "East Asia");
        chart.add("Delhi",       27890, "South Asia");
        chart.add("Shanghai",    25779, "East Asia");
        chart.add("Beijing",     22674, "East Asia");
        chart.add("Mumbai",      22120, "South India");
        // Bar beijing = new Bar("Beijing",     22674, "East Asia");

        // draw the bar chart
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        chart.draw();
        StdDraw.show();

    }
}