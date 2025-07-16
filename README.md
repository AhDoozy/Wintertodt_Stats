# Wintertodt Reward Counter
A RuneLite plugin to track and display Wintertodt statistics in real time with an on-screen overlay. It monitors:
- Supply crate **Rewards** owed.
- **Logs Chopped** (Bruma roots).
- **Logs Fletched** (Bruma kindling).
- **Potions Made** (Warm potions).
- **Completed Rounds** (detected via compass reset).
- **Highest Round Score** (maximum compass points).
- **Points per Hour** (crate rewards rate).
- **XP per Hour** and **Total XP** gained during a session.
  The overlay is configurable, allowing each stat to be toggled on or off, and large numbers are formatted with a ‘k’ suffix for readability.

## Change Log

### 2025-07-16

- Added compass-based point tracking and round completion detection.
- Implemented XP tracking for all skills with per-hour calculation.
- Formatted large numbers with ‘k’ notation.
- Filtered chat message parsing to system messages only.
- Renamed and reordered overlay labels for clarity.
- Fixed reward counter to set values from “You’re now owed” chat messages.