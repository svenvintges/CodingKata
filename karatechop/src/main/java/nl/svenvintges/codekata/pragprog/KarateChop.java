package nl.svenvintges.codekata.pragprog;

import javax.xml.stream.events.StartDocument;
import java.lang.reflect.Array;
import java.util.Arrays;

public class KarateChop {

    public static int chop1(int tobefound, int[] list) {
        int position = -1;
        int lower = 0, upper = list.length;

        if (list.length == 0) {
            return -1;
        }

        if (list.length == 1) {
            if (list[0] == tobefound) {
                position = 0;
            } else {
                position = -1;
            }
        } else {
            int split = Math.round((upper - lower) / 2);
            if (list[split] == tobefound) {
                return split;
            } else if (list[split] > tobefound) {
                position = chop1(tobefound, getSubarray(0, split, list));
            } else {
                position = chop1(tobefound, getSubarray(split, list.length, list));
                if (position != -1) {
                    position += split;
                }
            }
        }
        return position;
    }

    private static int[] getSubarray(int startIndex, int endIndex, int[] array) {
        //off by one?
        int[] subarray = new int[endIndex - startIndex];
        int j = 0;
        for (int i = startIndex; i < endIndex; i++) {
            subarray[j] = array[i];
            j++;
        }
        return subarray;
    }

    public static int chop2(int tobefound, int[] list) {
        if (list.length == 0) {
            return -1;
        }
        if (list.length == 1) {
            if (list[0] == tobefound) {
                return 0;
            }
        } else {
            int lower = 0, upper = list.length - 1;
            while (upper > lower) {
                int split = Math.round((upper - lower) / 2);
                if (list[split + lower] == tobefound) {
                    return split + lower;
                } else if (tobefound > list[split + lower]) {
                    lower = split + lower + 1;
                } else {
                    upper = lower + split;
                }
            }
            if (list[upper] == tobefound) return upper;
        }
        return -1;
    }

}
