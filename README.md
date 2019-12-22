# PyramidWord

This code is to solve the following problem.
Please write a web service that takes in a string and returns a boolean to indicate whether a word is a pyramid word. A word is a ‘pyramid’ word if you can arrange the letters in increasing frequency, starting with 1 and continuing without gaps and without duplicates. Examples: banana is a pyramid word because you have 1 'b', 2 'n's, and 3 'a's. bandana is not a pyramid word because you have 1 'b' and 1 'd'.

The time complexity of this code is O(n), where n is the length of the input word. The code first check if the length of the word is valid or not, which means whether the length equals 1+2+...+k. And then calculate k. The time complexity in this step is O(1). Second, use a hash map to save the frequency of each character. While calculating the frequency, we can check whether it is greater than k. If yes, return false. The time complexity of this step is O(n). Third, check whether the number of unique character equals to k. If not, return false. The time complexity of this step is O(1). Fourth, check whether each frequency only appears once. If there is a frequency appears more than once, return false. The time complexity of this step is O(k). Finally, return true. Therefore, the total time complexity is O(n).

To run the code, please follow the following steps:
1. javac PyramidWord.java
2. java -cp ./ PyramidWord <inputWord>
For example: java -cp ./ PyramidWord "abb"


