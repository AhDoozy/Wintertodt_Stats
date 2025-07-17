package com.Wintertodt_Stats;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;

public class WintertodtStatsOverlay extends Overlay
{
    private final Client client;
    private final WintertodtStatsPlugin plugin;
    private final WintertodtStatsConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public WintertodtStatsOverlay(Client client, WintertodtStatsPlugin plugin, WintertodtStatsConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.HIGH);
    }

    /**
     * Format large numbers into 'k' and 'M' notation.
     */
    private static String formatNumber(int value)
    {
        if (value >= 1_000_000)
        {
            return (value / 1_000_000) + "M";
        }
        if (value >= 1_000)
        {
            return (value / 1_000) + "k";
        }
        return Integer.toString(value);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();

        if (config.showRewards())
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Rewards")
                .right(String.valueOf(plugin.getRewardPoints()))
                .build());

        if (config.showLogsChopped())
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Logs Chopped")
                .right(String.valueOf(plugin.getLogsChopped()))
                .build());

        if (config.showLogsFletched())
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Logs Fletched")
                .right(String.valueOf(plugin.getLogsFletched()))
                .build());

        if (config.showPotionsMade())
            panelComponent.getChildren().add(LineComponent.builder()
                .left("Potions Made")
                .right(String.valueOf(plugin.getPotionsMade()))
                .build());

        if (config.showXpPerHour())
        {
            panelComponent.getChildren().add(
                LineComponent.builder()
                    .left("XP/hr")
                    .right(formatNumber(plugin.getXpPerHour()))
                    .build()
            );
        }

        if (config.showTotalXp())
        {
            panelComponent.getChildren().add(
                LineComponent.builder()
                    .left("Total XP")
                    .right(formatNumber(plugin.getTotalXpGained()))
                    .build()
            );
        }

        return panelComponent.render(graphics);
    }
}
