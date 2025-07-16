package com.Wintertodt_Stats;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.InventoryID;
import net.runelite.api.events.GameTick;
import net.runelite.api.ChatMessageType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@PluginDescriptor(
    name = "Wintertodt Stats",
    description = "Tracks Wintertodt statistics and displays an on-screen overlay",
    tags = {"wintertodt", "rewards", "tracker"}
)
public class WintertodtStatsPlugin extends Plugin
{
    private static final int WINTERTODT_REWARD_WIDGET_GROUP_ID = 396;
    private static final int BRUMA_ROOT = 20695;
    private static final int BRUMA_KINDLING = 20696;
    private static final int WARM_POTION = 20699;

    @Inject private Client client;
    @Inject private OverlayManager overlayManager;
    @Inject private WintertodtStatsOverlay overlay;
    @Inject private WintertodtStatsConfig config;

    private int rewardPoints, logsChopped, logsFletched, potionsMade;
    private int lastRootCount, lastKindlingCount, lastPotionCount;
    private Instant startTime;
    private Map<Skill, Integer> lastXpMap;
    private int totalXpGained;
    private int lastRewardPoints;
    private static final Pattern IncrementalPattern = Pattern.compile("You are owed (\\d+) more rewards from the cart\\.");
    private static final Pattern OwedPattern = Pattern.compile("You're now owed (\\d+) rewards\\.");
    private boolean sessionStarted = false;

    @Override
    protected void startUp()
    {
        startTime = Instant.now();
        lastXpMap = new EnumMap<>(Skill.class);
        for (Skill skill : Skill.values())
        {
            lastXpMap.put(skill, client.getSkillExperience(skill));
        }
        rewardPoints = logsChopped = logsFletched = potionsMade = 0;
        lastRootCount = lastKindlingCount = lastPotionCount = 0;
        totalXpGained = 0;
        lastRewardPoints = 0;
        overlayManager.add(overlay);
        log.debug("Wintertodt Reward Counter started.");
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
        log.debug("Wintertodt Reward Counter stopped.");
    }

    @Provides
    WintertodtStatsConfig provideConfig(ConfigManager manager)
    {
        return manager.getConfig(WintertodtStatsConfig.class);
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
            return;

        var items = event.getItemContainer().getItems();
        int roots = 0, kindling = 0, potions = 0;
        for (var item : items)
        {
            if (item == null) continue;
            switch (item.getId())
            {
                case BRUMA_ROOT:
                    roots += item.getQuantity();
                    break;
                case BRUMA_KINDLING:
                    kindling += item.getQuantity();
                    break;
                case WARM_POTION:
                    potions += item.getQuantity();
                    break;
                default:
                    break;
            }
        }

        if (roots > lastRootCount) logsChopped += roots - lastRootCount;
        if (kindling > lastKindlingCount) logsFletched += kindling - lastKindlingCount;
        if (potions > lastPotionCount) potionsMade += potions - lastPotionCount;

        lastRootCount = roots;
        lastKindlingCount = kindling;
        lastPotionCount = potions;
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        if (event.getType() != ChatMessageType.GAMEMESSAGE)
        {
            return;
        }

        String msg = event.getMessage();

        Matcher owed = OwedPattern.matcher(msg);
        if (owed.find())
        {
            int val = Integer.parseInt(owed.group(1));
            rewardPoints = val;
            lastRewardPoints = val;
            return;
        }
        Matcher incr = IncrementalPattern.matcher(msg);
        if (incr.find())
        {
            int val = Integer.parseInt(incr.group(1));
            rewardPoints = val;
            lastRewardPoints = val;
            return;
        }

        if (msg.equals("You think you've taken as much as you're owed from the reward cart."))
        {
            log.debug("Rewards claimed – resetting stats.");
            resetCounters();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        // Initialize session
        if (!sessionStarted)
        {
            sessionStarted = true;
            startTime = Instant.now();
            lastXpMap = new EnumMap<>(Skill.class);
            for (Skill skill : Skill.values())
            {
                lastXpMap.put(skill, client.getSkillExperience(skill));
            }
            return;
        }

        // XP tracking for all skills
        for (Skill skill : Skill.values())
        {
            int xp = client.getSkillExperience(skill);
            int prev = lastXpMap.getOrDefault(skill, xp);
            if (xp > prev)
            {
                totalXpGained += xp - prev;
            }
            lastXpMap.put(skill, xp);
        }
    }

    public int getRewardPoints() { return rewardPoints; }
    public int getLogsChopped() { return logsChopped; }
    public int getLogsFletched() { return logsFletched; }
    public int getPotionsMade() { return potionsMade; }
    public int getTotalXpGained() { return totalXpGained; }
    public int getXpPerHour()
    {
        long sec = Duration.between(startTime, Instant.now()).getSeconds();
        return sec > 0 ? (int)(totalXpGained * 3600L / sec) : 0;
    }

    private void resetCounters()
    {
        rewardPoints = logsChopped = logsFletched = potionsMade = 0;
        lastRootCount = lastKindlingCount = lastPotionCount = 0;
        totalXpGained = 0;
        lastRewardPoints = 0;
    }
}
