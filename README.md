# Wintertodt Stats Overlay
A RuneLite plugin to track and display Wintertodt statistics in real time with an on-screen overlay. It monitors:
- Supply crate **Rewards** owed (handles multiple chat message variants and displays in green/red if increasing or decreasing).
- **XP per Hour** and **Total XP** gained during a session (suppressed until 10 seconds after startup or relogin).
- Automatic reset of XP and start time on relogin.
- Overlay text coloring: rewards value displays green when unchanged or increased, red when decreased.
- **XP per Hour** and **Total XP** gained during a session.
  - XP per hour calculation suppresses display until 10 seconds after startup or relogin.
  The overlay is configurable, allowing each stat to be toggled on or off, and large numbers are formatted with a ‘k’ suffix for readability.

## Change Log

### 2025-07-16

- Removed logs/potions tracking; streamlined to rewards and XP stats.
- Implemented XP tracking for all skills with per-hour calculation.
- Filtered chat message parsing to system messages only.
- Renamed and reordered overlay labels for clarity.
- Fixed reward counter to set values from “You’re now owed” chat messages.
- Renamed plugin to “Wintertodt Stats” and updated runelite-plugin.properties displayName.
- Updated XP per hour to suppress rates for first 10 seconds and reset on relogin (via GameStateChanged).
- Improved chat parsing: handled “You are owed X more rewards…”, “You're now owed X…”, and reset on “take as much as you're owed” via dialog detection.
- Added overlay text color: rewards value displays green when unchanged or increased, red when decreased.