public class p0028_IndexFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(new p0028_IndexFirstOccurrence().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        int firstOccurenceIndex;
        firstOccurenceIndex = haystack.indexOf(needle);


        return firstOccurenceIndex;
    }
}
