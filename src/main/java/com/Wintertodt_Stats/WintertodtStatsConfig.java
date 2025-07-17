package com.Wintertodt_Stats;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("wintertodtStats")
public interface WintertodtStatsConfig extends Config
{
    @ConfigItem(
        keyName = "showRewards",
        name = "Show Rewards",
        description = "Display crate rewards in overlay",
        position = 1
    )
    default boolean showRewards()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showLogsChopped",
        name = "Show Logs Chopped",
        description = "Display logs chopped in overlay",
        position = 2
    )
    default boolean showLogsChopped()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showLogsFletched",
        name = "Show Logs Fletched",
        description = "Display logs fletched in overlay",
        position = 3
    )
    default boolean showLogsFletched()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showPotionsMade",
        name = "Show Potions Made",
        description = "Display potions made in overlay",
        position = 4
    )
    default boolean showPotionsMade()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showXpPerHour",
        name = "Show XP per Hour",
        description = "Display Firemaking XP per hour",
        position = 5
    )
    default boolean showXpPerHour()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showTotalXp",
        name = "Show Total XP Gained",
        description = "Display total Firemaking XP gained",
        position = 6
    )
    default boolean showTotalXp()
    {
        return true;
    }

    @ConfigItem(
        keyName = "rewardPoints",
        name = "Stored Reward Points",
        description = "Persisted number of Wintertodt reward points",
        position = 7
    )
    default int rewardPoints()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "rewardPoints",
        name = "Stored Reward Points",
        description = "Persisted number of Wintertodt reward points",
        position = 7,
        hidden = true
    )
    void setRewardPoints(int rewardPoints);

    @ConfigItem(
        keyName = "totalXpGained",
        name = "Stored Total XP",
        description = "Persisted total Firemaking XP gained",
        position = 8
    )
    default int totalXpGained()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "totalXpGained",
        name = "Stored Total XP",
        description = "Persisted total Firemaking XP gained",
        position = 8,
        hidden = true
    )
    void setTotalXpGained(int totalXpGained);

    @ConfigItem(
        keyName = "roundsCompleted",
        name = "Stored Rounds Completed",
        description = "Persisted number of Wintertodt rounds completed",
        position = 9
    )
    default int roundsCompleted()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "roundsCompleted",
        name = "Stored Rounds Completed",
        description = "Persisted number of Wintertodt rounds completed",
        position = 9,
        hidden = true
    )
    void setRoundsCompleted(int roundsCompleted);

    @ConfigItem(
        keyName = "highestRoundScore",
        name = "Stored Highest Round Score",
        description = "Persisted highest score achieved in a Wintertodt round",
        position = 10
    )
    default int highestRoundScore()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "highestRoundScore",
        name = "Stored Highest Round Score",
        description = "Persisted highest score achieved in a Wintertodt round",
        position = 10,
        hidden = true
    )
    void setHighestRoundScore(int highestRoundScore);

    @ConfigItem(
        keyName = "logsChopped",
        name = "Stored Logs Chopped",
        description = "Persisted number of Wintertodt logs chopped",
        position = 11
    )
    default int logsChopped()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "logsChopped",
        name = "Stored Logs Chopped",
        description = "Persisted number of Wintertodt logs chopped",
        position = 11,
        hidden = true
    )
    void setLogsChopped(int logsChopped);

    @ConfigItem(
        keyName = "logsFletched",
        name = "Stored Logs Fletched",
        description = "Persisted number of Wintertodt logs fletched",
        position = 12
    )
    default int logsFletched()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "logsFletched",
        name = "Stored Logs Fletched",
        description = "Persisted number of Wintertodt logs fletched",
        position = 12,
        hidden = true
    )
    void setLogsFletched(int logsFletched);

    @ConfigItem(
        keyName = "potionsMade",
        name = "Stored Potions Made",
        description = "Persisted number of Wintertodt potions made",
        position = 13
    )
    default int potionsMade()
    {
        return 0;
    }

    @ConfigItem(
        keyName = "potionsMade",
        name = "Stored Potions Made",
        description = "Persisted number of Wintertodt potions made",
        position = 13,
        hidden = true
    )
    void setPotionsMade(int potionsMade);
}