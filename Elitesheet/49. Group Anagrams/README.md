<h2><a href="https://leetcode.com/problems/group-anagrams">49. Group Anagrams</a></h2>

<p>Given an array of strings <code>strs</code>, group the <span data-keyword="anagram" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class="">anagrams</button></span> together. You can return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["eat","tea","tan","ate","nat","bat"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["bat"],["nat","tan"],["ate","eat","tea"]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is no string in strs that can be rearranged to form <code>"bat"</code>.</li>
	<li>The strings <code>"nat"</code> and <code>"tan"</code> are anagrams as they can be rearranged to form each other.</li>
	<li>The strings <code>"ate"</code>, <code>"eat"</code>, and <code>"tea"</code> are anagrams as they can be rearranged to form each other.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = [""]</span></p>

<p><strong>Output:</strong> <span class="example-io">[[""]]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["a"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["a"]]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>


---

# 🛍️ Group-Anagrams | Explained

## Approach 1 (Using Character Frequency Signature)
### Intuition
Imagine you have a set of words, and you want to group them based on whether they contain the same letters, regardless of the order of these letters. To do this, you can think of creating a unique signature for each word that captures the frequency of each letter it contains. This way, words that are anagrams of each other will have the same signature. The intuition here is similar to creating a fingerprint for each word, where the fingerprint (or signature) represents the frequency distribution of the letters in that word.

### Approach
The approach involves two main steps:
1. **Generate a signature for each word**: By counting the frequency of each letter in the word, a unique signature can be created.
2. **Group words by their signature**: Words with the same signature are anagrams of each other and thus can be grouped together.

### Detailed Code Analysis
Let's dive into the code provided to see how this approach is implemented:
```java
public String getSignature(String s) {
    int[] count = new int[26]; // Create an array to hold the count of each letter
    for (char c : s.toCharArray()) { // Iterate over each character in the string
        count[c - 'a']++; // Increment the count for the corresponding letter
    }

    StringBuilder sb = new StringBuilder(); // Create a StringBuilder to build the signature
    for (int i = 0; i < 26; i++) { // Iterate over each possible letter
        if (count[i] != 0) { // If the count for this letter is not zero
            sb.append((char) ('a' + i)).append(count[i]); // Append the letter and its count to the signature
        }
    }
    return sb.toString(); // Return the signature as a string
}

public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>(); // List to hold the final grouped anagrams
    Map<String, List<String>> groups = new HashMap<>(); // Map to group words by their signature

    for (String s : strs) { // Iterate over each word in the input array
        groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s); // Add the word to its corresponding group
    }

    result.addAll(groups.values()); // Add all groups to the result list
    return result; // Return the list of grouped anagrams
}
```
In this code:
- `getSignature(String s)` generates a unique signature for a given word `s` by counting the frequency of each letter.
- The `groupAnagrams(String[] strs)` method uses these signatures to group the words. It iterates over each word, generates its signature using `getSignature(s)`, and then adds the word to a group in the `groups` map where the key is the signature and the value is a list of words with that signature.
- The `groups` map automatically handles the grouping since words with the same signature (i.e., anagrams) will have the same key and thus be added to the same list.
- Finally, the `result` list is populated with the grouped anagrams by adding all the lists from the `groups` map to it.

### Code
```java
public String getSignature(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
        if (count[i] != 0) {
            sb.append((char) ('a' + i)).append(count[i]);
        }
    }
    return sb.toString();
}

public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> groups = new HashMap<>();

    for (String s : strs) {
        groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
    }

    result.addAll(groups.values());
    return result;
}
```

### Complexity
- Time: The time complexity is O(NM), where N is the number of strings and M is the maximum length of a string. This is because for each string, we are generating its signature which takes O(M) time, and we are doing this for N strings. The grouping operation itself is O(1) on average due to the use of a HashMap.
- Space: The space complexity is also O(NM), as we are storing all the characters of all the strings in the groups map. The `count` array and the `StringBuilder` used to create the signature take constant space, but the space used by the `result` list and the `groups` map is proportional to the total number of characters in all the strings.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle case sensitivity and non-alphabet characters?**
   - To handle case sensitivity, you could convert all strings to either lowercase or uppercase before processing. For non-alphabet characters, you could either ignore them or treat them as part of the signature, depending on the requirements.

2. **Can you optimize the space complexity of this solution?**
   - Yes, instead of storing all groups in the `result` list at the end, you could directly return the values of the `groups` map. This way, you avoid the extra space needed for the `result` list.