import java.awt.Color;
import java.util.Arrays;

public class KernelFilter {
    
    // ensures color value is btwn 0-255
    private static int clamp_color(int raw_color) {
        int clamped_color = raw_color;
        if (clamped_color > 255) clamped_color = 255;
        else if (clamped_color < 0) clamped_color = 0;
        return clamped_color;
    }

    // init 3d source color array
    private static int[][][] get_source_colors(Picture picture, int width, int height) {
        int[][][] source_colors = new int[width][height][3];

        for (int i = 0; i < width; i++) { // i = column
            for (int j = 0; j < height; j++) { // j = row
                Color color = picture.get(i, j);
                source_colors[i][j][0] = color.getRed();
                source_colors[i][j][1] = color.getGreen();
                source_colors[i][j][2] = color.getBlue();
            }
        }
        return source_colors;
    }

    // get color array after applying filter
    private static int[][][] get_target_colors(int[][][] source_colors, int width, int height, int[][] filter, float blur) {
        // init return array
        int[][][] target_colors = new int[width][height][3];
        // offset is the distance from edge of filter to center pixel
        int offset = (int) Math.floor(filter.length / 2);

        // for each pixel
        for (int i = 0; i < width; i++) { // i = column
            for (int j = 0; j < height; j++) { // j = row
                for (int k = 0; k < 3; k++) { // k = color channel

                    // apply the filter
                    int sum = 0;
                    for (int a = 0; a < filter.length; a++) {
                        for (int b = 0; b < filter[0].length; b++) {

                            // wrapping
                            int source_x = i + a - offset;
                            int source_y = j + b - offset;

                            if (source_x < 0) source_x += width;
                            else if (source_x >= width) source_x -= width;

                            if (source_y < 0) source_y += height;
                            else if (source_y >= height) source_y -= height;

                            sum += filter[a][b] * source_colors[source_x][source_y][k];
                        }
                    }
                    // apply optional blur and clamping
                    int raw_color = Math.round(sum * blur);
                    target_colors[i][j][k] = clamp_color(raw_color);
                }
            }
        }
        return target_colors;
    }

    // translate target colors array into picture
    private static Picture get_picture(int width, int height, int[][][] target_colors) {
        Picture picture = new Picture(width, height);
        for (int i = 0; i < width; i++) { // i = column
            for (int j = 0; j < height; j++) { // j = row
                Color target_color = new Color(target_colors[i][j][0], target_colors[i][j][1], target_colors[i][j][2]);
                picture.set(i, j, target_color);
            }
        }
        return picture;
    }

    // overloaded apply filter; 3 args => blur
    private static Picture apply_filter(Picture picture, int[][] filter, float blur) {
        int height = picture.height();
        int width = picture.width();

        int[][][] source_colors = get_source_colors(picture, width, height);
        int[][][] target_colors = get_target_colors(source_colors, width, height, filter, blur);

        return get_picture(width, height, target_colors);
    }

    // overloaded apply filter; 2 args => no blur
    private static Picture apply_filter(Picture picture, int[][] filter) {
        int height = picture.height();
        int width = picture.width();

        int[][][] source_colors = get_source_colors(picture, width, height);
        int[][][] target_colors = get_target_colors(source_colors, width, height, filter, 1f);

        return get_picture(width, height, target_colors);
    }


    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        int[][] identity_filter = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        return apply_filter(picture, identity_filter);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int[][] gaussian_filter = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
        float gaussian_blur = (1f / 16f); // cast ints for float division
        return apply_filter(picture, gaussian_filter, gaussian_blur);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] sharpen_filter = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        return apply_filter(picture, sharpen_filter);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] laplacian_filter = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        return apply_filter(picture, laplacian_filter);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] emboss_filter = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        return apply_filter(picture, emboss_filter);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int[][] motion_blur_filter = {{1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        float motion_blur = (1f / 9f); // cast ints for float division
        return apply_filter(picture, motion_blur_filter, motion_blur);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        // should take one arg - the input picture name
        String filename = args[0];
        Picture picture = new Picture(filename);

        // display identity filter
        Picture identity = new Picture(identity(picture));
        identity.save("identity_" + filename);
        identity.show();

        // display sharpen filter
        Picture sharpen = new Picture(sharpen(picture));
        sharpen.save("sharpen_" + filename);
        sharpen.show();

        // display laplacian filter
        Picture laplacian = new Picture(laplacian(picture));
        laplacian.save("laplacian_" + filename);
        laplacian.show();

        // display emboss filter
        Picture emboss = new Picture(emboss(picture));
        emboss.save("emboss_" + filename);
        emboss.show();

        // display gaussian filter
        Picture gaussian = new Picture(gaussian(picture));
        gaussian.save("gaussian_" + filename);
        gaussian.show();

        // display motionBlur filter
        Picture motionBlur = new Picture(motionBlur(picture));
        motionBlur.save("motionBlur_" + filename);
        motionBlur.show();
    }

}
