//2024
// Solves the problem of counting activities that at least a given number of people enjoy
public static int getNum(Map<String, Set<String>> map, int people) {
    HashMap<String, Integer> freqs = new HashMap<>();

    // Build the frequency map
    for (String name : map.keySet()) {
        for (String activity : map.get(name)) {
            if (freqs.containsKey(activity)) {
                freqs.put(activity, freqs.get(activity) + 1);
            } else {
                freqs.put(activity, 1);
            }
        }
    }

    // Check the number of activities that the target number of people
    // or more enjoy
    int result = 0;
    for (String activity : freqs.keySet()) {
        if (freqs.get(activity) >= people) {
            result++;
        }
    }

    return result;
}

//2023 Fall
// Solves the problem of tracking the win-loss record of teams and finding the best team by win percentage
public static Object[] getMap(String[] results) {
    TreeMap<String, int[]> map = new TreeMap<>();

    for (int i = 0; i < results.length; i += 2) {
        String name = results[i];
        String gameResult = results[i + 1];
        int[] record = map.get(name);

        if (record == null) {
            // First time seeing this team.
            record = new int[2];
            map.put(name, record);
        }

        // Win or Loss?
        if (gameResult.equals("W")) {
            record[0]++; // Increment wins
        } else {
            record[1]++; // Increment losses
        }
    }

    // Now find the best team.
    double bestWinPercentage = -1;
    String best = "";

    for (String teamName : map.keySet()) {
        int[] record = map.get(teamName);
        double winPercentage = 1.0 * record[0] / (record[0] + record[1]);

        if (winPercentage > bestWinPercentage) {
            bestWinPercentage = winPercentage;
            best = teamName;
        }
    }

    return new Object[] {map, best};
}

//2021 Fall
// Solves the problem of tracking author collaborations and counting collaborations between the first and last authors
public static int updateAuthors(Map<String, List<String>> map, String[] authors) {
    if (authors.length == 1) {
        return 0;
    }

    // Update collaborations for each author
    for (String author : authors) {
        List<String> collabs = map.get(author);
        if (collabs == null) {
            collabs = new LinkedList<>();
            map.put(author, collabs);
        }

        // Add collaborations for each other author
        for (String otherAuthor : authors) {
            if (!author.equals(otherAuthor)) {
                collabs.add(0, otherAuthor); // Add other authors to the front
            }
        } /
    }

    // Now do the second part: count collaborations between first and last author
    int result = 0;
    String first = authors[0];
    String last = authors[authors.length - 1];
    for (String name : map.get(first)) {
        if (name.equals(last)) {
            result++;
        }
    }

    return result;
}

//2023 Spring
// Solves the problem of calculating the highest similarity between pairs of books based on shared characters
public static double highestSimilarity(Map<String, Set<String>> books) {
    double max = 0;

    // Iterate through each pair of books
    for (String book1 : books.keySet()) {
        for (String book2 : books.keySet()) {
            if (!book1.equals(book2)) {  // Avoid comparing the same book with itself
                int sharedCharacters = 0;
                Set<String> myChars = books.get(book1);
                Set<String> otherChars = books.get(book2);

                // Count the number of shared characters between the two books
                for (String aCharacter : myChars) {
                    if (otherChars.contains(aCharacter)) {
                        sharedCharacters++;
                    }
                }

                // Calculate the similarity score
                double simScore = 1.0 * sharedCharacters 
                    / (myChars.size() + otherChars.size() - sharedCharacters);

                // Update max similarity score if needed
                if (simScore > max) {
                    max = simScore;
                }
            }
        }
    }

    return max;
}

//2022 Spring
// Solves the problem of indexing keywords and tracking their occurrences across pages in a book
public static TreeMap<String, ArrayList<Integer>> getIndex(String[][] book, String[] keyWords) {
    TreeMap<String, ArrayList<Integer>> index = new TreeMap<>();

    // We know all elements of keyWords are present in book, so add them upfront
    for (String word : keyWords) {
        index.put(word, new ArrayList<>());
    }

    int pageNum = 1;
    for (String[] page : book) {
        for (String word : page) {
            if (index.containsKey(word)) {
                ArrayList<Integer> pageNums = index.get(word);
                // Check if the page number is already in the list
                if (!pageNums.contains(pageNum)) {
                    pageNums.add(pageNum);
                }
            }
        }
        pageNum++;
    }
    
    return index;
}

//fall 2019
// Solves the problem of calculating the teams' win/loss difference and filtering teams by a cutoff value
public static Map<String, Integer> getTeams(String[] games, int cutoff) {
    HashMap<String, Integer> allTeams = new HashMap<>();
    
    for (int i = 0; i < games.length; i += 2) {
        String winner = games[i];
        update(allTeams, winner, 1);  // Update the winner
        String loser = games[i + 1];
        update(allTeams, loser, -1);   // Update the loser
    }
    
    TreeMap<String, Integer> result = new TreeMap<>();
    for (String key : allTeams.keySet()) {
        int diff = allTeams.get(key);
        if (diff >= cutoff) {
            result.put(key, diff);  // Only include teams that meet the cutoff
        }
    }
    
    return result;
}

private static void update(Map<String, Integer> map, String team, int add) {
    Integer diff = map.get(team);
    
    if (diff == null) {
        diff = new Integer(add);  // Initialize with 'add' if the team doesn't exist
    } else {
        diff = new Integer(diff + add);  // Otherwise, update the difference
    }
    
    map.put(team, diff);
}
