import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;



class LongestCompoundWord {


	// --------------------Custom Reader Class-----------------

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String giveMeFile) throws IOException {
            File file = new File("input.txt");
            br = new BufferedReader(new FileReader(file));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

// ---------------------------------------------------------


	// to create pair of anything.
    static class pair {
        String x;
        String y;
        pair(String x, String y) {
            this.x = x;
            this.y = y;
        }
    }


 
   
    public static void main(String[] args) throws java.lang.Exception {

        FastReader read = new FastReader("input.txt");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // int t = read.nextInt();
        // int cse = 1;
        // while (t-- != 0) {
           

        // }


        String line;
        

        // Creating a tree map in which strings are sorted by their length in decreasing order as we need the largest string.
        /*  For sorting in decreasing order by leangth "SortByLengthDec()" I have used custom comparator
            present outside main.
            O(logn) time complexity for creating this treemap.
        */ 
        TreeMap<String, Boolean> tree = new TreeMap<>(new SortByLengthDec());
        // Taking input till the end of the file and adding every string into a list.


        /* Creating an HashMap that will store either true value for every string that is given to us
         * usefull later when need to check the compound words.
         */
        HashMap<String, Boolean> map = new HashMap<>();
        while((line = read.nextLine()) != null) {
            tree.put(line, true);
            map.put(line, true);
        }

        // String words[] = new String[al.size()];
        // for(int i = 0;i<al.size();i++) words[i] = al.get(i);


        
        long startTime = System.currentTimeMillis();

        

        
        

        String longestCompoundWord = "";
        String secondLongestCompoundWord = "";

        int counter = 0;
        boolean gotLongest = false;
        boolean gotSecondLongest = false;
        // for(int i = 0;i<tree.size();i++) {
            for(Map.Entry<String, Boolean> entry : tree.entrySet()) {
            /* Check possible is the function that'll either return true or fasle based on if the 
             * string is compound or not.
             */
            String give = entry.getKey();
            if(checkPossible(give, map)) {
                // logic to get the longest compound word.
                if(!gotLongest) {
                    longestCompoundWord = give;
                    gotLongest = true;
                    continue;
                }
                // Logic to get the second Longest compound word.
                if(!gotSecondLongest) {
                    secondLongestCompoundWord = give;
                    gotSecondLongest = true;
                    break;
                } 
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Longest Coumpound Word is : " + longestCompoundWord);
        System.out.println("Second Longest Compound Word is: " + secondLongestCompoundWord);
        // Average Time required to solve main input file is : approx 80ms ::
        // Depends on the machine.
        System.out.println("Time required to complete the execution is: " + (endTime - startTime) + "ms");

        out.flush();
    }

   

    public static Boolean checkPossible(String s, HashMap<String, Boolean> map) {

        /* As later on we are using recurrsion for recursively iterating through the 
         * string so these two if statements can be considered as base conditions. to stop the recurrsion.
         */
       if(s.length() == 0) return false;

       if(s.length() == 1) {
            if(map.containsKey(s)) return true;

            return false;
        }

        /* So main Logic is to create pairs for every string, that only we are doing here 
         */
       for(int i = 1;i<s.length();i++) {
        // System.out.println(p.x + " " + p.y);
        /* In below logic we are checking if the first part of the pair(basically first part and second part of the string)
        that we created is present in the hashmap that we have meaning the word is present in the hashmap or not.
         * 
         * And if the first part is present in the hashmap then we take the rest of the string
         * and recursively to the same on that break it into pairs
         * we continue this till the string is either null or the size is 1.
         * 
         * If the second string is also present in the hashmap then we have found our compounded string
         * so in that case we simply return.
         */
        String firstPart = s.substring(0, i);
        String secondPart = s.substring(i);
        // pair p = new pair(first, second);
            if(map.containsKey(firstPart) == true) {
                if(map.containsKey(secondPart)) {
                    //System.out.println("coming");
                    return true;
                }
                // recursive function for the rest of the string second part of the string. or second value of pair.
                if(checkPossible(secondPart, map)) return true;
            }
       }

    return false;
    }

    

}

// Comparator to sort the strings by length in decreasing order.
class SortByLengthDec implements Comparator<String>
{
    public int compare(String a, String b)
    {
        return b.length() - a.length();
    }
}