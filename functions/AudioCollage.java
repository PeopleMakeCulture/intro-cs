public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        int j = 0;
        int i = a.length - 1;
        while (j < a.length) {
            result[j] = a[i];
            j++;
            i--;
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            result[a.length + j] = b[j];
        }
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] x, double[] y) {

        // assign shorter array to a, longer to b
        double[] a;
        double[] b;
        if (x.length <= y.length) {
            a = x;
            b = y;
        } else {
            a = y;
            b = x;
        }

        double[] result = new double[b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        for (int j = a.length; j < b.length; j++) {
            result[j] = b[j];
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    /// METHOD: If the existing sound has n samples, then the new sound has ⌊n/α⌋ samples for some constant α>0
    // with sample i of the new sound having the same amplitude as sample ⌊iα⌋ of the existing sound
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = a.length;
        double[] result = new double[(int) (n / alpha)];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[(int) (i * alpha)];
        }
        return result;
    }

    // Create an audio collage and plays it on standard audio
    // TODO: Fix operation exception
    public static void main(String[] args) {

        double[] reverseChimes = reverse(StdAudio.read("chimes.wav"));
        double[] reverseScratch = reverse(StdAudio.read("scratch.wav"));
        double[] scratchBeatbox = merge(StdAudio.read("scratch.wav"), StdAudio.read("beatbox.wav"));
        double[] pianoChimes = mix(chimes, piano);
        double[] ampSinger = amplify(StdAudio.read("singer.wav"), 1.2);
        double[] doubleTime = changeSpeed(StdAudio.read("beatbox.wav"), 1.2);
        double[] doubleTime3 = merge(merge(doubleTime, doubleTime), doubleTime);

        double[] mix = merge(merge(merge(scratchBeatbox, pianoChimes), mix(ampSinger, doubleTime3)), reverseScratch);

        StdAudio.save("mix.wav", mix);
        StdAudio.play("mix.wav");

    }
}
