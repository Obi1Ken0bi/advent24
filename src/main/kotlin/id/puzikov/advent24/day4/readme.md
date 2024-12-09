# 🎄 Day 4: Ceres Search

## 🔍 Part One

At the Ceres monitoring station, a small Elf needs help with her word search puzzle. The task is to find all occurrences of the word `XMAS`.

📋 Word Search Rules:
* Words can be:
    * Horizontal
    * Vertical
    * Diagonal
    * Backwards
    * Overlapping other words

🎯 Example Pattern (with dots for irrelevant letters):
```
..X...
.SAMX.
.A..A.
XMAS.S
.X....
```

✨ Full Example Grid:
```
MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX
```

🔎 Same grid with non-XMAS letters replaced by dots:
```
....XXMAS.
.SAMXMS...
...S..A...
..A.A.MS.X
XMASAMX.MM
X.....XA.A
S.S.S.S.SS
.A.A.A.A.A
..M.M.M.MM
.X.X.XMASX
```

In this example, `XMAS` appears `18` times.

**🎯 Task**: Find the total number of times `XMAS` appears in the word search.

## ⭐ Part Two

Plot twist! It's actually an `X-MAS` puzzle where you need to find two `MAS` patterns forming an `X` shape.

📋 X-MAS Pattern Rules:
* Must form an X shape
* Each `MAS` can be forwards or backwards
* Both `MAS` sequences must share the `A` in the middle

🎯 Basic X-MAS Pattern:
```
M.S
.A.
M.S
```

✨ Previous Example Grid (showing only X-MAS patterns):
```
.M.S......
..A..MSMS.
.M.S.MAA..
..A.ASMSM.
.M.S.M....
..........
S.S.S.S.S.
.A.A.A.A..
M.M.M.M.M.
..........
```

In this example, `X-MAS` appears `9` times.

**🎯 Task**: Find the total number of `X-MAS` patterns in the word search grid.