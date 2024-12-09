# 🎄 Day 2: Red-Nosed Reports

## 🦌 Part One

The Red-Nosed Reindeer nuclear fusion/fission plant engineers need help analyzing unusual data from their reactor. The data consists of reports, with one report per line. Each report contains a list of numbers called "levels" separated by spaces.

📝 Example input:
```
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
```

✅ A report is considered safe if it meets both criteria:
1. The levels are either all increasing or all decreasing
2. Any two adjacent levels differ by at least one and at most three

🔍 Analysis of the example reports:
* `7 6 4 2 1`: ✨ Safe (all decreasing by 1 or 2)
* `1 2 7 8 9`: ❌ Unsafe (`2 7` increases by 5)
* `9 7 6 2 1`: ❌ Unsafe (`6 2` decreases by 4)
* `1 3 2 4 5`: ❌ Unsafe (`1 3` increases but `3 2` decreases)
* `8 6 4 4 1`: ❌ Unsafe (`4 4` neither increases nor decreases)
* `1 3 6 7 9`: ✨ Safe (all increasing by 1, 2, or 3)

**🎯 Task**: Count how many reports are safe.

## ⚡ Part Two

The Problem Dampener, a reactor-mounted module, allows the reactor safety systems to tolerate a single bad level in what would otherwise be a safe report. If removing a single level from an unsafe report would make it safe, the report now counts as safe.

🔍 Updated analysis with Problem Dampener:
* `7 6 4 2 1`: ✨ Safe (no removal needed)
* `1 2 7 8 9`: ❌ Unsafe (still unsafe with any level removed)
* `9 7 6 2 1`: ❌ Unsafe (still unsafe with any level removed)
* `1 3 2 4 5`: ✨ Safe (removing `3` makes it safe)
* `8 6 4 4 1`: ✨ Safe (removing one `4` makes it safe)
* `1 3 6 7 9`: ✨ Safe (no removal needed)

**🎯 Task**: Count how many reports are safe when the Problem Dampener is active.