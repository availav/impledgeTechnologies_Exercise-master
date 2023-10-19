# impledgeTechnologies_Exercise-master

# impledgeTechnologies_Exercise

   <h1> <center>----RUNNING CODE----</center></h1>
   <hr>

<p>
   1. First make sure the java environment is setup in the system trying to compile the project.<br>
         * For that download java from oracle website and install it.
         * make sure all the environment variables are also set up. </p>
               OR
   <p>   * Download and install eclipse ide for java developers that'll take care of jdk by itself.
         
        
        
     
   2. Simply either fork the repository or download the zip file and open "LongestCompoundWord.java" in 
      eclipse.<br>
      NOTE: make sure the inpt file is also in the same folder as the .java file.</br></br>
      Now simply just run the code.


 <h1><center>WORKING OF CODE.</center> </h1>

  <hr>
<p> At the first after we take input from the file we put every string into a treemap (O(logn)) we pass our custom comparator to sort the treemap according to string length in descending order
   longest string in length will come at the first index and so on.</p>
<p>Now the main concept of the program is to divide the string into every two possible pair<br>
  - for ex: String = "ratcat" So it will be divided something like ->>   "r  atcat" -> "ra tcat" -> "rat cat"
  </p>

- <p>now we check if the first part of the pair is present in the hashmap of all the strings.
  if the first part of the pair is present then we recuresively to the same with the second part of the string

- - > " ra tcat" -> "t cat" -> "c at".... </p>

- <p>if we reach the end of the string and the rest of the parts are matched then we simply return true;

  if the part of the string doesn't match we discard those callbacks in the recursion stack and then simply again

  repeat the process by appending more character to the first string and then simply the process is repeated again.

- The total running time complexity of this code will be around -> O(logn \* m^2)
- - > where n = no. of inputs we have.
- - > m = average length of the string.

  ![image](https://user-images.githubusercontent.com/55589024/194065005-17dd5f25-1122-4852-9284-2c79153e5b7c.png)

- TODO: If I use trie and queue data structure as present on google then also time complexity will be nearly equal
  because searching for a word in trie will also be equal to O(m) where m is the average length of the string.
  and same goes for inserting some string into it.</p>
