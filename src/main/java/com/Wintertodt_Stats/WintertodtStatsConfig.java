package com.Wintertodt_Stats;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("wintertodtrewardcounter")
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
}