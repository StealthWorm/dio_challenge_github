public class teste {
    public static void main(String[] args) throws Exception {
        int[] num = {1, 2, 2, 1};

        public int hasNValues( int[] a, int n){
            int[] nonRepeatedArr = new int[];

            if (a == null || n == 0) return 0;

            for (int i = 0; i < a.length; i++) {
                if (!Arrays.toString(nonRepeatedArr).contains(a[i])) {

                }
                sumEven += a[i];
         else
                sumOdd += a[i];
            }


            if (set.size() != n) {
                return 0;
            } else {
                return 1;
            }
        }

        System.out.println(hasNValues(num, 4));
    }
}
