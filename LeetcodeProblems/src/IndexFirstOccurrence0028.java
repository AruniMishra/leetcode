public class IndexFirstOccurrence0028 {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(new IndexFirstOccurrence0028().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        int firstOccurenceIndex;
        firstOccurenceIndex = haystack.indexOf(needle);


        return firstOccurenceIndex;
    }
}
