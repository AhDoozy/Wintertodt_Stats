# 🎯 Wintertodt Stats Overlay

A **RuneLite** plugin that tracks and displays your Wintertodt session performance **in real time** via an on-screen overlay.

---

## Description

Stay on top of your Wintertodt grind with:

- 🔋 **Persistent Stats**:  
  - Stats saved across sessions.
  - Reward points, logs, and potions persisting through relogs  
- 💥 **Session Accuracy**:  
  - XP/hr calculation resets on relog to avoid spikes  
  - Baseline snapshot ensures only **session** gains are shown  
- 🛠️ **In-Chat Testing Command**:  
  - Type `::resetxp` in-game to zero your Total XP counter for testing  
- 🎨 **Clean Overlay**:  
  - Configurable toggles for each stat  
  - Formatted numbers with **k** (thousands) and **M** (millions) suffixes

---

## ⚙️ Configuration

Adjust your overlay via the RuneLite **Settings** tab:

| Setting                | Description                                    |
|------------------------|------------------------------------------------|
| Show Reward Points     | Display current owed supply crate rewards      |
| Show Total XP          | Display cumulative XP gained this session      |
| Show XP/hr             | Display rate of XP per hour                    |
| Show Logs Chopped      | Display number of logs chopped                 |
| Show Potions Made      | Display number of potions brewed               |
| Format Numbers (k/M)   | Toggle compact formatting for large numbers    |

---

## 🚀 Usage

- **Overlay**  
  - Displays live stats while you play Wintertodt.  
  - Automatically resets XP/hr baseline on relog.  
- **Testing Command**  
  - In chat, type `::resetxp` to reset your Total XP counter and baseline.  

---

## 📝 Change Log

#### 2025-07-17 • v1.2.0

- ✔️ **Feature**: Added `xpBaseline` to preserve session XP/hr accuracy on relog  
- ✔️ **Enhancement**: Number formatting updated to support **M** (millions) suffix  
- 🔧 **Fix**: Removed auto-save on login to prevent overwriting manual resets  
- 🛠️ **Dev**: Introduced `::resetxp` command for in-chat testing of XP reset  
  

#### 2025-07-16 • v1.1.0

- **Initial Release**  
- Session XP & XP/hr tracking (suppressed for first 10s)  
- Persistent reward points, logs chopped, potions made  
- Overlay toggles and basic `k` suffix formatting  

---

&copy; 2025 **AhDoozy** • [GitHub Repo](https://github.com/YourName/Wintertodt-Stats-Overlay)