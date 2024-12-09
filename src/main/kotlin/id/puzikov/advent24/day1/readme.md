# 🎄 Day 1: Historian Hysteria 🎄

## Puzzle Description

The Chief Historian is always present for the big Christmas sleigh launch, but nobody has seen him in months! Last anyone heard, he was visiting locations that are historically significant to the North Pole; a group of Senior Historians has asked you to accompany them as they check the places they think he was most likely to visit.

As each location is checked, they will mark it on their list with a star. They figure the Chief Historian must be in one of the first fifty places they'll look, so in order to save Christmas, you need to help them get fifty stars on their list before Santa takes off on December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

---

### Part One

The Elves discover an assortment of notes and lists of historically significant locations in the Chief Historian's office. These locations are listed not by name but by unique numbers called location IDs. However, the lists created by two groups of Senior Historians don't match.

Your task is to reconcile the two lists. To do this:

1. Pair up the smallest numbers from the left list with the smallest numbers from the right list, the second smallest from the left list with the second smallest from the right list, and so on.
2. For each pair, calculate the distance (absolute difference) between the two numbers.
3. Sum all the distances to find the total distance between the two lists.

**Example:**

| Left List | Right List |
|-----------|------------|
| 3         | 4          |
| 4         | 3          |
| 2         | 5          |
| 1         | 3          |
| 3         | 9          |
| 3         | 3          |

Pair the smallest numbers and calculate the distances:

- 1 (left) and 3 (right): Distance = 2
- 2 (left) and 3 (right): Distance = 1
- 3 (left) and 3 (right): Distance = 0
- 3 (left) and 4 (right): Distance = 1
- 3 (left) and 5 (right): Distance = 2
- 4 (left) and 9 (right): Distance = 5

**Total Distance = 2 + 1 + 0 + 1 + 2 + 5 = 11**

Your task is to calculate the total distance for the given input lists.

---

### Part Two

The analysis confirms the two lists of location IDs are very different. However, you notice that many location IDs appear in both lists. You decide to calculate a similarity score.

**Steps:**

1. For each number in the left list, count how many times it appears in the right list.
2. Multiply the number by its occurrence count in the right list.
3. Sum these values to calculate the total similarity score.

**Example:**

| Left List | Right List |
|-----------|------------|
| 3         | 4          |
| 4         | 3          |
| 2         | 5          |
| 1         | 3          |
| 3         | 9          |
| 3         | 3          |

- 3 appears 3 times in the right list. Score = 3 * 3 = 9
- 4 appears 1 time in the right list. Score = 4 * 1 = 4
- 2 appears 0 times in the right list. Score = 2 * 0 = 0
- 1 appears 0 times in the right list. Score = 1 * 0 = 0
- 3 appears 3 times in the right list. Score = 3 * 3 = 9
- 3 appears 3 times in the right list. Score = 3 * 3 = 9

**Total Similarity Score = 9 + 4 + 0 + 0 + 9 + 9 = 31**

Your task is to calculate the similarity score for the given input lists.